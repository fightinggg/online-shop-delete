package com.shop.orders.entity;

import java.io.Serializable;

public class Goods implements Serializable {
    private Integer id;

    private Long globalId;

    private Integer userId;

    private Integer price;

    private String category;

    private Integer allSize;

    private String mainurl;

    private String mainDescribe;

    private String name;

    private static final long serialVersionUID = 1L;

    public Goods(Integer id, Long globalId, Integer userId, Integer price, String category, Integer allSize, String mainurl, String mainDescribe, String name) {
        this.id = id;
        this.globalId = globalId;
        this.userId = userId;
        this.price = price;
        this.category = category;
        this.allSize = allSize;
        this.mainurl = mainurl;
        this.mainDescribe = mainDescribe;
        this.name = name;
    }

    public Goods() {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getAllSize() {
        return allSize;
    }

    public void setAllSize(Integer allSize) {
        this.allSize = allSize;
    }

    public String getMainurl() {
        return mainurl;
    }

    public void setMainurl(String mainurl) {
        this.mainurl = mainurl;
    }

    public String getMainDescribe() {
        return mainDescribe;
    }

    public void setMainDescribe(String mainDescribe) {
        this.mainDescribe = mainDescribe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", globalId=").append(globalId);
        sb.append(", userId=").append(userId);
        sb.append(", price=").append(price);
        sb.append(", category=").append(category);
        sb.append(", allSize=").append(allSize);
        sb.append(", mainurl=").append(mainurl);
        sb.append(", mainDescribe=").append(mainDescribe);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}