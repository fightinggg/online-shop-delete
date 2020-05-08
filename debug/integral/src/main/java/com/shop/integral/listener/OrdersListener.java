package com.shop.integral.listener;

import com.alibaba.fastjson.JSONObject;
import com.shop.integral.entity.Orders;
import com.shop.integral.service.IntegralTransactionService;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "addOrder",consumerGroup = "orderEmailConsumer")
public class OrdersListener implements RocketMQListener<String> {

    @Autowired
    IntegralTransactionService integralTransactionService;

    @Override
    public void onMessage(String s) {
        Orders orders =JSONObject.parseObject(s,Orders.class);
        integralTransactionService.sendEmail(orders);
    }
}
