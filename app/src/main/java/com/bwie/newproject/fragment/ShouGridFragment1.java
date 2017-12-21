package com.bwie.newproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.newproject.R;
import com.bwie.newproject.adapter.GridShouAdapter;
import com.bwie.newproject.bean.GridBean;
import com.bwie.newproject.bean.ShouBean;
import com.bwie.newproject.fragment.ifragment.IShouFragment;
import com.bwie.newproject.presenter.ShouPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/16.
 * 首页banner图下的九宫格
 */

public class ShouGridFragment1 extends Fragment implements IShouFragment {
    private RecyclerView rv;
    private ShouPresenter shouPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.item_nav1, null);
        shouPresenter = new ShouPresenter(this);
        shouPresenter.setGrid();
        rv = view.findViewById(R.id.rcv1);
        rv.setLayoutManager(new GridLayoutManager(getContext(),5));
        return view;
    }

    @Override
    public void getBanner(ShouBean shouBean) {

    }

    @Override
    public void getGrid(GridBean gridBean) {
        List<GridBean.DataBean> data = gridBean.getData();
        List<GridBean.DataBean> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            GridBean.DataBean bean = data.get(i);
            list.add(bean);
        }
        GridShouAdapter adapter = new GridShouAdapter(getContext(), gridBean.getData());
        rv.setAdapter(adapter);
    }
}
