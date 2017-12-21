package com.bwie.newproject.presenter;

import com.bwie.newproject.bean.CartBean;
import com.bwie.newproject.fragment.ifragment.IGouFragment;
import com.bwie.newproject.model.GouModel;
import com.bwie.newproject.model.imodel.IGouModel;
import com.bwie.newproject.net.OnNetListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/17.
 * 购物车
 */

public class GouPresenter {
    private IGouModel iGouModel;
    private IGouFragment iGouFragment;

    public GouPresenter(IGouFragment iGouFragment) {
        this.iGouFragment = iGouFragment;
        iGouModel = new GouModel();
    }
    public void setCart(String cid, String token){
        iGouModel.getCart( cid, token,new OnNetListener<CartBean>() {
            @Override
            public void onSuccess(CartBean cartBean) {
                List<CartBean.DataBean> data = cartBean.getData();
                List<List<CartBean.DataBean.ListBean>> child = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    List<CartBean.DataBean.ListBean> list = data.get(i).getList();
                    child.add(list);
                }
                iGouFragment.showCart(data,child);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
