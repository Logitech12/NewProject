package com.bwie.newproject.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.newproject.R;
import com.bwie.newproject.bean.ProductBean;

import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/13.
 * 分类右适配器
 */

public class RightAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ProductBean.DataBean> list;
    private BomAdapter bomAdapter;

    public RightAdapter(Context context, List<ProductBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.right_top, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        ProductBean.DataBean dataBean = list.get(position);
        holder1.tv.setText(dataBean.getName());
        holder1.rv.setLayoutManager(new GridLayoutManager(context,3));
        List<ProductBean.DataBean.ListBean> list = dataBean.getList();
        bomAdapter = new BomAdapter(context,list);
        holder1.rv.setAdapter(bomAdapter);
        bomAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (list== null) {
            return 0;
        }
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        RecyclerView rv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.top_name);
            rv = itemView.findViewById(R.id.top_rv);
        }
    }
}
