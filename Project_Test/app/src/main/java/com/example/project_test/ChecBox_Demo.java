package com.example.project_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class ChecBox_Demo extends AppCompatActivity {

    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chec_box__demo);
        setSubmitEvent();
    }

    public void setToastMessage(CheckBox checkBox){

        if (checkBox.isChecked()){
            msg += String.format("%s được chọn\n",checkBox.getText());
        }
    }

    public void setSubmitEvent(){
        Button submitBtn = (Button) findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = "";
                CheckBox mem_1 = findViewById(R.id.mem_1);
                CheckBox mem_2 = findViewById(R.id.mem_2);
                CheckBox mem_3 = findViewById(R.id.mem_3);
                CheckBox mem_4 = findViewById(R.id.mem_4);
                setToastMessage(mem_1);
                setToastMessage(mem_2);
                setToastMessage(mem_3);
                setToastMessage(mem_4);
                Toast.makeText(ChecBox_Demo.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}