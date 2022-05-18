package com.example.bankapp;

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
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.CallableStatement;

public class Screen9 implements Initializable {
    @FXML
    private ComboBox<String> BankAccountID = new ComboBox<>();
    @FXML
    private TextField FeeType;
    @FXML
    private Button Back;
    @FXML
    private Button Confirm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initializeBankAccountID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void initializeBankAccountID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select bankID, accountID from interest_bearing;");
        while (set.next()) {
            list.add(set.getString(1) + ", " + set.getString(2));
        }
        BankAccountID.setItems(list);
        BankAccountID.getSelectionModel().selectFirst();
    }

    @FXML
    private void onBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen20.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onConfirm() throws IOException {
        if (Objects.equals(FeeType.getText(), "")) {
            FeeType.setText(null);
        }
        try {
            CallableStatement statement = Connect.getConnection().prepareCall("{call create_fee(?, ?, ?)}");
            statement.setString(1, BankAccountID.getValue().split(", ")[0]);
            statement.setString(2, BankAccountID.getValue().split(", ")[1]);
            statement.setString(3, FeeType.getText());
            statement.execute();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen20.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Confirm.getScene().getWindow();
        stage.setScene(scene);
    }
}