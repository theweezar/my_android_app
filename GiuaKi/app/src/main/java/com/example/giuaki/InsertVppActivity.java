package com.example.giuaki;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class InsertVppActivity extends AppCompatActivity {

    EditText mavpp_input;
    EditText tenvpp_input;
    EditText dvt_input;
    EditText gianhap_input;
    ImageView hinh_input;
    Button back_btn;
    Button insert_btn;

    int IMAGE_FOLDER = 1000;
    int PERMISSION_GRANTED = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_vpp);
        setControl();
        setEventForBackButton();
        setEventForImage();
    }

    public void setControl(){
        mavpp_input = (EditText)findViewById(R.id.mavpp_input);
        tenvpp_input = (EditText)findViewById(R.id.tenvpp_input);
        dvt_input = (EditText)findViewById(R.id.dvt_input);
        gianhap_input = (EditText)findViewById(R.id.gianhap_input);
        hinh_input = (ImageView)findViewById(R.id.hinh_input);
        back_btn = (Button)findViewById(R.id.back_btn);
        insert_btn = (Button)findViewById(R.id.insert_btn);
    }

    public void setEventForBackButton(){
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void pickImageFromStorage(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_FOLDER);
    }

    public void setEventForImage(){
        hinh_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissions, PERMISSION_GRANTED);
                    }
                    else{
                        pickImageFromStorage();
                    }
                }
                else{
                    pickImageFromStorage();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_GRANTED){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                pickImageFromStorage();
            }
        }
        else{
            Toast.makeText(InsertVppActivity.this,"Permission's denied....", Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == IMAGE_FOLDER && resultCode == RESULT_OK && data != null){
            hinh_input.setImageURI(data.getData());
            Toast.makeText(InsertVppActivity.this,"Thêm hình thành công", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}