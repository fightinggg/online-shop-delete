package com.shop.comments.service.impl;

import com.shop.comments.dao.CommentsDao;
import com.shop.comments.entity.Comments;
import com.shop.comments.service.CommentsService;
import com.shop.common.exception.FallbackException;
import com.shop.common.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    CommentsDao commentsDao;
    @Autowired
    UidService uidService;

    public String insert(Integer id, int goodsId, String replayId, String data) throws FallbackException {
        System.out.println(uidService.getUid());
        Comments comments = new Comments(null, (Long) uidService.getUid(), id, goodsId, replayId, data);
        return commentsDao.insert(comments);
    }

    public List<Comments> findByGoodsId(int integers) {
        return commentsDao.findByGoodsId(integers);
    }

    public Comments delById(int buyerId, String commentsId) {
        return commentsDao.delById(buyerId,commentsId);
    }

}
