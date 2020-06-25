package org.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud {

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "first_name VARCHAR(45) NOT NULL,"
                + "last_name VARCHAR(45) NOT NULL,"
                + "email VARCHAR(45) NOT NULL,"
                + "password VARCHAR(45) NOT NULL,"
                + "confirm_password VARCHAR(45) NOT NULL"
                + ");";

        Connection connection = ConnectionDB.connect();
        Statement statement;

        try {
            statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void  insert(String firstName, String lastName, String email, String password, String confirmPassword) {
        String sql = "INSERT INTO users (first_name, last_name, email, password, confirm_password) VALUES(?,?,?,?,?)";
        Connection connection = ConnectionDB.connect();
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, confirmPassword);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void update(String firstName, String lastName, String email, String password) {
        String sql = "UPDATE users (firstName, lastName, email, password) VALUES(?,?,?,?)";
        Connection connection = ConnectionDB.connect();
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id =?)";
        Connection connection = ConnectionDB.connect();
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
