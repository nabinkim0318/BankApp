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

public class Screen5_E implements Initializable {
    @FXML
    private ComboBox<String> EmployeeID = new ComboBox<>();
    @FXML
    private Button Back;
    @FXML
    private Button Confirm;

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
        ResultSet set = Connect.getConnection().createStatement().executeQuery("select perID from employee where perID not in (select manager from bank) and perID not in (select w1.perID from workFor as w1 where w1.bankID in (select w2.bankID from workFor as w2 group by w2.bankID having count(*) = 1));");
        while (set.next()) {
            list.add(set.getString(1));
        }
        EmployeeID.setItems(list);
    }

    @FXML
    private void onBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Screen21.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void onConfirm() throws SQLException, IOException {
        CallableStatement statement = Connect.getConnection().prepareCall("{call stop_employee_role(?)}");
        statement.setString(1, EmployeeID.getValue());
        statement.execute();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Screen21.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        Stage stage = (Stage) Confirm.getScene().getWindow();
        stage.setScene(scene);
    }
}