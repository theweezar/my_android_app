package com.example.giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button phongban_btn;
    Button nhanvien_btn;
    Button vanphongpham_btn;
    Button phieucapphat_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEventPhongBan();
        setEventNhanVien();
        setEventVanPhongPham();
    }

    public void setControl(){
        phongban_btn = findViewById(R.id.phongban_btn);
        nhanvien_btn = findViewById(R.id.nhanvien_btn);
        vanphongpham_btn = findViewById(R.id.vanphongpham_btn);
        phieucapphat_btn = findViewById(R.id.phieucapphat_btn);
    }

    public void setEventPhongBan(){
        phongban_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InsertPhongBanActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setEventNhanVien(){
        nhanvien_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InsertNhanVienActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setEventVanPhongPham(){
        vanphongpham_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InsertVppActivity.class);
                startActivity(intent);
            }
        });
    }
}