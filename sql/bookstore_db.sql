/*
SQLyog Enterprise Trial - MySQL GUI v7.11 
MySQL - 5.7.21-log : Database - bookstore_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookstore_db`;

/*Table structure for table `tb_book` */

DROP TABLE IF EXISTS `tb_book`;

CREATE TABLE `tb_book` (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_title` varchar(255) NOT NULL,
  `book_publication_year` int(11) NOT NULL,
  `book_edition_number` int(11) NOT NULL,
  `book_author` varchar(255) NOT NULL,
  `book_price` double NOT NULL,
  `book_isbn` int(11) NOT NULL,
  `book_publisher` varchar(255) NOT NULL,
  `book_genre` varchar(255) NOT NULL,
  `book_modification_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8;

/*Table structure for table `tb_cellphone` */

DROP TABLE IF EXISTS `tb_cellphone`;

CREATE TABLE `tb_cellphone` (
  `cel_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cel_brand` varchar(255) NOT NULL,
  `cel_price` double NOT NULL,
  `cel_warranty` int(11) NOT NULL,
  `cel_storage_memory` int(11) NOT NULL,
  `cel_camera` int(11) NOT NULL,
  `cel_modification_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tb_dvd` */

DROP TABLE IF EXISTS `tb_dvd`;

CREATE TABLE `tb_dvd` (
  `dvd_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dvd_title` varchar(255) NOT NULL,
  `dvd_total_duration` int(11) NOT NULL,
  `dvd_price` double NOT NULL,
  `dvd_genre` varchar(255) NOT NULL,
  `dvd_release_year` int(11) NOT NULL,
  `dvd_code` int(11) NOT NULL,
  `dvd_movie_director` varchar(255) DEFAULT NULL,
  `dvd_show_artist` varchar(255) DEFAULT NULL,
  `dvd_modification_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`dvd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `tb_laptop` */

DROP TABLE IF EXISTS `tb_laptop`;

CREATE TABLE `tb_laptop` (
  `pc_id` int(11) NOT NULL AUTO_INCREMENT,
  `pc_brand` varchar(255) NOT NULL,
  `pc_price` double NOT NULL,
  `pc_warranty` int(11) NOT NULL,
  `pc_ram_size` int(11) NOT NULL,
  `pc_hd_size` double NOT NULL,
  `pc_modification_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tb_magazine` */

DROP TABLE IF EXISTS `tb_magazine`;

CREATE TABLE `tb_magazine` (
  `mag_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mag_name` varchar(255) NOT NULL,
  `mag_edition_number` int(11) NOT NULL,
  `mag_genre` varchar(255) NOT NULL,
  `mag_publication_date` date NOT NULL,
  `mag_publisher` varchar(255) NOT NULL,
  `mag_price` double NOT NULL,
  `mag_modification_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`mag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
