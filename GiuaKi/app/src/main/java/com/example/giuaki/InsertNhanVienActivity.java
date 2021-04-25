package com.example.giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InsertNhanVienActivity extends AppCompatActivity {

    EditText manv_input;
    EditText hoten_input;
    EditText ngaysinh_input;
    Spinner phongban_input;
    Button back_btn;
    Button insert_btn;
    PhongBanDatabase phongbandb;
    NhanVienDatabase nhanviendb;
    List<PhongBan> list_phongban;

    public InsertNhanVienActivity(){
        // init database for 2 entities (PHONGBAN, NHANVIEN)
        phongbandb = new PhongBanDatabase(InsertNhanVienActivity.this);
        nhanviendb = new NhanVienDatabase(InsertNhanVienActivity.this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_nhan_vien);
        setControl();
        setDataForPhongBanToInsert();
        setEventForBackButton();
        setEventForInsertButton();
    }

    public void setControl(){
        manv_input = (EditText)findViewById(R.id.manv_input);
        hoten_input = (EditText)findViewById(R.id.hoten_input);
        ngaysinh_input = (EditText)findViewById(R.id.ngaysinh_input);
        phongban_input = (Spinner)findViewById(R.id.phongban_input);
        back_btn = (Button)findViewById(R.id.back_btn);
        insert_btn = (Button)findViewById(R.id.insert_btn);
    }

    public void setDataForPhongBanToInsert(){
        list_phongban = phongbandb.select();

        // This list is just for phongban's name to display on screen
        List<String> tenphongban = new ArrayList<>();

        for(int i = 0; i < list_phongban.size(); i++){
            tenphongban.add(list_phongban.get(i).getTenpb());
        }

        // Creating adapter for spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, tenphongban);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        phongban_input.setAdapter(arrayAdapter);
    }

    public void setEventForBackButton(){
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void setEventForInsertButton(){
        insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String manv = manv_input.getText().toString().trim();
                String hoten = hoten_input.getText().toString().trim();
                String ngaysinh = ngaysinh_input.getText().toString().trim();
                long phongban = phongban_input.getSelectedItemId();

                if (manv.isEmpty()){
                    Toast.makeText(InsertNhanVienActivity.this, "Nhập mã nhân viên", Toast.LENGTH_SHORT).show();
                }
                else if (hoten.isEmpty()){
                    Toast.makeText(InsertNhanVienActivity.this, "Nhập họ tên", Toast.LENGTH_SHORT).show();
                }
                else if (ngaysinh.isEmpty()){
                    Toast.makeText(InsertNhanVienActivity.this, "Nhập ngày sinh", Toast.LENGTH_SHORT).show();
                }
                // ^([0-9]{2})+\W+([0-9]{2})+\W+([0-9]{4})+$
                else if (!ngaysinh.matches("^([0-9]{2})+\\W+([0-9]{2})+\\W+([0-9]{4})+$")){
                    // Check dd/mm/yyyy
                    Toast.makeText(InsertNhanVienActivity.this, "Nhập sai định dạng ngày sinh",
                            Toast.LENGTH_SHORT).show();
                }
                else{
//                    Toast.makeText(InsertNhanVienActivity.this,
//                            "Id spinner: " + list_phongban.get((int)phongban).getMapb(), Toast.LENGTH_SHORT).show();
                    NhanVien nv = new NhanVien(
                            manv, hoten, ngaysinh, list_phongban.get((int)phongban).getId());
                    long new_nhanvien_id = nhanviendb.insert(nv);
                    Toast.makeText(InsertNhanVienActivity.this,
                            "Thêm nhân viên thành công có id: " + new_nhanvien_id, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}