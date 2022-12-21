package com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko;

import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Model.Spieler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class SpielfeldController {


    @FXML
    private ImageView field_image;

    @FXML
    private StackPane stack_field;

    @FXML
    private AnchorPane playable_field;

    @FXML
    private Button start_play;


    public void initialize(){
        Image img = new Image(String.valueOf(SpielfeldController.class.getResource("field1.png")));
        Image spieler = new Image(String.valueOf(SpielfeldController.class.getResource("QAT_akramafif.png")));

        field_image.setImage(img);
        field_image.setPreserveRatio(false);

        //Mannschaft Klasse, durch Schleife werden beide in dieser Klasse initialisiert
        Spieler s = new Spieler(playable_field, "LV", false);
        Spieler s2 = new Spieler(playable_field, "LV", true);

        Spieler s10 = new Spieler(playable_field, "RV", false);
        Spieler s20 = new Spieler(playable_field, "RV", true);

        Spieler s4 = new Spieler(playable_field, "LM", false);
        Spieler s5 = new Spieler(playable_field, "LM", true);

        Spieler sd = new Spieler(playable_field, "ZM", false);
        Spieler sd2 = new Spieler(playable_field, "ZM", true);

        Spieler sd234 = new Spieler(playable_field, "RM", false);
        Spieler sd22 = new Spieler(playable_field, "RM", true);

        Spieler torwart = new Spieler(playable_field, "TW", false);
        Spieler torwart2 = new Spieler(playable_field, "TW", true);

        Spieler torwart4 = new Spieler(playable_field, "ST", false);
        Spieler torwart24 = new Spieler(playable_field, "ST", true);




    }

    @FXML
    void play_click(ActionEvent event) {
        start_play.setVisible(false);
    }
}
