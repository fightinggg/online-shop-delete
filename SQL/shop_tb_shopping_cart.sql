create table tb_shopping_cart
(
    id         int auto_increment
        primary key,
    global_id  bigint not null,
    buyer_id   int    null,
    goods_id   int    null,
    counts     int    null,
    address_id int    null
)
    comment '购物车';

