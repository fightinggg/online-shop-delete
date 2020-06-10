package com.shop.comments.service;

import com.mongodb.client.result.UpdateResult;
import com.shop.comments.dao.CommentsDao;
import com.shop.comments.entity.Comments;
import com.shop.common.exception.FallbackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentsService {

    public String insert(Integer id, int goodsId, String replayId, String string) throws FallbackException;

    public List<Comments> findByGoodsId(int integers);

    public Comments delById(int buyerId, String id);

}
