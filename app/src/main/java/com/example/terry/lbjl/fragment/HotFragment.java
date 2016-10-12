package com.example.terry.lbjl.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.example.terry.lbjl.R;
import com.example.terry.lbjl.activity.HotDetailActivity;
import com.example.terry.lbjl.adapter.HotGvAdapter;
import com.example.terry.lbjl.adapter.HotLvAdapter;
import com.example.terry.lbjl.bean.Gift;
import com.example.terry.lbjl.bean.Hot;
import com.example.terry.lbjl.callback.DataCallBack;
import com.example.terry.lbjl.constants.Constants;
import com.example.terry.lbjl.http.HttpUtils;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends Fragment implements DataCallBack {

    @BindView(R.id.lv_hot)
    ListView mListView;
    @BindView(R.id.gv_hot)
    GridView mGridView;
    HttpUtils mHttpUtils;

    public HotFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hot, container, false);
        ButterKnife.bind(this, view);
        mHttpUtils = HttpUtils.getHttpUtils();
        mHttpUtils.getDataFromNetWork(Constants.HOT_PATH, this);
//        mHttpUtils.setDataCallBack(this);
        return view;
    }

    @Override
    public void setDataCallBack(String data) {
        Gson mGson = new Gson();
        Hot mHot = mGson.fromJson(data, Hot.class);
        final List<Hot.InfoBean.Push1Bean> mPush1 = mHot.getInfo().getPush1();
        final List<Hot.InfoBean.Push2Bean> mPush2 = mHot.getInfo().getPush2();
        HotLvAdapter mLvAdapter = new HotLvAdapter(mPush1, getActivity());
        HotGvAdapter mGvAdapter = new HotGvAdapter(mPush2, getActivity());
        mListView.setAdapter(mLvAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), HotDetailActivity.class);
                intent.putExtra("appid", mPush1.get(position).getId());
                startActivity(intent);
            }
        });
        mGridView.setAdapter(mGvAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), HotDetailActivity.class);
                intent.putExtra("appid", mPush2.get(position).getId());
                startActivity(intent);
            }
        });
    }
}
