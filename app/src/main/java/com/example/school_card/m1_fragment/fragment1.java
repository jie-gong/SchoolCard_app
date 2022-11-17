package com.example.school_card.m1_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.school_card.R;


public class fragment1 extends Fragment {
    int position;
    private LinearLayout ivYd;
    private LinearLayout liner;

    public fragment1(int position) {
        this.position = position;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        switch (position) {
            case 0:
                ivYd.setBackgroundResource(R.drawable.ch5);
                break;
            case 1:
                ivYd.setBackgroundResource(R.drawable.ch2);
                break;
            case 2:
                ivYd.setBackgroundResource(R.drawable.ch3);
                break;
            case 3:
                ivYd.setBackgroundResource(R.drawable.ch4);
                break;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mian_f1, null);
    }

    private void initView() {
        ivYd = getView().findViewById(R.id.iv_yd);
        liner = getView().findViewById(R.id.liner);
    }
}
