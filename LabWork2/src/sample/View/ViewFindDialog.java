package sample.View;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import sample.Model.FootballPlayer;

public class ViewFindDialog extends ViewDeleteDialog {
    public ViewFindDialog(){


        root.getChildren().remove(findButton);
        Button changeTableSizeButton=new Button("Change size");
        TextField tableSize=new TextField("10");
        tableSize.setPrefWidth(30);
        HBox findAndTableSize=new HBox(findButton,tableSize,changeTableSizeButton);
        changeTableSizeButton.setOnAction(event->{
            table.controller.changeTableSize(tableSize);
            table.controller.refreshPageNumber(table.currentPageButton);
        });

        root.getChildren().addAll(findAndTableSize,table.getTableAndNavigation());
    }
    public Table table=new Table();

    public void addInTable(FootballPlayer footballPlayer){
    table.controller.allFootballPlayers.add(footballPlayer);
    }

    public void refreshTable(){
        table.controller.refreshPageNumber(table.currentPageButton);
        table.controller.refreshTable();

    }

    public void clearList(){
        table.controller.allFootballPlayers.clear();

    }
}
