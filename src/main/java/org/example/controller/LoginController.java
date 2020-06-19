package org.example.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class LoginController {

    @FXML
    private Label registrationLabel;

    @FXML
    private Pane signInPane;

    @FXML
    private ImageView loginCarImg;

    @FXML
    private JFXButton loginButton;




    public void initialize() {
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

//    @FXML
//    void openRegistrationForm(MouseEvent event) throws IOException {
//        AnchorPane registrationPane = FXMLLoader.load(getClass().getResource("/fxml/registrationForm.fxml"));
//        signInPane.getChildren().removeAll();
//        signInPane.getChildren().setAll(fxml);
//    }
}
