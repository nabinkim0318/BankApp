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

public class Screen14 implements Initializable {
    @FXML
    private TableView<Account> AccountStats;
    @FXML
    private TableColumn<Account, String> Bank;
    @FXML
    private TableColumn<Account, String> AccountID;
    @FXML
    private TableColumn<Account, String> Balance;
    @FXML
    private TableColumn<Account, String> NumberOfOwners;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Account> list = FXCollections.observableArrayList();
        try {
            ResultSet set = Connect.getConnection().createStatement().executeQuery("select * from display_account_stats;");
            while (set.next()) {
                list.add(new Account(set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4)));
            }
            Bank.setCellValueFactory(new PropertyValueFactory("Bank"));
            AccountID.setCellValueFactory(new PropertyValueFactory("AccountID"));
            Balance.setCellValueFactory(new PropertyValueFactory("Balance"));
            NumberOfOwners.setCellValueFactory(new PropertyValueFactory("NumberOfOwners"));
            AccountStats.setItems(list);
        } catch (SQLException e) {
        }
    }
}