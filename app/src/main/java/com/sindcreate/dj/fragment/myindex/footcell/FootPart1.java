package com.sindcreate.dj.fragment.myindex.footcell;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.listviewadapter.CollectListAdapter;
import com.sindcreate.dj.base.basecell.RVBaseCell;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;
import com.sindcreate.dj.model.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Double on 2018/5/23.
 */

public class FootPart1 extends RVBaseCell<Entry> {
    public static final int TYPE = 4001;
    public FootPart1(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }
    ListView listView;
    CollectListAdapter adapter;
    List<Entry> list=new ArrayList<>();
    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view= new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_my_foot_part1,parent,false));

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
