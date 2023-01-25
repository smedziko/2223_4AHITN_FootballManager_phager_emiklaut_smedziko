package com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Controller;

import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Model.ChangeScene;
import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Players;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;

public class MenuController {

    @FXML
    private Pane background;
    @FXML
    private Button start_game;

    @FXML
    private Button settings;

    @FXML
    private ComboBox<Players> landauswahl;

    private String selectedLand;

    public void initialize(){

        landauswahl.setItems(Players.getPlayers());

        start_game.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    ChangeScene.change_scene("spielfeld", start_game);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        settings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ChangeScene.change_scene("settings", settings);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
