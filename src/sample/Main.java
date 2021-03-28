package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private final String UI = "ui.fxml";
    private final String TITLE = "Unit Converter";
    private final int WIDTH = -1;
    private final int HEIGHT = -1;
    private Controller controller = new Controller();


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root= FXMLLoader.load(getClass().getResource(UI));
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
