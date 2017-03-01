package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class Controller {

    @FXML
    Button buttonDictionary;
    @FXML
    Button buttonBackDW;

    public void buttonDictionaryOnClickAction() throws IOException {
     changeSceneForDictionaryWindow();
    }

    public void buttonBackOnClickAction() throws IOException {
        changeSceneForMainWindow();
    }

    public void changeSceneForMainWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/windows/mainWindow.fxml"));
        Main.window.setScene(new Scene(root));
    }

    public void changeSceneForDictionaryWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/windows/dictionaryWindow.fxml"));
        Main.window.setScene(new Scene(root));
    }
}
