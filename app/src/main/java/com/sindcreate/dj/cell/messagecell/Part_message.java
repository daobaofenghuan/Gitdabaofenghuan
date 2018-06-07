package com.sindcreate.dj.cell.messagecell;

/**
 * Created by Double on 2018/5/25.
 */



import android.annotation.SuppressLint;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.basecell.RVBaseCell;
import com.sindcreate.dj.base.basecell.RVBaseViewHolder;
import com.sindcreate.dj.model.Entry;



/**
 * Created by Double on 2018/5/23.
 */

public class Part_message extends RVBaseCell<Entry> {
    //警示教育
    public static final int TYPE = 502;
    RelativeLayout dui;
    public Part_message(Entry entry){
        super(entry);


    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view= new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_message_part1_1,parent,false));


       RelativeLayout rydown=view.getRelativeLayout(R.id.id_message_rlydown);
       // ImageView down=view.getImageView(R.id.id_message_icondown);
        final LinearLayout relativeLayout=view.getLinearLayout(R.id.id_message_nr);
        relativeLayout.setVisibility(View.GONE);



        rydown.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(relativeLayout.getVisibility()==View.VISIBLE)
                 {relativeLayout.setVisibility(View.GONE);}else {
                     relativeLayout.setVisibility(View.VISIBLE);
                 }
             }
         });

        return view;
        //   return null;
    }

    @Override
    public void onBindViewHolder(final RVBaseViewHolder holder, int position) {
        if(mData.flag1){
            System.out.println("阅读过了");
           new Handler().postDelayed(new Runnable() {
               @Override
               public void run() {
                   holder.getRelativeLayout(R.id.id_message_iconright).setVisibility(View.VISIBLE);
                   //holder.dui.setVisibility(View.VISIBLE);
               }
           },300);
          }else {
            System.out.println("没阅读过");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    holder.getRelativeLayout(R.id.id_message_iconright).setVisibility(View.INVISIBLE);
                }
            },300);



        }

    }

    @Override
    public void releaseResource() {
        super.releaseResource();
        Log.e("db_test_cell","Partone releaseResource");
    }
}
