package com.sindcreate.dj.fragment.ServiceIndex.cell;

import android.annotation.SuppressLint;
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

public class JYXC_Part1 extends RVBaseCell<Entry> {
    public static final int TYPE = 3001;
    public JYXC_Part1(Entry entry){
        super(entry);

    }
    @Override
    public int getItemType() {
        return TYPE;
    }

    @SuppressLint("InflateParams")
    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RVBaseViewHolder view= new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_service_jyxc,parent,false));
            //  TextView texttitle= view.getTextView(R.id.id_hometitle_1);
          //    TextView zhuti=view.getTextView(R.id.id_home_event_zhuti);
          // zhuti.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
       // texttitle.setText("党组活动");

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
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {


    }

    @Override
    public void releaseResource() {
        super.releaseResource();
        Log.e("db_test_cell","Partone releaseResource");
    }
}
