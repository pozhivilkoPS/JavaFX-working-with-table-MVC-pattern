package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.View.ViewMainFrame;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ViewMainFrame window=new ViewMainFrame();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
