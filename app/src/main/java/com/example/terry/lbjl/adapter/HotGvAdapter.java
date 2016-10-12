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
 * Created by Terry on 2016/10/11.
 */
public class HotGvAdapter extends BaseAdapter {
    List<Hot.InfoBean.Push2Bean> mPush2Been;
    Context mContext;

    public HotGvAdapter(List<Hot.InfoBean.Push2Bean> push2Been, Context context) {
        mPush2Been = push2Been;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mPush2Been.size();
    }

    @Override
    public Hot.InfoBean.Push2Bean getItem(int position) {
        return mPush2Been.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gv_hot_push2, null);
            mViewHolder = new ViewHolder(convertView);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(mContext).load(Constants.GIFT_MAIN + mPush2Been.get(position).getLogo()).
                config(Bitmap.Config.RGB_565)
                .into(mViewHolder.mImageView);
        mViewHolder.mTextView.setText(mPush2Been.get(position).getName());
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.iv_hot_logo2)
        ImageView mImageView;
        @BindView(R.id.tv_hot_name2)
        TextView mTextView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
