package com.sindcreate.dj.cell.educell;

/**
 * Created by Double on 2018/5/25.
 */



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

public class Part_theme extends RVBaseCell<Entry> {
    public static final int TYPE = 201;
    public Part_theme(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view= new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_edu_theme,parent,false));
        TextView texttitle= view.getTextView(R.id.id_hometitle_1);
        TextView zhuti=view.getTextView(R.id.id_home_event_zhuti);
        // zhuti.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
        texttitle.setText("主题教育");
        TextView righttext=view.getTextView(R.id.id_item_rtext);
        righttext.setText("查看全部");

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
