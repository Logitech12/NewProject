package com.bwie.newproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bwie.newproject.R;
import com.bwie.newproject.adapter.CartAdapter;
import com.bwie.newproject.bean.CartBean;
import com.bwie.newproject.eventbusevent.MessageEvent;
import com.bwie.newproject.eventbusevent.PriceAndCountEvent;
import com.bwie.newproject.fragment.ifragment.IGouFragment;
import com.bwie.newproject.presenter.GouPresenter;
import com.bwie.newproject.widgth.MyApp;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/12.
 * 购物车
 */

public class GouFragment extends Fragment implements IGouFragment {
    private ExpandableListView elv;
    private CheckBox checkAll;
    /**
     * 合计:￥
     */
    private TextView price;
    /**
     * 结算(0)
     */
    private TextView number;
    private GouPresenter gouPresenter;
    private CartAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.gou, null);
        initView(view);
        gouPresenter = new GouPresenter(this);
        int id = MyApp.sp.getInt("uid", 0);
        String token = MyApp.sp.getString("token", "");
        gouPresenter.setCart(id+"",token);
        EventBus.getDefault().register(this);
        return view;
    }

    private void initView(View view) {
        elv = view.findViewById(R.id.elv);
        checkAll = view.findViewById(R.id.checkAll);
        price =  view.findViewById(R.id.price);
        number = view.findViewById(R.id.number);
        checkAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.changeAllListCbState(checkAll.isChecked());
            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void showCart(List<CartBean.DataBean> group, List<List<CartBean.DataBean.ListBean>> child) {
        elv.setGroupIndicator(null);
        adapter = new CartAdapter(getContext(),group,child);
        elv.setAdapter(adapter);
        for (int i = 0; i < group.size(); i++) {
            //默认二级列表展开
            elv.expandGroup(i);
        }
    }
    @Subscribe
    public void onMessageEvent(MessageEvent event){
        checkAll.setChecked(event.isChecked());
    }
    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event) {
        number.setText("结算(" + event.getCount() + ")");
        price.setText(event.getPrice() + "");
    }

}
