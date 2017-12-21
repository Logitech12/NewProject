package com.bwie.newproject.eventbusevent;

/**
 * Created by 乔晓慧 on 2017/12/18.
 * 用来存储价格和数量
 */

public class PriceAndCountEvent {
    private int price;
    private int count;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
