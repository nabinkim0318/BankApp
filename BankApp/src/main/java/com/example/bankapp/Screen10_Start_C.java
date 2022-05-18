package com.example.bankapp;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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

public class Screen10_Start_C implements Initializable {
    @FXML
    private ComboBox<String> CheckingID = new ComboBox<>();
    @FXML
    private ComboBox<String> SavingsID = new ComboBox<>();
    @FXML
    private Button Back;
    @FXML
    private Button Confirm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initializeCheckingID();
            initializeSavingsID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void initializeCheckingID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select bankID, accountID, perID from checking natural join access where protectionBank is NULL and protectionAccount is NULL;");
        while (set.next()) {
            if (set.getString(3).equals(Connect.getID())) {
                list.add(set.getString(1) + ", " + set.getString(2));
            }
        }
        CheckingID.setItems(list);
        CheckingID.getSelectionModel().selectFirst();
    }

    @FXML
    private void initializeSavingsID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select bankID, accountID, perID from savings natural join access where (bankID, accountID) not in (select protectionBank, protectionAccount from checking where protectionBank is not NULL and protectionAccount is not NULL);");
        while (set.next()) {
            if (set.getString(3).equals(Connect.getID())) {
                list.add(set.getString(1) + ", " + set.getString(2));
            }
        }
        SavingsID.setItems(list);
        SavingsID.getSelectionModel().selectFirst();
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
            CallableStatement statement = Connect.getConnection().prepareCall("{call start_overdraft(?, ?, ?, ?, ?)}");
            statement.setString(1, Connect.getID());
            statement.setString(2, CheckingID.getValue().split(", ")[0]);
            statement.setString(3, CheckingID.getValue().split(", ")[1]);
            statement.setString(4, SavingsID.getValue().split(", ")[0]);
            statement.setString(5, SavingsID.getValue().split(", ")[1]);
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