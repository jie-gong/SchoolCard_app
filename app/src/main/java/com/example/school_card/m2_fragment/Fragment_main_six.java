package com.example.school_card.m2_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.school_card.Okhttp.OkHttpLo;
import com.example.school_card.Okhttp.OkHttpTo;
import com.example.school_card.R;
import com.example.school_card.Repairs;
import com.example.school_card.m2.GRXX;
import com.example.school_card.m2.MainActivity2;
import com.example.school_card.util.SPUtil;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/15/下午 02:49
 */
public class Fragment_main_six extends Fragment {
    private Banner bannerThree;
    private LinearLayout jsgg;
    private LinearLayout wdxx;
    private LinearLayout wdxinxi;
    private LinearLayout xnxw;
    private LinearLayout xybx;
    private LinearLayout qd;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        getBanner();
        qd.setOnClickListener(v -> QDao());
        jsgg.setOnClickListener(v -> MainActivity2.setIndex0());
        wdxx.setOnClickListener(v -> MainActivity2.setIndex1());
        xybx.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), Repairs.class);
            startActivity(intent);
        });
        wdxinxi.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), GRXX.class);
            startActivity(intent);
        });
        xnxw.setOnClickListener(v -> MainActivity2.setIndex2());

    }

    public void QDao() {
        SPUtil spUtil = new SPUtil();
        String sp = spUtil.getSp(requireContext());
        new OkHttpTo()
                .setUrl("/card/SignIn")
                .setType("POST")
                .setJsonObject("studentid", sp)
                .setJsonObject("frequency", sp)
                .setOkHttpLo(jsonObject -> {
                    if (jsonObject.optString("code").equals("200")) {
                        Toast.makeText(requireContext(), "签到成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(requireContext(), "签到失败", Toast.LENGTH_SHORT).show();
                    }
                }).start();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_six, null);
    }

    private List<Integer> url;

    private void getBanner() {
        url = new ArrayList<>();
        url.add(R.drawable.a646);
        url.add(R.drawable.a622);
        url.add(R.drawable.a646);
        url.add(R.drawable.a622);
        url.add(R.drawable.a646);
        getActivity().runOnUiThread(() -> {
            bannerThree.setIndicator(new CircleIndicator(requireContext()));
            bannerThree.setAdapter(new BannerImageAdapter<Integer>(url) {
                @Override
                public void onBindView(BannerImageHolder holder, Integer integer, int i, int i1) {
                    Glide.with(holder.imageView).load(integer).into(holder.imageView);
                }
            });
        });

    }

    private void initView() {
        bannerThree = getView().findViewById(R.id.banner_three);
        jsgg = getView().findViewById(R.id.jsgg);
        wdxx = getView().findViewById(R.id.wdxx);
        wdxinxi = getView().findViewById(R.id.wdxinxi);
        xnxw = getView().findViewById(R.id.xnxw);
        xybx = getView().findViewById(R.id.xybx);
        qd = getView().findViewById(R.id.qd);
    }
}
