package com.example.demo_project;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.w3c.dom.Text;
import org.w3c.dom.events.MouseEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.*;

public class HelloController implements Initializable {
@FXML
 public     MediaPlayer player;

    @FXML
    private MediaView mediaView;

       @FXML
       private Button mute_buttons;
    @FXML
    public Button playBtn;
    @FXML
    public Button preBtn;
    @FXML

    public Button nextBtn;
    @FXML
    private Slider volume_slider;
    @FXML
    public Slider timeSlider;
    @FXML
    private Button stop;
    @FXML
    private Button replay;


    @FXML
    private Button speaker_increment;

    @FXML
    public Button speaker_decrement;

    @FXML
    private AnchorPane ANCHOR_PANE;

    @FXML
    private Button speed_decrementer;
    ArrayList<String> songList = new ArrayList<String>();
    @FXML
    private Button speed_incrementer;


// initialize the scene like icon

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializer ii=new initializer(playBtn, preBtn, nextBtn, timeSlider, stop, replay, speaker_increment, speaker_decrement, volume_slider, player, mute_buttons, speed_incrementer, speed_decrementer);
        ii.initials();

    }




// open file
    @FXML
    void openSongMenu(ActionEvent event) {

        try {
            System.out.println("open song clicked");
            //choosing file
            FileChooser chooser = new FileChooser();
            File file = chooser.showOpenDialog(null);


            String ss=file.toString();

            // storing player song
            System.out.println(file);

            songList.add(ss);




            int i=ss.lastIndexOf(".");
            int kk=ss.length();
            String name=ss.substring(i+1, kk);





            Media m = new Media(file.toURI().toURL().toString());
            System.out.println(m);

            if (player != null) {
                player.dispose();
            }


            player = new MediaPlayer(m);
              if(name=="mp3"||name=="MP3"){
                  mediaView.setMediaPlayer(player);

              }
              else {
                  mediaView.setMediaPlayer(player);
              }



            //time slider...

            player.setOnReady(() -> {
                //when player gets ready
                timeSlider.setMin(0);
                timeSlider.setMax(player.getMedia().getDuration().toMinutes());

                timeSlider.setValue(0);

        });

            //progress
            //listener on player...

            player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                @Override
                public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                    //coding...
                    Duration d = player.getCurrentTime();




                    timeSlider.setValue(d.toMinutes());
                    if (timeSlider.getValue() == player.getMedia().getDuration().toMinutes()) {
                        timeSlider.setValue(0);
                    }


                }
            });


//            time slider on click

            timeSlider.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    if (timeSlider.isPressed()) {
                        double val = timeSlider.getValue();
                        player.seek(new Duration(val * 60 * 1000));
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





// play the song
    @FXML
    void play(ActionEvent event) {
   play_pause  pp=  new play_pause(player, playBtn);
   pp.play_and_pause();

    }



// skip by 10second
    @FXML
    void preBtnClick(ActionEvent event) {
        double d = player.getCurrentTime().toSeconds();

        d = d - 10;

        player.seek(new Duration(d * 1000));

    }




// skip by 10sec
    @FXML
    void nextBtnClick(ActionEvent event) {
        double d = player.getCurrentTime().toSeconds();

        d = d + 10;

        player.seek(new Duration(d * 1000));

    }


    //exit the media player
    @FXML
    void exit_option(ActionEvent event) {
       new exit();

    }



//about us page

    @FXML
    void about_us(ActionEvent event) {
   aboutUs  aboutus=new aboutUs();
     aboutus.showinfo();
    }



// skip by 10sec

    @FXML
    void plus10(ActionEvent event) {
        fast_forward fast=new fast_forward(player);
        fast.skip_10_second();
    }



//skip by -10 sec

    @FXML
    void minus_10(ActionEvent event) {
          fast_backward slow=new fast_backward(player);
          slow.skip_minus_10();
    }
// exit the media player
    @FXML
    void stop_button(ActionEvent event) {
            new exit();
    }

// replay the song
    @FXML
    void replay_click(ActionEvent event) {
       replay_click rr=new replay_click(player, timeSlider, playBtn);

       rr.replay();
    }


// play back fast

    @FXML
    void play_back_fast(ActionEvent event) {

      play_backfast fast=new play_backfast(player, speed_incrementer, speed_decrementer);
      fast.speed_increment();
    }



// playback slow
    @FXML
    void play_back_slow(ActionEvent event) {
        double speed=player.getRate();
        if(speed>=1) {
            player.setRate(speed - 0.5);
            speed_incrementer.setText(speed+0.5+"x");
            speed_decrementer.setText(speed+0.5+"x");
        }

    }

//mute the song

    @FXML
    void mute_button(ActionEvent event) throws FileNotFoundException {
       mute_icon mute=new mute_icon(player, mute_buttons, volume_slider);
       mute.mutes();
    }

//playback speed setter

    @FXML
    void play_back_setter(ActionEvent event) {
        double  rate=player.getRate();
        if(rate<=3){
            player.setRate(rate+0.5);
            speed_incrementer.setText(rate+0.5+"x");
            speed_decrementer.setText(rate+0.5+"x");


        }


    }





//play back setter
    @FXML
    void play_back_speed_dec(ActionEvent event) {
      double rate=player.getRate();
      if(rate>=1){
          player.setRate(rate-0.5);
          speed_decrementer.setText( rate-0.5+"x");
          speed_incrementer.setText(rate-0.5+"x");
      }
    }


//volume adjust
    public void volume_adjuster(javafx.scene.input.MouseEvent mouseEvent) {


        volume_increment vol=new volume_increment(player, volume_slider, mute_buttons);
        vol.set_volume();

    }



// media view height setter

    @FXML
    void media_height_decrease(ActionEvent event) {


        double height=   mediaView.getFitHeight();
        if(height>=100) {
            mediaView.setFitHeight( height-80);
        }
        System.out.println(height);
    }

    // media view height setter
    @FXML
    void media_height_increse(ActionEvent event) {
        double height=   mediaView.getFitHeight();
        mediaView.setFitHeight(80+height);
        System.out.println(height);
    }
    // media view width setter
    @FXML
    void media_width_decrease(ActionEvent event) {
        double width=   mediaView.getFitWidth();
        if (width>=100) {
            mediaView.setFitWidth(width-80);
        }
        System.out.println(width);
    }
    // media view width setter
    @FXML
    void media_width_increase(ActionEvent event) {
        double width=   mediaView.getFitWidth();
        mediaView.setFitWidth(80+width);
        System.out.println(width);


//        ANCHOR_PANE.



    }



    int flag=0;
    @FXML

// fit to screen
    void fit_toScreen(ActionEvent event) {


          if(flag==0) {
              mediaView.setFitHeight(710);

              mediaView.setFitWidth(1250);
              flag=1;
          }
          else{
              mediaView.setFitHeight(500);

              mediaView.setFitWidth(650);
              flag=0;
        }


    }



}
