create table couponWarehouse
(
    id                       int auto_increment
        primary key,
    preferentialAmount       int  null,
    minimumConsumptionAmount int  null,
    deadline                 date null,
    sellerId                 int  null,
    count                    int  null
);

create index fk_couponWarehouse_seller_1
    on couponWarehouse (sellerId);

