package com.example.bankapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.io.IOException;
import java.sql.CallableStatement;

public class Screen13_A {
    @FXML
    private Button PayAllEmployees;

    @FXML
    private void onPayAllEmployees() throws IOException {
        try {
            CallableStatement statement = Connect.getConnection().prepareCall("{call pay_employees()}");
            statement.execute();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen20.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) PayAllEmployees.getScene().getWindow();
        stage.setScene(scene);
    }
}