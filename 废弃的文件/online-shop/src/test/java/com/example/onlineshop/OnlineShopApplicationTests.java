package com.example.onlineshop;

import com.example.onlineshop.service.SellerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineShopApplicationTests {
    @Autowired
    SellerService sellerService;


    @Test
    void contextLoads() {
//        sellerService.getOrders(1);
    }

}
