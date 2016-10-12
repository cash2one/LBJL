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
public class FeatureFragment extends Fragment {

    @BindView(R.id.tab_feature)
    TabLayout mTabLayout;
    @BindView(R.id.vp_feature)
    ViewPager mViewPager;
    FWedFragment mWedFragment;
    FNewFragment mNewFragment;
    List<Fragment> mFragmentList;

    public FeatureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feature, container, false);
        ButterKnife.bind(this, view);

        mWedFragment = new FWedFragment();
        mNewFragment = new FNewFragment();
        mFragmentList = new ArrayList<>();
        mFragmentList.add(mWedFragment);
        mFragmentList.add(mNewFragment);

        String[] title = new String[]{"暴打星期三", "新游周刊"};
        mTabLayout.addTab(mTabLayout.newTab().setText(title[0]));
        mTabLayout.addTab(mTabLayout.newTab().setText(title[1]));

        GameAdapter mGameAdapter = new GameAdapter(getActivity().getSupportFragmentManager(), mFragmentList, title);
        mViewPager.setAdapter(mGameAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        return view;
    }
}
