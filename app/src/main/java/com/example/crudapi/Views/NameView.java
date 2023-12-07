package com.example.crudapi.Views;

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

public class NameView extends LinearLayout {
    private EditText editText;
   private String datacontrolid,datatypeId;


    public NameView(Context context, String caption, String hint, String iddc, String iddt) {
        super(context);
        customView(context,caption,hint,iddt,iddc);
        datacontrolid=iddc;
        datatypeId=iddt;
    }
    public void customView(Context context, String caption ,String hint,String datatypeid, String datacontrollid) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View inflatedView = inflater.inflate(R.layout.textviewlayout, this,true);
         android.widget.TextView textView= inflatedView.findViewById(R.id.recordid);
         editText= inflatedView.findViewById(R.id.data);
            textView.setText(caption);
            editText.setHint(hint);
    }
      public DatacontrolModel getText() throws JSONException {
          DatatypeModel datatypeModel = new DatatypeModel();
          datatypeModel.setId(datatypeId);
          datatypeModel.setType("text");
          datatypeModel.setSubtype("text");

          List<JSONObject> list = new ArrayList<>();
          JSONObject valueModel = new JSONObject();
          valueModel.put("valuetype", "text");
          valueModel.put("text", editText.getText().toString());
          valueModel.put("rich", false);
          list.add(valueModel);
         datatypeModel.setValue(list);

          DatacontrolModel datacontrolModel = new DatacontrolModel();
          datacontrolModel.setId(datacontrolid);
          datacontrolModel.setCtrltype("single_fields");
          ArrayList<DatatypeModel> datatypesList = new ArrayList<>();
          datatypesList.add(datatypeModel);
          datacontrolModel.setDatatypes(datatypesList);
          Log.d("datalist",datacontrolModel.toString());

  return  datacontrolModel;

      }
    public EditText getEditText() {
        String txt =editText.getText().toString();
        Log.d("no",txt);
        return editText;
    }
}
