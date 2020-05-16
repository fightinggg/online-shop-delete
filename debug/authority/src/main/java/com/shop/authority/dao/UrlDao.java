package com.shop.authority.dao;

import com.shop.authority.entity.Url;
import com.shop.authority.mapper.UrlMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UrlDao extends UrlMapper {
    @Select("select * from tb_url limit #{pageBegin},#{perPage}")
    List<Url> searchAllUrl(int pageBegin, int perPage);
}
