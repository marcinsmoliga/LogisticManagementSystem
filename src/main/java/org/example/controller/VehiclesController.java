package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.example.main.LoginApp;
import org.example.model.Lorry;

import java.io.IOException;

public class VehiclesController {

    @FXML
    private TableView<Lorry> lorryTableView;

    @FXML
    private TableColumn<Lorry, String> idTableColumn;

    @FXML
    private TableColumn<Lorry, String> vrnTableColumn;

    @FXML
    private TableColumn<Lorry, String> mileageTableColumn;

    @FXML
    private TableColumn<Lorry, String> purchaseTableColumn;

    @FXML
    private TableColumn<Lorry, String> locationTableColumn;

    @FXML
    private TextField searchField;

    @FXML
    private AnchorPane vehiclesRootAnchorPane;


    private final ObservableList<Lorry> lorriesList = FXCollections.observableArrayList();

    public void initialize() {
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("LORRY_ID"));
        vrnTableColumn.setCellValueFactory(new PropertyValueFactory<>("VRN"));
        mileageTableColumn.setCellValueFactory(new PropertyValueFactory<>("MILEAGE"));
        locationTableColumn.setCellValueFactory(new PropertyValueFactory<>("LOCATION"));

        Lorry lorry1 = new Lorry(1,"PKP1", 150_000, "Germany1");
        Lorry lorry2 = new Lorry(2,"PKP2", 250_000, "France2");
        Lorry lorry3 = new Lorry(3,"PKP3", 350_000, "Poland3");
        Lorry lorry4 = new Lorry(4,"PKP4", 450_000, "Spain4");
        Lorry lorry5 = new Lorry(5,"PKP5", 550_000, "Croatia5");

        lorriesList.addAll(lorry1, lorry2, lorry3, lorry4, lorry5);

        FilteredList<Lorry> filteredData = new FilteredList<>(lorriesList, b -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(lorry -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if (lorry.getVRN().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (lorry.getLOCATION().toLowerCase().contains(lowerCaseFilter)) {
                    return  true;
                } else if (String.valueOf(lorry.getMILEAGE()).contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Lorry> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(lorryTableView.comparatorProperty());
        lorryTableView.setItems(sortedData);
    }

    public void backToMenu(ActionEvent actionEvent) throws IOException {
        AnchorPane menuPane = FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
        vehiclesRootAnchorPane.getChildren().removeAll();
        vehiclesRootAnchorPane.getChildren().setAll(menuPane);
    }
}
