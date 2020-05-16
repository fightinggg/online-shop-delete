package com.shop.authority.service;

import com.shop.authority.dao.RoleUrlDao;
import com.shop.authority.entity.RoleUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleUrlService {
    @Autowired
    RoleUrlDao roleUrlDao;

    public Object roleHaveWhatUrl(int roleId, String pageBegin, String perPage) {
        return roleUrlDao.selectByRoleIdAndPage(roleId, pageBegin, perPage);
    }


    public Object urlHaveWhatRole(int urlId, String pageBegin, String perPage) {
        return roleUrlDao.selectByUrlIdAndPage(urlId, pageBegin, perPage);
    }

    public Object insert(RoleUrl roleUrl) {
        return roleUrlDao.insert(roleUrl);
    }

    public Object delete(int id) {
        return roleUrlDao.deleteByPrimaryKey(id);
    }
}
