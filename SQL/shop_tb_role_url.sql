create table tb_role_url
(
    id        int auto_increment,
    global_id bigint null,
    role_id   int    null,
    url_id    int    null,
    constraint tb_role_url_id_uindex
        unique (id)
);

alter table tb_role_url
    add primary key (id);

INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (1, null, 2, 1);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (3, null, 2, 2);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (4, null, 2, 3);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (5, null, 2, 4);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (6, null, 2, 5);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (7, null, 2, 6);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (8, null, 2, 7);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (11, null, 2, 8);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (12, null, 2, 9);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (13, null, 1, 10);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (14, null, 1, 11);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (15, null, 1, 12);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (16, null, 2, 13);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (17, null, 2, 14);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (18, null, 2, 15);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (19, null, 2, 16);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (20, null, 4, 16);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (21, null, 1, 17);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (22, null, 1, 18);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (23, null, 1, 19);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (24, null, 1, 20);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (25, null, 4, 21);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (26, null, 1, 22);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (27, null, 4, 23);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (28, null, 1, 24);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (29, null, 4, 25);
INSERT INTO shop.tb_role_url (id, global_id, role_id, url_id) VALUES (30, null, 4, 26);