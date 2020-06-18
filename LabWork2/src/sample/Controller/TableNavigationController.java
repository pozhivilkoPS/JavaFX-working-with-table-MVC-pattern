package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Model.FootballPlayer;

import java.util.ArrayList;

public class TableNavigationController {

    public ArrayList<FootballPlayer> allFootballPlayers=new ArrayList<>();
    public ObservableList<FootballPlayer> footballPlayers= FXCollections.observableArrayList();
    public int currentPage=0;
    public int currentTableSize=10;

    public void refreshPageNumber(Button button){
        Integer maxPages=allFootballPlayers.size()/currentTableSize;
        if(maxPages*currentTableSize<allFootballPlayers.size())
            maxPages++;
        if(maxPages==0)
            maxPages++;
        button.setText(Integer.toString(currentPage+1)+"/"+maxPages.toString());

    }

    public void refreshTable(){
        footballPlayers.clear();
        if(allFootballPlayers.size()-currentPage*currentTableSize<currentTableSize) {
            for (int i = currentPage * currentTableSize; i < allFootballPlayers.size(); i++)
                footballPlayers.add(allFootballPlayers.get(i));
        }
        else
            for(int i=currentPage*currentTableSize;i<currentPage*currentTableSize+currentTableSize;i++)
                footballPlayers.add(allFootballPlayers.get(i));

    }

    public void nextPage(){
        if(allFootballPlayers.size()>(currentPage+1)*currentTableSize) {
            currentPage++;
            refreshTable();
        }

    }

    public void previousPage(){
        if(currentPage>0) {
            currentPage--;
            refreshTable();
        }

    }

    public void firstPage(){
        currentPage=0;
        refreshTable();

    }

    public void lastPage(){
        if(allFootballPlayers.size()!=0){
            currentPage=allFootballPlayers.size()/currentTableSize;
            if(allFootballPlayers.size()==currentPage*currentTableSize)
                currentPage--;
            refreshTable();
        }

    }

    public void changeTableSize(TextField textField){
        currentPage=0;
        currentTableSize=Integer.parseInt(textField.getText());
        refreshTable();

    }
}
