module com.example.programowanieobiektowe5 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens com.example.programowanieobiektowe5 to javafx.fxml;
    exports com.example.programowanieobiektowe5;
}