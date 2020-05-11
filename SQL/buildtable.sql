CREATE TABLE `address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyerId` int(11) NULL,
  `address` varchar(255) NULL,
  `phonenum` int(11) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `bankCard`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyerId` int(11) NULL,
  `bankName` varchar(30) NULL,
  `bankId` int(11) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `buyer`  (
  `id` int(11) NOT NULL,
  `password` int(11) NULL,
  `name` varchar(30) NULL,
  `sex` enum('man','woman') NULL,
  `birthday` date NULL,
  `phonenum` int(11) NULL,
  `email` varchar(30) NULL,
  `rate` int(11) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `buyerIntegral`  (
  `buyerId` int(11) NOT NULL,
  `integral` int(11) NULL,
  PRIMARY KEY (`buyerId`)
);

CREATE TABLE `buyerMoney`  (
  `id` int(11) NOT NULL,
  `money` int(11) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `comments`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyerId` int(11) NULL,
  `goodsId` int(11) NULL,
  `comments` varchar(255) NULL,
  `commentsId` int(11) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `coupon`  (
  `couponId` int(11) NOT NULL AUTO_INCREMENT,
  `buyerId` int(11) NULL,
  `couponWarehouseId` int(11) NULL,
  PRIMARY KEY (`couponId`)
);

CREATE TABLE `couponWarehouse`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `preferentialAmount` int(11) NULL,
  `minimumConsumptionAmount` int(11) NULL,
  `deadline` date NULL,
  `sellerId` int(11) NULL,
  `count` int(11) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `favourite`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyerId` int(11) NULL,
  `goodsId` int(11) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `globalId`  (
  `id` int(20) NOT NULL,
  `created_at` timestamp(0) NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `updated_at` timestamp(0) NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`)
);

CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NULL COMMENT '名字',
  `sellerId` int(11) NULL COMMENT '卖家编号',
  `price` int(11) NULL COMMENT '价格',
  `category` varchar(30) NULL COMMENT '分类',
  `salevol` int(11) NULL COMMENT '销量',
  `mainURL` varchar(255) NULL,
  `mainDescribe` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `goodsCounts`  (
  `id` int(11) NOT NULL,
  `counts` int(11) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `goodsDescribe`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsId` int(11) NULL,
  `URL` varchar(255) NULL,
  `describe` varchar(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyerId` int(11) NULL,
  `goodsId` int(11) NULL,
  `addressid` int(11) NULL,
  `counts` int(11) NULL,
  `state` enum('runing','successed') NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `seller`  (
  `id` int(11) NOT NULL,
  `password` int(11) NULL,
  `name` varchar(11) NULL,
  `rate` enum('1','2','3','4','5') NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `sellerMoney`  (
  `id` int(11) NOT NULL,
  `money` int(11) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `shoppingCart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyerId` int(11) NULL,
  `goodsId` int(11) NULL,
  `counts` int(11) NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `address` ADD CONSTRAINT `fk_address_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `bankCard` ADD CONSTRAINT `fk_bankCard_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `buyerIntegral` ADD CONSTRAINT `fk_buyerIntegral_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `buyerMoney` ADD CONSTRAINT `fk_buyer_copy_1_buyer_1` FOREIGN KEY (`id`) REFERENCES `buyer` (`id`);
ALTER TABLE `comments` ADD CONSTRAINT `fk_comments_goods_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`);
ALTER TABLE `comments` ADD CONSTRAINT `fk_comments_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `coupon` ADD CONSTRAINT `fk_coupon_couponWarehouse_1` FOREIGN KEY (`couponWarehouseId`) REFERENCES `couponWarehouse` (`id`);
ALTER TABLE `coupon` ADD CONSTRAINT `fk_coupon_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `couponWarehouse` ADD CONSTRAINT `fk_couponWarehouse_seller_1` FOREIGN KEY (`sellerId`) REFERENCES `seller` (`id`);
ALTER TABLE `favourite` ADD CONSTRAINT `fk_favourite_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `favourite` ADD CONSTRAINT `fk_favourite_goods_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`);
ALTER TABLE `goods` ADD CONSTRAINT `fk_goods_seller_1` FOREIGN KEY (`sellerId`) REFERENCES `seller` (`id`);
ALTER TABLE `goodsCounts` ADD CONSTRAINT `fk_goods_copy_1_goods_1` FOREIGN KEY (`id`) REFERENCES `goods` (`id`);
ALTER TABLE `goodsDescribe` ADD CONSTRAINT `fk_goodsURL_goods_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`);
ALTER TABLE `orders` ADD CONSTRAINT `fk_order_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `orders` ADD CONSTRAINT `fk_order_goods_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`);
ALTER TABLE `orders` ADD CONSTRAINT `fk_order_address_1` FOREIGN KEY (`addressid`) REFERENCES `address` (`id`);
ALTER TABLE `sellerMoney` ADD CONSTRAINT `fk_sellerMoney_seller_1` FOREIGN KEY (`id`) REFERENCES `seller` (`id`);
ALTER TABLE `shoppingCart` ADD CONSTRAINT `fk_shoppingCart_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `shoppingCart` ADD CONSTRAINT `fk_shoppingCart_goods_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`);

