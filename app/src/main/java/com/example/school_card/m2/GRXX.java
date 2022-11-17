package com.example.school_card.m2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.school_card.Okhttp.OkHttpTo;
import com.example.school_card.R;
import com.example.school_card.dialog.Dialog;
import com.example.school_card.util.SPUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class GRXX extends AppCompatActivity {

    private LinearLayout line;
    private TextView xuehao;
    private LinearLayout line1;
    private TextView xingbie;
    private TextView zhuangtai;
    private TextView idCard;
    private TextView number;
    private SharedPreferences.Editor editor;
    private Integer sex = 0;
    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grxx);
        initView();
        OkHttp();
        title1.setText("个人信息");
        ivFh.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
            finish();
        });
        xingbie.setOnClickListener(view -> {
            Toast.makeText(this, "长按修改性别", Toast.LENGTH_SHORT).show();
        });
        number.setOnClickListener(view -> {
            Toast.makeText(this, "长按修改手机号", Toast.LENGTH_SHORT).show();
        });
        xingbie.setOnLongClickListener(view -> {
            View view1 = View.inflate(this, R.layout.xinbgiedialog, null);
            AlertDialog show = new AlertDialog.Builder(this).setView(view1).show();
            Button click = view1.findViewById(R.id.click);
            Spinner spinner = view1.findViewById(R.id.xb);
            click.setOnClickListener(view2 -> {
                if (spinner.getSelectedItem().equals("男")) {
                    sex = 1;
                } else if (spinner.getSelectedItem().equals("女")) {
                    sex = 0;
                }
                SPUtil spUtil = new SPUtil();
                String id = spUtil.getSp(GRXX.this);
                new OkHttpTo()
                        .setUrl("/card/update")
                        .setType("POST")
                        .setJsonObject("studentid", id)
                        .setJsonObject("sex", sex)
                        .setOkHttpLo(jsonObject -> {
                            if (jsonObject.optString("code").equals("200")) {
                                Toast.makeText(GRXX.this, "修改成功", Toast.LENGTH_SHORT).show();
                                OkHttp();
                                show.dismiss();
                            } else {
                                Toast.makeText(GRXX.this, "修改失败", Toast.LENGTH_SHORT).show();
                            }
                        }).start();
            });
            return true;
        });
    }

    public void dialog() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Dialog dialog = new Dialog();
        transaction.add(dialog, "dialog-tag");
        transaction.show(dialog);
        transaction.commit();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        OkHttp();
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Toast.makeText(this, "点击左上角退出", Toast.LENGTH_SHORT).show();
        return false;
    }

    private void OkHttp() {
        SharedPreferences pref = getSharedPreferences("userInfo", MODE_PRIVATE);//将内容存放到userinfo的文档内
        editor = pref.edit();
        String zhang = pref.getString("id", "");//获取账号
        try {
            new OkHttpTo().setUrl("/card/student")
                    .setType("POST")
                    .setJsonObject("studentid", zhang)
                    .setOkHttpLo(jsonObject -> {
                        try {
                            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                            //状态
                            zhuangtai.setText("正常");
                            //学号
                            String studentid = jsonObject1.getString("studentid");
                            xuehao.setText(studentid);
                            //性别
                            String name = jsonObject1.getString("sex");
                            if (name.equals("1")) {
                                xingbie.setText("男");
                            } else {
                                xingbie.setText("女");
                            }
                            //电话
                            String phone = jsonObject1.getString("phone");
                            number.setText(phone);
                            //身份证号
                            String idcard = jsonObject1.getString("idcard");
                            idCard.setText(idcard);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }).start();

        } catch (Exception e) {
            e.printStackTrace();
            dialog();
        }

    }

    private void initView() {
        line = findViewById(R.id.line);
        xuehao = findViewById(R.id.xuehao);
        line1 = findViewById(R.id.line1);
        xingbie = findViewById(R.id.xingbie);
        zhuangtai = findViewById(R.id.zhuangtai);
        idCard = findViewById(R.id.id_card);
        number = findViewById(R.id.number);
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
    }
}