package com.example.school_card.Okhttp;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.school_card.App.App;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class OkHttpTo extends Thread {
    private String type;
    private String url = "http://10.212.153.72:8000";
    private OkHttpLo okHttpLo;
    private final JSONObject jsonObject = new JSONObject();

    public String getUrl() {
        return url;
    }


    public OkHttpTo setType(String type) {
        this.type = type;
        return this;
    }

    public OkHttpTo setUrl(String url) {
        this.url += url;
        return this;
    }

    public OkHttpTo setOkHttpLo(OkHttpLo okHttpLo) {
        this.okHttpLo = okHttpLo;
        return this;
    }

    public OkHttpTo setJsonObject(String k, Object v) {
        try {
            jsonObject.put(k, v);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    private final Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            okHttpLo.onResponse((JSONObject) msg.obj);
            return true;
        }
    });

    @Override
    public void run() {
        super.run();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = null;
        if (type.equalsIgnoreCase("POST") ||
                type.equalsIgnoreCase("PUT")) {
            body = RequestBody.create(mediaType, jsonObject.toString());
        }
        Request request = new Request.Builder()
                .url(url)
                .method(type.toUpperCase(), body)
//                .addHeader("Authorization", App.getToken())
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            Message msg = Message.obtain();
            msg.obj = new JSONObject(response.body().string());
            handler.sendMessage(msg);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}