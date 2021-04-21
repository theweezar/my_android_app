package com.example.project_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<QuocGia> {
    Context context;
    int resource;
    ArrayList<QuocGia> data;

    public CustomAdapter(Context context, int resource, ArrayList data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(position %2 ==0)
         convertView = LayoutInflater.from(context)
                 .inflate(R.layout.item_quoc_gia, null);
        else
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_quoc_gia2, null);
        ImageView imQuocky = convertView.findViewById(R.id.imQuocKy);
        TextView tvTenQG = convertView.findViewById(R.id.tvTenQG);
        TextView tvDanSo = convertView.findViewById(R.id.tvDanSo);
        Button btnXoa =convertView.findViewById(R.id.btnXoa);
        Button btnSua =convertView.findViewById(R.id.btnSua);

        QuocGia quocGia = data.get(position);
        imQuocky.setImageResource(quocGia.getQuocKy());
        tvTenQG.setText(quocGia.getTenQG());
        tvDanSo.setText(quocGia.getDanSo());

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(position);
                notifyDataSetChanged();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "sua "+ quocGia.getTenQG(), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
