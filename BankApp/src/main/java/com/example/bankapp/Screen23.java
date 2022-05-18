package com.example.bankapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Screen23 {
    @FXML
    private Button PayEmployee;
    @FXML
    private Button HireWorker;

    @FXML
    private void onHireWorker() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen6_M.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) HireWorker.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onPayEmployee() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen13_M.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) PayEmployee.getScene().getWindow();
        stage.setScene(scene);
    }
}
