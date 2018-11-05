/*
Navicat MySQL Data Transfer

Source Server         : zjz
Source Server Version : 50130
Source Host           : localhost:3306
Source Database       : blogs

Target Server Type    : MYSQL
Target Server Version : 50130
File Encoding         : 65001

Date: 2013-07-30 20:51:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `aricle`
-- ----------------------------
DROP TABLE IF EXISTS `aricle`;
CREATE TABLE `aricle` (
  `ArticleId` int(4) NOT NULL AUTO_INCREMENT,
  `UserId` int(4) NOT NULL,
  `ArticleName` varchar(50) NOT NULL,
  `ArticleContent` varchar(1000) NOT NULL,
  `PubTime` datetime DEFAULT NULL,
  PRIMARY KEY (`ArticleId`),
  KEY `fk-Ariticle-User` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aricle
-- ----------------------------
INSERT INTO `aricle` VALUES ('11', '40', 'test2文章', '<h2 style=\"font-style:italic;\">&nbsp;&nbsp;&nbsp; 网易娱乐7月16日报道近日，被网友吐槽为&ldquo;万千星辉贺台庆&rdquo;式的群星戏《不二神探》遭遇恶评如潮，连李连杰、文章这种&ldquo;得道高僧&rdquo;和如日中天的实力小生亦未能幸免，但是影片中插入了几段对打功夫戏份却被影迷大为称赞，&ldquo;绝对的商业电影中的硬菜！</h2>\r\n', null);
INSERT INTO `aricle` VALUES ('12', '39', 'test1文章', '<h1>test1的文章内容</h1>\r\n', null);

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `CommentId` int(4) NOT NULL AUTO_INCREMENT,
  `ArticleId` int(4) NOT NULL,
  `CommentContent` varchar(200) NOT NULL,
  `UserId` int(4) NOT NULL,
  `UserName` varchar(255) NOT NULL,
  PRIMARY KEY (`CommentId`),
  KEY `fk-Comment-User` (`UserId`),
  KEY `fk-Comment-Aricle` (`ArticleId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('4', '11', '李连杰演得好', '39', 'test1@qq.com');
INSERT INTO `comment` VALUES ('5', '12', '这文章写的太烂！', '40', 'test2@qq.com');

-- ----------------------------
-- Table structure for `friend`
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `FriendId` int(4) NOT NULL AUTO_INCREMENT,
  `FriendName` varchar(50) NOT NULL,
  `UserId` int(4) NOT NULL,
  PRIMARY KEY (`FriendId`),
  KEY `fk-Friend-User` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES ('35', 'test1@qq.com', '40');
INSERT INTO `friend` VALUES ('36', 'test1@qq.com', '41');
INSERT INTO `friend` VALUES ('37', '123@qq.com', '42');
INSERT INTO `friend` VALUES ('38', 'test2@qq.com', '39');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `MessageId` int(4) NOT NULL AUTO_INCREMENT,
  `UseId` int(4) NOT NULL,
  `MessageContent` varchar(200) NOT NULL,
  `FriendId` int(4) NOT NULL,
  `FriendName` varchar(200) NOT NULL,
  `ToUserId` int(11) NOT NULL,
  PRIMARY KEY (`MessageId`),
  KEY `fk-Message-User` (`UseId`),
  KEY `fk-Message-Friend` (`FriendId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('8', '39', 'test1给你请俺啦', '38', 'test1@qq.com', '40');
INSERT INTO `message` VALUES ('9', '40', '我给你留言了哦', '35', 'test2@qq.com', '39');

-- ----------------------------
-- Table structure for `photo`
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `PhotoId` int(4) NOT NULL AUTO_INCREMENT,
  `UserId` int(4) NOT NULL,
  `Url` varchar(50) NOT NULL,
  PRIMARY KEY (`PhotoId`),
  KEY `fk-Photo-User` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of photo
-- ----------------------------
INSERT INTO `photo` VALUES ('33', '40', '162300n3u33k8h0pnn0kmg.jpg');
INSERT INTO `photo` VALUES ('34', '40', '162319hzdmpmzsnditb7ar.jpg');
INSERT INTO `photo` VALUES ('35', '40', 'Water lilies.jpg');
INSERT INTO `photo` VALUES ('36', '39', 'Sunset.jpg');

-- ----------------------------
-- Table structure for `reply`
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `ReplyId` int(4) NOT NULL AUTO_INCREMENT,
  `ReplyContent` varchar(200) NOT NULL,
  `RmessageId` int(4) NOT NULL,
  `UserId` int(4) NOT NULL,
  `FriendId` int(4) NOT NULL,
  PRIMARY KEY (`ReplyId`),
  KEY `fk-Reply-Massage` (`RmessageId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('3', '跪安！\r\n	', '8', '40', '40');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `UserId` int(4) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) NOT NULL,
  `UserPasswd` varchar(50) NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('39', 'test1@qq.com', '123');
INSERT INTO `user` VALUES ('40', 'test2@qq.com', '123');
INSERT INTO `user` VALUES ('41', '1101418000@qq.com', '123');
INSERT INTO `user` VALUES ('42', '123', '1');
INSERT INTO `user` VALUES ('43', '1', '123');

-- ----------------------------
-- Table structure for `userinformation`
-- ----------------------------
DROP TABLE IF EXISTS `userinformation`;
CREATE TABLE `userinformation` (
  `InformationId` int(4) NOT NULL AUTO_INCREMENT,
  `UserId` int(4) NOT NULL,
  `TickName` varchar(50) DEFAULT NULL,
  `Telphone` varchar(20) DEFAULT NULL,
  `Hobby` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`InformationId`),
  KEY `fk1` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinformation
-- ----------------------------
INSERT INTO `userinformation` VALUES ('9', '39', 'test1', '12312321', '看书');
INSERT INTO `userinformation` VALUES ('10', '40', 'test2', '不告诉你', '你猜');
INSERT INTO `userinformation` VALUES ('11', '41', null, null, null);
INSERT INTO `userinformation` VALUES ('12', '42', null, null, null);
INSERT INTO `userinformation` VALUES ('13', '43', null, null, null);
