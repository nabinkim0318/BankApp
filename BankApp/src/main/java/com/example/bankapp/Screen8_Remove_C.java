package com.example.bankapp;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.CallableStatement;

public class Screen8_Remove_C implements Initializable {
    @FXML
    private ComboBox<String> BankAccountID = new ComboBox<>();
    @FXML
    private ComboBox<String> CustomerID = new ComboBox<>();
    @FXML
    private Button Back;
    @FXML
    private Button Confirm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initializeBankAccountID();
            initializeCustomerID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void initializeBankAccountID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select perID, bankID, accountID from access;");
        while (set.next()) {
            if (set.getString(1).equals(Connect.getID())) {
                list.add(set.getString(2) + ", " + set.getString(3));
            }
        }
        BankAccountID.setItems(list);
        BankAccountID.getSelectionModel().selectFirst();
    }

    @FXML
    private void initializeCustomerID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select perID from customer;");
        while (set.next()) {
            list.add(set.getString(1));
        }
        CustomerID.setItems(list);
        CustomerID.getSelectionModel().selectFirst();
    }

    @FXML
    private void onBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen24.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onConfirm() throws IOException {
        try {
            CallableStatement statement = Connect.getConnection().prepareCall("{call remove_account_access(?, ?, ?, ?)}");
            statement.setString(1, Connect.getID());
            statement.setString(2, CustomerID.getValue());
            statement.setString(3, BankAccountID.getValue().split(", ")[0]);
            statement.setString(4, BankAccountID.getValue().split(", ")[1]);
            statement.execute();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen24.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Confirm.getScene().getWindow();
        stage.setScene(scene);
    }
}
