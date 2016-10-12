package com.example.terry.lbjl.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.terry.lbjl.R;
import com.example.terry.lbjl.adapter.GameAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {
    @BindView(R.id.tab_game)
    TabLayout mTabLayout;
    @BindView(R.id.vp_game)
    ViewPager mViewPager;
    GBeginFragment mGBeginFragment;
    GTestFragment mGTestFragment;
    List<Fragment> mFragmentList;
    GameAdapter mGameAdapter;

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        ButterKnife.bind(this, view);

        mGBeginFragment = new GBeginFragment();
        mGTestFragment = new GTestFragment();
        mFragmentList = new ArrayList<>();
        mFragmentList.add(mGBeginFragment);
        mFragmentList.add(mGTestFragment);

        String[] title = new String[]{"开服", "开测"};
        mTabLayout.addTab(mTabLayout.newTab().setText(title[0]));
        mTabLayout.addTab(mTabLayout.newTab().setText(title[1]));

        mGameAdapter = new GameAdapter(getActivity().getSupportFragmentManager(), mFragmentList, title);
        mViewPager.setAdapter(mGameAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        return view;
    }

}
