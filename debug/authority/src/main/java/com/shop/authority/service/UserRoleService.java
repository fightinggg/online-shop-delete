package com.shop.authority.service;

import com.shop.authority.dao.UserRoleDao;
import com.shop.authority.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    @Autowired
    UserRoleDao userRoleDao;

    public Object user_have_what_role(int userId) {
        return userRoleDao.selectByUserId(userId);
    }

    public Object role_have_what_user(int roleId) {
        return userRoleDao.selectByRoleId(roleId);
    }


    public Object delete_user_role(int id) {
        return userRoleDao.deleteByPrimaryKey(id);
    }

    public Object insert_user_role(UserRole userRole) {
        return userRoleDao.insert(userRole);
    }
}
