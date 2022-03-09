/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - db3
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db3` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db3`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `account` */

insert  into `account`(`id`,`name`,`balance`) values (1,'zhangsan',1500),(2,'lisi',1500),(3,'wangwu',1500);

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `id` int(11) NOT NULL,
  `ename` varchar(50) DEFAULT NULL,
  `job_id` int(11) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `joindate` date DEFAULT NULL,
  `salary` decimal(7,2) DEFAULT NULL,
  `bonus` decimal(7,2) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `emp_jobid_ref_job_id_fk` (`job_id`),
  KEY `emp_deptid_ref_dept_id_fk` (`dept_id`),
  CONSTRAINT `emp_deptid_ref_dept_id_fk` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`),
  CONSTRAINT `emp_jobid_ref_job_id_fk` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `emp` */

insert  into `emp`(`id`,`ename`,`job_id`,`mgr`,`joindate`,`salary`,`bonus`,`dept_id`) values (1001,'孙悟空',4,1004,'2000-12-17','8000.00',NULL,20),(1002,'卢俊义',3,1006,'2001-02-20','16000.00','3000.00',30),(1003,'林冲',3,1006,'2001-02-22','12500.00','5000.00',30),(1004,'唐僧',2,1009,'2001-04-02','29750.00',NULL,20),(1005,'李逵',4,1006,'2001-09-28','12500.00','14000.00',30),(1006,'宋江',2,1009,'2001-05-01','28500.00',NULL,30),(1007,'刘备',2,1009,'2001-09-01','24500.00',NULL,10),(1008,'猪八戒',4,1004,'2007-04-19','30000.00',NULL,20),(1009,'罗贯中',1,NULL,'2001-11-17','50000.00',NULL,10),(1010,'吴用',3,1006,'2001-09-08','15000.00','0.00',30),(1011,'沙僧',4,1004,'2007-05-23','11000.00',NULL,20),(1012,'李逵',4,1006,'2001-12-03','9500.00',NULL,30),(1013,'小白龙',4,1004,'2001-12-03','30000.00',NULL,20),(1014,'关羽',4,1007,'2002-01-23','13000.00',NULL,10);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (1,'zhangsan','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
