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

 Date: 07/07/2020 11:46:33
*/


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bookList
-- ----------------------------
DROP TABLE IF EXISTS `bookList`;
CREATE TABLE `bookList` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(255) DEFAULT '' COMMENT '书名',
  `path` varchar(255) DEFAULT '' COMMENT '书在百度网盘里面的路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=196707 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
