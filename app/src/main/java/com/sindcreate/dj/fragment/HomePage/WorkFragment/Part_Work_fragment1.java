package com.sindcreate.dj.fragment.HomePage.WorkFragment;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.listviewadapter.WorkListAdapter;
import com.sindcreate.dj.adapter.listviewadapter.ZaiXianListAdapter;
import com.sindcreate.dj.bean.Datebean.AcceptData;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Double on 2018/6/4.
 */

public class Part_Work_fragment1 extends Fragment {
    @BindView(R.id.id_sanhui_list)
    ListView listView;
    WorkListAdapter adapter;
    ArrayList<AcceptData> datalist=new ArrayList<>();
    @BindView(R.id.id_title_text)
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_work_list,container,false);
        ButterKnife.bind(this,view);
        AcceptData databean=new AcceptData();
textView.setText("工作任务");
        datalist.add(databean);
        datalist.add(databean);
        datalist.add(databean);
        adapter=new WorkListAdapter(getContext(),datalist);
        listView.setAdapter(adapter);
        View view1=inflater.inflate(R.layout.item_nomore,container,false);
        listView.addFooterView(view1);


        return view;
    }

    @OnClick({R.id.id_title_back})
    public  void  goback(View v){
        Message msg=Message.obtain();
        switch (v.getId()){

            case R.id.id_title_back:

                msg.what= MsgNum.MSG_Home;
                Mydata.handler.sendMessage(msg);
                break;

        }

    }
}
