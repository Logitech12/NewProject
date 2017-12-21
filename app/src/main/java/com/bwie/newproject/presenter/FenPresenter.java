package com.bwie.newproject.presenter;

import com.bwie.newproject.bean.GridBean;
import com.bwie.newproject.bean.ProductBean;
import com.bwie.newproject.fragment.ifragment.IFenFragment;
import com.bwie.newproject.model.FenModel;
import com.bwie.newproject.model.imodel.IFenModel;
import com.bwie.newproject.net.OnNetListener;

/**
 * Created by 乔晓慧 on 2017/12/13.
 * 分类
 */

public class FenPresenter {
    private IFenModel iFenModel;
    private IFenFragment iFenFragment;

    public FenPresenter(IFenFragment iFenFragment) {
        this.iFenFragment = iFenFragment;
        iFenModel = new FenModel();
    }
    public void setList(){
        iFenModel.getList(new OnNetListener<GridBean>() {
            @Override
            public void onSuccess(GridBean gridBean) {
                iFenFragment.showView(gridBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
    public void setProduct(String cid){
        iFenModel.getProduct(new OnNetListener<ProductBean>() {
            @Override
            public void onSuccess(ProductBean productBean) {
                iFenFragment.showProduct(productBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        },cid);
    }
}
