package com.example.onlineshop.controller;

import com.alibaba.fastjson.JSON;
import com.example.onlineshop.entity.Buyer;
import com.example.onlineshop.entity.Order;
import com.example.onlineshop.service.BuyerService;
import com.example.onlineshop.service.OrderService;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/buyer")
@SessionAttributes("buyer")
public class BuyerController {
    @Autowired
    BuyerService buyerService;
    @Autowired
    OrderService orderService;

    // 增
    @PostMapping("")
    String post(@RequestBody Buyer buyer) {
        return JSON.toJSONString(buyerService.post(buyer));
    }

    //删
    @DeleteMapping("/{id}")
    String delete(@PathVariable("id") int id) {
        return JSON.toJSONString(buyerService.delete(id));
    }

    // 改
    @PutMapping("")
    String put(@RequestBody Buyer buyer) {
        return JSON.toJSONString(buyerService.post(buyer));
    }

    // 查
    @GetMapping("/{id}")
    String get(@PathVariable("id") int id) {
        return JSON.toJSONString(buyerService.get(id));
    }

    @GetMapping("/login")
    String login(@RequestBody Buyer buyer, HttpSession httpSession) {
        int id = buyer.getId();
        int passward = buyer.getPassword();
        buyer = buyerService.get(id);
        if (buyer != null && buyer.getPassword().equals(passward)) {
            httpSession.setAttribute("buyer", buyer);
            return JSON.toJSONString("登陆成功");
        } else {
            return JSON.toJSONString("登陆失败");
        }
    }

    @GetMapping("/order")
    String getOrder(Model model) {
        Buyer buyer = (Buyer) model.getAttribute("buyer");
        return JSON.toJSONString(orderService.findByBuyerId(buyer.getId()));
    }

    @PostMapping("/order")
    String putOrder(@RequestBody Order order, Model model) {
        Buyer buyer = (Buyer) model.getAttribute("buyer");
        order.setBuyerid(buyer.getId());
        return JSON.toJSONString(orderService.post(order));
    }
}

