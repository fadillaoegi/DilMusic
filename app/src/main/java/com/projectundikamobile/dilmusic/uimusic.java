package com.projectundikamobile.dilmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class uimusic extends AppCompatActivity {

    protected ImageView mainpause,next, back, stop;
    protected  MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uimusic);

        initial();
        song = MediaPlayer.create(getApplicationContext(), R.raw.for_you_azu);

        if (song.isPlaying()) {

            song.stop();

        } else if (!song.isPlaying()) {

            song.start();

        }

        kilk();

    }

    public void initial(){



        //initial ImageView
        stop      = (ImageView) findViewById(R.id.stop);
        mainpause = (ImageView) findViewById(R.id.mainpause);
        next      = (ImageView) findViewById(R.id.next);
        back      = (ImageView) findViewById(R.id.back);


    }


    public void kilk(){

            stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                song.stop();
            }
        });

        mainpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (song.isPlaying()){
                    mainpause.setImageResource(R.drawable.main);
                    song.pause();


                }else {

                    mainpause.setImageResource(R.drawable.pause);
                    song.start();
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                song.stop();
                Intent intent = new Intent(uimusic.this, laguorange.class);
                startActivity(intent);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                Intent intent = new Intent(uimusic.this, lagutothebone.class);
                startActivity(intent);

            }
        });

    }

}