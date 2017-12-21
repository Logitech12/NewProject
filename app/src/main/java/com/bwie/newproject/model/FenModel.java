package com.bwie.newproject.model;

import com.bwie.newproject.bean.GridBean;
import com.bwie.newproject.bean.ProductBean;
import com.bwie.newproject.model.imodel.IFenModel;
import com.bwie.newproject.net.OnNetListener;
import com.bwie.newproject.net.RetrofitHelper;
import com.bwie.newproject.net.ServerApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 乔晓慧 on 2017/12/13.
 * 分类
 */

public class FenModel implements IFenModel {
    //左侧
    @Override
    public void getList(final OnNetListener<GridBean> onNetListener) {
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.grid()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GridBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(GridBean gridBean) {
                        onNetListener.onSuccess(gridBean);
                    }
                });
    }

    //右侧
    @Override
    public void getProduct(final OnNetListener<ProductBean> onNetListener, String cid) {
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.product(cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ProductBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.getMessage();
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(ProductBean productBean) {
                        onNetListener.onSuccess(productBean);
                    }
                });
    }
}
