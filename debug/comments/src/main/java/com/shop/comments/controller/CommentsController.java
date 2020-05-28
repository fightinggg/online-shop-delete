package com.shop.comments.controller;

import com.alibaba.fastjson.JSON;
import com.shop.comments.entity.Comments;
import com.shop.comments.service.CommentsService;
import com.shop.common.annotation.ResponseEncode;
import com.shop.common.exception.FallbackException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class CommentsController {
    @Autowired
    CommentsService commentsService;


    /**
     * @param goodsId  商品id
     * @param replayId 回复id
     * @param data     评论参数
     * @return Object 执行结果
     */
    @PostMapping("/{goodsId}/{replayId}")
    @ResponseEncode
    public Object insert(@RequestHeader Integer id,
                         @PathVariable("goodsId") int goodsId,
                         @PathVariable("replayId") int replayId,
                         @RequestBody String data) throws FallbackException {
        String commentsId = commentsService.insert(id, goodsId, replayId, data);
        log.info("用户{}评论了商品{},回复了{},评论是{}", id, goodsId, replayId, commentsId);
        return "成功";
    }

    /**
     *
     * @param id
     * @param goodsId
     * @return
     */
    @GetMapping("/{goodsId}")
    @ResponseEncode
    public Object findByGoodsId(@RequestHeader @Nullable Integer id,
                                @PathVariable("goodsId") int goodsId) {
        log.info("用户{}查看了商品{}的评论", id, goodsId);
        return commentsService.findByGoodsId(goodsId);
    }

    /**
     *
     * @param id
     * @param commentsId
     * @return
     */
    @DeleteMapping("/{commentsId}")
    @ResponseEncode
    public Object delById(@RequestHeader Integer id,
                          @PathVariable("commentsId") String commentsId) {
        log.info("用户{}删除了评论{}", id, commentsId);
        return commentsService.delById(id, commentsId);
    }
}
