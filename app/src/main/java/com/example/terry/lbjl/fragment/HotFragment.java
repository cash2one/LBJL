package com.example.terry.lbjl.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.terry.lbjl.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends Fragment {


    public HotFragment() {
        // Required empty public constructor
    }

    public static HotFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HotFragment fragment = new HotFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hot, container, false);
    }

}
