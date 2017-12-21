package com.bwie.newproject.model.imodel;

import com.bwie.newproject.bean.RegisterBean;
import com.bwie.newproject.net.OnNetListener;

/**
 * Created by 乔晓慧 on 2017/12/15.
 */

public interface IRegisterModel {
    public void getRegister(final OnNetListener<RegisterBean> onNetListener, String phone, String pass);
}
