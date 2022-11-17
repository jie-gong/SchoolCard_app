package com.example.school_card.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.school_card.R;
import com.google.android.material.navigation.NavigationView;

public class UserLogin extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private EditText zhanghao;
    private EditText mima;
    private CheckBox ch1;
    private Button DL;
    private NavigationView TuiChu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        initView();
        title1.setText("教师登录");
    }

    private void initView() {
        drawerLayout = findViewById(R.id.drawerLayout);
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
        zhanghao = findViewById(R.id.zhanghao);
        mima = findViewById(R.id.mima);
        ch1 = findViewById(R.id.ch1);
        DL = findViewById(R.id.DL);
        TuiChu = findViewById(R.id.TuiChu);
    }
}