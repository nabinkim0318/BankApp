package com.TDgame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Screen24Cont {
    final int height = 600;
    final int width = 400;

    @FXML
    private Button ManageAccounts;

    @FXML
    private Button Deposit;

    @FXML
    private Button ManageOverdraft;

    @FXML
    private Button MakeTransfer;

    @FXML
    private Button Withdrawal;


    @FXML
    private void onManageAccounts() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen6.fxml"));
        loadScene1(fxmlLoader1, height, width);
    }

    private void loadScene1(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) ManageAccounts.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onDeposit() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene2(fxmlLoader1, height, width);
    }

    private void loadScene2(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Deposit.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onManageOverdraft() throws IOException {
        FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("/views/Screen6.fxml"));
        loadScene3(fxmlLoader3, height, width);
    }

    private void loadScene3(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) ManageOverdraft.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onMakeTransfer() throws IOException {
        FXMLLoader fxmlLoader4 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene4(fxmlLoader4, height, width);
    }

    private void loadScene4(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) MakeTransfer.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onWithdrawal() throws IOException {
        FXMLLoader fxmlLoader4 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene5(fxmlLoader4, height, width);
    }

    private void loadScene5(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Withdrawal.getScene().getWindow();
        stage1.setScene(scene1);
    }
}
