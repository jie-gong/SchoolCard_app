package com.example.school_card.m2_fragment;

import android.os.Bundle;
import android.util.Log;
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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.school_card.Okhttp.HttpUtil;
import com.example.school_card.R;
import com.example.school_card.adapter.News;
import com.example.school_card.bean.News_List_Bean;
import com.example.school_card.dialog.Dialog_XingBie;
import com.example.school_card.m1.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Fragment_main_three extends Fragment {
    View view;
    private ImageView back;
    private Banner bannerThree;
    private LinearLayout yyyly;
    private LinearLayout hjxx;
    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private ListView ListViewThree;
    private LinearLayout jiaHao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_three, container, false);
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title1.setText("校内新闻");
        getBanner();
        ivFh.setOnClickListener(view1 -> {
            MainActivity.setIndex();
        });
        getList();
    }

    private ArrayList<News_List_Bean> beans;
    private News news;
    private void getList() {
        beans = new ArrayList<>();
        new HttpUtil()
                .sendResult("/prod-api/press/press/list", "", "GET", new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
//                        Log.d("SB", String.valueOf(beans.size()));
                        String s = response.body().string();
                        try {
                            beans = new Gson().fromJson(new JSONObject(s).optJSONArray("rows").toString(), new TypeToken<List<News_List_Bean>>() {
                            }.getType());
                            news = new News(beans);
                            Log.d("SB", String.valueOf(beans.size()));
                            getActivity().runOnUiThread(() -> {
                                ListViewThree.setAdapter(news);
                                ListAdapter listAdapter = ListViewThree.getAdapter();
                                if (listAdapter == null) {
                                    return;
                                }
                                int h = 0;
                                for (int i = 0; i < beans.size(); i++) {
                                    View view = listAdapter.getView(i, null, ListViewThree);
                                    view.measure(1, 1);
                                    h += view.getMeasuredHeight();
                                }
                                ViewGroup.LayoutParams params = ListViewThree.getLayoutParams();
                                params.height = h;
                                ListViewThree.setLayoutParams(params);
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
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
        bannerThree = view.findViewById(R.id.banner_three);
        yyyly = view.findViewById(R.id.yyyly);
        hjxx = view.findViewById(R.id.hjxx);
        ivFh = view.findViewById(R.id.iv_fh);
        title1 = view.findViewById(R.id.title1);
        tvGrzx = view.findViewById(R.id.tv_grzx);
        ListViewThree = view.findViewById(R.id.ListView_three);
        jiaHao = view.findViewById(R.id.jiaHao);
    }
}
