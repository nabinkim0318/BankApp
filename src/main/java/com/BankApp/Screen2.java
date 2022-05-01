package com.BankApp;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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

public class Screen2 implements Initializable {
    @FXML
    private TextField BankID;
    @FXML
    private TextField Name;
    @FXML
    private TextField Street;
    @FXML
    private TextField City;
    @FXML
    private TextField StateAbbr;
    @FXML
    private TextField ZipCode;
    @FXML
    private TextField ReservedAssets;
    @FXML
    private ComboBox<String> CorporationID = new ComboBox<>();
    @FXML
    private ComboBox<String> ManagerID = new ComboBox<>();
    @FXML
    private ComboBox<String> EmployeeID = new ComboBox<>();
    @FXML
    private Button Cancel;
    @FXML
    private Button Create;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initializeCorporationID();
            initializeManagerID();
            initializeEmployeeID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void initializeCorporationID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select corpID from corporation;");
        while (set.next()) {
            list.add(set.getString(1));
        }
        CorporationID.setItems(list);
    }

    private void initializeManagerID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select perID from employee where perID not in (select manager from bank) and perID not in (select perID from workFor);");
        while (set.next()) {
            list.add(set.getString(1));
        }
        ManagerID.setItems(list);
    }

    private void initializeEmployeeID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select perID from employee where perID not in (select manager from bank);");
        while (set.next()) {
            list.add(set.getString(1));
        }
        EmployeeID.setItems(list);
    }

    @FXML
    private void onCancel() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Screen20.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Cancel.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onCreate() throws SQLException, IOException {
        CallableStatement statement = Connect.getConnection().prepareCall("{call create_bank(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
        statement.setString(1, BankID.getText());
        statement.setString(2, Name.getText());
        statement.setString(3, Street.getText());
        statement.setString(4, City.getText());
        statement.setString(5, StateAbbr.getText());
        statement.setString(6, ZipCode.getText());
        statement.setString(7, ReservedAssets.getText());
        statement.setString(8, CorporationID.getValue());
        statement.setString(9, ManagerID.getValue());
        statement.setString(10, EmployeeID.getValue());
        statement.execute();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Screen20.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Create.getScene().getWindow();
        stage.setScene(scene);
    }
}
