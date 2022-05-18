package com.example.bankapp;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Screen18 implements Initializable {
    @FXML
    private TableView<Employee> EmployeeStats;
    @FXML
    private TableColumn<Employee, String> PersonID;
    @FXML
    private TableColumn<Employee, String> TaxID;
    @FXML
    private TableColumn<Employee, String> Name;
    @FXML
    private TableColumn<Employee, String> DateOfBirth;
    @FXML
    private TableColumn<Employee, String> DateJoined;
    @FXML
    private TableColumn<Employee, String> Street;
    @FXML
    private TableColumn<Employee, String> City;
    @FXML
    private TableColumn<Employee, String> State;
    @FXML
    private TableColumn<Employee, String> Zip;
    @FXML
    private TableColumn<Employee, String> NumberOfBanks;
    @FXML
    private TableColumn<Employee, String> BankAssets;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Employee> list = FXCollections.observableArrayList();
        try {
            ResultSet set = Connect.getConnection().createStatement().executeQuery("select * from display_employee_stats;");
            while (set.next()) {
                list.add(new Employee(set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5),
                        set.getString(6),
                        set.getString(7),
                        set.getString(8),
                        set.getString(9),
                        set.getString(10),
                        set.getString(11)));
            }
            PersonID.setCellValueFactory(new PropertyValueFactory("PersonID"));
            TaxID.setCellValueFactory(new PropertyValueFactory("TaxID"));
            Name.setCellValueFactory(new PropertyValueFactory("Name"));
            DateOfBirth.setCellValueFactory(new PropertyValueFactory("DateOfBirth"));
            DateJoined.setCellValueFactory(new PropertyValueFactory("DateJoined"));
            Street.setCellValueFactory(new PropertyValueFactory("Street"));
            City.setCellValueFactory(new PropertyValueFactory("City"));
            State.setCellValueFactory(new PropertyValueFactory("State"));
            Zip.setCellValueFactory(new PropertyValueFactory("Zip"));
            NumberOfBanks.setCellValueFactory(new PropertyValueFactory("NumberOfBanks"));
            BankAssets.setCellValueFactory(new PropertyValueFactory("BankAssets"));
            EmployeeStats.setItems(list);
        } catch (SQLException e) {
        }
    }
}