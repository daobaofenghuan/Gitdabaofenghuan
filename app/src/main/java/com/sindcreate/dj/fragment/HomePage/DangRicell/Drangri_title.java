package com.sindcreate.dj.fragment.HomePage.DangRicell;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sindcreate.dj.MainActivity;
import com.sindcreate.dj.R;
import com.sindcreate.dj.base.RVBaseCell;
import com.sindcreate.dj.base.RVBaseViewHolder;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */

public class Drangri_title extends RVBaseCell<Entry> {
    public static final int TYPE = 119;
    public Drangri_title(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view= new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.title_show2,parent,false));


        TextView title=view.getTextView(R.id.id_title_text);
        title.setText("党日活动");



        ImageView img=view.getImageView(R.id.title_img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   startActivity(new Intent(getActivity(), MessageActivity.class));
                Message msg=Message.obtain();
                msg.what= MsgNum.MSG_XiaoXI;
               Mydata. handler.sendMessage(msg);



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
