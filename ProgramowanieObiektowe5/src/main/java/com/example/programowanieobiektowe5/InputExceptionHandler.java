package com.example.programowanieobiektowe5;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class InputExceptionHandler extends Exception{

    public InputExceptionHandler(String message) {
        super(message);
    }

}

