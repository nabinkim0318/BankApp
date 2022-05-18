package com.example.bankapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Screen21 {
    @FXML
    private Button CreateEmployee;
    @FXML
    private Button CreateCustomer;
    @FXML
    private Button StopEmployee;
    @FXML
    private Button StopCustomer;

    @FXML
    private void onCreateEmployee() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen3.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) CreateEmployee.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onCreateCustomer() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen4.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) CreateCustomer.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onStopEmployee() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen5_E.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) StopEmployee.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onStopCustomer() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen5_C.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) StopCustomer.getScene().getWindow();
        stage.setScene(scene);
    }
}
