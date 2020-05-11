package com.shop.goods.entity;

public class Goods {
    private Integer id;

    private String name;

    private Integer sellerid;

    private Integer price;

    private String category;

    private Integer salevol;

    private String mainurl;

    private String maindescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSellerid() {
        return sellerid;
    }

    public void setSellerid(Integer sellerid) {
        this.sellerid = sellerid;
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

    public Integer getSalevol() {
        return salevol;
    }

    public void setSalevol(Integer salevol) {
        this.salevol = salevol;
    }

    public String getMainurl() {
        return mainurl;
    }

    public void setMainurl(String mainurl) {
        this.mainurl = mainurl;
    }

    public String getMaindescribe() {
        return maindescribe;
    }

    public void setMaindescribe(String maindescribe) {
        this.maindescribe = maindescribe;
    }
}