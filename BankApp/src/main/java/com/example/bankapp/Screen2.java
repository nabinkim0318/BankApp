package com.example.bankapp;

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
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.Objects;
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
        CorporationID.getSelectionModel().selectFirst();
    }

    private void initializeManagerID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select perID from employee where perID not in (select manager from bank) and perID not in (select perID from workFor);");
        while (set.next()) {
            list.add(set.getString(1));
        }
        ManagerID.setItems(list);
        ManagerID.getSelectionModel().selectFirst();
    }

    private void initializeEmployeeID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select perID from employee where perID not in (select manager from bank);");
        while (set.next()) {
            list.add(set.getString(1));
        }
        EmployeeID.setItems(list);
        EmployeeID.getSelectionModel().selectFirst();
    }

    @FXML
    private void onCancel() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen20.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Cancel.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onCreate() throws IOException {
        if (Objects.equals(BankID.getText(), "")) {
            BankID.setText(null);
        }
        if (Objects.equals(Name.getText(), "")) {
            Name.setText(null);
        }
        if (Objects.equals(Street.getText(), "")) {
            Street.setText(null);
        }
        if (Objects.equals(City.getText(), "")) {
            City.setText(null);
        }
        if (Objects.equals(StateAbbr.getText(), "")) {
            StateAbbr.setText(null);
        }
        if (Objects.equals(ZipCode.getText(), "")) {
            ZipCode.setText(null);
        }
        if (Objects.equals(ReservedAssets.getText(), "")) {
            ReservedAssets.setText(null);
        }
        try {
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
        } catch (SQLException e){
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
