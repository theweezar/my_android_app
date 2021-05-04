package com.example.giuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListVppActivity extends AppCompatActivity {

    Button reload_btn;
    TableLayout list_vpp_table;
    ImageView preview_image;

    VanPhongPhamDatabase vppdb = new VanPhongPhamDatabase(ListVppActivity.this);

    List<VanPhongPham> list_vpp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vpp);
        setControl();
        setEventForReloadBtn();
    }

    public void setControl(){
        reload_btn = (Button)findViewById(R.id.reload_btn);
        list_vpp_table = (TableLayout)findViewById(R.id.list_vpp_table);
        preview_image = (ImageView)findViewById(R.id.preview_image);
    }

    public void setEventForReloadBtn(){
        reload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadVPP();
            }
        });
    }

    public void loadVPP(){
        list_vpp = vppdb.select();
        Toast.makeText(ListVppActivity.this,"Độ dài danh sách vpp là " + list_vpp.size(),
                Toast.LENGTH_SHORT).show();
        for (int i = 0; i < list_vpp.size(); i++){
            TableRow row = new TableRow(ListVppActivity.this);

            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            row.addView(renderInforColumn(list_vpp.get(i).getTenVpp()));
            row.addView(renderInforColumn(list_vpp.get(i).getDvt()));
            row.addView(renderInforColumn(list_vpp.get(i).getGiaNhap()));

            int finalI = i;
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    byte[] byte_hinh = list_vpp.get(finalI).getHinh();
                    if (byte_hinh != null){
                        Bitmap bitmap = BitmapFactory.decodeByteArray(byte_hinh, 0, byte_hinh.length);
                        preview_image.setImageBitmap(bitmap);
                    }
                }
            });

            list_vpp_table.addView(row);
        }
    }

    @SuppressLint({"DefaultLocale", "UseCompatLoadingForDrawables"})
    public TextView renderInforColumn(String infor){
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT
        );
        TextView str_view = new TextView(ListVppActivity.this);
        str_view.setText(infor);
        str_view.setTextSize(20);
        str_view.setTextColor(getResources().getColor(R.color.black));
        str_view.setPadding(5,5,5,5);
        str_view.setBackground(getResources().getDrawable(R.drawable.border_black_shape_rectangle_noradius));
        str_view.setLayoutParams(layoutParams);
        return str_view;
    }


}