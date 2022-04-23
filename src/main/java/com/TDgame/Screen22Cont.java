package com.TDgame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Screen22Cont {
    final int height = 600;
    final int width = 400;

    @FXML
    private Button AccountStats;

    @FXML
    private Button CorporationStats;

    @FXML
    private Button BankStats;

    @FXML
    private Button CustomerStats;

    @FXML
    private Button EmployeeStats;


    @FXML
    private void onAccountStats() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen6.fxml"));
        loadScene1(fxmlLoader1, height, width);
    }

    private void loadScene1(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) AccountStats.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onCorporationStats() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene2(fxmlLoader1, height, width);
    }

    private void loadScene2(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) CorporationStats.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onBankStats() throws IOException {
        FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("/views/Screen6.fxml"));
        loadScene3(fxmlLoader3, height, width);
    }

    private void loadScene3(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) BankStats.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onCustomerStats() throws IOException {
        FXMLLoader fxmlLoader4 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene4(fxmlLoader4, height, width);
    }

    private void loadScene4(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) CustomerStats.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onEmployeeStats() throws IOException {
        FXMLLoader fxmlLoader4 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene5(fxmlLoader4, height, width);
    }

    private void loadScene5(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) EmployeeStats.getScene().getWindow();
        stage1.setScene(scene1);
    }
}
