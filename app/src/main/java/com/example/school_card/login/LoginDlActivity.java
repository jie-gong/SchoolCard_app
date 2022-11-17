package com.example.school_card.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.school_card.Okhttp.OkHttpTo;
import com.example.school_card.R;
import com.example.school_card.m2.MainActivity2;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;

public class LoginDlActivity extends AppCompatActivity {

    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private EditText zhanghao;
    private EditText mima;
    private TextView text1;
    private Button DL;
    private DrawerLayout drawerLayout;
    private NavigationView TuiChu;
    private SharedPreferences.Editor editor;
    private static final String TAG = "login_DL";
    private CheckBox ch1;
    private long time = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_dl);
        initView();
        onBack();//退出
        title1.setText("学生登陆");
        DL.setOnClickListener(v -> {
            String zh = zhanghao.getText().toString().trim();
            String mm = mima.getText().toString().trim();
            if (zh.equals("") || mm.equals("")) {
                Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
            } else {
                Okhttp();
            }
        });
        text1.setOnClickListener(v -> {
            Toast.makeText(this, "移动端不提供学生注册，请联系管理员提供账号密码", Toast.LENGTH_SHORT).show();
        });

    }


    public void Okhttp() {
        String username = zhanghao.getText().toString().trim();
        String password = mima.getText().toString().trim();
        new OkHttpTo()
                .setJsonObject("username", username)
                .setJsonObject("password", password)
                .setUrl("/login/studentLogin")
                .setType("POST")
                .setOkHttpLo(jsonObject -> {
                    if (jsonObject.optString("code").equals("200")) {
                        try {
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            int studentid = jsonArray.getJSONObject(0).getInt("studentid");
                            Intent intent = new Intent(this, MainActivity2.class);
                            String student = String.valueOf(studentid);
                            SharedPreferences pref = getSharedPreferences("userInfo", MODE_PRIVATE);//将内容存放到userinfo的文档内
                            editor = pref.edit();
                            editor.putString("id", student);
                            editor.commit();
                            startActivity(intent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    } else {
                        Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                    }
                }).start();

    }

    public void onBack() {

        TuiChu.setNavigationItemSelectedListener(item -> {
            item.getItemId();
            return true;
        });
        ivFh.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        TuiChu.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.tuichu) {
                finish();
            }
            return true;
        });
    }

    //双击退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        long mNowTime = System.currentTimeMillis();/**  获取第一次按键时间*/
        if ((mNowTime - time) > 1000) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            time = mNowTime;
        } else {
            finish();
            System.exit(0);
        }
        return true;
    }

    private void initView() {
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
        zhanghao = findViewById(R.id.zhanghao);
        mima = findViewById(R.id.mima);
        text1 = findViewById(R.id.text1);
        DL = findViewById(R.id.DL);
        drawerLayout = findViewById(R.id.drawerLayout);
        TuiChu = findViewById(R.id.TuiChu);
        ch1 = findViewById(R.id.ch1);
    }


}