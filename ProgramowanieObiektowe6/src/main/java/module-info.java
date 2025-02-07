module com.example.programowanieobiektowe6 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens com.example.programowanieobiektowe6 to javafx.fxml;
    exports com.example.programowanieobiektowe6;
}