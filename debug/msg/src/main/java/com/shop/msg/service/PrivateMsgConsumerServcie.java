package com.shop.msg.service;


import com.shop.common.entity.PrivateMsg;
import com.shop.msg.dao.PrivateMsgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivateMsgConsumerServcie {
    @Autowired
    PrivateMsgDao privateMsgDao;

    public List<PrivateMsg> select(int userId, int pageBegin, int perPage) {
        return privateMsgDao.select(userId,pageBegin,perPage);
    }

    public String read(int userId, String _id) {
        return privateMsgDao.read(userId,_id);
    }
}
