package com.shop.orders.listener;

import com.alibaba.fastjson.JSONObject;
import com.shop.orders.dao.OrdersDao;
import com.shop.orders.entity.Orders;
import com.shop.orders.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQTransactionListener(txProducerGroup = "orderProducer")
public class OrderListener implements RocketMQLocalTransactionListener {
    @Autowired
    OrdersService ordersService;
    @Autowired
    OrdersDao ordersDao;

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        Orders orders = null;
        try {
            String jsonString = new String((byte[]) message.getPayload());
            orders = JSONObject.parseObject(jsonString, Orders.class);
            ordersService.localPost(orders);
            log.info("订单{}提交", orders);
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            log.info("订单{}失败,回滚", orders);
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        try {
            String jsonString = new String((byte[]) message.getPayload());
            Orders orders = JSONObject.parseObject(jsonString, Orders.class);
            if (ordersDao.selectByGlobalId(orders.getGlobalId()) != null) {
                return RocketMQLocalTransactionState.COMMIT;
            } else {
                return RocketMQLocalTransactionState.UNKNOWN;
            }
        } catch (Exception e) {
            return RocketMQLocalTransactionState.UNKNOWN;
        }
    }
}
