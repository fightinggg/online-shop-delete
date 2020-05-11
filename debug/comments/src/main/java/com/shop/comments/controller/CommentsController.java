package com.shop.comments.controller;

import com.alibaba.fastjson.JSON;
import com.shop.comments.entity.Comments;
import com.shop.comments.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentsController {
    @Autowired
    CommentsService commentsService;

    @PostMapping("/buyer/{buyerId}/{goodsId}/{replayId}")
    public String insert(@PathVariable("buyerId") int buyerId,
                         @PathVariable("goodsId") int goodsId,
                         @PathVariable("replayId") int replayId,
                         @RequestBody String string) {
        Comments comments = new Comments(null,buyerId, goodsId, replayId, string);
        return JSON.toJSONString(commentsService.insert(buyerId, comments));
    }

    @GetMapping("/everyone/null/{goodsId}")
    public String findByGoodsId(@PathVariable("goodsId") int goodsId) {
        return JSON.toJSONString(commentsService.findByGoodsId(goodsId));
    }

    @DeleteMapping("/buyer/{buyerId}/{id}")
    public String delById(@PathVariable("buyerId") int buyerId,
                          @PathVariable("id") String id) {
        return JSON.toJSONString(commentsService.delById(buyerId, id));
    }
}
