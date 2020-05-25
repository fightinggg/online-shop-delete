create table address
(
    id       int auto_increment
        primary key,
    buyerId  int          null,
    address  varchar(255) null,
    phonenum int          null,
    constraint fk_address_buyer_1
        foreign key (buyerId) references tb_user (id)
);

