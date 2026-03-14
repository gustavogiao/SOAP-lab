package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public static Connection getConnection() throws Exception {

        String url = "jdbc:mysql://localhost:3306/school";
        String user = "soapuser";
        String password = "soap123";

        return DriverManager.getConnection(url,user,password);
    }
}