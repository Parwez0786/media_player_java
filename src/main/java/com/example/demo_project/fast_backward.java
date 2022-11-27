package com.example.demo_project;

import javafx.fxml.FXML;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class fast_backward {

    @FXML
    public MediaPlayer media;
    fast_backward(MediaPlayer mm){
        this.media=mm;

    }

    public void skip_minus_10(){
        double d = media.getCurrentTime().toSeconds();

        d = d - 10;

        media.seek(new Duration(d * 1000));
    }
}
