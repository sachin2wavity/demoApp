package com.example.crudapi.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.crudapi.CreateModels.DatacontrolModel;
import com.example.crudapi.CreateModels.DatatypeModel;
import com.example.crudapi.CreateModels.FormModel;
import com.example.crudapi.CreateModels.RootModel;
import com.example.crudapi.Lists.RcidList;
import com.example.crudapi.Network.NetWorkClass;
import com.example.crudapi.Pojomodels.DataControlModel;
import com.example.crudapi.Pojomodels.RecordDataModel;
import com.example.crudapi.R;
import com.example.crudapi.Updateviews.AgeViewUpdate;
import com.example.crudapi.Updateviews.DateViewUpdate;
import com.example.crudapi.Updateviews.DropdownUpdate;
import com.example.crudapi.Updateviews.NameViewUpdate;
import com.example.crudapi.Updateviews.SegmentUpdate;
import com.example.crudapi.Updateviews.ToggleUpdae;
import com.example.crudapi.Urls.Urls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecordDetails extends AppCompatActivity {
    private DataControlModel dataControlModel2 = new DataControlModel();
    private DatatypeModel datatypeModel1 = new DatatypeModel();
    private List<DatatypeModel> datatypeModelList = new ArrayList<>();
    private List<DataControlModel> controlModelList2 = new ArrayList<>();
    private NetWorkClass nw = new NetWorkClass();
    private RecordDataModel recordDataModel = new RecordDataModel();
    private List<RecordDataModel> recordDataModelList = new ArrayList<>();
    private LinearLayout linearLayout;
    private Urls urls = new Urls();
    private List<String> valuesModelList = new ArrayList<>();
    private List<String> datalist = new ArrayList<>();
    private UpdateActivity updateActivity = new UpdateActivity();
    private TextView textView;
    private String name, date;
    private Boolean toggle;
    private int Number;
    private String text1, appId, formsId;
    private MainActivity activity = new MainActivity();
    private Button saveBtn;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_details);
        textView = findViewById(R.id.demo1);
        linearLayout = findViewById(R.id.linearlFinal);
        saveBtn = findViewById(R.id.saveButton);
        backBtn=findViewById(R.id.backButton);
        datalist.add("Test 1");
        datalist.add("Test 2");
        datalist.add("Test 3");
        datalist.add("Test 4");
        Intent intent = getIntent();
        String id = intent.getStringExtra("recordId");
        String rcid = intent.getStringExtra("rcid");
        textView.setText(rcid);

        values(null, controlModelList2, id);

        //String id = intent.getStringExtra("recordId");
        Log.d("recordid", id);
        JSONObject payloadObject = new JSONObject();
        try {
            payloadObject.put("text", name);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData(payloadObject, id);
                updateRecord(linearLayout, id);
                Intent intent1 = new Intent(RecordDetails.this, RcidList.class);
                startActivity(intent1);
            }
        });

    }

    public void values(JSONObject payload, List<DataControlModel> controlModelList3, String id) {

        nw.apiResponse(Request.Method.GET, urls.recurl + id + "?ownerDetail=true", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    appId = response.getString("application");
                    JSONArray formsAray = response.getJSONArray("forms");
                    for (int i = 0; i < formsAray.length(); i++) {
                        JSONObject formObj = formsAray.getJSONObject(i);
                        JSONArray datacontrolarray = formObj.getJSONArray("datacontrols");
                        JSONObject datacon = datacontrolarray.getJSONObject(i);
                        formsId = formObj.getString("id");
                        String ctrlType = datacon.getString("ctrltype");
                        Log.d("ct", formsId);

                        for (int n = 0; n < datacontrolarray.length(); n++) {
                            JSONObject dataControl = datacontrolarray.getJSONObject(n);

                            String dataControlId = dataControl.getString("id");
                            boolean oneTimeEntry = dataControl.getBoolean("oneTimeEntry");
                            String ctrlType1 = dataControl.getString("ctrltype");

                            Log.d("dc", ctrlType1);
                            dataControlModel2.setCtrlType(ctrlType1);
                            dataControlModel2.setId(dataControlId);
                            controlModelList2.add(dataControlModel2);

                            JSONArray datatypesArray = dataControl.getJSONArray("datatypes");

                            for (int j = 0; j < datatypesArray.length(); j++) {
                                JSONObject datatype = datatypesArray.getJSONObject(j);

                                // Extract information from the datatype
                                String datatypeId = datatype.getString("id");
                                String datatypeType = datatype.getString("type");
                                Log.d("dt", datatypeType);
                                datatypeModel1.setId(datatypeId);
                                datatypeModel1.setType(datatypeType);
                                datatypeModelList.add(datatypeModel1);
                                JSONArray valuesArray = datatype.getJSONArray("values");

                                for (int k = 0; k < valuesArray.length(); k++) {
                                    JSONObject value = valuesArray.getJSONObject(k);
                                    String valueType = value.getString("valuetype");
                                    int index = value.getInt("index");
                                    if (value.has("text")) {
                                        String text = value.getString("text");
                                        Log.d("text", text);
                                        recordDataModel.setText(text);
                                        if (controlModelList2.get(k).getCtrlType().equals("single_fields"))
                                        {
                                            NameViewUpdate nameViewUpdate = new NameViewUpdate(RecordDetails.this,null, controlModelList2.get(k).getId(), datatypeModelList.get(k).getId(), text);
                                            Log.d("iddc",controlModelList2.get(k).getId());
                                            Log.d("iddt", datatypeModelList.get(k).getId());
                                            linearLayout.addView(nameViewUpdate);
                                        }
                                    } else if (value.has("date")) {
                                        Long date = value.getLong("date");
                                        Log.d("date", date.toString());
                                        recordDataModel.setDate(date);
                                        recordDataModelList.add(recordDataModel);
                                        if (controlModelList2.get(k).getCtrlType().equals("date")) ;
                                        {
                                            DateViewUpdate dateViewUpdate = new DateViewUpdate(RecordDetails.this, "Date", controlModelList2.get(k).getId(), datatypeModelList.get(k).getId(), date);
                                            linearLayout.addView(dateViewUpdate);
                                        }
                                    } else if (value.has("number")) {
                                        int number = value.getInt("number");
                                        Log.d("age", number + "");
                                        recordDataModel.setAge(number);
                                        recordDataModelList.add(recordDataModel);
                                        if (controlModelList2.get(k).getCtrlType().equals("number")) {
                                            AgeViewUpdate ageViewUpdate = new AgeViewUpdate(RecordDetails.this, null, controlModelList2.get(k).getId(), datatypeModelList.get(k).getId(), number);
                                            linearLayout.addView(ageViewUpdate);
                                        }
                                    } else if (value.has("value")) {
                                        String valuetest = value.getString("value");
                                        Log.d("valuetxt", valuetest);
                                        recordDataModel.setValueTest(valuetest);
                                        recordDataModelList.add(recordDataModel);
                                        if (controlModelList2.get(k).getCtrlType().equals("category_dropdown"))
                                            ;
                                        {
                                            if (valuetest.equals("Test B") || valuetest.equals("Test A") || valuetest.equals("Test C")) {
                                                DropdownUpdate update = new DropdownUpdate(RecordDetails.this, "DropDown", controlModelList2.get(k).getId(), datatypeModelList.get(k).getId(), valuetest);
                                                linearLayout.addView(update);
                                            } else if (valuetest.equals("true") || valuetest.equals("false")) {
                                                Boolean b = Boolean.parseBoolean(valuetest);
                                                ToggleUpdae toggleUpdae = new ToggleUpdae(RecordDetails.this, null, controlModelList2.get(k).getId(), datatypeModelList.get(k).getId(), b);
                                                linearLayout.addView(toggleUpdae);
                                            } else {
                                                Log.d("grid", valuetest);
                                                SegmentUpdate update = new SegmentUpdate(RecordDetails.this, "Segment", controlModelList2.get(k).getId(), datatypeModelList.get(k).getId(), datalist, valuetest);
                                                linearLayout.addView(update);
                                            }

                                        }
                                    }

                                }

                            }
                        }
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, getApplicationContext());

    }

    public void updateData(JSONObject object, String id) {
        nw.apiResponse(Request.Method.PUT, urls.recurl + id, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("res", response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, getApplicationContext());
    }

    public void updateOperation(String id) {
        nw.getData(Request.Method.GET, urls.recurl + id + "?ownerDetail=true", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, getApplicationContext());
    }

    public void updateRecord(LinearLayout parentLayout, String rcid) {
        DatacontrolModel datacontrolModel = new DatacontrolModel();
        DatacontrolModel datacontrolModel1 = new DatacontrolModel();
        DatacontrolModel datacontrolModel2 = new DatacontrolModel();
        DatacontrolModel datacontrolModel3 = new DatacontrolModel();
        DatacontrolModel datacontrolModel4 = new DatacontrolModel();
        DatacontrolModel datacontrolModel5 = new DatacontrolModel();
        for (int i = 0; i < parentLayout.getChildCount(); i++) {
            View chlidView = parentLayout.getChildAt(i);
            if (chlidView instanceof NameViewUpdate) {
                NameViewUpdate nameViewUpdate = (NameViewUpdate) chlidView;
                EditText editText = nameViewUpdate.getEditText();
                try {
                    datacontrolModel = nameViewUpdate.getText();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (chlidView instanceof DateViewUpdate) {
                DateViewUpdate dateViewUpdate = (DateViewUpdate) chlidView;
                try {
                    datacontrolModel1 = dateViewUpdate.getText();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else if (chlidView instanceof AgeViewUpdate) {
                AgeViewUpdate ageViewUpdate = (AgeViewUpdate) chlidView;
                try {
                    datacontrolModel2 = ageViewUpdate.getText();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (chlidView instanceof DropdownUpdate) {
                DropdownUpdate update = (DropdownUpdate) chlidView;
                try {
                    datacontrolModel3 = update.getText();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (chlidView instanceof ToggleUpdae) {
                ToggleUpdae toggleUpdae = (ToggleUpdae) chlidView;
                try {
                    datacontrolModel4 = toggleUpdae.getText();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else if (chlidView instanceof SegmentUpdate) {
                SegmentUpdate update = (SegmentUpdate) chlidView;
                try {
                    datacontrolModel5 = update.getText();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        ArrayList<DatacontrolModel> datacontrolsList = new ArrayList<>();
        datacontrolsList.add(datacontrolModel);
        datacontrolsList.add(datacontrolModel1);
        datacontrolsList.add(datacontrolModel2);
        datacontrolsList.add(datacontrolModel3);
        datacontrolsList.add(datacontrolModel4);
        datacontrolsList.add(datacontrolModel5);
        FormModel formModel = new FormModel();
        formModel.setId(formsId);
        formModel.setDatacontrols(datacontrolsList);

// Create an ArrayList of FormModel and add the previously created instance
        ArrayList<FormModel> formsList = new ArrayList<>();
        formsList.add(formModel);

// Create an instance of RootModel
        RootModel rootModel = new RootModel();
        Log.d("recordid", rcid);
        rootModel.setRecordid(rcid);
        rootModel.setApplication(appId);
        rootModel.setStatus("active");
        rootModel.setState("open");
        rootModel.setLatitude(0);
        rootModel.setLongitude(0);
        rootModel.setForms(formsList);
        JSONObject object = null;
        try {
            object = new JSONObject(rootModel.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("Update payload", object.toString());
        getRecords(object, rcid);
    }

    public void getRecords(JSONObject payl, String id) {
        nw.apiResponse(Request.Method.PUT, urls.updateUrl + id, payl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("ok", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, getApplicationContext());
    }


}

