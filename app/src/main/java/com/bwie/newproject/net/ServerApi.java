package com.bwie.newproject.net;

import com.bwie.newproject.bean.AddCartBean;
import com.bwie.newproject.bean.CartBean;
import com.bwie.newproject.bean.GridBean;
import com.bwie.newproject.bean.LoginBean;
import com.bwie.newproject.bean.ProductBean;
import com.bwie.newproject.bean.ProductDetailBean;
import com.bwie.newproject.bean.RegisterBean;
import com.bwie.newproject.bean.SearchBean;
import com.bwie.newproject.bean.ShouBean;
import com.bwie.newproject.bean.ZiProduct;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 乔晓慧 on 2017/12/12.
 */

public interface ServerApi {
    @GET(Api.BANNER)
    Observable<ShouBean> shou();//轮播
    @GET(Api.GRID)
    Observable<GridBean> grid();//九宫格+分类左
    @GET(Api.PRODUCT)
    Observable<ProductBean> product(@Query("cid") String cid);//分类右
    @GET(Api.ZIPRODUCT)
    Observable<ZiProduct> ziproduct(@Query("pscid") String cid);//分类右-商品子条目
    @GET(Api.PRODUCTDETAIL)
    Observable<ProductDetailBean> detail(@Query("pid") String pid);//分类右-商品子条目--详情
    @GET(Api.LOGIN)
    Observable<LoginBean> login(@Query("mobile") String phone,@Query("password") String pass);//登录
    @GET(Api.REGIST)
    Observable<RegisterBean> regist(@Query("mobile") String phone, @Query("password") String pass);//注册
    @GET(Api.SEARCH)
    Observable<SearchBean> search(@Query("keywords") String key);//查询商品
    @GET(Api.CART)
    Observable<CartBean> cart(@Query("uid") String uid,@Query("token") String token);//查询购物车
    @GET(Api.ADDCART)
    Observable<AddCartBean> addCart(@Query("uid") String uid, @Query("pid") String pid);//添加购物车
}
