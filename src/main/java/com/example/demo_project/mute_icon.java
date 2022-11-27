package com.example.demo_project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class mute_icon {
    @FXML
    public MediaPlayer player;
    @FXML
    private Button mute_buttons;
    @FXML
    public Slider volume_slider;
    mute_icon(MediaPlayer player, Button mute_buttons, Slider volume_slider){
        this.player=player;
        this.mute_buttons=mute_buttons;
      this.volume_slider=volume_slider;
    }

    public  void  mutes() throws FileNotFoundException {
        boolean status=player.isMute();
        if(status==true){
            player.setMute(false);
            mute_buttons.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/mute.png"))));

            volume_slider.setValue(player.getVolume()*100);



        }
        else {
            player.setMute(true);
            mute_buttons.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/volume.png"))));
            volume_slider.setValue(0);
        }
    }
}
