package com.example.onlineshop.dao;

import com.example.onlineshop.entity.Buyer;
import com.example.onlineshop.entity.Order;
import com.example.onlineshop.mapper.OrderMapper;

import java.util.List;

public interface OrderDao extends OrderMapper {
    List<Order> selectByBuyerId(int id);

    List<Order> selectBySellerId(int id);
}
