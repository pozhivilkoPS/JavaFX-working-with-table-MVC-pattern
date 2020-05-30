package sample.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Controller.Controller;
import sample.View.Table;

public class ViewMainFrame {
    public ViewMainFrame(){
        tableSize.setPrefWidth(30);
        mainFrame.setScene(window);
        mainFrame.show();

        addButton.setOnAction(controller.addNew);

        findButton.setOnAction(event -> {
            controller.find();
        });

        deleteButton.setOnAction(controller.delete);

        openButton.setOnAction(controller.openFile);

        saveButton.setOnAction(controller.save);

        changeTableSizeButton.setOnAction(event -> {
            table.controller.changeTableSize(tableSize);
            table.controller.refreshPageNumber(table.currentPageButton);
        });
        
    }





    Table table=new Table();
    Controller controller=new Controller(table);

    Button changeTableSizeButton=new Button("Change size");
    TextField tableSize=new TextField("10");
    Button saveButton=new Button("Save");
    Button openButton=new Button("Open");
    Button addButton=new Button("Add");
    Button deleteButton = new Button("Delete");
    Button findButton=new Button("Find");

    HBox controlButtons=new HBox(saveButton,openButton,findButton,deleteButton,addButton,tableSize,changeTableSizeButton);
    VBox root=new VBox(controlButtons,table.getTableAndNavigation());

    Scene window = new Scene(root,780,600);
    Stage mainFrame=new Stage();

}
