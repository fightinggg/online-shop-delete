package com.shop.authority.dao;

import com.shop.authority.mapper.RoleUrlMapper;
import org.apache.ibatis.annotations.Select;

public interface RoleUrlDao extends RoleUrlMapper {
    @Select("select * from tb_role_url where role_id = #{roleId} limit pageBegin,perPage")
    Object selectByRoleIdAndPage(int roleId, String pageBegin, String perPage);

    @Select("select * from tb_role_url where url_id = #{urlId} limit pageBegin,perPage")
    Object selectByUrlIdAndPage(int urlId, String pageBegin, String perPage);
}
