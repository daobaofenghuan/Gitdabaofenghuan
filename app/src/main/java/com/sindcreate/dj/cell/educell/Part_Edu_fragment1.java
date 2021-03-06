package com.sindcreate.dj.cell.educell;

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
import com.sindcreate.dj.activity.WebViewActivity;
import com.sindcreate.dj.adapter.listviewadapter.EduListAdapter;
import com.sindcreate.dj.adapter.listviewadapter.ZaiXianListAdapter;
import com.sindcreate.dj.bean.DataMaker;
import com.sindcreate.dj.bean.Datebean.AcceptData;
import com.sindcreate.dj.model.Entry;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Double on 2018/6/4.
 */

public class Part_Edu_fragment1 extends Fragment {
    @BindView(R.id.id_sanhui_list)
    ListView listView;
    EduListAdapter adapter;
    ArrayList<AcceptData> datalist=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.fragment_homepage_zaixian,container,false);
        ButterKnife.bind(this,view);
     List<Entry> listdata=  DataMaker.MakeHomeData();
        System.out.println("数据大小为"+listdata.size());
//        AcceptData databean=new AcceptData();
//
//        datalist.add(databean);
//        datalist.add(databean);
//        datalist.add(databean);
        adapter=new EduListAdapter(getContext(),listdata);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), WebViewActivity.class));
            }
        });


        return view;
    }
}
