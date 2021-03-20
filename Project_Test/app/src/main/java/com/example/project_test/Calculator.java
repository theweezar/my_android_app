package com.example.project_test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    private TextView result;
    private EditText a;
    private EditText b;
    private Button sumBtn;
    private Button clearBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setView();
        setEventForSumButton();
        setEventForClearButton();
    }

    private void setView(){
        result = findViewById(R.id.result);
        a = findViewById(R.id.so_a);
        b = findViewById(R.id.so_b);
        sumBtn = findViewById(R.id.sumBtn);
        clearBtn = findViewById(R.id.clearBtn);
    }

    private void setEventForSumButton(){
        sumBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                double anum, bnum;
                String resultStr;
                try {
                    anum = Double.parseDouble(a.getText().toString());
                    bnum = Double.parseDouble(b.getText().toString());
                    resultStr = String.format("Tổng 2 số là: %.2f",anum + bnum);
                }
                catch (NumberFormatException e){
                    resultStr = "Vui lòng nhập đúng định dạng số";
                }
                result.setBackgroundColor(Color.parseColor("#00cc00"));
                result.setText(resultStr);
            }
        });
    }

    private void setEventForClearButton(){
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.setText("");
                b.setText("");
                result.setBackgroundColor(Color.parseColor("#ffffff"));
                result.setText("");
            }
        });
    }

}