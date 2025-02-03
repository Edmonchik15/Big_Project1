package com.example.big_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button signinButton;

    ImageView Account_Image;

    TextView Sign_in;

    ImageView show_password;

    TextView forgot_password;

    TextView dont_have_account;

    TextView Sign_Up;


    private boolean passwordShowing = false;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        username = findViewById(R.id.username_input);
        password = findViewById(R.id.password_input);
        signinButton = findViewById(R.id.Sign_In_Btn);
        Sign_Up = findViewById(R.id.Sign_up);
        dont_have_account = findViewById(R.id.donthave_accaount);
        forgot_password = findViewById(R.id.forgot_password);
        show_password = findViewById(R.id.show_password);
        Sign_in = findViewById(R.id.sign_in);
        Account_Image = findViewById(R.id.Image_accaunt);

        show_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(passwordShowing){
                    passwordShowing = false;

                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    show_password.setImageResource(R.drawable.show_password);
                } else{
                    passwordShowing = true;

                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    show_password.setImageResource(R.drawable.hide_password);
                }
                password.setSelection(password.length());
            }
        });


        Sign_Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}