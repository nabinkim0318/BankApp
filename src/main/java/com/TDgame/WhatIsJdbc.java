package com.TDgame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class WhatIsJdbc {
    public static void main(String[] args) throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management", "root", "{your password}");
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery("select * from person");
        while (rs.next()) {
            System.out.println(rs.getString(1) + "  " + rs.getString(2));
        }
        c.close();
    }
}

