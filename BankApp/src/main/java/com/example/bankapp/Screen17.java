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

public class Screen17 implements Initializable {
    @FXML
    private TableView<Customer> CustomerStats;
    @FXML
    private TableColumn<Customer, String> CustomerID;
    @FXML
    private TableColumn<Customer, String> TaxID;
    @FXML
    private TableColumn<Customer, String> CustomerName;
    @FXML
    private TableColumn<Customer, String> DateOfBirth;
    @FXML
    private TableColumn<Customer, String> JoinedDate;
    @FXML
    private TableColumn<Customer, String> Street;
    @FXML
    private TableColumn<Customer, String> City;
    @FXML
    private TableColumn<Customer, String> State;
    @FXML
    private TableColumn<Customer, String> Zip;
    @FXML
    private TableColumn<Customer, String> NumberOfAccounts;
    @FXML
    private TableColumn<Customer, String> CustomerAssets;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Customer> list = FXCollections.observableArrayList();
        try {
            ResultSet set = Connect.getConnection().createStatement().executeQuery("select * from display_customer_stats;");
            while (set.next()) {
                list.add(new Customer(set.getString(1),
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
            CustomerID.setCellValueFactory(new PropertyValueFactory("CustomerID"));
            TaxID.setCellValueFactory(new PropertyValueFactory("TaxID"));
            CustomerName.setCellValueFactory(new PropertyValueFactory("CustomerName"));
            DateOfBirth.setCellValueFactory(new PropertyValueFactory("DateOfBirth"));
            JoinedDate.setCellValueFactory(new PropertyValueFactory("JoinedDate"));
            Street.setCellValueFactory(new PropertyValueFactory("Street"));
            City.setCellValueFactory(new PropertyValueFactory("City"));
            State.setCellValueFactory(new PropertyValueFactory("State"));
            Zip.setCellValueFactory(new PropertyValueFactory("Zip"));
            NumberOfAccounts.setCellValueFactory(new PropertyValueFactory("NumberOfAccounts"));
            CustomerAssets.setCellValueFactory(new PropertyValueFactory("CustomerAssets"));
            CustomerStats.setItems(list);
        } catch (SQLException e) {
        }
    }
}
