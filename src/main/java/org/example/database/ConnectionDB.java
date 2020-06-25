package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    final static String DATABASE_NAME = "transport_db";
    final static String TIMEZONE_CONFIG = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final static String DB_URL = "jdbc:mysql://localhost/" + DATABASE_NAME + TIMEZONE_CONFIG;
    final static String USER = "root";
    final static String PASS = "";

    public static Connection connect() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("connectedDB");
        } catch (Exception e) {
            System.out.println("ERRORcon");
            e.printStackTrace();
        }
        return connection;
    }

    public static void close() {

    }
}
