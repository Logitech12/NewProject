package com.bwie.newproject.presenter;

import com.bwie.newproject.bean.ZiProduct;
import com.bwie.newproject.model.ZiProductModel;
import com.bwie.newproject.model.imodel.IZiProductModel;
import com.bwie.newproject.net.OnNetListener;
import com.bwie.newproject.view.iview.IZiProductActivity;

/**
 * Created by 乔晓慧 on 2017/12/14.
 * 子条目
 */

public class ZiProductPresenter {
    private IZiProductModel iZiProductModel;
    private IZiProductActivity iZiProductActivity;

    public ZiProductPresenter(IZiProductActivity iZiProductActivity) {
        this.iZiProductActivity = iZiProductActivity;
        iZiProductModel = new ZiProductModel();
    }
    public void setZiProduct(String cid){
        iZiProductModel.getZiProduct(new OnNetListener<ZiProduct>() {
            @Override
            public void onSuccess(ZiProduct ziProduct) {
                iZiProductActivity.shouZIProduct(ziProduct);
            }

            @Override
            public void onFailure(Exception e) {

            }
        }, cid);
    }
}
