package com.example.crudapi.Network;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.crudapi.Activities.LoginActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class NetWorkClass extends JsonObjectRequest {

    public NetWorkClass(int method, String url, @Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    public NetWorkClass() {
        super(null, null, null, null);

    }
  public void getToken(int method,String url,JSONObject jsonObject,Response.Listener<JSONObject> listener,Response.ErrorListener errorListener,Context context){
        JsonObjectRequest request   = new JsonObjectRequest(method,url,jsonObject,listener,errorListener){

        };
      RequestQueue queue = Volley.newRequestQueue(context);
      queue.add(request);

  }

    public void getData(int method, String url, @Nullable JSONObject jsonRequest,
                        Response.Listener<JSONObject> listener,
                        Response.ErrorListener errorListener,
                        Context context) {
        String app_Token = LoginActivity.getAccessToken(context);
        JsonObjectRequest request = new JsonObjectRequest(method, url, jsonRequest, listener, errorListener) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer "+app_Token);
                Log.d("tok",app_Token);
                headers.put("User-Agent", "Mobile/Wavity");
                return headers;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }

    public void apiResponse(int method, String url, JSONObject payLoad, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, Context context) {
        String app_Token1 = LoginActivity.getAccessToken(context);
        JsonObjectRequest request = new JsonObjectRequest(method, url, payLoad, listener, errorListener) {
            @NonNull
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer  "+app_Token1);
                headers.put("User-Agent", "Mobile/Wavity");
                return headers;
            }
        };
        RequestQueue queue1 = Volley.newRequestQueue(context);
        queue1.add(request);
    }


}

