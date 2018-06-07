package com.sindcreate.dj.fragment;

import android.os.Build;


import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sindcreate.dj.DataMocker;
import com.sindcreate.dj.MainActivity;
import com.sindcreate.dj.R;
import com.sindcreate.dj.base.basecell.Cell;

import com.sindcreate.dj.bean.MsgNum;
import com.sindcreate.dj.cell.defautcell.BannerCell;
import com.sindcreate.dj.cell.homemaincell.Part_Event;
import com.sindcreate.dj.cell.homemaincell.Part_EveryDayHomework;
import com.sindcreate.dj.cell.homemaincell.Part_EveryDayLesson;
import com.sindcreate.dj.cell.homemaincell.Part_Showresult;
import com.sindcreate.dj.cell.homemaincell.Partone;
import com.sindcreate.dj.model.Entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sindcreate.dj.DataMocker.mockData;
import static com.sindcreate.dj.DataMocker.mockMoreData;

/**
 * Created by Double on 2018/5/22.
 */
@RequiresApi(api = Build.VERSION_CODES.M)
public class HomePageFragment extends AbsBaseFragment<Entry> {
    @Override
    public void onRecyclerViewInitialized() {
        //初始化View和数据加载
        //设置刷新进度条颜色
        setColorSchemeResources(R.color.colorAccent);
        loadData();
    }

    @Override
    public void onPullRefresh() {
        //下拉刷新回调
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                setRefreshing(false);
            }
        },2000);
    }

    @Override
    public void onLoadMore() {
        //上拉加载回调
        loadMore();
    }


    private void loadMore(){
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoadMore();
                mBaseAdapter.addAll(getCells(mockMoreData()));

            }
        },10000);
    }

    protected List<Cell> getCells(List<Entry> entries){
        //根据实体生成Cell
        List<Cell> cells = new ArrayList<>();
        cells.add(new BannerCell(Arrays.asList(DataMocker.images)));
        cells.add(new Partone(null));
        cells.add(new Part_EveryDayHomework(null));
        cells.add(new Part_EveryDayLesson(null));
        cells.add(new Part_Event(null));
        cells.add(new Part_Showresult(null));

//        for (int i=0;i<entries.size();i++){
//            Entry entry = entries.get(i);
//            if(entry.type == Entry.TYPE_IMAGE){
//                cells.add(new ImageCell(entry));
//            }else{
//                cells.add(new TextCell(entry));
//            }
//        }
        return cells;
    }



    @Override
    public View addToolbar() {
        View toolbar = LayoutInflater.from(getContext()).inflate(R.layout.title,null);
        

        TextView title=toolbar.findViewById(R.id.id_title_text);
        title.setText("智慧党建");


        MainActivity mainActivity= (MainActivity) getActivity();
        assert mainActivity != null;
        final Handler handler=mainActivity.handler;
        ImageView img=toolbar.findViewById(R.id.title_img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   startActivity(new Intent(getActivity(), MessageActivity.class));
                Message msg=Message.obtain();
                msg.what= MsgNum.MSG_XiaoXI;
                handler.sendMessage(msg);



            }
        });


        return toolbar;
    }

    /**
     * 模拟从服务器取数据
     */
    private void loadData(){
        View loadingView = LayoutInflater.from(getContext()).inflate(R.layout.manu_loading_layout,null);
        mBaseAdapter.showLoading(loadingView);
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mBaseAdapter.hideLoading();
                mBaseAdapter.addAll(getCells(mockData()));
            }
        },2000);
    }
}


