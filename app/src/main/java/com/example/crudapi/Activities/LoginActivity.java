package com.example.crudapi.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.crudapi.Lists.RcidList;
import com.example.crudapi.Network.NetWorkClass;
import com.example.crudapi.R;
import com.example.crudapi.Urls.Urls;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText txtusername, txtpassword;
    private Button signBtn;
    private Urls urls = new Urls();
    private NetWorkClass netWorkClass = new NetWorkClass();
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtusername = findViewById(R.id.txtusername);
        txtpassword = findViewById(R.id.txtpass);
        signBtn = findViewById(R.id.btn_sign);
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtusername.getText().toString();
                String password = txtpassword.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
                }

                JSONObject jsBody = loginToApp(username, password);
                netWorkClass.getToken(Request.Method.POST, urls.loginUrl, jsBody, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (response.has("access_token")) {
                            String token = null;
                            try {
                                token = response.getString("access_token");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            if (token != null && !token.isEmpty()) {
                                Intent intent = new Intent(LoginActivity.this, RcidList.class);
                                preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("access_token", token);
                                editor.apply();
                                startActivity(intent);

                            }
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, getApplicationContext());

            }
        });
    }

    public JSONObject loginToApp(String username, String password) {
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("username", username);
            jsonBody.put("password", password);
            jsonBody.put("grant_type", "password");
            jsonBody.put("scope", "mobileinfo");
            jsonBody.put("latitude", "0");
            jsonBody.put("longitude", "0");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonBody;

    }

    public static String getAccessToken(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        return preferences.getString("access_token", null);
    }

}