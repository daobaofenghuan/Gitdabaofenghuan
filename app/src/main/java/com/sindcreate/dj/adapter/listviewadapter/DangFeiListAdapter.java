package com.sindcreate.dj.adapter.listviewadapter;

/**
 * Created by 大宝 on 2018/1/5.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sindcreate.dj.R;
import com.sindcreate.dj.model.Entry;

import java.io.File;
import java.util.List;

public class DangFeiListAdapter extends BaseAdapter {
    private Context context;
    private View[] itemViews;
    private LayoutInflater mInflater;
    private File cache;
    /**
     *
     */
    public static List<Entry> cf;

    public DangFeiListAdapter(Context context, List<Entry> cf2) {
        this.context = context;
        cf = cf2;
        this.cache = cache;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return cf.size() ;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return cf.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup arg2) {
        // TODO Auto-generated method stub
        View view;
        ViewHolder vh;

        if (converView == null) {
            view = mInflater.inflate(R.layout.item_listv_dangfei, null);
            vh = new ViewHolder(view);

            view.setTag(vh);

        } else {

            view = converView;
            vh = (ViewHolder) view.getTag();

        }


        return view;
    }

    // 自定义 优化
    class ViewHolder {
        TextView text1, text2, text3, text4;
        ImageView img1, img2;

        public ViewHolder(View view) {

        }


    }
}