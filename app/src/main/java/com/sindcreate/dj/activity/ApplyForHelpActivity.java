package com.sindcreate.dj.activity;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import com.sindcreate.dj.MainActivity;
import com.sindcreate.dj.R;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;


public class ApplyForHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applyforhelp);
        StatusBarUtils.setWindowStatusBarColor(ApplyForHelpActivity.this, R.color.dj_titalred);



    }

}
