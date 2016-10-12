package com.example.terry.lbjl.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.terry.lbjl.R;
import com.example.terry.lbjl.fragment.FeatureFragment;
import com.example.terry.lbjl.fragment.GameFragment;
import com.example.terry.lbjl.fragment.GiftFragment;
import com.example.terry.lbjl.fragment.HotFragment;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rg_main_bottom)
    RadioGroup mRadioGroup;
    @BindView(R.id.tv_bar)
    TextView mTextView;
    @BindView(R.id.btn_bar)
    Button mButton;
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
        mGiftFragment = new GiftFragment();
        mGameFragment = new GameFragment();
        mHotFragment = new HotFragment();
        mFeatureFragment = new FeatureFragment();
    }

    private void initFirstFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_content_main, mGiftFragment).commit();
        mTextView.setText("礼包精灵");
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
                mTextView.setVisibility(View.VISIBLE);
                mTextView.setText("礼包精灵");
                break;
            case R.id.rb_game_bottom:
                switchFragment(mGameFragment);
                mTextView.setText("开服");
                mButton.setVisibility(View.GONE);
                break;
            case R.id.rb_hot_bottom:
                switchFragment(mHotFragment);
                mTextView.setText("热门游戏");
                mButton.setVisibility(View.GONE);
                break;
            case R.id.rb_feature_bottom:
                switchFragment(mFeatureFragment);
                mTextView.setText("独家企划");
                mButton.setVisibility(View.GONE);
                break;
        }
    }
}