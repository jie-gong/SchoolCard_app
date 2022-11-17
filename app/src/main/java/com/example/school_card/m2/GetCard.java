package com.example.school_card.m2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.school_card.Okhttp.OkHttpLo;
import com.example.school_card.Okhttp.OkHttpTo;
import com.example.school_card.R;
import com.example.school_card.adapter.Main2_Adapter_QD;
import com.example.school_card.adapter.Main2_Record_Adapter;
import com.example.school_card.bean.QDJL_bean;
import com.example.school_card.bean.Record_bean;
import com.example.school_card.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetCard extends AppCompatActivity {

    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private TextView shuaxin;
    private ListView listViewJl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_card);
        initView();
        Okhttp();
        title1.setText("充值记录");
        ivFh.setOnClickListener(v -> {
            finish();
        });
        shuaxin.setOnClickListener(v -> {
            Okhttp();
        });
    }

    private Main2_Record_Adapter adapter;
    private ArrayList<Record_bean> beans = new ArrayList<>();

    private void Okhttp() {
        SPUtil spUtil = new SPUtil();
        String sp = spUtil.getSp(this);
        new OkHttpTo()
                .setJsonObject("studentid", sp)
                .setUrl("/card/selectbalance")
                .setType("POST")
                .setOkHttpLo(jsonObject -> {
                    if (jsonObject.optString("code").equals("200")) {
                        beans = new Gson()
                                .fromJson(jsonObject.optJSONArray("data").toString(),
                                        new TypeToken<List<Record_bean>>() {
                                        }.getType());
                        adapter = new Main2_Record_Adapter(beans);
                        listViewJl.setAdapter(adapter);
                        runOnUiThread(() -> {
                            listViewJl.setAdapter(adapter);
                            ListAdapter listAdapter = listViewJl.getAdapter();
                            if (listAdapter == null) {
                                return;
                            }
                            int h = 0;
                            for (int i = 0; i < beans.size(); i++) {
                                View view = listAdapter.getView(i, null, listViewJl);
                                view.measure(1, 1);
                                h += view.getMeasuredHeight();
                            }
                            ViewGroup.LayoutParams params = listViewJl.getLayoutParams();
                            params.height = h + listViewJl.getDividerHeight() * (listAdapter.getCount() - 1);
                            listViewJl.setLayoutParams(params);
                        });
                    } else {
                        ArrayList<Record_bean> qdjl_beans = new ArrayList<>();
                        Record_bean bean = new Record_bean();
                        bean.setBalance("当前暂无充值记录");
                        qdjl_beans.add(bean);
                        adapter = new Main2_Record_Adapter(qdjl_beans);
                        listViewJl.setAdapter(adapter);
                    }
                }).start();
    }

    private void initView() {
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
        shuaxin = findViewById(R.id.shuaxin);
        listViewJl = findViewById(R.id.listView_Jl);
    }
}