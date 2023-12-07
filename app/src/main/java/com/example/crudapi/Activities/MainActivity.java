package com.example.crudapi.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.crudapi.CreateModels.DatacontrolModel;
import com.example.crudapi.CreateModels.FormModel;
import com.example.crudapi.CreateModels.RootCreateModel;
import com.example.crudapi.CreateModels.RootModel;
import com.example.crudapi.Lists.RcidList;
import com.example.crudapi.ModelClases.AppDefination;
import com.example.crudapi.ModelClases.DataControlAppd;
import com.example.crudapi.ModelClases.DataTypePojo;
import com.example.crudapi.ModelClases.FormsModel;
import com.example.crudapi.ModelClases.ValuePojo;
import com.example.crudapi.Network.NetWorkClass;
import com.example.crudapi.Pojomodels.RecordModel;
import com.example.crudapi.R;
import com.example.crudapi.Urls.Urls;
import com.example.crudapi.Views.AgeView;
import com.example.crudapi.Views.DateView;
import com.example.crudapi.Views.DropdownView;
import com.example.crudapi.Views.NameView;
import com.example.crudapi.Views.SegmentView;
import com.example.crudapi.Views.ToggleView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private TextView textView;
    private ArrayList<ValuePojo> valuesModelList = new ArrayList<>();
    private List<JSONObject> jsonObjects = new ArrayList<>();
    private ArrayList<AppDefination> appDefinationArrayList = new ArrayList<>();
    private ArrayList<DataTypePojo> dataTypePojoList = new ArrayList<>();
    private ValuePojo valuePojo = new ValuePojo();
    private ArrayList<DataControlAppd> controlModelList = new ArrayList<>();
    private LinearLayout linearLayout;
    private JSONArray array = null;
    private JSONArray getArray;
    private Urls urls = new Urls();
    private Button button;
    private String Appid;
    private JSONArray arr = null;
    private UpdateActivity updateActivity = new UpdateActivity();
    private NetWorkClass nw = new NetWorkClass();
    private List<RecordModel> recordModels = new ArrayList<>();
    private FormsModel formPojo = new FormsModel();
    private AppDefination appDefination;
    private Urls url1 = new Urls();
    private RecordModel recordModel1 = new RecordModel();
    private List<RecordModel> model1 = new ArrayList<>();
    private List<String> datalist = new ArrayList<>();
    private RootModel rootModel = new RootModel();
    private ImageView backBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.linearlFinal);
        button = findViewById(R.id.createbtn);
        backBtn= findViewById(R.id.backButton);
        Button saveBtn = findViewById(R.id.saveButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RcidList.class);
                startActivity(intent);

            }
        });
        textView = findViewById(R.id.demo1);
        LinearLayout parentLayout = findViewById(R.id.linearlFinal);
        apiData(parentLayout, getApplicationContext());
        saveBtn.setOnClickListener(v -> {
            DatacontrolModel datacontrolModel = new DatacontrolModel();
            DatacontrolModel datacontrolModel1 = new DatacontrolModel();
            DatacontrolModel datacontrolModel2 = new DatacontrolModel();
            DatacontrolModel datacontrolModel3 = new DatacontrolModel();
            DatacontrolModel datacontrolModel4 = new DatacontrolModel();
            DatacontrolModel datacontrolModel5 = new DatacontrolModel();
            String txt;
            for (int i = 0; i < parentLayout.getChildCount(); i++) {
                View chlidView = parentLayout.getChildAt(i);

                if (chlidView instanceof NameView) {
                    NameView nameView = (NameView) chlidView;
                    try {
                        datacontrolModel = nameView.getText();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else if (chlidView instanceof DateView) {
                    DateView dateView = (DateView) chlidView;
                    try {
                        datacontrolModel1 = dateView.getText();
                        Log.d("data2", datacontrolModel1.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (chlidView instanceof AgeView) {
                    AgeView ageView = (AgeView) chlidView;
                    try {
                        datacontrolModel2 = ageView.getText();
                        Log.d("data2", datacontrolModel2.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (chlidView instanceof DropdownView) {
                    DropdownView dropdownView = (DropdownView) chlidView;
                    try {
                        datacontrolModel3 = dropdownView.getText();
                        Log.d("data2", datacontrolModel2.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (chlidView instanceof com.example.crudapi.Views.ToggleView) {
                    ToggleView toggleView = (ToggleView) chlidView;
                    try {
                        datacontrolModel4 = toggleView.getText();
                        Log.d("data2", datacontrolModel2.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (chlidView instanceof com.example.crudapi.Views.SegmentView) {
                    SegmentView segmentView = (SegmentView) chlidView;
                    try {
                        datacontrolModel5 = segmentView.getText();
                        Log.d("data2", datacontrolModel2.toString());
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
            formModel.setId(formPojo.getId());
            formModel.setDatacontrols(datacontrolsList);
            ArrayList<FormModel> formsList = new ArrayList<>();
            formsList.add(formModel);
            RootCreateModel rootModel = new RootCreateModel();
            rootModel.setApplication(appDefination.getId());
            rootModel.setState("open");
            rootModel.setLatitude(0);
            rootModel.setLongitude(0);
            rootModel.setForms(formsList);
            Log.d("record", rootModel.toString());
            JSONObject object=null;
            try {
                 object = new JSONObject(rootModel.toString());
                Log.d("obj", object.toString());
                getRecords(object);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        });
    }

    public void getRecords(JSONObject payl) {
        nw.apiResponse(Request.Method.POST, urls.createUrl, payl, new Response.Listener<JSONObject>() {
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

    public void apiData(LinearLayout parentLayot, Context context) {

        nw.getData(Method.GET, urls.url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String appid = response.getString("id");
                    String appCap = response.getString("caption");
                    String description = response.getString("description");
                    long createdTime = response.getLong("created_time");
                    long modifiedTime = response.getLong("modified_time");
                    String createdBy = response.getString("created_by");
                    String modifiedBy = response.getString("modified_by");
                    Long versionNumber = response.getLong("version_number");
                    long versionStamp = response.getLong("version_stamp");
                    String status = response.getString("status");
                    boolean catalogue = response.getBoolean("catalogue");
                    String prefix = response.getString("prefix");
                    String appType = response.getString("application_type");
                    appDefination = new AppDefination();
                    appDefination.setId(appid);
                    appDefination.setCaption(appCap);
                    appDefination.setCreated_time(createdTime);
                    appDefination.setModified_time(modifiedTime);
                    appDefination.setCreated_by(createdBy);
                    appDefination.setModified_by(modifiedBy);
                    appDefination.setVersion_number(versionNumber);
                    appDefination.setVersion_stamp(versionStamp);
                    appDefination.setStatus(status);
                    appDefination.setCatalogue(catalogue);
                    appDefination.setPrefix(prefix);
                    appDefination.setApplication_type(appType);
                    appDefinationArrayList.add(appDefination);
                      textView.setText(appCap);

                    JSONArray jsonArray = response.getJSONArray("forms");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Log.d("dt", jsonObject.toString());
                        array = jsonObject.getJSONArray("datacontrols");
                        String id = jsonObject.getString("id");
                        formPojo.setId(id);
                    }
                    for (int j = 0; j < array.length(); j++) {
                        JSONObject object = array.getJSONObject(j);
                        String id = object.getString("id");
                        String caption1 = object.getString("caption");
                        String ctrltype = object.getString("ctrltype");
                        String title = object.getString("title");
                        Boolean deprecated = object.getBoolean("deprecated");
                        Boolean required1 = object.getBoolean("required");
                        DataControlAppd controlModel = new DataControlAppd();
                        Log.d("ck", ctrltype);
                        controlModel.setId(id);
                        controlModel.setCaption(caption1);
                        controlModel.setCtrltype(ctrltype);
                        controlModel.setTitle(title);
                        controlModel.setDeprecated(deprecated);
                        controlModel.setRequired(required1);
                        controlModelList.add(controlModel);
                        formPojo.setDatacontrols(controlModelList);

                        JSONArray array1 = object.getJSONArray("datatypes");
                        String iddt = "";
                        String dataType = "";
                        String type = "";
                        String caption = "";
                        String placeHolder = "";
                        Integer fontSize = 0;
                        String fontStyle = "";
                        int max_len;
                        Boolean required = false;
                        String colortxt = "";
                        for (int i = 0; i < array1.length(); i++) {
                            try {
                                JSONObject jsonObj = array1.getJSONObject(i);
                                DataTypePojo model = new DataTypePojo();
                                iddt = jsonObj.getString("id");
                                dataType = jsonObj.getString("datatype");
                                type = jsonObj.getString("type");
                                caption = jsonObj.getString("caption");
                                if (jsonObj.has("values"))
                                {
                                    JSONArray valuesArray = jsonObj.getJSONArray("values");
                                    datalist.clear();
                                    for (int valuearr=0;valuearr<valuesArray.length();valuearr++)
                                    {
                                        JSONObject jsonObject = valuesArray.getJSONObject(valuearr);
                                        String values = jsonObject.getString("value");
                                        Log.d("val1",values);
                                        datalist.add(values);

                                    }
                                }
                                if (jsonObj.has("placeholder")) {
                                    placeHolder = jsonObj.getString("placeholder");
                                    fontSize = Integer.valueOf(jsonObj.getString("fontSize"));
                                    fontStyle = jsonObj.getString("fontStyle");
                                    colortxt = jsonObj.getString("textColor");
                                }
                                if (jsonObj.has("max_length")) {
                                    max_len = Integer.valueOf(jsonObj.getString("max_length"));
                                    model.setMax_length(max_len);
                                } else {
                                    model.setMax_length(0);
                                }
                                required = jsonObj.getBoolean("required");
                                model.setDatatype(dataType);
                                model.setType(type);
                                model.setCaption(caption);
                                model.setPlaceholder(placeHolder);
                                model.setFontSize(fontSize);
                                model.setFontStyle(fontStyle);
                                model.setTextColor(colortxt);
                                model.setRequired(required);
                                model.setIddt(iddt);
                                dataTypePojoList.add(model);
                                controlModel.setDatatypes(dataTypePojoList);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    for (int i = 0; i < controlModelList.size(); i++) {
                        Log.d("datatypelist", controlModelList.get(i).getCtrltype());
                        if (controlModelList.get(i).getCtrltype().equals("single_fields")) {
                            NameView textView1 = new NameView(MainActivity.this, controlModelList.get(i).getCaption(), dataTypePojoList.get(i).getPlaceholder(), controlModelList.get(i).getId(), dataTypePojoList.get(i).getIddt());
                            parentLayot.addView(textView1);
                        } else if (controlModelList.get(i).getCtrltype().equals("date")) {
                            DateView textView2 = new DateView(MainActivity.this, controlModelList.get(i).getCaption(), controlModelList.get(i).getId(), dataTypePojoList.get(i).getIddt());
                            parentLayot.addView(textView2);
                        } else if (controlModelList.get(i).getCtrltype().equals("number")) {
                            AgeView ageView = new AgeView(MainActivity.this, controlModelList.get(i).getCaption(), controlModelList.get(i).getId(), dataTypePojoList.get(i).getIddt());
                            Log.d("dataid", dataTypePojoList.get(i).getIddt());
                            parentLayot.addView(ageView);
                        } else if (controlModelList.get(i).getCtrltype().equals("category_dropdown")) {
                            DropdownView dropdownView = new DropdownView(MainActivity.this, controlModelList.get(i).getCaption(), controlModelList.get(i).getId(), dataTypePojoList.get(i).getIddt());
                            parentLayot.addView(dropdownView);
                        } else if (controlModelList.get(i).getCtrltype().equals("category_toggle")) {
                            ToggleView toggleView = new ToggleView(MainActivity.this, controlModelList.get(i).getCaption(), controlModelList.get(i).getId(), dataTypePojoList.get(i).getIddt());
                            parentLayot.addView(toggleView);
                        } else if (controlModelList.get(i).getCtrltype().equals("category_segment")) {
                            SegmentView segmentView = new SegmentView(MainActivity.this, controlModelList.get(i).getCaption(), controlModelList.get(i).getId(), dataTypePojoList.get(i).getIddt(), datalist);
                            parentLayot.addView(segmentView);
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "No data", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle errors here.
                Log.e("Volley Error", error.toString());
            }
        }, context);
    }


}






