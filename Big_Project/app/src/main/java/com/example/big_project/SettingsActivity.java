package com.example.big_project;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.hardware.camera2.params.BlackLevelPattern;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorLong;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;


public class SettingsActivity extends AppCompatActivity {

    Button themeDark;
    Button themeLight;

    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        themeDark = findViewById(R.id.theme);
        themeLight = findViewById(R.id.theme2);

        themeDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RelativeLayout layout = (RelativeLayout) findViewById(R.id.Infolayout);
                layout.setBackgroundResource(R.drawable.darkbackground);
                RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.info);
                layout1.setBackgroundResource(R.drawable.darkbackground);
                RelativeLayout layout2 = (RelativeLayout) findViewById(R.id.Settings);
                layout2.setBackgroundResource(R.drawable.darkbackground);

            }
        });

        themeLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RelativeLayout layout3 = (RelativeLayout) findViewById(R.id.Infolayout);
                layout3.setBackgroundResource(R.drawable.background);
                RelativeLayout layout4 = (RelativeLayout) findViewById(R.id.info);
                layout4.setBackgroundResource(R.drawable.background);
                RelativeLayout layout5 = (RelativeLayout) findViewById(R.id.Settings);
                layout5.setBackgroundResource(R.drawable.background);

            }
        });
    }
}