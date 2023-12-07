package com.example.crudapi.Views;

import static com.example.crudapi.R.id.recordid;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.crudapi.Adapters.CustomAdapter;
import com.example.crudapi.CreateModels.DatacontrolModel;
import com.example.crudapi.CreateModels.DatatypeModel;
import com.example.crudapi.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SegmentView extends LinearLayout {
    String controlid,datatypeId;
    GridView gridView;
    CustomAdapter adapter;
    String lastClickedText ;
    public SegmentView(Context context,String name,String dcid,String dtypeid,List<String> valuesModelList) {
        super(context);
        controlid=dcid;
        datatypeId=dtypeid;
        customView(context,name,valuesModelList);
    }
    public void customView(Context context, String numberId,List<String> valuesModelList) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View inflatedView = inflater.inflate(R.layout.segmemt, this,true);
         android.widget.TextView textView= inflatedView.findViewById(recordid);
        textView.setText(numberId);
         gridView = inflatedView.findViewById(R.id.gridLayout);
         adapter = new CustomAdapter(context, valuesModelList);
        gridView.setAdapter(adapter);


    }
    public DatacontrolModel getText() throws JSONException {

        DatatypeModel datatypeModel = new DatatypeModel();
        datatypeModel.setId(datatypeId);
        datatypeModel.setType("category");
        datatypeModel.setSubtype("singleselect");
        lastClickedText =adapter.getLastClickedText();
        Log.d("text",lastClickedText);
        List<JSONObject> list = new ArrayList<>();
        JSONObject valueModel = new JSONObject();
        valueModel.put("valuetype", "category");
        valueModel.put("name",lastClickedText);
        valueModel.put("value",lastClickedText);
        list.add(valueModel);
        datatypeModel.setValue(list);

        DatacontrolModel datacontrolModel = new DatacontrolModel();
        datacontrolModel.setId(controlid);
        datacontrolModel.setCtrltype("category_segment");
        ArrayList<DatatypeModel> datatypesList = new ArrayList<>();
        datatypesList.add(datatypeModel);
        datacontrolModel.setDatatypes(datatypesList);
        Log.d("datalist",datacontrolModel.toString());

        return  datacontrolModel;

    }


}
