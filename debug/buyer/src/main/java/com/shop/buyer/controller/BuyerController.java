package com.shop.buyer.controller;

import com.shop.buyer.entity.Buyer;
import com.shop.buyer.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

@RestController
public class BuyerController {
    @Autowired
    BuyerService buyerService;

    // 查看账号信息
    @GetMapping("/buyer/{buyerId}")
    public String get(@PathVariable int buyerId) {
        return JSON.toJSONString(buyerService.get(buyerId));
    }

    // 查询个人余额
    @GetMapping("buyer/{buyerId}/money")
    public String getMoney(@PathVariable int buyerId){
        return JSON.toJSONString(buyerService.getMoney(buyerId));
    }

    // 修改账号信息
    @PutMapping("/buyer/{buyerId}")
    public String put(@PathVariable int buyerId, @RequestBody Buyer buyer) {
        if (!buyer.getId().equals(buyerId)) return JSON.toJSONString("error");
        else return JSON.toJSONString(buyerService.put(buyer));
    }

    // 注册账号
    @PostMapping("/everyone/null")
    public String post(@RequestBody Buyer buyer) {
        return JSON.toJSONString(buyerService.post(buyer));
    }



    // 充值
    @PutMapping("/buyer/{buyerId}/addmoney/{money}")
    public String addMoney(@PathVariable int buyerId, @PathVariable int money) {
        return JSON.toJSONString(buyerService.addMoney(buyerId, money));
    }
}



