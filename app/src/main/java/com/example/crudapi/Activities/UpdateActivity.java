package com.example.crudapi.Activities;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.crudapi.ModelClases.DataControlModel;
import com.example.crudapi.ModelClases.DataTypesModel;
import com.example.crudapi.Network.NetWorkClass;
import com.example.crudapi.Pojomodels.RecordDataModel;
import com.example.crudapi.R;
import com.example.crudapi.Urls.Urls;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class UpdateActivity extends AppCompatActivity {
    LinearLayout linearLayout;

    TextView textView;
    DataControlModel controlModel = new DataControlModel();
    List<DataTypesModel> dataTypesModelList = new ArrayList<>();
    List<DataTypesModel> dataTypesModelList2 = new ArrayList<>();
    List<String> valuesModelList = new ArrayList<String>();
    List<JSONObject> jsonObjects = new ArrayList<>();
    DataTypesModel model = new DataTypesModel();
    List<DataControlModel> controlModelList = new ArrayList<>();
    com.example.crudapi.Pojomodels.DataControlModel dataControlModel2 =new com.example.crudapi.Pojomodels.DataControlModel();
    List<com.example.crudapi.Pojomodels.DataControlModel> controlModelList2 = new ArrayList<>();

    JSONArray array = null;
    JSONArray getArray;
    Urls urls = new Urls();
    Button button;
    JSONArray arr = null;
    NetWorkClass nw = new NetWorkClass();
    RecordDataModel recordDataModel = new RecordDataModel();
    List<RecordDataModel> recordDataModelList = new ArrayList<>();

   Button saveBtn ;
    public UpdateActivity() {
        // Default constructor with no arguments
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        linearLayout = findViewById(R.id.linearlFinal);
        textView = findViewById(R.id.demo1);
        saveBtn = findViewById(R.id.saveButton);
        button =findViewById(R.id.createbtn);
//        nw.fetchDataFromApi(getApplicationContext());
//        String jsonSbuttring ="{\"id\":\"fa27a799-68ca-4689-a172-23dfb9458646\",\"application\":\"14ed2651-88d0-4d02-8b54-0104602b6245\",\"status\":\"active\",\"created_time\":1699966129128,\"modified_time\":1700207484173,\"created_by\":\"99ec78df-8626-4aa3-9dc8-69b4cd079abe\",\"modified_by\":\"99ec78df-8626-4aa3-9dc8-69b4cd079abe\",\"latitude\":0,\"longitude\":0,\"update_latitude\":0,\"update_longitude\":0,\"state\":\"open\",\"forms\":[{\"id\":\"27489d44-29d3-47b5-8d37-5938c2889da7\",\"datacontrols\":[{\"id\":\"a7238712-a09c-496a-9629-ac21946850ee\",\"oneTimeEntry\":false,\"ctrltype\":\"single_fields\",\"datatypes\":[{\"id\":\"c2d02a39-97b0-4a4d-9de3-3427b3cde361\",\"type\":\"text\",\"values\":[{\"valuetype\":\"text\",\"text\":\"vvxxvxv\",\"rich\":false}],\"index\":0,\"subtype\":\"text\",\"criteria_values\":[]}],\"summary\":[],\"customforms\":[]},{\"id\":\"b199e73c-91f0-4c15-bede-40bd97f8eb07\",\"oneTimeEntry\":false,\"ctrltype\":\"date\",\"datatypes\":[{\"id\":\"14aaab10-79ec-4680-8e85-2f58ed301057\",\"type\":\"datepicker\",\"values\":[{\"valuetype\":\"date\",\"index\":-1,\"date\":1700024400000,\"time\":0,\"criteria_values\":[],\"start_time\":0,\"end_time\":0}],\"index\":0,\"subtype\":\"datepicker\",\"criteria_values\":[]}],\"summary\":[],\"customforms\":[]},{\"id\":\"642db483-9d9b-43b0-b645-4d34d755ee73\",\"oneTimeEntry\":false,\"ctrltype\":\"number\",\"datatypes\":[{\"id\":\"306c8941-3fab-440f-a11b-af26bbbb6a3d\",\"type\":\"number\",\"values\":[{\"valuetype\":\"number\",\"index\":-1,\"number\":56,\"currency\":false,\"criteria_values\":[]}],\"index\":0,\"subtype\":\"number\",\"criteria_values\":[]}],\"summary\":[],\"customforms\":[]},{\"id\":\"8c7b2a9b-188a-439c-9adf-351e71d72fd6\",\"oneTimeEntry\":false,\"ctrltype\":\"category_dropdown\",\"datatypes\":[{\"id\":\"dff02f92-c105-4060-abf9-6959d882f8fe\",\"type\":\"category\",\"values\":[{\"valuetype\":\"category\",\"index\":-1,\"name\":\"Test A\",\"value\":\"Test A\",\"criteria_values\":[]}],\"index\":0,\"subtype\":\"singleselect\",\"criteria_values\":[]}],\"summary\":[],\"customforms\":[]},{\"id\":\"beddc8c3-a36f-4ba2-bcdc-c9a9e7f0265a\",\"oneTimeEntry\":false,\"ctrltype\":\"category_toggle\",\"datatypes\":[{\"id\":\"2ad71a82-c650-49d1-85f7-1f35c83d08ff\",\"type\":\"category\",\"values\":[{\"valuetype\":\"category\",\"index\":-1,\"name\":\"true\",\"value\":\"true\",\"criteria_values\":[]}],\"index\":0,\"subtype\":\"singleselect\",\"criteria_values\":[]}],\"summary\":[],\"customforms\":[]},{\"id\":\"94044cab-7254-495f-9b9b-b613c08e5a19\",\"oneTimeEntry\":false,\"ctrltype\":\"category_segment\",\"datatypes\":[{\"id\":\"03f884a6-57e7-4961-b6f1-38b071e85b2e\",\"type\":\"category\",\"values\":[{\"valuetype\":\"category\",\"index\":-1,\"name\":\"Test 2\",\"value\":\"Test 2\",\"criteria_values\":[]}],\"index\":0,\"subtype\":\"singleselect\",\"criteria_values\":[]}],\"summary\":[],\"customforms\":[]}],\"sections\":[]}],\"updateFmExcel\":false,\"rcid\":\"OTS-12\",\"app_version\":4,\"ownerDetail\":{\"id\":\"99ec78df-8626-4aa3-9dc8-69b4cd079abe\",\"created_time\":1695296861127,\"modified_time\":1699937983339,\"created_by\":\"de434441-16da-482c-8dba-45110ae5a9b7\",\"modified_by\":\"e06d0890-ac21-4880-a0c6-58b40e7755e7\",\"status\":\"active\",\"firstname\":\"Sachin\",\"middlename\":\"\",\"lastname\":\"Dighade\",\"role\":\"admin\",\"preferences\":{\"address\":{},\"ui_locale\":\"en_US\",\"data_locale\":\"en_US\",\"timezone\":\"America/New_York\",\"manager\":{\"id\":\"e06d0890-ac21-4880-a0c6-58b40e7755e7\",\"name\":\"rama\",\"email\":\"ramamohank@wavity.com\",\"phone\":{},\"firstname\":\"Ramamohan Reddy\",\"middlename\":\"\",\"lastname\":\"Kasireddy\"},\"landingpage\":{\"landing_page_type\":\"home\",\"group_dashboard\":{}},\"solutions\":[],\"custom_attr\":{}},\"outOfOfficeStatus\":\"inactive\",\"email\":\"sachind@wavity.com\",\"manager_id\":\"e06d0890-ac21-4880-a0c6-58b40e7755e7\",\"sms\":false,\"device\":false,\"group_count\":1,\"dashboard\":\"3723746e-335f-4150-ad71-fdaef5565520\",\"groups\":[{\"group_id\":\"0bf1c6a8-976c-4027-936a-ea8c164a9b0b\",\"group_name\":\"Mobile\"}]}}";
//        try {
//            JSONObject jsonObject = new JSONObject(jsonString);
//        //   values(jsonObject);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

apiData();
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =new Intent(UpdateActivity.this,MainActivity.class);
        startActivity(intent);
    }
});
    //    values(null);
saveBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//        try {
//            createData();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }
});

    }
    public  void getRecords(JSONObject payLoad){

nw.apiResponse(Request.Method.POST,urls.tableurl,payLoad, new Response.Listener<JSONObject>() {
    @Override
    public void onResponse(JSONObject response) {
        try {
            JSONArray object = response.getJSONArray("records");
            Log.d("resz",object.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("ok",response.toString());

    }
}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {

    }
},getApplicationContext());
    }

    public void values(JSONObject payload)
    {
        nw.apiResponse(Request.Method.GET,urls.recurl,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray formsAray = response.getJSONArray("forms");
                    for (int i=0;i<formsAray.length();i++) {
                        JSONObject formObj = formsAray.getJSONObject(i);
                        JSONArray datacontrolarray = formObj.getJSONArray("datacontrols");
                        JSONObject datacon = datacontrolarray.getJSONObject(i);
                        String id = datacon.getString("id");
                        String ctrlType = datacon.getString("ctrltype");
                        Log.d("ct", ctrlType);

                        for (int n = 0; n < datacontrolarray.length(); n++) {
                            JSONObject dataControl = datacontrolarray.getJSONObject(n);

                            // Extract information from the datacontrol
                            String dataControlId = dataControl.getString("id");
                            boolean oneTimeEntry = dataControl.getBoolean("oneTimeEntry");
                            String ctrlType1 = dataControl.getString("ctrltype");

                            Log.d("dc",ctrlType1);
                            dataControlModel2.setCtrlType(ctrlType1);
                            dataControlModel2.setId(dataControlId);
                            controlModelList2.add(dataControlModel2);

                            JSONArray datatypesArray = dataControl.getJSONArray("datatypes");

                            for (int j = 0; j < datatypesArray.length(); j++) {
                                JSONObject datatype = datatypesArray.getJSONObject(j);

                                // Extract information from the datatype
                                String datatypeId = datatype.getString("id");
                                String datatypeType = datatype.getString("type");
                                   Log.d("dt",datatypeType);
                                JSONArray valuesArray = datatype.getJSONArray("values");

                                for (int k = 0; k < valuesArray.length(); k++) {
                                    JSONObject value = valuesArray.getJSONObject(k);

                                    // Extract information from the value
                                    String valueType = value.getString("valuetype");
                                    int index = value.getInt("index");
                                    if (value.has("text")) {
                                        String text = value.getString("text");
                                        Log.d("text", text);
                                        recordDataModel.setText(text);
                                        recordDataModelList.add(recordDataModel);
                                    }else if (value.has("date"))
                                    {
                                        Long date =value.getLong("date");
                                        Log.d("date",date.toString());
                                        recordDataModel.setDate(date);
                                        recordDataModelList.add(recordDataModel);
                                    }else if (value.has("number"))
                                    {
                                        int number =value.getInt("number");
                                        Log.d("age",number+"");
                                        recordDataModel.setAge(number);
                                        recordDataModelList.add(recordDataModel);
                                    }else if (value.has("value"))
                                    {
                                        String valuetest = value.getString("value");
                                        Log.d("valuetxt",valuetest);
                                        recordDataModel.setValueTest(valuetest);
                                        recordDataModelList.add(recordDataModel);
                                    }
                                    // ... extract other fields as needed
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
        },getApplicationContext());
    }
    public void apiData() {

        nw.getData(Request.Method.GET, urls.url
               , null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String data = response.getString("caption");
                    Log.d("no", data);
                    textView.setText(data);
                    JSONArray jsonArray = response.getJSONArray("forms");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Log.d("dt", jsonObject.toString());
                        array = jsonObject.getJSONArray("datacontrols");
                        String id = jsonObject.getString("id");


                    }
                    for (int j = 0; j < array.length(); j++) {
                        JSONObject object = array.getJSONObject(j);
                        String id = object.getString("id");
                        String caption1 = object.getString("caption");
                        String ctrltype = object.getString("ctrltype");
                        String title = object.getString("title");
                        Boolean deprecated = object.getBoolean("deprecated");
                        Log.d("ck", ctrltype);
                        controlModel.setId(id);
                        controlModel.setCaption(caption1);
                        controlModel.setCtrltype(ctrltype);
                        controlModel.setTitle(title);
                        controlModel.setDeprecated(deprecated);
                        controlModelList.add(new DataControlModel(caption1, id, ctrltype, title, deprecated));

                        JSONArray array1 = object.getJSONArray("datatypes");
                        String dataType = "";
                        String type = "";
                        String caption = "";
                        String placeHolder = "";
                        Integer fontSize;
                        String fontStyle = "";
                        Integer max_len;
                        Boolean required = false;
                        String colortxt = "";
                        for (int i = 0; i < array1.length(); i++) {
                            try {
                                JSONObject jsonObj = array1.getJSONObject(i);

                                dataType = jsonObj.getString("datatype");
                                type = jsonObj.getString("type");
                                caption = jsonObj.getString("caption");
                                if (jsonObj.has("placeholder")) {
                                    placeHolder = jsonObj.getString("placeholder");
                                    fontSize = Integer.valueOf(jsonObj.getString("fontSize"));
                                    fontStyle = jsonObj.getString("fontStyle");
                                    colortxt = jsonObj.getString("textColor");

                                    if (jsonObj.has("max_length")) {
                                        max_len = Integer.valueOf(jsonObj.getString("max_length"));
                                        model.setMax_len(max_len);
                                    } else {
                                        model.setMax_len(0);
                                    }
                                    required = jsonObj.getBoolean("required");
                                    model.setDataType(dataType);
                                    model.setType(type);
                                    model.setCaption(caption);
                                    model.setPlaceholder(placeHolder);
                                    model.setFontsizr(fontSize);
                                    model.setFontstyle(fontStyle);
                                    model.setColor(colortxt);
                                    model.setRequired(required);
                                    if (controlModelList.get(i).getCtrltype().equals("category_dropdown")) {
                                        arr = jsonObj.getJSONArray("values");
                                        for (int k = 0; k < 3; k++) {
                                            JSONObject one = arr.getJSONObject(k);
                                            String value = one.getString("value");
                                            valuesModelList.add(value);
                                        }
                                    }

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                    }
                    for (int i = 0; i < controlModelList.size(); i++) {
                        if (controlModelList.get(i).getCtrltype().equals("single_fields")) {
                            addTextview(controlModelList.get(i).getCaption());
                        } else if (controlModelList.get(i).getCtrltype().equals("date")) {
                            addDateView(controlModelList.get(i).getCaption());
                        } else if (controlModelList.get(i).getCtrltype().equals("number")) {
                            addAge(controlModelList.get(i).getCaption());
                        } else if (controlModelList.get(i).getCtrltype().equals("category_dropdown")) {
                            addValues(controlModelList.get(i).getCaption());
                        } else if (controlModelList.get(i).getCtrltype().equals("category_toggle")) {
                            addToggle(controlModelList.get(i).getCaption());
                        } else if (controlModelList.get(i).getCtrltype().equals("category_segment")) {
                            valuesModelList.add("Test A");
                            valuesModelList.add("Test B");
                            valuesModelList.add("Test c");
                            addBtn(valuesModelList, controlModelList.get(i).getCaption());
                        }

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(UpdateActivity.this, "No data", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle errors here.
                Log.e("Volley Error", error.toString());
            }
        }, getApplicationContext());
    }

    public void addTextview(String text) {
        TextView textView = new TextView(UpdateActivity.this);
       // textView.setText(cap);
        textView.setText(text);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 16, 10, 25);
        textView.setLayoutParams(params);
        LinearLayout parentLayout = findViewById(R.id.linearlFinal);
        parentLayout.addView(textView);
        EditText editText = new EditText(UpdateActivity.this);
        String hint = model.getPlaceholder();
        editText.setHint(hint);
        editText.setPadding(30, 20, 20, 20);

// Create a SpannableString with the hint text
        SpannableString spannableString = new SpannableString(hint);

// Apply padding to the entire hint
        int paddingInPx = 30; // adjust as needed
        spannableString.setSpan(new PaddingLeftSpan(paddingInPx), 0, spannableString.length(), 0);

// Set the modified SpannableString as the hint for the EditText
        editText.setHint(spannableString);


        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params1.setMargins(20, 5, 0, 0);
        editText.setBackground(getDrawable(R.drawable.editback));
        editText.setElevation(10.0f);
        editText.setLayoutParams(params1);
        linearLayout.addView(editText);
        View view = new View(UpdateActivity.this);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                3
        );
        view.setLayoutParams(params2);
        params2.setMargins(0, 40, 0, 5);
        view.setBackgroundColor(Color.LTGRAY);

        linearLayout.addView(view);

    }

    public void addDateView(String cap) {
        TextView textView = new TextView(UpdateActivity.this);

        textView.setText(cap+"");

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 16, 16, 25);
        textView.setLayoutParams(params);
        linearLayout.addView(textView);
        RelativeLayout relativeLayout = new RelativeLayout(UpdateActivity.this);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        linearLayout.addView(relativeLayout);
        TextView textView1 = new TextView(UpdateActivity.this);
        textView1.setHint("select date");
        textView1.getText();
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        textView1.setLayoutParams(params3);
        ImageView imageView = new ImageView(UpdateActivity.this);
        imageView.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
        LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(
                50,
                50
        );
        imageView.setLayoutParams(params4);
        params4.setMargins(850, 5, 25, 20);
        imageView.setOnClickListener(new View.OnClickListener() {
            final Calendar calendar = Calendar.getInstance();
            final int y = 2023;
            final int m = calendar.get(Calendar.MONTH);
            final int d = calendar.get(Calendar.DAY_OF_MONTH);

            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(UpdateActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String monthString = new SimpleDateFormat("MMM ", Locale.getDefault()).format(new Date(0, month, 1));
                        String selectedDate = monthString + " " + dayOfMonth + ", " + 2023;
                        textView1.setText(selectedDate);
                    }
                }, m, d, y);
                datePickerDialog.show();
            }
        });

        relativeLayout.addView(textView1);
        relativeLayout.addView(imageView);


        View view = new View(UpdateActivity.this);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                3
        );
        view.setLayoutParams(params2);
        params2.setMargins(0, 40, 0, 5);
        view.setBackgroundColor(Color.LTGRAY);
        linearLayout.addView(view);

    }

    public void addOtherView(int j) {
        TextView textView = new TextView(UpdateActivity.this);
        textView.setText(dataTypesModelList.get(j).getCaption());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 16, 16, 25);
        textView.setLayoutParams(params);
        LinearLayout parentLayout = findViewById(R.id.linearlFinal);
        parentLayout.addView(textView);
        EditText editText = new EditText(UpdateActivity.this);
        editText.setHint(dataTypesModelList.get(j).getPlaceholder());
        int leftPadding = 20;
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        params1.setMargins(0, 5, 0, 0);
        editText.setBackground(getDrawable(R.drawable.editback));
        editText.setElevation(10.0f);
        linearLayout.addView(editText);
        View view = new View(UpdateActivity.this);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                3
        );
        view.setLayoutParams(params2);
        params2.setMargins(0, 40, 0, 5);
        view.setBackgroundColor(Color.LTGRAY);

        linearLayout.addView(view);
    }

    public void addBtn(List<String> valuesModelList, String cap) {
        TextView textView = new TextView(UpdateActivity.this);
        textView.setText(cap);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 16, 16, 25);
        textView.setLayoutParams(params);
        linearLayout.addView(textView);
        RelativeLayout relativeLayout = new RelativeLayout(UpdateActivity.this);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        GridView gridView = new GridView(getApplicationContext());
        GridView.LayoutParams params5 = new GridView.LayoutParams(
                GridView.LayoutParams.WRAP_CONTENT, // Width, can be MATCH_PARENT, WRAP_CONTENT, or a specific size in pixels
                GridView.LayoutParams.WRAP_CONTENT   // Height, can be MATCH_PARENT, WRAP_CONTENT, or a specific size in pixels
        );
        gridView.setLayoutParams(params5);
        gridView.setNumColumns(3);
       // CustomAdapter adapter = new CustomAdapter(UpdateActivity.this, valuesModelList);
    //    gridView.setAdapter(adapter);
        linearLayout.addView(gridView);
        View view = new View(UpdateActivity.this);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                3
        );
        view.setLayoutParams(params2);
        params2.setMargins(0, 40, 0, 5);
        view.setBackgroundColor(Color.LTGRAY);

        linearLayout.addView(view);

    }

    public void addToggle(String capa) {
        LinearLayout horizontalLayout = new LinearLayout(this);
        horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView textView = new TextView(UpdateActivity.this);
        textView.setText(capa);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 16, 16, 25);

        textView.setLayoutParams(params);

        horizontalLayout.addView(textView);
        Switch switchButton = new Switch(this);
        switchButton.setId(View.generateViewId());

        switchButton.setChecked(false);
        switchButton.setTextOn("ON");
        switchButton.setTextOff("OFF");

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Handle switch state changes
                ColorStateList colorStateList = ColorStateList.valueOf(Color.parseColor("#87CEEB"));
                ColorStateList colorStateList1 = ColorStateList.valueOf(Color.WHITE);

                if (isChecked) {
                    switchButton.setThumbTintList(colorStateList);
                    switchButton.setTrackTintList(colorStateList);
                } else {
                    switchButton.setThumbTintList(colorStateList1);
                    switchButton.setTrackTintList(colorStateList1);
                }
            }
        });

        LinearLayout.LayoutParams switchParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        switchParams.setMargins(700, 20, 15, 0);  // Adjust margins as needed

        switchButton.setLayoutParams(switchParams);
        horizontalLayout.addView(switchButton);
        linearLayout.addView(horizontalLayout);



        View view = new View(UpdateActivity.this);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                3
        );
        view.setLayoutParams(params2);
        params2.setMargins(0, 40, 0, 5);
        view.setBackgroundColor(Color.LTGRAY);

        linearLayout.addView(view);

    }

    public void addAge(String cap) {
        TextView textView = new TextView(UpdateActivity.this);
        textView.setText(cap);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 16, 16, 25);
        textView.setLayoutParams(params);
        LinearLayout parentLayout = findViewById(R.id.linearlFinal);
        parentLayout.addView(textView);
        EditText editText = new EditText(UpdateActivity.this);
        String hint = model.getPlaceholder();
        SpannableString spannableString = new SpannableString(hint);

// Apply padding to the entire hint
        int paddingInPx = 30; // adjust as needed
        spannableString.setSpan(new PaddingLeftSpan(paddingInPx), 0, spannableString.length(), 0);

// Set the modified SpannableString as the hint for the EditText
        editText.setHint(spannableString);


        editText.setElevation(10.0f);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        params1.setMargins(100, 5, 0, 0);
        editText.setBackground(getDrawable(R.drawable.editback));
        linearLayout.addView(editText);
        View view = new View(UpdateActivity.this);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                3
        );
        view.setLayoutParams(params2);
        params2.setMargins(0, 40, 0, 5);
        view.setBackgroundColor(Color.LTGRAY);

        linearLayout.addView(view);
    }

    public void addValues(String cap) {
        TextView textView = new TextView(UpdateActivity.this);
        textView.setText(cap);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 16, 16, 25);
        textView.setLayoutParams(params);
        linearLayout.addView(textView);
        EditText editText = new EditText(UpdateActivity.this);

        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        params1.setMargins(100, 5, 0, 0);
        editText.setBackground(getDrawable(R.drawable.editback));
        String hint = "Select Value";
        SpannableString spannableString = new SpannableString(hint);
        int paddingInPx = 30;
        spannableString.setSpan(new PaddingLeftSpan(paddingInPx), 0, spannableString.length(), 0);

        editText.setHint(spannableString);

        editText.setElevation(10.0f);
        linearLayout.addView(editText);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(UpdateActivity.this, R.style.AppBottomSheetDialogTheme);
                bottomSheetDialog.setContentView(R.layout.bottomsheet);
                bottomSheetDialog.show();

            }
        });
        View view = new View(UpdateActivity.this);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                3
        );
        view.setLayoutParams(params2);
        params2.setMargins(0, 40, 0, 5);
        view.setBackgroundColor(Color.LTGRAY);

        linearLayout.addView(view);
    }




    class PaddingLeftSpan implements LeadingMarginSpan.LeadingMarginSpan2 {
        private final int padding;

        PaddingLeftSpan(int padding) {
            this.padding = padding;
        }

        @Override
        public int getLeadingMargin(boolean first) {
            return padding;
        }

        @Override
        public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {

        }

        @Override
        public int getLeadingMarginLineCount() {
            return 1;
        }

    }

}


