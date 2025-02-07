module com.example.ProgramowanieObiektowe3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.ProgramowanieObiektowe3 to javafx.fxml;
    exports com.example.ProgramowanieObiektowe3;
}