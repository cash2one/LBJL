package com.example.terry.lbjl.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.terry.lbjl.R;
import com.example.terry.lbjl.activity.GiftDetailActivity;
import com.example.terry.lbjl.adapter.GiftLvAdapter;
import com.example.terry.lbjl.adapter.GiftVpAdapter;
import com.example.terry.lbjl.bean.Gift;
import com.example.terry.lbjl.callback.DataCallBack;
import com.example.terry.lbjl.constants.Constants;
import com.example.terry.lbjl.http.HttpUtils;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GiftFragment extends Fragment implements DataCallBack,
        ViewPager.OnPageChangeListener, AdapterView.OnItemClickListener {

    @BindView(R.id.lv_gift)
    PullToRefreshListView mGiftLv;
    @BindView(R.id.vp_gift)
    ViewPager mGiftVp;
    @BindView(R.id.point_container)
    LinearLayout point_container;
    private boolean stopThread = false;
    Gift gift;
    private int page = 1;
    HttpUtils httpUtils;

    public GiftFragment() {
        // Required empty public constructor
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg != null) {
                if (msg.what == 0) {
                    int pos = mGiftVp.getCurrentItem();
                    int size = gift.getAd().size();
                    mGiftVp.setCurrentItem((pos + 1) % size, false);
                }
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gift, container, false);
        ButterKnife.bind(this, view);
        httpUtils = HttpUtils.getHttpUtils();
        httpUtils.getDataFromNetWork(String.format(Constants.GIFT_PATH + (page++)),this);
//        httpUtils.setDataCallBack(this);
        return view;
    }


    @Override
    public void setDataCallBack(final String data) {
        Gson gson = new Gson();
//        Log.e("====","===="+data);
        gift = gson.fromJson(data, Gift.class);
        GiftLvAdapter lvAdapter = new GiftLvAdapter(gift.getList(), getActivity());
        mGiftLv.setAdapter(lvAdapter);
        mGiftLv.setMode(PullToRefreshBase.Mode.BOTH);
        mGiftLv.setOnItemClickListener(this);
        mGiftLv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                httpUtils.getDataFromNetWork(Constants.GIFT_PATH + page,GiftFragment.this);
                mGiftLv.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });

        List<View> viewList = new ArrayList<>();
        List<Gift.AdBean> list = gift.getAd();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            String adPath = list.get(i).getIconurl();
            Picasso.with(getActivity()).load(Constants.GIFT_MAIN + adPath)
                    .config(Bitmap.Config.RGB_565)
                    .into(imageView);
            viewList.add(imageView);

            ImageView iv_point_reading = new ImageView(getActivity());
            iv_point_reading.setId(i);
            iv_point_reading.setPadding(10, 0, 10, 0);
            if (i == 0) {
                iv_point_reading.setImageResource(R.drawable.gift_ad_point_selected);
            } else {
                iv_point_reading.setImageResource(R.drawable.gift_ad_point_default);
            }
            point_container.addView(iv_point_reading);

            GiftVpAdapter vpAdapter = new GiftVpAdapter(viewList);
            mGiftVp.setAdapter(vpAdapter);
            mGiftVp.addOnPageChangeListener(this);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stopThread) {
                    try {
                        Thread.sleep(4000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(0);
                }
            }
        }).start();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int count = point_container.getChildCount();
        for (int i = 0; i < count; i++) {
            ImageView imageView = (ImageView) point_container.getChildAt(i);
            if (i == position) {
                imageView.setImageResource(R.drawable.gift_ad_point_selected);
            } else {
                imageView.setImageResource(R.drawable.gift_ad_point_default);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onDestroy() {
        stopThread = true;
        super.onDestroy();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.putExtra("id", gift.getList().get(position - 1).getId());
        intent.setClass(getActivity(), GiftDetailActivity.class);
        startActivity(intent);
    }
}
