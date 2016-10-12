package com.example.terry.lbjl.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.terry.lbjl.R;
import com.example.terry.lbjl.adapter.GameTestAdapter;
import com.example.terry.lbjl.bean.GameTest;
import com.example.terry.lbjl.callback.DataCallBack;
import com.example.terry.lbjl.constants.Constants;
import com.example.terry.lbjl.http.HttpUtils;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GTestFragment extends Fragment implements DataCallBack {

    @BindView(R.id.lv_game)
    PullToRefreshListView mListView;
    HttpUtils mHttpUtils;

    public GTestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gtest, container, false);
        ButterKnife.bind(this, view);
        mHttpUtils = HttpUtils.getHttpUtils();
        mHttpUtils.getDataFromNetWork(Constants.GAME_TEST,this);
//        mHttpUtils.setDataCallBack(this);
        return view;
    }

    @Override
    public void setDataCallBack(String data) {
        Gson gson = new Gson();
        GameTest gameTest = gson.fromJson(data, GameTest.class);
        GameTestAdapter adapter = new GameTestAdapter(gameTest.getInfo(), getActivity());
        mListView.setAdapter(adapter);
        mListView.setMode(PullToRefreshBase.Mode.DISABLED);
    }
}
