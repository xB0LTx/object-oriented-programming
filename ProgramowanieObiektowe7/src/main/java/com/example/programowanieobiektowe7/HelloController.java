package com.example.programowanieobiektowe7;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static com.example.programowanieobiektowe7.Utils.clearInputFields;
import static com.example.programowanieobiektowe7.Utils.isValid;

public class HelloController {

    @FXML
    public TextField name, surname, age;
    @FXML
    public ChoiceBox<String> sortBox;
    public final ArrayList<Patient> patientsList = new ArrayList<>();

    public void initialize() {
        sortBox.getItems().addAll("Imię", "Nazwisko", "Wiek", "Kolejności dodania");
        sortBox.setValue("Kolejności dodania");
    }

    @FXML
    public void handleAdd() {
        String firstName = name.getText();
        firstName = firstName.strip();
        String lastName = surname.getText();
        lastName = lastName.strip();
        String ageText = age.getText();
        ageText = ageText.strip();

        if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty()) {
            Utils.errorAlert("Wszystkie pola muszą być wypełnione");
            return;
        }

        if (!isValid(firstName)) {
            Utils.errorAlert("Imię musi zaczynać się z wielkiej litery i nie może zawierać cyfr oraz znaków specjalnych");
            return;
        }

        if (!isValid(lastName)) {
            Utils.errorAlert("Nazwisko musi zaczynać się z wielkiej litery i nie może zawierać cyfr oraz znaków specjalnych");
            return;
        }

        int ageValue;
        try {
            ageValue = Integer.parseInt(ageText);
            if (ageValue < 0 || ageValue > 150) {
                Utils.errorAlert("Wiek musi być liczbą z przedziału 0-150");
                return;
            }
        } catch (NumberFormatException e) {
            Utils.errorAlert("Wprowadzony wiek nie jest poprawną liczbą całkowitą");
            return;
        }

        Patient patient = new Patient(patientsList.size() + 1, firstName, lastName, ageValue);
        patientsList.add(patient);
        Utils.successAlert("Pacjent dodany pomyślnie!");

        clearInputFields(name, surname, age);
    }

    @FXML
    public void handlePrint() {
        if (patientsList.isEmpty()) {
            Utils.errorAlert("Lista pacjentów jest pusta");
            return;
        }

        try {
            Patient.export(patientsList, sortBox.getValue());
            Utils.successAlert("Lista pacjentów wyeksportowana pomyślnie!");
        } catch (Exception e) {
            Utils.errorAlert("Nie udało się wyeksportować listy pacjentów");
        }
    }
}
