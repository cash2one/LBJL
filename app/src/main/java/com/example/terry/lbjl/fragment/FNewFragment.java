package com.example.terry.lbjl.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.terry.lbjl.R;
import com.example.terry.lbjl.activity.FeatureNewDetailActivity;
import com.example.terry.lbjl.activity.FeatureWedDetailActivity;
import com.example.terry.lbjl.adapter.FeatureNewAdapter;
import com.example.terry.lbjl.bean.FeatureNew;
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
public class FNewFragment extends Fragment implements DataCallBack, AdapterView.OnItemClickListener {

    @BindView(R.id.lv_feature_new)
    PullToRefreshListView mListView;
    HttpUtils mHttpUtils;
    List<FeatureNew.ListBean> mNewList;

    public FNewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fnew, container, false);
        ButterKnife.bind(this, view);
        mHttpUtils = HttpUtils.getHttpUtils();
        mHttpUtils.getDataFromNetWork(String.format(Constants.FEATURE_NEW + 0),this);
        return view;
    }

    @Override
    public void setDataCallBack(String data) {
        Gson mGson = new Gson();
        FeatureNew mNew = mGson.fromJson(data, FeatureNew.class);
        mNewList = mNew.getList();
        FeatureNewAdapter mNewAdapter = new FeatureNewAdapter(mNewList, getActivity());
        mListView.setAdapter(mNewAdapter);
        mListView.setMode(PullToRefreshBase.Mode.BOTH);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.putExtra("id", mNewList.get(position - 1).getId());
        intent.setClass(getActivity(), FeatureNewDetailActivity.class);
        startActivity(intent);
    }
}
