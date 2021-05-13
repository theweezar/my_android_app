package com.example.project_test.load_image_from_uri;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.project_test.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<User> {

    Context context;
    int resource;
    ArrayList<User> data;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<User> data) {
        super(context, resource, data);
        this.context = context;
        this.data = data;
        this.resource = resource;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, null);

        TextView tvLoginName = (TextView) convertView.findViewById(R.id.tv_login_name);
        TextView tvId = (TextView) convertView.findViewById(R.id.tv_id);
        ImageView ivAvatar = (ImageView) convertView.findViewById(R.id.iv_avatar);

        User u = data.get(position);
        Picasso.get()
                .load(u.avatar_url)
                .into(ivAvatar);
        tvLoginName.setText(u.login);
        tvId.setText(String.valueOf(u.id));
        return convertView;
    }

}


