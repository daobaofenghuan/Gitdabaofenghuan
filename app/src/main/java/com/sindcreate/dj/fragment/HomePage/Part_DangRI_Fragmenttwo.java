package com.sindcreate.dj.fragment.HomePage;

/**
 * Created by Double on 2018/6/8.
 */

import android.support.v4.app.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.DynamicHomeAdapter;
import com.sindcreate.dj.base.BaseFragment;
import com.sindcreate.dj.fragment.HomePage.Sanhuifragment.Part_Sanhui2_fragment;
import com.sindcreate.dj.fragment.HomePage.Sanhuifragment.Part_Sanhui3_fragment;
import com.sindcreate.dj.fragment.HomePage.WorkFragment.Part_Work_fragment1;
import com.sindcreate.dj.fragment.HomePage.ZaixianFragemnt.Part_ZaiXian_fragment1;
import com.sindcreate.dj.util.UiUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Part_DangRI_Fragmenttwo extends BaseFragment {
    private Button but, but2;
    private TextView textView;
    private List<String> mTabs;
    Unbinder unbinder;
    @BindView(R.id.vp5)
    ViewPager vp;

    @BindView(R.id.tl5)
    TabLayout tl;
    @BindView(R.id.id_title_text)
    TextView titletext;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_homepage_dangri, container, false);
        ButterKnife.bind(this, view);
        unbinder = ButterKnife.bind(this, view);

        initTabLayout();
        bindViewPager();


        return view;

    }


    private void initTabLayout() {
        //    textView.setText("三会一课");
        mTabs = new ArrayList<>();
        mTabs.clear();
        mTabs.add(UiUtil.getString(R.string.daiwobaoming));
        mTabs.add(UiUtil.getString(R.string.woyibangming));
        mTabs.add(UiUtil.getString(R.string.sanhui_text3));


    }

    private void bindViewPager() {

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Part_Work_fragment1());
        fragments.add(new Part_Work_fragment1());
        fragments.add(new Part_Work_fragment1());


        DynamicHomeAdapter adapter = new DynamicHomeAdapter(getFragmentManager(), fragments, mTabs);
        vp.setOffscreenPageLimit(3);
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);
        //   reflex(tl);

    }


}
