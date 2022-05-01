package com.BankApp;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
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

public class Screen8_A implements Initializable {
    @FXML
    private ComboBox<String> BankID = new ComboBox<>();
    @FXML
    private ComboBox<String> AccountID = new ComboBox<>();
    @FXML
    private ComboBox<String> AccountType = new ComboBox<>();
    @FXML
    private TextField InitialBalance;
    @FXML
    private TextField InterestRate;
    @FXML
    private TextField MinBalance;
    @FXML
    private TextField MaxWithdrawals;
    @FXML
    private Button Back;
    @FXML
    private Button Confirm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initializeBankID();
            initializeAccountID();
            initializeAccountType();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void initializeBankID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select bankID from bank;");
        while (set.next()) {
            list.add(set.getString(1));
        }
        BankID.setItems(list);
    }

    @FXML
    private void initializeAccountID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select accountID from bank_account;");
        while (set.next()) {
            list.add(set.getString(1));
        }
        AccountID.setItems(list);
    }

    @FXML
    private void initializeAccountType() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("checking");
        list.add("savings");
        list.add("market");
        AccountType.setItems(list);
    }

    @FXML
    private void onBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Screen20.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onConfirm() throws SQLException, IOException {
        CallableStatement statement = Connect.getConnection().prepareCall("{call add_account_access(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
        statement.setString(1, null);
        statement.setString(2, null);
        statement.setString(3, AccountType.getValue());
        statement.setString(4, BankID.getValue());
        statement.setString(5, AccountID.getValue());
        statement.setString(6, InitialBalance.getText());
        statement.setString(7, InterestRate.getText());
        statement.setString(8, null);
        statement.setString(9, MinBalance.getText());
        statement.setString(10, null);
        statement.setString(11, MaxWithdrawals.getText());
        statement.setString(12, null);
        statement.execute();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Screen20.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Confirm.getScene().getWindow();
        stage.setScene(scene);
    }
}
