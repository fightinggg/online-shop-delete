package com.shop.goods.entity;

import java.util.ArrayList;
import java.util.List;


public class SendGoods {

    Goods goods;
    private List<GoodsDescribe> goodsDescribes;

    SendGoods(Goods goods,  List<GoodsDescribe> goodsDescribes) {
        this.goods=goods;
        this.goodsDescribes = goodsDescribes;

    }


    public Goods getGoods() {
        return goods;
    }

    public List<GoodsDescribe> getGoodsDescribes() {
        return goodsDescribes;
    }
}
