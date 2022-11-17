package com.example.school_card.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.school_card.R;
import com.example.school_card.bean.Announce_bean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/14/下午 03:31
 */
public class Main2_Announce_Adapter extends BaseAdapter {
    private List<Announce_bean> announce_beans;

    public Main2_Announce_Adapter(List<Announce_bean> announce_beans) {
        this.announce_beans = announce_beans;
    }

    @Override
    public int getCount() {
        return announce_beans.size();
    }

    @Override
    public Object getItem(int i) {
        return announce_beans.get(i);
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
        Announce_bean bean = announce_beans.get(i);
        if (bean.getCreateTime() == null) {
            viewHolder.newsTitleGz.setText(bean.getGz());
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒");
            String format = sdf.format(bean.getCreateTime());
            if (bean.getState() == 1) {
                viewHolder.news_inflate_item.setBackgroundResource(R.drawable.newsba);
            }
            viewHolder.newsDateTime.setText(format);
            viewHolder.newsTitleGz.setText(bean.getGz());
        }
        return view;
    }

    class ViewHolder {
        private TextView newsTitleGz;
        private TextView newsDateTime;
        private LinearLayout news_inflate_item;
    }
}
