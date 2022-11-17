package com.example.school_card.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.school_card.R;
import com.example.school_card.m2.MainActivity2;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/14/上午 08:58
 */
public class Dialog extends DialogFragment {
    private TextView idTxtYourName;
    private Button ok;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog, null);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        ok.setOnClickListener(view -> {
            Intent intent = new Intent(requireContext(), MainActivity2.class);
            startActivity(intent);
        });
    }

    private void initView() {
        idTxtYourName = getView().findViewById(R.id.id_txt_your_name);
        ok = getView().findViewById(R.id.ok);
    }
}
