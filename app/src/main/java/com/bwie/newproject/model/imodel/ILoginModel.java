package com.bwie.newproject.model.imodel;

import com.bwie.newproject.bean.LoginBean;
import com.bwie.newproject.net.OnNetListener;

/**
 * Created by 乔晓慧 on 2017/12/15.
 */

public interface ILoginModel {
    public void getLogin(final OnNetListener<LoginBean> onNetListener, String phone, String pass);
}
