package com.example.ProgramowanieObiektowe3;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.Arrays;


public class HelloController implements Initializable {

    @FXML
    private Button button00;

    @FXML
    private Button button01;

    @FXML
    private Button button02;

    @FXML
    private Button button10;

    @FXML
    private Button button11;

    @FXML
    private Button button12;

    @FXML
    private Button button20;

    @FXML
    private Button button21;

    @FXML
    private Button button22;

    @FXML
    private Button button_reset;

    @FXML
    private Text winnerText;

    private int playerTurn = 0;

    ArrayList<Button> buttons;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button00,button01,button02,button10,button11,button12,button20,button21,button22));
        buttons.forEach(button ->{
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    @FXML
    void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        gameEnd(false);
        winnerText.setText("Nowa gra rozpoczęta!");
    }

    public void resetButton(Button button){
        button.setDisable(false);
        button.setText("");
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            checkIfGameIsOver();
        });
    }
    private void gameEnd(boolean bool){
        for (Button button : buttons) {
            button.setDisable(bool);
        }
    }
    public void setPlayerSymbol(Button button){
        if(playerTurn % 2 == 0){
            button.setText("X");
            playerTurn = 1;
        } else{
            button.setText("O");
            playerTurn = 0;
        }
    }

    public void checkIfGameIsOver(){
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> button00.getText() + button01.getText() + button02.getText();
                case 1 -> button10.getText() + button11.getText() + button12.getText();
                case 2 -> button20.getText() + button21.getText() + button22.getText();
                case 3 -> button00.getText() + button10.getText() + button20.getText();
                case 4 -> button01.getText() + button11.getText() + button21.getText();
                case 5 -> button02.getText() + button12.getText() + button22.getText();
                case 6 -> button00.getText() + button11.getText() + button22.getText();
                case 7 -> button02.getText() + button11.getText() + button20.getText();
                default -> null;
            };

            if (line.equals("XXX")) {
                winnerText.setText("Wygrał X! Gratulacje:)");
                gameEnd(true);
            }
            else if (line.equals("OOO")) {
                winnerText.setText("Wygrał O! Gratulacje:)");
                gameEnd(true);
            }
        }

    }
}