package com.shop.email.service;

import com.shop.email.dao.BuyerDao;
import com.shop.email.dao.EmailTransactionDao;
import com.shop.email.dao.OrdersDao;
import com.shop.email.entity.Buyer;
import com.shop.email.entity.EmailTransaction;
import com.shop.email.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailService {
    @Autowired
    BuyerDao buyerDao;

    @Autowired
    EmailTransactionDao emailTransactionDao;

    // TODO
    @Transactional
    public void sendEmail(Orders orders) {
        // 这里要保证幂等性
        EmailTransaction emailTransaction = emailTransactionDao.selectByPrimaryKey(orders.getId());
        if(emailTransaction==null){
            emailTransaction = new EmailTransaction();
            emailTransaction.setOrdersid(orders.getId());
            emailTransactionDao.insert(emailTransaction);
            Buyer buyer = buyerDao.selectByPrimaryKey(orders.getBuyerid());
            System.out.println("send email to "+buyer.getName()+" his email is "+buyer.getEmail());
        }
        else{
            System.out.println("幂等拒绝多次服务");
        }
    }
}
