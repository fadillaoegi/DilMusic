package com.projectundikamobile.dilmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.media.MediaPlayer;
import android.widget.Toast;

public class dashboard extends AppCompatActivity {

    private ListView listsong;
    private MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        listsong = findViewById(R.id.listlagu);

        String[] array_for_list_song = new String[] {
                "For You - Azu",
                "Orange - 7",
                "Angel - Denni Caknan",
                "Pamungkas - To The Bone"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, array_for_list_song);

        listsong.setAdapter(adapter);

//        Onclick

        listsong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    Intent intent = new Intent (listsong.getContext(), uimusic.class);
                    startActivity(intent);
//                    song = MediaPlayer.create(getApplicationContext(), R.raw.for_you_azu);
//                    song.start();

                } else if (position == 1){

                    Intent intent = new Intent(listsong.getContext(), laguorange.class);
                    startActivity(intent);
//                    song = MediaPlayer.create(getApplicationContext(), R.raw.orange);
//                    song.start();

                } else if (position == 2){

                    Intent intent = new Intent(listsong.getContext(), laguangel.class);
                    startActivity(intent);
//                    song = MediaPlayer.create(getApplicationContext(), R.raw.angel);
//                    song.start();

                } else if (position == 3){

                    Intent intent = new Intent(listsong.getContext(), lagutothebone.class);
                    startActivity(intent);
//                    song = MediaPlayer.create(getApplicationContext(), R.raw.tothebone);
//                    song.start();

                }

            }
        });

    }
}