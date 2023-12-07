package com.example.crudapi.Updateviews;

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

public class ToggleUpdae extends LinearLayout {
    Switch aSwitch;
    boolean switchValue;
    String controlid="beddc8c3-a36f-4ba2-bcdc-c9a9e7f0265a", datatyeid="2ad71a82-c650-49d1-85f7-1f35c83d08ff";

    public ToggleUpdae(Context context, String cap, String dcid, String dtypeid,Boolean val) {
        super(context);
        controlid=dcid;
        datatyeid=dtypeid;
        customView(context, cap,val);
    }

    public void customView(Context context, String numberId,Boolean val) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View inflatedView = inflater.inflate(R.layout.switch_layout, this, true);
        android.widget.TextView textView = inflatedView.findViewById(R.id.recordid);
        aSwitch = inflatedView.findViewById(R.id.switchbtn);
        textView.setText("Toggle");
        aSwitch.setChecked(val);

        if (val) {
            // If val is true, set color to #87CEEB
            ColorStateList colorStateList = ColorStateList.valueOf(Color.parseColor("#87CEEB"));
            aSwitch.setThumbTintList(colorStateList);
            aSwitch.setTrackTintList(colorStateList);
        } else {
            // If val is false, set color to LTGRAY
            ColorStateList colorStateList = ColorStateList.valueOf(Color.LTGRAY);
            aSwitch.setThumbTintList(colorStateList);
            aSwitch.setTrackTintList(colorStateList);
        }

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
