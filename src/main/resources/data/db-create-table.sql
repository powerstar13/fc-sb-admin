-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.7.24-log - MySQL Community Server (GPL)
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- fc-sb-admin 데이터베이스 구조 내보내기
DROP DATABASE IF EXISTS `fc-sb-admin`;
CREATE DATABASE IF NOT EXISTS `fc-sb-admin` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;
USE `fc-sb-admin`;

-- 테이블 fc-sb-admin.admin_user 구조 내보내기
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE IF NOT EXISTS `admin_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'index',
  `account` varchar(12) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `status` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `role` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `last_login_at` datetime DEFAULT NULL,
  `login_fail_count` int(11) DEFAULT NULL,
  `password_updated_at` datetime DEFAULT NULL,
  `registered_at` datetime DEFAULT NULL,
  `unregistered_at` datetime DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `created_by` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 fc-sb-admin.category 구조 내보내기
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `title` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `created_by` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 fc-sb-admin.item 구조 내보내기
DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `name` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  `title` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `content` text COLLATE utf8mb4_bin NOT NULL,
  `price` decimal(12,4) NOT NULL,
  `brand_name` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `registered_at` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `unregistered_at` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `partner_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `partner_id_to_item_partner_id` (`partner_id`),
  CONSTRAINT `partner_id_to_item_partner_id` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 fc-sb-admin.order_detail 구조 내보내기
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE IF NOT EXISTS `order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `arrival_date` datetime NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total_price` decimal(12,4) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `created_by` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `order_group_id` bigint(20) NOT NULL,
  `item_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_group_id_to_order_detail_order_group_id` (`order_group_id`),
  KEY `item_id_to_order_detail_item_id` (`item_id`),
  CONSTRAINT `item_id_to_order_detail_item_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`),
  CONSTRAINT `order_group_id_to_order_detail_order_group_id` FOREIGN KEY (`order_group_id`) REFERENCES `order_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 fc-sb-admin.order_group 구조 내보내기
DROP TABLE IF EXISTS `order_group`;
CREATE TABLE IF NOT EXISTS `order_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `order_type` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `rev_address` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `rev_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `payment_type` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `total_price` decimal(12,4) DEFAULT NULL,
  `total_quantity` int(11) DEFAULT NULL,
  `order_at` datetime DEFAULT NULL,
  `arrival_date` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_to_order_group_user_id` (`user_id`),
  CONSTRAINT `user_id_to_order_group_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 fc-sb-admin.partner 구조 내보내기
DROP TABLE IF EXISTS `partner`;
CREATE TABLE IF NOT EXISTS `partner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `address` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `call_center` varchar(13) COLLATE utf8mb4_bin DEFAULT NULL,
  `partner_number` varchar(13) COLLATE utf8mb4_bin DEFAULT NULL,
  `business_number` varchar(16) COLLATE utf8mb4_bin DEFAULT NULL,
  `ceo_name` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `registered_at` datetime DEFAULT NULL,
  `unregistered_at` datetime DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `created_by` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id_to_partner_category_id` (`category_id`),
  CONSTRAINT `category_id_to_partner_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 fc-sb-admin.user 구조 내보내기
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'index',
  `account` varchar(12) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `status` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `phone_number` varchar(13) COLLATE utf8mb4_bin NOT NULL,
  `registered_at` datetime DEFAULT NULL,
  `unregistered_at` datetime DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `created_by` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 내보낼 데이터가 선택되어 있지 않습니다.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
