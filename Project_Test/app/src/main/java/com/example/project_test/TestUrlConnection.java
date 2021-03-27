package com.example.project_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import static android.os.StrictMode.*;

public class TestUrlConnection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_url_connection);
        ThreadPolicy policy = new ThreadPolicy.Builder().permitAll().build();
        setThreadPolicy(policy);
        Button testBtn = findViewById(R.id.test_btn);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testURLConnection();
            }
        });

        Toast.makeText(TestUrlConnection.this,"App is running",Toast.LENGTH_SHORT).show();
    }

    public void testURLConnection(){
        try{
            String input = new AsynConnectionTest().execute("http://192.168.1.6:8000/register").get();
            TextView httpData = findViewById(R.id.test_http_data);
            httpData.setText(input);
        }
        catch (ExecutionException e){

        }
        catch (InterruptedException e){

        }
    }


}