package com.example.bankapp;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.CallableStatement;

public class Screen12 implements Initializable {
    @FXML
    private ComboBox<String> FromBankAccountID = new ComboBox<>();
    @FXML
    private TextField Amount;
    @FXML
    private ComboBox<String> ToBankAccountID = new ComboBox<>();
    @FXML
    private Button Back;
    @FXML
    private Button Confirm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initializeFromBankAccountID();
            initializeToBankAccountID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void initializeFromBankAccountID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select perID, bankID, accountID from access;");
        while (set.next()) {
            if (set.getString(1).equals(Connect.getID())) {
                list.add(set.getString(2) + ", " + set.getString(3));
            }
        }
        FromBankAccountID.setItems(list);
        FromBankAccountID.getSelectionModel().selectFirst();
    }

    @FXML
    private void initializeToBankAccountID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select perID, bankID, accountID from access;");
        while (set.next()) {
            if (set.getString(1).equals(Connect.getID())) {
                list.add(set.getString(2) + ", " + set.getString(3));
            }
        }
        ToBankAccountID.setItems(list);
        ToBankAccountID.getSelectionModel().selectFirst();
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
        if (Objects.equals(Amount.getText(), "")) {
            Amount.setText(null);
        }
        try {
            CallableStatement statement = Connect.getConnection().prepareCall("{call account_transfer(?, ?, ?, ?, ?, ?, ?)}");
            statement.setString(1, Connect.getID());
            statement.setString(2, Amount.getText());
            statement.setString(3, FromBankAccountID.getValue().split(", ")[0]);
            statement.setString(4, FromBankAccountID.getValue().split(", ")[1]);
            statement.setString(5, ToBankAccountID.getValue().split(", ")[0]);
            statement.setString(6, ToBankAccountID.getValue().split(", ")[1]);
            statement.setString(7, null);
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