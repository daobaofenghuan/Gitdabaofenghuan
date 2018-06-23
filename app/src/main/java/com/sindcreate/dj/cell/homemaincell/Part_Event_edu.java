package com.sindcreate.dj.cell.homemaincell;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Message;
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
import com.sindcreate.dj.activity.WebViewActivity2;
import com.sindcreate.dj.base.basecell.RVBaseCell;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.model.Entry;

/**
 * Created by Double on 2018/5/23.
 */
//两学一做
public class Part_Event_edu extends RVBaseCell<Entry> {
    public static final int TYPE = 1004;
    public Part_Event_edu(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }
    ImageView imgv1,imgv2;
    TextView text1,text2;
    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view= new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_mainactivity_event,parent,false));
              TextView texttitle= view.getTextView(R.id.id_hometitle_1);
              TextView zhuti=view.getTextView(R.id.id_home_event_zhuti);

          // zhuti.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
        texttitle.setText("专题教育");
        RelativeLayout relativeLayout= view.getRelativeLayout(R.id.cell_homepage_eventpart1);
        RelativeLayout relativeLayout2= view.getRelativeLayout(R.id.cell_homepage_eventpart2);
        TextView more=view.getTextView(R.id.id_item_rtext);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg=Message.obtain();
              msg.what=  MsgNum.MSG_edu;
              Mydata.handler.sendMessage(msg);

            }
        });
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydata.context.startActivity(new Intent(Mydata.context, WebViewActivity2.class));
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydata.context.startActivity(new Intent(Mydata.context, WebViewActivity2.class));
            }
        });
        imgv1=view.getImageView(R.id.id_home_event_img);
        imgv2=view.getImageView(R.id.id_home_event2_img);
        text1=view.getTextView(R.id.id_home_event_zhuti);
        text2=view.getTextView(R.id.id_home_event2_zhuti);
        return view;
     //   return null;
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {
        Glide.with(Mydata.context).load("http://p4.img.cctvpic.com/fmspic/vms/image/2017/09/22/VSET_1506063865871130.jpg").into(imgv1);
        Glide.with(Mydata.context).load("http://p2.img.cctvpic.com/fmspic/vms/image/2017/04/21/VSET_1492776712003067.jpg").into(imgv2);
        text1.setText("两学一做·榜样");
        text2.setText("《中国共产党廉洁自律准则》解读");
    }

    @Override
    public void releaseResource() {
        super.releaseResource();
        Log.e("db_test_cell","Partone releaseResource");
    }
}
