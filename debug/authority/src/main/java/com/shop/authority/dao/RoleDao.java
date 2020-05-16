package com.shop.authority.dao;

import com.shop.authority.entity.Role;
import com.shop.authority.mapper.RoleMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao extends RoleMapper {
    @Select("select * from tb_role limit #{pageBegin},#{perPage}")
    List<Role> selectByPage(int pageBegin, int perPage);
}
