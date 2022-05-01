package com.BankApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.ResultSet;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Screen20.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Cancel.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onCreate() throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Screen16.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Create.getScene().getWindow();
        stage.setScene(scene);
        CallableStatement statement = Connect.getConnection().prepareCall("{call create_corporation(?, ?, ?, ?)}");
        statement.setString(1, CorporationID.getText());
        statement.setString(2, ShortName.getText());
        statement.setString(3, LongName.getText());
        statement.setString(4, ReservedAssets.getText());
        statement.execute();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select * from corporation;");
        System.out.println(set.getString(1) + ", " +
                    set.getString(2) + ", " +
                    set.getString(3) + ", " +
                    set.getString(4));
        }
    }
