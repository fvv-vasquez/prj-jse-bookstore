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
  `book_title` varchar(255) NOT NULL,
  `book_publication_year` int(11) NOT NULL,
  `book_edition_number` int(11) NOT NULL,
  `book_author` varchar(255) NOT NULL,
  `book_price` double NOT NULL,
  `book_isbn` int(11) NOT NULL AUTO_INCREMENT,
  `book_publisher` varchar(255) NOT NULL,
  `book_genre` varchar(255) NOT NULL,
  PRIMARY KEY (`book_isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8;

/*Table structure for table `tb_cellphone` */

DROP TABLE IF EXISTS `tb_cellphone`;

CREATE TABLE `tb_cellphone` (
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

/*Table structure for table `tb_dvd` */

DROP TABLE IF EXISTS `tb_dvd`;

CREATE TABLE `tb_dvd` (
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

/*Table structure for table `tb_headset` */

DROP TABLE IF EXISTS `tb_headset`;

CREATE TABLE `tb_headset` (
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

/*Table structure for table `tb_keyboard` */

DROP TABLE IF EXISTS `tb_keyboard`;

CREATE TABLE `tb_keyboard` (
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

/*Table structure for table `tb_laptop` */

DROP TABLE IF EXISTS `tb_laptop`;

CREATE TABLE `tb_laptop` (
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

/*Table structure for table `tb_magazine` */

DROP TABLE IF EXISTS `tb_magazine`;

CREATE TABLE `tb_magazine` (
  `mag_name` varchar(255) NOT NULL,
  `mag_edition_number` int(11) NOT NULL,
  `mag_genre` varchar(255) NOT NULL,
  `mag_publication_date` date NOT NULL,
  `mag_publisher` varchar(255) NOT NULL,
  `mag_price` double NOT NULL,
  PRIMARY KEY (`mag_edition_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tb_mouse` */

DROP TABLE IF EXISTS `tb_mouse`;

CREATE TABLE `tb_mouse` (
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

/*Table structure for table `tb_router` */

DROP TABLE IF EXISTS `tb_router`;

CREATE TABLE `tb_router` (
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