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
public class FeatureNewAdapter extends BaseAdapter {

    List<FeatureNew.ListBean> mNewList;
    Context mContext;

    public FeatureNewAdapter(List<FeatureNew.ListBean> newList, Context context) {
        mNewList = newList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mNewList.size();
    }

    @Override
    public FeatureNew.ListBean getItem(int position) {
        return mNewList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.feature_new_item, null);
            mViewHolder = new ViewHolder(convertView);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(mContext).load(Constants.GIFT_MAIN + mNewList.get(position).getIconurl())
                .config(Bitmap.Config.RGB_565).into(mViewHolder.iv_new);
        Picasso.with(mContext).load(Constants.GIFT_MAIN + mNewList.get(position).getAuthorimg())
                .config(Bitmap.Config.RGB_565).into(mViewHolder.iv_author);
        mViewHolder.tv_new.setText(mNewList.get(position).getName());
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.iv_feature_new)
        ImageView iv_new;
        @BindView(R.id.tv_feature_new)
        TextView tv_new;
        @BindView(R.id.iv_feature_author)
        ImageView iv_author;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
