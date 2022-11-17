package com.example.school_card.adapter;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.school_card.App.App;

import java.util.ArrayList;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/10/19/下午 04:22
 */
public class Main1_Adapter extends FragmentStateAdapter {

    private ArrayList<Fragment> fragments;

    public Main1_Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<Fragment> fragments) {
        super(fragmentManager, lifecycle);
        this.fragments = fragments;

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
