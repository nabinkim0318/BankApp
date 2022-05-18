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

public class Screen16 implements Initializable {
    @FXML
    private TableView<Corporation> CorporationStats;
    @FXML
    private TableColumn<Corporation, String> CorporationID;
    @FXML
    private TableColumn<Corporation, String> ShortName;
    @FXML
    private TableColumn<Corporation, String> FormalName;
    @FXML
    private TableColumn<Corporation, String> NumberOfBanks;
    @FXML
    private TableColumn<Corporation, String> CorporationAssets;
    @FXML
    private TableColumn<Corporation, String> TotalAssets;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Corporation> list = FXCollections.observableArrayList();
        try {
            ResultSet set = Connect.getConnection().createStatement().executeQuery("select * from display_corporation_stats;");
            while (set.next()) {
                list.add(new Corporation(set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5),
                        set.getString(6)));
            }
            CorporationID.setCellValueFactory(new PropertyValueFactory("CorporationID"));
            ShortName.setCellValueFactory(new PropertyValueFactory("ShortName"));
            FormalName.setCellValueFactory(new PropertyValueFactory("FormalName"));
            NumberOfBanks.setCellValueFactory(new PropertyValueFactory("NumberOfBanks"));
            CorporationAssets.setCellValueFactory(new PropertyValueFactory("CorporationAssets"));
            TotalAssets.setCellValueFactory(new PropertyValueFactory("TotalAssets"));
            CorporationStats.setItems(list);
        } catch (SQLException e) {
        }
    }
}