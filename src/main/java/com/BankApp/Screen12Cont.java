package com.BankApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Screen12Cont {
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
    private ComboBox<String> Account;

    @FXML
    protected void initializeAccount() {
        ObservableList<String> AccountList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        Account.setItems(AccountList);
    }

    @FXML
    private ComboBox<String> BankTwo;

    @FXML
    protected void initializeBankTwo() {
        ObservableList<String> BankTwoList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        BankTwo.setItems(BankTwoList);
    }

    @FXML
    private ComboBox<String> AccountTwo;

    @FXML
    protected void initializeAccountTwo() {
        ObservableList<String> AccountTwoList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        AccountTwo.setItems(AccountTwoList);
    }

    @FXML
    private TextField Amount;

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
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen24.fxml"));
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
    private void onAccount() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene4(fxmlLoader1, height, width);
    }

    private void loadScene4(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Account.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onBankTwo() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene5(fxmlLoader1, height, width);
    }

    private void loadScene5(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) BankTwo.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onAccountTwo() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene6(fxmlLoader1, height, width);
    }

    private void loadScene6(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) AccountTwo.getScene().getWindow();
        stage1.setScene(scene1);
    }
}