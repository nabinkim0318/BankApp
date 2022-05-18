package com.example.bankapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.util.Objects;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class Screen19 {
    @FXML
    private TextField ID;
    @FXML
    private TextField Password;
    @FXML
    private Button Login;

    @FXML
    private void onLogin() throws IOException {
        if (Objects.equals(ID.getText(), "")) {
            ID.setText(null);
        }
        if (Objects.equals(Password.getText(), "")) {
            Password.setText(null);
        }
        try {
            ResultSet set;
            ArrayList<String> admin = new ArrayList<>();
            ArrayList<String> manager = new ArrayList<>();
            ArrayList<String> customer = new ArrayList<>();
            set = Connect.getConnection().createStatement().executeQuery("select perID from system_admin;");
            while (set.next()) {
                admin.add(set.getString(1));
            }
            set = Connect.getConnection().createStatement().executeQuery("select manager from bank;");
            while (set.next()) {
                manager.add(set.getString(1));
            }
            set = Connect.getConnection().createStatement().executeQuery("select perID from customer;");
            while (set.next()) {
                customer.add(set.getString(1));
            }
            set = Connect.getConnection().createStatement().executeQuery("select perID, pwd from person;");
            String password = "";
            while (set.next()) {
                if (set.getString(1).equals(ID.getText())) {
                    password = set.getString(2);
                }
            }
            Connect.setID(ID.getText());
            if (admin.contains(ID.getText()) && Password.getText().equals(password)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen20.fxml"));
                Scene scene = new Scene(loader.load(), 600, 400);
                Stage stage = (Stage) Login.getScene().getWindow();
                stage.setScene(scene);
            } else if (manager.contains(ID.getText()) && Password.getText().equals(password)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen23.fxml"));
                Scene scene = new Scene(loader.load(), 600, 400);
                Stage stage = (Stage) Login.getScene().getWindow();
                stage.setScene(scene);
            } else if (customer.contains(ID.getText()) && Password.getText().equals(password)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen24.fxml"));
                Scene scene = new Scene(loader.load(), 600, 400);
                Stage stage = (Stage) Login.getScene().getWindow();
                stage.setScene(scene);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Incorrect ID or Password");
                alert.show();
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
