package com.example.project_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

// Màn hình chính
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("start","App is running");

        ManHinh1 screenOne = new ManHinh1();

        final Button buttonOne = findViewById(R.id.btnOne);
        buttonOne.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.d("btnOne","Button 1 (Man hinh 1) is pressed");
                screenOne.show(getSupportFragmentManager(), "ManHinh1");
            }
        });

        final Button buttonTwo = findViewById(R.id.btnTwo);
        buttonTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.d("btnTwo","Button 2 (Man hinh 2) is pressed");
                Intent intent = new Intent(MainActivity.this, ManHinh2.class);
                startActivity(intent);
            }
        });
    }
}