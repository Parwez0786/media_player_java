package com.example.demo_project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;

public class play_backfast {

    @FXML
    private MediaPlayer player;
    @FXML
    private Button speed_decrementer;
    @FXML
    private Button speed_incrementer;

    play_backfast(MediaPlayer player, Button speed_incrementer, Button speed_decrementer) {
        this.player=player;
        this.speed_incrementer=speed_incrementer;
        this.speed_decrementer=speed_decrementer;

    }


    public  void speed_increment(){
        double speed=player.getRate();

        player.setRate(speed+0.5);
        speed_incrementer.setText(speed+0.5+"x");
        speed_decrementer.setText(speed+0.5+"x");
    }

}
