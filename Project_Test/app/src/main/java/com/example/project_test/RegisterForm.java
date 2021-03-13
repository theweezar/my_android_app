package com.example.project_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RegisterForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);
        setEvent();
    }

    private void setEvent(){
        Button submitBtn = findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText taiKhoan, matKhau, ngaySinh, eMail;
                taiKhoan = findViewById(R.id.taiKhoan);
                ngaySinh = findViewById(R.id.ngaySinh);
                eMail = findViewById(R.id.eMail);
                String ketQua = String.format("Thông tin tài khoản\nTài Khoản: %s\nNgày sinh: %s\nEmail: %s\n",
                        taiKhoan.getText().toString(), ngaySinh.getText().toString(), eMail.getText().toString());
                TextView ketQuaView = findViewById(R.id.ketQua);
                ketQuaView.setText(ketQua);
            }
        });
    }
}