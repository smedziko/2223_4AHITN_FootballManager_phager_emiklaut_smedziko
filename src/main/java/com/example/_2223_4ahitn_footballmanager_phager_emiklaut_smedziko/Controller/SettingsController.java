package com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Controller;

import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Model.ChangeScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class SettingsController {

    @FXML
    private ComboBox musikauswahl;

    @FXML
    private Slider lautstaerke;

    @FXML
    private RadioButton musikan;

    @FXML
    private RadioButton musikaus;

    @FXML
    private RadioButton soundan;

    @FXML
    private RadioButton soundaus;

    @FXML
    private Button save;

    public void initialize() {


        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ChangeScene.change_scene("menu", save);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
