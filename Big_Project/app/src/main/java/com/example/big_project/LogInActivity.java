package com.example.big_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;
    CheckBox checkBox1;

    CheckBox checkBox2;
    public void onClick(View v) {
        if (v.getId() == R.id.login_btn) {
            if (username.getText().toString().contains("a") && password.getText().toString().contains("1")) {
                Toast.makeText(LogInActivity.this, "LogIn Successful!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(LogInActivity.this, "LogIn Failed!!!", Toast.LENGTH_SHORT).show();
                Toast.makeText(LogInActivity.this, "Please try again!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username_input);
        password = findViewById(R.id.password_input);
        checkBox1 = findViewById(R.id.checkBox1);
        loginButton = findViewById(R.id.login_btn);
        checkBox2 = findViewById(R.id.checkBox2);


        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBox2.setVisibility(View.GONE);
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBox1.setVisibility(View.GONE);
            }
        });
    }
}