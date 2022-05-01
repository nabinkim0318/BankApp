package com.BankApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Screen20Cont {
    final int height = 600;
    final int width = 400;

    @FXML
    private Button ViewStats;

    @FXML
    private Button CreateCorporation;

    @FXML
    private Button CreateFee;

    @FXML
    private Button ManageUsers;

    @FXML
    private Button ManageOverdraft;

    @FXML
    private Button HireWorker;

    @FXML
    private Button PayEmployee;

    @FXML
    private Button ReplaceManager;

    @FXML
    private Button ManageAccounts;

    @FXML
    private Button CreateBank;

    @FXML
    private void onViewStats() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen22.fxml"));
        loadScene1(fxmlLoader1, width, height);
    }

    private void loadScene1(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) ViewStats.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onCreateCorporation() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen1.fxml"));
        loadScene2(fxmlLoader1, width, height);
    }

    private void loadScene2(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) CreateCorporation.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onCreateFee() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen9.fxml"));
        loadScene3(fxmlLoader1, width, height);
    }

    private void loadScene3(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) CreateFee.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onManageUsers() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen21.fxml"));
        loadScene4(fxmlLoader1, height, width);
    }

    private void loadScene4(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) ManageUsers.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onManageOverdraft() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen10.fxml"));
        loadScene5(fxmlLoader1, height, width);
    }

    private void loadScene5(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) ManageOverdraft.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onHireWorker() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen6_A.fxml"));
        loadScene6(fxmlLoader1, height, width);
    }

    private void loadScene6(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) HireWorker.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onPayEmployee() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene7(fxmlLoader1, height, width);
    }

    private void loadScene7(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) PayEmployee.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onReplaceManager() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen7.fxml"));
        loadScene8(fxmlLoader1, height, width);
    }

    private void loadScene8(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) ReplaceManager.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onManageAccounts() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen8_A.fxml"));
        loadScene9(fxmlLoader1, height, width);
    }

    private void loadScene9(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) ManageAccounts.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onCreateBank() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen1.fxml"));
        loadScene10(fxmlLoader1, height, width);
    }

    private void loadScene10(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) CreateBank.getScene().getWindow();
        stage1.setScene(scene1);
    }
}
