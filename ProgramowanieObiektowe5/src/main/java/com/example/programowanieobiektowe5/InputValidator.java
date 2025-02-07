package com.example.programowanieobiektowe5;

public class InputValidator {

    public static void validateInput(String inputValue) throws InputExceptionHandler{
        if (inputValue.length() > 1) {
            throw new MultipleCharsException();
        }
        if (!inputValue.matches("\\d+")) {
            throw new WrongCharactersException();
        }
        if (!inputValue.equals("1")) {
            throw new WrongNumberException();
        }
    }
}
