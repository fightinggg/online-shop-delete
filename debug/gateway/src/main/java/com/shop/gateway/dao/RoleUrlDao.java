package com.shop.gateway.dao;

import com.shop.gateway.mapper.RoleUrlMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleUrlDao  extends RoleUrlMapper {
    @Select("select name " +
            "from tb_role r,tb_role_url ru , tb_url u " +
            "where r.id = ru.role_id " +
            "and ru.url_id = u.id " +
            "and u.url_pre = #{pre}")
    List<String> selectRoleByUrl(String pre);
}
