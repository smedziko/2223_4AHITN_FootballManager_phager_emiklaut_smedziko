package com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Model;

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Circle;

public class Ball {

    static Circle playball;


    static AnimationTimer move = new AnimationTimer() {
        private long lastUpdate = 0;

        @Override
        public void handle(long l) {

            if (l - lastUpdate >= 12_000_000) {

                playball.setLayoutX(playball.getLayoutX() - 1);
            }
            lastUpdate = l;
        }
    };

    public static void setBall(Circle ball){
        playball = ball;
    }

}
