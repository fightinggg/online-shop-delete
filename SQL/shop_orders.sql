create table orders
(
    id        int auto_increment
        primary key,
    buyerId   int                          null,
    goodsId   int                          null,
    addressid int                          null,
    counts    int                          null,
    state     enum ('runing', 'successed') null,
    constraint fk_order_address_1
        foreign key (addressid) references address (id),
    constraint fk_order_buyer_1
        foreign key (buyerId) references tb_user (id),
    constraint fk_order_goods_1
        foreign key (goodsId) references tb_goods (id)
);

