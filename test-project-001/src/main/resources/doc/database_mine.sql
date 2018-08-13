/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : database_mine

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 07/08/2018 08:32:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `student_id` int(11) NOT NULL,
  `math` int(11) DEFAULT 0,
  `chinese` int(255) DEFAULT 60,
  PRIMARY KEY (`student_id`) USING BTREE,
  INDEX `chinese index`(`chinese`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (10001, 60, 60);
INSERT INTO `score` VALUES (10002, 98, 80);
INSERT INTO `score` VALUES (10003, 96, 80);
INSERT INTO `score` VALUES (10004, 70, 60);
INSERT INTO `score` VALUES (10005, 99, 60);
INSERT INTO `score` VALUES (10006, 100, 80);
INSERT INTO `score` VALUES (10007, 80, 60);
INSERT INTO `score` VALUES (10008, 75, 70);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `USER_PASSWORD` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户密码',
  `USER_NAME` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名称',
  `REMARK` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10009 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (10000, 'root', '欧泰', NULL);
INSERT INTO `sys_user` VALUES (10001, 'xiaoxiao', '小小', NULL);
INSERT INTO `sys_user` VALUES (10002, 'xiaohong', '小红', NULL);
INSERT INTO `sys_user` VALUES (10003, 'xiaoming', '小明', NULL);
INSERT INTO `sys_user` VALUES (10004, 'zhangsan', '张三', '1');
INSERT INTO `sys_user` VALUES (10005, 'lisi', '李四', NULL);
INSERT INTO `sys_user` VALUES (10006, 'admin', 'admin', NULL);
INSERT INTO `sys_user` VALUES (10008, 'xiaoxiaoxiao', '小小小', NULL);

SET FOREIGN_KEY_CHECKS = 1;
