package com.example.onlineshop.service;

import com.example.onlineshop.entity.Buyer;
import com.example.onlineshop.mapper.BuyerMapper;
import com.example.onlineshop.mapper.GoodsMapper;
import com.example.onlineshop.mapper.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class BuyerService {
    @Autowired
    BuyerMapper buyerMapper;

    public int post(Buyer buyer) {
        return buyerMapper.insert(buyer);
    }

    public int delete(int id) {
        return buyerMapper.deleteByPrimaryKey(id);
    }

    public int put(Buyer buyer) {
        return buyerMapper.updateByPrimaryKey(buyer);
    }

    public Buyer get(int id) {
        return buyerMapper.selectByPrimaryKey(id);
    }


}
