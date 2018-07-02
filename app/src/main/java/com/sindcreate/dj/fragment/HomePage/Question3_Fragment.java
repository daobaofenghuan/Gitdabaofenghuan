package com.sindcreate.dj.fragment.HomePage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.sindcreate.dj.R;
import com.sindcreate.dj.adapter.recycleradapter.QuestionAdapter;
import com.sindcreate.dj.bean.Datebean.QSstatus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Question3_Fragment extends Fragment  {
    private Button but, but2;
    private QuestionAdapter   adapterlist;
    List<QSstatus> datalist=new ArrayList<>();
    @BindView(R.id.recycler_view)
    RecyclerView  listv;
    @BindView(R.id.id_title_back)
    RelativeLayout backly;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question_3, container, false);
        ButterKnife.bind(this, view);

        GridLayoutManager manager = new GridLayoutManager(getContext(), 8, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        for (int i=0;i<68;i++){
            QSstatus databean=new QSstatus();
            databean.Nub=String.valueOf(i+1);
            if(i<3){
                databean.status=1;
            }else {
                databean.status=0;
            }

            datalist.add(databean);


        }
        adapterlist = new QuestionAdapter(getContext(), datalist);
        listv.setLayoutManager(manager);
        listv.setAdapter(adapterlist);


        backly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           getActivity().finish();

            }
        });
        return view;
    }









}
