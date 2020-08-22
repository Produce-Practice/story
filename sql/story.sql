# Host: localhost  (Version 5.7.27)
# Date: 2020-08-23 00:17:07
# Generator: MySQL-Front 6.0  (Build 2.20)


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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (3,'275518','sun','EEA308B243ABBFA8877DCEFC2B32E235',NULL,1,'FA7BC88F-1BFA-4625-9C51-A6EF582F7954',NULL,NULL,'');
