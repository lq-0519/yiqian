/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 182.92.81.132:3306
 Source Schema         : yiqianLibrary

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 07/07/2020 11:46:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for variable
-- ----------------------------
DROP TABLE IF EXISTS `variable`;
CREATE TABLE `variable` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET latin1 NOT NULL COMMENT '变量的名字',
  `value` varchar(800) CHARACTER SET utf8 DEFAULT NULL COMMENT '变量的值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
