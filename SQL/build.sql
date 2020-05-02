CREATE TABLE `address`  (
  `id` int(11) NOT NULL,
  `buyerId` int(11) NULL,
  `address` varchar(255) NULL,
  `phonenum` int(11) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `bankCard`  (
  `id` int(11) NOT NULL,
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
  `money` int(11) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `comments`  (
  `id` int(11) NOT NULL,
  `buyerId` int(11) NULL,
  `goodsId` int(11) NULL,
  `comments` varchar(255) NULL,
  `commentsId` int(11) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `coupon`  (
  `couponId` int(11) NOT NULL,
  `buyerId` int(11) NULL,
  `couponWarehouseId` int(11) NULL,
  PRIMARY KEY (`couponId`)
);

CREATE TABLE `couponWarehouse`  (
  `id` int(11) NOT NULL,
  `preferentialAmount` int(11) NULL,
  `minimumConsumptionAmount` int(11) NULL,
  `deadline` date NULL,
  `sellerId` int(11) NULL,
  `count` int(11) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `favourite`  (
  `buyerId` int(11) NULL,
  `goodsId` int(11) NULL
);

CREATE TABLE `goods`  (
  `id` int(11) NOT NULL,
  `name` varchar(30) NULL,
  `sellerId` int(11) NULL,
  `price` int(11) NULL,
  `category` varchar(30) NULL,
  `salevol` int(11) NULL,
  `count` int(11) NULL,
  `desc` varchar(30) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `order`  (
  `id` int(11) NOT NULL,
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
  `money` int(11) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `shoppingCart`  (
  `buyerId` int(11) NULL,
  `goodsId` int(11) NULL,
  `counts` int(11) NULL
);

ALTER TABLE `address` ADD CONSTRAINT `fk_address_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `bankCard` ADD CONSTRAINT `fk_bankCard_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `comments` ADD CONSTRAINT `fk_comments_goods_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`);
ALTER TABLE `comments` ADD CONSTRAINT `fk_comments_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `coupon` ADD CONSTRAINT `fk_coupon_couponWarehouse_1` FOREIGN KEY (`couponWarehouseId`) REFERENCES `couponWarehouse` (`id`);
ALTER TABLE `coupon` ADD CONSTRAINT `fk_coupon_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `couponWarehouse` ADD CONSTRAINT `fk_couponWarehouse_seller_1` FOREIGN KEY (`sellerId`) REFERENCES `seller` (`id`);
ALTER TABLE `favourite` ADD CONSTRAINT `fk_favourite_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `favourite` ADD CONSTRAINT `fk_favourite_goods_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`);
ALTER TABLE `goods` ADD CONSTRAINT `fk_goods_seller_1` FOREIGN KEY (`sellerId`) REFERENCES `seller` (`id`);
ALTER TABLE `order` ADD CONSTRAINT `fk_order_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `order` ADD CONSTRAINT `fk_order_goods_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`);
ALTER TABLE `order` ADD CONSTRAINT `fk_order_address_1` FOREIGN KEY (`addressid`) REFERENCES `address` (`id`);
ALTER TABLE `shoppingCart` ADD CONSTRAINT `fk_shoppingCart_buyer_1` FOREIGN KEY (`buyerId`) REFERENCES `buyer` (`id`);
ALTER TABLE `shoppingCart` ADD CONSTRAINT `fk_shoppingCart_goods_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`);

