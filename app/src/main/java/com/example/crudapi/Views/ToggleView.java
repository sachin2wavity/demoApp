package com.example.crudapi.Views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.example.crudapi.CreateModels.DatacontrolModel;
import com.example.crudapi.CreateModels.DatatypeModel;
import com.example.crudapi.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ToggleView extends LinearLayout {
    Switch aSwitch;
    boolean switchValue;
    String controlid,datatyeid;

    public ToggleView(Context context, String cap,String dcid, String dtypeid) {
        super(context);
        controlid=dcid;
        datatyeid=dtypeid;
        customView(context, cap);
    }

    public void customView(Context context, String numberId) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View inflatedView = inflater.inflate(R.layout.switch_layout, this, true);
        android.widget.TextView textView = inflatedView.findViewById(R.id.recordid);
        aSwitch = inflatedView.findViewById(R.id.switchbtn);
        textView.setText(numberId);
        aSwitch.setChecked(false);
        aSwitch.setTextOn("ON");
        aSwitch.setTextOff("OFF");

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Handle switch state changes
                ColorStateList colorStateList = ColorStateList.valueOf(Color.parseColor("#87CEEB"));
                ColorStateList colorStateList1 = ColorStateList.valueOf(Color.LTGRAY);
                 switchValue = aSwitch.isChecked();

                if (isChecked) {
                    aSwitch.setThumbTintList(colorStateList);
                    aSwitch.setTrackTintList(colorStateList);
                    ;
                } else {
                    aSwitch.setThumbTintList(colorStateList1);
                    aSwitch.setTrackTintList(colorStateList1);
                }
            }
        });

    }
    public DatacontrolModel getText() throws JSONException {
        DatatypeModel datatypeModel = new DatatypeModel();
        datatypeModel.setId(datatyeid);
        datatypeModel.setType("category");
        datatypeModel.setSubtype("singleselect");
        List<JSONObject> list = new ArrayList<>();
        JSONObject valueModel = new JSONObject();
        valueModel.put("valuetype", "category");
        valueModel.put("value",switchValue);
        valueModel.put("name",switchValue);
        list.add(valueModel);
        datatypeModel.setValue(list);

        DatacontrolModel datacontrolModel = new DatacontrolModel();
        datacontrolModel.setId(controlid);
        datacontrolModel.setCtrltype("category_toggle");
        ArrayList<DatatypeModel> datatypesList = new ArrayList<>();
        datatypesList.add(datatypeModel);
        datacontrolModel.setDatatypes(datatypesList);
        Log.d("datalist",datacontrolModel.toString());

        return  datacontrolModel;

    }

}