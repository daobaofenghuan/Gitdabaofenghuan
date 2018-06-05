package com.sindcreate.dj.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


/**
 * Created by LiFang on 2018/1/23.
 */

public class DynamicHomeAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private List<String> mTabs;

    public DynamicHomeAdapter(FragmentManager fm, List<Fragment> fragments, List<String> tabs) {
        super(fm);
        mFragments = fragments;
        mTabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs.get(position);
    }
}
