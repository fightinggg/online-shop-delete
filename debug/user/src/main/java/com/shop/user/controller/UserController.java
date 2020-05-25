package com.shop.user.controller;

import com.alibaba.fastjson.JSON;
import com.shop.common.annotation.ResponseEncode;
import com.shop.user.entity.User;
import com.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    // 注册账号
    @PostMapping("/")
    @ResponseEncode
    public Object post(@RequestBody User user) {
        return userService.post(user);
    }

    // 查询账号是否可用
    @GetMapping("/id/is/effective/{searchId}")
    @ResponseEncode
    public Object getBuyerIdIsEffective(@PathVariable int searchId){
        return userService.idIsEffective(searchId);
    }

    // 查看自己账号的信息
    @GetMapping("/")
    @ResponseEncode
    public Object get(@RequestHeader int id) {
        return userService.get(id);
    }

    // 查询个人余额
    @GetMapping("/money")
    @ResponseEncode
    public Object getMoney(@RequestHeader int id) {
        return userService.getMoney(id);
    }

    // 修改账号信息
    @PutMapping("/")
    @ResponseEncode
    public Object put(@RequestHeader int id, @RequestBody User user) {
        user.setId(id);
        return userService.put(user);
    }

    // 充值
    @PutMapping("/add/money/{money}")
    @ResponseEncode
    public Object addMoney(@RequestHeader int id, @PathVariable int money) {
        return userService.addMoney(id, money);
    }


}

//

