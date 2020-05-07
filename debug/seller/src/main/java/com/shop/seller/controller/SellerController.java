package com.shop.seller.controller;

import com.alibaba.fastjson.JSON;
import com.shop.seller.entity.Seller;
import com.shop.seller.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
public class SellerController {
    @Autowired
    SellerService sellerService;

    // 登陆
    @PostMapping("/everyone/null/{sellerId}/login")
    public String postLogin(@PathVariable int sellerId, @RequestBody int password, HttpSession httpSession) {
        Seller seller = sellerService.get(sellerId);
        if (seller.getPassword() != password) {
            return JSON.toJSONString("密码错误");
        } else {
            httpSession.setAttribute("seller", String.valueOf(sellerId));
            return JSON.toJSONString("登陆成功");
        }
    }

    // 查看账号信息
    @GetMapping("/seller/{sellerId}")
    public String get(@PathVariable int sellerId) {
        return JSON.toJSONString(sellerService.get(sellerId));
    }

    // 查询余额
    @GetMapping("/seller/{sellerId}/money")
    public String getMoney(@PathVariable int sellerId){
        return JSON.toJSONString(sellerService.getMoney(sellerId));
    }

    // 修改个人信息
    @PutMapping("/seller/{sellerId}")
    public String put(@RequestBody Seller seller) {
        return JSON.toJSONString(sellerService.put(seller));
    }


    // 注册账号
    @PostMapping("everyone/null")
    public String register(@RequestBody Seller seller) {
        return JSON.toJSONString(sellerService.post(seller));
    }


    // 提现
    @PutMapping("/seller/{sellerId}/submoney/{money}")
    public String addMoney(@PathVariable int sellerId, @PathVariable int money) {
        return JSON.toJSONString(sellerService.delMoney(sellerId, money));
    }
}




