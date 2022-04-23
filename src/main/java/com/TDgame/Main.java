package com.TDgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage mainStage;
    final int height = 600;
    final int width = 400;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/Screen23.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle("BankApp");
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void main(String[] args) {
        launch();
    }
}