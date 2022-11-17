package com.example.school_card.Okhttp;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/13/下午 09:01
 */
public class HttpUtil {
    public static String BASE_URL = "http://124.93.196.45:10001/";
    public static String AUTHOR = "";

    public void sendResult(String url, String msg, String method, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = null;
        if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT")) {
            body = RequestBody.create(MediaType.parse("application/json"), msg);
        }
        Request request = new Request.Builder()
                .method(method.toUpperCase(), body)
                .addHeader("Content-Type", "application/json")
                .url(BASE_URL + url)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
