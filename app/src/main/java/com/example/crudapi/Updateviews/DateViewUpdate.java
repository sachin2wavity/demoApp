package com.example.crudapi.Updateviews;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.crudapi.CreateModels.DatacontrolModel;
import com.example.crudapi.CreateModels.DatatypeModel;
import com.example.crudapi.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateViewUpdate extends LinearLayout {
    TextView text;
    long timestamp;
    String controlid = "b199e73c-91f0-4c15-bede-40bd97f8eb07", datatypeid = "14aaab10-79ec-4680-8e85-2f58ed301057";

    public DateViewUpdate(Context context, String caption, String iddc, String iddt, Long date) {
        super(context);
        controlid=iddc;
        datatypeid=iddt;
        customView(context, caption, date);
    }

    public void customView(Context context, String caption, Long date) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View inflatedView = inflater.inflate(R.layout.dateviewlayout, this, true);
        android.widget.TextView textView = inflatedView.findViewById(R.id.caption);
        text = inflatedView.findViewById(R.id.data);
        textView.setText("Date");
        timestamp = date; // Example timestamp

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        String formattedDate = dateFormat.format(new Date(timestamp));

        text.setText(formattedDate);
        ImageView imageView = inflatedView.findViewById(R.id.dateselectBtn);
        imageView.setOnClickListener(new View.OnClickListener() {
            final Calendar calendar = Calendar.getInstance();
            final int y = 2023;
            final int m = calendar.get(Calendar.MONTH);
            final int d = calendar.get(Calendar.DAY_OF_MONTH);

            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String monthString = new SimpleDateFormat("MMM ", Locale.getDefault()).format(new Date(0, month, 1));
                        String selectedDate = monthString + " " + dayOfMonth + ", " + 2023;

                        text.setText(selectedDate);
                    }
                }, m, d, y);
                datePickerDialog.show();
            }
        });
    }
    public DatacontrolModel getText() throws JSONException {

        DatatypeModel datatypeModel = new DatatypeModel();
        datatypeModel.setId(datatypeid);
        datatypeModel.setType("datepicker");
        datatypeModel.setSubtype("datepicker");

        List<JSONObject> list = new ArrayList<>();
        JSONObject valueModel = new JSONObject();
        valueModel.put("valuetype", "date");
        valueModel.put("date",timestamp);
        valueModel.put("index",-1);

      //  valueModel.put("number", editText.getText().toString());
        list.add(valueModel);
        datatypeModel.setValue(list);
        DatacontrolModel datacontrolModel = new DatacontrolModel();
        datacontrolModel.setId(controlid);
        datacontrolModel.setCtrltype("date");
        ArrayList<DatatypeModel> datatypesList = new ArrayList<>();
        datatypesList.add(datatypeModel);
        datacontrolModel.setDatatypes(datatypesList);
        Log.d("datalist", datacontrolModel.toString());

        return datacontrolModel;

    }
}
