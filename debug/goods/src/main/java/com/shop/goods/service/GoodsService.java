package com.shop.goods.service;

import com.shop.goods.dao.GoodsCountsDao;
import com.shop.goods.dao.GoodsDao;
import com.shop.goods.dao.GoodsDescribeDao;
import com.shop.goods.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    GoodsCountsDao goodsCountsDao;
    @Autowired
    GoodsDescribeDao goodsDescribeDao;

    // TODO 事务
    public int post(int sellerId, SendGoods sendgoods) {

        // 准备数据
        Goods goods = sendgoods.getGoods();
        GoodsDescribe goodsDescribe = sendgoods.getGoodsDescribe();
        List<URLState> urlStates = sendgoods.getGoodsDescribes();
        Goodscounts goodscounts = new Goodscounts();
        goodscounts.setCounts(0);

        // 验证
        if (sellerId != goods.getSellerid()) return 0;

        // 更新主键
        goodsDao.insertSelective(goods);
        goodsDescribe.setId(goods.getId());
        for(URLState urlState: urlStates) urlState.setGoodsid(goods.getId());

        goodscounts.setId(goods.getId());

        goodsCountsDao.insertSelective(goodscounts);
        return 1;
    }

    public int put(int sellerId, SendGoods goods) {
        if (sellerId != goods.getSellerid()) return 0;
        Goodscounts goodscounts = new Goodscounts();
        goodscounts.setCounts(0);
        goodscounts.setId(goods.getId());
        return goodsDao.updateByPrimaryKey(goods);
    }

    public List<Goods> get(int pageBegin, int perpage) {
        return goodsDao.selectByPage(pageBegin, perpage);
    }

    public List<Goods> getByCategory(String category,int pageBegin,int perpage){
        return goodsDao.selectByPageAndCategory(category,pageBegin,perpage);
    }

    public int delete(int sellerId, int goodsId) {
    }

    public Object sellerGet(int sellerId, int goodsId) {
    }
}
