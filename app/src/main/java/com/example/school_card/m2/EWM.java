package com.example.school_card.m2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.school_card.R;
import com.example.school_card.SCerweima.CodeCreator;

public class EWM extends AppCompatActivity {

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ewm);
        initView();
        Bitmap bitmap ;
        Bitmap logo = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        bitmap = CodeCreator.createQRCode("测试功能——后续开放", 400, 400, logo);
        image.setImageBitmap(bitmap);
    }

    private void initView() {
        image = findViewById(R.id.image);
    }
}