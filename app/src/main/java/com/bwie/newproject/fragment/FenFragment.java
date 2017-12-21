package com.bwie.newproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bwie.newproject.R;
import com.bwie.newproject.adapter.LeftAdapter;
import com.bwie.newproject.adapter.RightAdapter;
import com.bwie.newproject.bean.GridBean;
import com.bwie.newproject.bean.ProductBean;
import com.bwie.newproject.fragment.ifragment.IFenFragment;
import com.bwie.newproject.presenter.FenPresenter;
import com.bwie.newproject.view.SearActivity;

import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/12.
 * 商品分类
 */

public class FenFragment extends Fragment implements IFenFragment {
    private ListView left;
    private RecyclerView right;
    private LeftAdapter adapter;
    private FenPresenter fenPresenter;
    private List<GridBean.DataBean> data;
    private List<ProductBean.DataBean> rightdata;
    private RightAdapter rightAdapter;
    private ImageView iv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fen, null);
        left = view.findViewById(R.id.left);
        right = view.findViewById(R.id.right);
        iv = view.findViewById(R.id.tit_sou);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearActivity.class);
                startActivity(intent);
            }
        });
        fenPresenter = new FenPresenter(this);
        fenPresenter.setList();
        left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                GridBean.DataBean dataBean = data.get(i);
                int cid = dataBean.getCid();
                fenPresenter.setProduct(cid + "");
            }
        });
        right.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        fenPresenter.setProduct(1 + "");
    }
    @Override
    public void showView(GridBean gridBean) {
        data = gridBean.getData();
        adapter = new LeftAdapter(getContext(), data);
        left.setAdapter(adapter);
    }

    @Override
    public void showProduct(ProductBean productBean) {
        rightdata = productBean.getData();
        rightAdapter = new RightAdapter(getContext(), rightdata);
        right.setAdapter(rightAdapter);
        rightAdapter.notifyDataSetChanged();
    }
}
