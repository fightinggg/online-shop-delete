package com.shop.orders.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersMsg {
    String buyerEmail;
    String buyerPhone;
    String goodsname;
    int sellerId;
}
