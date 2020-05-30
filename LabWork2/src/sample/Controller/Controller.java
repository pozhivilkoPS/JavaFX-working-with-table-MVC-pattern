package sample.Controller;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.xml.sax.SAXException;
import sample.Model.FootballPlayer;
import sample.View.Table;
import sample.View.ViewAddNew;
import sample.View.ViewDeleteDialog;
import sample.View.ViewFindDialog;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    public Controller(Table mTable){
        mainTable=mTable;

    }

    Table mainTable;

   public EventHandler addNew=event -> {
        if (ViewAddNew.isShowing==false){
            ViewAddNew.isShowing=true;
            ViewAddNew viewAddNew=new ViewAddNew();
            viewAddNew.show();
            viewAddNew.generate.setOnAction(generateEvent->{
                FootballPlayer tmp=viewAddNew.generator.generate();
                viewAddNew.setName(tmp.getName());
                viewAddNew.setDate(tmp.getDateBirthday());
                viewAddNew.setTown(tmp.getTown());
                viewAddNew.setTeam(tmp.getTeam());
                viewAddNew.setCast(tmp.getCast());
                viewAddNew.setPosition(tmp.getPosition());
            });
            viewAddNew.add.setOnAction(e -> {
                FootballPlayer tmp=new FootballPlayer();

                tmp.setName(viewAddNew.getName());
                tmp.setDateBirthday(viewAddNew.getDate());
                tmp.setCast(viewAddNew.getCast());
                tmp.setPosition(viewAddNew.getPosition());
                tmp.setTeam(viewAddNew.getTeam());
                tmp.setTown(viewAddNew.getTown());
                mainTable.controller.allFootballPlayers.add(tmp);
            });
            viewAddNew.mainFrame.setOnCloseRequest(close -> {
                        ViewAddNew.isShowing=false;
                        mainTable.controller.refreshPageNumber(mainTable.currentPageButton);
                        mainTable.controller.footballPlayers.clear();
                        mainTable.controller.refreshTable();
                        viewAddNew.mainFrame.close();
                    }
            );
        }

    };

   public void find(){
    ViewFindDialog viewFind=new ViewFindDialog();
    viewFind.findButton.setOnAction(event -> {
        viewFind.clearList();
        if(viewFind.getFilter()==0){
       for (FootballPlayer footballPlayer:mainTable.getAllPlayers()) {
           if(footballPlayer.getName().contains(viewFind.getName()) && !viewFind.getName().equals("")){
               if(footballPlayer.getDateBirthday().equals(viewFind.getDate()))
                    viewFind.addInTable(footballPlayer);
           }
       }
        }else if(viewFind.getFilter()==1) {
            for (FootballPlayer footballPlayer : mainTable.getAllPlayers()) {
                if(!viewFind.getPosition().equals("")&&viewFind.getCast().equals("")){
                   if(footballPlayer.getPosition().contains(viewFind.getPosition()))
                        viewFind.addInTable(footballPlayer);
                }

                else if(viewFind.getPosition().equals("")&&!viewFind.getCast().equals("")){
                        if(footballPlayer.getCast().contains(viewFind.getCast()))
                            viewFind.addInTable(footballPlayer);
                }else
                    if(!viewFind.getPosition().equals("")&&!viewFind.getCast().equals("")){
                            if(footballPlayer.getCast().contains(viewFind.getCast())||footballPlayer.getPosition().contains(viewFind.getPosition()))
                                viewFind.addInTable(footballPlayer);

                    }

            }
        }else if(viewFind.getFilter()==2){
            for(FootballPlayer footballPlayer:mainTable.getAllPlayers()){
                if(!viewFind.getTeam().equals("")&&viewFind.getTown().equals("")){
                    if(footballPlayer.getTeam().contains(viewFind.getTeam()))
                        viewFind.addInTable(footballPlayer);
                }

                else if(viewFind.getTeam().equals("")&&!viewFind.getTown().equals("")){
                    if(footballPlayer.getTown().contains(viewFind.getTown()))
                        viewFind.addInTable(footballPlayer);
                }else
                if(!viewFind.getTeam().equals("")&&!viewFind.getTown().equals("")){
                    if(footballPlayer.getTeam().contains(viewFind.getTeam())||footballPlayer.getTown().contains(viewFind.getTown()))
                        viewFind.addInTable(footballPlayer);

                }
            }
        }
        viewFind.refreshTable();
    });
    }

   public EventHandler delete= event -> {
        ViewDeleteDialog viewDelete = new ViewDeleteDialog();
        ArrayList<FootballPlayer> forDelete=new ArrayList<>();
        viewDelete.findButton.setOnAction(e -> {
            if (viewDelete.getFilter() == 0) {
                for (FootballPlayer footballPlayer : mainTable.getAllPlayers()) {
                    if (footballPlayer.getName().contains(viewDelete.getName()) && !viewDelete.getName().equals("")) {
                        if (footballPlayer.getDateBirthday().equals(viewDelete.getDate())) {
                            forDelete.add(footballPlayer);
                        }

                    }
                }

            }else  if (viewDelete.getFilter() == 1) {
                for (FootballPlayer footballPlayer : mainTable.getAllPlayers()) {
                    if(!viewDelete.getPosition().equals("")&&viewDelete.getCast().equals("")){
                        if(footballPlayer.getPosition().contains(viewDelete.getPosition())){
                            forDelete.add(footballPlayer);
                        }

                    }

                    else if(viewDelete.getPosition().equals("")&&!viewDelete.getCast().equals("")){
                        if(footballPlayer.getCast().contains(viewDelete.getCast())){
                            forDelete.add(footballPlayer);
                        }
                    }else
                    if(!viewDelete.getPosition().equals("")&&!viewDelete.getCast().equals("")){
                        if(footballPlayer.getCast().contains(viewDelete.getCast())||footballPlayer.getPosition().contains(viewDelete.getPosition())){
                            forDelete.add(footballPlayer);
                        }


                    }

                }

            }else if (viewDelete.getFilter() == 2) {
                for(FootballPlayer footballPlayer:mainTable.getAllPlayers()){
                    if(!viewDelete.getTeam().equals("")&&viewDelete.getTown().equals("")){
                        if(footballPlayer.getTeam().contains(viewDelete.getTeam())){
                            forDelete.add(footballPlayer);
                        }

                    }

                    else if(viewDelete.getTeam().equals("")&&!viewDelete.getTown().equals("")){
                        if(footballPlayer.getTown().contains(viewDelete.getTown())){
                            forDelete.add(footballPlayer);
                        }

                    }else
                    if(!viewDelete.getTeam().equals("")&&!viewDelete.getTown().equals("")){
                        if(footballPlayer.getTeam().contains(viewDelete.getTeam())||footballPlayer.getTown().contains(viewDelete.getTown())){
                            forDelete.add(footballPlayer);
                        }


                    }
                }

            }
            for(int i=0;i<mainTable.getAllPlayers().size();i++){
                for(FootballPlayer deleteFootballPlayer:forDelete){
                    if(mainTable.getAllPlayers().contains(deleteFootballPlayer))
                        mainTable.getAllPlayers().remove(deleteFootballPlayer);

                }
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Количество удаленных записей "+ forDelete.size());
            alert.show();
            mainTable.controller.refreshTable();
            forDelete.clear();

        });
    };

   public EventHandler save=event -> {
        FileChooser fileChooser=new FileChooser();
        FileChooser.ExtensionFilter extensionFilter=new FileChooser.ExtensionFilter("xml file","*.xml");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file=fileChooser.showSaveDialog(new Stage());

        if(file!=null){
            DomWriter domWriter=new DomWriter();
            domWriter.write(file.getPath(),mainTable.controller.allFootballPlayers);
        }

    };

   public void read(String path){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
         SaxReader sax = new SaxReader();

        try {
            parser.parse(new File(path), sax);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainTable.controller.allFootballPlayers=sax.getFootballPlayers();
        mainTable.controller.refreshTable();
    }

   public EventHandler openFile=event -> {
        FileChooser fileChooser=new FileChooser();
        FileChooser.ExtensionFilter extensionFilter=new FileChooser.ExtensionFilter("xml file","*.xml");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file=fileChooser.showOpenDialog(new Stage());
        if(file!=null){
            if(file.getName().contains(".xml")){
                read(file.getPath());
            }
            mainTable.controller.refreshPageNumber(mainTable.currentPageButton);
        }

    };



}
