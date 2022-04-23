package com.TDgame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import java.io.IOException;

public class Screen5_1Cont {
    final int height = 600;
    final int width = 400;

    @FXML
    private Button Confirm;

    @FXML
    private Button Back;

    @FXML
    private MenuButton EmployeeID;

    @FXML
    private void onConfirm() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen6.fxml"));
        loadScene1(fxmlLoader1, height, width);
    }

    private void loadScene1(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Confirm.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onBack() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene2(fxmlLoader1, height, width);
    }

    private void loadScene2(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Back.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onEmployeeID() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene3(fxmlLoader1, height, width);
    }

    private void loadScene3(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) EmployeeID.getScene().getWindow();
        stage1.setScene(scene1);
    }
}