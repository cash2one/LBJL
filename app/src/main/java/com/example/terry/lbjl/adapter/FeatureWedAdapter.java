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
import com.example.terry.lbjl.bean.FeatureNew;
import com.example.terry.lbjl.bean.FeatureWed;
import com.example.terry.lbjl.constants.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Terry on 2016/10/11.
 */
public class FeatureWedAdapter extends BaseAdapter {

    List<FeatureWed.ListBean> mWedList;
    Context mContext;

    public FeatureWedAdapter(List<FeatureWed.ListBean> wedList, Context context) {
        mWedList = wedList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mWedList.size();
    }

    @Override
    public FeatureWed.ListBean getItem(int position) {
        return mWedList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.feature_wed_item, null);
            mViewHolder = new ViewHolder(convertView);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(mContext).load(Constants.GIFT_MAIN + mWedList.get(position).getIconurl())
                .config(Bitmap.Config.RGB_565).into(mViewHolder.mImageView);
        mViewHolder.tv_name.setText(mWedList.get(position).getName());
        mViewHolder.tv_addTime.setText(mWedList.get(position).getAddtime());
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.iv_feature_wed)
        ImageView mImageView;
        @BindView(R.id.tv_feature_name)
        TextView tv_name;
        @BindView(R.id.tv_feature_addtime)
        TextView tv_addTime;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
