create table tb_user_role
(
    id        int auto_increment
        primary key,
    global_id bigint null,
    user_id   int    not null,
    role_id   int    not null
);

INSERT INTO shop.tb_user_role (id, global_id, user_id, role_id) VALUES (1, null, 1, 2);
INSERT INTO shop.tb_user_role (id, global_id, user_id, role_id) VALUES (2, null, 1, 1000000004);
INSERT INTO shop.tb_user_role (id, global_id, user_id, role_id) VALUES (3, null, 1, 1000000005);
INSERT INTO shop.tb_user_role (id, global_id, user_id, role_id) VALUES (4, null, 2, 4);
INSERT INTO shop.tb_user_role (id, global_id, user_id, role_id) VALUES (5, null, 3, 1000000004);