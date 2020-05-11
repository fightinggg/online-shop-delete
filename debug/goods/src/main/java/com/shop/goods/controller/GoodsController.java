package com.shop.goods.controller;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shop.goods.entity.SendGoods;
import com.shop.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    // 创建商品
    @PostMapping("/seller/{sellerId}")
    public String post(@PathVariable int sellerId, @RequestBody SendGoods sendGoods) {
        System.out.println(sendGoods.toString());
        return JSON.toJSONString(goodsService.post(sellerId, sendGoods));
    }

    // 商品删除
    @DeleteMapping("/seller/{sellerId}/{goodsId}")
    public String delete(@PathVariable int sellerId, @PathVariable int goodsId) {
        return JSON.toJSONString(goodsService.delete(sellerId, goodsId));
    }

    // 商品修改
    @PutMapping("/seller/{sellerId}")
    public String put(@PathVariable int sellerId, @RequestBody SendGoods sendGoods) {
        return JSON.toJSONString(goodsService.put(sellerId, sendGoods));
    }

    // 商品余量修改
    @PutMapping("/seller/{sellerId}/{goodsId}/{count}")
    public  String putCount(@PathVariable int sellerId, @PathVariable int goodsId,@PathVariable int count) {
        return JSON.toJSONString(goodsService.putCount(sellerId,goodsId,count));
    }

    // 查询商品
    @GetMapping("/everyone/null/{pageBegin}/{perpage}")
    @HystrixCommand(fallbackMethod = "getFallback")
    public String get(@PathVariable int pageBegin, @PathVariable int perpage) {
        return JSON.toJSONString(goodsService.get(pageBegin, perpage));
    }

    // 根据卖家查询全部商品
    @PutMapping("/everyone/null/{sellerId}/{pageBegin}/{perpage}")
    public String getBySeller(@PathVariable int sellerId,
                              @PathVariable int pageBegin,
                              @PathVariable int perpage) {
        return JSON.toJSONString(goodsService.getBySeller(sellerId, pageBegin, perpage));
    }

    // 根据类型查询
    @GetMapping("/everyone/null/{category}/{pageBegin}/{perpage}")
    public String getByCategory(@PathVariable String category,
                                @PathVariable int pageBegin,
                                @PathVariable int perpage) {
        return JSON.toJSONString(goodsService.getByCategory(category, pageBegin, perpage));
    }

    // 查询熔断
    public String getFallback(int pageBegin, int perpage) {
        return JSON.toJSONString("当前访问的人似乎有点多，请稍后再访问[服务熔断]");
    }

}


