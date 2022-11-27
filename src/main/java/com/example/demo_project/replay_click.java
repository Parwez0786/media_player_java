package com.example.demo_project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;



public class replay_click {
@FXML
  public  MediaPlayer mediaplayers;

    @FXML
    public Slider timeSlider;
    @FXML
    public Button playBtn;
    @FXML
    public  play_pause playans;

    replay_click(MediaPlayer mm, Slider ss,Button pp ){
        this.mediaplayers=mm;
        this.timeSlider=ss;
        this.playBtn=pp;


    }

    public  void replay() {

        try {
            MediaPlayer.Status status = mediaplayers.getStatus();
            playans=new play_pause(mediaplayers, playBtn);
            if (status == MediaPlayer.Status.PLAYING) {

             playans.play_and_pause();

             mediaplayers.seek(new Duration(0));
             timeSlider.setValue(0);





            }
            playans.play_and_pause();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
