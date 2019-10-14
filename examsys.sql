/*
Navicat MySQL Data Transfer

Source Server         : window-mysql
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : examsys

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-10-14 16:42:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for e_admin
-- ----------------------------
DROP TABLE IF EXISTS `e_admin`;
CREATE TABLE `e_admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(255) DEFAULT NULL,
  `apassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_admin
-- ----------------------------

-- ----------------------------
-- Table structure for e_answerquestions
-- ----------------------------
DROP TABLE IF EXISTS `e_answerquestions`;
CREATE TABLE `e_answerquestions` (
  `aqId` int(11) NOT NULL AUTO_INCREMENT,
  `atitle` varchar(255) DEFAULT NULL,
  `aanswer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aqId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_answerquestions
-- ----------------------------
INSERT INTO `e_answerquestions` VALUES ('1', '哺乳动物的特征', '胎生，脑部较为发达，恒温动物');

-- ----------------------------
-- Table structure for e_fillquestions
-- ----------------------------
DROP TABLE IF EXISTS `e_fillquestions`;
CREATE TABLE `e_fillquestions` (
  `fqId` int(11) NOT NULL AUTO_INCREMENT,
  `ftitle` varchar(255) DEFAULT NULL,
  `fanswer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fqId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_fillquestions
-- ----------------------------
INSERT INTO `e_fillquestions` VALUES ('1', '静夜思的作者是___', '李白');

-- ----------------------------
-- Table structure for e_mulquestions
-- ----------------------------
DROP TABLE IF EXISTS `e_mulquestions`;
CREATE TABLE `e_mulquestions` (
  `mqId` int(11) NOT NULL AUTO_INCREMENT,
  `mtitle` varchar(255) DEFAULT NULL,
  `moptiona` varchar(255) DEFAULT NULL,
  `moptionb` varchar(255) DEFAULT NULL,
  `moptionc` varchar(255) DEFAULT NULL,
  `moptiond` varchar(255) DEFAULT NULL,
  `manswer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mqId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_mulquestions
-- ----------------------------
INSERT INTO `e_mulquestions` VALUES ('1', '什么动物四只脚', '豹子', '狗', '鸡', '老鼠', 'abd');

-- ----------------------------
-- Table structure for e_permission
-- ----------------------------
DROP TABLE IF EXISTS `e_permission`;
CREATE TABLE `e_permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) DEFAULT NULL,
  `pdesc` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1 代表菜单  2代表按钮',
  `url` varchar(255) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_permission
-- ----------------------------

-- ----------------------------
-- Table structure for e_role
-- ----------------------------
DROP TABLE IF EXISTS `e_role`;
CREATE TABLE `e_role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(255) DEFAULT NULL,
  `rdesc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_role
-- ----------------------------
INSERT INTO `e_role` VALUES ('1', 'admin', '管理员');
INSERT INTO `e_role` VALUES ('2', 'teacher', '老师');
INSERT INTO `e_role` VALUES ('3', 'user', '考生');

-- ----------------------------
-- Table structure for e_role_perm
-- ----------------------------
DROP TABLE IF EXISTS `e_role_perm`;
CREATE TABLE `e_role_perm` (
  `rpid` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rpid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_role_perm
-- ----------------------------

-- ----------------------------
-- Table structure for e_singlequestions
-- ----------------------------
DROP TABLE IF EXISTS `e_singlequestions`;
CREATE TABLE `e_singlequestions` (
  `sqId` int(11) NOT NULL AUTO_INCREMENT,
  `stitle` varchar(255) DEFAULT NULL,
  `soptiona` varchar(255) DEFAULT NULL,
  `soptionb` varchar(255) DEFAULT NULL,
  `soptionc` varchar(255) DEFAULT NULL,
  `soptiond` varchar(255) DEFAULT NULL,
  `sanswer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sqId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_singlequestions
-- ----------------------------
INSERT INTO `e_singlequestions` VALUES ('1', '1加1等于几？', '1', '3', '2', '4', 'c');

-- ----------------------------
-- Table structure for e_subject
-- ----------------------------
DROP TABLE IF EXISTS `e_subject`;
CREATE TABLE `e_subject` (
  `subjectId` int(11) NOT NULL AUTO_INCREMENT,
  `subjectName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`subjectId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_subject
-- ----------------------------
INSERT INTO `e_subject` VALUES ('1', '语文');
INSERT INTO `e_subject` VALUES ('2', '数学');
INSERT INTO `e_subject` VALUES ('3', '英语');

-- ----------------------------
-- Table structure for e_teacher
-- ----------------------------
DROP TABLE IF EXISTS `e_teacher`;
CREATE TABLE `e_teacher` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(255) DEFAULT NULL,
  `tpassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_teacher
-- ----------------------------

-- ----------------------------
-- Table structure for e_testpaper
-- ----------------------------
DROP TABLE IF EXISTS `e_testpaper`;
CREATE TABLE `e_testpaper` (
  `tpId` int(11) NOT NULL AUTO_INCREMENT,
  `tpTitle` varchar(255) DEFAULT NULL COMMENT '试卷的标题',
  `tid` int(11) DEFAULT NULL COMMENT '出题老师',
  `tpTime` varchar(255) DEFAULT NULL COMMENT '考试时间',
  `tpScore` int(3) DEFAULT '100' COMMENT '试卷总分数',
  `tpContext` text COMMENT '试卷内容',
  `subjectId` int(11) DEFAULT NULL COMMENT '试卷科目',
  PRIMARY KEY (`tpId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_testpaper
-- ----------------------------
INSERT INTO `e_testpaper` VALUES ('1', '第一阶段考试', '1', '120', '100', '题的具体内容', '1');

-- ----------------------------
-- Table structure for e_user
-- ----------------------------
DROP TABLE IF EXISTS `e_user`;
CREATE TABLE `e_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `upassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_user
-- ----------------------------

-- ----------------------------
-- Table structure for e_user_role
-- ----------------------------
DROP TABLE IF EXISTS `e_user_role`;
CREATE TABLE `e_user_role` (
  `urid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`urid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for e_user_score
-- ----------------------------
DROP TABLE IF EXISTS `e_user_score`;
CREATE TABLE `e_user_score` (
  `usId` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '学生id',
  `tpId` int(11) DEFAULT NULL COMMENT '试卷id',
  `usScore` double DEFAULT NULL COMMENT '考试成绩',
  `usContent` text COMMENT '考生做完的试卷',
  `usStatus` int(11) DEFAULT NULL COMMENT '0 已经批改  1 未批改',
  PRIMARY KEY (`usId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_user_score
-- ----------------------------
INSERT INTO `e_user_score` VALUES ('1', '1', '1', '98.5', '考生做完的试卷', '0');

-- ----------------------------
-- Table structure for e_ynquestions
-- ----------------------------
DROP TABLE IF EXISTS `e_ynquestions`;
CREATE TABLE `e_ynquestions` (
  `yqId` int(11) NOT NULL AUTO_INCREMENT,
  `ytitle` varchar(255) DEFAULT NULL,
  `yanswer` int(11) DEFAULT NULL,
  PRIMARY KEY (`yqId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_ynquestions
-- ----------------------------
INSERT INTO `e_ynquestions` VALUES ('1', '1大于2？', '1');
