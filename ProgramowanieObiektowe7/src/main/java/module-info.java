module com.example.programowanieobiektowe7 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens com.example.programowanieobiektowe7 to javafx.fxml;
    exports com.example.programowanieobiektowe7;
}