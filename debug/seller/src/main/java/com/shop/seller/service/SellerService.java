package com.shop.seller.service;

import com.shop.seller.dao.SellerDao;
import com.shop.seller.dao.SellerMoneyDao;
import com.shop.seller.entity.Seller;
import com.shop.seller.entity.Sellermoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * * 注册账号
 * * 登陆账号
 * * 充值
 * * 浏览商品
 * * 购买商品
 * * 浏览订单
 * * 确认收货
 */
@Service
public class SellerService {
    @Autowired
    SellerDao sellerDao;
    @Autowired
    SellerMoneyDao sellerMoneyDao;


    // 个人信息查询
    public Seller get(int id) {
        return sellerDao.selectByPrimaryKey(id);
    }

    // 余额查询
    public int getMoney(int id) {
        return sellerMoneyDao.selectByPrimaryKey(id).getMoney();
    }

    // 个人信息修改
    public int put(Seller seller) {
        return sellerDao.updateByPrimaryKeySelective(seller);
    }

    // 注册账号
    // TODO 分布式事务
    public int post(Seller seller) {
        Sellermoney sellermoney = new Sellermoney();
        sellermoney.setMoney(0);
        sellermoney.setId(seller.getId());
        sellerDao.insertSelective(seller);
        sellerMoneyDao.insertSelective(sellermoney);
        return 1;
    }

    // 提现
    public int delMoney(int id, int money) {
        Sellermoney sellermoney = sellerMoneyDao.selectByPrimaryKey(id);
        sellermoney.setMoney(sellermoney.getMoney() - money);
        return sellerMoneyDao.updateByPrimaryKeySelective(sellermoney);
    }

}
