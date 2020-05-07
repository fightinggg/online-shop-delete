package com.shop.email.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shop.email.entity.Orders;
import com.shop.email.service.EmailService;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "addOrder",consumerGroup = "orderEmailConsumer")
public class OrdersListener implements RocketMQListener<String> {

    @Autowired
    EmailService emailService;

    @Override
    public void onMessage(String s) {
        Orders orders =JSONObject.parseObject(s,Orders.class);
        emailService.sendEmail(orders);
    }
}
