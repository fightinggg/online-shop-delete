package com.shop.authority.controller;

import com.alibaba.fastjson.JSON;
import com.shop.authority.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {
    @Autowired
    UrlService urlService;

    @GetMapping("/search_all_url/{pageBegin}/{perPage}")
    String searchAllUrl(@PathVariable int pageBegin, @PathVariable int perPage){
        return JSON.toJSONString(urlService.searchAllUrl(pageBegin,perPage));
    }
}
