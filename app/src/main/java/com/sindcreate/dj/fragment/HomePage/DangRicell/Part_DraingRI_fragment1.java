package com.sindcreate.dj.fragment.HomePage.DangRicell;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.listviewadapter.DangFeiListAdapter;
import com.sindcreate.dj.adapter.listviewadapter.DangRiListAdapter;
import com.sindcreate.dj.adapter.listviewadapter.WorkListAdapter;
import com.sindcreate.dj.bean.Datebean.AcceptData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Double on 2018/6/4.
 */

public class Part_DraingRI_fragment1 extends Fragment {
    @BindView(R.id.id_sanhui_list)
    ListView listView;
    DangRiListAdapter adapter;
    ArrayList<AcceptData> datalist=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_homepage_zaixian,container,false);
        ButterKnife.bind(this,view);
        AcceptData databean=new AcceptData();

        datalist.add(databean);
        datalist.add(databean);
        datalist.add(databean);
        adapter=new DangRiListAdapter(getContext(),datalist);
        listView.setAdapter(adapter);
        View view1=inflater.inflate(R.layout.item_nomore,container,false);
        listView.addFooterView(view1);


        return view;
    }
}
