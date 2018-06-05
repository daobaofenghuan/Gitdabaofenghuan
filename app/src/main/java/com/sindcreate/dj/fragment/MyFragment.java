package com.sindcreate.dj.fragment;





import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;

import android.widget.TextView;


import com.sindcreate.dj.R;


import butterknife.ButterKnife;

public class MyFragment extends Fragment {
    private Button but, but2;
    private TextView textView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_myfmg, container, false);
        ButterKnife.bind(this, view);


        return view;

    }



}
