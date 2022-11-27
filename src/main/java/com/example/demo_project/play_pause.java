package com.example.demo_project;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class play_pause {
    @FXML

   public Button buttons;
   public MediaPlayer media_play;

    play_pause(MediaPlayer m, Button b){
        this.buttons=b;
        this.media_play=m;



    }

    public  void play_and_pause(){

        try {

            MediaPlayer.Status status = media_play.getStatus();

            if (status == MediaPlayer.Status.PLAYING) {
                ///pause...
                media_play.pause();
//            playBtn.setText("Play");
                buttons.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/play.png"))));
            } else {
                media_play.play();
//            playBtn.setText("Pause");
                buttons.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/pause.png"))));


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
