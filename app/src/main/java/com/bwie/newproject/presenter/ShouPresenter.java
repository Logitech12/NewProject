package com.bwie.newproject.presenter;

import com.bwie.newproject.bean.GridBean;
import com.bwie.newproject.bean.ShouBean;
import com.bwie.newproject.fragment.ifragment.IShouFragment;
import com.bwie.newproject.model.imodel.IShouModel;
import com.bwie.newproject.model.ShouModel;
import com.bwie.newproject.net.OnNetListener;

/**
 * Created by 乔晓慧 on 2017/12/13.
 * 首页
 */

public class ShouPresenter {
    private IShouModel iShouModel;
    private IShouFragment iShouFragment;

    public ShouPresenter(IShouFragment iShouFragment) {
        this.iShouFragment = iShouFragment;
        iShouModel = new ShouModel();
    }
    public void setBanner(){
        iShouModel.bannner(new OnNetListener<ShouBean>() {
            @Override
            public void onSuccess(ShouBean shouBean) {
                iShouFragment.getBanner(shouBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
    public void setGrid(){
        iShouModel.grid(new OnNetListener<GridBean>() {
            @Override
            public void onSuccess(GridBean gridBean) {
                iShouFragment.getGrid(gridBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
