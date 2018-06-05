package com.sindcreate.dj.fragment;



import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;

import android.widget.TextView;


import com.sindcreate.dj.R;
import com.sindcreate.dj.base.Cell;


import java.util.List;

import butterknife.ButterKnife;

public class GroupFragmentr1 extends AbsBaseFragment {
    private Button but, but2;
    private TextView textView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_myfmg, container, false);
        ButterKnife.bind(this, view);


        return view;

    }

    @Override
    public void onRecyclerViewInitialized() {
        //初始化View和数据加载

    }

    @Override
    public void onPullRefresh() {
        //下拉刷新回调
    }

    @Override
    public void onLoadMore() {
        //上拉加载回调
    }

    @Override
    protected List<Cell> getCells(List list) {
        //根据实体生成Cell


        return null;
    }


}
