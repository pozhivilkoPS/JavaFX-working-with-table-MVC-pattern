package sample.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.FootballPlayerGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ViewAddNew {
    public ViewAddNew(){
        mainFrame.setScene(window);
        root.getChildren().addAll(name,team,town,cast,position,add,nameL,dateBirthL,teamL,townL,castL,positionL,date,generate);
        name.setLayoutY(20);
        name.setPrefWidth(200);
        date.setPrefWidth(110);
        team.setLayoutY(20);
        team.setPrefWidth(140);
        town.setLayoutY(20);
        cast.setLayoutY(20);
        position.setLayoutY(20);
        date.setLayoutY(20);
        date.setLayoutX(200);


        dateBirthL.setLayoutX(200);
        team.setLayoutX(150*2+10);
        teamL.setLayoutX(150*2+10);
        town.setLayoutX(150*3);
        townL.setLayoutX(150*3);
        cast.setLayoutX(150*4);
        castL.setLayoutX(150*4);
        position.setLayoutX(150*5);
        positionL.setLayoutX(150*5);

        add.setLayoutY(50);
        add.setLayoutX(450);
        add.setText("Confirm");
        generate.setLayoutX(520);
        generate.setLayoutY(50);



    }

    public FootballPlayerGenerator generator=new FootballPlayerGenerator();
    public static boolean isShowing=false;
    public Button add=new Button();
    public Button generate=new Button("Generate");
    TextField name=new TextField();
    TextField team=new TextField();
    TextField town=new TextField();
    TextField cast=new TextField();
    TextField position=new TextField();
    Label nameL=new Label("Name");
    Label dateBirthL=new Label("Date of the birth");
    Label teamL=new Label("Team");
    Label townL=new Label("Town");
    Label castL=new Label("Cast");
    Label positionL=new Label("Position");
    LocalDate lc=LocalDate.of(2000,1,1);
    DatePicker date=new DatePicker(lc);

    Group root=new Group();

    Scene window = new Scene(root,900,200);
    public  Stage mainFrame=new Stage();
    public void show(){
        mainFrame.show();
    }

    public String getName(){
        return name.getText();
    }
    public String getDate(){
        return date.getEditor().getText();
    }
    public String getTown(){
        return town.getText();
    }
    public String getTeam(){
        return team.getText();
    }
    public String getCast(){
        return cast.getText();
    }
    public String getPosition(){
        return position.getText();
    }

    public void setName(String name){
        this.name.setText(name);
    }
    public void setDate(String date){
        this.date.getEditor().setText(date);
    }
    public void setTown(String town){
        this.town.setText(town);
    }
    public void setTeam(String team){
        this.team.setText(team);
    }
    public void setCast(String cast){
        this.cast.setText(cast);
    }
    public void setPosition(String position){
        this.position.setText(position);
    }
}
