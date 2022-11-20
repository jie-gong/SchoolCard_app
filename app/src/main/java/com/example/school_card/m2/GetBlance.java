package com.example.school_card.m2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.school_card.Okhttp.OkHttpLo;
import com.example.school_card.Okhttp.OkHttpTo;
import com.example.school_card.R;
import com.example.school_card.util.SPUtil;

import org.json.JSONObject;

public class GetBlance extends AppCompatActivity {

    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private EditText edit;
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;
    private Button getB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_blance);
        initView();
        title1.setText("账户充值");
        ivFh.setOnClickListener(v -> finish());
        t1.setOnClickListener(v -> {
            edit.setText("10");
        });
        t2.setOnClickListener(v -> {
            edit.setText("20");
        });
        t3.setOnClickListener(v -> {
            edit.setText("30");
        });
        t4.setOnClickListener(v -> {
            edit.setText("40");
        });
        getB.setOnClickListener(v -> {
            Okhttp();
            finish();
        });
    }

    private void Okhttp() {
        String s = edit.getText().toString();
        SPUtil spUtil = new SPUtil();
        String sp = spUtil.getSp(this);
        new OkHttpTo()
                .setUrl("/card/saveMoney")
                .setJsonObject("balance", s)
                .setJsonObject("studentid", sp)
                .setType("POST")
                .setOkHttpLo(jsonObject -> {
                    if (jsonObject.optString("code").equals("200")) {
                        Toast.makeText(this, "充值成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "充值失败", Toast.LENGTH_SHORT).show();
                    }
                }).start();
    }

    private void initView() {
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
        edit = findViewById(R.id.edit);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        getB = findViewById(R.id.getB);
    }
}