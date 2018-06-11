package com.sindcreate.dj.fragment;





import android.os.Bundle;

import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;

import android.widget.TextView;


import com.sindcreate.dj.R;
import com.sindcreate.dj.base.BaseFragment;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyFragment extends Fragment {
    private Button but, but2;
    private TextView textView;
    @BindView(R.id.id_title_text)
    TextView titletext;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_myfmg, container, false);
        ButterKnife.bind(this, view);

        titletext.setText("我的");
        return view;

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
