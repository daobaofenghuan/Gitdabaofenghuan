package com.sindcreate.dj.adapter.recycleradapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sindcreate.dj.R;
import com.sindcreate.dj.bean.Datebean.QSstatus;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/25.
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {
    private Context mContext;
    private List<QSstatus> data;
    private OnClickListener onClickListener;

    private boolean isAll = false;


    public QuestionAdapter(Context mContext, List<QSstatus> data) {
        this.mContext = mContext;
        this.data = data;
    }

    public void setIsAll() {
        isAll = !isAll;
        notifyDataSetChanged();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_question_tishu, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tmNun.setText(data.get(position).Nub);
        int flag=data.get(position).status;
        //0代表错误，1代表正确 3代表未选中 4代表选中 5代表已完成
        holder.rightly.setVisibility(View.GONE);
        holder.wrongly.setVisibility(View.GONE);
        if(flag==5){

            holder.tmNun.setTextColor(mContext.getResources().getColor(R.color.white));
            holder.tmNun.setBackgroundResource(R.drawable.yuanjiaolanlv_3dp);
        }
        if(flag==4){

        //    holder.tmNun.setTextColor(mContext.getResources().getColor(R.color.white));
       //     holder.tmNun.setBackgroundResource(R.drawable.yuanjiaored_3dp);
        }
        if(flag==3){

       holder.rightly.setVisibility(View.GONE);
       holder.wrongly.setVisibility(View.GONE);
        }

        if(flag==1){

               holder.tmNun.setTextColor(mContext.getResources().getColor(R.color.white));
                holder.tmNun.setBackgroundResource(R.drawable.yuanjiaolanlv_3dp);
            holder.rightly.setVisibility(View.VISIBLE);
        }
        if(flag==0){

               holder.tmNun.setTextColor(mContext.getResources().getColor(R.color.white));
                holder.tmNun.setBackgroundResource(R.drawable.yuanjiaored_3dp);
                holder.wrongly.setVisibility(View.VISIBLE);
        }

        holder.tmNun.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                System.out.println("被点击"+position);
             // v.setBackgroundColor(R.color.base_orange);
            }
        });


    }

    @Override
    public int getItemCount() {

            return data.size();


    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.id_question_timushu)
        TextView tmNun;
        @BindView(R.id.id_question2_rightly)
        RelativeLayout rightly;
        @BindView(R.id.id_question2_wrongly)
        RelativeLayout wrongly;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnClickListener {
        void onItemClick(int position);

        void onAddClick();

        void onDeleteClick();
    }
}
