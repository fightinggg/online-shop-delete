package com.shop.goods.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
// VO
public class GoodsVO implements Serializable {
    private Goods goods;
    private List<ImageNameAndDescribe> imageNameAndDescribes;
}
