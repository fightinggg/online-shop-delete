package com.shop.zuul.dao;

import com.shop.zuul.mapper.UserRoleMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserRoleDao extends UserRoleMapper {
    @Select("select name " +
            "from tb_role r,tb_user_role u " +
            "where r.id = u.role_id " +
            "and u.user_id = #{id}")
    List<String> selectRoleByUserId(Integer id);
}
