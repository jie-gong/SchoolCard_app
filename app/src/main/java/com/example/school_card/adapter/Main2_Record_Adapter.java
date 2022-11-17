package com.example.school_card.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.school_card.R;
import com.example.school_card.bean.Announce_bean;
import com.example.school_card.bean.Record_bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/17/下午 12:51
 */
public class Main2_Record_Adapter extends BaseAdapter {
    private ArrayList<Record_bean> beans;

    public Main2_Record_Adapter(ArrayList<Record_bean> beans) {
        this.beans = beans;
    }

    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public Object getItem(int i) {
        return beans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.announce_item, viewGroup, false);
            viewHolder.newsTitleGz = view.findViewById(R.id.news_title_gz);
            viewHolder.newsDateTime = view.findViewById(R.id.news_date_time);
            viewHolder.news_inflate_item = view.findViewById(R.id.news_inflate_item);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Record_bean bean = beans.get(i);
        if (bean.getCreateTime() == null) {
            viewHolder.newsTitleGz.setText(bean.getBalance());
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒");
            String format = sdf.format(bean.getCreateTime());
            viewHolder.newsDateTime.setText(format);
            viewHolder.newsTitleGz.setText("充值金额"+bean.getBalance());
        }
        return view;
    }

    class ViewHolder {
        private TextView newsTitleGz;
        private TextView newsDateTime;
        private LinearLayout news_inflate_item;

    }
}
