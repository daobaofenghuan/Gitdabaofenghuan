package com.sindcreate.dj.cell.messagecell;

/**
 * Created by Double on 2018/5/25.
 */



import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.basecell.RVBaseCell;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */

public class Part_title extends RVBaseCell<Entry> {
    //警示教育
    public static final int TYPE = 501;

    public Part_title(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view= new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_message_part1,parent,false));
        TextView texttitle= view.getTextView(R.id.id_hometitle_2);
         ImageView imgr=view.getImageView(R.id.home_title_rightimg);
         imgr.setVisibility(View.INVISIBLE);
        texttitle.setText("消息提醒");
        TextView righttext=view.getTextView(R.id.id_item_rtext);
        righttext.setText("");
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
