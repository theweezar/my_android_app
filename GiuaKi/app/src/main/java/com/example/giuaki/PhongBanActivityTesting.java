package com.example.giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class PhongBanActivityTesting extends AppCompatActivity {

    Button insert_btn;
    EditText mapb_input;
    EditText tenpb_input;
    TableLayout table_list;
    Button reload_btn;
    PhongBanDatabase phongbandb = new PhongBanDatabase(PhongBanActivityTesting.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_ban_testing);
        setControl();
        setEventForInsertBtn();
        setEventForReloadBtn();
    }

    public void setControl(){
        insert_btn = findViewById(R.id.insert_btn);
        mapb_input = findViewById(R.id.mapb_input);
        tenpb_input = findViewById(R.id.tenpb_input);
        table_list = findViewById(R.id.table_list);
        reload_btn = findViewById(R.id.reload_btn);
    }

    public void setEventForInsertBtn(){
        insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mapb = mapb_input.getText().toString().trim();
                String tenpb = tenpb_input.getText().toString().trim();

                if (mapb.isEmpty()){
                    Toast.makeText(PhongBanActivityTesting.this, "Nhập mã phòng ban", Toast.LENGTH_SHORT).show();
                }
                else if (tenpb.isEmpty()){
                    Toast.makeText(PhongBanActivityTesting.this, "Nhập tên phòng ban", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        phongbandb.insert(new PhongBan(mapb, tenpb));
                        Toast.makeText(PhongBanActivityTesting.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e){
                        Toast.makeText(PhongBanActivityTesting.this, "Lỗi sqlite", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    public void setEventForReloadBtn(){
        reload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<PhongBan> list_phongban = phongbandb.select();

                for(int i = 0; i < list_phongban.size(); i++){
                    TableRow row = new TableRow(PhongBanActivityTesting.this);

                    row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT));

                    row.addView(renderIdColumn(list_phongban.get(i).getId()));
                    row.addView(renderInforColumn(
                            String.format("%s\n%s", list_phongban.get(i).getMapb(), list_phongban.get(i).getTenpb())
                    ));
                    table_list.addView(row);
                }
                Toast.makeText(PhongBanActivityTesting.this,"List's length: " + list_phongban.size(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint({"DefaultLocale", "UseCompatLoadingForDrawables"})
    public TextView renderIdColumn(long id){
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT
        );
        TextView id_view = new TextView(PhongBanActivityTesting.this);
        id_view.setText(String.format("%d",id));
        id_view.setPadding(5,0,5,0);
        id_view.setBackground(getResources().getDrawable(R.drawable.border_black_shape_rectangle_noradius));
        id_view.setLayoutParams(layoutParams);
        return id_view;
    }

    @SuppressLint({"DefaultLocale", "UseCompatLoadingForDrawables"})
    public TextView renderInforColumn(String infor){
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT,
                1
        );
        TextView id_view = new TextView(PhongBanActivityTesting.this);
        id_view.setText(infor);
        id_view.setPadding(5,0,5,0);
        id_view.setBackground(getResources().getDrawable(R.drawable.border_black_shape_rectangle_noradius));
        id_view.setLayoutParams(layoutParams);
        return id_view;
    }
}