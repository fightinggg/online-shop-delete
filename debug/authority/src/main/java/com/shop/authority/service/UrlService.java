package com.shop.authority.service;

import com.shop.authority.dao.UrlDao;
import com.shop.authority.entity.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {
    @Autowired
    UrlDao urlDao;

    public List<Url> searchAllUrl(int pageBegin, int perPage) {
        return urlDao.searchAllUrl(pageBegin,perPage);
    }
}
