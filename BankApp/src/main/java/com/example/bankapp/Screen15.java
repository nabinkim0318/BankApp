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

public class Screen15 implements Initializable {
    @FXML
    private TableView<Bank> BankStats;
    @FXML
    private TableColumn<Bank, String> BankID;
    @FXML
    private TableColumn<Bank, String> CorporationName;
    @FXML
    private TableColumn<Bank, String> BankName;
    @FXML
    private TableColumn<Bank, String> Street;
    @FXML
    private TableColumn<Bank, String> City;
    @FXML
    private TableColumn<Bank, String> State;
    @FXML
    private TableColumn<Bank, String> Zip;
    @FXML
    private TableColumn<Bank, String> NumberOfAccounts;
    @FXML
    private TableColumn<Bank, String> BankAssets;
    @FXML
    private TableColumn<Bank, String> TotalAssets;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Bank> list = FXCollections.observableArrayList();
        try {
            ResultSet set = Connect.getConnection().createStatement().executeQuery("select * from display_bank_stats;");
            while (set.next()) {
                list.add(new Bank(set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5),
                        set.getString(6),
                        set.getString(7),
                        set.getString(8),
                        set.getString(9),
                        set.getString(10)));
            }
            BankID.setCellValueFactory(new PropertyValueFactory("BankID"));
            CorporationName.setCellValueFactory(new PropertyValueFactory("CorporationName"));
            BankName.setCellValueFactory(new PropertyValueFactory("BankName"));
            Street.setCellValueFactory(new PropertyValueFactory("Street"));
            City.setCellValueFactory(new PropertyValueFactory("City"));
            State.setCellValueFactory(new PropertyValueFactory("State"));
            Zip.setCellValueFactory(new PropertyValueFactory("Zip"));
            NumberOfAccounts.setCellValueFactory(new PropertyValueFactory("NumberOfAccounts"));
            BankAssets.setCellValueFactory(new PropertyValueFactory("BankAssets"));
            TotalAssets.setCellValueFactory(new PropertyValueFactory("TotalAssets"));
            BankStats.setItems(list);
        } catch (SQLException e) {
        }
    }
}