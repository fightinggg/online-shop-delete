package com.shop.phone.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shop.phone.dao.PhoneTransactionDao;
import com.shop.phone.entity.Orders;
import com.shop.phone.service.PhoneTransactionService;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "addOrder",consumerGroup = "orderEmailConsumer")
public class OrdersListener implements RocketMQListener<String> {

    @Autowired
    PhoneTransactionService phoneTransactionService;

    @Override
    public void onMessage(String s) {
        Orders orders =JSONObject.parseObject(s,Orders.class);
        phoneTransactionService.sendEmail(orders);
    }
}
