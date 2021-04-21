package com.example.milkteashop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class HttpRequestTesting extends AppCompatActivity {

    private final boolean logged = false;

    private final String token = null;

    TextView login_profile_btn = findViewById(R.id.login_profile_btn);
    EditText host_input = findViewById(R.id.host_input);
    EditText port_input = findViewById(R.id.port_input);
    EditText route_input = findViewById(R.id.route_input);
    RadioGroup method_input = findViewById(R.id.method_input);
    Button submit_btn = findViewById(R.id.submit_login_btn);
    TextView result_view = findViewById(R.id.result);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_request_testing);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        setHttpRequestAction();
        setLoginAction();
    }

    public boolean isNumber(String number_string){
        try {
            int number = Integer.parseInt(number_string);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public void setLoginAction(){
        login_profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (logged){

                }
                else{
                    Intent intent = new Intent(HttpRequestTesting.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void setHttpRequestAction(){
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String host = host_input.getText().toString().trim();
                String port = port_input.getText().toString().trim();
                String route = route_input.getText().toString().trim();
                result_view.setTextColor(getResources().getColor(R.color.red));

                if (host.isEmpty()){
                    result_view.setText("No host");
                }
                else if (port.isEmpty()){
                    result_view.setText("No port");
                }
                else if (route.isEmpty()){
                    result_view.setText("No route");
                }
                else {
                    int method_id = method_input.getCheckedRadioButtonId();
                    String result = "";
                    if (method_id == R.id.method_get){
                        try {
                            result = new MyFetcher().execute(String.format("http://%s:%s/%s", host, port, route)).get();
                            result_view.setTextColor(getResources().getColor(R.color.result_1));
                            result_view.setText(result);
                        }
                        catch(ExecutionException e){
                            result_view.setText(e.getMessage());
                        }
                        catch(InterruptedException e){
                            result_view.setText(e.getMessage());
                        }
                    }
                    else if (method_id == R.id.method_post){
                        result_view.setText("No support for POST method");
                    }
                }
            }
        });

    }
}