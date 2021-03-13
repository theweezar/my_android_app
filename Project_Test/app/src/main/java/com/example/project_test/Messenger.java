package com.example.project_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Messenger extends AppCompatActivity {

    private Button sendBtn = findViewById(R.id.sendBtn);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEvent();
        setContentView(R.layout.activity_messenger);
    }

    private void setEvent(){
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText toInput = findViewById(R.id.toInput);
                EditText msgInput = findViewById(R.id.msgInput);
                String to = toInput.getText().toString();
                String msg = msgInput.getText().toString();
            }
        });
    }
}