package com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Model;

import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.SpielfeldController;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Spieler {
    AnchorPane spielfeld;
    Circle body = new Circle();
    int speed;
    String rolle;

    boolean isEnemy;

    static ArrayList<Spieler> team = new ArrayList<>();

    Image img;

    public Spieler(AnchorPane spielfeld, String position, boolean enemy){
        rolle = position;
        team.add(this);
        isEnemy = enemy;
        this.spielfeld = spielfeld;
        Aufstellung.setPosition(this);

        Image img = new Image(String.valueOf(SpielfeldController.class.getResource("QAT_akramafif.png")));
        body.setFill(new ImagePattern(img));


        body.setRadius(18);
        spielfeld.getChildren().add(body);

    }


}
