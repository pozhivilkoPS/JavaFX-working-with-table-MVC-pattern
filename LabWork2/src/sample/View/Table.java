package sample.View;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import sample.Controller.TableNavigationController;
import sample.Model.FootballPlayer;
import sun.util.calendar.LocalGregorianCalendar;

import java.util.ArrayList;

public class Table {
   public Table(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<FootballPlayer, String>("name"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<FootballPlayer, LocalGregorianCalendar.Date>("dateBirthday"));
        teamColumn.setCellValueFactory(new PropertyValueFactory<FootballPlayer, String>("team"));
        townColumn.setCellValueFactory(new PropertyValueFactory<FootballPlayer, String>("town"));
        castColumn.setCellValueFactory(new PropertyValueFactory<FootballPlayer, String>("cast"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<FootballPlayer, String>("position"));
        nameColumn.setPrefWidth(200);
        teamColumn.setPrefWidth(145);
        townColumn.setPrefWidth(115);
        castColumn.setPrefWidth(115);
        positionColumn.setPrefWidth(140);

        navigationButtons.setLayoutY(400);
        navigationButtons.setLayoutX(300);

        nextPage.setOnAction(event -> {
            controller.nextPage();
        });

        previousPage.setOnAction(event -> {
            controller.previousPage();
        });

        firstPage.setOnAction(event -> {
            controller.firstPage();
        });

        lastPage.setOnAction(event -> {
            controller.lastPage();
        });

        table.getColumns().addAll(nameColumn,birthdayColumn,teamColumn,townColumn,castColumn,positionColumn);
        navigationButtons.addEventFilter(MouseEvent.MOUSE_CLICKED,event -> {
            controller.refreshPageNumber(currentPageButton);
        });
    }
    public TableNavigationController controller=new TableNavigationController();





    Button nextPage = new Button(">");
    Button previousPage=new Button("<");
    Button firstPage=new Button("<<");
    Button lastPage=new Button(">>");
    public Button currentPageButton=new Button(Integer.toString(controller.currentPage+1)+"/1");
    HBox navigationButtons=new HBox(firstPage,previousPage,currentPageButton,nextPage,lastPage);

    private TableView<FootballPlayer> table = new TableView<>(controller.footballPlayers);

    Group tableAndNavigation=new Group(getTable(),navigationButtons);

    TableColumn<FootballPlayer,String> nameColumn =new TableColumn<FootballPlayer,String>("Name");
    TableColumn<FootballPlayer, LocalGregorianCalendar.Date> birthdayColumn =new TableColumn<FootballPlayer, LocalGregorianCalendar.Date>("Birthday ");
    TableColumn<FootballPlayer, String> teamColumn =new TableColumn<FootballPlayer,String>("Team");
    TableColumn<FootballPlayer, String> townColumn =new TableColumn<FootballPlayer,String>("Town");
    TableColumn<FootballPlayer, String> castColumn =new TableColumn<FootballPlayer,String>("Cast");
    TableColumn<FootballPlayer, String> positionColumn =new TableColumn<FootballPlayer,String>("Position    ");

    public TableView<FootballPlayer> getTable(){
        return  table;
    }

    public Group getTableAndNavigation(){
        return tableAndNavigation;
    }

    public ArrayList<FootballPlayer> getAllPlayers(){
        return controller.allFootballPlayers;
    }




}
