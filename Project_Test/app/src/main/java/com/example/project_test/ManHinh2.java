package com.example.project_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManHinh2 extends AppCompatActivity {

    private Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh2);

        backBtn = findViewById(R.id.btnBack_2);
        backBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
//                Intent intent = new Intent(ManHinh2.this, MainActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }
}