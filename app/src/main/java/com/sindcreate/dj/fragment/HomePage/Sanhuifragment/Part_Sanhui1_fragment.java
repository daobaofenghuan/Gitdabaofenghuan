package com.sindcreate.dj.fragment.HomePage.Sanhuifragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.activity.HuoDongActivity;
import com.sindcreate.dj.adapter.listviewadapter.SanhuiListAdapter;
import com.sindcreate.dj.bean.Datebean.AcceptData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Double on 2018/6/4.
 */

public class Part_Sanhui1_fragment extends Fragment {
    @BindView(R.id.id_sanhui_list)
    ListView listView;
    SanhuiListAdapter adapter;
    ArrayList<AcceptData> datalist=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_homepage_sanhuiyike_1,container,false);
        ButterKnife.bind(this,view);
        AcceptData databean=new AcceptData();

        datalist.add(databean);
        datalist.add(databean);
        datalist.add(databean);
        adapter=new SanhuiListAdapter(getContext(),datalist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), HuoDongActivity.class));
            }
        });


        return view;
    }
}
