package com.projectundikamobile.dilmusic;

import androidx.appcompat.app.AppCompatActivity;

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

public class update extends AppCompatActivity {

    private Button btnupdate;
    private EditText etemail, etpass, etnohp;

    private String URL = "http://192.168.0.113/dbDilMusic/update.php";

    private StringRequest stringRequest;
    private RequestQueue requestQueue;

    private TextView debug;

    private String email, pass, nohp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        initial();
        klik();

    }

    public void initial(){

        btnupdate = (Button) findViewById(R.id.update);
        etemail = (EditText) findViewById(R.id.uemail);
        etpass = (EditText) findViewById(R.id.upass);
        etnohp = (EditText) findViewById(R.id.unohp);
        debug = (TextView) findViewById(R.id.debug);


    }

    public void klik() {


        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = etemail.getText().toString().trim();
                pass = etpass.getText().toString().trim();
                nohp = etnohp.getText().toString().trim();

                if (email.equals("") || pass.equals("") || nohp.equals("")) {

                    Toast.makeText(getApplicationContext(), "Isi email untuk bisa Update", Toast.LENGTH_LONG).show();

                } else {

                    stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            debug.setText("Sudah masuk Di onRespose");

                            if (response.equals("Update")) {

                                Toast.makeText(getApplicationContext(), "Data Berhasil di update", Toast.LENGTH_LONG).show();

                            } else {
                                Toast.makeText(getApplicationContext(), "Data Gagal Di update", Toast.LENGTH_LONG).show();
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

                            Map<String, String> data =new HashMap<>();
                            data.put("email", email);
                            data.put("password", pass);
                            data.put("nohp", nohp);

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