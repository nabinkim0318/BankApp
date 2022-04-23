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
    private Button HireWorker;

    @FXML
    private Button PayEmployee;

    @FXML
    private Button A;

    @FXML
    private Button B;

    @FXML
    private Button C;


    @FXML
    private void onHireWorker() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen6.fxml"));
        loadScene1(fxmlLoader1, height, width);
    }

    private void loadScene1(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) HireWorker.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onPayEmployee() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene2(fxmlLoader1, height, width);
    }

    private void loadScene2(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) PayEmployee.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onA() throws IOException {
        FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("/views/Screen6.fxml"));
        loadScene1(fxmlLoader3, height, width);
    }

    private void loadScene3(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) HireWorker.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onB() throws IOException {
        FXMLLoader fxmlLoader4 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene1(fxmlLoader4, height, width);
    }

    private void loadScene4(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) PayEmployee.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onC() throws IOException {
        FXMLLoader fxmlLoader4 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene1(fxmlLoader4, height, width);
    }

    private void loadScene5(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) PayEmployee.getScene().getWindow();
        stage1.setScene(scene1);
    }
}
