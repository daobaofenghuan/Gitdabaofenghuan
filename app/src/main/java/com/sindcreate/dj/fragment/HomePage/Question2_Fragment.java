package com.sindcreate.dj.fragment.HomePage;


import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.recycleradapter.QuestionAdapter;
import com.sindcreate.dj.bean.Datebean.QSstatus;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.view.MPopupWindows;
import com.sindcreate.dj.view.MPopupWindows2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Question2_Fragment extends Fragment  implements CompoundButton.OnClickListener{
    private Button but, but2;
    private QuestionAdapter   adapterlist;
    List<QSstatus> datalist=new ArrayList<>();
//    @BindView(R.id.id_question_start)
//  TextView StartView;
    @BindView(R.id.id_question_showtmly)
RelativeLayout showly;

//    @BindView(R.id.question_contain)
//    RecyclerView  listv;
    @BindView(R.id.id_question2_timu)
   TextView timutext;



    @BindView(R.id.id_checkbox_A)
    CheckBox box1;
    @BindView(R.id.id_checkbox_B)
    CheckBox box2;
    @BindView(R.id.id_checkbox_C)
    CheckBox box3;
    @BindView(R.id.id_checkbox_D)
    CheckBox box4;
    @BindView(R.id.id_checkbox_E)
    CheckBox box5;
    @BindView(R.id.id_checkbox_F)
    CheckBox box6;
//    @BindView(R.id.id_checkbox_)
//    CheckBox box7;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question_2, container, false);
        ButterKnife.bind(this, view);
    //   timutext.getText();
        String str="1. 我国已由高速增长阶段转向（ ）阶段。 <font color='#888888'> （单选题，1分）</font>";
        timutext.setTextSize(13);
        timutext.setText(Html.fromHtml(str));



//        GridLayoutManager manager = new GridLayoutManager(getContext(), 8, LinearLayoutManager.VERTICAL, false) {
//            @Override
//            public boolean canScrollVertically() {
//                return false;
//            }
//        };
//        for (int i=0;i<68;i++){
//            QSstatus databean=new QSstatus();
//            databean.Nub=String.valueOf(i+1);
//            if(i<3){
//                databean.status=5;
//            }
//            datalist.add(databean);
//
//
//        }
//        adapterlist = new QuestionAdapter(getContext(), datalist);
//        listv.setLayoutManager(manager);
//        listv.setAdapter(adapterlist);
        return view;

    }



    @OnClick({R.id.id_title_back,R.id.id_question2_timu,R.id.id_question_showtmly,R.id.id_checkbox_A,R.id.id_checkbox_B,R.id.id_checkbox_C,R.id.id_checkbox_D,R.id.id_checkbox_E,R.id.id_checkbox_F,R.id.id_question_next})
    public  void  goback(View v){
        Message msg=Message.obtain();
        switch (v.getId()){


            case R.id.id_question2_timu:

                msg.what= MsgNum.MSG_Question;
                Mydata.Questionhandler.sendMessage(msg);
                break;
            case R.id.id_question_showtmly:
//                if(listv.getVisibility()==View.VISIBLE){
//                    listv.setVisibility(View.GONE);
//
//                }else {
//                    listv.setVisibility(View.VISIBLE);
//                }
                MPopupWindows2 mPopupWindows = new MPopupWindows2(getContext(), showly, getActivity());
                mPopupWindows.showAsDropDown(showly,0,0);
                break;
            case R.id.id_checkbox_A:
                selectcheckbox();
                box1.setChecked(true);
                break;

            case R.id.id_checkbox_B:
                selectcheckbox();
                box2.setChecked(true);
                break;
            case R.id.id_checkbox_C:
                selectcheckbox();
                box3.setChecked(true);
                break;
            case R.id.id_checkbox_D:
                selectcheckbox();
                box4.setChecked(true);
                break;
            case R.id.id_checkbox_E:
                selectcheckbox();
                box5.setChecked(true);
                break;
            case R.id.id_checkbox_F:
                selectcheckbox();
                box6.setChecked(true);
                break;

            case R.id.id_title_back:
                getActivity().finish();
                break;
            case R.id.id_question_next:

                msg.what=MsgNum.MSG_Question_Result;
                Mydata.Questionhandler.sendMessage(msg);
                break;
        }

    }


   void selectcheckbox( ){
        box1.setChecked(false);
       box2.setChecked(false);
       box3.setChecked(false);
       box4.setChecked(false);
       box5.setChecked(false);
       box6.setChecked(false);




   }




    @Override
    public void onClick(View v) {

    }


}
