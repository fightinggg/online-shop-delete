package com.shop.goods.dao;

import com.shop.goods.entity.Goods;
import com.shop.goods.mapper.GoodsMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GoodsDao extends GoodsMapper {
    List<Goods> selectByPage(int pageBegin, int perPage);

    List<Goods> selectByPageAndCategory(String category, int pageBegin, int perPage);

    List<Goods> selectByUserId(int userId, int pageBegin, int perPage);
}
