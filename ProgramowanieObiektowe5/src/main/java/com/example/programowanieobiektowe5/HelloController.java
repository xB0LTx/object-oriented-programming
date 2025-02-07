package com.example.programowanieobiektowe5;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField inputTextField;

    @FXML
    private void onSubmitButtonClick() {
        try {
            String inputValue = inputTextField.getText();
            InputValidator.validateInput(inputValue);
            AlertHandler.showSuccessAlert("Wprowadzono liczbę 1!");
        } catch (InputExceptionHandler e) {
            AlertHandler.createAlertHandler(e.getMessage()).handle(null);
        }
    }
}
