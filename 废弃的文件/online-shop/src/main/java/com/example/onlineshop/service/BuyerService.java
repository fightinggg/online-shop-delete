package com.example.onlineshop.service;

import com.example.onlineshop.dao.OrdersDao;
import com.example.onlineshop.entity.*;
import com.example.onlineshop.mapper.BuyerMapper;
import com.example.onlineshop.mapper.GoodsMapper;
import com.example.onlineshop.mapper.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * * 注册账号
 * * 登陆账号
 * * 充值
 * * 浏览商品
 * * 购买商品
 * * 浏览订单
 * * 确认收货
 */
@Service
public class BuyerService {
    @Autowired
    BuyerMapper buyerMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    SellerMapper sellerMapper;

    @Autowired
    OrdersDao ordersDao;

    // 注册账号
    public int postBuyer(Buyer buyer) {
        return buyerMapper.insert(buyer);
    }

    // 登陆账号
    public Buyer getBuyer(int id) {
        return buyerMapper.selectByPrimaryKey(id);
    }

    // 充值
    public int addMoney(int id, int money) {
        Buyer buyer = buyerMapper.selectByPrimaryKey(id);
        buyer.setMoney(buyer.getMoney() + money);
        return buyerMapper.updateByPrimaryKey(buyer);
    }

    // 浏览商品
    public List<Goods> getGoods() {
        return goodsMapper.selectByExample(new GoodsExample());
    }

    // 购买商品
    @Transactional
    public int postOrder(Orders orders) {
        Buyer buyer = buyerMapper.selectByPrimaryKey(orders.getBuyerid());
        Goods goods = goodsMapper.selectByPrimaryKey(orders.getGoodsid());
        Seller seller = sellerMapper.selectByPrimaryKey(goods.getSellerid());
        int count = orders.getCounts();
        int cost = goods.getPrice() * count;
        buyer.setMoney(buyer.getMoney() - cost);
        seller.setMoney(seller.getMoney() + cost);
        goods.setCount(goods.getCount() - count);
        buyerMapper.updateByPrimaryKey(buyer);
        sellerMapper.updateByPrimaryKey(seller);
        goodsMapper.updateByPrimaryKey(goods);
        return ordersDao.insertSelective(orders);
    }

    // 浏览订单
    public List<Orders> getOrders(int id) {
        return ordersDao.selectByBuyerId(id);
    }

    // 确认收货
    public int closeOrders(int id) {
        Orders orders = ordersDao.selectByPrimaryKey(id);
        orders.setState("successed");
        return ordersDao.updateByPrimaryKey(orders);
    }
}
