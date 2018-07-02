package com.sindcreate.dj.fragment.HomePage.SanhuiIndex;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.basecell.RVBaseCell;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */

public class Huodong_part3xiu0630 extends RVBaseCell<Entry> {
    public static final int TYPE = 10016;
    int flag1=0;
    int flag2=0;
    int flag3=0;
    public Huodong_part3xiu0630(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view= new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_huodong_part3xiu0630,parent,false));
//        TextView yiduzk =view.getTextView(R.id.id_huodong_p3_ydzk);
//        TextView qdzk =view.getTextView(R.id.id_huodong_p3_qdzk);
//        TextView fkzk =view.getTextView(R.id.id_huodong_p3_fkzk);
//        final TextView yidury=view.getTextView(R.id.id_huodong_yidurenyuan);
//        final TextView qdry=view.getTextView(R.id.id_huodong_qdrenyuan);
//        final TextView fkry=view.getTextView(R.id.id_huodong_fkrenyuan);

//        yiduzk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(flag1%2==0){
//                yidury.setSingleLine(true);}
//                else {
//                yidury.setSingleLine(false);}
//                flag1++;
//            }
//        });
//        qdzk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(flag1%2==0){
//                    qdry.setSingleLine(true);}
//                else {
//                    qdry.setSingleLine(false);}
//                flag1++;
//            }
//        });
//        fkzk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(flag1%2==0){
//                    fkry.setSingleLine(true);}
//                else {
//                    fkry.setSingleLine(false);}
//                flag1++;
//            }
//        });

        return view;
     //   return null;
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {


    }

    @Override
    public void releaseResource() {
        super.releaseResource();
        Log.e("db_test_cell","Partone releaseResource");
    }


}
