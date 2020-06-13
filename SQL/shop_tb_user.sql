create table tb_user
(
    id           int                   not null
        primary key,
    gloabl_id    bigint                null,
    password     varchar(100)          null,
    sex          enum ('man', 'woman') null,
    birthday     date                  null,
    phone_number bigint                null,
    email        varchar(30)           null,
    rate         int                   null,
    name         varchar(30)           null
);

INSERT INTO shop.tb_user (id, gloabl_id, password, sex, birthday, phone_number, email, rate, name) VALUES (1, 1, '$2a$10$0T5qiEbjrBBkWkMvi/ZsOu1jD02edhwGCgGmxrnLJyIkOII2WxRUy', 'man', '2020-05-12', 123123, '1123213', null, 'root');
INSERT INTO shop.tb_user (id, gloabl_id, password, sex, birthday, phone_number, email, rate, name) VALUES (2, 2, '$2a$10$0zCS7qPVWEo9EGf9hQUS7erJpHNRKvT40dCcXp51lbuUDC6a0GFTq', 'man', null, null, null, null, 'user');
INSERT INTO shop.tb_user (id, gloabl_id, password, sex, birthday, phone_number, email, rate, name) VALUES (3, 3, '$2a$10$/ieoKFLTVTns3WRbOlfukehuujbxybqHHeH/LsobRGvGszTdtuW7O', 'man', null, null, null, null, null);
INSERT INTO shop.tb_user (id, gloabl_id, password, sex, birthday, phone_number, email, rate, name) VALUES (4, 4, '$2a$10$5j6C54S69ofOByhbplqPk.YSD/q6VK0lbZGf.j/UOPsRBB9ZXcxEK', 'man', null, null, null, null, null);
INSERT INTO shop.tb_user (id, gloabl_id, password, sex, birthday, phone_number, email, rate, name) VALUES (6, 6, '$2a$10$xdv5qpKtaIOYit5CBoCcRefx5jNnmR0o0.9JFU7aK.bTYwP/5pDyO', 'man', null, null, null, null, null);