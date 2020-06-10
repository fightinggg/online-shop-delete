package com.shop.cart.controller;

import com.shop.cart.entity.Cart;
import com.shop.cart.service.CartService;
import com.shop.common.annotation.ResponseEncode;
import com.shop.common.annotation.enable.EnableResponseEncodeAutoConfigration;
import com.shop.common.exception.FallbackException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@EnableResponseEncodeAutoConfigration
public class CartController {
    @Autowired
    CartService cartService;

    /**
     * 查看自己的购物车
     * @param id
     * @return
     */
    @GetMapping("/")
    @ResponseEncode
    Object get(@RequestHeader Integer id) {
        log.info("用户{}查看了自己的购物车", id);
        return cartService.get(id);
    }

    /**
     * 把商品加入购物车
     * @param id
     * @return
     */
    @PostMapping("/")
    @ResponseEncode
    Object post(@RequestHeader Integer id, @RequestBody Cart cart) throws FallbackException {
        log.info("用户{}把一个商品{}加入了自己的购物车", id, cart);
        return cartService.post(id, cart);
    }

    @DeleteMapping("/{cartId}")
    @ResponseEncode
    Object delete(@RequestHeader Integer id, @PathVariable Integer cartId) {
        log.info("用户{}删除了购物车的东西{}", id, cartId);
        return cartService.delete(id, cartId);
    }

    @PostMapping("/buy/{cartId}")
    @ResponseEncode
    Object buyer(@RequestHeader Integer id, @PathVariable Integer cartId) {
        log.info("用户{}直接购买了购物车中的东西{}", id, cartId);
        cartService.delete(id, cartId);
        return "失败了";
    }

}
