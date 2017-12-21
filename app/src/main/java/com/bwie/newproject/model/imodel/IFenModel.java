package com.bwie.newproject.model.imodel;

import com.bwie.newproject.bean.GridBean;
import com.bwie.newproject.bean.ProductBean;
import com.bwie.newproject.net.OnNetListener;

/**
 * Created by 乔晓慧 on 2017/12/13.
 */

public interface IFenModel {
    public void getList(OnNetListener<GridBean> onNetListener);
    public void getProduct(OnNetListener<ProductBean> onNetListener,String cid);
}
