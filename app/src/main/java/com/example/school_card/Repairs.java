package com.example.school_card;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.school_card.Okhttp.OkHttpTo;
import com.example.school_card.util.SPUtil;

public class Repairs extends AppCompatActivity {

    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private EditText nR;
    private Button get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repairs);
        initView();
        title1.setText("校园报修平台");
        ivFh.setOnClickListener(v -> {
            finish();
        });
        get.setOnClickListener(view -> {
            upRepairs();
            Intent intent = new Intent();

            startActivity(intent);
        });
    }

    private void upRepairs() {
        SPUtil spUtil = new SPUtil();
        String sp1 = spUtil.getSp(this);
        String trim = nR.getText().toString().trim();
        new OkHttpTo()
                .setJsonObject("announce", trim)
                .setJsonObject("studentid", sp1)
                .setType("POST")
                .setUrl("/card/upRepairs")
                .setOkHttpLo(jsonObject -> {
                    if (jsonObject.optString("code").equals("200")) {
                        Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
                    }
                }).start();
    }


    private void initView() {
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
        nR = findViewById(R.id.nR);
        get = findViewById(R.id.get);
    }
}