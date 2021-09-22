package com.projectundikamobile.dilmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {

    private String URL = "http://192.168.0.113/dbDilMusic/login.php";

    private Button blogin, bregister, btry;
    private String email, pass, login;

    private StringRequest stringRequest;
    private RequestQueue requestQueue;
    private JSONObject jsonObject;

    private EditText loginemail, loginpass;

    private TextView notif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initial();

        klik();

    }

    public void initial() {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        blogin = findViewById(R.id.login);
        btry   = findViewById(R.id.coba);
        bregister = findViewById(R.id.register1);
        loginemail = findViewById(R.id.loginemail);
        loginpass = findViewById(R.id.loginpass);
        notif = findViewById(R.id.txtnotif);


    }

    public void klik (){



//        Button Login
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = loginemail.getText().toString();
                pass = loginpass.getText().toString();

                if (email.equalsIgnoreCase("") || pass.equalsIgnoreCase(""))  {

                    notif.setText("Jangan Kosong wahai Anak Muda");

                } else if (email.equalsIgnoreCase("admin@gmail.com") && pass.equalsIgnoreCase("12345")) {

                    Intent intent = new Intent(login.this, list_master.class);
                    startActivity(intent);

                } else {

                    stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {

                                jsonObject = new JSONObject(response);
                                String check = jsonObject.getString("status");
                                String message = jsonObject.getString("message");
                                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                                if (check.equals("true")){

                                    startActivity(new Intent(getApplicationContext(), listView.class));

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
//                            txtStatus.setText("Berhasil Login");
//                            txtStatus.setText(response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            notif.setText(error.toString());
                        }
                    }) {
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("email", email);
                            data.put("password", pass);
                            return data;
                        }
                    };

                    requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                }

                }

        });

//        Button Register
        bregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);

            }
        });

//        Button Without Account
        btry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(login.this, listView.class);
                startActivity(intent);

            }
        });

    }

}