package com.shop.goods.service;

import com.shop.goods.dao.GoodsCountsDao;
import com.shop.goods.dao.GoodsDao;
import com.shop.goods.dao.GoodsDescribeDao;
import com.shop.goods.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    @Transactional
    public String post(int sellerId, SendGoods sendGoods) {

        // 准备数据
        Goods goods = sendGoods.getGoods();
        GoodsCounts goodscounts = new GoodsCounts();
        goodscounts.setCounts(0);
        ImageNameAndDescribes imageNameAndDescribes = new ImageNameAndDescribes(0, sendGoods.getImageNameAndDescribes());

        // 验证
        if (sellerId != goods.getSellerid()) return "失败";

        // 更新主键
        goodsDao.insertSelective(goods);
        goodscounts.setId(goods.getId());
        imageNameAndDescribes.setGoodsId(goods.getId());
        goodsCountsDao.insertSelective(goodscounts);
        goodsDescribeDao.insert(imageNameAndDescribes);
        return "插入成功";
    }

    @Transactional
    public String delete(int sellerId, int goodsId) {
        Goods goods = goodsDao.selectByPrimaryKey(goodsId);
        // 验证
        if (sellerId != goods.getSellerid()) return "失败";

        goodsCountsDao.deleteByPrimaryKey(goodsId);
        goodsDescribeDao.delByGoodsId(goodsId);
        goodsDao.deleteByPrimaryKey(goodsId);
        return "成功";
    }

    public String put(int sellerId, SendGoods sendGoods) {

        // 准备数据
        Goods goods = sendGoods.getGoods();
        ImageNameAndDescribes imageNameAndDescribes = new ImageNameAndDescribes(goods.getId(), sendGoods.getImageNameAndDescribes());

        // 验证
        if (sellerId != goods.getSellerid()) return "失败";

        goodsDao.updateByPrimaryKey(goods);
        goodsDescribeDao.updateByGoodsId(imageNameAndDescribes);
        return "修改成功";
    }

    public String putCount(int sellerId, int goodsId, int count) {
        Goods goods = goodsDao.selectByPrimaryKey(goodsId);
        // 验证
        if (sellerId != goods.getSellerid()) return "失败";
        GoodsCounts goodscounts = goodsCountsDao.selectByPrimaryKey(goodsId);
        goodscounts.setCounts(count);
        goodsCountsDao.updateByPrimaryKey(goodscounts);
        return "成功";
    }

    private List<SendGoods> getSendGoods(List<Goods> goods) {
        List<Integer> integers = new ArrayList<>();
        for (Goods goods1 : goods) {
            integers.add(goods1.getId());
        }
        List<ImageNameAndDescribes> byGoodsId = goodsDescribeDao.findByGoodsId(integers);
        List<SendGoods> sendGoods = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {
            sendGoods.add(new SendGoods(goods.get(i), byGoodsId.get(i).getImageNameAndDescribes()));
        }
        return sendGoods;
    }

    public List<SendGoods> get(int pageBegin, int perpage) {
        List<Goods> goods = goodsDao.selectByPage(pageBegin, perpage);
        return getSendGoods(goods);
    }

    public List<SendGoods> getByCategory(String category, int pageBegin, int perpage) {
        List<Goods> goods = goodsDao.selectByPageAndCategory(category, pageBegin, perpage);
        return getSendGoods(goods);
    }

    public List<SendGoods> getBySeller(int sellerId, int pageBegin, int perpage) {
        List<Goods> goods = goodsDao.selectBySellerId(sellerId, pageBegin, perpage);
        return getSendGoods(goods);
    }
}
