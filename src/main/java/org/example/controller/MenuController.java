package org.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    public static Stage menuStage = null;

    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private HBox menuHBox;

    @FXML
    private AnchorPane usersAnchorPane;

    @FXML
    private AnchorPane freightMarketAnchorPane;

    @FXML
    private AnchorPane vehiclesAnchorPane;

    @FXML
    private AnchorPane driversAnchorPane;

    @FXML
    void switchToVehicles(MouseEvent event) throws IOException {

        this.vehiclesAnchorPane.getScene().getWindow().hide();
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/fxml/vehicles.fxml"));
        Scene scene = new Scene(root);
        Stage vehicleStage = new Stage();
        vehicleStage.setScene(scene);
        vehicleStage.show();
    }

    @FXML
    void switchToTickets(MouseEvent event) {

    }

    @FXML
    void switchToUsers(MouseEvent event) throws IOException{
        this.vehiclesAnchorPane.getScene().getWindow().hide();
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("/fxml/users.fxml"));
        Scene scene = new Scene(root);
        Stage userStage = new Stage();
        userStage.setScene(scene);
        userStage.show();
    }
}
