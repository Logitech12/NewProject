package com.bwie.newproject.model;

import com.bwie.newproject.bean.AddCartBean;
import com.bwie.newproject.bean.ProductDetailBean;
import com.bwie.newproject.model.imodel.IProductDetailModel;
import com.bwie.newproject.net.OnNetListener;
import com.bwie.newproject.net.RetrofitHelper;
import com.bwie.newproject.net.ServerApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 乔晓慧 on 2017/12/13.
 * 商品详情
 */

public class ProductDetailModel implements IProductDetailModel {
    public void getDetail(final OnNetListener<ProductDetailBean> onNetListener, String pid){
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.detail(pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ProductDetailBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.getMessage();
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(ProductDetailBean detailBean) {
                        onNetListener.onSuccess(detailBean);
                    }
                });
    }
    @Override
    public void getAddCart(String cid, String pid, final OnNetListener<AddCartBean> onNetListener) {
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.addCart(cid,pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AddCartBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(AddCartBean addCartBean) {
                        onNetListener.onSuccess(addCartBean);
                    }
                });
    }
}
