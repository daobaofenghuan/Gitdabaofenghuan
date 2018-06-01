package com.sindcreate.dj.cell.maincell;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sindcreate.dj.MainActivity;
import com.sindcreate.dj.R;
import com.sindcreate.dj.base.RVBaseCell;
import com.sindcreate.dj.base.RVBaseViewHolder;

import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */

public class Partone extends RVBaseCell<Entry> {
    public static final int TYPE = 101;
    public Partone(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
RVBaseViewHolder view=    new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_mainactivity_part1,parent,false));
     //   return null;
      // id_home_dangri_img
        final ImageView  img=view.getImageView(R.id. id_home_dangri_img );
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("党日被点击");
                        //   startActivity(new Intent(getActivity(), MessageActivity.class));
                        Message msg=Message.obtain();
                        msg.what=100;
                        Mydata.handler.sendMessage(msg);



                    }
                });

            }
        });

        return view;
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
