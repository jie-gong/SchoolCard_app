package com.example.school_card.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.school_card.Okhttp.OkHttpTo;
import com.example.school_card.R;
import com.example.school_card.util.SPUtil;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/15/上午 11:28
 */
public class Dialog_XiaoXi extends DialogFragment {
    private EditText edit;
    private Button click;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        click.setOnClickListener(view -> {
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
                            dismiss();
                        }
                    }).start();
        });
    }

    public void getAnn() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.xiaoxidialog, null);
    }

    private void initView() {
        edit = getView().findViewById(R.id.edit);
        click = getView().findViewById(R.id.click);
    }
}
