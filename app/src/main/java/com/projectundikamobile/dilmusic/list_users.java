package com.projectundikamobile.dilmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class list_users extends AppCompatActivity {

//    local Server
    private String URL = "http://192.168.0.113/dbDilMusic/select.php";

    private StringRequest stringRequest;
    private RequestQueue requestQueue;

    private TextView txtusers;
    private ListView listusers2;
    //private EditText txtemail, txtpass, txtnohp;

    //deklarasi variable untuk Json
    private JSONObject jsonObj, jsonData; //digunakan untuk proses pengambilan data JSon
    private JSONArray jsonusers;

    private String id, email, pass, nohp; //variabel ini digunakan untuk menampung isi dari JSON "email" dan "password" dan "NoHp"
    ArrayAdapter<String> adapter_users; //digunakan untuk menampung data ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        //konfigurasi
        txtusers = (TextView) findViewById(R.id.txtusers);
        listusers2 = (ListView)findViewById(R.id.listusers2);

        //membuat constructor ArrayAdapter (dengan 2 parameter)
        //android.R.layout.simple_list_item_1 adalah layout bawaan dari Android sendiri
        adapter_users = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);

        //instance of class
        stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //text akan tertulis jika masuk di method onResponse(String response)
                txtusers.setText("List Users DilMusic");
                //transfer dari JSON ke Android
                try {
                    //instance of class JSONObj
                    jsonObj = new JSONObject(response);
                    //instance of class JSONObj. Isi parameter berdasarkan dari nama array di JSON
                    jsonusers = jsonObj.getJSONArray("users");

                    //hitung jumlah baris data
                    for (int i = 0; i < jsonusers.length(); i++)
                    {
                        //instance of class JSONObj untuk per baris, tampung ke dalam variable
                        jsonData = jsonusers.getJSONObject(i);
                        id  = jsonData.getString("id");
                        email = jsonData.getString("email");
                        pass = jsonData.getString("password");
                        nohp = jsonData.getString("nohp");

                        //kalau sudah dapet dari JSON, waktunya anda memasukan ke dalam adapter Listview
                        //membuat data adapter menggunakan method add()
                        adapter_users.add("Id : " + id + "\n" + "User : " + email + "\n" + "Pass : " + pass + "\n" + "NoHp : " + nohp);
//                        adapter_users.add(user);
                    }
                    //txtStatus_code.setText(user);
                    //mengirim data adapter utk di tempatkan ke dalam List view menggunakan method setAdapter()
                    listusers2.setAdapter(adapter_users);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //text akan tertulis jika masuk di method onErrorResponse(VolleyError error)
                txtusers.setText("masuk di method onErrorResponse(VolleyError error)");
            }
        })
        {
            //anda cukup menuliskan "map", lalu enter. Otomatis method getParams akan terbentuk
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };

        //request ke Volley
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);



    }
}