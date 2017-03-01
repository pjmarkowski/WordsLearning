package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {
    static Stage window;
    static DataBase dataBase = new DataBase();
    static Quiz quiz = new Quiz();

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/windows/mainWindow.fxml"));
        window.setTitle("Nauka słówek!");
        window.setScene(new Scene(root));
        window.show();
    }


    public static void main(String[] args) {
        try {
            dataBase.readDictionayFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        quiz.getAllElementsFromMapIntoList();
        System.out.println(quiz.takeRandomWordFromList());
        quiz.checkIfCorrectTranslation("dziękuję");

        launch(args);
    }
}
