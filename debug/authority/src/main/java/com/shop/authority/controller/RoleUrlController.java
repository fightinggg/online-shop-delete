package com.shop.authority.controller;

import com.alibaba.fastjson.JSON;
import com.shop.authority.entity.RoleUrl;
import com.shop.authority.service.RoleUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleUrlController {
    @Autowired
    RoleUrlService roleUrlService;

    @GetMapping("/role_have_what_url/{roleId}/{pageBegin}/{perPage}")
    String roleHaveWhatUrl(@PathVariable int roleId, @PathVariable String pageBegin, @PathVariable String perPage) {
        return JSON.toJSONString(roleUrlService.roleHaveWhatUrl(roleId,pageBegin,perPage));
    }

    @GetMapping("/url_have_what_role/{urlId}/{pageBegin}/{perPage}")
    String urlHaveWhatRole(@PathVariable int urlId, @PathVariable String pageBegin, @PathVariable String perPage) {
        return JSON.toJSONString(roleUrlService.urlHaveWhatRole(urlId,pageBegin,perPage));
    }

    @PostMapping("/insert_role_url")
    String insert(@RequestBody RoleUrl roleUrl) {
        return JSON.toJSONString(roleUrlService.insert(roleUrl));
    }

    @DeleteMapping("/delete_role_url/{id}")
    String delete(@PathVariable int id) {
        return JSON.toJSONString(roleUrlService.delete(id));
    }
}
