package com.shop.orders.entity;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", counts=").append(counts);
        sb.append(", globalId=").append(globalId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}