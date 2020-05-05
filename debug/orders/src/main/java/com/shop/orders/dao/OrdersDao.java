package com.shop.orders.dao;

import com.shop.orders.entity.Orders;
import com.shop.orders.mapper.OrdersMapper;

import java.util.List;

public interface OrdersDao extends OrdersMapper {
    List<Orders> selectByBuyerId(int buyerId);

    List<Orders> selectBySellerId(int sellerId);
}
