package com.BankApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class Screen8_ACont {
    final int height = 600;
    final int width = 400;

    @FXML
    private Button Cancel;

    @FXML
    private Button Create;

    @FXML
    private ComboBox<String> Bank;

    @FXML
    protected void initializeBank() {
        ObservableList<String> BankList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        Bank.setItems(BankList);
    }

    @FXML
    private ComboBox<String> AccountID;

    @FXML
    protected void initializeAccountID() {
        ObservableList<String> AccountIDList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        AccountID.setItems(AccountIDList);
    }

    @FXML
    private ComboBox<String> AccountType;

    @FXML
    protected void initializeAccountType() {
        ObservableList<String> AccountTypeList =
                FXCollections.observableArrayList("Easy", "Medium", "Hard");
        AccountType.setItems(AccountTypeList);
    }

    @FXML
    private TextField InitialBalance;

    @FXML
    private TextField MinBalance;

    @FXML
    private TextField MaxWithdrawals;

    @FXML
    private TextField InterestRate;

    @FXML
    private void onCreate() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen6.fxml"));
        loadScene1(fxmlLoader1, height, width);
    }

    private void loadScene1(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Create.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onCancel() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen20.fxml"));
        loadScene2(fxmlLoader1, height, width);
    }

    private void loadScene2(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Cancel.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onBank() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene3(fxmlLoader1, height, width);
    }

    private void loadScene3(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) Bank.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onAccountID() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene4(fxmlLoader1, height, width);
    }

    private void loadScene4(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) AccountID.getScene().getWindow();
        stage1.setScene(scene1);
    }

    @FXML
    private void onAccountType() throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/views/Screen13.fxml"));
        loadScene5(fxmlLoader1, height, width);
    }

    private void loadScene5(FXMLLoader fxml, int width, int height) throws IOException {
        Scene scene1 = new Scene(fxml.load(), width, height);
        Stage stage1 = (Stage) AccountType.getScene().getWindow();
        stage1.setScene(scene1);
    }
}
