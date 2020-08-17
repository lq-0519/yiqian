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

 Date: 17/08/2020 12:34:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for regiBook
-- ----------------------------
DROP TABLE IF EXISTS `regiBook`;
CREATE TABLE `regiBook` (
  `bookName` varchar(100) NOT NULL COMMENT '书名',
  `author` varchar(100) DEFAULT NULL COMMENT '作者\n',
  `invitationCodeId` varchar(20) DEFAULT NULL COMMENT '登记时使用的邀请码',
  `remarks` varchar(600) DEFAULT NULL COMMENT '备注',
  `isFund` int(2) NOT NULL COMMENT '是否被处理,1代表处理了',
  `result` varchar(100) DEFAULT NULL COMMENT '找书结果',
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `regiDate` datetime DEFAULT NULL COMMENT '登记日期',
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `regiBook_invitationCodeList_invitationCode_fk` (`invitationCodeId`),
  CONSTRAINT `regiBook_invitationCodeList_invitationCode_fk` FOREIGN KEY (`invitationCodeId`) REFERENCES `invitationCodeList` (`invitationCode`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=997 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
