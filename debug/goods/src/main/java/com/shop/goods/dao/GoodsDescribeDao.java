package com.shop.goods.dao;

import com.mongodb.client.result.UpdateResult;
import com.shop.goods.entity.ImageNameAndDescribes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsDescribeDao {

    @Autowired
    MongoTemplate mongoTemplate;

    public String insert(ImageNameAndDescribes imageNameAndDescribes) {
        mongoTemplate.save(imageNameAndDescribes);
        return "成功";
    }

    public List<ImageNameAndDescribes> findByGoodsId(List<Integer> integers){
        Query query = new Query( Criteria.where("goodsId").in(integers));
        return mongoTemplate.find(query, ImageNameAndDescribes.class);
    }

    public ImageNameAndDescribes findByGoodsId(Integer goodsId) {
        Query query = new Query(Criteria.where("goodsId").is(goodsId));
        return mongoTemplate.findOne(query, ImageNameAndDescribes.class);
    }

    public Long updateByGoodsId(ImageNameAndDescribes imageNameAndDescribes) {
        Query query = new Query(Criteria.where("goodsId").is(imageNameAndDescribes.getGoodsId()));
        Update update = Update.update("urlAndDescribes", imageNameAndDescribes.getImageNameAndDescribes());
        UpdateResult updateResult = mongoTemplate.updateMulti(query, update, ImageNameAndDescribes.class);
        return updateResult.getMatchedCount();
    }

    public ImageNameAndDescribes delByGoodsId(Integer goodsId) {
        Query query = new Query(Criteria.where("goodsId").is(goodsId));
        return mongoTemplate.findAndRemove(query, ImageNameAndDescribes.class);
    }
}
