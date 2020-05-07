package com.shop.email.service;

import com.shop.email.dao.BuyerDao;
import com.shop.email.dao.OrdersDao;
import com.shop.email.entity.Buyer;
import com.shop.email.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailService {
    @Autowired
    BuyerDao buyerDao;

    @Transactional
    public void sendEmail(Orders orders) {
        System.out.println("send" + orders.getId());

//        if(System.currentTimeMillis()%2==0) {
//            int x =2/0;
//        }
    }
}
