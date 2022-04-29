package com.TDgame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import java.io.IOException;

public class Screen7Cont {
    final int height = 600;
    final int width = 400;

    @FXML
    private Button Confirm;

    @FXML
    private Button Back;

    @FXML
    private ComboBox<String> Bank;

    @FXML
    protected void initializeBank() {
        ObservableList<String> BankList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        Bank.setItems(BankList);
    }

    @FXML
    private ComboBox<String> Employee;

    @FXML
    protected void initializeEmployee() {
        ObservableList<String> EmployeeList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        Employee.setItems(EmployeeList);
    }

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
    private void onBank() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene3(fxmlLoader1, height, width);
    }

    private void loadScene3(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Bank.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onEmployee() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene4(fxmlLoader1, height, width);
    }

    private void loadScene4(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Employee.getScene().getWindow();
        stage1.setScene(scene1);
    }
}
