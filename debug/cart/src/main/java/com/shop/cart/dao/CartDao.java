package com.shop.cart.dao;

import com.shop.cart.mapper.CartMapper;

public interface CartDao extends CartMapper {
    Object selectByUserId(Integer userId);

    Object deleteByIdAndCartId(Integer userId, Integer cartId);
}
