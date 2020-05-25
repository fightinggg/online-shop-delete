package com.shop.authority.entity;

import java.io.Serializable;

public class RoleUrl implements Serializable {
    private Integer id;

    private Long globalId;

    private Integer roleId;

    private Integer urlId;

    private static final long serialVersionUID = 1L;

    public RoleUrl(Integer id, Long globalId, Integer roleId, Integer urlId) {
        this.id = id;
        this.globalId = globalId;
        this.roleId = roleId;
        this.urlId = urlId;
    }

    public RoleUrl() {
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUrlId() {
        return urlId;
    }

    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }
}