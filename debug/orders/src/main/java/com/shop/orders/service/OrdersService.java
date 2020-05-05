package com.shop.orders.service;

import com.alibaba.fastjson.JSON;
import com.shop.orders.dao.*;
import com.shop.orders.entity.*;
import com.shop.orders.message.OrdersMsg;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    OrdersDao ordersDao;
    @Autowired
    BuyermoneyDao buyermoneyDao;
    @Autowired
    SellermoneyDao sellermoneyDao;
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    GoodscountsDao goodscountsDao;
//    @Autowired
//    RocketMQTemplate rocketMQTemplate;

//    // 添加订单！ 事务管理
//    @Transactional
//    public String post(int buyerid, Orders orders) {
//        // 验证权限
//        if (buyerid != orders.getBuyerid()) return "失败";
//        // 分布式事务
//        // 创建一个事务id，作为消息内容发到mq
//        OrdersMsg ordersMsg = new OrdersMsg();
//
//        String jsonString = JSON.toJSONString(ordersMsg);
//        //生成message类型
//        Message<String> message = MessageBuilder.withPayload(jsonString).build();
//        //发送一条事务消息
//        /*
//          String txProducerGroup 生产组
//          String destination topic，
//          Message<?> message, 消息内容
//          Object arg 参数
//         */
//        rocketMQTemplate.sendMessageInTransaction("producer_group_txmsg_bank1", "topic_txmsg", message, null);
//        return "成功";
//    }

    @Transactional
    public String localpost(Orders orders) {
        // 本地事务
        Buyermoney buyermoney = buyermoneyDao.selectByPrimaryKey(orders.getBuyerid());
        Goods goods = goodsDao.selectByPrimaryKey(orders.getGoodsid());
        Goodscounts goodscounts = goodscountsDao.selectByPrimaryKey(orders.getGoodsid());
        Sellermoney sellermoney = sellermoneyDao.selectByPrimaryKey(goods.getSellerid());

        int count = orders.getCounts();
        int cost = goods.getPrice() * count;

        buyermoney.setMoney(buyermoney.getMoney() - cost);
        goodscounts.setCounts(goodscounts.getCounts() - count);
        sellermoney.setMoney(sellermoney.getMoney() + cost);
        buyermoneyDao.updateByPrimaryKeySelective(buyermoney);
        goodscountsDao.updateByPrimaryKeySelective(goodscounts);
        sellermoneyDao.updateByPrimaryKeySelective(sellermoney);

        ordersDao.insertSelective(orders);
        return "successed";
    }

    // 移除订单！ 事务管理
    @Transactional
    public int delete(int buyerid, int ordersId) {
        // 本地事务
        Orders orders = ordersDao.selectByPrimaryKey(ordersId);
        Buyermoney buyermoney = buyermoneyDao.selectByPrimaryKey(orders.getBuyerid());
        Goods goods = goodsDao.selectByPrimaryKey(orders.getGoodsid());
        Goodscounts goodscounts = goodscountsDao.selectByPrimaryKey(orders.getGoodsid());
        Sellermoney sellermoney = sellermoneyDao.selectByPrimaryKey(goods.getSellerid());

        int count = orders.getCounts();
        int cost = goods.getPrice() * count;

        buyermoney.setMoney(buyermoney.getMoney() + cost);
        goodscounts.setCounts(goodscounts.getCounts() + count);
        sellermoney.setMoney(sellermoney.getMoney() - cost);
        buyermoneyDao.updateByPrimaryKeySelective(buyermoney);
        goodscountsDao.updateByPrimaryKeySelective(goodscounts);
        sellermoneyDao.updateByPrimaryKeySelective(sellermoney);

        return ordersDao.deleteByPrimaryKey(ordersId);
    }

    // 完成订单
    @Transactional
    public int successed(int buyerid, int ordersId) {
        Orders orders = ordersDao.selectByPrimaryKey(ordersId);
        if (buyerid != orders.getBuyerid()) return 0;
        orders.setState("successed");
        return ordersDao.updateByPrimaryKeySelective(orders);
    }

    public List<Orders> buyerget(int buyerId) {
        return ordersDao.selectByBuyerId(buyerId);
    }

    public List<Orders> sellerGet(int sellerId) {
        return ordersDao.selectBySellerId(sellerId);
    }
}
