package com.BankApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Screen13Cont {
    final int height = 600;
    final int width = 400;

    @FXML
    private Button PayAll;

    //Should not move to another screen
    @FXML
    private void onPayAll() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen5.fxml"));
        loadScene1(fxmlLoader1, height, width);
    }

    private void loadScene1(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) PayAll.getScene().getWindow();
        stage1.setScene(scene1);
    }
}
