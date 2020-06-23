package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    final static String DATABASE_NAME = "transport_db";
    final static String DB_URL = "jdbc:mysql://localhost/" + DATABASE_NAME + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final static String USER = "root";
    final static String PASS = "";

    public static Connection connectDB() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("connected");
            return conn;
        } catch (Exception e) {
            System.out.println("ERRORcon");
            e.printStackTrace();
            return null;
        }
    }
}
