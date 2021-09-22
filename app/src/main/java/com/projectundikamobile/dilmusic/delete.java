package com.projectundikamobile.dilmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class delete extends AppCompatActivity {

    private String URL = "http://192.168.0.113/dbDilMusic/delete.php";

    private EditText etid;
    private Button btnHapus;
    private TextView txtStatus_code;

    private String id;

    //Stringrequest salah satu library volley utk menangkap data
    private StringRequest stringRequest;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        initial();
        klik();
    }

    public void initial(){

        btnHapus = (Button) findViewById(R.id.hapus);
        etid = (EditText) findViewById(R.id.id);


    }

    public void klik() {

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id = etid.getText().toString().trim();

                if (id.equals("")){

                    Toast.makeText(getApplicationContext(), "Mohon Isikan id", Toast.LENGTH_LONG).show();

                }else {

                    stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if (response.equals("Delete")) {

                                Toast.makeText(getApplicationContext(), "Data Telah di hapus", Toast.LENGTH_LONG).show();


                            } else {
                                Toast.makeText(getApplicationContext(), "Data Gagal Di hapus", Toast.LENGTH_LONG).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    })
                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String, String> data = new HashMap<>();
                            data.put("id", id);

                            return data;

                        }
                    };

                    //request ke Volley
                    requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);



                }

            }
        });


    }

}