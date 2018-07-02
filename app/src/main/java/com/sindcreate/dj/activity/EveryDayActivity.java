package com.sindcreate.dj.activity;

import android.app.Activity;
import android.os.Bundle;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.fragment.HomePage.SanhuiIndex.HuodongFragment;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;

import butterknife.ButterKnife;

public class EveryDayActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_everyday);
        ButterKnife.bind(this);


        StatusBarUtils.setWindowStatusBarColor(EveryDayActivity.this, R.color.dj_titalred);





    }

}
