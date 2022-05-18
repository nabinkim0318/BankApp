package com.example.bankapp;

public class Bank {
    private String BankID;
    private String CorporationName;
    private String BankName;
    private String Street;
    private String City;
    private String State;
    private String Zip;
    private String NumberOfAccounts;
    private String BankAssets;
    private String TotalAssets;

    public Bank(String bankID, String corporationName, String bankName, String street, String city, String state, String zip, String numberOfAccounts, String bankAssets, String totalAssets) {
        BankID = bankID;
        CorporationName = corporationName;
        BankName = bankName;
        Street = street;
        City = city;
        State = state;
        Zip = zip;
        NumberOfAccounts = numberOfAccounts;
        BankAssets = bankAssets;
        TotalAssets = totalAssets;
    }

    public String getBankID() { return BankID; }

    public void setBankID(String bankID) {
        BankID = bankID;
    }

    public String getCorporationName() {
        return CorporationName;
    }

    public void setCorporationName(String corporationName) {
        CorporationName = corporationName;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        Zip = zip;
    }

    public String getNumberOfAccounts() {
        return NumberOfAccounts;
    }

    public void setNumberOfAccounts(String numberOfAccounts) {
        NumberOfAccounts = numberOfAccounts;
    }

    public String getBankAssets() {
        return BankAssets;
    }

    public void setBankAssets(String bankAssets) {
        BankAssets = bankAssets;
    }

    public String getTotalAssets() {
        return TotalAssets;
    }

    public void setTotalAssets(String totalAssets) {
        TotalAssets = totalAssets;
    }
}
