package com.bwie.newproject.model;

import com.bwie.newproject.bean.ZiProduct;
import com.bwie.newproject.model.imodel.IZiProductModel;
import com.bwie.newproject.net.OnNetListener;
import com.bwie.newproject.net.RetrofitHelper;
import com.bwie.newproject.net.ServerApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 乔晓慧 on 2017/12/14.
 * 分类右-子条目展示商品信息
 */

public class ZiProductModel implements IZiProductModel {
    @Override
    public void getZiProduct(final OnNetListener<ZiProduct> onNetListener, String pid) {
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.ziproduct(pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ZiProduct>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(ZiProduct ziProduct) {
                        onNetListener.onSuccess(ziProduct);
                    }
                });
    }
}
