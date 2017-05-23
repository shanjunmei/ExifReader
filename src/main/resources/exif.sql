/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : exif

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-05-23 14:25:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for exif
-- ----------------------------
DROP TABLE IF EXISTS `exif`;
CREATE TABLE `exif` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `make` varchar(50) DEFAULT NULL COMMENT '制造商',
  `model` varchar(50) DEFAULT NULL COMMENT '型号',
  `shoot_time` datetime DEFAULT NULL COMMENT '拍摄时间',
  `aperture` varchar(20) DEFAULT NULL COMMENT '光圈',
  `shutter_speed` varchar(50) DEFAULT NULL COMMENT '快门速度',
  `focal_length` varchar(20) DEFAULT NULL COMMENT '焦距',
  `exposure_bias` varchar(20) DEFAULT NULL COMMENT '曝光补偿',
  `width` int(11) DEFAULT NULL COMMENT '宽',
  `height` int(11) DEFAULT NULL COMMENT '高',
  `x_resolution` int(11) DEFAULT NULL COMMENT '水平分辨率',
  `y_resolution` int(11) DEFAULT NULL COMMENT '垂直分辨率',
  `sensitivity` varchar(20) DEFAULT NULL COMMENT '感光度',
  `file_path` varchar(1000) DEFAULT NULL COMMENT '文件路径',
  `file_name` varchar(1000) DEFAULT NULL COMMENT '文件名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1386 DEFAULT CHARSET=utf8;
