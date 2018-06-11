package com.sindcreate.dj.cell.homemaincell;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sindcreate.dj.R;
import com.sindcreate.dj.activity.WebViewActivity;
import com.sindcreate.dj.base.basecell.RVBaseCell;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */
//两学一做
public class Part_Event2 extends RVBaseCell<Entry> {
    public static final int TYPE = 107;
    public Part_Event2(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    ImageView imgv1;
    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view= new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_mainactivity_event,parent,false));
              TextView texttitle= view.getTextView(R.id.id_hometitle_1);
              TextView zhuti=view.getTextView(R.id.id_home_event_zhuti);

          // zhuti.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
        texttitle.setText("主题活动");
        RelativeLayout relativeLayout= view.getRelativeLayout(R.id.cell_homepage_eventpart1);
        RelativeLayout relativeLayout2= view.getRelativeLayout(R.id.cell_homepage_eventpart2);
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydata.context.startActivity(new Intent(Mydata.context, WebViewActivity.class));
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydata.context.startActivity(new Intent(Mydata.context, WebViewActivity.class));
            }
        });

        imgv1=view.getImageView(R.id.id_home_event_img);
        return view;
     //   return null;
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {
        Glide.with(Mydata.context).load("http://p5.img.cctvpic.com/photoworkspace/2017/12/26/2017122616570583080.jpg").into(imgv1);

    }

    @Override
    public void releaseResource() {
        super.releaseResource();
        Log.e("db_test_cell","Partone releaseResource");
    }
}
