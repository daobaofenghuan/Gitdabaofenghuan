package com.sindcreate.dj.base.basecell;

import com.sindcreate.dj.base.basecell.Cell;

/**
 * Created by Double on 2018/5/22.
 */

public  abstract class RVBaseCell<T> implements Cell {

    public RVBaseCell(T t){
        mData = t;
    }
    public T mData;

    protected RVBaseCell() {
    }

    @Override
    public void releaseResource() {
        // do nothing
        // 如果有需要回收的资源，子类自己实现
    }
}

