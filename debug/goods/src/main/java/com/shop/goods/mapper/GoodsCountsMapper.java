package com.shop.goods.mapper;

import com.shop.goods.entity.GoodsCounts;
import com.shop.goods.entity.GoodsCountsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsCountsMapper {
    int countByExample(GoodsCountsExample example);

    int deleteByExample(GoodsCountsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCounts record);

    int insertSelective(GoodsCounts record);

    List<GoodsCounts> selectByExample(GoodsCountsExample example);

    GoodsCounts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsCounts record, @Param("example") GoodsCountsExample example);

    int updateByExample(@Param("record") GoodsCounts record, @Param("example") GoodsCountsExample example);

    int updateByPrimaryKeySelective(GoodsCounts record);

    int updateByPrimaryKey(GoodsCounts record);
}