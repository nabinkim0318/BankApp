package com.example.bankapp;

public class Customer {
    private String CustomerID;
    private String TaxID;
    private String CustomerName;
    private String DateOfBirth;
    private String JoinedDate;
    private String Street;
    private String City;
    private String State;
    private String Zip;
    private String NumberOfAccounts;
    private String CustomerAssets;

    public Customer(String customerID, String taxID, String customerName, String dateOfBirth, String joinedDate, String street, String city, String state, String zip, String numberOfAccounts, String customerAssets) {
        CustomerID = customerID;
        TaxID = taxID;
        CustomerName = customerName;
        DateOfBirth = dateOfBirth;
        JoinedDate = joinedDate;
        Street = street;
        City = city;
        State = state;
        Zip = zip;
        NumberOfAccounts = numberOfAccounts;
        CustomerAssets = customerAssets;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getTaxID() {
        return TaxID;
    }

    public void setTaxID(String taxID) {
        TaxID = taxID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getJoinedDate() {
        return JoinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        JoinedDate = joinedDate;
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

    public String getCustomerAssets() {
        return CustomerAssets;
    }

    public void setCustomerAssets(String customerAssets) {
        CustomerAssets = customerAssets;
    }
}
