package com.shop.goods.service;

import com.shop.goods.dao.GoodsCountsDao;
import com.shop.goods.dao.GoodsDao;
import com.shop.goods.entity.Goods;
import com.shop.goods.entity.GoodsExample;
import com.shop.goods.entity.Goodscounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    GoodsCountsDao goodsCountsDao;

    // TODO 事务
    public int post(int sellerId, Goods goods) {
        if (sellerId != goods.getSellerid()) return 0;
        Goodscounts goodscounts = new Goodscounts();
        goodscounts.setCounts(0);
        goodsDao.insertSelective(goods);
        goodscounts.setId(goods.getId());
        System.out.println(goodscounts.getId());
        goodsCountsDao.insertSelective(goodscounts);
        return 1;
    }

    public int put(int sellerId, Goods goods) {
        if (sellerId != goods.getSellerid()) return 0;
        Goodscounts goodscounts = new Goodscounts();
        goodscounts.setCounts(0);
        goodscounts.setId(goods.getId());
        return goodsDao.updateByPrimaryKey(goods);
    }

    public List<Goods> get(int pageBegin, int perpage) {
        return goodsDao.selectByPage(pageBegin, perpage);
    }
}
