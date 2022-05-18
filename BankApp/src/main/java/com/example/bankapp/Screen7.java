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

public class Screen7 implements Initializable {
    @FXML
    private ComboBox<String> BankID = new ComboBox<>();
    @FXML
    private ComboBox<String> EmployeeID = new ComboBox<>();
    @FXML
    private TextField NewSalary;
    @FXML
    private Button Back;
    @FXML
    private Button Confirm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initializeBankID();
            initializeEmployeeID();
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
        BankID.getSelectionModel().selectFirst();
    }

    @FXML
    private void initializeEmployeeID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select perID from employee where perID not in (select manager from bank) and perID not in (select perID from workFor);");
        while (set.next()) {
            list.add(set.getString(1));
        }
        EmployeeID.setItems(list);
        EmployeeID.getSelectionModel().selectFirst();
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
        if (Objects.equals(NewSalary.getText(), "")) {
            NewSalary.setText(null);
        }
        try {
            CallableStatement statement = Connect.getConnection().prepareCall("{call replace_manager(?, ?, ?)}");
            statement.setString(1, EmployeeID.getValue());
            statement.setString(2, BankID.getValue());
            statement.setString(3, NewSalary.getText());
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
