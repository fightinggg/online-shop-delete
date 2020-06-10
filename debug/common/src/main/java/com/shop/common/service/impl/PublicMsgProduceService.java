package com.shop.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class PublicMsgProduceService {
    @Autowired
    KafkaProduceService kafkaProduceService;

    public String sendToAll(String head, String payload) {
        Message<String> msg = MessageBuilder
                .withPayload(payload)
                .setHeader(head, null)
                .build();
        boolean send = kafkaProduceService.getMySource().output().send(msg);
        if (send) return "发送成功";
        else return "发送失败";
    }
}
