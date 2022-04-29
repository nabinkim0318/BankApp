package com.TDgame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class Screen2Cont {
    final int height = 600;
    final int width = 400;

    @FXML
    private Button cancel;

    @FXML
    private Button create;

    @FXML
    private ComboBox<String> corpID;

    @FXML
    protected void initializeCorpID() {
        ObservableList<String> corpIDList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        corpID.setItems(corpIDList);
    }

    @FXML
    private ComboBox<String> manager;

    @FXML
    protected void initializeManager() {
        ObservableList<String> managerList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        manager.setItems(managerList);
    }

    @FXML
    private ComboBox<String> employee;

    @FXML
    protected void initializeEmployee() {
        ObservableList<String> employeeList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        employee.setItems(employeeList);
    }

    @FXML
    private TextField Name;

    @FXML
    private TextField BankID;

    @FXML
    private TextField Street;

    @FXML
    private TextField StateAbbr;

    @FXML
    private TextField ZipCode;

    @FXML
    private TextField City;

    @FXML
    private TextField ReservedAssets;

    @FXML
    private void onCancel() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen20.fxml"));
        loadScene1(fxmlLoader1, height, width);
    }

    private void loadScene1(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) cancel.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onCreate() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene2(fxmlLoader1, height, width);
    }

    private void loadScene2(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) create.getScene().getWindow();
        stage1.setScene(scene1);
    }
}
