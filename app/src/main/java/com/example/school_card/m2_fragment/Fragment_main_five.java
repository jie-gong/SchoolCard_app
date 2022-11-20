package com.example.school_card.m2_fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.school_card.m1.MainActivity;
import com.example.school_card.Okhttp.HttpUtil;
import com.example.school_card.Okhttp.OkHttpTo;
import com.example.school_card.R;
import com.example.school_card.bean.Banner_Bean;
import com.example.school_card.m2.GRXX;
import com.example.school_card.m2.GetCard;
import com.example.school_card.m2.XGMM;
import com.example.school_card.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/13/下午 08:08
 */
public class Fragment_main_five extends Fragment {
    private TextView tvGrzx;
    private ImageView image;
    private TextView zh;
    private TextView grxx;
    private TextView xgmm;
    private TextView ddlb;
    private TextView yjfk;
    private SharedPreferences.Editor editor;
    private Button TuiChu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.e, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        OkHttp();
        TuiChu.setOnClickListener(view1 -> {
            SharedPreferences pref = getActivity().getSharedPreferences("userInfo", MODE_PRIVATE);//将内容存放到userinfo的文档内
            editor = pref.edit();
            editor.remove("id");
            editor.commit();
            Intent intent = new Intent(requireContext(), MainActivity.class);
            startActivity(intent);
            getActivity().finish();
        });
        grxx.setOnClickListener(view1 -> {
            Intent intent = new Intent(requireContext(), GRXX.class);
            startActivity(intent);
        });
        xgmm.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), XGMM.class);
            startActivity(intent);
        });
        zh.setOnClickListener(v -> {
            Toast.makeText(requireContext(), "昵称不支持修改，请联系管理员", Toast.LENGTH_SHORT).show();
        });
        ddlb.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), GetCard.class);
            startActivity(intent);
        });
        getInformation();
    }

    List<Banner_Bean> beans = new ArrayList<>();

    private void getInformation() {

        new HttpUtil().sendResult("/prod-api/api/rotation/list", "", "GET", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                try {
                    beans = new Gson().fromJson(new JSONObject(s).optJSONArray("rows").toString(), new TypeToken<List<Banner_Bean>>() {
                    }.getType());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void OkHttp() {
        SPUtil spUtil = new SPUtil();
        String sp = spUtil.getSp(requireContext());
        new OkHttpTo()
                .setType("POST")
                .setUrl("/card/student")
                .setJsonObject("studentid", sp)
                .setOkHttpLo(jsonObject -> {
                    if (jsonObject.optString("code").equals("200")) {
                        try {
                            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                            String name = jsonObject1.getString("name");
                            zh.setText(name);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("TAG", "没有数据");
                        }
                    } else {
                        Toast.makeText(requireContext(), "网络连接失败或账号异常,强制退出", Toast.LENGTH_SHORT).show();
                        SharedPreferences pref = getActivity().getSharedPreferences("userInfo", MODE_PRIVATE);//将内容存放到userinfo的文档内
                        editor = pref.edit();
                        editor.remove("id");
                        editor.commit();
                        requireActivity().finish();
                    }
                }).start();
    }

    private void initView() {
        tvGrzx = getView().findViewById(R.id.tv_grzx);
        image = getView().findViewById(R.id.image);
        zh = getView().findViewById(R.id.zh);
        grxx = getView().findViewById(R.id.grxx);
        xgmm = getView().findViewById(R.id.xgmm);
        ddlb = getView().findViewById(R.id.ddlb);
        yjfk = getView().findViewById(R.id.yjfk);
        TuiChu = getView().findViewById(R.id.TuiChu);
    }
}
