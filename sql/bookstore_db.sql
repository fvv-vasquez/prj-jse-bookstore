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

/*Table structure for table `book_tb` */

DROP TABLE IF EXISTS `book_tb`;

CREATE TABLE `book_tb` (
  `book_title` varchar(255) NOT NULL,
  `book_publication_year` int(11) NOT NULL,
  `book_edition_number` int(11) NOT NULL,
  `book_author` varchar(255) NOT NULL,
  `book_price` double NOT NULL,
  `book_isbn` int(11) NOT NULL AUTO_INCREMENT,
  `book_publisher` varchar(255) NOT NULL,
  `book_genre` varchar(255) NOT NULL,
  PRIMARY KEY (`book_isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `cellphone_tb` */

DROP TABLE IF EXISTS `cellphone_tb`;

CREATE TABLE `cellphone_tb` (
  `cel_id` int(11) NOT NULL AUTO_INCREMENT,
  `cel_brand` varchar(255) NOT NULL,
  `cel_model` varchar(255) NOT NULL,
  `cel_color` varchar(255) NOT NULL,
  `cel_price` double NOT NULL,
  `cel_warranty` int(11) NOT NULL,
  `cel_screen_size` double NOT NULL,
  `cel_storage_memory` double NOT NULL,
  `cel_camera` int(11) NOT NULL,
  PRIMARY KEY (`cel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `dvd_tb` */

DROP TABLE IF EXISTS `dvd_tb`;

CREATE TABLE `dvd_tb` (
  `dvd_title` varchar(255) NOT NULL,
  `dvd_total_duration` int(11) NOT NULL,
  `dvd_price` double NOT NULL,
  `dvd_genre` varchar(255) NOT NULL,
  `dvd_release_year` int(11) NOT NULL,
  `dvd_code` int(11) NOT NULL AUTO_INCREMENT,
  `dvd_movie_director` varchar(255) DEFAULT NULL,
  `dvd_show_artist` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dvd_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `headset_tb` */

DROP TABLE IF EXISTS `headset_tb`;

CREATE TABLE `headset_tb` (
  `head_id` int(11) NOT NULL AUTO_INCREMENT,
  `head_brand` varchar(255) NOT NULL,
  `head_model` varchar(255) NOT NULL,
  `head_color` varchar(255) NOT NULL,
  `head_price` double NOT NULL,
  `head_warranty` int(11) NOT NULL,
  `head_connection` varchar(255) NOT NULL,
  `head_microphone` tinyint(1) NOT NULL,
  `head_wirred` tinyint(1) NOT NULL,
  PRIMARY KEY (`head_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `keyboard_tb` */

DROP TABLE IF EXISTS `keyboard_tb`;

CREATE TABLE `keyboard_tb` (
  `kb_id` int(11) NOT NULL AUTO_INCREMENT,
  `kb_brand` varchar(255) NOT NULL,
  `kb_model` varchar(255) NOT NULL,
  `kb_color` varchar(255) NOT NULL,
  `kb_price` double NOT NULL,
  `kb_warranty` int(11) NOT NULL,
  `kb_connection` varchar(255) NOT NULL,
  `kb_multimedia` tinyint(1) NOT NULL,
  `kb_wired` tinyint(1) NOT NULL,
  PRIMARY KEY (`kb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `laptop_tb` */

DROP TABLE IF EXISTS `laptop_tb`;

CREATE TABLE `laptop_tb` (
  `pc_id` int(11) NOT NULL AUTO_INCREMENT,
  `pc_brand` varchar(255) NOT NULL,
  `pc_model` varchar(255) NOT NULL,
  `pc_color` varchar(255) NOT NULL,
  `pc_price` double NOT NULL,
  `pc_warranty` int(11) NOT NULL,
  `pc_ram_size` int(11) NOT NULL,
  `pc_processor` varchar(255) NOT NULL,
  `pc_screen_size` double NOT NULL,
  `pc_hd_size` double NOT NULL,
  PRIMARY KEY (`pc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `magazine_tb` */

DROP TABLE IF EXISTS `magazine_tb`;

CREATE TABLE `magazine_tb` (
  `mag_name` varchar(255) NOT NULL,
  `mag_edition_number` int(11) NOT NULL,
  `mag_genre` varchar(255) NOT NULL,
  `mag_publication_date` date NOT NULL,
  `mag_publisher` varchar(255) NOT NULL,
  `mag_price` double NOT NULL,
  PRIMARY KEY (`mag_edition_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `mouse_tb` */

DROP TABLE IF EXISTS `mouse_tb`;

CREATE TABLE `mouse_tb` (
  `mouse_id` int(11) NOT NULL AUTO_INCREMENT,
  `mouse_brand` varchar(255) NOT NULL,
  `mouse_model` varchar(255) NOT NULL,
  `mouse_color` varchar(255) NOT NULL,
  `mouse_price` double NOT NULL,
  `mouse_warranty` int(11) NOT NULL,
  `mouse_connection` varchar(255) NOT NULL,
  `mouse_resolution` mediumint(9) NOT NULL,
  `mouse_wired` tinyint(1) NOT NULL,
  PRIMARY KEY (`mouse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `router_tb` */

DROP TABLE IF EXISTS `router_tb`;

CREATE TABLE `router_tb` (
  `rout_id` int(11) NOT NULL AUTO_INCREMENT,
  `rout_brand` varchar(255) NOT NULL,
  `rout_model` varchar(255) NOT NULL,
  `rout_color` varchar(255) NOT NULL,
  `rout_price` double NOT NULL,
  `rout_warranty` int(11) NOT NULL,
  `rout_quantity_port` int(11) NOT NULL,
  `rout_quantity_antenna` int(11) NOT NULL,
  `rout_wireless` tinyint(1) NOT NULL,
  PRIMARY KEY (`rout_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
