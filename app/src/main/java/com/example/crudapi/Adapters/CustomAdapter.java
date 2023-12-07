package com.example.crudapi.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.crudapi.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<String> list = new ArrayList<>();
    private String lastClickedText;

    public String getLastClickedText() {
        return lastClickedText;
    }

    public void setLastClickedText(String lastClickedText) {
        this.lastClickedText = lastClickedText;
    }

    public CustomAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }




    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context.getApplicationContext());
            convertView = inflater.inflate(R.layout.segmentbtn, parent, false);
        }

        Button textView = convertView.findViewById(R.id.btn);
        textView.setText(list.get(position));
        if (list.get(position).equals(lastClickedText)) {
            // If yes, set the background color to #87CEEB
            textView.setBackgroundColor(Color.parseColor("#87CEEB"));
        } else {
            // If no, set the background color to the default color (you can set it to LTGRAY or any other color)
            textView.setBackgroundColor(Color.LTGRAY);
        }

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setBackgroundColor(Color.parseColor("#87CEEB"));
             lastClickedText =list.get(position);
            }
        });

        return convertView;

    }
}
