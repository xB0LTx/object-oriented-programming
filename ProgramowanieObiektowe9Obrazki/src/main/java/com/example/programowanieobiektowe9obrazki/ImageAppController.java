package com.example.programowanieobiektowe9obrazki;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class ImageAppController {

    @FXML
    private ImageView image_box;

    @FXML
    private Button image_button;

    @FXML
    private Label image_label;

    private File[] imageFiles;
    private int currentImageIndex = 0;

    @FXML
    private void initialize() {
        File imagesDirectory = new File("obrazki");
        imageFiles = imagesDirectory.listFiles();
    }

    public void init() {
        updateImageView();
    }

    @FXML
    private void handleDisplayButton(ActionEvent event) {
        currentImageIndex = (currentImageIndex + 1) % imageFiles.length;
        updateImageView();
    }

    private void updateImageView() {
        Image image = new Image(imageFiles[currentImageIndex].toURI().toString());
        image_box.setImage(image);
        image_label.setText("Obraz " + (currentImageIndex + 1) + " z " + imageFiles.length);
    }
}
