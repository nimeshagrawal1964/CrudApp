package com.nimesh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/crud?useSSL=false";
        String user="root";
        String pass="";

        try {
            System.out.println("Attempting conn");
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("connection success");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
