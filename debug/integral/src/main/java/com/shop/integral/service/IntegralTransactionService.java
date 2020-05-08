package com.shop.integral.service;


import com.shop.integral.dao.BuyerDao;
import com.shop.integral.dao.BuyerIntegralDao;
import com.shop.integral.dao.IntegralTransactionDao;
import com.shop.integral.entity.Buyer;
import com.shop.integral.entity.BuyerIntegral;
import com.shop.integral.entity.IntegralTransaction;
import com.shop.integral.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IntegralTransactionService {
    @Autowired
    BuyerDao buyerDao;

    @Autowired
    IntegralTransactionDao integralTransactionDao;

    @Autowired
    BuyerIntegralDao buyerIntegralDao;

    // TODO
    @Transactional
    public void sendEmail(Orders orders) {
        // 这里要保证幂等性
        IntegralTransaction integralTransaction = integralTransactionDao.selectByPrimaryKey(orders.getId());
        if(integralTransaction==null){
            integralTransaction = new IntegralTransaction();
            integralTransaction.setOrdersid(orders.getId());
            integralTransactionDao.insert(integralTransaction);
            Buyer buyer = buyerDao.selectByPrimaryKey(orders.getBuyerid());
            BuyerIntegral oldIntegral = buyerIntegralDao.selectByPrimaryKey(orders.getBuyerid());
            oldIntegral.setIntegral(oldIntegral.getIntegral()+10);
            buyerIntegralDao.updateByPrimaryKey(oldIntegral);
        }
        else{
            System.out.println("幂等拒绝多次服务");
        }
    }
}
