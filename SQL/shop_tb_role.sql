create table tb_role
(
    id        int auto_increment
        primary key,
    gloabl_id bigint      null,
    name      varchar(30) not null,
    constraint role_name_uindex
        unique (name)
);

INSERT INTO shop.tb_role (id, gloabl_id, name) VALUES (1, null, 'ROLE_TOURIST');
INSERT INTO shop.tb_role (id, gloabl_id, name) VALUES (2, null, 'ROLE_ROOT');
INSERT INTO shop.tb_role (id, gloabl_id, name) VALUES (3, null, 'ROLE_ADMIN');
INSERT INTO shop.tb_role (id, gloabl_id, name) VALUES (4, null, 'ROLE_USER');
INSERT INTO shop.tb_role (id, gloabl_id, name) VALUES (5, null, 'ROLE_VIP');
INSERT INTO shop.tb_role (id, gloabl_id, name) VALUES (6, null, 'ROLE_SVIP');