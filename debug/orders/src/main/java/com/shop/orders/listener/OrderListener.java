package com.shop.orders.listener;

import com.alibaba.fastjson.JSONObject;
import com.shop.common.exception.FallbackException;
import com.shop.common.service.impl.PrivateMsgProduceService;
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
    @Autowired
    PrivateMsgProduceService privateMsgProduceService;

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        Orders orders = null;
        try {
            String jsonString = new String((byte[]) message.getPayload());
            orders = JSONObject.parseObject(jsonString, Orders.class);
            ordersService.localPost(orders);
            privateMsgProduceService.send(orders.getBuyerId(), "订单成功", "你的订单" + orders.getGoodsId() + "成功了");
            log.info("订单{}提交", orders);
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            log.error("订单{}失败,回滚", orders);
            try {
                privateMsgProduceService.send(orders.getBuyerId(),
                        "订单失败",
                        "你的订单" + orders.getGoodsId() + "失败了"
                                + "失败原因是" + e.getMessage());
            } catch (FallbackException fallbackException) {
                log.error("严重失败，需要人工处理！！！！！！！，订单失败，并且通知失败" + orders.getGlobalId());
                fallbackException.printStackTrace();
            }
            e.printStackTrace();
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
