package com.sindcreate.dj.cell.homemaincell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.RVBaseCell;
import com.sindcreate.dj.base.RVBaseViewHolder;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */

public class Part_EveryDayHomework  extends RVBaseCell<Entry>{
    //每日一题
    public static final int TYPE = 102;

 public   Part_EveryDayHomework (Entry entry){

     super(entry);
 }

    @Override
    public int getItemType() {
        return TYPE;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       RVBaseViewHolder view =new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_mainactivity_homework,parent,false));
     TextView textView= view.getTextView(R.id.id_item_rtext);
        final RelativeLayout relativeLayout=view.getRelativeLayout(R.id.id_home_tily);
     textView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if(relativeLayout.getVisibility()==View.VISIBLE)
             {relativeLayout.setVisibility(View.GONE);}else {
                 relativeLayout.setVisibility(View.VISIBLE);
             }

         }
     });
        return view;
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

    }
}
