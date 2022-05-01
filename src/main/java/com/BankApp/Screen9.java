package com.BankApp;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.CallableStatement;

public class Screen9 {
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
    private TextField FeeType;

    @FXML
    private void onConfirm() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Screen6.fxml"));
        Scene scene1 = new Scene(loader.load(), width, height);
        Stage stage1 = (Stage) Confirm.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Screen20.fxml"));
        Scene scene1 = new Scene(loader.load(), width, height);
        Stage stage1 = (Stage) Back.getScene().getWindow();
        stage1.setScene(scene1);
    }
}