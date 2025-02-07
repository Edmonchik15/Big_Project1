package com.example.big_project;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseUser;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OTP_Verification extends AppCompatActivity {

    ImageView OTP_Image;
    TextView Please;
    TextView Email_Adress;
    TextView otpEmail;
    TextView Mobille;
    TextView otpMobile;
    EditText otpET1;
    EditText otpET2;
    EditText otpET3;
    EditText otpET4;
    Button Verify;
    TextView didnt_reseive_code;
    TextView resend_code;
    private boolean resendEnabled = false;

    private int resendTime = 60;

    private int selectedETPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_otp_verification);

        resend_code = findViewById(R.id.resendBtn);
        didnt_reseive_code = findViewById(R.id.donthave_code);
        Verify = findViewById(R.id.verifyBtn);
        otpET4 = findViewById(R.id.otpET4);
        otpET3 = findViewById(R.id.otpET3);
        otpET2 = findViewById(R.id.otpET2);
        otpET1 = findViewById(R.id.otpET1);
        otpEmail = findViewById(R.id.otpEmail);
        Mobille = findViewById(R.id.Mobile);
        otpMobile = findViewById(R.id.otpMobile);
        Email_Adress = findViewById(R.id.Email_Adress);
        Please = findViewById(R.id.Please);
        OTP_Image = findViewById(R.id.Otp_Image);

        final String getEmail = getIntent().getStringExtra("Email");
        final String getMobile = getIntent().getStringExtra("Mobile");


        otpEmail.setText(getEmail);
        otpMobile.setText(getMobile);

        otpET1.addTextChangedListener(textWatcher);
        otpET2.addTextChangedListener(textWatcher);
        otpET3.addTextChangedListener(textWatcher);
        otpET4.addTextChangedListener(textWatcher);

        showKeyboard(otpET1);

        startCountDownTimer();

        resend_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(resendEnabled){

                    startCountDownTimer();
                }
            }
        });

        Verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String generateOtp = otpET1.getText().toString()+otpET2.getText().toString()+otpET3.getText().toString()+otpET4.getText().toString();

                if(generateOtp.length() == 4){

                }
            }
        });
    }
    private void showKeyboard(EditText otpET) {
        otpET.requestFocus();

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(otpET, InputMethodManager.SHOW_IMPLICIT);
    }

    private void startCountDownTimer() {

        resendEnabled = false;
        resend_code.setTextColor(Color.parseColor("#99000000"));

        new CountDownTimer(resendTime * 1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                resend_code.setText("Resend Code (" + (millisUntilFinished / 1000) + ")");
            }

            @Override
            public void onFinish() {
                resendEnabled = true;
                resend_code.setText("Resend Code");
                resend_code.setTextColor(getResources().getColor(R.color.primary));
            }
        }.start();
    }

    private final TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.length() > 0){

                    if(selectedETPosition == 0){

                        selectedETPosition = 1;
                        showKeyboard(otpET2);
                    } else if (selectedETPosition == 1) {

                        selectedETPosition = 2;
                        showKeyboard(otpET3);
                    } else if (selectedETPosition == 2) {

                        selectedETPosition = 3;
                        showKeyboard(otpET4);
                    }
                }
            }
        };

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_DEL){

            if(selectedETPosition == 3){

                selectedETPosition = 2;
                showKeyboard(otpET3);
            } else if (selectedETPosition == 2) {
                selectedETPosition = 1;
                showKeyboard(otpET2);
            } else if (selectedETPosition == 1) {

                selectedETPosition = 0;
                showKeyboard(otpET1);
            }

            return true;
        }else {
            return super.onKeyUp(keyCode, event);

        }
    }

    private class FirebaseAuth {
    }
}