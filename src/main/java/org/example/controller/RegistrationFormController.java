package org.example.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.database.Crud;
import org.example.main.LoginApp;

import java.io.IOException;

public class RegistrationFormController {
    Crud crud = new Crud();

    @FXML
    private Label backLabel;

    @FXML
    private JFXTextField firstNameTextField;

    @FXML
    private JFXTextField lastNameTextField;

    @FXML
    private JFXPasswordField passwordTextField;

    @FXML
    private JFXTextField emailTextField;

    @FXML
    private JFXPasswordField confirmPasswordTextField;

    @FXML
    private JFXButton registerButton;

    @FXML
    private Label registerMsgLabel;

    @FXML
    public void registerButtonOnAction(javafx.event.ActionEvent actionEvent) {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        String confirmPassword = confirmPasswordTextField.getText();

        if (password.equals(confirmPassword)) {
            crud.createTable();
            crud.insert(firstName, lastName, email, password, confirmPassword);
        } else {
            registerMsgLabel.setText("Please make sure yours passwords match");
        }


    }

    @FXML
    void backToLogin(MouseEvent event) throws IOException {
        AnchorPane loginPane = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        LoginApp.stage.getScene().setRoot(loginPane);
    }
}
