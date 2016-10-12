package com.example.terry.lbjl.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.terry.lbjl.R;
import com.example.terry.lbjl.bean.Hot;
import com.example.terry.lbjl.constants.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Terry on 2016/10/8.
 */
public class HotLvAdapter extends BaseAdapter {

    List<Hot.InfoBean.Push1Bean> mPush1Been;
    Context context;

    public HotLvAdapter(List<Hot.InfoBean.Push1Bean> push1Been, Context context) {
        mPush1Been = push1Been;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mPush1Been.size();
    }

    @Override
    public Hot.InfoBean.Push1Bean getItem(int position) {
        return mPush1Been.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_hot_push1, null);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Hot.InfoBean.Push1Bean push1Bean = mPush1Been.get(position);
        Picasso.with(context).load(Constants.GIFT_MAIN + push1Bean.getLogo()).
                config(Bitmap.Config.RGB_565).into(viewHolder.iv_logo);
        viewHolder.tv_name.setText(push1Bean.getName());
        viewHolder.tv_typename.setText(push1Bean.getTypename());
        viewHolder.tv_size.setText(push1Bean.getSize());
        viewHolder.tv_clicks.setText(String.valueOf(push1Bean.getClicks()));
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.iv_hot_logo)
        ImageView iv_logo;
        @BindView(R.id.tv_hot_name)
        TextView tv_name;
        @BindView(R.id.tv_hot_typename)
        TextView tv_typename;
        @BindView(R.id.tv_hot_clicks)
        TextView tv_clicks;
        @BindView(R.id.tv_hot_size)
        TextView tv_size;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
