package main;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Map;

public class Controller {

    @FXML
    Button buttonDictionary;
    @FXML
    Button buttonQuiz;
    @FXML
    Button buttonBackDW;
    @FXML
    Button buttonShowDW;
    @FXML
    TableView tableView;
    @FXML
    TableColumn<Map.Entry<String, String>, String> wordcolumn;
    @FXML
    TableColumn<Map.Entry<String, String>, String> translationcolumn;
    @FXML
    Label labelWord;
    @FXML
    TextField textFieldTranslation;
    @FXML
    Button buttonCheck;
    @FXML
    Button buttonNext;
    @FXML
    Label labelResult;


    FXMLLoader loaderQuizWindow = new FXMLLoader(getClass().getResource("/windows/quizWindow.fxml"));


    public void buttonDictionaryOnClickAction() throws IOException {
        changeSceneForDictionaryWindow();
    }

    public void buttonBackOnClickAction() throws IOException {
        changeSceneForMainWindow();
    }
    public void buttonQuizOnClickAction() throws IOException {
        changeSceneForQuizWindow();
    }

    public void buttonCheckOnClickAction() {
        printResultInformation(Main.quiz.checkIfCorrectTranslation(textFieldTranslation.getText()));
    }

    public void buttonNextOnClickAction() {
        setWordLabelFromThisWindow();
        clearResultLabel();
        clearTextFieldTranslation();
        Main.quiz.increasePossiblePoints();
    }

    public void changeSceneForMainWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/windows/mainWindow.fxml"));
        Main.window.setScene(new Scene(root));
    }

    public void changeSceneForDictionaryWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/windows/dictionaryWindow.fxml"));
        Main.window.setScene(new Scene(root));
    }

    public void changeSceneForQuizWindow() throws IOException {
        Parent root = loaderQuizWindow.load();
        setWordLabelFromPreviousWindow();
        Main.window.setScene(new Scene(root));
    }

    public void setWordLabelFromPreviousWindow() {
        Controller controller = (Controller)loaderQuizWindow.getController();
        controller.labelWord.setText(Main.quiz.takeRandomWordFromList());
    }

    public void setWordLabelFromThisWindow() {
        labelWord.setText(Main.quiz.takeRandomWordFromList());
    }

    public void clearTextFieldTranslation() {
        textFieldTranslation.clear();
    }

    public void clearResultLabel() {
        labelResult.setText("");
    }

    public void printResultInformation(int result) {
        if(result == 1) {
            labelResult.setText("Poprawna odpowiedź!");
        }
        else {
            labelResult.setText("Niepoprawna odpowiedz! \nPoprawna odpowiedź to: " + Main.quiz.correctAnswer);
        }
    }




    public void setTableView() {
        wordcolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
                // this callback returns property for just one cell, you can't use a loop here
                // for first column we use key
                return new SimpleStringProperty(p.getValue().getKey());
            }
        });
        translationcolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
                // for second column we use value
                return new SimpleStringProperty(p.getValue().getValue());
            }
        });
        ObservableList<Map.Entry<String, String>> items = FXCollections.observableArrayList(Main.dataBase.getDictionary().entrySet());
        tableView.setItems(items);
    }
}
