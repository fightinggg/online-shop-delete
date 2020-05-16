package com.shop.user.controller;

import com.alibaba.fastjson.JSON;
import com.shop.user.entity.User;
import com.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    // 注册账号
    @PostMapping("/null/register")
    public String post(@RequestBody User user) {
        return JSON.toJSONString(userService.post(user));
    }

    // 查询账号是否可用
    @GetMapping("/null/id_is_effective/{searchId}")
    public String getBuyerIdIsEffective(@PathVariable int searchId){
        return JSON.toJSONString(userService.idIsEffective(searchId));
    }

    // 查看自己账号的信息
    @GetMapping("/{id}")
    public String get(@PathVariable("id") int id) {
        return JSON.toJSONString(userService.get(id));
    }

    // 查询个人余额
    @GetMapping("/{id}/money")
    public String getMoney(@PathVariable("id") int id) {
        return JSON.toJSONString(userService.getMoney(id));
    }

    // 修改账号信息
    @PutMapping("/{id}")
    public String put(@PathVariable int id, @RequestBody User user) {
        return JSON.toJSONString(userService.put(user));
    }

    // 充值
    @PutMapping("/{id}/addmoney/{money}")
    public String addMoney(@PathVariable int id, @PathVariable int money) {
        return JSON.toJSONString(userService.addMoney(id, money));
    }
}
