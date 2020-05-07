package com.shop.goods.controller;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shop.goods.entity.Goods;
import com.shop.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    // 创建商品
    @PostMapping("/seller/{sellerId}")
    public String post(@PathVariable int sellerId, @RequestBody Goods goods) {
        return JSON.toJSONString(goodsService.post(sellerId, goods));
    }

    // 商品修改
    @PutMapping("/seller/{sellerId}")
    public String put(@PathVariable int sellerId, @RequestBody Goods goods) {
        return JSON.toJSONString(goodsService.put(sellerId, goods));
    }

    // 查询商品
    @GetMapping("/everyone/null/{pageBegin}/{perpage}")
    @HystrixCommand(fallbackMethod = "getFallback")
    public String get(@PathVariable int pageBegin, @PathVariable int perpage) {
        return JSON.toJSONString(goodsService.get(pageBegin, perpage));
    }
    // 查询熔断
    public String getFallback(int pageBegin, int perpage) {
        return JSON.toJSONString("当前访问的人似乎有点多，请稍后再访问[服务熔断]");
    }
}


