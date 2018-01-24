/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : slave

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-01-24 21:05:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `account` varchar(32) DEFAULT NULL,
  `cashRemain` decimal(14,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_account
-- ----------------------------
INSERT INTO `user_account` VALUES ('1', '1', '092102981212', '400000.00');
