package com.shop.goods.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "URLAndDescribes")
public class ImageNameAndDescribes {
    private int goodsId;
    private List<ImageNameAndDescribe> imageNameAndDescribes;
}