package com.example.bankapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Screen20 {
    @FXML
    private Button ViewStats;
    @FXML
    private Button CreateCorporation;
    @FXML
    private Button CreateFee;
    @FXML
    private Button ManageUsers;
    @FXML
    private Button StartOverdraft;
    @FXML
    private Button StopOverdraft;
    @FXML
    private Button HireWorker;
    @FXML
    private Button PayEmployee;
    @FXML
    private Button ReplaceManager;
    @FXML
    private Button AddAccess;
    @FXML
    private Button RemoveAccess;
    @FXML
    private Button CreateBank;

    @FXML
    private void onViewStats() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen22.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) ViewStats.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onCreateCorporation() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen1.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) CreateCorporation.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onCreateFee() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen9.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) CreateFee.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onManageUsers() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen21.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) ManageUsers.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onStartOverdraft() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen10_Start_A.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) StartOverdraft.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onStopOverdraft() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen10_Stop_A.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) StopOverdraft.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onHireWorker() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen6_A.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) HireWorker.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onPayEmployee() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen13_A.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) PayEmployee.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onReplaceManager() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen7.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) ReplaceManager.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onAddAccess() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen8_Add_A.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) AddAccess.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onRemoveAccess() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen8_Remove_A.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) RemoveAccess.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onCreateBank() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen2.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) CreateBank.getScene().getWindow();
        stage.setScene(scene);
    }
}
