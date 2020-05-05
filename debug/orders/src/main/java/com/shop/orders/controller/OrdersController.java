package com.shop.orders.controller;

import com.alibaba.fastjson.JSON;
import com.shop.orders.entity.Orders;
import com.shop.orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    // 添加订单
    @PostMapping("/buyer/{buyerId}")
    public String post(@PathVariable int buyerId, @RequestBody Orders orders) {
        return JSON.toJSONString(ordersService.localpost(orders));
    }

    // 取消订单
    @DeleteMapping("buyer/{buyerId}/{ordersId}")
    public String delete(@PathVariable int buyerId, @PathVariable int ordersId) {
        return JSON.toJSONString(ordersService.delete(buyerId, ordersId));
    }

    // 完成订单
    @PutMapping("buyer/{buyerId}/{ordersId}/successed")
    public String successed(@PathVariable int buyerId, @PathVariable int ordersId) {
        return JSON.toJSONString(ordersService.successed(buyerId, ordersId));
    }

    // 查看订单
    @GetMapping("buyer/{buyerId}")
    public String get(@PathVariable int buyerId){
        return JSON.toJSONString(ordersService.buyerget(buyerId));
    }
    // 查看订单
    @GetMapping("seller/{sellerId}")
    public String sellerGet(@PathVariable int sellerId){
        return JSON.toJSONString(ordersService.sellerGet(sellerId));
    }
}
