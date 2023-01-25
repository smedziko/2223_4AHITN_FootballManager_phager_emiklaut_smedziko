package com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Controller;

import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.HelloApplication;
import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Model.Ball;
import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Model.Spieler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class SpielfeldController {

    boolean cover = false;

    @FXML
    private ImageView field_image;

    @FXML
    private StackPane stack_field;

    @FXML
    private AnchorPane playable_field;

    @FXML
    private Button start_play;


    @FXML
    private Button toggle_cover;



    public void initialize(){
        Image img = new Image(String.valueOf(HelloApplication.class.getResource("field1.png")));
        Image spieler = new Image(String.valueOf(HelloApplication.class.getResource("QAT_akramafif.png")));

        field_image.setImage(img);
        field_image.setPreserveRatio(false);

        //Mannschaft Klasse, durch Schleife werden beide in dieser Klasse initialisiert
        Spieler s = new Spieler(playable_field, "LV", false,2312);
        Spieler s2 = new Spieler(playable_field, "LV", true,234);

        Spieler s10 = new Spieler(playable_field, "RV", false,32423);
        Spieler s20 = new Spieler(playable_field, "RV", true,342);

        Spieler s4 = new Spieler(playable_field, "LM", false,32423);
        Spieler s5 = new Spieler(playable_field, "LM", true,11);

        Spieler sd = new Spieler(playable_field, "ZM", false,10);
        Spieler sd2 = new Spieler(playable_field, "ZM", true,2);

        Spieler sd234 = new Spieler(playable_field, "RM", false,21);
        Spieler sd22 = new Spieler(playable_field, "RM", true,23);

        Spieler torwart = new Spieler(playable_field, "TW", false,2);
        Spieler torwart2 = new Spieler(playable_field, "TW", true,1);

        Spieler torwart4 = new Spieler(playable_field, "ST", false,12);
        Spieler torwart24 = new Spieler(playable_field, "ST", true,234);



    }

    @FXML
    void play_click(ActionEvent event) {
        start_play.setVisible(false);

        Circle ball = new Circle();
        ball.setRadius(14);
        Image img = new Image(String.valueOf(SpielfeldController.class.getResource("QAT_akramafif.png")));
        ball.setFill(new ImagePattern(img));
        ball.setLayoutX(417);
        ball.setLayoutY(298);
        playable_field.getChildren().add(ball);
        Ball.setBall(ball);

        for (Spieler s : Spieler.getTeam()) {
            s.setBall(ball);
            s.getMove().start();
        }

        for(Spieler s : Spieler.getEnemyteam()){
            s.setBall(ball);
            s.getMove().start();
        }

    }
    @FXML
    void toggle_cover_click(ActionEvent event) {
        cover = !cover;

        for (Spieler s : Spieler.getTeam()) {
            s.setCover(cover);
        }
    }
}
