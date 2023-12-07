package com.example.crudapi.Updateviews;

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

public class AgeViewUpdate extends LinearLayout {
 private    EditText editText;
  private   String controlid = "642db483-9d9b-43b0-b645-4d34d755ee73", datatypeid = "306c8941-3fab-440f-a11b-af26bbbb6a3d";

    public AgeViewUpdate(Context context, String caption, String iddc, String iddt, int age) {
        super(context);
        controlid=iddc;
        datatypeid=iddt;
        customView(context, caption, age);
    }

    public void customView(Context context, String caption, int age) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View inflatedView = inflater.inflate(R.layout.ageview_layout, this, true);
        android.widget.TextView textView = inflatedView.findViewById(R.id.recordid);
        editText = inflatedView.findViewById(R.id.data);
        textView.setText("Age");
        editText.setText(age+"");
    }
    public EditText getEditText() {
        String txt = editText.getText().toString();
        Log.d("no", txt);
        return editText;
    }
    public DatacontrolModel getText() throws JSONException {

        DatatypeModel datatypeModel = new DatatypeModel();
        datatypeModel.setId(datatypeid);
        datatypeModel.setType("number");
        datatypeModel.setSubtype("number");

        List<JSONObject> list = new ArrayList<>();
        JSONObject valueModel = new JSONObject();
        valueModel.put("valuetype", "number");
        valueModel.put("index",-1);
        valueModel.put("number", editText.getText().toString());
        valueModel.put("currency",false);
        list.add(valueModel);
        datatypeModel.setValue(list);
        DatacontrolModel datacontrolModel = new DatacontrolModel();
        datacontrolModel.setId(controlid);
        datacontrolModel.setCtrltype("number");
        ArrayList<DatatypeModel> datatypesList = new ArrayList<>();
        datatypesList.add(datatypeModel);
        datacontrolModel.setDatatypes(datatypesList);
        Log.d("datalist", datacontrolModel.toString());

        return datacontrolModel;

    }
}
