package com.TDgame;
//package com.javaguides.javafx.registration;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Parent;

public class Main extends Application {
    private static Stage mainStage;
    final int height = 600;
    final int width = 400;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/Screen21.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), height, width); //"/views/Screen24.fxml"
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