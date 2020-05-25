package com.shop.authority.controller;

import com.alibaba.fastjson.JSON;
import com.shop.authority.entity.User;
import com.shop.authority.entity.UserRole;
import com.shop.authority.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;

    @GetMapping("/user/have/what/role/{userId}")
    String user_have_what_role(@PathVariable int userId){
        return JSON.toJSONString(userRoleService.user_have_what_role(userId));
    }

    @GetMapping("/role/have/what/user/{roleId}")
    String role_have_what_user(@PathVariable int roleId){
        return JSON.toJSONString(userRoleService.role_have_what_user(roleId));
    }

    @PostMapping("/user/role")
    String insert_user_role(@RequestBody UserRole userRole){
        return JSON.toJSONString(userRoleService.insert_user_role(userRole));
    }

    @DeleteMapping("/user/role/{id}")
    String delete_user_role(@PathVariable int id){
        return JSON.toJSONString(userRoleService.delete_user_role(id));
    }

}
