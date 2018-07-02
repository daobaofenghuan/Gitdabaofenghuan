package com.sindcreate.dj.fragment.HomePage;


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

public class Question1start_Fragment extends Fragment {
    private Button but, but2;
    @BindView(R.id.id_question_start)
   TextView StartView;

    @BindView(R.id.id_title_text)
    TextView titletext;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question_1start_xiu, container, false);
        ButterKnife.bind(this, view);


        titletext.setText("学习十九大，共创未来知识测试标题");
        return view;

    }



    @OnClick({R.id.id_question_start,R.id.id_title_back})
    public  void  goback(View v){
        Message msg=Message.obtain();
        switch (v.getId()){


            case R.id.id_question_start:

                msg.what= MsgNum.MSG_Question;
                Mydata.Questionhandler.sendMessage(msg);
                break;
            case R.id.id_title_back:
                getActivity().finish();
                break;
        }

    }


}
