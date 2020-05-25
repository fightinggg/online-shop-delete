create table tb_money
(
    id    int not null
        primary key,
    money int null,
    constraint fk_buyer_copy_1_buyer_1
        foreign key (id) references tb_user (id)
);

INSERT INTO shop.tb_money (id, money) VALUES (1, 20);
INSERT INTO shop.tb_money (id, money) VALUES (2, 0);
INSERT INTO shop.tb_money (id, money) VALUES (3, 0);
INSERT INTO shop.tb_money (id, money) VALUES (4, 0);
INSERT INTO shop.tb_money (id, money) VALUES (6, 0);