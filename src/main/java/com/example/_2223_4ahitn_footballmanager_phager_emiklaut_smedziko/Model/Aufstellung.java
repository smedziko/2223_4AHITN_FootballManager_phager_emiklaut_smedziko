package com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Model;

import java.util.Objects;

public class Aufstellung {
    static final int torwartX = 50;
    static final int torwartY = 298;

    static final int verteidigerX = 200;
    static final int mitteX = 280;
    static final int mitteY = 297;
    static final int obenY = 115;

    static final int untenY = 485;

    static final int field_width = 836;


    static final String[] mitte = {"LS", "ST", "RS"};
    static final String[] unten = {"RV", "RS", "RM"};
    static final String[] oben = {"LV", "LM", "LS"};


    static String aufstellung;

    public static void setPosition(Spieler spieler){
        double posX = 0;
        double posY = 0;
        if(Objects.equals(spieler.rolle, "TW")){
            posX = torwartX;
            posY = torwartY;
            System.out.println(spieler.spielfeld.getPrefWidth());
        }else {

            //In Datenbank packen, Jede Position fixe X / Y Werte nur mehr herausholen
            //Alles in Docker reintun / Docker wiederholen
            switch (spieler.rolle) {
                case "IV":
                    posX = 130;
                    posY = mitteY;
                    break;

                case "RV":
                    posX = verteidigerX;
                    posY = untenY;
                    break;

                case "LV":
                    posX = verteidigerX;
                    posY = obenY;
                    break;

                case "ZM":
                    posX = mitteX - 20;
                    posY = mitteY;
                    break;

                case "LM":
                    posX = mitteX;
                    posY = obenY - 25;
                    break;

                case "RM":
                    posX = mitteX;
                    posY = untenY + 25;
                    break;

                case "ST":
                    posX = 340;
                    posY = mitteY;
            }

        }

        if (spieler.isEnemy) {
            posX = field_width - posX;
        }

        spieler.body.setLayoutX(posX);
        spieler.body.setLayoutY(posY);

    }
}
