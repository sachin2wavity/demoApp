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

public class NameViewUpdate extends LinearLayout {
    EditText editText;
    String controlid , datatypeid ;

    public NameViewUpdate(Context context, String caption, String iddc, String iddt, String text) {
        super(context);
        controlid=iddc;
        datatypeid=iddt;
        customView(context, caption, text);
    }

    public void customView(Context context, String caption, String text1) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View inflatedView = inflater.inflate(R.layout.textviewlayout, this, true);
        android.widget.TextView textView = inflatedView.findViewById(R.id.recordid);
        editText = inflatedView.findViewById(R.id.data);
        textView.setText("Name");
        editText.setText(text1);
    }

    public EditText getEditText() {
        String txt = editText.getText().toString();
        Log.d("no", txt);
        return editText;
    }

    public DatacontrolModel getText() throws JSONException {

        DatatypeModel datatypeModel = new DatatypeModel();
        datatypeModel.setId(datatypeid);
        datatypeModel.setType("text");
        datatypeModel.setSubtype("text");

        List<JSONObject> list = new ArrayList<>();
        JSONObject valueModel = new JSONObject();
        valueModel.put("valuetype", "text");
        valueModel.put("index",-1);
        valueModel.put("rich",false);
        valueModel.put("text", editText.getText().toString());
        list.add(valueModel);
        datatypeModel.setValue(list);
        DatacontrolModel datacontrolModel = new DatacontrolModel();
        datacontrolModel.setId(controlid);
        datacontrolModel.setCtrltype("single_fields");
        ArrayList<DatatypeModel> datatypesList = new ArrayList<>();
        datatypesList.add(datatypeModel);
        datacontrolModel.setDatatypes(datatypesList);
        Log.d("datalist", datacontrolModel.toString());

        return datacontrolModel;

    }
}
