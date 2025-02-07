import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Random;

public class Window extends JFrame {
    int diamondCounter = 0;
    int attempts = 0;
    JButton btn1 = new JButton("Kliknij tutaj!!");
    JButton btn2 = new JButton("A może tutaj?!");
    JLabel label = new JLabel();
    JTextArea text = new JTextArea();
    Random rand = new Random();
    public Window(){
        System.out.println("Podaj imię gracza:");
        Scanner input = new Scanner(System.in);
        String str_input="";
        str_input = input.next();
        setLayout(new GridLayout(2, 2,10,10));
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAndDisplayResult(1);
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAndDisplayResult(0);
            }
        });
        add(btn1);
        add(btn2);
        add(label);
        add(text);
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Bomba czy Diament?! Gra: "+ str_input+", 20 prób.");
    }
    private void checkAndDisplayResult(int playerChoice) {
        int int_rand = rand.nextInt(2);

        if (int_rand == playerChoice) {
            diamondCounter++;
            text.setText("Szczęście uśmiechnęło się do ciebie! Wygrałeś diament <>!!!");
        } else {
            text.setText("Trafiłeś na bombę :c!!!");
        }

        attempts++;

        label.setText("Próba: " + attempts + ", Liczba diamentów: " + diamondCounter);

        if (attempts == 20) {
            endGame();
        }
    }
    private void endGame() {
        attempts=0;
        if (diamondCounter == 20) {
            text.setText("Gratulacje! Wygrałeś wszystkie diamenty!\nWciśnięcie któregokolwiek przycisku rozpoczyna nową grę.");
        } else {
            text.setText("Koniec gry. Zdobyłeś " + diamondCounter + " diamentów.\nWciśnięcie któregokolwiek przycisku rozpoczyna nową grę.");
        }
        diamondCounter=0;
    }



}
