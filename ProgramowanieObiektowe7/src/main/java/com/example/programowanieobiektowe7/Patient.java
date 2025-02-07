package com.example.programowanieobiektowe7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Comparator;

public class Patient {
    private final int id;
    private final String imie;
    private final String nazwisko;
    private final int wiek;

    public Patient(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.imie = firstName;
        this.nazwisko = lastName;
        this.wiek = age;
    }
    public int getId() {
        return id;
    }
    public String getFistName() {
        return imie;
    }
    public String getLastName() {
        return nazwisko;
    }
    public int getAge() {
        return wiek;
    }

    public static void export(ArrayList<Patient> patients, String mode) {
        switch (mode) {
            case "Imię" -> patients.sort(Comparator.comparing(Patient::getFistName));
            case "Nazwisko" -> patients.sort(Comparator.comparing(Patient::getLastName));
            case "Wiek" -> patients.sort(Comparator.comparingInt(Patient::getAge));
            case "Kolejności dodania" -> patients.sort(Comparator.comparingInt(Patient::getId));
            default -> {
                Utils.errorAlert("Nieznany tryb sortowania");
                return;
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(patients);
            Utils.prepareTerminal();
            System.out.println(json);
        } catch (JsonProcessingException e) {
            Utils.errorAlert("Nie udało się wyeksportować listy pacjentów");
        }
    }
}