package com.example.school_card.m1_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.school_card.login.LoginDlActivity;
import com.example.school_card.R;
import com.example.school_card.login.UserLogin;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/10/19/下午 08:13
 */
public class fragment2 extends Fragment {
    private LinearLayout ivYd2;
    private Button user;
    private Button admin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_f2, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        ivYd2.setBackgroundResource(R.drawable.ch5);
        //学生登录
        user.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), LoginDlActivity.class);
            startActivity(intent);
            getActivity().finish();
        });
        //管理员登录
        admin.setOnClickListener(view1 -> {
            Toast.makeText(requireContext(), "教师登录暂未开放，敬请期待", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(requireContext(), UserLogin.class);
//            startActivity(intent);
//            getActivity().finish();
        });
    }

    private void initView() {
        ivYd2 = getView().findViewById(R.id.iv_yd2);
        user = getView().findViewById(R.id.user);
        admin = getView().findViewById(R.id.admin);
    }
}
