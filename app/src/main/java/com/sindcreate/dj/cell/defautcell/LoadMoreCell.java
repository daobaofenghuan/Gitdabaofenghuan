package com.sindcreate.dj.cell.defautcell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;
import com.sindcreate.dj.base.basecell.RVSimpleAdapter;
import com.sindcreate.dj.util.Utils;


/**
 * Created by zhouwei on 17/1/23.
 */

public class LoadMoreCell extends RVAbsStateCell{
    public static final int mDefaultHeight = 80;//dp
    public LoadMoreCell(Object o) {
        super(o);
    }

    @Override
    public int getItemType() {
        return RVSimpleAdapter.LOAD_MORE_TYPE;
    }


    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

    }

    @Override
    protected View getDefaultView(Context context) {
        // 设置LoadMore View显示的默认高度
        setHeight(Utils.dpToPx(context,mDefaultHeight));
        return LayoutInflater.from(context).inflate(R.layout.rv_load_more_layout,null);
    }
}
