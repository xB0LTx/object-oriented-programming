package com.example.programowanieobiektowe7;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	public static void successAlert(String message) {
		showAlert("Sukces!", message, Alert.AlertType.INFORMATION);
	}

	public static void errorAlert(String message) {
		showAlert("Błąd", message, Alert.AlertType.ERROR);
	}

	private static void showAlert(String title, String message, Alert.AlertType alertType) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	private static void printDateTime() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		System.out.println("Raport pacjentów: " + currentDateTime.format(formatter));
	}

	public static void prepareTerminal() {
		System.out.println("\n\n--------------------------------------------------");
		printDateTime();
		System.out.println("--------------------------------------------------");
	}

	public static void clearInputFields(TextField name, TextField surname, TextField age) {
		name.clear();
		surname.clear();
		age.clear();
	}

	public static boolean isValid(String name) {
		Pattern pattern = Pattern.compile("[A-ZĄĆĘŁŃÓŚŻŹ][a-ząćęłńóśżź]*");
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}
}
