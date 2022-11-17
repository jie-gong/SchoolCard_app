package com.example.school_card.m1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.school_card.R;
import com.example.school_card.adapter.Main1_Adapter;
import com.example.school_card.m1_fragment.fragment1;
import com.example.school_card.m1_fragment.fragment2;
import com.example.school_card.m2_fragment.Fragment_main_three;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ViewPager2 vpStart;
    private LinearLayout linear;

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ImageView imageView;
    private int index=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragment();
    }

    public static void setIndex() {
        vpStart.setCurrentItem(0);
    }

    public void fragment() {
//        fragments.add(new fragment1(1));
//        fragments.add(new fragment1(1));
//        fragments.add(new fragment1(2));
//        fragments.add(new fragment1(3));
        fragments.add(new fragment2());
        fragments.add(new Fragment_main_three());
        Main1_Adapter main1_adapter = new Main1_Adapter(getSupportFragmentManager(), getLifecycle(), fragments);
        vpStart.setAdapter(main1_adapter);
        vpStart.setCurrentItem(0);
//        for (int i = 0; i <= 3; i++) {
//            imageView = new ImageView(this);
//            if (i != fragments.size()) {
//                imageView.setImageResource(R.drawable.lb2);
//            } else {
//                imageView.setImageResource(R.drawable.lb1);
//            }
//            imageView.setLayoutParams(new ViewGroup.LayoutParams(70, 70));
//            linear.addView(imageView);
//        }
        vpStart.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

//                for (int i = 0; i <= 3; i++) {
//                    if (position == 4) {
//                        imageView.setVisibility(View.INVISIBLE);
//                    } else {
//                        imageView.setVisibility(View.VISIBLE);
//                        if (i == position) {
//                            imageView.setImageResource(R.drawable.lb2);
//                        } else {
//                            imageView.setImageResource(R.drawable.lb1);
//                        }
//                    }
//                    imageView = (ImageView) linear.getChildAt(i);
//                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void initView() {
        vpStart = findViewById(R.id.vp_start);
        linear = findViewById(R.id.linear);
    }
}