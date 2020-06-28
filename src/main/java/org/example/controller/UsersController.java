package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.example.main.LoginApp;

import java.io.IOException;

public class UsersController {

    @FXML
    private Button homeButton;

    @FXML
    AnchorPane usersRootAnchorPane;

    @FXML
    void backToMenu(ActionEvent actionEvent) throws IOException {
        AnchorPane menuPane = FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
        usersRootAnchorPane.getChildren().removeAll();
        usersRootAnchorPane.getChildren().setAll(menuPane);


    }
}
