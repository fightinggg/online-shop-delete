package com.shop.user.service;

import com.shop.common.MyUtils;
import com.shop.user.dao.MoneyDao;
import com.shop.user.dao.UserDao;
import com.shop.user.entity.Money;
import com.shop.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    MoneyDao moneyDao;

    // 个人信息查询
    public User get(int id) {
        User user = userDao.selectByPrimaryKey(id);
        user.setPassword(null);
        user.setGloablId(null);
        return user;
    }

    // 余额查询
    public int getMoney(int id) {
        return moneyDao.selectByPrimaryKey(id).getMoney();
    }

    // 个人信息修改
    public int put(User user) {
        if (user.getPassword() != null) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        }

        User old = userDao.selectByPrimaryKey(user.getId());
        MyUtils.upd(old, user, user.getClass());

        return userDao.updateByPrimaryKey(user);
    }

    // 注册账号
    // TODO 事务
    public int post(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        Money money = new Money();
        money.setId(user.getId());
        money.setMoney(0);
        userDao.insert(user);
        moneyDao.insertSelective(money);
        return 1;
    }

    // 充值
    public int addMoney(int id, int money) {
        Money oldMoney = moneyDao.selectByPrimaryKey(id);
        oldMoney.setMoney(oldMoney.getMoney() + money);
        return moneyDao.updateByPrimaryKey(oldMoney);
    }

    public boolean idIsEffective(int userId) {
        User user = userDao.selectByPrimaryKey(userId);
        return user == null;
    }
}
