ALTER TABLE `address` DROP FOREIGN KEY `fk_address_buyer_1`;
ALTER TABLE `bankCard` DROP FOREIGN KEY `fk_bankCard_buyer_1`;
ALTER TABLE `buyerMoney` DROP FOREIGN KEY `fk_buyer_copy_1_buyer_1`;
ALTER TABLE `comments` DROP FOREIGN KEY `fk_comments_goods_1`;
ALTER TABLE `comments` DROP FOREIGN KEY `fk_comments_buyer_1`;
ALTER TABLE `coupon` DROP FOREIGN KEY `fk_coupon_couponWarehouse_1`;
ALTER TABLE `coupon` DROP FOREIGN KEY `fk_coupon_buyer_1`;
ALTER TABLE `couponWarehouse` DROP FOREIGN KEY `fk_couponWarehouse_seller_1`;
ALTER TABLE `favourite` DROP FOREIGN KEY `fk_favourite_buyer_1`;
ALTER TABLE `favourite` DROP FOREIGN KEY `fk_favourite_goods_1`;
ALTER TABLE `goods` DROP FOREIGN KEY `fk_goods_seller_1`;
ALTER TABLE `goodsCounts` DROP FOREIGN KEY `fk_goods_copy_1_goods_1`;
ALTER TABLE `orders` DROP FOREIGN KEY `fk_order_buyer_1`;
ALTER TABLE `orders` DROP FOREIGN KEY `fk_order_goods_1`;
ALTER TABLE `orders` DROP FOREIGN KEY `fk_order_address_1`;
ALTER TABLE `sellerMoney` DROP FOREIGN KEY `fk_sellerMoney_seller_1`;
ALTER TABLE `shoppingCart` DROP FOREIGN KEY `fk_shoppingCart_buyer_1`;
ALTER TABLE `shoppingCart` DROP FOREIGN KEY `fk_shoppingCart_goods_1`;

DROP TABLE `address`;
DROP TABLE `bankCard`;
DROP TABLE `buyer`;
DROP TABLE `buyerMoney`;
DROP TABLE `comments`;
DROP TABLE `coupon`;
DROP TABLE `couponWarehouse`;
DROP TABLE `favourite`;
DROP TABLE `goods`;
DROP TABLE `goodsCounts`;
DROP TABLE `orders`;
DROP TABLE `seller`;
DROP TABLE `sellerMoney`;
DROP TABLE `shoppingCart`;

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
  `integral` int(11) NULL,
  PRIMARY KEY (`id`)
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

CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NULL,
  `sellerId` int(11) NULL,
  `price` int(11) NULL,
  `category` varchar(30) NULL,
  `salevol` int(11) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `goodsCounts`  (
  `id` int(11) NOT NULL,
  `counts` int(11) NULL,
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
ALTER TABLE `orders` ADD CONSTRAINT `fk_order_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `orders` ADD CONSTRAINT `fk_order_goods_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`);
ALTER TABLE `orders` ADD CONSTRAINT `fk_order_address_1` FOREIGN KEY (`addressid`) REFERENCES `address` (`id`);
ALTER TABLE `sellerMoney` ADD CONSTRAINT `fk_sellerMoney_seller_1` FOREIGN KEY (`id`) REFERENCES `seller` (`id`);
ALTER TABLE `shoppingCart` ADD CONSTRAINT `fk_shoppingCart_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `shoppingCart` ADD CONSTRAINT `fk_shoppingCart_goods_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`);

