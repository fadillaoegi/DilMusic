package com.projectundikamobile.dilmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class lagutothebone extends AppCompatActivity {

    protected ImageView mainpause, next, stop, back;
    protected MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lagutothebone);

        initial();
        klik();

        song = MediaPlayer.create(getApplicationContext(), R.raw.tothebone);

        if (song.isPlaying()) {

            song.stop();

        }else if (!song.isPlaying()) {

            song.start();

        }

    }

    public void initial(){

        mainpause   = (ImageView) findViewById(R.id.mainpause);
        stop        = (ImageView) findViewById(R.id.stop);
        next        = (ImageView) findViewById(R.id.next);
        back        = (ImageView) findViewById(R.id.back);

    }

    public void klik(){

        mainpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (song.isPlaying()) {

                    song.pause();
                    mainpause.setImageResource(R.drawable.main);

                } else {
                    song.start();
                    mainpause.setImageResource(R.drawable.pause);
                }

            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                song.stop();

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                song.stop();
                Intent intent = new Intent(lagutothebone.this, uimusic.class);
                startActivity(intent);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                song.stop();
                Intent intent = new Intent(lagutothebone.this, laguangel.class);
                startActivity(intent);

            }
        });



    }
}