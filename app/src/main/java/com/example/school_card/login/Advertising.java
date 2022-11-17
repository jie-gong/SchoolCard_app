package com.example.school_card.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.school_card.R;
import com.example.school_card.m1.MainActivity;
import com.example.school_card.m2.MainActivity2;

import java.util.Timer;
import java.util.TimerTask;

public class Advertising extends AppCompatActivity {

    private TextView text;
    private final Handler handler = new Handler();
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertising);
        initView();
        TG();

    }

    private int s = 2;

    private void ss() {
        //倒计时跳过界面
        s--;
        if (s == 0) {
            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(intent);
            finish();
        }
        runOnUiThread(() -> {
            text.setText(s + "跳过");
        });
    }


    private void initView() {
        text = findViewById(R.id.text);
    }

    public void TG() {
        //获得SharedPreferences对象
        SharedPreferences pref = getSharedPreferences("userInfo", MODE_PRIVATE);//将内容存放到userinfo的文档内
        editor = pref.edit();
        String zhang = pref.getString("id", "");//获取账号
        if (zhang.equals("")) {
            Intent intent = new Intent(Advertising.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    ss();
                }
            };
            timer.schedule(task, 100, 1300);
            //点击跳过
            text.setOnClickListener(view -> {
                timer.cancel();
                Intent intent = new Intent(Advertising.this, MainActivity2.class);
                startActivity(intent);
                finish();
            });
        }
    }
}
