package com.example.bzu_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class l_AVA extends AppCompatActivity {
private EditText H1,H2,H3,H4,H5,H6,m1,m2,m3,m4,m5,m6;
private EditText CompleteHours,CompleteHoursTotal,GAP,GAPTotal,SemesterTotal;
private Button home,calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lava);
        H1=findViewById(R.id.H1);
        H2=findViewById(R.id.H2);
        H3=findViewById(R.id.H3);
        H4=findViewById(R.id.H4);
        H5=findViewById(R.id.H5);
        H6=findViewById(R.id.H6);

        m1=findViewById(R.id.m1);
        m2=findViewById(R.id.m2);
        m3=findViewById(R.id.m3);
        m4=findViewById(R.id.m4);
        m5=findViewById(R.id.m5);
        m6=findViewById(R.id.m6);

        CompleteHours =findViewById(R.id.CompletedH);
        CompleteHoursTotal=findViewById(R.id.totalCOMH);

        GAP=findViewById(R.id.PGAP);
        GAPTotal=findViewById(R.id.TotalGAp);

        SemesterTotal=findViewById(R.id.Stotal);
        home=findViewById(R.id.home_butl);
        calculate=findViewById(R.id.calculaut_l);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m1Value = parseEditTextValue(m1);
                int h1Value = parseEditTextValue(H1);
                int m2Value = parseEditTextValue(m2);
                int h2Value = parseEditTextValue(H2);
                int m3Value = parseEditTextValue(m3);
                int h3Value = parseEditTextValue(H3);
                int m4Value = parseEditTextValue(m4);
                int h4Value = parseEditTextValue(H4);
                int m5Value = parseEditTextValue(m5);
                int h5Value = parseEditTextValue(H5);
                int m6Value = parseEditTextValue(m6);
                int h6Value = parseEditTextValue(H6);

                double result = (m1Value * h1Value) + (m2Value * h2Value) + (m3Value * h3Value) + (m4Value * h4Value) + (m5Value * h5Value) + (m6Value * h6Value);
                int hresult=(h1Value+h2Value+h3Value+h4Value+h5Value+h6Value);
                int mresult=(m1Value+m2Value+m3Value+m4Value+m5Value+m6Value);
                double sresult = result/hresult;
                SemesterTotal.setText(String.valueOf(sresult));

                int cohlValue = parseEditTextValue(CompleteHours);
                double previousgap= parseEditTextValue(GAP);
                if( cohlValue!=0 && previousgap !=0){
                 int cohlValuenew =cohlValue+ hresult;
                  GAPTotal.setText(String.valueOf(((sresult*hresult)+(previousgap*cohlValue))/cohlValuenew));
                    CompleteHoursTotal.setText(String.valueOf(cohlValuenew));

                }

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(l_AVA.this,main.class);
                startActivity(intent);
            }
        });
    }

    private int parseEditTextValue(EditText editText) {
        String text = editText.getText().toString().trim();
        return text.isEmpty() ? 0 : Integer.parseInt(text);
    }
}