package com.example.terry.lbjl.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.terry.lbjl.R;
import com.example.terry.lbjl.fragment.FeatureFragment;
import com.example.terry.lbjl.fragment.GameFragment;
import com.example.terry.lbjl.fragment.GiftFragment;
import com.example.terry.lbjl.fragment.HotFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rg_main_bottom)
    RadioGroup mRadioGroup;
//    @BindView(R.id.rb_gift_bottom)
//    RadioButton mGiftRb;
//    @BindView(R.id.rb_game_bottom)
//    RadioButton mGameRb;
//    @BindView(R.id.rb_hot_bottom)
//    RadioButton mHotRb;
//    @BindView(R.id.rb_feature_bottom)
//    RadioButton mFeatureRb;

    Fragment mFeatureFragment;
    Fragment mGameFragment;
    Fragment mGiftFragment;
    Fragment mHotFragment;
    Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();
        initFirstFragment();
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    private void initFragment() {
        mGiftFragment = GiftFragment.newInstance();
        mGameFragment = GameFragment.newInstance();
        mHotFragment = HotFragment.newInstance();
        mFeatureFragment = FeatureFragment.newInstance();
    }

    private void initFirstFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_content_main, mGiftFragment).commit();
        mCurrentFragment = mGiftFragment;
    }

    private void switchFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (fragment.isAdded()) {
            ft.hide(mCurrentFragment).show(fragment).commit();
        } else {
            ft.hide(mCurrentFragment).add(R.id.layout_content_main, fragment).commit();
        }
        mCurrentFragment = fragment;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_gift_bottom:
                switchFragment(mGiftFragment);
                break;
            case R.id.rb_game_bottom:
                switchFragment(mGameFragment);
                break;
            case R.id.rb_hot_bottom:
                switchFragment(mHotFragment);
                break;
            case R.id.rb_feature_bottom:
                switchFragment(mFeatureFragment);
                break;
        }
    }
}