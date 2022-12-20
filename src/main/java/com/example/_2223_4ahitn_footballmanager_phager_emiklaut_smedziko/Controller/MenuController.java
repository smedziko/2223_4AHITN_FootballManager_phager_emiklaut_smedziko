package com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Controller;

import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Model.ChangeScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuController {

    @FXML
    private Pane background;
    @FXML
    private Button start_game;

    public void initialize(){


        start_game.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    ChangeScene.change_scene("hello-view", start_game);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
