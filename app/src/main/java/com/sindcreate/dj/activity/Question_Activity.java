package com.sindcreate.dj.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.sindcreate.dj.R;

import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.fragment.HomePage.Question1start_Fragment;


import com.sindcreate.dj.fragment.HomePage.Question2_Fragment;
import com.sindcreate.dj.fragment.HomePage.Question3_Fragment;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;
import static com.sindcreate.dj.bean.MsgNum.*;
import butterknife.ButterKnife;

public class Question_Activity extends AppCompatActivity {
Question1start_Fragment fragment;
Question2_Fragment fragment2;
Question3_Fragment fragment3;
@SuppressLint("HandlerLeak")
private Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction=   fragmentManager.beginTransaction();
        transaction.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
 switch (msg.what){
     case  MSG_Question:
            fragment2=new Question2_Fragment();
       transaction.replace(R.id.contain_basefg,fragment2).commit();
       break;
     case  MSG_Question_Result:
         System.out.println("替换发生");
         fragment3=new Question3_Fragment();
         transaction.replace(R.id.contain_basefg,fragment3).commit();

        break;


 }

    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_fragment);
        ButterKnife.bind(this);
        Mydata.Questionhandler=handler;
        StatusBarUtils.setWindowStatusBarColor(Question_Activity.this, R.color.dj_titalred);

        FragmentManager fragmentManager=getSupportFragmentManager();
         android.support.v4.app.FragmentTransaction transaction=   fragmentManager.beginTransaction();
       transaction.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_ENTER_MASK);
        fragment=new Question1start_Fragment();
        transaction.  replace(R.id.contain_basefg,fragment).commit();





    }

}
