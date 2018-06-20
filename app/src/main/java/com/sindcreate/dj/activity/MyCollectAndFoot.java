package com.sindcreate.dj.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.listviewadapter.DangFeiListAdapter;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.fragment.ServiceIndex.JYXC_Fragment;
import com.sindcreate.dj.fragment.myindex.ColectFragment;
import com.sindcreate.dj.model.Entry;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCollectAndFoot extends BaseActivity {
    ColectFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footandcollect);
        ButterKnife.bind(this);
        titletext.setText("我的足迹");
        Mydata.contextcollect=this;
        StatusBarUtils.setWindowStatusBarColor(MyCollectAndFoot.this, R.color.dj_titalred);


        fragment=new ColectFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_my,fragment).commit();




    }

}
