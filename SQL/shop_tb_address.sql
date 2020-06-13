create table tb_address
(
    id        int auto_increment
        primary key,
    global_id bigint       null,
    user_id   int          null,
    address   varchar(255) null,
    phonenum  varchar(30)  null,
    email     varchar(30)  null,
    constraint fk_address_buyer_1
        foreign key (user_id) references tb_user (id)
);

