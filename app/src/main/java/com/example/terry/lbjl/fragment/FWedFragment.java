package com.example.terry.lbjl.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.terry.lbjl.R;
import com.example.terry.lbjl.activity.FeatureWedDetailActivity;
import com.example.terry.lbjl.activity.GiftDetailActivity;
import com.example.terry.lbjl.adapter.FeatureNewAdapter;
import com.example.terry.lbjl.adapter.FeatureWedAdapter;
import com.example.terry.lbjl.bean.FeatureNew;
import com.example.terry.lbjl.bean.FeatureWed;
import com.example.terry.lbjl.bean.FeatureWedDetail;
import com.example.terry.lbjl.callback.DataCallBack;
import com.example.terry.lbjl.constants.Constants;
import com.example.terry.lbjl.http.HttpUtils;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FWedFragment extends Fragment implements DataCallBack, AdapterView.OnItemClickListener {

    @BindView(R.id.lv_feature_wed)
    PullToRefreshListView mListView;
    HttpUtils mHttpUtils;
    List<FeatureWed.ListBean> mWedList;

    public FWedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fwed, container, false);
        ButterKnife.bind(this, view);

        mHttpUtils = HttpUtils.getHttpUtils();
        mHttpUtils.getDataFromNetWork(String.format(Constants.FEATURE_WED + 0),this);
        Log.e("==FWedFragment==","onCreateView");
//        mHttpUtils.setDataCallBack(this);
        return view;
    }

    @Override
    public void setDataCallBack(String data) {
        Gson mGson = new Gson();
        FeatureWed mWed = mGson.fromJson(data, FeatureWed.class);
        mWedList = mWed.getList();
        FeatureWedAdapter mWedAdapter = new FeatureWedAdapter(mWedList, getActivity());
        mListView.setAdapter(mWedAdapter);
        mListView.setMode(PullToRefreshBase.Mode.BOTH);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.putExtra("sid", mWedList.get(position - 1).getSid());
        intent.setClass(getActivity(), FeatureWedDetailActivity.class);
        startActivity(intent);
    }
}
