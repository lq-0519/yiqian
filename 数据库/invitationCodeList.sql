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

 Date: 07/07/2020 11:46:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for invitationCodeList
-- ----------------------------
DROP TABLE IF EXISTS `invitationCodeList`;
CREATE TABLE `invitationCodeList` (
  `invitationCode` varchar(20) NOT NULL COMMENT '邀请码 唯一 做主键',
  `username` varchar(200) NOT NULL COMMENT '添加邀请码时使用的用户名,931722548用户就用931722548号,微信就用微信号',
  `accountType` varchar(20) NOT NULL COMMENT '账户类型',
  `createDate` datetime DEFAULT NULL COMMENT '登记时间',
  `sum` int(10) unsigned DEFAULT '0' COMMENT '记录当前邀请码一共登机了多少书',
  `last` int(10) NOT NULL COMMENT '今天还能登记的书的本数',
  PRIMARY KEY (`invitationCode`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
