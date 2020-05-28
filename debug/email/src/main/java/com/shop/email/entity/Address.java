package com.shop.email.entity;

import java.io.Serializable;

public class Address implements Serializable {
    private Integer id;

    private Long globalId;

    private Integer userId;

    private String address;

    private String phonenum;

    private String email;

    private static final long serialVersionUID = 1L;

    public Address(Integer id, Long globalId, Integer userId, String address, String phonenum, String email) {
        this.id = id;
        this.globalId = globalId;
        this.userId = userId;
        this.address = address;
        this.phonenum = phonenum;
        this.email = email;
    }

    public Address() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}