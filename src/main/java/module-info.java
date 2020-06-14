module LogisticManagementSystem {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    exports org.example.main to javafx.graphics;
    opens org.example.controller to javafx.fxml;
}