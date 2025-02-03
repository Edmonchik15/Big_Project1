package com.example.big_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    TextView sign_up;

    EditText username_input2;

    EditText email_input;

    EditText mobile_input;

    EditText password_input2;

    ImageView show_password2;

    EditText confirm_password_input;

    ImageView confirm_show_password;

    Button Sign_Up_Button;

    TextView have_account;

    TextView Sign_in;


    private boolean passwordShowing = false;
    private boolean con_passwordShowing = false;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        username_input2 = findViewById(R.id.username_input2);
        email_input = findViewById(R.id.email_input);
        mobile_input = findViewById(R.id.mobile_input);
        password_input2 = findViewById(R.id.password_input2);
        show_password2 = findViewById(R.id.show_password2);
        confirm_password_input = findViewById(R.id.confirm_password_input);
        confirm_show_password = findViewById(R.id.confirm_show_password);
        Sign_Up_Button = findViewById(R.id.Sign_Up_Btn);
        have_account = findViewById(R.id.have_accaount);
        Sign_in = findViewById(R.id.Sign_in);
        sign_up = findViewById(R.id.sign_up);

        show_password2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passwordShowing){
                    passwordShowing = false;

                    password_input2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    show_password2.setImageResource(R.drawable.show_password);
                } else{
                    passwordShowing = true;

                    password_input2.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    show_password2.setImageResource(R.drawable.hide_password);
                }
                password_input2.setSelection(password_input2.length());
            }
        });

        confirm_show_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(con_passwordShowing){
                    con_passwordShowing = false;

                    confirm_password_input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    confirm_show_password.setImageResource(R.drawable.show_password);
                } else{
                    con_passwordShowing = true;

                    confirm_password_input.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    confirm_show_password.setImageResource(R.drawable.hide_password);
                }
                confirm_password_input.setSelection(confirm_password_input.length());
            }
        });

        Sign_Up_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String getMobile = mobile_input.getText().toString();
                final String getEmail = email_input.getText().toString();

                Intent intent = new Intent(SignUpActivity.this,OTP_Verification.class);
                intent.putExtra("Mobile",getMobile);
                intent.putExtra("eEmail",getEmail);
                startActivity(intent);
            }
        });

        Sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
