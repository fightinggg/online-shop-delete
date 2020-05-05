package com.example.onlineshop.controller;

import com.alibaba.fastjson.JSON;
import com.example.onlineshop.entity.*;
import com.example.onlineshop.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/seller")
@SessionAttributes("seller")
public class SellerController {
    @Autowired
    SellerService sellerService;

    // 注册
    @PostMapping("/regirster")
    public String postSeller(@RequestBody Seller seller) {
        return JSON.toJSONString(sellerService.postSeller(seller));
    }

    // 登陆
    @PostMapping("/login")
    public String getSeller(@RequestBody Seller seller, HttpSession httpSession) {
        int id = seller.getId();
        int passward = seller.getPassword();
        seller = sellerService.getSeller(id);
        if (seller != null && seller.getPassword().equals(passward)) {
            httpSession.setAttribute("seller", seller);
            return JSON.toJSONString("登陆成功");
        } else {
            return JSON.toJSONString("登陆失败");
        }
    }

    // 提现
    @PutMapping("/subMoney")
    public String subMoney(@RequestBody int money, Model model) {
        Seller seller = (Seller) model.getAttribute("seller");
        return JSON.toJSONString(sellerService.subMoney(seller.getId(), money));
    }

    //发布商品
    @PostMapping("/goods")
    public String postGoods(@RequestBody Goods goods) {
        return JSON.toJSONString(sellerService.postGoods(goods));
    }

    // 修改
    @PutMapping("/goods")
    public String putGoods(@RequestBody Goods goods) {
        return JSON.toJSONString(sellerService.putGoods(goods));
    }

    // 浏览订单
    @GetMapping("/orders")
    public String getOrders(Model model) {
        Seller seller = (Seller) model.getAttribute("seller");
        return JSON.toJSONString(sellerService.getOrders(seller.getId()));
    }
}
