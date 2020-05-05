package com.example.onlineshop.controller;

import com.alibaba.fastjson.JSON;
import com.example.onlineshop.entity.*;
import com.example.onlineshop.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/buyer")
@SessionAttributes("buyer")
public class BuyerController {
    @Autowired
    BuyerService buyerService;

    // 注册账号
    @PostMapping("/register")
    public String postBuyer(@RequestBody Buyer buyer) {
        return JSON.toJSONString(buyerService.postBuyer(buyer));
    }

    // 登陆账号
    @PostMapping("/login")
    public String getBuyer(@RequestBody Buyer buyer, HttpSession httpSession) {
        int id = buyer.getId();
        int passward = buyer.getPassword();
        buyer = buyerService.getBuyer(id);
        if (buyer != null && buyer.getPassword().equals(passward)) {
            httpSession.setAttribute("buyer", buyer);
            return JSON.toJSONString("登陆成功");
        } else {
            return JSON.toJSONString("登陆失败");
        }
    }

    // 充值
    @PutMapping("/addmoney")
    public String addMoney(@RequestBody int money, Model model) {
        Buyer buyer = (Buyer) model.getAttribute("buyer");
        return JSON.toJSONString(buyerService.addMoney(buyer.getId(), money));
    }

    // 浏览商品
    @GetMapping("/goods")
    public String getGoods() {
        return JSON.toJSONString(buyerService.getGoods());
    }

    // 购买商品
    @PostMapping("/orders")
    public String postOrder(@RequestBody Orders orders, Model model) {
        Buyer buyer = (Buyer) model.getAttribute("buyer");
        orders.setId(buyer.getId());
        return JSON.toJSONString(buyerService.postOrder(orders));
    }

    // 浏览订单
    @GetMapping("/orders")
    public String getOrders(Model model) {
        Buyer buyer = (Buyer) model.getAttribute("buyer");
        return JSON.toJSONString(buyerService.getOrders(buyer.getId()));
    }

    // 确认收货
    @PutMapping("/orders")
    public String closeOrders(@RequestBody int id, Model model) {
        return JSON.toJSONString(buyerService.closeOrders(id));
    }
}




