package com.example.milkteashop;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// Extends sẽ có 3 tham biến được gọi lần lượt ở <doInBackGround, onProgresspUpdate, onPostExecute>
public class MyFetcher extends AsyncTask<String, Integer, String> {

    // Phương thức này được thực hiện trước khi thực hiện httprequest
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    // Phương thức doInBackground sẽ được thực hiện khi đang thực hiện httprequest, giống kiểu chạy ngầm
    // phương thức doInBackground sẽ có kiểu dữ liệu bằng với key thứ 3 ở trên
    @Override
    protected String doInBackground(String... urls) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(urls[0])
                .build();

        try  {
            Response response = client.newCall(request).execute();
            return Objects.requireNonNull(response.body()).string();
        }
        catch (IOException ignored){

        }
        return null;
    }

    // Phương thức này được thực hiện khi quá trình request chưa xong thì trong thời gian này sẽ làm gì
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    // Phương thức này được thực hiện khi đã hoàn thành httprequest
    @Override
    protected void onPostExecute(String string) {
        // Khi execute xong
        super.onPostExecute(string);
    }
}
