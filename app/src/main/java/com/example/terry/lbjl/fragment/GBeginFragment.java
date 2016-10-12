package com.example.terry.lbjl.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.terry.lbjl.R;
import com.example.terry.lbjl.adapter.GameBeginAdapter;
import com.example.terry.lbjl.bean.GameBegin;
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
public class GBeginFragment extends Fragment implements DataCallBack {
//    @BindView(R.id.lv_game_begin)
    ListView mListView;
    HttpUtils mHttpUtils;

    public GBeginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gbegin, container, false);
        mListView = (ListView) view.findViewById(R.id.lv_game_begin);
//        ButterKnife.bind(this, view);
        mHttpUtils = HttpUtils.getHttpUtils();
        mHttpUtils.getDataFromNetWork(Constants.GAME_OPEN,this);
//        mHttpUtils.setDataCallBack(this);
        return view;
    }

    @Override
    public void setDataCallBack(String data) {
        Gson gson = new Gson();
        Log.e("====", "====" + data);
        GameBegin gameBegin = gson.fromJson(data, GameBegin.class);
        GameBeginAdapter adapter = new GameBeginAdapter(gameBegin.getInfo(), getActivity());
        mListView.setAdapter(adapter);
    }
}
