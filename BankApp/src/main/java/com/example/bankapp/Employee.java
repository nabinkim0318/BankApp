package com.example.bankapp;

public class Employee {
    private String PersonID;
    private String TaxID;
    private String Name;
    private String DateOfBirth;
    private String DateJoined;
    private String Street;
    private String City;
    private String State;
    private String Zip;
    private String NumberOfBanks;
    private String BankAssets;

    public Employee(String personID, String taxID, String name, String dateOfBirth, String dateJoined, String street, String city, String state, String zip, String numberOfBanks, String bankAssets) {
        PersonID = personID;
        TaxID = taxID;
        Name = name;
        DateOfBirth = dateOfBirth;
        DateJoined = dateJoined;
        Street = street;
        City = city;
        State = state;
        Zip = zip;
        NumberOfBanks = numberOfBanks;
        BankAssets = bankAssets;
    }

    public String getPersonID() {
        return PersonID;
    }

    public void setPersonID(String personID) {
        PersonID = personID;
    }

    public String getTaxID() {
        return TaxID;
    }

    public void setTaxID(String taxID) {
        TaxID = taxID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getDateJoined() {
        return DateJoined;
    }

    public void setDateJoined(String dateJoined) {
        DateJoined = dateJoined;
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

    public String getNumberOfBanks() {
        return NumberOfBanks;
    }

    public void setNumberOfBanks(String numberOfBanks) {
        NumberOfBanks = numberOfBanks;
    }

    public String getBankAssets() {
        return BankAssets;
    }

    public void setBankAssets(String bankAssets) {
        BankAssets = bankAssets;
    }
}
