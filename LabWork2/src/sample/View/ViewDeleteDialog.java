package sample.View;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewDeleteDialog {
    public ViewDeleteDialog() {
        Scene window = new Scene(root, 780, 600);
        mainFrame.setScene(window);
        mainFrame.show();
        root.prefHeight(100);
        filter.getItems().addAll("Name and Birthday", "Position or Cast", "Team or Town");
        dateBirthL.setLayoutX(200);
        name.setPrefWidth(200);
        date.setPrefWidth(110);
        team.setPrefWidth(120);
        teamL.setLayoutX(300);
        town.setPrefWidth(120);
        townL.setLayoutX(420);
        castL.setLayoutX(530);
        cast.setPrefWidth(120);
        positionL.setLayoutX(650);
        position.setPrefWidth(140);
        labels.getChildren().addAll(nameL, dateBirthL, teamL, townL, castL, positionL);
        fields.getChildren().addAll(name, date, team, town, cast, position);
        root.getChildren().addAll(filter, labels, fields, findButton);

    }

    VBox root = new VBox();
    Group labels = new Group();
    HBox fields = new HBox();
    public ComboBox<String> filter = new ComboBox<>();

    TextField name = new TextField();
    TextField team = new TextField();
    TextField town = new TextField();
    TextField cast = new TextField();
    TextField position = new TextField();
    Label nameL = new Label("Name");
    Label dateBirthL = new Label("Birth(d.m.y)");
    Label teamL = new Label("Team");
    Label townL = new Label("Town");
    Label castL = new Label("Cast");
    Label positionL = new Label("Position");
    DatePicker date = new DatePicker();


    Stage mainFrame = new Stage();

    public Button findButton = new Button("Find");

    public String getName() {
        return name.getText();
    }

    public String getDate() {
        return date.getEditor().getText();
    }

    public String getTown() {
        return town.getText();
    }

    public String getTeam() {
        return team.getText();
    }

    public String getCast() {
        return cast.getText();
    }

    public String getPosition() {
        return position.getText();
    }
    public int getFilter(){
        return filter.getSelectionModel().getSelectedIndex();
    }
}
