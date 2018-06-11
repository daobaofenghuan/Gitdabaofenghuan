package com.sindcreate.dj.base;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sindcreate.dj.R;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;

import butterknife.OnClick;

/**
 * Created by Double on 2018/6/7.
 */

public class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @OnClick({R.id.id_title_back,R.id.title_img})
    public  void  goback(View v){
        Message msg=Message.obtain();
        switch (v.getId()){

            case R.id.id_title_back:

                msg.what= MsgNum.MSG_Home;
                Mydata.handler.sendMessage(msg);
               break;
            case R.id.title_img:

                msg.what= MsgNum.MSG_XiaoXI;
                Mydata.handler.sendMessage(msg);
                break;

        }

    }
}
