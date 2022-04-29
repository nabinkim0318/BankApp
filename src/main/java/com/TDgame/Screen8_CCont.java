package com.TDgame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Screen8_CCont {
    final int height = 600;
    final int width = 400;

    @FXML
    private Button Create;

    @FXML
    private Button Cancel;

    @FXML
    private ComboBox<String> AccessibleAccounts;

    @FXML
    protected void initializeAccounts() {
        ObservableList<String> accessibleAccountList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        AccessibleAccounts.setItems(accessibleAccountList);
    }

    @FXML
    private ComboBox<String> Customer;

    @FXML
    protected void initializeCustomer() {
        ObservableList<String> CustomerList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        Customer.setItems(CustomerList);
    }

    @FXML
    private CheckBox AddingOwner;

    @FXML
    private TextField InitialBalance;

    @FXML
    private TextField MinBalance;

    @FXML
    private TextField MaxWithdrawals;

    @FXML
    private TextField InterestRate;

    @FXML
    private void onCreate() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen6.fxml"));
        loadScene1(fxmlLoader1, height, width);
    }

    private void loadScene1(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Create.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onCancel() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen24.fxml"));
        loadScene2(fxmlLoader1, height, width);
    }

    private void loadScene2(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Cancel.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onAccessibleAccounts() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene3(fxmlLoader1, height, width);
    }

    private void loadScene3(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) AccessibleAccounts.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onCustomer() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene4(fxmlLoader1, height, width);
    }

    private void loadScene4(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Customer.getScene().getWindow();
        stage1.setScene(scene1);
    }

    /*@FXML
    private void onAddingOwner() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene5(fxmlLoader1, height, width);
    }

    private void loadScene5(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) AddingOwner.getScene().getWindow();
        stage1.setScene(scene1);
    }*/
}