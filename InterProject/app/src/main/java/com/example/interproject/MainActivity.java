package com.example.interproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvHienthi;
    ArrayList<Quocgia> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    public void setControl(){
        lvHienthi = findViewById(R.id.lvHienthi);
    }
    public void setEvent(){
        khoitao();
        CustomAdapter adapter = new CustomAdapter(this,
                R.layout.item_quoc_gia,data);
                adapter.addAll(data);
        lvHienthi.setAdapter(adapter);
    }
    public void khoitao(){
        data = new ArrayList<>();
        Quocgia quocgia1 = new Quocgia(1,"1","1000");
        Quocgia quocgia2 = new Quocgia(2,"2","1000");
        Quocgia quocgia3 = new Quocgia(3,"3","1000");
        Quocgia quocgia4 = new Quocgia(4,"4","1000");
        data.add(quocgia1);
        data.add(quocgia2);
        data.add(quocgia3);
        data.add(quocgia4);
    }
}