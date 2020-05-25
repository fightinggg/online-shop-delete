package com.shop.authority.mapper;

import com.shop.authority.entity.Url;
import com.shop.authority.entity.UrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UrlMapper {
    int countByExample(UrlExample example);

    int deleteByExample(UrlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Url record);

    int insertSelective(Url record);

    List<Url> selectByExample(UrlExample example);

    Url selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Url record, @Param("example") UrlExample example);

    int updateByExample(@Param("record") Url record, @Param("example") UrlExample example);

    int updateByPrimaryKeySelective(Url record);

    int updateByPrimaryKey(Url record);
}