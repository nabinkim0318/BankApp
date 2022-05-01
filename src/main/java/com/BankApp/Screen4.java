package com.BankApp;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.CallableStatement;

public class Screen4 implements Initializable {
    @FXML
    private ComboBox<String> CustomerID = new ComboBox<>();
    @FXML
    private Button Back;
    @FXML
    private Button Confirm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initializeCustomerID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void initializeCustomerID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select perID from employee where perID not in (select perID from customer);");
        while (set.next()) {
            list.add(set.getString(1));
        }
        CustomerID.setItems(list);
    }

    @FXML
    private void onBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Screen20.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onConfirm() throws SQLException, IOException {
        CallableStatement statement = Connect.getConnection().prepareCall("{call start_customer_role(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
        statement.setString(1, CustomerID.getValue());
        statement.setString(2, null);
        statement.setString(3, null);
        statement.setString(4, null);
        statement.setString(5, null);
        statement.setString(6, null);
        statement.setString(7, null);
        statement.setString(8, null);
        statement.setString(9, null);
        statement.setString(10, null);
        statement.setString(11, null);
        statement.execute();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Screen20.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Confirm.getScene().getWindow();
        stage.setScene(scene);
    }
}
