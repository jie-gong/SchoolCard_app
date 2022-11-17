package com.example.school_card.m2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.school_card.R;
import com.example.school_card.adapter.Main2_Adapter;
import com.example.school_card.m1.MainActivity;
import com.example.school_card.m2_fragment.Fragment_main_five;
import com.example.school_card.m2_fragment.Fragment_main_four;
import com.example.school_card.m2_fragment.Fragment_main_one;
import com.example.school_card.m2_fragment.Fragment_main_six;
import com.example.school_card.m2_fragment.Fragment_main_two;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private androidx.drawerlayout.widget.DrawerLayout drawerLayout;
    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private static ViewPager2 viewpager;
    private ImageView iv1;
    private TextView tv1;
    private ImageView iv2;
    private TextView tv2;
    private ImageView iv3;
    private TextView tv3;
    private ImageView iv4;
    private TextView tv4;
    private ImageView iv5;
    private TextView tv5;
    private NavigationView mainNav;
    private SharedPreferences.Editor editor;
    private TextView viewById;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private Main2_Adapter main2_adapter = new Main2_Adapter(getSupportFragmentManager(), getLifecycle(), fragments);


    public static void setIndex0() {
        viewpager.setCurrentItem(0);
    }

    public static void setIndex1() {
        viewpager.setCurrentItem(2);
    }

    public static void setIndex2() {
        viewpager.setCurrentItem(3);
    }

    public static void setIndex3() {
        viewpager.setCurrentItem(4);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        CeB();
        fragments.add(new Fragment_main_one());
        fragments.add(new Fragment_main_six());
        fragments.add(new Fragment_main_two());
        fragments.add(new Fragment_main_four());
        fragments.add(new Fragment_main_five());
        Main2_Adapter main2_adapter = new Main2_Adapter(getSupportFragmentManager(), getLifecycle(), fragments);
        viewpager.setAdapter(main2_adapter);
        viewpager.setOffscreenPageLimit(5);
//        viewpager.setUserInputEnabled(false); //true:滑动，false：禁止滑动
        viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        title1.setText("教师公告");
                        iv1.setImageResource(R.mipmap.sy2);
                        tv1.setTextColor(Color.parseColor("#827B7B"));
                        iv2.setImageResource(R.mipmap.gd1);
                        tv2.setTextColor(Color.parseColor("#ffffff"));
                        iv3.setImageResource(R.mipmap.dj1);
                        tv3.setTextColor(Color.parseColor("#ffffff"));
                        iv4.setImageResource(R.mipmap.xw1);
                        tv4.setTextColor(Color.parseColor("#ffffff"));
                        iv5.setImageResource(R.mipmap.gr1);
                        tv5.setTextColor(Color.parseColor("#ffffff"));
                        break;
                    case 1:
                        title1.setText("全部服务");
                        iv1.setImageResource(R.mipmap.sy1);
                        tv1.setTextColor(Color.parseColor("#ffffff"));
                        iv2.setImageResource(R.mipmap.gd2);
                        tv2.setTextColor(Color.parseColor("#827B7B"));
                        iv3.setImageResource(R.mipmap.dj1);
                        tv3.setTextColor(Color.parseColor("#ffffff"));
                        iv4.setImageResource(R.mipmap.xw1);
                        tv4.setTextColor(Color.parseColor("#ffffff"));
                        iv5.setImageResource(R.mipmap.gr1);
                        tv5.setTextColor(Color.parseColor("#ffffff"));
                        break;
                    case 2:
                        title1.setText("我的消息");
                        iv1.setImageResource(R.mipmap.sy1);
                        tv1.setTextColor(Color.parseColor("#ffffff"));
                        iv2.setImageResource(R.mipmap.gd1);
                        tv2.setTextColor(Color.parseColor("#ffffff"));
                        iv3.setImageResource(R.mipmap.dj);
                        tv3.setTextColor(Color.parseColor("#827B7B"));
                        iv4.setImageResource(R.mipmap.xw1);
                        tv4.setTextColor(Color.parseColor("#ffffff"));
                        iv5.setImageResource(R.mipmap.gr1);
                        tv5.setTextColor(Color.parseColor("#ffffff"));
                        break;
                    case 3:
                        title1.setText("校园新闻");
                        iv1.setImageResource(R.mipmap.sy1);
                        tv1.setTextColor(Color.parseColor("#ffffff"));
                        iv2.setImageResource(R.mipmap.gd1);
                        tv2.setTextColor(Color.parseColor("#ffffff"));
                        iv3.setImageResource(R.mipmap.dj1);
                        tv3.setTextColor(Color.parseColor("#ffffff"));
                        iv4.setImageResource(R.mipmap.xw2);
                        tv4.setTextColor(Color.parseColor("#827B7B"));
                        iv5.setImageResource(R.mipmap.gr1);
                        tv5.setTextColor(Color.parseColor("#ffffff"));
                        break;
                    case 4:
                        title1.setText("个人中心");

                        iv1.setImageResource(R.mipmap.sy1);
                        tv1.setTextColor(Color.parseColor("#ffffff"));
                        iv2.setImageResource(R.mipmap.gd1);
                        tv2.setTextColor(Color.parseColor("#ffffff"));
                        iv3.setImageResource(R.mipmap.dj1);
                        tv3.setTextColor(Color.parseColor("#ffffff"));
                        iv4.setImageResource(R.mipmap.xw1);
                        tv4.setTextColor(Color.parseColor("#ffffff"));
                        iv5.setImageResource(R.mipmap.gr2);
                        tv5.setTextColor(Color.parseColor("#827B7B"));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

    }


    //侧边栏实现
    public void CeB() {
        ivFh.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        mainNav.setNavigationItemSelectedListener(item -> {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.grzx:
//                    Toast.makeText(MainActivity2.this, "个人中心", Toast.LENGTH_SHORT).show();
                    viewpager.setAdapter(main2_adapter);
                    viewpager.setCurrentItem(5);
                    break;
                case R.id.qhzh:
                    intent = new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    SharedPreferences pref = getSharedPreferences("userInfo", MODE_PRIVATE);//将内容存放到userinfo的文档内
                    editor = pref.edit();
                    editor.remove("id");
                    editor.commit();
                    break;
                case R.id.fx:
                    intent = new Intent(MainActivity2.this, EWM.class);
                    startActivity(intent);
                    break;
                case R.id.xgzl:
                    intent = new Intent(MainActivity2.this, GRXX.class);
                    startActivity(intent);
                case R.id.tc:
                    finish();
                    break;
            }
            return true;
        });
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.iv_1:
                iv1.setImageResource(R.mipmap.sy2);
                tv1.setTextColor(Color.parseColor("#827B7B"));
                iv2.setImageResource(R.mipmap.gd1);
                tv2.setTextColor(Color.parseColor("#ffffff"));
                iv3.setImageResource(R.mipmap.dj1);
                tv3.setTextColor(Color.parseColor("#ffffff"));
                iv4.setImageResource(R.mipmap.xw1);
                tv4.setTextColor(Color.parseColor("#ffffff"));
                iv5.setImageResource(R.mipmap.gr1);
                tv5.setTextColor(Color.parseColor("#ffffff"));
                viewpager.setCurrentItem(0);
                break;
            case R.id.iv_2:
                iv1.setImageResource(R.mipmap.sy1);
                tv1.setTextColor(Color.parseColor("#ffffff"));
                iv2.setImageResource(R.mipmap.gd2);
                tv2.setTextColor(Color.parseColor("#827B7B"));
                iv3.setImageResource(R.mipmap.dj1);
                tv3.setTextColor(Color.parseColor("#ffffff"));
                iv4.setImageResource(R.mipmap.xw1);
                tv4.setTextColor(Color.parseColor("#ffffff"));
                iv5.setImageResource(R.mipmap.gr1);
                tv5.setTextColor(Color.parseColor("#ffffff"));
                viewpager.setCurrentItem(1);
                break;
            case R.id.iv_3:
                iv1.setImageResource(R.mipmap.sy1);
                tv1.setTextColor(Color.parseColor("#ffffff"));
                iv2.setImageResource(R.mipmap.gd1);
                tv2.setTextColor(Color.parseColor("#ffffff"));
                iv3.setImageResource(R.mipmap.dj);
                tv3.setTextColor(Color.parseColor("#827B7B"));
                iv4.setImageResource(R.mipmap.xw1);
                tv4.setTextColor(Color.parseColor("#ffffff"));
                iv5.setImageResource(R.mipmap.gr1);
                tv5.setTextColor(Color.parseColor("#ffffff"));
                viewpager.setCurrentItem(2);
                break;
            case R.id.iv_4:
                iv1.setImageResource(R.mipmap.sy1);
                tv1.setTextColor(Color.parseColor("#ffffff"));
                iv2.setImageResource(R.mipmap.gd1);
                tv2.setTextColor(Color.parseColor("#ffffff"));
                iv3.setImageResource(R.mipmap.dj1);
                tv3.setTextColor(Color.parseColor("#ffffff"));
                iv4.setImageResource(R.mipmap.xw2);
                tv4.setTextColor(Color.parseColor("#827B7B"));
                iv5.setImageResource(R.mipmap.gr1);
                tv5.setTextColor(Color.parseColor("#ffffff"));
                viewpager.setCurrentItem(3);
                break;
            case R.id.iv_5:
                iv1.setImageResource(R.mipmap.sy1);
                tv1.setTextColor(Color.parseColor("#ffffff"));
                iv2.setImageResource(R.mipmap.gd1);
                tv2.setTextColor(Color.parseColor("#ffffff"));
                iv3.setImageResource(R.mipmap.dj1);
                tv3.setTextColor(Color.parseColor("#ffffff"));
                iv4.setImageResource(R.mipmap.xw1);
                tv4.setTextColor(Color.parseColor("#ffffff"));
                iv5.setImageResource(R.mipmap.gr2);
                tv5.setTextColor(Color.parseColor("#827B7B"));
                viewpager.setCurrentItem(4);
                break;
        }
    }

    private void initView() {
        drawerLayout = findViewById(R.id.DrawerLayout);
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
        viewpager = findViewById(R.id.viewpager);
        iv1 = findViewById(R.id.iv_1);
        tv1 = findViewById(R.id.tv_1);
        iv2 = findViewById(R.id.iv_2);
        tv2 = findViewById(R.id.tv_2);
        iv3 = findViewById(R.id.iv_3);
        tv3 = findViewById(R.id.tv_3);
        iv4 = findViewById(R.id.iv_4);
        tv4 = findViewById(R.id.tv_4);
        iv5 = findViewById(R.id.iv_5);
        tv5 = findViewById(R.id.tv_5);
        mainNav = findViewById(R.id.mainNav);
        viewById = findViewById(R.id.head_UP);
    }
}