package com.bwie.newproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.newproject.R;
import com.bwie.newproject.bean.ProductBean;
import com.bwie.newproject.view.ProductDetailActivity;
import com.bwie.newproject.view.ZiProductActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/13.
 * 分类右下二级适配器
 */

public class BomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ProductBean.DataBean.ListBean> list;

    public BomAdapter(Context context, List<ProductBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.right_bom, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        final ProductBean.DataBean.ListBean listBean = list.get(position);
        holder1.sdv.setImageURI(listBean.getIcon());
        holder1.tv.setText(listBean.getName());
        holder1.sdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ZiProductActivity.class);
                intent.putExtra("pid",list.get(position).getPcid()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list== null) {
            return 0;
        }
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView sdv;
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.bom_iv);
            tv = itemView.findViewById(R.id.bom_tv);
        }
    }
}
