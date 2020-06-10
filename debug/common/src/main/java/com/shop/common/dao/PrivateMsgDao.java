package com.shop.common.dao;

import com.shop.common.entity.PrivateMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class PrivateMsgDao {
    @Autowired
    MongoTemplate mongoTemplate;

    public void insert(PrivateMsg privateMsg) {
        mongoTemplate.save(privateMsg);
    }

}
