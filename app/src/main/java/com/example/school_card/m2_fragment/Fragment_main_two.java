package com.example.school_card.m2_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.school_card.Okhttp.OkHttpTo;
import com.example.school_card.R;
import com.example.school_card.adapter.Main2_Announce_Adapter;
import com.example.school_card.bean.Announce_bean;
import com.example.school_card.util.SPUtil;
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
public class Fragment_main_two extends Fragment {
    View view;
    private ImageView back;
    private Banner bannerThree;
    private LinearLayout yyyly;
    private LinearLayout hjxx;
    private LinearLayout ylyjg;
    private LinearLayout jzjc;
    private ImageView ivFh;
    private TextView tvGrzx;
    private LinearLayout new1;
    private ListView listView;
    private TextView shuaxin;
    private LinearLayout jiaHao;
    private int number = 10;
    private TextView qingchu;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_two, container, false);
        initView();
        getList();
        getAnn();
        shuaxin.setOnClickListener(view -> {
            getList();
//            number = 10;
        });
        qingchu.setOnClickListener(v -> {
            listView.setAdapter(null);
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBanner();
    }


    private void getAnn() {
        jiaHao.setOnClickListener(view1 -> {
            View view = View.inflate(requireContext(), R.layout.xiaoxidialog, null);
            AlertDialog show = new AlertDialog.Builder(requireContext()).setView(view).show();
            Button click = view.findViewById(R.id.clicked);
            EditText edit = view.findViewById(R.id.edit);
            click.setOnClickListener(view2 -> {
                SPUtil spUtil = new SPUtil();
                String sp1 = spUtil.getSp(requireContext());
                String trim = edit.getText().toString().trim();
                new OkHttpTo()
                        .setType("POST")
                        .setUrl("/card/getAnn")
                        .setJsonObject("studentid", sp1)
                        .setJsonObject("state", 1)
                        .setJsonObject("gz", trim)
                        .setOkHttpLo(jsonObject -> {
                            if (jsonObject.optString("code").equals("200")) {
                                getList();
                                show.dismiss();
                            }
                        }).start();
            });

        });
    }

    private ArrayList<Announce_bean> beans = new ArrayList<>();
    private Main2_Announce_Adapter adapter;

    private void getList() {
        SPUtil spUtil = new SPUtil();
        String sp1 = spUtil.getSp(requireContext());
        new OkHttpTo()
                .setType("POST")
                .setUrl("/card/getNews")
                .setJsonObject("studentid", sp1)
                .setOkHttpLo(jsonObject -> {
                    if (sp1.equals("")){
                        Toast.makeText(requireContext(), "账号异常，请重新登录", Toast.LENGTH_SHORT).show();
                    }
                    if (jsonObject.optString("code").equals("200")) {
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
                    } else {
                        ArrayList<Announce_bean> announce_beans = new ArrayList<>();
                        Announce_bean bean = new Announce_bean();
                        bean.setGz("当前暂无消息");
                        bean.setState(1);
                        announce_beans.add(bean);
                        adapter = new Main2_Announce_Adapter(announce_beans);
                        listView.setAdapter(adapter);
                    }
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
        yyyly = view.findViewById(R.id.yyyly);
        hjxx = view.findViewById(R.id.hjxx);
        tvGrzx = view.findViewById(R.id.tv_grzx);
        listView = view.findViewById(R.id.listView_two);
        shuaxin = view.findViewById(R.id.shuaxin);
        jiaHao = view.findViewById(R.id.jiaHao);
        qingchu = view.findViewById(R.id.qingchu);
    }


}
