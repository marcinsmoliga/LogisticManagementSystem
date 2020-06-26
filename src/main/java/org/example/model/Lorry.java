package org.example.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Lorry {
    private final SimpleIntegerProperty LORRY_ID;
    private final SimpleStringProperty VRN;
    private final SimpleIntegerProperty MILEAGE;
//    private final SimpleDateFormat PURCHASE_DATE;
    private final SimpleStringProperty LOCATION;

    public Lorry(int id, String vrn, int mileage, String location) {
        this.LORRY_ID = new SimpleIntegerProperty(id);
        this.VRN = new SimpleStringProperty(vrn);
        this.MILEAGE = new SimpleIntegerProperty(mileage);
//        this.PURCHASE_DATE = new Date(purchaseDate);
        this.LOCATION = new SimpleStringProperty(location);
    }

    public int getLORRY_ID() {
        return LORRY_ID.get();
    }

    public SimpleIntegerProperty LORRY_IDProperty() {
        return LORRY_ID;
    }

    public void setLORRY_ID(int LORRY_ID) {
        this.LORRY_ID.set(LORRY_ID);
    }

    public String getVRN() {
        return VRN.get();
    }

    public SimpleStringProperty VRNProperty() {
        return VRN;
    }

    public void setVRN(String VRN) {
        this.VRN.set(VRN);
    }

    public int getMILEAGE() {
        return MILEAGE.get();
    }

    public SimpleIntegerProperty MILEAGEProperty() {
        return MILEAGE;
    }

    public void setMILEAGE(int MILEAGE) {
        this.MILEAGE.set(MILEAGE);
    }

    public String getLOCATION() {
        return LOCATION.get();
    }

    public SimpleStringProperty LOCATIONProperty() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION.set(LOCATION);
    }
}
