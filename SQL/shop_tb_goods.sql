create table tb_goods
(
    id            int auto_increment
        primary key,
    global_id     bigint       null comment '全局id',
    user_id       int          null comment '卖家编号',
    price         int          null comment '价格',
    category      varchar(30)  null comment '分类',
    all_size      int          null comment '总量',
    mainURL       varchar(255) null,
    main_describe varchar(255) null,
    name          varchar(30)  null comment '名字',
    constraint tb_goods_global_id_uindex
        unique (global_id)
);

create index fk_goods_seller_1
    on tb_goods (user_id);

INSERT INTO shop.tb_goods (id, global_id, user_id, price, category, all_size, mainURL, main_describe, name) VALUES (62, 4353443928570421252, 2, 1, 'foods', null, 'www.baidu.com', '好喝的可乐', '可乐');
INSERT INTO shop.tb_goods (id, global_id, user_id, price, category, all_size, mainURL, main_describe, name) VALUES (66, 4401390125964558341, 1, 1, 'foods', null, 'http://3m123712o1.qicp.vip/file/14357004250300391431', '好喝的可乐', '可乐');
INSERT INTO shop.tb_goods (id, global_id, user_id, price, category, all_size, mainURL, main_describe, name) VALUES (67, 4401390125964558345, 1, 1, 'foods', null, 'http://3m123712o1.qicp.vip/file/14401390125964558344', '好喝的可乐', '可乐');
INSERT INTO shop.tb_goods (id, global_id, user_id, price, category, all_size, mainURL, main_describe, name) VALUES (68, 4401390125964558349, 1, 1, 'shoes', null, 'http://3m123712o1.qicp.vip/file/14401390125964558348', '好看的凉鞋', '凉鞋');
INSERT INTO shop.tb_goods (id, global_id, user_id, price, category, all_size, mainURL, main_describe, name) VALUES (69, 4402358898787852289, 1, 1, 'foods', null, 'www.baidu.com', '好喝的可乐', '可乐');