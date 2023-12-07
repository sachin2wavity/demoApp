package com.example.crudapi.Lists;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.crudapi.Activities.MainActivity;
import com.example.crudapi.Adapters.RecordAdapter;
import com.example.crudapi.Network.NetWorkClass;
import com.example.crudapi.Pojomodels.DataControlModel;
import com.example.crudapi.Pojomodels.DataTypesModel;
import com.example.crudapi.Pojomodels.RecordModel;
import com.example.crudapi.R;
import com.example.crudapi.Urls.Urls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RcidList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NetWorkClass netWorkClass = new NetWorkClass();
    private RecordModel recordModel = new RecordModel();
    private DataTypesModel typesModel = new DataTypesModel();
    private List<RecordModel> modelList = new ArrayList<>();
    private List<DataControlModel> controlModelList = new ArrayList<>();
    private List<DataTypesModel> dataTypesModelList = new ArrayList<>();
    private DataControlModel controlModel = new DataControlModel();
    private Urls url2 = new Urls();
    private Button button;
    private ActivityResultLauncher<Intent> resultLauncher;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcid_list);
        button = findViewById(R.id.createbtn);
        recyclerView = findViewById(R.id.recyclerview1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RcidList.this, MainActivity.class);
              startActivity(intent);
            }
        });
        JSONObject payload = new JSONObject();
        try {
            payload.put("start", 0);
            payload.put("rows", 15);
            payload.put("meta_filters", new JSONArray());
            payload.put("data_filters", new JSONArray());
            payload.put("filters", new JSONArray());
            payload.put("ignoreRecords", new JSONArray());
            payload.put("selectedRecords", new JSONArray());
            payload.put("selected_recordIds", new JSONArray());
            payload.put("application", url2.appid);
            payload.put("role", "normal");
            Log.d("payload", payload.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        netWorkClass.apiResponse(Request.Method.POST, url2.tableurl, payload, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray jsonArray = response.getJSONArray("records");
                    JSONObject object = null;
                    JSONArray formsArray = new JSONArray();
                    JSONObject fromsobject;
                    Log.d("res", response.toString());
                    for (int jsonlen = 0; jsonlen < jsonArray.length(); jsonlen++) {
                        object = jsonArray.getJSONObject(jsonlen);

                        RecordModel recordModel = new RecordModel(); // Create a new instance for each iteration
                        recordModel.setId(object.getString("id"));
                        Log.d("rcid", recordModel.getId());
                        recordModel.setRcid(object.getString("rcid"));
                        formsArray = object.getJSONArray("forms");
                        Log.d("name1", formsArray.toString());

                        modelList.add(recordModel);
                        Log.d("data", modelList.get(jsonlen).getRcid());
                    }
                    for (int i = 0; i < formsArray.length(); i++) {
                        String iddc = "";
                        String ctrltype = "";
                        JSONObject obj = formsArray.getJSONObject(i);
                        String id = obj.getString("id");
                        Log.d("id", id);
                        JSONArray dataControlsarray = obj.getJSONArray("datacontrols");
                        Log.d("array", dataControlsarray.toString());

                        JSONObject dataconObj = dataControlsarray.getJSONObject(i);
                        iddc = dataconObj.getString("id");
                        ctrltype = dataconObj.getString("ctrltype");
                        controlModel.setId(iddc);
                        controlModel.setCtrlType(ctrltype);
                        controlModelList.add(controlModel);

                        JSONArray dataTypeArray = dataconObj.getJSONArray("datatypes");
                        JSONObject datatypeObj = dataTypeArray.getJSONObject(i);
                        String dtId = datatypeObj.getString("id");
                        String type = datatypeObj.getString("type");
                        typesModel.setId(dtId);
                        typesModel.setType(type);
                        dataTypesModelList.add(typesModel);

                    }

                    processJsonArray(modelList);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", "Error occurred post", error);
            }
        }, getApplicationContext());

    }

    private void processJsonArray(List<RecordModel> modelList1) {
        Log.d("list size", String.valueOf(modelList1.size()));

        RecordAdapter adapter = new RecordAdapter(RcidList.this, modelList1);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(RcidList.this, RecyclerView.VERTICAL, false));

    }

}