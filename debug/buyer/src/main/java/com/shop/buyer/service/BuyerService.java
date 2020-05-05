package com.shop.buyer.service;

import com.shop.buyer.dao.BuyerDao;
import com.shop.buyer.dao.BuyermoneyDao;
import com.shop.buyer.entity.Buyer;
import com.shop.buyer.entity.Buyermoney;
import com.shop.buyer.mapper.BuyerMapper;
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
public class BuyerService {
    @Autowired
    BuyerDao buyerDao;
    @Autowired
    BuyermoneyDao buyermoneyDao;

    // 个人信息查询
    public Buyer get(int id) {
        return buyerDao.selectByPrimaryKey(id);
    }

    // 余额查询
    public int getMoney(int id) {
        return buyermoneyDao.selectByPrimaryKey(id).getMoney();
    }

    // 个人信息修改
    public int put(Buyer buyer) {
        return buyerDao.updateByPrimaryKey(buyer);
    }

    // 注册账号
    // TODO 事务
    public int post(Buyer buyer) {
        Buyermoney buyermoney = new Buyermoney();
        buyermoney.setId(buyer.getId());
        buyermoney.setMoney(0);
        buyerDao.insert(buyer);
        buyermoneyDao.insertSelective(buyermoney);
        return 1;
    }

    // 充值
    public int addMoney(int id, int money) {
        Buyermoney buyermoney = buyermoneyDao.selectByPrimaryKey(id);
        buyermoney.setMoney(buyermoney.getMoney() + money);
        return buyermoneyDao.updateByPrimaryKey(buyermoney);
    }
}
