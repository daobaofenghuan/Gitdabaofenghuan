package com.sindcreate.dj.activity;

import android.os.Bundle;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.fragment.HomePage.SanhuiIndex.HuodongFragment;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;

import butterknife.ButterKnife;

public class HuoDongActivity extends BaseActivity {

HuodongFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huodong);
        ButterKnife.bind(this);
        titletext.setText("活动详情");
        Mydata.contexthuodong=this;
        StatusBarUtils.setWindowStatusBarColor(HuoDongActivity.this, R.color.dj_titalred);
       fragment=new HuodongFragment();
       getSupportFragmentManager().beginTransaction().add(R.id.contain_sanhuiindex,fragment).commit();




    }

}
