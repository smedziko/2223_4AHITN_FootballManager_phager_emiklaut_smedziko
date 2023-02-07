package com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Model;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Ball {

    static Circle playball;

    static int shootspeed;
    static int goalposition;

    static Label score = new Label();

    static boolean stopped = false;

    static int enemygoals = 0;
    static int goals = 0;

    static AnimationTimer move = new AnimationTimer() {
        private long lastUpdate = 0;

        @Override
        public void handle(long l) {

            if (l - lastUpdate >= 12_000_000) {

                if (!stopped) {
                    if (playball.getLayoutY() < goalposition) {
                        playball.setLayoutY(playball.getLayoutY() + 1);
                    }

                    if (playball.getLayoutY() > goalposition) {
                        playball.setLayoutY(playball.getLayoutY() - 1);
                    }

                    if(playball.getLayoutY() > 280) {
                        playball.setLayoutX(playball.getLayoutX() + 0.5);
                    }else {
                        playball.setLayoutX(playball.getLayoutX() - 0.5);
                    }

                    if(playball.getLayoutX() > 800 ){
                        goals++;
                        score.setText(goals + " : " + enemygoals);
                        playball.setLayoutX(417);
                        Ball.stopped = true;
                    }
                    if(playball.getLayoutX() < 100){
                        enemygoals++;
                        score.setText(goals + " : " + enemygoals);
                        playball.setLayoutX(417);
                        Ball.stopped = true;
                    }

                }
            }
            lastUpdate = l;
        }
    };

    public static void setBall(Circle ball, Label textfield){
        playball = ball;
        score = textfield;
    }

    public static void setBall(Circle ball){
        playball = ball;
    }

    public static void shoot(){
        goalposition = ThreadLocalRandom.current().nextInt(296, 305);
        move.start();
    }

}
