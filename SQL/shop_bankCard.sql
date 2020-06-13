create table bankCard
(
    id       int auto_increment
        primary key,
    buyerId  int         null,
    bankName varchar(30) null,
    bankId   int         null,
    constraint fk_bankCard_buyer_1
        foreign key (buyerId) references tb_user (id)
);

