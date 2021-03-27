package com.example.project_test;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// Extends sẽ có 3 tham biến được gọi lần lượt ở <doInBackGround, onProgresspUpdate, onPostExecute>
public class AsynConnectionTest extends AsyncTask<String, Integer, String> {

    @Override
    protected void onPreExecute() {
        // Trước khi thực hiện request
        super.onPreExecute();
    }

    // phương thức doInBackground sẽ có kiểu dữ liệu bằng với key thứ 3 ở trên
    @Override
    protected String doInBackground(String... urls) {
        // Khi đang thực hiện request
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(urls[0])
                .build();

        try  {
            Response response = client.newCall(request).execute();
            return response.body().string();
        }
        catch (IOException e){

        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        // Nếu như quá trình request chưa xong thì trong thời gian này sẽ làm gì
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String string) {
        // Khi execute xong
        super.onPostExecute(string);
    }
}
