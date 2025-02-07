package com.example.programowanieobiektowe6;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloController {

    @FXML
    private TextArea textArea;

    @FXML
    private void handleSaveToFile() {
        String content = textArea.getText();
        saveToFile("tekst.txt", content);
    }

    @FXML
    private void handleLoadFromFile() {
        String content = loadFromFile("tekst.txt");
        textArea.setText(content);
    }

    private void saveToFile(String fileName, String content) {
        Path filePath = Paths.get(fileName);
        try {
            Files.write(filePath, content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String loadFromFile(String fileName) {
        Path filePath = Paths.get(fileName);
        try {
            if (Files.exists(filePath)) {
                return new String(Files.readAllBytes(filePath));
            } else {
                return "Plik nie istnieje!";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Błąd odczytu pliku!";
        }
    }
}
