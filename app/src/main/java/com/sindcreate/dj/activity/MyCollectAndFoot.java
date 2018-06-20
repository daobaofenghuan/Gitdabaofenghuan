package com.sindcreate.dj.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.listviewadapter.DangFeiListAdapter;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.fragment.ServiceIndex.JYXC_Fragment;
import com.sindcreate.dj.model.Entry;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCollectAndFoot extends BaseActivity {
    JYXC_Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footandcollect);
        ButterKnife.bind(this);
        titletext.setText("我的党费");
        StatusBarUtils.setWindowStatusBarColor(MyCollectAndFoot.this, R.color.dj_titalred);


        fragment=new JYXC_Fragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contain_jyxc,fragment).commit();




    }

}
