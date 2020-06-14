package org.example.controller;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class LoginController {

    @FXML
    private ImageView loginCarImg;

    @FXML
    private Button loginButton;

    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField passwordTextField;


    public void initialize() {
        ScaleTransition transition = new ScaleTransition(Duration.seconds(4.0D), this.loginCarImg);
        transition.setToX(2.0D);
        transition.setToY(2.0D);
        transition.setCycleCount(-1);
        transition.setAutoReverse(true);
        transition.play();
    }

    @FXML
    private void logIntoSystem(ActionEvent actionEvent) {
        try {
            this.loginButton.getScene().getWindow().hide();
            AnchorPane root = FXMLLoader.load(this.getClass().getResource("/fxml/menu.fxml"));
            Scene scene = new Scene(root);
            Stage driverStage = new Stage();
            driverStage.setScene(scene);
            driverStage.show();
        } catch (IOException e) {
            System.out.println("error");

        }
    }
}
