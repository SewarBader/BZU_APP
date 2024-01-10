package com.example.bzu_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class averagewelc extends AppCompatActivity {
    Button next,skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_averagewelc);
        skip=findViewById(R.id.skip3);
        next = findViewById(R.id.next3);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(averagewelc.this, schedulewel.class);
                startActivity(intent);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(averagewelc.this, LOGin.class);
                startActivity(intent);
            }
        });
    }
}