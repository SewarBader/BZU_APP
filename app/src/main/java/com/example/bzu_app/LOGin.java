package com.example.bzu_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class LOGin extends AppCompatActivity {
    private TextView id , Pass;
    private CheckBox RemamberMe;
    private Button LogIN ,signup;
    private static final String SPref = "MyPrefs";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String REMEMBER = "remember";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id =findViewById(R.id.loginId);
        Pass= findViewById(R.id.loginPass);
        RemamberMe = findViewById(R.id.checkBox);
        LogIN = findViewById(R.id.but_login);
        signup = findViewById(R.id.but_sign);

        SharedPreferences sharedPreferences = getSharedPreferences(SPref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (sharedPreferences.getBoolean(REMEMBER, false)) {
            id.setText(sharedPreferences.getString(USERNAME, ""));
            Pass.setText(sharedPreferences.getString(PASSWORD, ""));
            RemamberMe.setChecked(true);
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LOGin.this, Signup.class);
                startActivity(intent);
            }
        });


        LogIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
                Intent intent = new Intent(LOGin.this, main.class);
                startActivity(intent);
            }
        });

    }

    private void login() {
        String username = id.getText().toString();
        String password = Pass.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences(SPref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if( (id.equals(null) && (Pass.equals(null))) ){
            Toast.makeText(this, "Please Enter your id to log in  ", Toast.LENGTH_SHORT).show();
        } else {
            if (RemamberMe.isChecked()) {

                editor.putString(USERNAME, username);
                editor.putString(PASSWORD, password);
                editor.putBoolean(REMEMBER, true);
                editor.apply();
                Toast.makeText(this, "Login Successful! ", Toast.LENGTH_SHORT).show();

            } else {
                editor.remove(USERNAME);
                editor.remove(PASSWORD);
                editor.remove(REMEMBER);
                editor.apply();
                Toast.makeText(this, "Login Successful! ", Toast.LENGTH_SHORT).show();

            }

        }

    }}