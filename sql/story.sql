# Host: localhost  (Version 5.7.27)
# Date: 2020-08-24 16:49:05
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "idea"
#

DROP TABLE IF EXISTS `idea`;
CREATE TABLE `idea` (
  `ideaId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0',
  `typeId` int(11) NOT NULL DEFAULT '0',
  `title` varchar(255) NOT NULL DEFAULT '',
  `content` varchar(6000) NOT NULL DEFAULT '',
  `likes` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `visits` int(11) NOT NULL DEFAULT '0' COMMENT '访问人次',
  `visibility` int(11) NOT NULL DEFAULT '0' COMMENT '0: private; 1: public;',
  PRIMARY KEY (`ideaId`),
  KEY `typeId` (`typeId`),
  KEY `userId` (`userId`),
  CONSTRAINT `typeId` FOREIGN KEY (`typeId`) REFERENCES `type` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "idea"
#


#
# Structure for table "role"
#

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(25) NOT NULL DEFAULT '',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

#
# Data for table "role"
#

INSERT INTO `role` VALUES (1,'admin'),(2,'creator');

#
# Structure for table "type"
#

DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

#
# Data for table "type"
#

INSERT INTO `type` VALUES (1,'文学'),(2,'音乐'),(3,'影评'),(4,'随笔');

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userAccount` varchar(25) NOT NULL DEFAULT '',
  `userName` varchar(25) NOT NULL DEFAULT '' COMMENT '昵称',
  `password` varchar(255) NOT NULL DEFAULT '',
  `sign` varchar(255) DEFAULT '',
  `roleId` int(11) NOT NULL DEFAULT '0',
  `salt` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `email` varchar(30) DEFAULT '',
  PRIMARY KEY (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (3,'275518','sun','EEA308B243ABBFA8877DCEFC2B32E235',NULL,1,'FA7BC88F-1BFA-4625-9C51-A6EF582F7954',NULL,NULL,''),(4,'275516','hello','45F6C81DB7FC86CB3495CE571F374959',NULL,1,'F0458930-4232-44A6-9482-046E9686CCA3',NULL,NULL,''),(5,'','小光','B55AEBBE07172424CE286BE0C4409A23',NULL,1,'8FDC3D91-7BE5-43A4-AA01-0B7ABE6BF7F5',NULL,NULL,''),(6,'275514','小光','EE0EF8000943995A580614CF30DA3188',NULL,1,'C800B755-D0B9-4F7D-BA36-6CC4EC5E2CB8',NULL,NULL,''),(7,'275510','小光','1B5B53868D35F13F2BC2BCF2E29D5F3B',NULL,1,'E1F61B48-E4C2-466B-998C-527029097AA1',NULL,NULL,'');

#
# Structure for table "comment"
#

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `ideaId` int(11) NOT NULL DEFAULT '0',
  `content` varchar(255) NOT NULL DEFAULT '',
  `userId` int(11) NOT NULL DEFAULT '0',
  `commentTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `parentId` int(11) DEFAULT '0',
  PRIMARY KEY (`commentId`),
  KEY `ideaId` (`ideaId`),
  KEY `userId_0` (`userId`),
  CONSTRAINT `ideaId` FOREIGN KEY (`ideaId`) REFERENCES `idea` (`ideaId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userId_0` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "comment"
#

