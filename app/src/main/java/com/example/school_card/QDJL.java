package com.example.school_card;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.school_card.Okhttp.OkHttpLo;
import com.example.school_card.Okhttp.OkHttpTo;
import com.example.school_card.adapter.Main2_Adapter_QD;
import com.example.school_card.adapter.Main2_Announce_Adapter;
import com.example.school_card.bean.Announce_bean;
import com.example.school_card.bean.QDJL_bean;
import com.example.school_card.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QDJL extends AppCompatActivity {

    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private TextView shuaxin;
    private ListView listViewTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qdjl);
        initView();
        ivFh.setOnClickListener(v -> finish());
        title1.setText("签到记录");
        Okhttp();
        shuaxin.setOnClickListener(view -> {
            Okhttp();
        });
    }

    private Main2_Adapter_QD adapter_qd;
    private ArrayList<QDJL_bean> beans = new ArrayList<>();

    private void Okhttp() {
        SPUtil spUtil = new SPUtil();
        String sp = spUtil.getSp(this);
        new OkHttpTo().setType("POST")
                .setUrl("/card/selectSign")
                .setJsonObject("studentid", sp)
                .setOkHttpLo(jsonObject -> {
                    if (jsonObject.optString("code").equals("200")) {
                        beans = new Gson()
                                .fromJson(jsonObject.optJSONArray("data").toString(),
                                        new TypeToken<List<QDJL_bean>>() {

                                        }.getType());
                        adapter_qd = new Main2_Adapter_QD(beans);
                        runOnUiThread(() -> {
                            listViewTwo.setAdapter(adapter_qd);
                            ListAdapter listAdapter = listViewTwo.getAdapter();
                            if (listAdapter == null) {
                                return;
                            }
                            int h = 0;
                            for (int i = 0; i < beans.size(); i++) {
                                View view = listAdapter.getView(i, null, listViewTwo);
                                view.measure(1, 1);
                                h += view.getMeasuredHeight();
                            }
                            ViewGroup.LayoutParams params = listViewTwo.getLayoutParams();
                            params.height = h + listViewTwo.getDividerHeight() * (listAdapter.getCount() - 1);
                            listViewTwo.setLayoutParams(params);
                        });
                    } else {
                        ArrayList<QDJL_bean> qdjl_beans = new ArrayList<>();
                        QDJL_bean bean = new QDJL_bean();
                        bean.setFrequency("当前暂无签到记录");
                        qdjl_beans.add(bean);
                        adapter_qd = new Main2_Adapter_QD(qdjl_beans);
                        listViewTwo.setAdapter(adapter_qd);
                    }

                }).start();
    }

    private void initView() {
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
        shuaxin = findViewById(R.id.shuaxin);
        listViewTwo = findViewById(R.id.listView_two);
    }
}