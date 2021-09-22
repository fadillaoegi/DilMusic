package com.projectundikamobile.dilmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class list_master extends AppCompatActivity {

    protected Button listusers, updateusers, deleteusers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_master);

        initial();
        klik();

    }

    public void initial (){

        listusers = findViewById(R.id.listusers);
        updateusers = findViewById(R.id.Updateusers);
        deleteusers = findViewById(R.id.deleteusers);

    }

    public void klik() {

        listusers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(list_master.this, list_users.class);
                startActivity(intent);

            }
        });

        updateusers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), update.class);
                startActivity(intent);

            }
        });

        deleteusers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), delete.class);
                startActivity(intent);

            }
        });

    }

}