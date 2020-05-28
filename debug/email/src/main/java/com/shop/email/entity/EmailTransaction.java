package com.shop.email.entity;

import java.io.Serializable;

public class EmailTransaction implements Serializable {
    private Long id;

    private static final long serialVersionUID = 1L;

    public EmailTransaction(Long id) {
        this.id = id;
    }

    public EmailTransaction() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}