package com.example.interproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Quocgia> {
    Context context;
    int resource;
    ArrayList data;

    public CustomAdapter(Context context, int resource, ArrayList data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource,null);
        // Control
        ImageView imgQuocky = convertView.findViewById(R.id.imQuocKy);
        TextView tvTenQG = convertView.findViewById(R.id.tenQuocgia);
        TextView tvDanSo = convertView.findViewById(R.id.danso);
        Quocgia quocgia = (Quocgia) data.get(position);
        tvTenQG.setText(quocgia.getTenQG());
        tvDanSo.setText(quocgia.getDanSo());
        return convertView;
    }
}

