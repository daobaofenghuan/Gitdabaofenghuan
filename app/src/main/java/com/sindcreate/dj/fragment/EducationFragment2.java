package com.sindcreate.dj.fragment;


import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.DynamicHomeAdapter;
import com.sindcreate.dj.base.BaseFragment;
import com.sindcreate.dj.bean.DataMaker;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.cell.educell.Part_Edu_fragment1;
import com.sindcreate.dj.fragment.HomePage.Sanhuifragment.Part_Sanhui1_fragment;
import com.sindcreate.dj.fragment.HomePage.Sanhuifragment.Part_Sanhui2_fragment;
import com.sindcreate.dj.fragment.HomePage.Sanhuifragment.Part_Sanhui3_fragment;
import com.sindcreate.dj.fragment.HomePage.WorkFragment.Part_Work_fragment1;
import com.sindcreate.dj.model.Entry;
import com.sindcreate.dj.util.UiUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Double on 2018/5/22.
 */
public class EducationFragment2 extends Fragment {
    private Button but, but2;
    private TextView textView;
    private List<String> mTabs=new ArrayList<>();
    @BindView(R.id.vp4)
    ViewPager vp;

    @BindView(R.id.tl4)
    TabLayout tl;
    @BindView(R.id.id_title_text)
    TextView titletext;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edu_main, container, false);
        ButterKnife.bind(this, view);
        initTabLayout();
        bindViewPager();

        titletext.setText("教育");
        return view;

    }
    private void initTabLayout() {

        mTabs = new ArrayList<>();
        mTabs.clear();
        mTabs.add(UiUtil.getString(R.string.quanbu));
        mTabs.add(UiUtil.getString(R.string.edu_text1));
        mTabs.add(UiUtil.getString(R.string.edu_text2));
        mTabs.add(UiUtil.getString(R.string.edu_text3));
        mTabs.add(UiUtil.getString(R.string.edu_text4));
        mTabs.add(UiUtil.getString(R.string.edu_text5));

    }

    private void bindViewPager() {

        List<Fragment> fragments = new ArrayList<>();


        fragments.add(new Part_Edu_fragment1());
        fragments.add(new Part_Edu_fragment1());
        fragments.add(new Part_Edu_fragment1());
        fragments.add(new Part_Edu_fragment1());
        fragments.add(new Part_Edu_fragment1());
        fragments.add(new Part_Edu_fragment1());

        DynamicHomeAdapter adapter = new DynamicHomeAdapter(getFragmentManager(), fragments, mTabs);
        vp.setOffscreenPageLimit(6);
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);
        tl.setTabMode(TabLayout.MODE_SCROLLABLE);
        //   reflex(tl);

    }




    @OnClick({R.id.title_img})
    public  void  goback(View v){
        Message msg=Message.obtain();
        switch (v.getId()){


            case R.id.title_img:

                msg.what= MsgNum.MSG_XiaoXI;
                Mydata.handler.sendMessage(msg);
                break;

        }

    }


}