create table tb_orders
(
    id            int auto_increment
        primary key,
    global_id     bigint     null,
    buyer_id      int        null,
    seller_id     int        null,
    goods_id      int        null,
    price         int        null,
    counts        int        null,
    address_id    int        null,
    buyer_submit  tinyint(1) null,
    seller_submit tinyint(1) null
);

create index fk_order_address_1
    on tb_orders (seller_id);

create index fk_order_buyer_1
    on tb_orders (buyer_id);

create index fk_order_goods_1
    on tb_orders (goods_id);

INSERT INTO shop.tb_orders (id, global_id, buyer_id, seller_id, goods_id, price, counts, address_id, buyer_submit, seller_submit) VALUES (48, 4372464929975238656, 1, 2, 62, 1, 10, 1, 1, 0);
INSERT INTO shop.tb_orders (id, global_id, buyer_id, seller_id, goods_id, price, counts, address_id, buyer_submit, seller_submit) VALUES (49, 4372464929975238660, 1, 2, 62, 1, 10, 1, 0, 0);