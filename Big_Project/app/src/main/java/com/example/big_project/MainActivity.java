package com.example.big_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username_input);
        password = findViewById(R.id.password_input);
        loginButton = findViewById(R.id.login_btn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().contains("a") && password.getText().toString().contains("1")){
                    Toast.makeText(MainActivity.this, "LogIn Succesful!!!", Toast.LENGTH_SHORT).show();

                } else{
                    Toast.makeText(MainActivity.this, "LogIn Failed!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}