/*
Navicat MySQL Data Transfer

Source Server         : JGMSql
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shorturl

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2019-04-13 17:17:59
*/


CREATE DATABASE shorturl

use shorturl

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for diyurl
-- ----------------------------
DROP TABLE IF EXISTS `diyurl`;
CREATE TABLE `diyurl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL COMMENT '用户指定字符串',
  `prefix` varchar(12) DEFAULT NULL COMMENT '用户指定字符串地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for urlmapping
-- ----------------------------
DROP TABLE IF EXISTS `urlmapping`;
CREATE TABLE `urlmapping` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `short_url` varchar(32) DEFAULT NULL,
  `long_url` varchar(1024) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for view
-- ----------------------------
DROP TABLE IF EXISTS `view`;
CREATE TABLE `view` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `ip_addr` varchar(20) DEFAULT NULL COMMENT 'ip地址',
  `create_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of diyurl
-- ----------------------------
INSERT INTO `diyurl` VALUES ('1', '新浪', 'sina.it');
INSERT INTO `diyurl` VALUES ('2', '淘宝', 'tb.cn');
INSERT INTO `diyurl` VALUES ('3', 'QQ', 'qq.cn');
INSERT INTO `diyurl` VALUES ('4', '谷歌', 'goo.gl');
INSERT INTO `diyurl` VALUES ('5', '网易', 'dwz.zn');
INSERT INTO `diyurl` VALUES ('6', 'BIT', 'bit.ly');
INSERT INTO `diyurl` VALUES ('7', 'jgm', 'jgm');
