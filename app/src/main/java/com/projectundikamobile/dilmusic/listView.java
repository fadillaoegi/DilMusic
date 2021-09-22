package com.projectundikamobile.dilmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class listView extends AppCompatActivity {

    ListView list;
    String[]  txtmenu = {"Play Song","About Aplication", "Software Engineering"};
    Integer[] icon = {R.drawable.logodilmusik, R.drawable.about, R.drawable.me};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        menu adapter = new menu(listView.this, txtmenu, icon);

        list = findViewById(R.id.list);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int possition, long id) {

                if (possition == 0) {

                        int i = 0;
                        Intent intent = new Intent (view.getContext(), dashboard.class);
                        Toast.makeText(listView.this, "Open " + txtmenu[i], Toast.LENGTH_LONG).show();
                        startActivity(intent);

                } else if (possition == 1) {

                    int i = 1;
                    Intent intent = new Intent (view.getContext(), aboutAplikasi.class);
                    Toast.makeText(listView.this, "Open " + txtmenu[i], Toast.LENGTH_LONG).show();
                    startActivity(intent);

                } else if (possition == 2) {

                    int i = 2;
                    Intent intent = new Intent (view.getContext(), AboutMe.class);
                    Toast.makeText(listView.this, "Open " + txtmenu[i], Toast.LENGTH_LONG).show();
                    startActivity(intent);

                }
            }
        });

    }
}