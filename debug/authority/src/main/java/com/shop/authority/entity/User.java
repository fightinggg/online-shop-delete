package com.shop.authority.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private Long gloablId;

    private String password;

    private String sex;

    private Date birthday;

    private Long phoneNumber;

    private String email;

    private Integer rate;

    private String name;

    private static final long serialVersionUID = 1L;

    public User(Integer id, Long gloablId, String password, String sex, Date birthday, Long phoneNumber, String email, Integer rate, String name) {
        this.id = id;
        this.gloablId = gloablId;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.rate = rate;
        this.name = name;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getGloablId() {
        return gloablId;
    }

    public void setGloablId(Long gloablId) {
        this.gloablId = gloablId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}