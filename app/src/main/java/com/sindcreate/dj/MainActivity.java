package com.sindcreate.dj;

import android.annotation.SuppressLint;
import android.app.Fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.sindcreate.dj.adapter.MainRecycleAdapter;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.fragment.EducationFragment;
import com.sindcreate.dj.fragment.EducationFragment2;
import com.sindcreate.dj.fragment.HomePage.Part_DangRI_Fragmenttwo;
import com.sindcreate.dj.fragment.HomePage.Part_DangRi_Fragemnt;
import com.sindcreate.dj.fragment.HomePage.Part_SanHuiYiKe_Fragment;
import com.sindcreate.dj.fragment.HomePage.Part_Work_Fragment;
import com.sindcreate.dj.fragment.HomePage.Part_ZaiXian_Fragment;

import com.sindcreate.dj.fragment.HomePageFragment;
import com.sindcreate.dj.fragment.MessageFragment;
import com.sindcreate.dj.fragment.MyFragment;
import com.sindcreate.dj.fragment.ServiceFragment;
import com.sindcreate.dj.util.UiUtil;

import com.sindcreate.mylibrary.comm.util.StatusBarUtils;

import static com.sindcreate.dj.bean.MsgNum.*;

import java.util.ArrayList;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> list = new ArrayList<>();
    MainRecycleAdapter mAdapter;
    //4个主页
    HomePageFragment fragment;
    EducationFragment2 fragment2;
    ServiceFragment fragment3;
    MyFragment fragment4;//我的
    //消息
    MessageFragment messageFragment;
    //homepage 4个新选项

    Part_DangRI_Fragmenttwo dangRi_fragemnt6;
    Part_SanHuiYiKe_Fragment sanHuiYiKe_fragment7;
    Part_ZaiXian_Fragment zaiXian_fragment8;
    Part_Work_Fragment work_fragment9;


    @BindView(R.id.id_home_bottom_img1)
    ImageView bottomimg1;
    @BindView(R.id.id_home_bottom_img2)
    ImageView bottomimg2;
    @BindView(R.id.id_home_bottom_img3)
    ImageView bottomimg3;
    @BindView(R.id.id_home_bottom_img4)
    ImageView bottomimg4;

    @BindView(R.id.id_home_bottom_ly1)
    LinearLayout bottomly1;
    @BindView(R.id.id_home_bottom_ly2)
    LinearLayout bottomly2;
    @BindView(R.id.id_home_bottom_ly3)
    LinearLayout bottomly3;
    @BindView(R.id.id_home_bottom_ly4)
    LinearLayout bottomly4;

    @BindView(R.id.id_home_bottom_tx1)
    TextView textView1;
    @BindView(R.id.id_home_bottom_tx2)
    TextView textView2;
    @BindView(R.id.id_home_bottom_tx3)
    TextView textView3;
    @BindView(R.id.id_home_bottom_tx4)
    TextView textView4;


    @SuppressLint("HandlerLeak")
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg != null) {
                switch (msg.what) {
                    case MSG_XiaoXI:
                        initview(5);
                        break;
                    case MSG_DangRI:
                        initview(6);

                        break;
                    case MSG_SanHui:
                        initview(7);
                        break;
                    case MSG_ZAIXIANKAOSHI:
                        initview(8);
                        break;
                    case MSG_Work:
                        initview(9);
                        break;
                    case MSG_Home:
                        initview(1);
                        break;
                }


            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mydata.handler = this.handler;
        Mydata.context = this;
        StatusBarUtils.setWindowStatusBarColor(MainActivity.this, R.color.dj_titalred);
        ButterKnife.bind(MainActivity.this);


        initview(1);
        selectcolor(1);


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
                    fragment2 = new EducationFragment2();
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

            case 4:
                if (fragment4 == null) {
                    fragment4 = new MyFragment();
                    mFragmentTransaction.add(R.id.fragment_container, fragment4);
                } else {
                    mFragmentTransaction.show(fragment4);
                }
                break;

            case 5:
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
                    mFragmentTransaction.add(R.id.fragment_container, messageFragment);
                } else {
                    mFragmentTransaction.show(messageFragment);
                }
                break;
            case 6:
                if (dangRi_fragemnt6 == null) {
                    dangRi_fragemnt6 = new Part_DangRI_Fragmenttwo();
                    mFragmentTransaction.add(R.id.fragment_container, dangRi_fragemnt6);
                } else {
                    mFragmentTransaction.show(dangRi_fragemnt6);
                }
                break;

            case 7:
                if (sanHuiYiKe_fragment7 == null) {
                    sanHuiYiKe_fragment7 = new Part_SanHuiYiKe_Fragment();
                    mFragmentTransaction.add(R.id.fragment_container, sanHuiYiKe_fragment7);
                } else {
                    mFragmentTransaction.show(sanHuiYiKe_fragment7);
                }
                break;
            case 8:
                if (zaiXian_fragment8 == null) {
                    zaiXian_fragment8 = new Part_ZaiXian_Fragment();
                    mFragmentTransaction.add(R.id.fragment_container, zaiXian_fragment8);
                } else {
                    mFragmentTransaction.show(zaiXian_fragment8);
                }
                break;
            case 9:
                if (work_fragment9 == null) {
                    work_fragment9 = new Part_Work_Fragment();
                    mFragmentTransaction.add(R.id.fragment_container, work_fragment9);
                } else {
                    mFragmentTransaction.show(work_fragment9);
                }
                break;

        }
        mFragmentTransaction.commit();

    }

    @OnClick({R.id.id_home_bottom_ly1, R.id.id_home_bottom_ly2, R.id.id_home_bottom_ly3, R.id.id_home_bottom_ly4})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.id_home_bottom_ly1:
                System.out.println("点击1");
                initview(1);
                selectcolor(1);

                break;
            case R.id.id_home_bottom_ly2:
                System.out.println("点击2");
                initview(2);
                selectcolor(2);
                break;
            case R.id.id_home_bottom_ly3:
                initview(3);
                selectcolor(3);
                break;
            case R.id.id_home_bottom_ly4:
                initview(4);
                selectcolor(4);
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
        if (fragment4 != null) {
            fragmentTransaction.hide(fragment4);
        }
        if (messageFragment != null) {
            fragmentTransaction.hide(messageFragment);
        }
        if (dangRi_fragemnt6 != null) {
            fragmentTransaction.hide(dangRi_fragemnt6);
          //  dangRi_fragemnt6 = null;
        }
        if (sanHuiYiKe_fragment7 != null) {
            fragmentTransaction.hide(sanHuiYiKe_fragment7);
            //   sanHuiYiKe_fragment7.onDetach();
            // sanHuiYiKe_fragment7 = null;
        }
        if (zaiXian_fragment8 != null) {
            fragmentTransaction.hide(zaiXian_fragment8);

        }
        if (work_fragment9 != null) {
            fragmentTransaction.hide(work_fragment9);

        }

    }

    private void selectcolor(int flag) {
        bottomimg1.setImageResource(R.mipmap.icon_bottom1);
        bottomimg2.setImageResource(R.mipmap.icon_bottom2);
        bottomimg3.setImageResource(R.mipmap.icon_bottom3);
        bottomimg4.setImageResource(R.mipmap.icon_bottom4);
        textView1.setTextColor(UiUtil.getColor(R.color.dj_textcolors));
        textView2.setTextColor(UiUtil.getColor(R.color.dj_textcolors));
        textView3.setTextColor(UiUtil.getColor(R.color.dj_textcolors));
        textView4.setTextColor(UiUtil.getColor(R.color.dj_textcolors));
        switch (flag) {
            case 1:
                bottomimg1.setImageResource(R.mipmap.icon_bottom11);
                textView1.setTextColor(UiUtil.getColor(R.color.dj_textcolors_red));
                break;

            case 2:
                bottomimg2.setImageResource(R.mipmap.icon_bottom22);
                textView2.setTextColor(UiUtil.getColor(R.color.dj_textcolors_red));
                break;
            case 3:
                bottomimg3.setImageResource(R.mipmap.icon_bottom33);
                textView3.setTextColor(UiUtil.getColor(R.color.dj_textcolors_red));
                break;
            case 4:
                bottomimg4.setImageResource(R.mipmap.icon_bottom44);
                textView4.setTextColor(UiUtil.getColor(R.color.dj_textcolors_red));
                break;


        }


    }


}
