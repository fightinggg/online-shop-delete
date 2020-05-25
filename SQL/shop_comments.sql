create table comments
(
    id         int auto_increment
        primary key,
    buyerId    int          null,
    goodsId    int          null,
    comments   varchar(255) null,
    commentsId int          null,
    constraint fk_comments_buyer_1
        foreign key (buyerId) references tb_user (id),
    constraint fk_comments_goods_1
        foreign key (goodsId) references tb_goods (id)
);

