package com.example.giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InsertPhongBanActivity extends AppCompatActivity {

    EditText mapb_input;
    EditText tenpb_input;
    Button back_btn;
    Button insert_btn;
    PhongBanDatabase phongbandb = new PhongBanDatabase(InsertPhongBanActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_phong_ban);
        setControl();
        setEventForBackButton();
        setEventForInsertButton();
    }

    public void setControl(){
        mapb_input = findViewById(R.id.mapb_input);
        tenpb_input = findViewById(R.id.tenpb_input);
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

    public void setEventForInsertButton(){
        insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mapb = mapb_input.getText().toString().trim();
                String tenpb = tenpb_input.getText().toString().trim();

                if (mapb.isEmpty()){
                    Toast.makeText(InsertPhongBanActivity.this, "Nhập mã phòng ban", Toast.LENGTH_SHORT).show();
                }
                else if (tenpb.isEmpty()){
                    Toast.makeText(InsertPhongBanActivity.this, "Nhập tên phòng ban", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        long newPhongbanId = phongbandb.insert(new PhongBan(mapb, tenpb));
                        Toast.makeText(InsertPhongBanActivity.this,
                                "Thêm thành công phòng ban có id: " + newPhongbanId, Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e){
                        Toast.makeText(InsertPhongBanActivity.this, "Lỗi sqlite", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}