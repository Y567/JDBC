/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.27 : Database - games
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`games` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `games`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `username` varchar(32) NOT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `administrator` */

insert  into `administrator`(`username`,`password`) values ('gyy','yy5201314');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `tell` varchar(11) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`tell`,`gender`,`birthday`) values (1,'1592221415@qq.com','yy5201314','13571299572','女','2013-10-11'),(3,'1592221415@qq.com','yy5201314','18700183736','男','2019-10-11'),(4,'1592221415@qq.com','yy5201314','18700187878','女','1991-10-11'),(5,'1592221415@qq.com','yy5201314','18700183736','男','2019-10-11'),(6,'1592221415@qq.com','yy5201314','18700183736','男','2019-10-11'),(7,'3592221415@qq.com','rzbxs35201314','18700183234','女','1996-12-11'),(8,'1593451415@qq.com','yy5201314','13578968505','女','2019-03-04');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
