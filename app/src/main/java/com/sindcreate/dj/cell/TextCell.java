package com.sindcreate.dj.cell;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sindcreate.dj.R;


import com.sindcreate.dj.base.RVBaseCell;
import com.sindcreate.dj.base.RVBaseViewHolder;
import com.sindcreate.dj.model.Entry;


/**
 * Created by Double on 2018/5/22.
 */
public class TextCell extends RVBaseCell<Entry> {
    public static final int TYPE = 0;
    public TextCell(Entry entry) {
        super(entry);
    }

    @Override
    public int getItemType() {
        return TYPE;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_grou1,null));
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {
       // holder.setText(R.id.text_content,mData.content);
    }
}

