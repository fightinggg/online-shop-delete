package com.shop.authority.controller;

import com.alibaba.fastjson.JSON;
import com.shop.authority.entity.Role;
import com.shop.authority.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    // 查询角色
    @GetMapping("/search_role/{pageBegin}/{perPage}")
    String search(@PathVariable int pageBegin, @PathVariable int perPage) {
        return JSON.toJSONString(roleService.search(pageBegin,perPage));
    }

    // 增加角色
    @PostMapping("/insert_role")
    String insert(@RequestBody Role role) {
        return JSON.toJSONString(roleService.insert(role));
    }

    // 修改角色
    @PutMapping("/update_role")
    String update(@RequestBody Role role) {
        return JSON.toJSONString(roleService.update(role));
    }

    // 删除角色
    @DeleteMapping("/erase_role/{roleId}")
    String erase(@PathVariable int roleId) {
        return JSON.toJSONString(roleService.erase(roleId));
    }
}
