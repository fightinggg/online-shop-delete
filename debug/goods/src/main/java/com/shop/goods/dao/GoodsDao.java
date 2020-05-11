package com.shop.goods.dao;

import com.shop.goods.entity.Goods;
import com.shop.goods.mapper.GoodsMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import java.util.List;

public interface GoodsDao extends GoodsMapper {
    List<Goods> selectByPage(int pageBegin, int perPage);

    List<Goods> selectByPageAndCategory(String category, int pageBegin, int perpage);

    List<Goods> selectBySellerId(int sellerId, int pageBegin, int perpage);
}
