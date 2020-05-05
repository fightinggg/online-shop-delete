package com.example.onlineshop.dao;

import com.example.onlineshop.entity.Buyer;
import com.example.onlineshop.entity.Orders;
import com.example.onlineshop.mapper.OrdersMapper;

import java.util.List;

public interface OrdersDao extends OrdersMapper {
    List<Orders> selectByBuyerId(int id);

    List<Orders> selectBySellerId(int id);
}
