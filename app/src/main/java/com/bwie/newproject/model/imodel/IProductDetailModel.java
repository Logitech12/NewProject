package com.bwie.newproject.model.imodel;

import com.bwie.newproject.bean.AddCartBean;
import com.bwie.newproject.bean.ProductDetailBean;
import com.bwie.newproject.net.OnNetListener;

/**
 * Created by 乔晓慧 on 2017/12/13.
 */

public interface IProductDetailModel {
    public void getDetail(OnNetListener<ProductDetailBean> onNetListener,String pid);
    public void getAddCart(String cid, String pid,OnNetListener<AddCartBean> onNetListener);
}
