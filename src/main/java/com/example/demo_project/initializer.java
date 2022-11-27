package com.example.demo_project;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import org.w3c.dom.Text;

import java.io.FileInputStream;

public class initializer {


    @FXML
    MediaPlayer player;

    @FXML
    public MediaView mediaView;

    @FXML
    public Button playBtn;

    @FXML
    public Slider volume_slider;
    @FXML
    public Button preBtn;
    @FXML
    public Button nextBtn;

    @FXML
    public Slider timeSlider;


    @FXML
    public Button stop;
    @FXML
    public Button replay;
    @FXML
    public Button speaker_increment;
    @FXML
    public Button speaker_decrement;
       @FXML
       public Button mute_button;


    @FXML
    public  Button speed_incrementer;

    @FXML
    public  Button speed_decrementer;

// initializing constructor
     initializer(Button playBtn, Button preBtn, Button nextBtn, Slider timeSlider, Button stop,Button replay, Button speaker_increment, Button speaker_decrement, Slider volume_slider, MediaPlayer player, Button mute_button, Button speed_incrementer,Button speed_decrementer){
         this.playBtn=playBtn;
         this.preBtn=preBtn;
         this.nextBtn=nextBtn;
         this.timeSlider=timeSlider;
         this.stop=stop;
         this.replay=replay;

          this.volume_slider=volume_slider;

         this.mute_button=mute_button;
  this.speed_decrementer=speed_decrementer;
  this.speed_incrementer=speed_incrementer;

     }
     public  void initials() {
         System.out.println("i initializing");
         try {


             // initializing all attributes
             playBtn.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/play.png"))));
             preBtn.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/slow.png"))));
             nextBtn.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/fast.png"))));
             timeSlider.setShowTickLabels(true);
             stop.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/stop.png"))));
             replay.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/replay.png"))));



             mute_button.setGraphic(new ImageView(new Image(new FileInputStream("src/icons/mute.png"))));
             speed_decrementer.setText("1x");
             speed_incrementer.setText("1x");

//               volume_slider.setValue(player.getVolume()*100);


         } catch (Exception e) {
             e.printStackTrace();
         }

     }
}
