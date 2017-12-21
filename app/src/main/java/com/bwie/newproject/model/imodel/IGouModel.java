package com.bwie.newproject.model.imodel;

import com.bwie.newproject.bean.AddCartBean;
import com.bwie.newproject.bean.CartBean;
import com.bwie.newproject.net.OnNetListener;

/**
 * Created by 乔晓慧 on 2017/12/17.
 */

public interface IGouModel {
    public void getCart(String cid, String token,OnNetListener<CartBean> onNetListener);
}