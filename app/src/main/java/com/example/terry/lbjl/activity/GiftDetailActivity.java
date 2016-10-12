package com.example.terry.lbjl.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.terry.lbjl.R;
import com.example.terry.lbjl.bean.GiftDetail;
import com.example.terry.lbjl.callback.DataCallBack;
import com.example.terry.lbjl.constants.Constants;
import com.example.terry.lbjl.http.HttpUtils;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GiftDetailActivity extends AppCompatActivity implements DataCallBack {

    @BindView(R.id.imageView2)
    ImageView mImageView;
    @BindView(R.id.tv_gift_detail_title)
    TextView tv_title;
    @BindView(R.id.iv_gift_detail_iconurl)
    ImageView iv_icon;
    @BindView(R.id.tv_gift_detail_overtime)
    TextView tv_overtime;
    @BindView(R.id.tv_gift_detail_number)
    TextView tv_number;
    @BindView(R.id.tv_gift_detail_explains)
    TextView tv_explains;
    @BindView(R.id.tv_gift_detail_way)
    TextView tv_getWay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift_detail);
        ButterKnife.bind(this);
        String id = getIntent().getStringExtra("id");
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.getDataFromNetWork(String.format(Constants.GIFT_DETAIL + id),this);
    }

    @Override
    public void setDataCallBack(String data) {
        Gson gson = new Gson();
        GiftDetail giftDetail = gson.fromJson(data, GiftDetail.class);
        GiftDetail.InfoBean infoBean = giftDetail.getInfo();
        tv_title.setText(infoBean.getGname() + infoBean.getGiftname());
        Picasso.with(this).load(Constants.GIFT_MAIN + infoBean.getIconurl()).
                config(Bitmap.Config.RGB_565).into(iv_icon);
        tv_overtime.setText(infoBean.getOvertime());
        tv_number.setText(String.valueOf(infoBean.getNumber()));
        tv_explains.setText(infoBean.getExplains());
        tv_getWay.setText(infoBean.getDescs());
    }

}
