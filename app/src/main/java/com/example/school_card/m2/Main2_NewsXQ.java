package com.example.school_card.m2;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.school_card.Okhttp.HttpUtil;
import com.example.school_card.R;
import com.example.school_card.bean.News_Bean;
import com.example.school_card.bean.News_List_Bean;

public class Main2_NewsXQ extends AppCompatActivity {

    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private TextView tvName;
    private ImageView ivNew;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_news_xq);
        initView();
        ivFh.setOnClickListener(v -> finish());
        title1.setText("新闻详情");
        News_List_Bean news = (News_List_Bean) getIntent().getSerializableExtra("news");
        tvContent.setText("\u3000\u3000" + Html.fromHtml(news.getContent()));
        tvName.setText(news.getTitle());
        Glide.with(this)
                .load("http://124.93.196.45:10001" + news.getCover())
                .into(ivNew);
    }

    private void initView() {
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
        tvName = findViewById(R.id.tv_name);
        ivNew = findViewById(R.id.iv_new);
        tvContent = findViewById(R.id.tv_content);
    }
}