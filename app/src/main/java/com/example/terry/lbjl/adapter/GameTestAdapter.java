package com.example.terry.lbjl.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.terry.lbjl.R;
import com.example.terry.lbjl.bean.GameBegin;
import com.example.terry.lbjl.bean.GameTest;
import com.example.terry.lbjl.bean.Gift;
import com.example.terry.lbjl.constants.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Terry on 2016/10/1.
 */
public class GameTestAdapter extends BaseAdapter {

    List<GameTest.InfoBean> mInfoBeen;
    Context context;

    public GameTestAdapter(List<GameTest.InfoBean> infoBeen, Context context) {
        mInfoBeen = infoBeen;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mInfoBeen.size();
    }

    @Override
    public GameTest.InfoBean getItem(int position) {
        return mInfoBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_test_item, null);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(Constants.GIFT_MAIN + mInfoBeen.get(position).getIconurl()).
                config(Bitmap.Config.RGB_565).into(viewHolder.iv_icon);
        viewHolder.tv_title.setText(mInfoBeen.get(position).getGname());
        viewHolder.tv_addTime.setText(mInfoBeen.get(position).getAddtime());
        viewHolder.tv_com.setText(mInfoBeen.get(position).getOperators());
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.iv_game_test)
        ImageView iv_icon;
        @BindView(R.id.tv_test_title)
        TextView tv_title;
        @BindView(R.id.tv_test_com)
        TextView tv_com;
        @BindView(R.id.tv_test_addtime)
        TextView tv_addTime;
        @BindView(R.id.btn_test_check)
        Button btn_check;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
