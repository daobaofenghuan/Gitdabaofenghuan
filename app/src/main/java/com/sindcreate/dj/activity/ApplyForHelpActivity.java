package com.sindcreate.dj.activity;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import com.sindcreate.dj.MainActivity;
import com.sindcreate.dj.R;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;

import java.nio.Buffer;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ApplyForHelpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applyforhelp);
        StatusBarUtils.setWindowStatusBarColor(ApplyForHelpActivity.this, R.color.dj_titalred);
        ButterKnife.bind(this);


    }

}
