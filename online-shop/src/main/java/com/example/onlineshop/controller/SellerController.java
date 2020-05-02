package com.example.onlineshop.controller;

import com.alibaba.fastjson.JSON;
import com.example.onlineshop.entity.Buyer;
import com.example.onlineshop.entity.Order;
import com.example.onlineshop.entity.Seller;
import com.example.onlineshop.service.OrderService;
import com.example.onlineshop.service.SellerService;
import com.sun.tools.corba.se.idl.constExpr.Or;
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

    @Autowired
    OrderService orderService;

    // 增
    @PostMapping("")
    String post(@RequestBody Seller seller) {
        return JSON.toJSONString(sellerService.post(seller));
    }

    //删
    @DeleteMapping("/{id}")
    String delete(@PathVariable("id") int id) {
        return JSON.toJSONString(sellerService.delete(id));
    }

    // 改
    @PutMapping("")
    String put(@RequestBody Seller seller) {
        return JSON.toJSONString(sellerService.post(seller));
    }

    // 查
    @GetMapping("/{id}")
    String get(@PathVariable("id") int id) {
        return JSON.toJSONString(sellerService.get(id));
    }

    @GetMapping("/login")
    String login(@RequestBody Seller seller, HttpSession httpSession) {
        int id = seller.getId();
        int password = seller.getPassword();
        seller = sellerService.get(id);
        if (seller != null && seller.getPassword().equals(password)) {
            httpSession.setAttribute("seller", seller);
            return JSON.toJSONString("登陆成功");
        } else {
            return JSON.toJSONString("登陆失败");
        }
    }

    @GetMapping("/order")
    String getOrder(Model model) {
        Seller seller = (Seller) model.getAttribute("seller");
        return JSON.toJSONString(orderService.findBySellerId(seller.getId()));
    }

}
