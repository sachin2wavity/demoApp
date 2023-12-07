package com.example.crudapi.Views;

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

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateView extends LinearLayout {
    public TextView textView1;
    String datacontrolid,datatypeId;

    public DateView(Context context, String textviewName,String datacontrolId,String dataTypeid) {
        super(context);
        customView(context, textviewName);

            datacontrolid=datacontrolId;
            datatypeId=dataTypeid;
    }

    public void customView(Context context, String textviewName) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View inflatedView = inflater.inflate(R.layout.dateviewlayout, this, true);
        textView1 = inflatedView.findViewById(R.id.data);
        TextView textView = findViewById(R.id.caption);
        textView.setText(textviewName);
        textView1.setHint("Select Date");
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
                        textView1.setText(selectedDate);
                    }
                }, m, d, y);
                datePickerDialog.show();
            }
        });
    }

    public DatacontrolModel getText() throws JSONException {

        // Create an instance of DatatypeModel
        DatatypeModel datatypeModel = new DatatypeModel();
        datatypeModel.setId(datatypeId);
        datatypeModel.setType("datepicker");
        datatypeModel.setSubtype("datepicker");
        long date1 = convertDateStringToLong(textView1.getText().toString());
        Timestamp timestamp =  new Timestamp(date1);

        List<JSONObject> list = new ArrayList<>();
        JSONObject valueModel = new JSONObject();
        valueModel.put("valuetype", "date");
        valueModel.put("date", date1);
        list.add(valueModel);
        datatypeModel.setValue(list);

        // Create an instance of DatacontrolModel
        DatacontrolModel datacontrolModel2 = new DatacontrolModel();
        datacontrolModel2.setId(datacontrolid);
        datacontrolModel2.setCtrltype("date");

        // Create an ArrayList of DatatypeModel and add the previously created instance
        ArrayList<DatatypeModel> datatypesList = new ArrayList<>();
        datatypesList.add(datatypeModel);
        datacontrolModel2.setDatatypes(datatypesList);
    Log.d("date",datacontrolModel2.toString());
        return datacontrolModel2;
    }
    public static long convertDateStringToLong(String dateString) {
        if (dateString.equals("")) {

        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy",Locale.ENGLISH);
            try {
                Date date = sdf.parse(dateString);
                Long date1 =date.getTime();
                return date1 ;
            } catch (ParseException e) {
                e.printStackTrace();
                return 0; // Handle the parsing exception according to your requirements
            }
        }
        return 0;
    }
}
