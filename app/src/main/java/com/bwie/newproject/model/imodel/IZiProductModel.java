package com.bwie.newproject.model.imodel;

import com.bwie.newproject.bean.ZiProduct;
import com.bwie.newproject.net.OnNetListener;

/**
 * Created by 乔晓慧 on 2017/12/14.
 */

public interface IZiProductModel {
    public void getZiProduct(OnNetListener<ZiProduct> onNetListener, String pid);
}
