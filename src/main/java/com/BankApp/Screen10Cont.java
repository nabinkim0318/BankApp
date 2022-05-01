package com.BankApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Screen10Cont {
    final int height = 600;
    final int width = 400;

    @FXML
    private Button Confirm;

    @FXML
    private Button Back;

    @FXML
    private ComboBox<String> AvailableChecking;

    @FXML
    protected void initializeChecking() {
        ObservableList<String> checkingList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        AvailableChecking.setItems(checkingList);
    }

    @FXML
    private ComboBox<String> AvailableSaving;

    @FXML
    protected void initializeSaving() {
        ObservableList<String> savingList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        AvailableSaving.setItems(savingList);
    }

    @FXML
    private CheckBox Adding;

    @FXML
    private void onConfirm() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen6.fxml"));
        loadScene1(fxmlLoader1, height, width);
    }

    private void loadScene1(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Confirm.getScene().getWindow();
        stage1.setScene(scene1);
    }

    // If admin, moves to screen 20, if not, moves to screen 24
    @FXML
    private void onBack() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen20.fxml"));
        loadScene2(fxmlLoader1, height, width);
    }

    private void loadScene2(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Back.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onAvailableChecking() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene3(fxmlLoader1, height, width);
    }

    private void loadScene3(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) AvailableChecking.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onAvailableSaving() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene4(fxmlLoader1, height, width);
    }

    private void loadScene4(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) AvailableSaving.getScene().getWindow();
        stage1.setScene(scene1);
    }

    /*@FXML
    private void onAdding() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene5(fxmlLoader1, height, width);
    }

    private void loadScene5(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Adding.getScene().getWindow();
        stage1.setScene(scene1);
    }*/
}