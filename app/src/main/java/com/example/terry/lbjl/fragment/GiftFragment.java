package com.example.terry.lbjl.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.terry.lbjl.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GiftFragment extends Fragment {

    @BindView(R.id.lv_gift)
    ListView mGiftLv;

    public GiftFragment() {
        // Required empty public constructor
    }

    public static GiftFragment newInstance() {

        Bundle args = new Bundle();

        GiftFragment fragment = new GiftFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gift, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

}
