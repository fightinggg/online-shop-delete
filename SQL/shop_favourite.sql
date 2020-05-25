create table favourite
(
    id      int auto_increment
        primary key,
    buyerId int null,
    goodsId int null,
    constraint fk_favourite_buyer_1
        foreign key (buyerId) references tb_user (id),
    constraint fk_favourite_goods_1
        foreign key (goodsId) references tb_goods (id)
);

