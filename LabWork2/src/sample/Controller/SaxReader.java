package sample.Controller;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import sample.Model.FootballPlayer;

import java.util.ArrayList;

public class SaxReader extends DefaultHandler {
    ArrayList<FootballPlayer> footballPlayers=new ArrayList<>();
    String element="";
    FootballPlayer footballPlayer=new FootballPlayer();
    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element=qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        element="";
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if(element.equals("name")){
            FootballPlayer tmp =new FootballPlayer();
            footballPlayer=tmp;
            footballPlayer.setName(new String(ch, start, length));
        }

        if (element.equals("dateBirthday"))
                footballPlayer.setDateBirthday(new String(ch, start, length));
            if (element.equals("town"))
                footballPlayer.setTown(new String(ch, start, length));
            if (element.equals("team"))
                footballPlayer.setTeam(new String(ch, start, length));
            if (element.equals("cast"))
                footballPlayer.setCast(new String(ch, start, length));
            if (element.equals("position")) {
                footballPlayer.setPosition(new String(ch, start, length));
                footballPlayers.add(footballPlayer);
            }

    }
    public ArrayList<FootballPlayer> getFootballPlayers(){
        return footballPlayers;
    }
}
