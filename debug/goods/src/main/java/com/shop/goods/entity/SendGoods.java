package com.shop.goods.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendGoods {
    private Goods goods;
    private List<ImageNameAndDescribe> imageNameAndDescribes;
}
