package com.example.school_card.m2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.school_card.Okhttp.OkHttpTo;
import com.example.school_card.R;
import com.example.school_card.login.LoginDlActivity;
import com.example.school_card.util.SPUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class XGMM extends AppCompatActivity {

    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private EditText mm1;
    private EditText mm2;
    private EditText mm3;
    private Button butt1;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xgmm);
        initView();
        title1.setText("修改密码");
        //提交数据
        butt1.setOnClickListener(view -> {
            upPass();
        });
    }

    private void upPass() {
        SPUtil spUtil = new SPUtil();
        String sp1 = spUtil.getSp(this);
        //查询密码
        new OkHttpTo()
                .setUrl("/card/selectPass")
                .setType("POST")
                .setJsonObject("studentid", sp1)
                .setOkHttpLo(jsonObject -> {
                    if (jsonObject.optString("code").equals("200")) {
                        try {
                            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                            String password = jsonObject1.optString("password");
//                            Log.d("qweqwe", "upPass: " + password);
                            if (password.equals(mm1.getText().toString().trim())) {
                                if (mm2.getText().toString().trim().equals(mm3.getText().toString().trim())) {
                                    //修改密码
                                    new OkHttpTo()
                                            .setType("POST")
                                            .setUrl("/card/updatePass")
                                            .setJsonObject("password", mm2.getText().toString().trim())
                                            .setOkHttpLo(jsonObject2 -> {
                                                Intent intent = new Intent(this, LoginDlActivity.class);
                                                startActivity(intent);
                                                pref = getSharedPreferences("userInfo", MODE_PRIVATE);//将内容存放到userinfo的文档内
                                                editor = pref.edit();
                                                editor.remove("id");
                                                editor.commit();
                                                finish();
                                            }).start();
                                } else {
                                    Toast.makeText(this, "请重新输入新密码", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(this, "原密码不正确", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }).start();
    }

    private void initView() {
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
        mm1 = findViewById(R.id.mm1);
        mm2 = findViewById(R.id.mm2);
        mm3 = findViewById(R.id.mm3);
        butt1 = findViewById(R.id.butt1);
    }
}