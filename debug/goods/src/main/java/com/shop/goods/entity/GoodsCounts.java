package com.shop.goods.entity;

import java.io.Serializable;

public class GoodsCounts implements Serializable {
    private Integer id;

    private Integer counts;

    private Long globalId;

    private static final long serialVersionUID = 1L;

    public GoodsCounts(Integer id, Integer counts, Long globalId) {
        this.id = id;
        this.counts = counts;
        this.globalId = globalId;
    }

    public GoodsCounts() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Long getGlobalId() {
        return globalId;
    }

    public void setGlobalId(Long globalId) {
        this.globalId = globalId;
    }
}