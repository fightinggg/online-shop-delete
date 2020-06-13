create table tb_integral
(
    buyerId  int not null
        primary key,
    integral int null,
    constraint fk_buyerIntegral_buyer_1
        foreign key (buyerId) references tb_user (id)
);

