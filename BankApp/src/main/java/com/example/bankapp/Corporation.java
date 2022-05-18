package com.example.bankapp;

public class Corporation {
    private String CorporationID;
    private String ShortName;
    private String FormalName;
    private String NumberOfBanks;
    private String CorporationAssets;
    private String TotalAssets;

    public Corporation(String corporationID, String shortName, String formalName, String numberOfBanks, String corporationAssets, String totalAssets) {
        CorporationID = corporationID;
        ShortName = shortName;
        FormalName = formalName;
        NumberOfBanks = numberOfBanks;
        CorporationAssets = corporationAssets;
        TotalAssets= totalAssets;
    }

    public String getCorporationID() {
        return CorporationID;
    }

    public void setCorporationID(String corporationID) {
        CorporationID = corporationID;
    }

    public String getShortName() {
        return ShortName;
    }

    public void setShortName(String shortName) {
        ShortName = shortName;
    }

    public String getFormalName() {
        return FormalName;
    }

    public void setFormalName(String formalName) {
        FormalName = formalName;
    }

    public String getNumberOfBanks() {
        return NumberOfBanks;
    }

    public void setNumberOfBanks(String numberOfBanks) {
        NumberOfBanks = numberOfBanks;
    }

    public String getCorporationAssets() {
        return CorporationAssets;
    }

    public void setCorporationAssets(String corporationAssets) {
        CorporationAssets = corporationAssets;
    }

    public String getTotalAssets() {
        return TotalAssets;
    }

    public void setTotalAssets(String totalAssets) {
        TotalAssets = totalAssets;
    }
}