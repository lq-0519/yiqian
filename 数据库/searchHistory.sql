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

 Date: 17/08/2020 12:35:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for searchHistory
-- ----------------------------
DROP TABLE IF EXISTS `searchHistory`;
CREATE TABLE `searchHistory` (
  `ip` varchar(100) NOT NULL COMMENT '记录搜索者的ip',
  `searchTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '搜索时间',
  `bookName` varchar(200) NOT NULL COMMENT '搜索的书名',
  `result` int(10) NOT NULL COMMENT '搜索出来的结果',
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35992 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
