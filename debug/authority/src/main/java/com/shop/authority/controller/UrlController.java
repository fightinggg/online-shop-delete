package com.shop.authority.controller;

import com.alibaba.fastjson.JSON;
import com.shop.authority.entity.Url;
import com.shop.authority.service.UrlService;
import com.shop.common.annotation.ResponseEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {
    @Autowired
    UrlService urlService;

    @GetMapping("/url/{pageBegin}/{perPage}")
    @ResponseEncode
    Object searchAllUrl(@PathVariable int pageBegin, @PathVariable int perPage){
        return urlService.searchAllUrl(pageBegin,perPage);
    }

    @PostMapping("/url")
    @ResponseEncode
    Object put(@RequestBody Url url){
        return urlService.add(url);
    }
}
