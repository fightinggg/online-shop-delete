package com.example.onlineshop.service;

import com.example.onlineshop.dao.OrderDao;
import com.example.onlineshop.entity.*;
import com.example.onlineshop.mapper.BuyerMapper;
import com.example.onlineshop.mapper.GoodsMapper;
import com.example.onlineshop.mapper.OrderMapper;
import com.example.onlineshop.mapper.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    BuyerMapper buyerMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    SellerMapper sellerMapper;

    @Autowired
    OrderDao orderDao;


    public int post(Order order) {
        Buyer buyer = buyerMapper.selectByPrimaryKey(order.getBuyerid());
        Goods goods = goodsMapper.selectByPrimaryKey(order.getGoodsid());
        Seller seller = sellerMapper.selectByPrimaryKey(goods.getSellerid());
        int count = order.getCounts();
        int cost = goods.getPrice() * count;
        buyer.setMoney(buyer.getMoney() - cost);
        seller.setMoney(seller.getMoney() + cost);
        goods.setCount(goods.getCount() - count);
        return orderDao.insertSelective(order);
    }

    public int delete(Order order) {
        Buyer buyer = buyerMapper.selectByPrimaryKey(order.getBuyerid());
        Goods goods = goodsMapper.selectByPrimaryKey(order.getGoodsid());
        Seller seller = sellerMapper.selectByPrimaryKey(goods.getSellerid());
        int count = order.getCounts();
        int cost = goods.getPrice() * count;
        buyer.setMoney(buyer.getMoney() + cost);
        seller.setMoney(seller.getMoney() - cost);
        goods.setCount(goods.getCount() + count);
        return orderDao.insertSelective(order);
    }

    public List<Order> findByBuyerId(int id) {
        return orderDao.selectByBuyerId(id);
    }

    public List<Order> findBySellerId(int id) {
        return orderDao.selectBySellerId(id);
    }
}
