package com.example.httpsample;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Commander {

    public void doPost(String url, String jsonString) throws IOException {
        okhttp3.MediaType mediaTypeJson = okhttp3.MediaType.parse("application/json; charset=utf-8");

        RequestBody requestBody = RequestBody.create(mediaTypeJson, jsonString);

        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)//POST指定
                .build();
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        //同期呼び出し
        //Response response = client.newCall(request).execute();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //結果を表示
                Log.d("Commander", String.format("%s", response.body().string()));
            }
        });
    }
}
