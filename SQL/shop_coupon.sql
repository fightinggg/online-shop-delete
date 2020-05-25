create table coupon
(
    couponId          int auto_increment
        primary key,
    buyerId           int null,
    couponWarehouseId int null,
    constraint fk_coupon_buyer_1
        foreign key (buyerId) references tb_user (id),
    constraint fk_coupon_couponWarehouse_1
        foreign key (couponWarehouseId) references couponWarehouse (id)
);

