package com.example.school_card.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.school_card.R;
import com.example.school_card.bean.Announce_bean;
import com.example.school_card.bean.QDJL_bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/16/下午 03:50
 */
public class Main2_Adapter_QD extends BaseAdapter {
    private List<QDJL_bean> beans;

    public Main2_Adapter_QD(List<QDJL_bean> beans) {
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.qdjl, viewGroup, false);
            viewHolder.newsTitleItem = view.findViewById(R.id.news_title_item);
            viewHolder.newsDateItem = view.findViewById(R.id.news_date_item);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        QDJL_bean bean = beans.get(i);
        if (bean.getCreateTime() == null) {
            viewHolder.newsTitleItem.setText(bean.getFrequency());
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH点MM分ss秒");
            String format = sdf.format(bean.getCreateTime());
            viewHolder.newsDateItem.setText(format);
            viewHolder.newsTitleItem.setText(bean.getFrequency());
        }
        return view;
    }


    class ViewHolder {
        private TextView newsTitleItem;
        private TextView newsDateItem;
    }
}
