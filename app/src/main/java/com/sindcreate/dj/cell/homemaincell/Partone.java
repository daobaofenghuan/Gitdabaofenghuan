package com.sindcreate.dj.cell.homemaincell;

import android.annotation.SuppressLint;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.RVBaseCell;
import com.sindcreate.dj.base.RVBaseViewHolder;

import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.model.Entry;

import butterknife.ButterKnife;

/**
 * Created by Double on 2018/5/23.
 */

public class Partone extends RVBaseCell<Entry> implements View.OnClickListener {
    public static final int TYPE = 101;

    public Partone(Entry entry) {
        super(entry);

    }

    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RVBaseViewHolder view = new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_mainactivity_part1, parent, false));
        final ImageView img2 = view.getImageView(R.id.id_home_dangri_img);
        img2.setOnClickListener(this);
        final ImageView img1 = view.getImageView(R.id.id_home_sanhuiyike_img);
        img1.setOnClickListener(this);
        final ImageView img3 = view.getImageView(R.id.id_home_zaixiandati_img);
        img3.setOnClickListener(this);
        final ImageView img4 = view.getImageView(R.id.id_home_gongzuorenwu_img);
        img4.setOnClickListener(this);

        return view;
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {


    }

    @Override
    public void releaseResource() {
        super.releaseResource();
        Log.e("db_test_cell", "Partone releaseResource");
    }

    @Override
    public void onClick(View v) {
        Message msg = Message.obtain();


        switch (v.getId()) {
            case R.id.id_home_dangri_img:
                System.out.println("党日被点击");
                msg.what = MsgNum.MSG_DangRI;
                break;
            case R.id.id_home_sanhuiyike_img:
                System.out.println("三会被点击");
                msg.what = MsgNum.MSG_SanHui;

                break;
            case R.id.id_home_zaixiandati_img:
                System.out.println("在线被点击");
                msg.what = MsgNum.MSG_ZAIXIANKAOSHI;
                break;
            case R.id.id_home_gongzuorenwu_img:
                System.out.println("工作被点击");
                msg.what=MsgNum.MSG_Work;
                break;

        }
        Mydata.handler.sendMessage(msg);
    }
}
