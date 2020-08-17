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

 Date: 17/08/2020 12:35:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sysLog
-- ----------------------------
DROP TABLE IF EXISTS `sysLog`;
CREATE TABLE `sysLog` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `visitTime` datetime DEFAULT NULL COMMENT '执行操作的时间',
  `ip` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT 'ip地址',
  `method` varchar(400) COLLATE utf8_bin DEFAULT NULL COMMENT '执行的方法',
  `executionTime` int(11) DEFAULT NULL COMMENT '访问时长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7043 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
