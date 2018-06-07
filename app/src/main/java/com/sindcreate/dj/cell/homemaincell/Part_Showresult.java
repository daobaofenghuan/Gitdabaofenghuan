package com.sindcreate.dj.cell.homemaincell;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.basecell.RVBaseCell;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */

public class Part_Showresult extends RVBaseCell<Entry> {
    public static final int TYPE = 105;
    public Part_Showresult(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view= new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_mainactivity_showresult,parent,false));
              TextView texttitle= view.getTextView(R.id.id_hometitle_2);
              TextView zhuti=view.getTextView(R.id.id_home_event_zhuti);
          // zhuti.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
        texttitle.setText("成果展示");


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
