package com.example.school_card.dialog;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.school_card.R;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/14/上午 11:28
 */
public class Dialog_XingBie extends DialogFragment {
    private Spinner xb;
    private int sex;
    private Button click;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.xinbgiedialog, null);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
//        click.setOnClickListener(view -> {
//            if (xb.getSelectedItem().equals("男")) {
//                sex = 1;
//            } else if (xb.getSelectedItem().equals("女")) {
//                sex = 0;
//            }
//            SP sp = new SP();
//            String id = sp.getSp(requireContext());
//            new OkHttpTo()
//                    .setUrl("/card/update")
//                    .setType("POST")
//                    .setJsonObject("studentid", id)
//                    .setJsonObject("sex", sex)
//                    .setOkHttpLo(jsonObject -> {
//                        if (jsonObject.optString("code").equals("200")) {
//                            Toast.makeText(requireContext(), "修改成功", Toast.LENGTH_SHORT).show();
//                            dismiss();
//                        } else {
//                            Toast.makeText(requireContext(), "修改失败", Toast.LENGTH_SHORT).show();
//                        }
//                    }).start();
//        });

    }


    private void initView() {
        xb = getView().findViewById(R.id.xb);
        click = getView().findViewById(R.id.click);
    }
}
