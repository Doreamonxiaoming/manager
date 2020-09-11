CREATE DATABASE `personal_finance_manager`;

USE `personal_finance_manager`;

DROP TABLE IF EXISTS `tb_transaction`;

CREATE TABLE `tb_transaction` (
  `id` int NOT NULL primary key,
  `name` varchar(255),
  `category_id` int,
  `transact_time` datetime,
  `amount` decimal,
  `detail` varchar(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='transaction';

insert  into `tb_transaction`(`id`,`name`,`category_id`,`transact_time`,`amount`,`detail`) values (0,'transaction0',0,'2020/09/11',100,'ok');
insert  into `tb_transaction`(`id`,`name`,`category_id`,`transact_time`,`amount`,`detail`) values (1,'transaction1',1,'2020/09/11',100,'ok');

DROP TABLE IF EXISTS `tb_category`;

CREATE TABLE `tb_category` (
  `id` int NOT NULL  primary key,
  `name` varchar(255),
  `budget` decimal
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='category';

insert  into `tb_category`(`id`,`name`,`budget`) values (0,'category0',100);
insert  into `tb_category`(`id`,`name`,`budget`) values (1,'category1',100);