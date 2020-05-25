package com.shop.authority.entity;

import java.io.Serializable;

public class Url implements Serializable {
    private Integer id;

    private Long globalId;

    private String urlPre;

    private String describe;

    private static final long serialVersionUID = 1L;

    public Url(Integer id, Long globalId, String urlPre, String describe) {
        this.id = id;
        this.globalId = globalId;
        this.urlPre = urlPre;
        this.describe = describe;
    }

    public Url() {
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

    public String getUrlPre() {
        return urlPre;
    }

    public void setUrlPre(String urlPre) {
        this.urlPre = urlPre;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}