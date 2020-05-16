package com.shop.authority.dao;

import com.shop.authority.entity.Role;
import com.shop.authority.entity.SendUser2Role;
import com.shop.authority.entity.UserRole;
import com.shop.authority.mapper.UserRoleMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserRoleDao extends UserRoleMapper {
    List<SendUser2Role> selectByUserId(int userId);

    List<UserRole> selectByRoleId(int roleId);
}
