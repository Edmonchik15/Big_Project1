package com.example.big_project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Info1Activity extends AppCompatActivity {

    TextView info;

    TextView aftor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1);

        info = findViewById(R.id.Text_What);
        aftor = findViewById(R.id.Text_What1);
    }
}