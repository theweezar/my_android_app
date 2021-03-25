package com.example.milkteashop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSortButtonAnimation();
        setFocusSortMenu();
    }

    public void setSortButtonAnimation(){
        TextView sortBtn = findViewById(R.id.sort_btn);
        LinearLayout sortMenu = findViewById(R.id.sort_menu);
        Animation animation = AnimationUtils.loadAnimation(sortMenu.getContext(),R.anim.drop_down);
        sortMenu.setAnimation(animation);
        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortMenu.startAnimation(animation);
                sortMenu.setAlpha(1);
                sortBtn.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void setFocusSortMenu(){
        LinearLayout sortMenu = findViewById(R.id.sort_menu);
        sortMenu.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                sortMenu.setAlpha(0);
            }
        });
    }
}