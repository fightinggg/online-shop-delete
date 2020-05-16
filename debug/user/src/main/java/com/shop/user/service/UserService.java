package com.shop.user.service;

import com.shop.user.dao.MoneyDao;
import com.shop.user.dao.UserDao;
import com.shop.user.entity.Money;
import com.shop.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    MoneyDao moneyDao;

    // 个人信息查询
    public User get(int id) {
        return userDao.selectByPrimaryKey(id);
    }

    // 余额查询
    public int getMoney(int id) {
        return moneyDao.selectByPrimaryKey(id).getMoney();
    }

    // 个人信息修改
    public int put(User user) {
        return userDao.updateByPrimaryKey(user);
    }

    // 注册账号
    // TODO 事务
    public int post(User user) {
        Money usermoney = new Money();
        usermoney.setId(user.getId());
        usermoney.setMoney(0);
        userDao.insert(user);
        moneyDao.insertSelective(usermoney);
        return 1;
    }

    // 充值
    public int addMoney(int id, int money) {
        Money usermoney = moneyDao.selectByPrimaryKey(id);
        usermoney.setMoney(usermoney.getMoney() + money);
        return moneyDao.updateByPrimaryKey(usermoney);
    }

    public boolean idIsEffective(int userId) {
        User user = userDao.selectByPrimaryKey(userId);
        return user==null;
    }
}
