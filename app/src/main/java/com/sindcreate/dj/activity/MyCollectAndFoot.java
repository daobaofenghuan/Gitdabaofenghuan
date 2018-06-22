package com.sindcreate.dj.activity;

import android.content.Intent;
import android.os.Bundle;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.fragment.myindex.CollectFragment;
import com.sindcreate.dj.fragment.myindex.FootFragment;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;

import butterknife.ButterKnife;

public class MyCollectAndFoot extends BaseActivity {
    FootFragment fragment;
    CollectFragment fragment2;
int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footandcollect);
        ButterKnife.bind(this);
        flag=  getIntent().getIntExtra("flag",0);

        Mydata.contextcollect=this;
        StatusBarUtils.setWindowStatusBarColor(MyCollectAndFoot.this, R.color.dj_titalred);

        if (flag==0) {
            titletext.setText("我的足迹");
            fragment = new FootFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_my, fragment).commit();
        }else {
            titletext.setText("收藏的文章");
            fragment2 = new CollectFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_my, fragment2).commit();

        }



    }


}
