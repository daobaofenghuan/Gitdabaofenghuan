package com.sindcreate.dj.fragment.HomePage;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.DynamicHomeAdapter;
import com.sindcreate.dj.base.BaseFragment;
import com.sindcreate.dj.fragment.HomePage.Sanhuifragment.Part_Sanhui1_fragment;
import com.sindcreate.dj.fragment.HomePage.Sanhuifragment.Part_Sanhui2_fragment;
import com.sindcreate.dj.fragment.HomePage.Sanhuifragment.Part_Sanhui3_fragment;
import com.sindcreate.dj.fragment.HomePage.ZaixianFragemnt.Part_ZaiXian_fragment1;
import com.sindcreate.dj.fragment.HomePage.ZaixianFragemnt.Part_ZaiXian_fragment2;
import com.sindcreate.dj.util.UiUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.sindcreate.dj.util.DensityUtil.dip2px;

public class Part_ZaiXian_Fragment extends BaseFragment {
    private Button but, but2;
    private TextView textView;
    private List<String> mTabs;
    Unbinder unbinder2;
    @BindView(R.id.vp2)
    ViewPager vp;

    @BindView(R.id.tl2)
    TabLayout tl;
    @BindView(R.id.id_title_text)
    TextView titletext;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_homepage_zaixiankaoshi, container, false);
        ButterKnife.bind(this, view);
        unbinder2 = ButterKnife.bind(this, view);
        titletext.setText("在线答题2");
        initTabLayout();
        bindViewPager();

        return view;

    }



    private void initTabLayout() {
    //    textView.setText("三会一课");
        mTabs = new ArrayList<>();
        mTabs.clear();
        mTabs.add("进行中");
        mTabs.add("已结束");



    }

    private void bindViewPager() {

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Part_ZaiXian_fragment1());
        fragments.add(new Part_ZaiXian_fragment2());


        DynamicHomeAdapter adapter = new DynamicHomeAdapter(getChildFragmentManager(), fragments, mTabs);
        vp.setOffscreenPageLimit(2);
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);
     //   reflex(tl);

    }



}
