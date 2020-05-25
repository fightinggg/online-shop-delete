create table tb_url
(
    id         int auto_increment,
    global_id  bigint       null,
    url_pre    varchar(100) null,
    `describe` varchar(100) null,
    constraint tb_url_id_uindex
        unique (id)
);

alter table tb_url
    add primary key (id);

INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (1, null, 'GET/authority/role/', '管理员查看角色信息');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (2, null, 'POST/authority/role/', '插入角色');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (3, null, 'PUT/authority/role/', '修改角色');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (4, null, 'DELETE/authority/role/', '删除角色');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (5, null, 'GET/authority/url/', '查询可用的URL');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (6, null, 'GET/authority/user_have_what_role/', '查询用户的角色');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (7, null, 'GET/authority/role_have_what_user/', '查询角色的用户');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (8, null, 'POST/authority/insert_user_role/', '插入用户的角色');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (9, null, 'DELETE/authority/delete_user_role/', '删除用户的角色');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (10, null, 'POST/user/', '注册用户');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (11, null, 'GET/user/id/is/effective/', '查询用户id是否有效');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (12, null, 'GET/user/', '查询用户信息');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (13, null, 'GET/user/money/', '查询余额信息');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (14, null, 'PUT/user/', '修改用户');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (15, null, 'PUT/user/add/money/', '充值');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (16, null, 'POST/goods/', '添加商品');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (17, null, 'GET/goods/', '查询商品');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (18, null, 'DELETE/goods/', '删除商品');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (19, null, 'GET/goods/category/', '按照分类查询商品');
INSERT INTO shop.tb_url (id, global_id, url_pre, `describe`) VALUES (20, null, 'GET/goods/seller/', '按照卖家查询商品');