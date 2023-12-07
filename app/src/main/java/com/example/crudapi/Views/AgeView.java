package com.example.crudapi.Views;

import static com.example.crudapi.R.id.recordid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.crudapi.CreateModels.DatacontrolModel;
import com.example.crudapi.CreateModels.DatatypeModel;
import com.example.crudapi.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AgeView extends LinearLayout{
    EditText  editText;
    String datacontrolid1="642db483-9d9b-43b0-b645-4d34d755ee73",datatypeId1="306c8941-3fab-440f-a11b-af26bbbb6a3d";
    public AgeView(Context context,String caption,String datacotrolid,String datatype) {
        super(context);
        customView(context,"Age","Enter Value");


    }
    @SuppressLint("MissingInflatedId")
    public void customView(Context context, String numberId, String editTextHint) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View inflatedView = inflater.inflate(R.layout.ageview_layout, this, true);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) android.widget.TextView textView = inflatedView.findViewById(recordid);
        editText = inflatedView.findViewById(R.id.data);
        textView.setText(numberId);
        editText.setHint(editTextHint);

    }
    public DatacontrolModel getText() throws JSONException {

        DatatypeModel datatypeModel = new DatatypeModel();
        datatypeModel.setId(datatypeId1);
        datatypeModel.setType("number");
        datatypeModel.setSubtype("number");

        List<JSONObject> list = new ArrayList<>();
        JSONObject valueModel = new JSONObject();
        valueModel.put("valuetype", "number");
        valueModel.put("number", editText.getText().toString());
        list.add(valueModel);
        datatypeModel.setValue(list);

        DatacontrolModel datacontrolModel = new DatacontrolModel();
        datacontrolModel.setId(datacontrolid1);
        datacontrolModel.setCtrltype("number");
        ArrayList<DatatypeModel> datatypesList = new ArrayList<>();
        datatypesList.add(datatypeModel);
        datacontrolModel.setDatatypes(datatypesList);
        Log.d("datalist",datacontrolModel.toString());

        return  datacontrolModel;

    }


}
