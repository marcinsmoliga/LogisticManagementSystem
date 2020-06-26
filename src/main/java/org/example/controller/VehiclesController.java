package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.main.LoginApp;
import org.example.model.Lorry;

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
    private Button searchButton;

    @FXML
    private TextField searchField;


    private final ObservableList<Lorry> lorriesList = FXCollections.observableArrayList();

    public void initialize() {
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("LORRY_ID"));
        vrnTableColumn.setCellValueFactory(new PropertyValueFactory<>("VRN"));
        mileageTableColumn.setCellValueFactory(new PropertyValueFactory<>("MILEAGE"));
        locationTableColumn.setCellValueFactory(new PropertyValueFactory<>("LOCATION"));

        Lorry lorry1 = new Lorry(1,"PKP1", 150_000, "Germany1");
        Lorry lorry2 = new Lorry(2,"PKP2", 250_000, "Germany2");
        Lorry lorry3 = new Lorry(3,"PKP3", 350_000, "Germany3");
        Lorry lorry4 = new Lorry(4,"PKP4", 450_000, "Germany4");
        Lorry lorry5 = new Lorry(5,"PKP5", 550_000, "Germany5");

        lorriesList.addAll(lorry1, lorry2, lorry3, lorry4, lorry5);

        FilteredList<Lorry> filteredData = new FilteredList<>(lorriesList, b -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(lorry -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if (lorry.getVRN().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true;
                } else if (lorry.getLOCATION().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return  true;
                } else if (String.valueOf(lorry.getMILEAGE()).indexOf(lowerCaseFilter) != -1) {
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
}
