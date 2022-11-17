package com.example.school_card;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class news1 extends AppCompatActivity {

    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private TextView tvName;
    private ImageView ivNew;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news1);
        initView();
        ivFh.setOnClickListener(view -> {
            finish();
        });
        title1.setText("新闻");
        tvContent.setText("\n为提升技能大赛工作水平，电气工程系于2013年率先在机电一体化技术专业开展“卓越技师班”试点培养工作，至今已成立9届卓越技师班，覆盖全部高职专业。\n" +
                "\n" +
                "在“卓越技师”试点培养过程中，将大赛项目转化为整周实训课程，融入人才培养方案，解决技能大赛“精英教育”的问题，提高大赛普惠率。为解决大赛集训期间学生需要停课、无法接受系统化人才培养的问题，电气工程系把每门专业课按照基础、进阶、强化三个阶段分别融入三个学期教学，将教学内容重新序化和组合。选聘多名骨干教师承担卓越技师班授课任务，利用集中备课的形式让骨干教师了解技能大赛，促进教师的实践教学水平。");
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