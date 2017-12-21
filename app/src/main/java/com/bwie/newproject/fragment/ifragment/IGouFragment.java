package com.bwie.newproject.fragment.ifragment;

import com.bwie.newproject.bean.CartBean;

import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/17.
 */

public interface IGouFragment {
    public void showCart(List<CartBean.DataBean> group, List<List<CartBean.DataBean.ListBean>> child);
}
