package com.example.bankapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Screen24 {
    @FXML
    private Button AddAccess;
    @FXML
    private Button RemoveAccess;
    @FXML
    private Button Deposit;
    @FXML
    private Button StartOverdraft;
    @FXML
    private Button StopOverdraft;
    @FXML
    private Button MakeTransfer;
    @FXML
    private Button Withdrawal;


    @FXML
    private void onAddAccess() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen8_Add_C.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) AddAccess.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onRemoveAccess() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen8_Remove_C.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) RemoveAccess.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onDeposit() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen11_D.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Deposit.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onStartOverdraft() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen10_Start_C.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) StartOverdraft.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onStopOverdraft() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen10_Stop_C.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) StopOverdraft.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onMakeTransfer() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen12.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) MakeTransfer.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onWithdrawal() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen11_W.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Withdrawal.getScene().getWindow();
        stage.setScene(scene);
    }
}
