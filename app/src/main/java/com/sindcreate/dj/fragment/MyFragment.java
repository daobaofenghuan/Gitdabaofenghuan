package com.sindcreate.dj.fragment;





import android.content.Intent;
import android.os.Bundle;

import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;

import android.widget.RelativeLayout;
import android.widget.TextView;


import com.sindcreate.dj.R;
import com.sindcreate.dj.activity.Login_Activity;
import com.sindcreate.dj.activity.MyDangMoney;
import com.sindcreate.dj.base.BaseFragment;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyFragment extends Fragment {
    private Button but, but2;
    private TextView textView;
    @BindView(R.id.id_my_mydangfeily)
    RelativeLayout mydangfei;
    @BindView(R.id.id_title_text)
    TextView titletext;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_myfmg2, container, false);
        ButterKnife.bind(this, view);

        titletext.setText("我的");
        return view;

    }


    @OnClick({R.id.title_img,R.id.id_my_mydangfeily})
    public  void  goback(View v){
        Message msg=Message.obtain();
        switch (v.getId()){


            case R.id.title_img:

                msg.what= MsgNum.MSG_XiaoXI;
                Mydata.handler.sendMessage(msg);
                break;
            case R.id.id_my_mydangfeily:
                getActivity().startActivity(new Intent(getContext(), MyDangMoney.class));;
                break;
        }

    }


}
