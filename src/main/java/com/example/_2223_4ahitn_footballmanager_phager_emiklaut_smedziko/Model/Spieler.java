package com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Model;

import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Controller.SpielfeldController;
import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Database;
import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.HelloApplication;
import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Players;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Spieler {
    AnchorPane spielfeld;
    Circle body = new Circle();
    double speed = 0.5;
    String rolle;

    boolean isEnemy;

    boolean cover;

    boolean hasBall = false;

    boolean balldetected = false;
    boolean onlymove = true;
    boolean enemydetected = false;

    static ArrayList<Spieler> team = new ArrayList<>();
    static ArrayList<Spieler> enemyteam = new ArrayList<>();

    double startX;
    double startY;

    static boolean startofgame;
    static boolean enemyTeamball;
    static boolean teamball;

    static Spieler playeronball;

    int zweikampf;

    double underX;
    double overY;
    double overX;
    double underY;

    public static String country = "";

    int start = 0;

    boolean isTW = false;

    static boolean teamanstoss;

    int random = 0;

    AnimationTimer move = new AnimationTimer() {
        private long lastUpdate = 0;

        @Override
        public void handle(long l) {

            if (l - lastUpdate >= 12_000_000) {

                try {

                    //Fehlend
                    // Tor, Getroffen oder nicht chance, wenn nicht abblocken in random richtung
                    // Frei stellen, wenn eigener Spieler Ball
                    // Datenbank verschiedene Spieler
                    if(!hasBall) {
                        if((teamball && isEnemy || enemyTeamball && !isEnemy) || (!teamball && !enemyTeamball)) {
                            checkballdetection();
                        }
                    }else {
                        runtogoal();
                    }
                    onlymove = true;

                    


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }





            lastUpdate = l;
        }
    };



    // && ball.getLayoutY() < body.getLayoutY() + 2 && ball.getLayoutY() > body.getLayoutY() - 2

    public void checkballdetection() throws InterruptedException {


        if (Ball.playball.getLayoutY() >= overY && Ball.playball.getLayoutX() >= underX && Ball.playball.getLayoutX() <= overX) {
            balldetected = true;
            onlymove = false;
        } else if (Ball.playball.getLayoutY() <= underY && Ball.playball.getLayoutX() >= underX && Ball.playball.getLayoutX() <= overX) {
            balldetected = true;
            onlymove = false;
        }

        if(balldetected){
            if(Ball.playball.getLayoutY() > body.getLayoutY()){
                body.setLayoutY(body.getLayoutY() + speed);
            }else if(Ball.playball.getLayoutY() < body.getLayoutY()){
                body.setLayoutY(body.getLayoutY() - speed);
            }

            if(Ball.playball.getLayoutX() > body.getLayoutX()){
                body.setLayoutX(body.getLayoutX() + speed);
            }else if(Ball.playball.getLayoutX() < body.getLayoutX()){
                body.setLayoutX(body.getLayoutX() - speed);
            }
        }

        if(Ball.playball.getLayoutX() > body.getLayoutX() - 10 && Ball.playball.getLayoutX() < body.getLayoutX() + 10 && Ball.playball.getLayoutY() > body.getLayoutY()-10 && Ball.playball.getLayoutY() < body.getLayoutY()+10) {

            if (!teamball && !enemyTeamball) {
                hasBall = true;
                playeronball = this;

                Ball.stopped = true;
                Ball.playball.setLayoutY(body.getLayoutY());

                if(isEnemy) {
                    Ball.playball.setLayoutX(body.getLayoutX() + 1);
                }else {
                    Ball.playball.setLayoutX(body.getLayoutX() - 1);
                }

                if (isEnemy) {
                    enemyTeamball = true;
                } else {
                    teamball = true;
                }
            }else {
                Ball.stopped = true;
                fight();
            }
        }


    }

    private void runtogoal() {

        boolean enemyontop = false;
        boolean enemyonbottom = false;
        ArrayList<Spieler> teamlist;
        if(isEnemy) {
            teamlist = team;
        }else {
            teamlist = enemyteam;
        }
        if(body.getLayoutY() < Aufstellung.untenY && body.getLayoutY() > Aufstellung.obenY) {
            for (Spieler s : teamlist) {
                if (s.body.getLayoutY() > body.getLayoutY() - 50 && s.body.getLayoutY() < body.getLayoutY() && !enemyontop && !enemyonbottom) {
                    enemyonbottom = true;
                } else if (s.body.getLayoutY() < body.getLayoutY() && s.body.getLayoutY() > body.getLayoutY() + 50 && !enemyontop && !enemyonbottom) {
                    enemyontop = true;
                }

            }
        }

            if (enemyonbottom) {
                body.setLayoutY(body.getLayoutY() + speed);
                Ball.playball.setLayoutY(Ball.playball.getLayoutY() + speed);
            } else if (enemyontop) {
                body.setLayoutY(body.getLayoutY() - speed);
                Ball.playball.setLayoutY(Ball.playball.getLayoutY() - speed);
            }

        if(!isEnemy && body.getLayoutX() >= 670 || isEnemy && body.getLayoutX() <= 200){
            Ball.stopped = false;
            Ball.shoot();
            playeronball = null;
            enemyTeamball = false;
            teamball = false;
            hasBall = false;
            pauseTimerForDuration(move, Duration.millis(2000));
        }else if(!isEnemy){
            body.setLayoutX(body.getLayoutX() + speed);
            Ball.playball.setLayoutX(Ball.playball.getLayoutX() + speed);
        }else {
            body.setLayoutX(body.getLayoutX() - speed);
            Ball.playball.setLayoutX(Ball.playball.getLayoutX() - speed);
        }


        }


    public void fight() {
        if(playeronball != this) {
            if (playeronball.zweikampf > zweikampf) {
                pauseTimerForDuration(move,Duration.millis(2200));
            }else {
                hasBall = true;
                playeronball.hasBall = false;
                pauseTimerForDuration(playeronball.getMove(),Duration.millis(2200));

                playeronball = this;

                if (isEnemy) {
                    enemyTeamball = true;
                    teamball = false;
                } else {
                    teamball = true;
                    enemyTeamball = false;
                }

            }
        }

    }







    public Spieler(AnchorPane spielfeld, String position, boolean enemy, int zweikampf){
        this.zweikampf = zweikampf;
        rolle = position;
        startofgame = true;


        isEnemy = enemy;
        //Enemy team das die Spieler wissen wo gegner stehen für deckung andere techniken
        if(isEnemy){
            enemyteam.add(this);
        }else {
            team.add(this);

        }

        this.spielfeld = spielfeld;
        Aufstellung.setPosition(this);

        Image img = new Image(String.valueOf(HelloApplication.class.getResource("QAT_akramafif.png")));
        body.setFill(new ImagePattern(img));


        body.setRadius(18);
        spielfeld.getChildren().add(body);

        startX = body.getLayoutX();
        startY = body.getLayoutX();


        if(!Objects.equals(position, "TW")) {
            underY = startY + 80;
            overY = startY - 80;
            overX = startX + 80;
            underX = startX - 80;
        }else {
            underY = startY -10;
            overX = startX + 10;
            underX = startX - 10;
            overY = startY + 10;
            isTW = true;
        }
    }


    public static ArrayList<Spieler> getTeam(){
        return team;
    }

    public static void setAnstoss(boolean teamanstoss){
        Spieler.teamanstoss = teamanstoss;
        Spieler.startofgame = true;
    }

    public static ArrayList<Spieler> getEnemyteam(){
        return enemyteam;
    }

    public AnimationTimer getMove(){
        return move;
    }

    public void setCover(boolean c){
        cover = c;
    }

    public void setBall(Circle ball){
        Ball.setBall(ball);
    }

    public boolean getIsTW(){
        return isTW;
    }

    void pauseTimerForDuration(AnimationTimer timer, Duration duration) {
        PauseTransition pt = new PauseTransition(duration);
        pt.setOnFinished(event -> timer.start());
        timer.stop();
        pt.play();}



}
