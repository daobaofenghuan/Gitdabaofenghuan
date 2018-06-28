package com.sindcreate.dj.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.sindcreate.dj.MainActivity;
import com.sindcreate.dj.R;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.fragment.ServiceIndex.JYXC_Fragment;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login_Activity extends Activity {
@BindView(R.id.id_login_button)
    TextView loginbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //沉浸式状态栏
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }else{
       StatusBarUtils.setWindowStatusBarColor(Login_Activity.this, R.color.dj_login_red1);}





    }

@OnClick({R.id.id_login_button})
   void viewclick(View v){
        switch (v.getId()){
            case R.id.id_login_button:
                startActivity(new Intent(Login_Activity.this, MainActivity.class));//TODO 後面傢finish或者main为干掉其他启动
                finish();
                break;


        }

}

}
