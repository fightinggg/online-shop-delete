package com.example.onlineshop.service;

import com.example.onlineshop.dao.OrdersDao;
import com.example.onlineshop.entity.Goods;
import com.example.onlineshop.entity.Orders;
import com.example.onlineshop.entity.Seller;
import com.example.onlineshop.mapper.GoodsMapper;
import com.example.onlineshop.mapper.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 注册账号
 * 登陆账号
 * 提现
 * 发布商品
 * 撤销商品
 * 浏览订单
 */


@Service
public class SellerService {
    @Autowired
    SellerMapper sellerMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    OrdersDao ordersDao;

    // 注册
    public int postSeller(Seller seller) {
        return sellerMapper.insertSelective(seller);
    }

    // 登陆
    public Seller getSeller(int id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    // 提现
    public int subMoney(int id, int money) {
        Seller seller = sellerMapper.selectByPrimaryKey(id);
        seller.setMoney(seller.getMoney() - money);
        return sellerMapper.updateByPrimaryKey(seller);
    }

    //发布商品
    public int postGoods(Goods goods) {
        return goodsMapper.insertSelective(goods);
    }

    // 撤销商品
    public int putGoods(Goods goods) {
        return goodsMapper.updateByPrimaryKey(goods);
    }

    // 浏览订单
    public List<Orders> getOrders(int id) {
        return ordersDao.selectBySellerId(id);
    }

}
