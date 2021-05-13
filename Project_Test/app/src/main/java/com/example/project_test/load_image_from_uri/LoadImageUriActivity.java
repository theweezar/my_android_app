package com.example.project_test.load_image_from_uri;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.project_test.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LoadImageUriActivity extends AppCompatActivity {

    ImageView ivBasicImage;
    ListView lvHienThi;
    ArrayList<User> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        setControl();
        loadImageWithPicasso();
        loadUserData();
    }

    public void setControl(){
        ivBasicImage = (ImageView) findViewById(R.id.ivBasicImage);
        lvHienThi = (ListView) findViewById(R.id.lvHienThi);
        data = new ArrayList<>();
    }

    public void loadImageWithPicasso(){
        String imageUri = "https://i.imgur.com/tGbaZCY.jpg";
        Picasso.get().load(imageUri).into(ivBasicImage);
    }

    public void loadUserData(){
        loadData();
        CustomAdapter adapter = new CustomAdapter(LoadImageUriActivity.this, R.layout.item_user, data);
        lvHienThi.setAdapter(adapter);
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("users_list.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void loadData() {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray userArray = obj.getJSONArray("users");
            for (int i = 0; i < userArray.length(); i++) {
                JSONObject userDetail = userArray.getJSONObject(i);
                User user = new User();
                user.setId(userDetail.getInt("id"));
                user.setAvatar_url(userDetail.getString("avatar_url"));
                user.setLogin(userDetail.getString("login"));
                data.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}