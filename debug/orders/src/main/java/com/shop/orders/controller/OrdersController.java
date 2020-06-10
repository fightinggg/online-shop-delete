package com.shop.orders.controller;

import com.alibaba.fastjson.JSON;
import com.shop.common.annotation.ResponseEncode;
import com.shop.common.exception.FallbackException;
import com.shop.common.exception.NoAuthorityException;
import com.shop.common.exception.NoFoundException;
import com.shop.orders.entity.Orders;
import com.shop.orders.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    // 添加订单
    @PostMapping(value = "/", produces = "application/json;charset=utf-8")
    @ResponseEncode
    public Object post(@RequestHeader int id, @RequestBody Orders orders) throws FallbackException {
        log.info("用户{}添加了订单{}", id, orders);
        return ordersService.post(id, orders);
    }

    // 取消订单
    @DeleteMapping(value = "/{ordersId}", produces = "application/json;charset=utf-8")
    @ResponseEncode
    public Object delete(@RequestHeader int id, @PathVariable int ordersId) throws NoAuthorityException, NoFoundException {
        log.info("用户{}取消了订单{}", id, ordersId);
        return ordersService.delete(id, ordersId);
    }

    // 完成订单
    @PutMapping(value = "/successed/{ordersId}", produces = "application/json;charset=utf-8")
    @ResponseEncode
    public Object successed(@RequestHeader int id, @PathVariable int ordersId) {
        log.info("用户{}完成了订单{}", id, ordersId);
        return ordersService.successed(id, ordersId);
    }

    // 查看订单
    @GetMapping(value = "/{pageBegin}/{perPage}", produces = "application/json;charset=utf-8")
    @ResponseEncode
    public Object get(@RequestHeader int id,
                      @PathVariable int pageBegin,
                      @PathVariable int perPage) {
        log.info("用户{}查看了自己的订单", id);
        return ordersService.get(id,pageBegin,perPage);
    }
}
