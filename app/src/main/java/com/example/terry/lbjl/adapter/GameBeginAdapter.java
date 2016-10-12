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
import com.example.terry.lbjl.bean.GameBegin;
import com.example.terry.lbjl.constants.Constants;
import com.squareup.picasso.Picasso;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Terry on 2016/10/1.
 */
public class GameBeginAdapter extends BaseAdapter {

    public static final int DATE_TYPE = 0;
    public static final int VIEW_TYPE = 1;
    private List<GameBegin.InfoBean> mInfoBeen;
    private Context context;
    private Set<String> setType;
    private String currentDateType = "";

    public GameBeginAdapter(List<GameBegin.InfoBean> infoBeen, Context context) {
        mInfoBeen = infoBeen;
        this.context = context;
        setType = new HashSet<>();
        for (GameBegin.InfoBean mInfoBean : mInfoBeen) {
            setType.add(mInfoBean.getAddtime());
        }
    }

    @Override
    public int getCount() {
        return mInfoBeen.size() + setType.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        GameBegin.InfoBean gameBegin = mInfoBeen.get(position);
        String getDateType = gameBegin.getAddtime();
        if (!currentDateType.equals(getDateType)) {
            currentDateType = getDateType;
            return DATE_TYPE;
        }
        return VIEW_TYPE;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        ViewHolder viewHolder = null;
        DateViewHolder dateViewHolder = null;
        if (convertView == null) {
            switch (type) {
                case DATE_TYPE:
                    convertView = LayoutInflater.from(context).inflate(R.layout.game_begin_item01, null);
                    dateViewHolder = new DateViewHolder(convertView);
                    break;
                case VIEW_TYPE:
                    convertView = LayoutInflater.from(context).inflate(R.layout.game_begin_item02, null);
                    viewHolder = new ViewHolder(convertView);
                    break;
            }
        }
        switch (type) {
            case DATE_TYPE:
                dateViewHolder.tv_addTime.setText(currentDateType);
                break;
            case VIEW_TYPE:
                Picasso.with(context).load(Constants.GIFT_MAIN + mInfoBeen.get(position).getIconurl()).
                        config(Bitmap.Config.RGB_565).into(viewHolder.iv_icon);
                viewHolder.tv_gName.setText(mInfoBeen.get(position).getGname());
                viewHolder.tv_linkUrl.setText(mInfoBeen.get(position).getLinkurl());
                viewHolder.tv_area.setText(mInfoBeen.get(position).getArea());
                viewHolder.tv_operators.setText(mInfoBeen.get(position).getOperators());
                break;
        }
        return convertView;
    }

    class ViewHolder {

        @BindView(R.id.iv_begin_icon)
        ImageView iv_icon;
        @BindView(R.id.tv_begin_gname)
        TextView tv_gName;
        @BindView(R.id.tv_begin_linkurl)
        TextView tv_linkUrl;
        @BindView(R.id.tv_begin_area)
        TextView tv_area;
        @BindView(R.id.tv_begin_operators)
        TextView tv_operators;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(view);
        }
    }

    class DateViewHolder {
        @BindView(R.id.tv_begin_addtime)
        TextView tv_addTime;

        public DateViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(view);
        }
    }
}
