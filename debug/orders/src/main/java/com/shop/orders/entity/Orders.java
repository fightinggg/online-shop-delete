package com.shop.orders.entity;

import java.io.Serializable;

public class Orders implements Serializable {
    private Integer id;

    private Long globalId;

    private Integer buyerId;

    private Integer sellerId;

    private Integer goodsId;

    private Integer price;

    private Integer counts;

    private Integer addressId;

    private Boolean buyerSubmit;

    private Boolean sellerSubmit;

    private static final long serialVersionUID = 1L;

    public Orders(Integer id, Long globalId, Integer buyerId, Integer sellerId, Integer goodsId, Integer price, Integer counts, Integer addressId, Boolean buyerSubmit, Boolean sellerSubmit) {
        this.id = id;
        this.globalId = globalId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.goodsId = goodsId;
        this.price = price;
        this.counts = counts;
        this.addressId = addressId;
        this.buyerSubmit = buyerSubmit;
        this.sellerSubmit = sellerSubmit;
    }

    public Orders() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getGlobalId() {
        return globalId;
    }

    public void setGlobalId(Long globalId) {
        this.globalId = globalId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Boolean getBuyerSubmit() {
        return buyerSubmit;
    }

    public void setBuyerSubmit(Boolean buyerSubmit) {
        this.buyerSubmit = buyerSubmit;
    }

    public Boolean getSellerSubmit() {
        return sellerSubmit;
    }

    public void setSellerSubmit(Boolean sellerSubmit) {
        this.sellerSubmit = sellerSubmit;
    }
}