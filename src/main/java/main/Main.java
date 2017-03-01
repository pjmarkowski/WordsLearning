package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    static Stage window;
    static DataBase dataBase = new DataBase();


    @Override
    public void start(Stage primaryStage) throws Exception{
        dataBase.readDictionayFromFile();
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/windows/mainWindow.fxml"));
        window.setTitle("Nauka słówek!");
        window.setScene(new Scene(root));
        window.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
