package com.example.crudapi.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crudapi.CreateModels.ValueModel;
import com.example.crudapi.R;

public class CreateActivity extends AppCompatActivity {
  ValueModel valueModel = new ValueModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

    }

}