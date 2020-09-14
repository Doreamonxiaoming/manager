CREATE DATABASE `personal_finance_manager`;

USE `personal_finance_manager`;

DROP TABLE IF EXISTS `tb_transaction`;

CREATE TABLE `tb_transaction` (
  `id` int NOT NULL primary key AUTO_INCREMENT,
  `name` varchar(255),
  `category_id` int,
  `transact_time` datetime,
  `amount` decimal,
  `detail` varchar(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='transaction';

insert  into `tb_transaction`(`name`,`category_id`,`transact_time`,`amount`,`detail`) values ('transaction0',1,'2020/09/11',100,'ok');
insert  into `tb_transaction`(`name`,`category_id`,`transact_time`,`amount`,`detail`) values ('transaction1',1,'2020/09/11',100,'ok');

DROP TABLE IF EXISTS `tb_category`;

CREATE TABLE `tb_category` (
  `id` int NOT NULL primary key AUTO_INCREMENT,
  `name` varchar(255),
  `budget` decimal
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='category';

insert  into `tb_category`(`name`,`budget`) values ('category0',100);
insert  into `tb_category`(`name`,`budget`) values ('category1',100);