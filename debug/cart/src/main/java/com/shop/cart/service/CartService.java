package com.shop.cart.service;

import com.shop.cart.dao.CartDao;
import com.shop.cart.entity.Cart;
import com.shop.common.annotation.enable.EnableUidServiceFeignAutoConfiguration;
import com.shop.common.exception.FallbackException;
import com.shop.common.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@EnableUidServiceFeignAutoConfiguration
public class CartService {
    @Autowired
    CartDao cartDao;
    @Autowired
    UidService uidService;

    public Object delete(Integer id, Integer cartId) {
        return cartDao.deleteByIdAndCartId(id, cartId);
    }

    public Object post(Integer id, Cart cart) throws FallbackException {
        cart.setBuyerId(id);
        cart.setGlobalId((Long) uidService.getUid());
        return cartDao.insert(cart);
    }

    public Object get(Integer userId) {
        return cartDao.selectByUserId(userId);
    }
}
