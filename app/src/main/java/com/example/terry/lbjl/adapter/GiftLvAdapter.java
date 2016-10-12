package com.example.terry.lbjl.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.terry.lbjl.R;
import com.example.terry.lbjl.bean.Gift;
import com.example.terry.lbjl.constants.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Terry on 2016/9/26.
 */
public class GiftLvAdapter extends BaseAdapter {

    List<Gift.ListBean> listBeen;
    Context context;

    public GiftLvAdapter(List<Gift.ListBean> listBeen, Context context) {
        this.listBeen = listBeen;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listBeen.size();
    }

    @Override
    public Gift.ListBean getItem(int position) {
        return listBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_gift_item, null);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Gift.ListBean bean = listBeen.get(position);
        Picasso.with(context).load(Constants.GIFT_MAIN + bean.getIconurl()).
                config(Bitmap.Config.RGB_565).into(viewHolder.mIconIv);
        viewHolder.mGNameTv.setText(bean.getGname());
        viewHolder.mGiftNameTv.setText(bean.getGiftname());
        int num = bean.getNumber();
        viewHolder.mNumberTv.setText(String.valueOf(num));
        viewHolder.mAddTimeTv.setText(bean.getAddtime());
        if (num == 0) {
            viewHolder.mGetBtn.setText("淘号");
        } else {
            viewHolder.mGetBtn.setText("立即领取");
        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.iv_icon)
        ImageView mIconIv;
        @BindView(R.id.tv_gname)
        TextView mGNameTv;
        @BindView(R.id.tv_giftname)
        TextView mGiftNameTv;
        @BindView(R.id.tv_number)
        TextView mNumberTv;
        @BindView(R.id.tv_addtime)
        TextView mAddTimeTv;
        @BindView(R.id.btn_get)
        Button mGetBtn;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
