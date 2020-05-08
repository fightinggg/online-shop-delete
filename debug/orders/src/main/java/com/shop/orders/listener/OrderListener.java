package com.shop.orders.listener;

import com.alibaba.fastjson.JSONObject;
import com.shop.orders.entity.Orders;
import com.shop.orders.service.OrdersService;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RocketMQTransactionListener(txProducerGroup = "orderProducer")
public class OrderListener implements RocketMQLocalTransactionListener {
    @Autowired
    OrdersService ordersService;

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        try {
            System.out.println("exec transaction add order");
            String jsonString = new String((byte[]) message.getPayload());
            Orders orders = JSONObject.parseObject(jsonString, Orders.class);
            ordersService.localpost(orders);
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        String jsonString = new String((byte[]) message.getPayload());
        Orders orders = JSONObject.parseObject(jsonString, Orders.class);
        if (ordersService.get(orders.getId()) != null) {
            return RocketMQLocalTransactionState.COMMIT;
        } else {
            return RocketMQLocalTransactionState.UNKNOWN;
        }
    }
}
