package com.bwie.newproject.net;

/**
 * Created by 乔晓慧 on 2017/12/12.
 */

public class Api {
    /*
    * 登录接口 mobile password      https://www.zhaoapi.cn/user/login
    * 注册接口 mobile password      https://www.zhaoapi.cn/user/reg
    * 上传头像 uid file token       https://www.zhaoapi.cn/file/upload
    * 获取用户信息 id token         https://www.zhaoapi.cn/user/getUserInfo
    * 首页广告（轮播图+京东秒杀+最底部的为你推荐）       https://www.zhaoapi.cn/ad/getAd
    * 返回参数说明
        type：0 跳转到活动页
        type:1 跳转到商品详情页
    * 商品分类接口（此接口用于首页九宫格，和底部页签分类页） https://www.zhaoapi.cn/product/getCatagory
    *返回参数说明
        ishome：1 首页显示分类九宫格
        ishome:0 首页不显示
    *商品子分类接口 cid            https://www.zhaoapi.cn/product/getProductCatagory
    *商品详情 pid                  https://www.zhaoapi.cn/product/getProductDetail
    *   images：顶部图片列表
        detailUrl：上拉加载详情的h5页面
        subhead：副标题
    *当前子分类下的商品列表（分页） pscid          https://www.zhaoapi.cn/product/getProducts
    *
    * 根据关键词搜索商品  keywords      https://www.zhaoapi.cn/product/searchProducts?keywords=笔记本&page=1
    * 查询购物车 uid token        https://www.zhaoapi.cn/product/getCarts
    *
    * 添加购物车 uid pid token  https://www.zhaoapi.cn/product/addCart?source=android&uid=71&pid=1
    */
    public static final String HOST = "https://www.zhaoapi.cn/";
    public static final String BANNER = "ad/getAd?source=android";
    public static final String GRID = "product/getCatagory";
    public static final String PRODUCT = "product/getProductCatagory?source=android";
    public static final String ZIPRODUCT = "product/getProducts?source=android";
    public static final String PRODUCTDETAIL = "product/getProductDetail?source=android";
    public static final String LOGIN = "user/login";
    public static final String REGIST = "user/reg";
    public static final String SEARCH = "product/searchProducts?source=android&page=1";
    public static final String CART = "product/getCarts?source=android";
    public static final String ADDCART = "product/addCart?source=android";
}
