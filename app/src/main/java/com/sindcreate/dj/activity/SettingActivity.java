package com.sindcreate.dj.activity;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.RelativeLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.sindcreate.dj.R;

import com.sindcreate.dj.base.BaseActivity;

import com.sindcreate.dj.view.MPopupWindowsSetting;
import com.sindcreate.dj.view.MPopupWindowsSettingcode;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SettingActivity extends BaseActivity {
@BindView(R.id.id_setting_ly1)
    RelativeLayout passwordly;
    @BindView(R.id.id_setting_ly2)
    RelativeLayout headimgly;
    @BindView(R.id.id_chenjinly)
    RelativeLayout chenjin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
     //   StatusBarUtils.setWindowStatusBarColor(SettingActivity.this, R.color.dj_titalred);
        ImmersionBar.with(this).init();
        ButterKnife.bind(this);


    }

    @OnClick({R.id.id_setting_ly1,R.id.id_setting_ly2})
    void viewonclick(View v){
        switch (v.getId()){
            case R.id.id_setting_ly1:
                new MPopupWindowsSettingcode(this,passwordly,this,chenjin);


                break;
            case R.id.id_setting_ly2:

                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED)
                {

                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE
                          ,Manifest.permission.CAMERA  },
                            1);
                    //权限还没有授予，需要在这里写申请权限的代码
                }else {
                    new MPopupWindowsSetting(this, headimgly, this, chenjin);
                    //权限已经被授予，在这里直接写要执行的相应方法即可
                }


             //   chenjin.setVisibility(View.VISIBLE);
                break;

        }


    }
}
