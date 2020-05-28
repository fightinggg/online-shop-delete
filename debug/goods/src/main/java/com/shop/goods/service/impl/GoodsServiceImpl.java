package com.shop.goods.service.impl;

import com.shop.common.MyUtils;
import com.shop.common.exception.FallbackException;
import com.shop.common.exception.NoAuthorityException;
import com.shop.common.exception.NoFoundException;
import com.shop.goods.dao.GoodsCountsDao;
import com.shop.goods.dao.GoodsDao;
import com.shop.goods.dao.GoodsDescribeDao;
import com.shop.goods.entity.*;
import com.shop.goods.enums.RedisTime;
import com.shop.goods.service.GoodsService;
import com.shop.common.service.UidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    GoodsCountsDao goodsCountsDao;
    @Autowired
    GoodsDescribeDao goodsDescribeDao;
    @Autowired
    UidService uidService;


    // TODO 事务
    // 用户userId要创建商品sendGoods, 这里的id是随机生成的，gloabId要靠uid微服务来维护
    @Transactional
    public String post(int userId, GoodsVO goodsVO)
            throws FallbackException, NoAuthorityException {
        // 准备数据
        Goods goods = goodsVO.getGoods();
        goods.setGlobalId((Long) uidService.getUid());
        goods.setUserId(userId);

        // 更新主键
        goodsDao.insert(goods);
        goodsCountsDao.insert(new GoodsCounts(goods.getId(), 0, (Long) uidService.getUid()));
        goodsDescribeDao.insert(new ImageNameAndDescribes(goods.getId(),
                (Long) uidService.getUid(), goodsVO.getImageNameAndDescribes()));
        return "插入成功";
    }


    @Transactional
    public String delete(int userId, int goodsId) throws NoAuthorityException, NoFoundException {
        Goods goods = goodsDao.selectByPrimaryKey(goodsId);
        if (goods == null) throw new NoFoundException();

        // 验证
        if (userId != goods.getUserId()) throw new NoAuthorityException();

        goodsCountsDao.deleteByPrimaryKey(goodsId);
        goodsDescribeDao.delByGoodsId(goodsId);
        goodsDao.deleteByPrimaryKey(goodsId);
        return "成功";
    }

    public String put(int userId, GoodsVO goodsVO) throws NoAuthorityException, NoFoundException {
        // 准备数据
        Goods goods = goodsVO.getGoods();
        Goods oldGoods = goodsDao.selectByPrimaryKey(goods.getId());
        if (oldGoods == null) throw new NoFoundException();

        MyUtils.upd(oldGoods, goods, goods.getClass());
        goods.setGlobalId(oldGoods.getGlobalId());
        goods.setId(oldGoods.getId());

        ImageNameAndDescribes oldImageNameAndDescribes = goodsDescribeDao.findByGoodsId(goods.getId());
        ImageNameAndDescribes imageNameAndDescribes =
                new ImageNameAndDescribes(goods.getId(),
                        oldImageNameAndDescribes.getGlobalId(),
                        goodsVO.getImageNameAndDescribes());

        // 验证
        if (userId != goods.getUserId()) throw new NoAuthorityException();

        goodsDao.updateByPrimaryKey(goods);
        goodsDescribeDao.updateByGoodsId(imageNameAndDescribes);
        return "修改成功";
    }


    public GoodsVO get(int goodsId) throws NoFoundException {
        Goods goods = goodsDao.selectByPrimaryKey(goodsId);
        if (goods == null) throw new NoFoundException();

        ImageNameAndDescribes byGoodsId = goodsDescribeDao.findByGoodsId(goodsId);
        return new GoodsVO(goods, byGoodsId.getImageNameAndDescribes());
    }

    // 商品数量
    @CachePut(key = "'goods'+#goodsId", cacheNames = RedisTime.FIVE_MINUTE)
    public String addCount(int userId, int goodsId, int count) {
        Goods goods = goodsDao.selectByPrimaryKey(goodsId);
        // 验证
        if (userId != goods.getUserId()) return "失败";
        GoodsCounts goodscounts = goodsCountsDao.selectByPrimaryKey(goodsId);
        goodscounts.setCounts(goodscounts.getCounts() + count);
        goodsCountsDao.updateByPrimaryKey(goodscounts);
        return "成功";
    }

    @Cacheable(key = "'goods'+#goodsId", cacheNames = RedisTime.FIVE_MINUTE)
    public int getCount(int goodsId) {
        GoodsCounts goodsCounts = goodsCountsDao.selectByPrimaryKey(goodsId);
        return goodsCounts.getCounts();
    }

//    // 辅助函数
//    public List<GoodsVO> getSendGoods(List<Goods> goods) {
//        List<Integer> integers = new ArrayList<>();
//        for (Goods goods1 : goods) {
//            integers.add(goods1.getId());
//        }
//        List<ImageNameAndDescribes> byGoodsId = goodsDescribeDao.findByGoodsId(integers);
//        List<GoodsVO> goodVOS = new ArrayList<>();
//        for (int i = 0; i < integers.size(); i++) {
//            goodVOS.add(new GoodsVO(goods.get(i), byGoodsId.get(i).getImageNameAndDescribes()));
//        }
//        return goodVOS;
//    }

    @Cacheable(key = "'goods'+#pageBegin+'-'+#perPage", cacheNames = RedisTime.ONE_MINUTE)
    public List<Goods> getByPage(int pageBegin, int perPage) {
        List<Goods> goods = goodsDao.selectByPage(pageBegin, perPage);
        return goods;
    }


    @Cacheable(key = "'goods'+#category+'-'+#pageBegin+'-'+#perPage", cacheNames = RedisTime.ONE_MINUTE)
    public List<Goods> getByCategory(String category, int pageBegin, int perPage) {
        List<Goods> goods = goodsDao.selectByPageAndCategory(category, pageBegin, perPage);
        return goods;
    }

    @Cacheable(key = "'goods'+#userId+'-'+#pageBegin+'-'+#perPage", cacheNames = RedisTime.ONE_MINUTE)
    public List<Goods> getBySeller(int userId, int pageBegin, int perPage) {
        List<Goods> goods = goodsDao.selectByUserId(userId, pageBegin, perPage);
        return goods;
    }
}
