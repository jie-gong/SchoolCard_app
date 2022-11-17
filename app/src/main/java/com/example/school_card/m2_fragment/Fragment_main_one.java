package com.example.school_card.m2_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.school_card.Okhttp.OkHttpTo;
import com.example.school_card.QDJL;
import com.example.school_card.R;
import com.example.school_card.Repairs;
import com.example.school_card.adapter.Main2_Announce_Adapter;
import com.example.school_card.bean.Announce_bean;
import com.example.school_card.m2.MainActivity2;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/10/下午 05:19
 */
public class Fragment_main_one extends Fragment {
    View view;
    private ImageView back;
    private Banner bannerThree;
    private LinearLayout xnxw;
    private LinearLayout hjxx;
    private LinearLayout ylyjg;
    private LinearLayout jzjc;
    private ImageView ivFh;
    private TextView tvGrzx;
    private LinearLayout new1;
    private ListView listView;
    private ListView listViewThree;
    private LinearLayout xybx;
    private LinearLayout qdjl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_one, container, false);
        initView();
        getList();
        xnxw.setOnClickListener(v -> {
            MainActivity2.setIndex2();
        });
        xybx.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), Repairs.class);
            startActivity(intent);
        });
        qdjl.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), QDJL.class);
            startActivity(intent);
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBanner();
    }

    private ArrayList<Announce_bean> beans = new ArrayList<>();
    private Main2_Announce_Adapter adapter;

    private void getList() {
        new OkHttpTo()
                .setType("GET")
                .setUrl("/card/allgg")
                .setOkHttpLo(jsonObject -> {
                    beans = new Gson().fromJson(jsonObject.optJSONArray("data").toString(),
                            new TypeToken<List<Announce_bean>>() {
                            }.getType());
                    adapter = new Main2_Announce_Adapter(beans);
                    getActivity().runOnUiThread(() -> {
                        listView.setAdapter(adapter);
                        ListAdapter listAdapter = listView.getAdapter();
                        if (listAdapter == null) {
                            return;
                        }
                        int h = 0;
                        for (int i = 0; i < beans.size(); i++) {
                            View view = listAdapter.getView(i, null, listView);
                            view.measure(1, 1);
                            h += view.getMeasuredHeight();
                        }
                        ViewGroup.LayoutParams params = listView.getLayoutParams();
                        params.height = h + listView.getDividerHeight() * (listAdapter.getCount() - 1);
                        listView.setLayoutParams(params);
                    });
                }).start();
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
                    Glide.with(holder.imageView)
                            .load(integer)
                            .into(holder.imageView);
                }
            });
        });

    }

    private void initView() {
        bannerThree = view.findViewById(R.id.banner_three);
        xnxw = view.findViewById(R.id.xnxw);
        xybx = view.findViewById(R.id.xybx);
        tvGrzx = view.findViewById(R.id.tv_grzx);
        listView = view.findViewById(R.id.listView_three);
        xybx = view.findViewById(R.id.xybx);
        qdjl = view.findViewById(R.id.qdjl);
    }
}
