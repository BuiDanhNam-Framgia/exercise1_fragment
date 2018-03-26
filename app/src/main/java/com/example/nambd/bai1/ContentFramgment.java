package com.example.nambd.bai1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by NamBD on 3/26/2018.
 */

public class ContentFramgment extends Fragment {
    FragmentPagerAdapter adapterViewPager;
    private ViewPager vpPager;

    public static ContentFramgment newInstance() {
        ContentFramgment framgment = new ContentFramgment();
        return framgment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_chuvidt, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        vpPager = view.findViewById(R.id.vpPager);
        adapterViewPager = new FramgmentAdapter(getChildFragmentManager());
        vpPager.setAdapter(adapterViewPager);
    }
}
