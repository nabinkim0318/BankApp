package com.example.bankapp;

public class Account {
    private String Bank;
    private String AccountID;
    private String Balance;
    private String NumberOfOwners;

    public Account(String bank, String accountID, String balance, String numberOfOwners) {
        Bank = bank;
        AccountID = accountID;
        Balance = balance;
        NumberOfOwners = numberOfOwners;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public String getAccountID() {
        return AccountID;
    }
    public void setAccountID(String accountID) {
        AccountID = accountID;
    }
    public String getBalance() {
        return Balance;
    }
    public void setBalance(String balance) {
        Balance = balance;
    }
    public String getNumberOfOwners() {
        return NumberOfOwners;
    }
    public void setNumberOfOwners(String numberOfOwners) {
        NumberOfOwners = numberOfOwners;
    }
}
