package com.shop.msg.dao;

import com.shop.common.entity.PrivateMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class PrivateMsgDao {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<PrivateMsg> select(int userId, int pageBegin, int perPage) {
        Query query = new Query(Criteria.where("userId").is(userId))
                .skip(pageBegin).limit(perPage);
        return mongoTemplate.find(query, PrivateMsg.class);
    }

    public String read(int userId, String _id) {
        Query query = new Query(Criteria.where("userId").is(userId).and("_id").is(_id).and("isRead").is(false));
        Update update = new Update().set("isRead", true);
        long size = mongoTemplate.updateFirst(query, update, PrivateMsg.class).getModifiedCount();
        switch ((int) size) {
            case 1:
                return "成功";
            case 0:
                return "失败";
            default:
                log.error("严重错误！！！！！！，userId:{}, _id:{}", userId, _id);
                return "失败";
        }
    }

}
