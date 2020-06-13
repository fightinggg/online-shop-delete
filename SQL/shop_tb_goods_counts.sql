create table tb_goods_counts
(
    counts    int    null,
    global_id bigint null,
    id        int    not null
        primary key,
    constraint fk_goods_copy_1_goods_1
        foreign key (id) references tb_goods (id)
);

INSERT INTO shop.tb_goods_counts (counts, global_id, id) VALUES (980, 4353443928570421253, 62);
INSERT INTO shop.tb_goods_counts (counts, global_id, id) VALUES (0, 4401390125964558342, 66);
INSERT INTO shop.tb_goods_counts (counts, global_id, id) VALUES (0, 4401390125964558346, 67);
INSERT INTO shop.tb_goods_counts (counts, global_id, id) VALUES (0, 4401390125964558350, 68);
INSERT INTO shop.tb_goods_counts (counts, global_id, id) VALUES (0, 4402358898787852290, 69);