package com.example.school_card.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.school_card.R;
import com.example.school_card.bean.News_List_Bean;
import com.example.school_card.m2.Main2_NewsXQ;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL;

/**
 * @user 公杰
 * @方法描述 。。。。
 * @Date 2022/11/14/上午 10:12
 */
public class News extends BaseAdapter {


    private List<News_List_Bean> beans;

    public News(List<News_List_Bean> beans) {
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

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, parent, false);
            viewHolder.iv = convertView.findViewById(R.id.news_iv_item);
            viewHolder.title = convertView.findViewById(R.id.news_title_item);
            viewHolder.content = convertView.findViewById(R.id.news_content_item);
            viewHolder.number = convertView.findViewById(R.id.news_number_item);
            viewHolder.date = convertView.findViewById(R.id.news_date_item);
            viewHolder.inflate = convertView.findViewById(R.id.news_inflate_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        News_List_Bean bean = beans.get(position);
        Glide.with(parent.getContext()).load("http://124.93.196.45:10001" + bean.getCover()).into(viewHolder.iv);
        viewHolder.title.setText(bean.getTitle());
        viewHolder.content.setText(Html.fromHtml(bean.getContent()));
        viewHolder.date.setText(bean.getPublishDate());
        Integer commentNum = bean.getCommentNum();
        if (commentNum == null) {
            viewHolder.number.setText("评论数: 0");
        } else {
            viewHolder.number.setText("评论数： " + commentNum);
        }
        viewHolder.inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(parent.getContext(), Main2_NewsXQ.class);
                intent.putExtra("news", beans.get(position));
                parent.getContext().startActivity(intent);
            }
        });

        return convertView;
    }

    class ViewHolder {
        private ImageView iv;
        private TextView title;
        private TextView content;
        private TextView number;
        private TextView date;
        private LinearLayout inflate;
    }
}
