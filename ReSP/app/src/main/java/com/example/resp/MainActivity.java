package com.example.resp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private final boolean logged = false;

    private final String token = null;

    EditText host_input;
    RadioGroup method_input;
    Button submit_btn;
    TextView result_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        setControl();
        setHttpRequestAction();
    }

    public void setControl(){
        host_input = (EditText)findViewById(R.id.host_input);
        method_input = (RadioGroup) findViewById(R.id.method_input);
        submit_btn = (Button) findViewById(R.id.submit_login_btn);
        result_view = (TextView)findViewById(R.id.result);
    }

    public void setHttpRequestAction(){
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String host = host_input.getText().toString().trim();
                result_view.setTextColor(getResources().getColor(R.color.red));

                if (host.isEmpty()){
                    result_view.setText("No host");
                }
                else {
                    int method_id = method_input.getCheckedRadioButtonId();
                    String result = "";
                    if (method_id == R.id.method_get){
                        try {
                            result = new FetchHelper().execute(String.format("http://%s", host)).get();
                            result_view.setTextColor(getResources().getColor(R.color.result_1));
                            try{
                                result = parseJSON(result);
                            }
                            catch(JSONException e){
                                e.printStackTrace();
                            }
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

    public String parseJSON(String json) throws JSONException {
        String result = "";
        JSONObject jsonObject = new JSONObject(json);
        jsonObject.get
        return result;
    }
}