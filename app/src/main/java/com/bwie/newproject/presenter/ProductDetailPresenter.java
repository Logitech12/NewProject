package com.bwie.newproject.presenter;

import com.bwie.newproject.bean.AddCartBean;
import com.bwie.newproject.bean.ProductDetailBean;
import com.bwie.newproject.model.ProductDetailModel;
import com.bwie.newproject.model.imodel.IProductDetailModel;
import com.bwie.newproject.net.OnNetListener;
import com.bwie.newproject.view.iview.IProductDetailActivity;
import com.bwie.newproject.widgth.MyApp;

/**
 * Created by 乔晓慧 on 2017/12/13.
 * 商品详情
 */

public class ProductDetailPresenter {
    private IProductDetailModel iProductDetailModel;
    private IProductDetailActivity iProductDetailActivity;

    public ProductDetailPresenter(IProductDetailActivity iProductDetailActivity) {
        this.iProductDetailActivity = iProductDetailActivity;
        iProductDetailModel = new ProductDetailModel();
    }
    public void setDetail(String pid){
        iProductDetailModel.getDetail(new OnNetListener<ProductDetailBean>() {
            @Override
            public void onSuccess(ProductDetailBean detailBean) {
                iProductDetailActivity.shouDetail(detailBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        },pid);
    }
    public void setAddCart(String cid, String pid){
        iProductDetailModel.getAddCart(cid, pid, new OnNetListener<AddCartBean>() {
            @Override
            public void onSuccess(AddCartBean addCartBean) {
                iProductDetailActivity.shouAddCart(addCartBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
