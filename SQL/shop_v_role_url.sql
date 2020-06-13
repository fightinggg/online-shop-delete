create definer = root@`%` view v_role_url as
select `r`.`name` AS `name`, `u`.`url_pre` AS `url_pre`, `u`.`describe` AS `describe`
from `shop`.`tb_role` `r`
         join `shop`.`tb_role_url` `ru`
         join `shop`.`tb_url` `u`
where ((`r`.`id` = `ru`.`role_id`) and (`ru`.`url_id` = `u`.`id`));

INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_ROOT', 'GET/authority/role/', '管理员查看角色信息');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_ROOT', 'POST/authority/role/', '插入角色');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_ROOT', 'PUT/authority/role/', '修改角色');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_ROOT', 'DELETE/authority/role/', '删除角色');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_ROOT', 'GET/authority/url/', '查询可用的URL');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_ROOT', 'GET/authority/user_have_what_role/', '查询用户的角色');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_ROOT', 'GET/authority/role_have_what_user/', '查询角色的用户');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_ROOT', 'POST/authority/insert_user_role/', '插入用户的角色');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_ROOT', 'DELETE/authority/delete_user_role/', '删除用户的角色');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_TOURIST', 'POST/user/', '注册用户');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_TOURIST', 'GET/user/id/is/effective/', '查询用户id是否有效');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_TOURIST', 'GET/user/', '查询用户信息');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_ROOT', 'GET/user/money/', '查询余额信息');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_ROOT', 'PUT/user/', '修改用户');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_ROOT', 'PUT/user/add/money/', '充值');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_ROOT', 'POST/goods/', '添加商品');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_USER', 'POST/goods/', '添加商品');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_TOURIST', 'GET/goods/', '查询商品');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_TOURIST', 'DELETE/goods/', '删除商品');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_TOURIST', 'GET/goods/category/', '按照分类查询商品');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_TOURIST', 'GET/goods/seller/', '按照卖家查询商品');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_USER', 'POST/file/', '增加文件');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_TOURIST', 'GET/file/', '获取文件');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_USER', 'DELETE/file/', '删除文件');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_TOURIST', 'GET/hello/', '测试');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_USER', 'POST/comments/', '添加评价');
INSERT INTO shop.v_role_url (name, url_pre, `describe`) VALUES ('ROLE_USER', 'POST/orders/', '添加订单');