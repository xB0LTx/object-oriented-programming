module com.example.programowanieobiektowe9obrazki {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens com.example.programowanieobiektowe9obrazki to javafx.fxml;
    exports com.example.programowanieobiektowe9obrazki;
}