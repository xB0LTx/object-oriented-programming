package com.example.programowanieobiektowe5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Wyjątki");
            stage.setScene(scene);
            stage.setResizable(true);
            HelloController controller = fxmlLoader.getController();
            stage.show();
        } catch (IOException e) {
            AlertHandler.createAlertHandler("Error loading FXML: " + e.getMessage()).handle(null);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
