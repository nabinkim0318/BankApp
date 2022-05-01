package com.BankApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Screen4Cont {
    final int height = 600;
    final int width = 400;

    @FXML
    private Button confirm;

    @FXML
    private Button Back;

    @FXML
    private ComboBox<String> ID;

    @FXML
    protected void initialize() {
        ObservableList<String> IDList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        ID.setItems(IDList);
    }

    @FXML
    private void onConfirm() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen21.fxml"));
        loadScene1(fxmlLoader1, height, width);
    }

    private void loadScene1(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) confirm.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onBack() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen21.fxml"));
        loadScene2(fxmlLoader1, height, width);
    }

    private void loadScene2(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Back.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onID() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene3(fxmlLoader1, height, width);
    }

    private void loadScene3(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) ID.getScene().getWindow();
        stage1.setScene(scene1);
    }
}

