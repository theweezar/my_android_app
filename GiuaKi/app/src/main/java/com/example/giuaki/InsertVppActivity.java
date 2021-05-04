package com.example.giuaki;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

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

    VanPhongPhamDatabase vppdb = new VanPhongPhamDatabase(InsertVppActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_vpp);
        setControl();
        setEventForBackButton();
        setEventForImage();
        setEventForInsertButton();
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

    public void setEventForInsertButton(){
        insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maVpp = mavpp_input.getText().toString().trim();
                String tenVpp = tenvpp_input.getText().toString().trim();
                String dvt = dvt_input.getText().toString().trim();
                String giaNhap = gianhap_input.getText().toString().trim();
                byte[] byte_hinh = null;
                try {
                    Bitmap bitmap = ((BitmapDrawable) hinh_input.getDrawable()).getBitmap();
                    if (bitmap != null){
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                        byte_hinh = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                    }
                }
                catch (IOException e){
                    Toast.makeText(InsertVppActivity.this,"setEventForInsertButton() failed image processing",
                            Toast.LENGTH_SHORT).show();
                }
                if (maVpp.isEmpty()){
                    Toast.makeText(InsertVppActivity.this,"Nhập mã vpp",
                            Toast.LENGTH_SHORT).show();
                }
                else if (tenVpp.isEmpty()){
                    Toast.makeText(InsertVppActivity.this,"Nhập tên vpp",
                            Toast.LENGTH_SHORT).show();
                }
                else if (dvt.isEmpty()){
                    Toast.makeText(InsertVppActivity.this,"Nhập đơn vị tính",
                            Toast.LENGTH_SHORT).show();
                }
                else if (giaNhap.isEmpty()){
                    Toast.makeText(InsertVppActivity.this,"Nhập giá tiền",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    long newId = vppdb.insert(new VanPhongPham(maVpp, tenVpp, dvt, giaNhap, byte_hinh));
                    Toast.makeText(InsertVppActivity.this,"Thêm văn phòng phẩm với id " + newId,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}