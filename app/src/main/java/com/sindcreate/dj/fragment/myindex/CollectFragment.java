package com.sindcreate.dj.fragment.myindex;


import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.activity.MyCollectAndFoot;
import com.sindcreate.dj.activity.MyDangMoney;
import com.sindcreate.dj.adapter.listviewadapter.CollectListAdapter;
import com.sindcreate.dj.base.BaseFragment;
import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.bean.Mydata;
import com.sindcreate.dj.model.Entry;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectFragment extends Fragment {
    private Button but, but2;
    private TextView textView;
    CollectListAdapter adapter;
    List<Entry> list=new ArrayList();
     @BindView(R.id.id_mycollect_list)
    ListView listv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_collect, container, false);
        ButterKnife.bind(this, view);

        Entry entry=new Entry();
        list.add(entry);
        list.add(entry);
        list.add(entry);
        list.add(entry);
         adapter=new CollectListAdapter(getContext(),list);
        listv.setAdapter(adapter);

        return view;

    }




}
