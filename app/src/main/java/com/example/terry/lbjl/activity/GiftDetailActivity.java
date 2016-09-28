package com.example.terry.lbjl.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.terry.lbjl.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GiftDetailActivity extends AppCompatActivity {

    @BindView(R.id.gift_detail_bar)
    Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift_detail);
        ButterKnife.bind(this);
        mToolBar.setTitle("");
    }
}
