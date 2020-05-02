package com.example.onlineshop.service;

import com.example.onlineshop.entity.Seller;
import com.example.onlineshop.mapper.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SellerService {
    @Autowired
    SellerMapper sellerMapper;

    public int post(Seller seller) {
        return sellerMapper.insert(seller);
    }

    public int delete(int id) {
        return sellerMapper.deleteByPrimaryKey(id);
    }

    public int put(Seller seller) {
        return sellerMapper.updateByPrimaryKey(seller);
    }

    public Seller get(int id) {
        return sellerMapper.selectByPrimaryKey(id);
    }
}
