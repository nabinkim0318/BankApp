package com.example.bankapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.Objects;

public class Screen1 {
    @FXML
    private TextField CorporationID;
    @FXML
    private TextField LongName;
    @FXML
    private TextField ShortName;
    @FXML
    private TextField ReservedAssets;
    @FXML
    private Button Cancel;
    @FXML
    private Button Create;

    @FXML
    private void onCancel() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen20.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Cancel.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onCreate() throws IOException {
        if (Objects.equals(CorporationID.getText(), "")) {
            CorporationID.setText(null);
        }
        if (Objects.equals(ShortName.getText(), "")) {
            ShortName.setText(null);
        }
        if (Objects.equals(LongName.getText(), "")) {
            LongName.setText(null);
        }
        if (Objects.equals(ReservedAssets.getText(), "")) {
            ReservedAssets.setText(null);
        }
        try {
            CallableStatement statement = Connect.getConnection().prepareCall("{call create_corporation(?, ?, ?, ?)}");
            statement.setString(1, CorporationID.getText());
            statement.setString(2, ShortName.getText());
            statement.setString(3, LongName.getText());
            statement.setString(4, ReservedAssets.getText());
            statement.execute();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen20.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Create.getScene().getWindow();
        stage.setScene(scene);
    }
}
