package com.shop.orders.entity;

import java.io.Serializable;

public class Money implements Serializable {
    private Integer id;

    private Integer money;

    private static final long serialVersionUID = 1L;

    public Money(Integer id, Integer money) {
        this.id = id;
        this.money = money;
    }

    public Money() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}