package com.sindcreate.dj.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sindcreate.dj.R;
import com.sindcreate.dj.view.MyCircleImageView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/25.
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {
    private Context mContext;
    private List<String> data;
    private OnClickListener onClickListener;

    private boolean isAll = false;


    public QuestionAdapter(Context mContext, List<String> data) {
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

        holder.tmNun.setText(data.get(position));
        if(position<3){
            holder.tmNun.setBackgroundResource(R.color.dj_timuok);
            holder.tmNun.setTextColor(mContext.getResources().getColor(R.color.white));
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
