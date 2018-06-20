package com.sindcreate.dj.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.listviewadapter.DangFeiListAdapter;
import com.sindcreate.dj.base.BaseActivity;
import com.sindcreate.dj.fragment.ServiceIndex.JYXC_Fragment;
import com.sindcreate.dj.model.Entry;
import com.sindcreate.mylibrary.comm.util.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyDangMoney extends BaseActivity {
@BindView(R.id.id_dangfei_list)
    ListView listView;
DangFeiListAdapter adapter;
List<Entry> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydangfei);
        ButterKnife.bind(this);
        titletext.setText("我的党费");
        StatusBarUtils.setWindowStatusBarColor(MyDangMoney.this, R.color.dj_titalred);
        Entry entry=new Entry();
        list.add(entry);
        list.add(entry);
        list.add(entry);
        list.add(entry);
        adapter=new DangFeiListAdapter(this,list);
        listView.setAdapter(adapter);





    }

}
