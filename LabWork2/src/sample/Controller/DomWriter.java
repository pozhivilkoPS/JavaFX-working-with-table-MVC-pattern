package sample.Controller;




import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.io.File;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Element;
import org.w3c.dom.Node;
import sample.Model.FootballPlayer;


public class DomWriter {
    public void write(String path, ArrayList<FootballPlayer> footballPlayers) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElementNS("","footballers");
            doc.appendChild(rootElement);
            for(Integer i=0;i<footballPlayers.size();i++){
                rootElement.appendChild(getFootballPlayer(doc,footballPlayers.get(i)));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            
            StreamResult file = new StreamResult(new File(path));

            //записываем данные
            transformer.transform(source, file);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // метод для создания нового узла XML-файла
    private static Node getFootballPlayer(Document doc, FootballPlayer player) {
        Element footballPlayer = doc.createElement("footballPlayer");
        footballPlayer.appendChild(getFootballPlayerElements(doc, "name", player.getName()));
        footballPlayer.appendChild(getFootballPlayerElements(doc, "dateBirthday", player.getDateBirthday()));
        footballPlayer.appendChild(getFootballPlayerElements(doc, "team", player.getTeam()));
        footballPlayer.appendChild(getFootballPlayerElements(doc, "town", player.getTown()));
        footballPlayer.appendChild(getFootballPlayerElements(doc, "cast", player.getCast()));
        footballPlayer.appendChild(getFootballPlayerElements(doc, "position", player.getPosition()));
        return footballPlayer;
    }


    // утилитный метод для создание нового узла XML-файла
    private static Node getFootballPlayerElements(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}

