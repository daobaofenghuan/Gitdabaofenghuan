package com.sindcreate.dj.adapter.listviewadapter;

/**
 * Created by 大宝 on 2018/1/5.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import com.sindcreate.dj.R;
import com.sindcreate.dj.bean.Datebean.AcceptData;
import com.sindcreate.dj.view.MyCircleImageView;

import java.io.File;
import java.util.ArrayList;

public class SanhuiListAdapter extends BaseAdapter {
    private Context context;
    private View[] itemViews;
    private LayoutInflater mInflater;
    private File cache;
    /**
     *
     */
    public static ArrayList<AcceptData> cf;

    public SanhuiListAdapter(Context context, ArrayList<AcceptData> cf2) {
        this.context = context;
        cf = cf2;
        this.cache = cache;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return cf.size();
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
            view = mInflater.inflate(R.layout.item_listv_sanhui_xiugai, null);
            vh = new ViewHolder(view);

            view.setTag(vh);

        } else {

            view = converView;
            vh = (ViewHolder) view.getTag();

        }





      //  AddressListBean.DataBean item = cf.get(position);
        // vh.im.setImageResource(R.drawable.richeng001);

      //  vh.im.setImageResource(R.mipmap.icon_touxiang);
        // asyncloadImage(vh.im, item.lj);

//        vh.text1.setText(item.getName());
//        vh.text2.setText(item.getChildName()+" •  家长");

 //      vh.text3.setText(null);
        // vh.text2.setText(item.id);
		/*
		 * vh.text3.setText(item.keshi); vh.text4.setText(item.Monery);
		 */


//        RequestOptions options = new RequestOptions()
//                .centerCrop()
//                .placeholder(R.mipmap.head_error)
//                .diskCacheStrategy(DiskCacheStrategy.ALL);
//               Glide.with(context)
//                .load(item.getHeadImgUrl())
//                .apply(options)
//                .into(vh.im);

        return view;
    }

    // 自定义 优化
    class ViewHolder {
        TextView text1, text2, text3, text4;
        MyCircleImageView im;

        public ViewHolder(View view) {

//            im = view.findViewById(R.id.id_groupfragmentr1_img001);
//            text1 = (TextView) view.findViewById(R.id.id_groupfragmentr1_text1);
//            text2 = (TextView) view.findViewById(R.id.id_groupfragmentr1_text2);
//            text3 = (TextView) view.findViewById(R.id.id_groupfragmentr1_text3);
        }
    }






}