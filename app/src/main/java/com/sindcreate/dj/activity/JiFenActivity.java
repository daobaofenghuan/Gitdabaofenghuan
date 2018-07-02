package com.sindcreate.dj.activity;

import android.os.Bundle;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.fragment.HomePage.SanhuiIndex.HuodongFragment;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;

import butterknife.ButterKnife;

public class JiFenActivity extends BaseActivity {

HuodongFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jifen);
        ButterKnife.bind(this);
        titletext.setText("我的积分");

        StatusBarUtils.setWindowStatusBarColor(JiFenActivity.this, R.color.dj_titalred);





    }

}
