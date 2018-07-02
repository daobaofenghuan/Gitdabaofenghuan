package com.sindcreate.dj.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.recycleradapter.QuestionAdapter;
import com.sindcreate.dj.bean.Datebean.QSstatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Double on 2018/6/28.
 */
public class MPopupWindows2 extends PopupWindow {
    private QuestionAdapter   adapterlist;
    List<QSstatus> datalist=new ArrayList<>();
    public MPopupWindows2(final Context mContext, View parent, final Activity ac) {

        super(mContext);

        View view = View
                .inflate(mContext, R.layout.fragment_question_2_index, null);
//        view.startAnimation(AnimationUtils.loadAnimation(mContext,
//               R.anim.fade_ins));
        RecyclerView listv =  view
                .findViewById(R.id.question_contain);
//        listv.startAnimation(AnimationUtils.loadAnimation(mContext,
//               R.anim.push_bottom_in_2));

        setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);




        GridLayoutManager manager = new GridLayoutManager(mContext, 8, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        for (int i=0;i<68;i++){
            QSstatus databean=new QSstatus();
            databean.Nub=String.valueOf(i+1);
            if(i<3){
                databean.status=5;
            }
            datalist.add(databean);


        }
        adapterlist = new QuestionAdapter(mContext, datalist);
        listv.setLayoutManager(manager);
        listv.setAdapter(adapterlist);












        setBackgroundDrawable(new BitmapDrawable());
        setFocusable(true);
        setOutsideTouchable(true);
        setContentView(view);
     //   showAtLocation(parent, Gravity.TOP|Gravity.START,0, 0);
        update();



    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
