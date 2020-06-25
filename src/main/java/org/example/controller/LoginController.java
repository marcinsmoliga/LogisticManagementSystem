package org.example.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.database.ConnectionDB;
import org.example.database.Crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    @FXML
    private Label loginMsgLabel;

    @FXML
    private Pane signInPane;

    @FXML
    private JFXTextField emailTextField;

    @FXML
    private JFXPasswordField passwordTextField;

    @FXML
    private JFXButton loginButton;

    Crud crud = new Crud();


    public void initialize() {
    }

    @FXML
    private void loginButtonOnAction(ActionEvent actionEvent) {

        if (emailTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()) {
            loginMsgLabel.setText("Please enter email and password");

        } else {
            validateLogin();
        }
        try {
//
        } catch (Exception e) {
            System.out.println("error");

        }
    }

    public void validateLogin() {

        Connection connectDB = ConnectionDB.connect();
        System.out.println("Connected");
        String verifyLogin = "SELECT COUNT(1) FROM users WHERE email = '" + emailTextField.getText()
                + "' AND password = '" + passwordTextField.getText() + "'";


        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    System.out.println("SUCCESS");
                    showLoginWindow();
                } else {
                    loginMsgLabel.setText("Invalid login. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void openRegistrationForm(MouseEvent event) throws IOException {
        AnchorPane registrationPane = FXMLLoader.load(getClass().getResource("/fxml/registrationForm.fxml"));
        signInPane.getChildren().removeAll();
        signInPane.getChildren().setAll(registrationPane);
    }

    private void showLoginWindow() throws IOException {
        this.loginButton.getScene().getWindow().hide();
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/fxml/menu.fxml"));
        Scene scene = new Scene(root);
        Stage driverStage = new Stage();
        driverStage.setScene(scene);
        driverStage.show();
    }


//    @FXML
//    private void register(MouseEvent mouseEvent) {
//        crud.insert();
//    }
}
