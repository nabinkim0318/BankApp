package com.example.bankapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Screen22 {
    @FXML
    private Button DisplayAccountStats;

    @FXML
    private Button DisplayCorporationStats;

    @FXML
    private Button DisplayBankStats;

    @FXML
    private Button DisplayCustomerStats;

    @FXML
    private Button DisplayEmployeeStats;

    @FXML
    private void onDisplayAccountStats() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen14.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) DisplayAccountStats.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onDisplayCorporationStats() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen16.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) DisplayCorporationStats.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onDisplayBankStats() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen15.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) DisplayBankStats.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onDisplayCustomerStats() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen17.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) DisplayCustomerStats.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onDisplayEmployeeStats() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen18.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) DisplayEmployeeStats.getScene().getWindow();
        stage.setScene(scene);
    }
}
