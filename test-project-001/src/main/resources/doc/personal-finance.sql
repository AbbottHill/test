/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : personal-finance

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 07/08/2018 08:34:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for record_expense
-- ----------------------------
DROP TABLE IF EXISTS `record_expense`;
CREATE TABLE `record_expense`  (
  `id` bigint(255) UNSIGNED NOT NULL AUTO_INCREMENT,
  `trade_time` datetime(6) DEFAULT NULL,
  `money` decimal(60, 5) DEFAULT NULL,
  `expense_type` int(2) UNSIGNED DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `longitude` decimal(15, 0) DEFAULT NULL,
  `gmt_create` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `latitude` decimal(15, 0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10001 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record_expense
-- ----------------------------
INSERT INTO `record_expense` VALUES (10000, '2018-07-24 16:35:22.000000', 10.00000, 1, 'xiyoulu', NULL, '2018-07-24 16:35:34', '2018-07-28 16:12:55', NULL);

-- ----------------------------
-- Table structure for record_income
-- ----------------------------
DROP TABLE IF EXISTS `record_income`;
CREATE TABLE `record_income`  (
  `id` bigint(255) UNSIGNED NOT NULL AUTO_INCREMENT,
  `trade_time` datetime(6) DEFAULT NULL,
  `money` decimal(60, 5) UNSIGNED DEFAULT NULL,
  `income_type` int(255) UNSIGNED DEFAULT NULL,
  `location` decimal(15, 10) DEFAULT NULL,
  `longitude` decimal(15, 10) DEFAULT NULL,
  `latitude` decimal(15, 0) DEFAULT NULL,
  `gmt_create` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(155) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `birth` datetime(6) DEFAULT NULL,
  `gender` bit(1) DEFAULT b'1',
  `gmt_create` datetime(6) DEFAULT NULL,
  `gmt_modified` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `pk_user_id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1003 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1000, 'xiaoming', 'xiaoming', '2000-01-01 00:00:01.000000', b'1', '2018-07-21 15:02:24.000000', '2018-07-21 15:03:14.000000');
INSERT INTO `sys_user` VALUES (1001, '大明', 'daming', NULL, b'1', '2018-07-21 15:05:35.000000', NULL);
INSERT INTO `sys_user` VALUES (1002, 'xiaohong', 'xiaohong', NULL, b'1', '2018-07-21 15:05:38.000000', NULL);

SET FOREIGN_KEY_CHECKS = 1;
