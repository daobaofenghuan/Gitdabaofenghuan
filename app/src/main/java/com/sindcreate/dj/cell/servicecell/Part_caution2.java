package com.sindcreate.dj.cell.servicecell;

/**
 * Created by Double on 2018/5/25.
 */



import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.activity.ApplyForHelpActivity;
import com.sindcreate.dj.base.basecell.RVBaseCell;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */

public class Part_caution2 extends RVBaseCell<Entry> {
    //警示教育
    public static final int TYPE = 302;

    public Part_caution2(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view= new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_service_cedu,parent,false));
        TextView texttitle= view.getTextView(R.id.id_hometitle_1);

        texttitle.setText("政策法规");
        TextView textView=view.getTextView(R.id.id_sevice_shenqing);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydata.context.startActivity(new Intent(Mydata.context, ApplyForHelpActivity.class));

            }
        });




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
