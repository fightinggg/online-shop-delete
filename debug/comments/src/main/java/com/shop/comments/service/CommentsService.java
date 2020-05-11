package com.shop.comments.service;

import com.mongodb.client.result.UpdateResult;
import com.shop.comments.dao.CommentsDao;
import com.shop.comments.entity.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {
    @Autowired
    CommentsDao commentsDao;

    public String insert(int buyerId, Comments comments) {
        // 权限认证
        if (buyerId != comments.getBuyerId()) return "失败";
        return commentsDao.insert(comments);
    }

    public List<Comments> findByGoodsId(int integers) {
        return commentsDao.findByGoodsId(integers);
    }

    public Comments delById(int buyerId, String id) {
        // UNDO 权限认证
//        if(buyerId!=comments.getBuyerId()) return "失败";
        return commentsDao.delById(id);
    }

}
