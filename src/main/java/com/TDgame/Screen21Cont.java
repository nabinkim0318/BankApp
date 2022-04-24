package com.TDgame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Screen21Cont {
    final int height = 600;
    final int width = 400;

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
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen3.fxml"));
        loadScene1(fxmlLoader1, height, width);
    }

    private void loadScene1(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) CreateEmployee.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onCreateCustomer() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen4.fxml"));
        loadScene2(fxmlLoader1, height, width);
    }

    private void loadScene2(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) CreateCustomer.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onStopEmployee() throws IOException {
        FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("/views/Screen5_1.fxml"));
        loadScene1(fxmlLoader3, height, width);
    }

    private void loadScene3(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) StopEmployee.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onStopCustomer() throws IOException {
        FXMLLoader fxmlLoader4 = new FXMLLoader(getClass().getResource("/views/Screen5_2.fxml"));
        loadScene1(fxmlLoader4, height, width);
    }

    private void loadScene4(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) StopCustomer.getScene().getWindow();
        stage1.setScene(scene1);
    }
}
