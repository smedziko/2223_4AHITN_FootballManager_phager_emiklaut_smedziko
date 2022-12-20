package com.example._2223_4ahitn_footballmanager_phager_emiklaut_smedziko;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class SpielfeldController {


    @FXML
    private ImageView field_image;

    @FXML
    private StackPane stack_field;

    @FXML
    private AnchorPane playable_field;

    public void initialize(){
        Image img = new Image(String.valueOf(SpielfeldController.class.getResource("field1.png")));
        Image spieler = new Image(String.valueOf(SpielfeldController.class.getResource("QAT_akramafif.png")));

        field_image.setImage(img);
        field_image.setPreserveRatio(false);

        Circle r = new Circle();
        r.setFill(new ImagePattern(spieler));
        r.setRadius(18);
        r.setLayoutX(50);
        r.setLayoutY(298);

        playable_field.getChildren().add(r);





    }
}
