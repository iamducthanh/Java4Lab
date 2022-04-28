/*
 Navicat Premium Data Transfer

 Source Server         : us-cdbr-east-04.cleardb.com
 Source Server Type    : MySQL
 Source Server Version : 50650
 Source Host           : us-cdbr-east-04.cleardb.com:3306
 Source Schema         : heroku_458d0af2410d609

 Target Server Type    : MySQL
 Target Server Version : 50650
 File Encoding         : 65001

 Date: 28/04/2022 11:46:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fullname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10006 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (10005, 'admin123', '123', 'Nguyễn Đức Thành', 'ducthanh260801@gmail.com', 1);

SET FOREIGN_KEY_CHECKS = 1;
