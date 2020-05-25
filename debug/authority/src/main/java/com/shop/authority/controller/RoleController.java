package com.shop.authority.controller;

import com.alibaba.fastjson.JSON;
import com.shop.authority.entity.Role;
import com.shop.authority.service.RoleService;
import com.shop.common.annotation.ResponseEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    // 查询角色
    @GetMapping("/role/{pageBegin}/{perPage}")
    @ResponseEncode
    Object search(@PathVariable int pageBegin, @PathVariable int perPage) {
        return roleService.search(pageBegin, perPage);
    }

    // 增加角色
    @PostMapping("/role")
    @ResponseEncode
    Object insert(@RequestBody Role role) {
        return roleService.insert(role);
    }

    // 修改角色
    @PutMapping("/role")
    @ResponseEncode
    Object update(@RequestBody Role role) {
        return roleService.update(role);
    }

    // 删除角色
    @DeleteMapping("/role/{roleId}")
    @ResponseEncode
    Object erase(@PathVariable int roleId) {
        return roleService.erase(roleId);
    }
}
