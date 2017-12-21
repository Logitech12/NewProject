package com.bwie.newproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.newproject.R;
import com.bwie.newproject.bean.SearchBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/15.
 */

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<SearchBean.DataBean> list;

    public SearchAdapter(Context context, List<SearchBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.search, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        SearchBean.DataBean dataBean = list.get(position);
        holder1.sdv.setImageURI(dataBean.getImages());
        holder1.tv1.setText(dataBean.getSubhead());
        holder1.tv2.setText(dataBean.getPrice());
    }

    @Override
    public int getItemCount() {
        if (list == null){
            return 0;
        }
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView sdv;
        TextView tv1;
        TextView tv2;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.se_sdv);
            tv1 = itemView.findViewById(R.id.se_tv1);
            tv2 = itemView.findViewById(R.id.se_price);
        }
    }
}
