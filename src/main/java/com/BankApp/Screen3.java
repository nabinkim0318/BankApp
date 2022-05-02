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

public class Screen3 implements Initializable {
    @FXML
    private ComboBox<String> EmployeeID = new ComboBox<>();
    @FXML
    private TextField Salary;
    @FXML
    private TextField NumberOfPayments;
    @FXML
    private TextField AccumulatedEarnings;
    @FXML
    private Button Cancel;
    @FXML
    private Button Create;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initializeEmployeeID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void initializeEmployeeID() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select perID from customer where perID not in (select perID from employee);");
        while (set.next()) {
            list.add(set.getString(1));
        }
        EmployeeID.setItems(list);
    }

    @FXML
    private void onCancel() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Screen21.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Cancel.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onCreate() throws SQLException, IOException {
        CallableStatement statement = Connect.getConnection().prepareCall("{call start_employee_role(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
        statement.setString(1, EmployeeID.getValue());
        statement.setString(2, null);
        statement.setString(3, null);
        statement.setString(4, null);
        statement.setString(5, null);
        statement.setString(6, null);
        statement.setString(7, null);
        statement.setString(8, null);
        statement.setString(9, null);
        statement.setString(10, null);
        statement.setString(11, Salary.getText());
        statement.setString(12, NumberOfPayments.getText());
        statement.setString(13, AccumulatedEarnings.getText());
        statement.setString(14, null);
        statement.execute();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Screen21.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Create.getScene().getWindow();
        stage.setScene(scene);
    }
}
