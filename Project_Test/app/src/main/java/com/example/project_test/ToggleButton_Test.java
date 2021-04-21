package com.example.project_test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class ToggleButton_Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button__test);
        setEvent();
    }

    public void setEvent(){
        ToggleButton toggleBtn = findViewById(R.id.toggle_btn_1);
        Drawable on = getResources().getDrawable(R.drawable.screenshot_2);
        Drawable off = getResources().getDrawable(R.drawable.screenshot_1);
        on.setBounds(0, 0, 360, 360);
        off.setBounds(0,0, 360, 360);
        toggleBtn.setCompoundDrawables(null,off,null,null);
        toggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    toggleBtn.setCompoundDrawables(null,on,null,null);
                }
                else{
                    toggleBtn.setCompoundDrawables(null,off,null,null);
                }
            }
        });
    }

}