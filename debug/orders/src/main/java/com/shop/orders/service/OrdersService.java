package com.shop.orders.service;

import com.alibaba.fastjson.JSON;
import com.shop.common.exception.FallbackException;
import com.shop.common.exception.NoAuthorityException;
import com.shop.common.exception.NoFoundException;
import com.shop.common.service.UidService;
import com.shop.orders.dao.*;
import com.shop.orders.entity.*;
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
    MoneyDao moneyDao;
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    GoodsCountDao goodsCountDao;
    @Autowired
    RocketMQTemplate rocketMQTemplate;
    @Autowired
    UidService uidService;

    // 添加订单！ 事务管理
    public String post(int id, Orders orders) throws FallbackException {
        // 分布式事务启动
        // 创建一个事务消息, 现在除了id以外，其他的都已经完成赋值
        Goods goods = goodsDao.selectByPrimaryKey(orders.getGoodsId());
        orders.setGlobalId((Long) uidService.getUid());
        orders.setBuyerId(id);
        orders.setBuyerSubmit(false);
        orders.setSellerSubmit(false);
        orders.setSellerId(goods.getUserId());
        orders.setPrice(goods.getPrice());
        String jsonString = JSON.toJSONString(orders);
        //生成message类型
        Message<String> message = MessageBuilder.withPayload(jsonString).build();
        //发送一条事务消息
        /*
          String txProducerGroup 生产组
          String destination topic，
          Message<?> message, 消息内容
          Object arg 参数
         */
        rocketMQTemplate.sendMessageInTransaction("orderProducer", "addOrder", message, null);
        return "订单提交成功，这里无法保证购买成功，具体信息请注意查看您的邮箱";
    }

    @Transactional
    public void localPost(Orders orders) throws Exception {
        // 查询+准备
        Money buyerMoney = moneyDao.selectByPrimaryKey(orders.getBuyerId());
        GoodsCounts goodsCounts = goodsCountDao.selectByPrimaryKey(orders.getGoodsId());

        // 计算
        int count = orders.getCounts();
        int cost = orders.getPrice() * count;

        // 修改
        if (buyerMoney.getMoney() < cost) throw new Exception("钱不够了");
        if (goodsCounts.getCounts() < count) throw new Exception("商品不够了");
        buyerMoney.setMoney(buyerMoney.getMoney() - cost);
        goodsCounts.setCounts(goodsCounts.getCounts() - count);

        // 执行
        moneyDao.updateByPrimaryKey(buyerMoney);
        goodsCountDao.updateByPrimaryKey(goodsCounts);
        ordersDao.insertSelective(orders);
    }

    // 移除订单！ 事务管理
    @Transactional
    public String delete(int id, int ordersId) throws NoFoundException, NoAuthorityException {
        // 准备
        Orders orders = ordersDao.selectByPrimaryKey(ordersId);

        // 安全
        if (orders == null) throw new NoFoundException();
        if (id != orders.getBuyerId()) throw new NoAuthorityException();

        GoodsCounts goodsCounts = goodsCountDao.selectByPrimaryKey(orders.getGoodsId());
        Money buyerMoney = moneyDao.selectByPrimaryKey(orders.getBuyerId());

        // 计算
        int count = orders.getCounts();
        int cost = orders.getPrice() * count;

        // 修改
        buyerMoney.setMoney(buyerMoney.getMoney() + cost);
        goodsCounts.setCounts(goodsCounts.getCounts() + count);

        // 执行
        moneyDao.updateByPrimaryKey(buyerMoney);
        goodsCountDao.updateByPrimaryKey(goodsCounts);
        ordersDao.deleteByPrimaryKey(ordersId);
        return "成功";
    }

    // 完成订单
    @Transactional
    public String successed(int id, int ordersId) {
        Orders orders = ordersDao.selectByPrimaryKey(ordersId);
        if (id == orders.getBuyerId()) {
            orders.setBuyerSubmit(true);
        }
        if (id == orders.getSellerId()) {
            orders.setSellerSubmit(true);
        }
        ordersDao.updateByPrimaryKey(orders);
        if (orders.getBuyerSubmit() && orders.getSellerSubmit()) {
            Money money = moneyDao.selectByPrimaryKey(orders.getSellerId());
            money.setMoney(money.getMoney() + orders.getPrice() * orders.getCounts());
            moneyDao.updateByPrimaryKey(money);
            return "完成订单";
        } else {
            return "请等待其他人确定完成订单";
        }
    }

    public List<Orders> get(Integer id, Integer pageBegin, Integer perPage) {
        return ordersDao.selectByBuyerId(id, pageBegin, perPage);
    }
}
