package com.shop.phone.service;

import com.shop.phone.dao.BuyerDao;
import com.shop.phone.dao.PhoneTransactionDao;
import com.shop.phone.entity.Buyer;
import com.shop.phone.entity.Orders;
import com.shop.phone.entity.PhoneTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PhoneTransactionService {
    @Autowired
    BuyerDao buyerDao;

    @Autowired
    PhoneTransactionDao phoneTransactionDao;
    // TODO
    @Transactional
    public void sendEmail(Orders orders) {
        // 这里要保证幂等性
        PhoneTransaction phoneTransaction = phoneTransactionDao.selectByPrimaryKey(orders.getId());
        if(phoneTransaction==null){
            phoneTransaction = new PhoneTransaction();
            phoneTransaction.setOrdersid(orders.getId());
            phoneTransactionDao.insert(phoneTransaction);
            Buyer buyer = buyerDao.selectByPrimaryKey(orders.getBuyerid());
            System.out.println("send phone to "+buyer.getName()+" his phone is "+buyer.getPhonenum());
        }
        else{
            System.out.println("幂等拒绝多次服务");
        }
    }

}
