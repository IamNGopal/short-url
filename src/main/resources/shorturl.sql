/*
 Navicat Premium Data Transfer

 Source Server         : Gopal
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : 127.0.0.1:3306
 Source Schema         : shorturl

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 24/12/2019 01:52:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shorturl
-- ----------------------------
DROP TABLE IF EXISTS `shorturl`;
CREATE TABLE `shorturl`  (
  `shorturl_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shorturl_code` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `shorturl_originlurl` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `shorturl_date` datetime(0) NULL DEFAULT NULL,
  `shorturl_validdate` datetime(0) NULL DEFAULT NULL,
  `shorturl_hitcount` int(10) NULL DEFAULT 0,
  PRIMARY KEY (`shorturl_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shorturl_hit
-- ----------------------------
DROP TABLE IF EXISTS `shorturl_hit`;
CREATE TABLE `shorturl_hit`  (
  `hit_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hit_shorturl_id` bigint(20) NULL DEFAULT 0,
  `hit_ip` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hit_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`hit_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
