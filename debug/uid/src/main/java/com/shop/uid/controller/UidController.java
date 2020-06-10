package com.shop.uid.controller;

import com.shop.common.annotation.ResponseEncode;
import com.shop.uid.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UidController {
    @Autowired
    UidService uidService;

    static volatile int x = 1;

    @GetMapping(value = "/")
    @ResponseEncode
    Object getUid() throws Exception {
        System.out.println("get uid");
        x++;
        if (x % 20 == 0)
            throw new Exception("fuck");
        return uidService.getUID();
    }
}
