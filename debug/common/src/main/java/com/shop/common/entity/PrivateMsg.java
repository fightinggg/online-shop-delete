package com.shop.common.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection ="online-shop-PrivateMsg")
public class PrivateMsg {
    private String _id;
    private Long globalId;
    private Integer userId;
    private Boolean isRead;
    private Long createTime;
    private String head;
    private String payload;
}
