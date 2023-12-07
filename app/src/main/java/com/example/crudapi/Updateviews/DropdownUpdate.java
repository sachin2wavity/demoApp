package com.example.crudapi.Updateviews;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.crudapi.CreateModels.DatacontrolModel;
import com.example.crudapi.CreateModels.DatatypeModel;
import com.example.crudapi.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DropdownUpdate extends LinearLayout {
    TextView data;
    String controlid = "8c7b2a9b-188a-439c-9adf-351e71d72fd6", datatypeid = "dff02f92-c105-4060-abf9-6959d882f8fe";

    public DropdownUpdate(Context context, String caption, String iddc, String iddt, String val) {
        super(context);
        controlid =iddc;
        datatypeid=iddt;
        customView(context, caption, val);
    }

    public void customView(Context context, String caption, String val) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View inflatedView = inflater.inflate(R.layout.dropdown_layout, this, true);
        android.widget.TextView textView = inflatedView.findViewById(R.id.recordid);
        textView.setText("Dropdown");
        data = inflatedView.findViewById(R.id.drpotxt);
        data.setText(val);
        ImageView imageView =inflatedView.findViewById(R.id.dropValue);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.AppBottomSheetDialogTheme);
                bottomSheetDialog.setContentView(R.layout.bottomsheet);
                TextView selectedDataTextView = bottomSheetDialog.findViewById(R.id.txt1);
                TextView textView1   = bottomSheetDialog.findViewById(R.id.text2);
                TextView textView2   = bottomSheetDialog.findViewById(R.id.txt3);;
                RadioButton selectDataButton = bottomSheetDialog.findViewById(R.id.ronebtn);
                RadioButton radioButton1 = bottomSheetDialog.findViewById(R.id.rtwobtn);
                RadioButton radioButton2 = bottomSheetDialog.findViewById(R.id.rthree);



                selectDataButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Retrieve the selected data (replace this with your actual data retrieval logic)
                        String selectedData = (String) selectedDataTextView.getText(); // Replace with your logic to get the selected data

                        // Set the selected data to the EditText
                        data.setText(" " + selectedData);
                        //   valueModel.setText(selectedData);
                        // Dismiss the BottomSheetDialog
                        bottomSheetDialog.dismiss();
                    }
                });

                radioButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Retrieve the selected data (replace this with your actual data retrieval logic)
                        String selectedData = (String) textView1.getText(); // Replace with your logic to get the selected data

                        // Set the selected data to the EditText
                        data.setText(" " + selectedData);
                        //   valueModel.setText(selectedData);
                        // Dismiss the BottomSheetDialog
                        bottomSheetDialog.dismiss();
                    }
                });
                radioButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Retrieve the selected data (replace this with your actual data retrieval logic)
                        String selectedData = (String) textView2.getText(); // Replace with your logic to get the selected data

                        // Set the selected data to the EditText
                        data.setText(" " + selectedData);
                        // valueModel.setText(selectedData);
                        // Dismiss the BottomSheetDialog
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.show();

            }
        });

    }
    public DatacontrolModel getText() throws JSONException {

        DatatypeModel datatypeModel = new DatatypeModel();
        datatypeModel.setId(datatypeid);
        datatypeModel.setSubtype("singleselect");
        datatypeModel.setType("category");

        List<JSONObject> list = new ArrayList<>();
        JSONObject valueModel = new JSONObject();
        valueModel.put("name", data.getText().toString());
        valueModel.put("value", data.getText().toString());
        valueModel.put("valuetype","category");
        list.add(valueModel);
        datatypeModel.setValue(list);

        DatacontrolModel datacontrolModel = new DatacontrolModel();
        datacontrolModel.setId(controlid);
        datacontrolModel.setCtrltype("category_dropdown");
        ArrayList<DatatypeModel> datatypesList = new ArrayList<>();
        datatypesList.add(datatypeModel);
        datacontrolModel.setDatatypes(datatypesList);
        Log.d("datalist",datacontrolModel.toString());

        return  datacontrolModel;
    }

}
