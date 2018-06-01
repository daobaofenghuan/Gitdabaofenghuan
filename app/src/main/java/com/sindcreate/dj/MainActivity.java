package com.sindcreate.dj;

import android.annotation.SuppressLint;
import android.app.Fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.LinearLayout;


import com.sindcreate.dj.adapter.MainRecycleAdapter;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.fragment.EducationFragment;
import com.sindcreate.dj.fragment.HomePage.Part_DangRi_Fragemnt;
import com.sindcreate.dj.fragment.HomePageFragment;
import com.sindcreate.dj.fragment.MessageFragment;
import com.sindcreate.dj.fragment.ServiceFragment;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;


import java.util.ArrayList;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> list = new ArrayList<>();
    MainRecycleAdapter mAdapter;
    HomePageFragment fragment;
    EducationFragment fragment2;
    ServiceFragment fragment3;
    MessageFragment messageFragment;
    Part_DangRi_Fragemnt dangRi_fragemnt6;

    @BindView(R.id.id_home_bottom_ly1)
    LinearLayout bottomly1;
    @BindView(R.id.id_home_bottom_ly2)
    LinearLayout bottomly2;
    @BindView(R.id.id_home_bottom_ly3)
    LinearLayout bottomly3;
    @BindView(R.id.id_home_bottom_ly4)
    LinearLayout bottomly4;


    @SuppressLint("HandlerLeak")
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg != null) {
                switch (msg.what) {
                    case 100:
              initview(5);
                    case 101:
                        initview(6);

                        break;

                }


            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mydata.handler=this.handler;
        Mydata.context=this;
        StatusBarUtils.setWindowStatusBarColor(MainActivity.this, R.color.dj_titalred);
        ButterKnife.bind(MainActivity.this);


        initview(1);


    }

    public void initview(int flag) {
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();


        hideFragment(mFragmentTransaction);
        switch (flag) {
            case 1:
                if (fragment == null) {
                    fragment = new HomePageFragment();
                    mFragmentTransaction.add(R.id.fragment_container, fragment);
                } else {
                    mFragmentTransaction.show(fragment);
                }

                break;
            case 2:
                if (fragment2 == null) {
                    fragment2 = new EducationFragment();
                    mFragmentTransaction.add(R.id.fragment_container, fragment2);
                } else {
                    mFragmentTransaction.show(fragment2);
                }
                break;
            case 3:
                if (fragment3 == null) {
                    fragment3 = new ServiceFragment();
                    mFragmentTransaction.add(R.id.fragment_container, fragment3);
                } else {
                    mFragmentTransaction.show(fragment3);
                }
                break;

            case 5:
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
                    mFragmentTransaction.add(R.id.fragment_container, messageFragment);
                }else {
                    mFragmentTransaction.show(messageFragment);
                }
                break;
                case 6:
                    if(dangRi_fragemnt6==null){
                        dangRi_fragemnt6=new Part_DangRi_Fragemnt();
                        mFragmentTransaction.add(R.id.fragment_container,dangRi_fragemnt6);
                    }else {
                        mFragmentTransaction.show(dangRi_fragemnt6);
                    }
                   break;



        }
        mFragmentTransaction.commit();

    }

    @OnClick({R.id.id_home_bottom_ly1, R.id.id_home_bottom_ly2, R.id.id_home_bottom_ly3})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.id_home_bottom_ly1:
                System.out.println("点击1");
                initview(1);

                break;
            case R.id.id_home_bottom_ly2:
                System.out.println("点击2");
                initview(2);
                break;
            case R.id.id_home_bottom_ly3:
                initview(3);
                break;
            case R.id.id_home_bottom_ly4:
                initview(4);
                break;
        }

    }


    private void hideFragment(FragmentTransaction fragmentTransaction) {
        //如果此fragment不为空的话就隐藏起来
        if (fragment != null) {
            fragmentTransaction.hide(fragment);
        }
        if (fragment2 != null) {
            fragmentTransaction.hide(fragment2);
        }
        if (fragment3 != null) {
            fragmentTransaction.hide(fragment3);
        }
        if (fragment != null) {
            fragmentTransaction.hide(fragment);
        }
        if(messageFragment!=null){
            fragmentTransaction.hide(messageFragment);
        }
        if(dangRi_fragemnt6!=null){
            fragmentTransaction.remove(dangRi_fragemnt6);
            dangRi_fragemnt6=null;
        }
    }


}
