package com.shop.cart.entity;

import java.io.Serializable;

public class Cart implements Serializable {
    private Integer id;

    private Long globalId;

    private Integer buyerId;

    private Integer goodsId;

    private Integer counts;

    private Integer addressId;

    private static final long serialVersionUID = 1L;

    public Cart(Integer id, Long globalId, Integer buyerId, Integer goodsId, Integer counts, Integer addressId) {
        this.id = id;
        this.globalId = globalId;
        this.buyerId = buyerId;
        this.goodsId = goodsId;
        this.counts = counts;
        this.addressId = addressId;
    }

    public Cart() {
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

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", globalId=").append(globalId);
        sb.append(", buyerId=").append(buyerId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", counts=").append(counts);
        sb.append(", addressId=").append(addressId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}