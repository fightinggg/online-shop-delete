package com.shop.authority.service;

import com.shop.authority.dao.RoleDao;
import com.shop.authority.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;

    public List<Role> search(int pageBegin, int perPage) {
        return roleDao.selectByPage(pageBegin,perPage);
    }

    public int insert(Role role) {
        return roleDao.insert(role);
    }

    public int update(Role role) {
        System.out.println(role.getId());
        Long gloablId = roleDao.selectByPrimaryKey(role.getId()).getGloablId();
        role.setGloablId(gloablId);
        return roleDao.updateByPrimaryKey(role);
    }

    public int erase(int roleId) {
        return roleDao.deleteByPrimaryKey(roleId);
    }
}
