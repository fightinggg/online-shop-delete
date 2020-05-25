package com.shop.goods.service;

import com.shop.common.exception.FallbackException;
import com.shop.common.exception.NoAuthorityException;
import com.shop.common.exception.NoFoundException;
import com.shop.goods.entity.*;

import java.util.List;

public interface GoodsService {

    public String post(int userId, GoodsVO goodsVO) throws FallbackException, NoAuthorityException;

    public String delete(int userId, int goodsId) throws NoAuthorityException, NoFoundException;

    public String put(int userId, GoodsVO goodsVO) throws FallbackException, NoAuthorityException, NoFoundException;

    public GoodsVO get(int goodsId) throws NoFoundException;

    public String addCount(int userId, int goodsId, int count);

    public int getCount(int goodsId);

    public List<Goods> getByPage(int pageBegin, int perPage);

    public List<Goods> getByCategory(String category, int pageBegin, int perPage);

    public List<Goods> getBySeller(int userId, int pageBegin, int perPage);
}
