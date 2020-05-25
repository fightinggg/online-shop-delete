package com.shop.authority.entity;

import java.io.Serializable;

public class Role implements Serializable {
    private Integer id;

    private Long gloablId;

    private String name;

    private static final long serialVersionUID = 1L;

    public Role(Integer id, Long gloablId, String name) {
        this.id = id;
        this.gloablId = gloablId;
        this.name = name;
    }

    public Role() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}