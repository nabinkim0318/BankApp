package com.example.bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management", "root", "Bohong264664");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static String ID;

    public static Connection getConnection() {
        return connection;
    }

    public static String getID() { return ID; }

    public static void setID(String id) { ID = id; }
}
