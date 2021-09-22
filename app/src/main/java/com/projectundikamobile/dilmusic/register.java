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
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {

    private EditText etemail, etpass, etnohp;
    private Button register, login;
    private TextView txtnotif;

    private StringRequest stringRequest;
    private RequestQueue requestQueue;

    private String email, pass, nohp;

    private String URL = "http://192.168.0.113/dbDilMusic/insert.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initial();
        klik();
    }

    public void initial() {

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        etemail  = (EditText)findViewById(R.id.email);
        etnohp   = (EditText)findViewById(R.id.nohp);
        etpass   = (EditText)findViewById(R.id.pass);
        txtnotif = (TextView)findViewById(R.id.notif);

    }

    public void klik(){

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(register.this, login.class);
                startActivity(intent);

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = etemail.getText().toString().trim();
                pass  = etpass.getText().toString().trim();
                nohp  = etnohp.getText().toString().trim();

                if (email.equals("") && pass.equals("") && nohp.equals("")){

                    txtnotif.setText("Tolong isi Semua form");
                    Toast.makeText(getApplicationContext(), "Tolong isi Semua form", Toast.LENGTH_LONG).show();

                }else {


                    stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            txtnotif.setText("Masuk di Response");

                            if (response.equals("Anda Berhasil Terdaftar")){

                                Toast.makeText( getApplicationContext(), "Anda Berhasil Terdaftar", Toast.LENGTH_LONG).show();

                            } else  {

                                Toast.makeText(getApplicationContext(), "Anda Berhasil mendaftar", Toast.LENGTH_LONG).show();

                            }



                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            txtnotif.setText("masuk di method onErrorResponse(String response)");

                        }
                    })

                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String, String> data = new HashMap<>();
                            data.put("email", email);
                            data.put("password", pass);
                            data.put("nohp", nohp);

                            return data;
                        }
                    };

                    requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);

                    Intent intent = new Intent(getApplicationContext(), login.class);
                    startActivity(intent);


                }




            }
        });

    }

}