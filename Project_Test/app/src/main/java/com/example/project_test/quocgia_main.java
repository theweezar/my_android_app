package com.example.project_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import java.util.ArrayList;

public class quocgia_main extends AppCompatActivity {

    EditText edtQG,edtDanSo;
    Spinner spChau;
    ListView lvHienThi;
    ArrayList<QuocGia> data;
    Button btnThem,btnXoa, btnSua, btnXoaTrang;
    CustomAdapter adapter;
    QuocGia quocGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quocgia_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        khoitao();
        adapter = new CustomAdapter(this,
                R.layout.item_quoc_gia, data);
        lvHienThi.setAdapter(adapter);

    }

    private void khoitao() {
        data = new ArrayList<>();
        QuocGia quocGia1= new QuocGia();
        quocGia1.setQuocKy(R.drawable.america);
        quocGia1.setTenQG("america");
        quocGia1.setDanSo("1000");
        data.add(quocGia1);
        QuocGia quocGia2= new QuocGia();
        quocGia2.setQuocKy(R.drawable.australia);
        quocGia2.setTenQG("new_zealand");
        quocGia2.setDanSo("2000");
        data.add(quocGia2);
        QuocGia quocGia3= new QuocGia();
        quocGia3.setQuocKy(R.drawable.china);
        quocGia3.setTenQG("china");
        quocGia3.setDanSo("3000");
        data.add(quocGia3);
        QuocGia quocGia4= new QuocGia();
        quocGia4.setQuocKy(R.drawable.australia);
        quocGia4.setTenQG("australia");
        quocGia4.setDanSo("4000");
        data.add(quocGia4);
    }

    private void setControl() {
        lvHienThi = findViewById(R.id.lvHienThi);

    }

    public void setSpinner(){
        
    }
}