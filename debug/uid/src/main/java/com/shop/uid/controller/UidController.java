package com.shop.uid.controller;

import com.shop.uid.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UidController {
    @Autowired
    UidService uidService;

    @GetMapping("/everyone/null/getUid")
    Long getUid() {
        return uidService.getUID();
    }
}
