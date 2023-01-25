package com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Model;

import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.SpielfeldController;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Random;

import static com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Model.Aufstellung.field_width;

public class Spieler {
    AnchorPane spielfeld;
    Circle body = new Circle();
    double speed = 0.5;
    String rolle;


    Circle ball;

    boolean isEnemy;

    boolean cover;

    boolean hasBall = false;

    boolean balldetected = false;

    static ArrayList<Spieler> team = new ArrayList<>();
    static ArrayList<Spieler> enemyteam = new ArrayList<>();

    double startX;
    double startY;
    boolean enemyTeamball;
    boolean teamball;

    Spieler playeronball;

    int zweikampf;

    AnimationTimer move = new AnimationTimer() {
        private long lastUpdate = 0;

        @Override
        public void handle(long l) {

            if (l - lastUpdate >= 12_000_000) {

                try {
                    checkballdetection();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }





            lastUpdate = l;
        }
    };


    // && ball.getLayoutY() < body.getLayoutY() + 2 && ball.getLayoutY() > body.getLayoutY() - 2

    public void checkballdetection() throws InterruptedException {

        double underX = body.getLayoutX() - 107;
        double overY = body.getLayoutY() - 107;
        double overX = body.getLayoutX() + 107;
        double underY = body.getLayoutY() + 107;

        if (ball.getLayoutY() >= overY && ball.getLayoutX() >= underX && ball.getLayoutX() <= overX) {
            balldetected = true;
        } else if (ball.getLayoutY() <= underY && ball.getLayoutY() >= body.getLayoutY() && ball.getLayoutX() >= underX && ball.getLayoutX() <= overX) {
            balldetected = true;
        }

        if(balldetected){
            if(ball.getLayoutY() > body.getLayoutY()){
                body.setLayoutY(body.getLayoutY() + speed);
            }else if(ball.getLayoutY() < body.getLayoutY()){
                body.setLayoutY(body.getLayoutY() - speed);
            }

            if(ball.getLayoutX() > body.getLayoutX()){
                body.setLayoutX(body.getLayoutX() + speed);
            }else if(ball.getLayoutX() < body.getLayoutX()){
                body.setLayoutX(body.getLayoutX() - speed);
            }
        }

        if(ball.getLayoutX() > body.getLayoutX() - 10 && ball.getLayoutX() < body.getLayoutX() + 10) {

            if (!teamball && !enemyTeamball) {
                hasBall = true;
                playeronball = this;

                if (isEnemy) {
                    enemyTeamball = true;
                    System.out.println("Enemy Team Ball");
                    fight();
                } else {
                    teamball = true;
                    System.out.println("Team ball");
                }
            }else {
                fight();
            }
        }


    }

    public void fight() throws InterruptedException {

        if(playeronball.zweikampf >= zweikampf){

            playeronball.move.wait(100);
        }else if(zweikampf >= playeronball.zweikampf){
            move.wait(100);
        }else {
        }

    }







    public Spieler(AnchorPane spielfeld, String position, boolean enemy, int zweikampf){
        this.zweikampf = zweikampf;
        rolle = position;

        isEnemy = enemy;
        //Enemy team das die Spieler wissen wo gegner stehen für deckung andere techniken
        if(isEnemy){
            enemyteam.add(this);
        }else {
            team.add(this);
        }

        this.spielfeld = spielfeld;
        Aufstellung.setPosition(this);

        Image img = new Image(String.valueOf(SpielfeldController.class.getResource("QAT_akramafif.png")));
        body.setFill(new ImagePattern(img));


        body.setRadius(18);
        spielfeld.getChildren().add(body);

        startX = body.getLayoutX();
        startY = body.getLayoutX();

    }


    public static ArrayList<Spieler> getTeam(){
        return team;
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
        this.ball = ball;
    }



}
