package com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Model;

import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Controller.MenuController;
import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.Controller.SpielfeldController;
import com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ChangeScene {

    public static void change_scene(String game, Button button) throws IOException {
        Stage stage = new Stage();

        Stage stageclose = (Stage) button.getScene().getWindow();
        stageclose.close();
        final FXMLLoader fxmlLoader = new FXMLLoader();
        System.out.println(MenuController.class.getResource(game+".fxml"));
        URL u = HelloApplication.class.getResource("spielfeld.fxml");

        fxmlLoader.setLocation(u);
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle(game);
        stage.setScene(scene);
        stage.show();
    }

}
