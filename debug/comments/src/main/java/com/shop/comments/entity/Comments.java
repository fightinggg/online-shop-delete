package com.shop.comments.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Comments")
public class Comments {
    String _id;
    Long globalId;
    Integer buyerId;
    Integer goodsId;
    String replyId; // 回复
    String data;
}
