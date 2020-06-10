package com.shop.msg.controller;

import com.shop.common.annotation.ResponseEncode;
import com.shop.msg.service.PrivateMsgConsumerServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PrivateMsgConsumerController {

    @Autowired
    PrivateMsgConsumerServcie privateMsgConsumerServcie;

    @ResponseEncode
    @GetMapping(value = "/private/{pageBegin}/{perPage}", produces = "application/json;charset=utf-8")
    public Object select(@RequestHeader int id,
                         @PathVariable int pageBegin,
                         @PathVariable int perPage) {
        log.info("用户{}查看了自己的消息", id);
        return privateMsgConsumerServcie.select(id, pageBegin, perPage);
    }

    @ResponseEncode
    @GetMapping(value = "/private/read/{_id}", produces = "application/json;charset=utf-8")
    public Object read(@RequestHeader int id,
                       @PathVariable String _id) {
        log.info("用户{}确认读取了消息{}", id, _id);
        return privateMsgConsumerServcie.read(id, _id);
    }
}
