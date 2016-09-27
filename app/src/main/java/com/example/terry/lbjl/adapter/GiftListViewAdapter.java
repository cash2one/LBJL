package com.example.terry.lbjl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.terry.lbjl.R;
import com.example.terry.lbjl.bean.GiftBean;
import com.example.terry.lbjl.constants.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Terry on 2016/9/26.
 */
public class GiftListViewAdapter extends BaseAdapter {

    List<GiftBean.ListBean> listBeen;
    Context context;

    @Override
    public int getCount() {
        return listBeen.size();
    }

    @Override
    public GiftBean.ListBean getItem(int position) {
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
        GiftBean.ListBean bean = listBeen.get(position);
        Picasso.with(context).load(Constants.GIFT_MAIN + bean.getIconurl()).into(viewHolder.mIconIv);
//        viewHolder.mIconIv.setImageResource(listBeen.get(position).getIconurl());
        viewHolder.mGNameTv.setText(bean.getGname());
        viewHolder.mGiftNameTv.setText(bean.getGiftname());
        viewHolder.mNumberTv.setText(bean.getNumber());
        viewHolder.mAddTimeTv.setText(bean.getAddtime());
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

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
