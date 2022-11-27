package com.example.demo_project;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import com.jfoenix.controls.JFXSlider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class volume_increment {

@FXML
    public  MediaPlayer player;
    public Slider volume_slider;
    @FXML
    private Button mute_buttons;

    volume_increment(MediaPlayer mediaPlayer, Slider volume_slider, Button mute_buttons){
        this.player=mediaPlayer;
        this.volume_slider=volume_slider;
      this.mute_buttons=mute_buttons;

    }

  public void set_volume(){
volume_slider.setValue(player.getVolume()*100);
volume_slider.valueProperty().addListener(new InvalidationListener() {
    @Override
    public void invalidated(Observable observable) {

        if(player.getVolume()==0){
            try {
                mute_buttons.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/volume.png"))));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            try {
                mute_buttons.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/mute.png"))));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        player.setVolume(volume_slider.getValue()/100);
    }
});



  }



}
