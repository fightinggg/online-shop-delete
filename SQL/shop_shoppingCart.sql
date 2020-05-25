create table shoppingCart
(
    id      int auto_increment
        primary key,
    buyerId int null,
    goodsId int null,
    counts  int null,
    constraint fk_shoppingCart_buyer_1
        foreign key (buyerId) references tb_user (id),
    constraint fk_shoppingCart_goods_1
        foreign key (goodsId) references tb_goods (id)
);

