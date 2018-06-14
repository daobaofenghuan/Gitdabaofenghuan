package com.sindcreate.dj.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.fragment.MessageFragment;
import com.sindcreate.dj.fragment.ServiceIndex.JYXC_Fragment;
import com.sindcreate.dj.fragment.ServiceIndex.cell.JYXC_Part1;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;

import butterknife.ButterKnife;

public class JYXC_Activity extends BaseActivity {
JYXC_Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jyxc);
        ButterKnife.bind(this);
        titletext.setText("建言献策");
        StatusBarUtils.setWindowStatusBarColor(JYXC_Activity.this, R.color.dj_titalred);
       fragment=new JYXC_Fragment();
       getSupportFragmentManager().beginTransaction().add(R.id.contain_jyxc,fragment).commit();




    }

}
