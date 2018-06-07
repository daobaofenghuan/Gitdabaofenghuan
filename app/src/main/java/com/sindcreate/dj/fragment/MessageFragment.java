package com.sindcreate.dj.fragment;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.base.basecell.Cell;
import com.sindcreate.dj.cell.defautcell.ImageCell;
import com.sindcreate.dj.cell.defautcell.TextCell;
import com.sindcreate.dj.cell.messagecell.Part_message;
import com.sindcreate.dj.cell.messagecell.Part_title;
import com.sindcreate.dj.model.Entry;

import java.util.ArrayList;
import java.util.List;

import static com.sindcreate.dj.DataMocker.mockMoreDatamessage;

/**
 * Created by Double on 2018/5/22.
 */
@RequiresApi(api = Build.VERSION_CODES.M)
public class MessageFragment extends AbsBaseFragment<Entry> {
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
                mBaseAdapter.addAll(getCells(mockMoreDatamessage()));

            }
        },10000);
    }

    protected List<Cell> getCells(List<Entry> entries){
        //根据实体生成Cell
        List<Cell> cells = new ArrayList<>();


        cells.add(new Part_title(null));


        for (int i=0;i<entries.size();i++){
            Entry entry = entries.get(i);
            if(entry.type == Entry.TYPE_IMAGE){
               cells.add(new ImageCell(entry));
            }if(entry.type==Entry.TYPE_MESSAGE){
                cells.add(new Part_message(entry));
                System.out.println("消息添加成功");
            }

            else{
               cells.add(new TextCell(entry));
           }
        }
        return cells;
    }



    @Override
    public View addToolbar() {
        View toolbar = LayoutInflater.from(getContext()).inflate(R.layout.title,null);
        TextView title=toolbar.findViewById(R.id.id_title_text);
        title.setText("消息");


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
                mBaseAdapter.addAll(getCells(mockMoreDatamessage()));
            }
        },2000);
    }
}


