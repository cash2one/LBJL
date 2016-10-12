package com.example.terry.lbjl.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Terry on 2016/10/1.
 */
public class GameAdapter extends FragmentPagerAdapter {
    List<Fragment> mList;
    String[] title;

    public GameAdapter(FragmentManager fm, List<Fragment> list, String[] title) {
        super(fm);
        mList = list;
        this.title = title;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }
}
