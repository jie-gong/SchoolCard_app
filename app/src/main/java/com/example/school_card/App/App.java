package com.example.school_card.App;

import android.app.Application;
import android.content.SharedPreferences;

public class App extends Application {

    private static String Token = "";

    public static String getToken() {
        return Token;
    }

    public static void setToken(String token) {
        Token = token;

    }


    @Override
    public void onCreate() {
        super.onCreate();
    }


}
