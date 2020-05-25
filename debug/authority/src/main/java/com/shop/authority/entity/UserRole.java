package com.shop.authority.entity;

import java.io.Serializable;

public class UserRole implements Serializable {
    private Integer id;

    private Long globalId;

    private Integer userId;

    private Integer roleId;

    private static final long serialVersionUID = 1L;

    public UserRole(Integer id, Long globalId, Integer userId, Integer roleId) {
        this.id = id;
        this.globalId = globalId;
        this.userId = userId;
        this.roleId = roleId;
    }

    public UserRole() {
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}