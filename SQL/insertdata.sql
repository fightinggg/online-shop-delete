
delete
from goodsCounts;
delete
from buyerMoney;
delete
from sellerMoney;
delete
from orders;
delete
from goods;
delete
from seller;
delete
from buyer;

insert into buyer(id, password, name, sex, birthday, phonenum, email, rate, integral)
    value (11, 11, 'buyer1', 'man', '2020-05-01', 1808669868, '18086698682@email', 0, 0);

insert into buyer(id, password, name, sex, birthday, phonenum, email, rate, integral)
    value (12, 12, 'buyer2', 'man', '2020-05-01', 1808669868, '18086698682@email', 0, 0);
insert into buyerMoney(id, money) value (11, 100);
insert into buyerMoney(id, money) value (12, 100);

insert into seller(id, password, name, rate)
    value (21, 21, 'seller1', '1');
insert into seller(id, password, name, rate)
    value (22, 22, 'seller2', '1');
insert into sellerMoney(id, money) value (21, 0);
insert into sellerMoney(id, money) value (22, 0);

insert into goods(id, name, sellerId, price, category, salevol)
    value (31, 'goods1', 21, 10, 'food ', 20);
insert into goods(id, name, sellerId, price, category, salevol)
    value (32, 'goods2', 21, 10, 'laptop', 20);
insert into goods(id, name, sellerId, price, category, salevol)
    value (33, 'goods3', 22, 10, 'bed   ', 20);
insert into goodsCounts(id, counts) value (31, 0);
insert into goodsCounts(id, counts) value (32, 0);
insert into goodsCounts(id, counts) value (33, 0);

insert into orders(id, buyerId, goodsId, counts, state)
    value (41, 11, 33, 10, 'runing');
insert into orders(id, buyerId, goodsId, counts, state)
    value (42, 11, 32, 10, 'runing');
insert into orders(id, buyerId, goodsId, counts, state)
    value (43, 12, 31, 10, 'runing');
