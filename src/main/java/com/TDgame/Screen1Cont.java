package com.TDgame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class Screen1Cont {
    final int height = 600;
    final int width = 400;

    @FXML
    private Button Cancel;

    @FXML
    private Button Create;

    @FXML
    private TextField ReservedAssets;

    @FXML
    private TextField LongName;

    @FXML
    private TextField ShortName;

    @FXML
    private TextField CorporationID;

    @FXML
    private void onCancel() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen20.fxml"));
        loadScene1(fxmlLoader1, height, width);
    }

    private void loadScene1(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Cancel.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onCreate() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene2(fxmlLoader1, height, width);
    }

    private void loadScene2(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Create.getScene().getWindow();
        stage1.setScene(scene1);
    }
}
