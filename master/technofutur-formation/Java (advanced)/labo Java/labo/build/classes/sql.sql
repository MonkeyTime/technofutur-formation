DROP TABLE IF EXISTS `REVINFO`;
		
CREATE TABLE `REVINFO` (
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `hibernate_sequence`;
		
CREATE TABLE `hibernate_sequence` (
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
);


-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;

-- ---
-- Table 'Category'
-- 
-- ---

DROP TABLE IF EXISTS `Category`;
		
CREATE TABLE `Category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(55) NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'Forum'
-- 
-- ---

DROP TABLE IF EXISTS `Forum`;
		
CREATE TABLE `Forum` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` MEDIUMTEXT NULL DEFAULT NULL,
  `totalTopics` INT NULL DEFAULT NULL,
  `totalPosts` INT NULL DEFAULT NULL,
  `categoryId` INT NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'Topic'
-- 
-- ---

DROP TABLE IF EXISTS `Topic`;
		
CREATE TABLE `Topic` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `creationTime` DATETIME NOT NULL,
  `lastPostTime` DATETIME NOT NULL,
  `totalViews` INT NULL DEFAULT NULL,
  `totalReplies` INT NULL DEFAULT NULL,
  `createdBy` VARCHAR(55) NOT NULL,
  `lastPostBy` VARCHAR(55) NOT NULL,
  `forumId` INT NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'Post'
-- 
-- ---

DROP TABLE IF EXISTS `Post`;
		
CREATE TABLE `Post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `creationTime` DATETIME NOT NULL,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  `message` MEDIUMTEXT NOT NULL,
  `topicId` INT NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  `userId` INT NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'User'
-- 
-- ---

DROP TABLE IF EXISTS `User`;
		
CREATE TABLE `User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(55) UNIQUE NOT NULL,
  `password` VARCHAR(196) NOT NULL,
  `firstName` VARCHAR(55) NULL DEFAULT NULL,
  `lastName` VARCHAR(55) NULL DEFAULT NULL,
  `email` VARCHAR(255) NOT NULL,
  `totalPosts` INT NULL DEFAULT NULL,
  `registrationDate` DATE NOT NULL,
  `lastVisit` DATETIME NOT NULL,
  `roleId` INT NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'Role'
-- 
-- ---

DROP TABLE IF EXISTS `Role`;
		
CREATE TABLE `Role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(55) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `Forum` ADD FOREIGN KEY (categoryId) REFERENCES `Category` (`id`);
ALTER TABLE `Topic` ADD FOREIGN KEY (forumId) REFERENCES `Forum` (`id`);
ALTER TABLE `Post` ADD FOREIGN KEY (topicId) REFERENCES `Topic` (`id`);
ALTER TABLE `Post` ADD FOREIGN KEY (userId) REFERENCES `User` (`id`);
ALTER TABLE `User` ADD FOREIGN KEY (roleId) REFERENCES `Role` (`id`);

-- ---
-- Table Properties
-- ---

-- ALTER TABLE `Category` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `Forum` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `Topic` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `Post` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `User` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `Role` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Test Data
-- ---

INSERT INTO `Category` (`name`) VALUES
('Java');
INSERT INTO `Category` (`name`) VALUES
('C++');
INSERT INTO `Forum` (`name`,`description`,`totalTopics`,`totalPosts`,`categoryId`) VALUES
('Spring MVC','Spring MVC...',1,1,1);
INSERT INTO `Forum` (`name`,`description`,`totalTopics`,`totalPosts`,`categoryId`) VALUES
('Spring Framework','Spring Framework...',1,1,1);
INSERT INTO `Forum` (`name`,`description`,`totalTopics`,`totalPosts`,`categoryId`) VALUES
('Boost','Boost...',1,1,2);

INSERT INTO `Role` (`name`,`description`) VALUES
('Admin','Administrator site');
INSERT INTO `Role` (`name`,`description`) VALUES
('User','User site');

INSERT INTO `User` (`username`,`password`,`firstName`,`lastName`,`email`,`totalPosts`,`registrationDate`,`lastVisit`,`roleId`) VALUES
('MonkeyTime','monkeytime','Laurent','Bertrand','pix@gmail.com','1','2014-09-03','2014-10-26 12:09:43',1);
INSERT INTO `User` (`username`,`password`,`firstName`,`lastName`,`email`,`totalPosts`,`registrationDate`,`lastVisit`,`roleId`) VALUES
('MonkeyTime2','monkeytime','Laurent2','Bertrand2','pix@gmail.com','2','2014-12-28','2014-12-28 12:10:24',2);

INSERT INTO `Topic` (`title`,`creationTime`,`lastPostTime`,`totalViews`,`totalReplies`,`createdBy`,`lastPostBy`,`forumId`) VALUES
('Lorem ipsum dolor sit amet, consectetur adipiscing elit.','2014-10-27 12:10:43','2014-10-27 12:10:43',1,1,'MonkeyTime','MonkeyTime', 1);
INSERT INTO `Topic` (`title`,`creationTime`,`lastPostTime`,`totalViews`,`totalReplies`,`createdBy`,`lastPostBy`,`forumId`) VALUES
('Lorem ipsum dolor sit amet, consectetur adipiscing elit.','2014-10-27 12:10:43','2014-10-27 12:10:43',1,1,'MonkeyTime','MonkeyTime', 2);
INSERT INTO `Topic` (`title`,`creationTime`,`lastPostTime`,`totalViews`,`totalReplies`,`createdBy`,`lastPostBy`,`forumId`) VALUES
('Lorem ipsum dolor sit amet, consectetur adipiscing elit.','2014-10-27 12:10:43','2014-10-27 12:10:43',1,1,'MonkeyTime','MonkeyTime', 3);

INSERT INTO `Post` (`creationTime`,`title`,`message`,`topicId`,`username`,`userId`) VALUES
('2014-10-27 12:10:43',NULL,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras accumsan lacus augue, eget varius orci aliquam ac. Nunc aliquam pharetra augue eleifend feugiat. In hac habitasse platea dictumst. Mauris erat leo, pulvinar sed sem rhoncus, placerat vehicula elit. Curabitur ac nulla vel felis volutpat pulvinar a ac velit. Aenean sit amet ligula dui. Praesent consectetur massa quis turpis tincidunt, in ornare quam viverra. Proin enim metus, facilisis ut sapien ac, auctor eleifend nibh. Etiam ultrices blandit dolor semper molestie. Sed eget elementum nibh, sit amet facilisis augue. Donec interdum nunc vitae felis accumsan ornare. Donec quis leo posuere, blandit justo non, gravida arcu. Vestibulum at porttitor leo. Aliquam a elementum ligula.

Maecenas aliquet rhoncus quam. Nulla posuere maximus gravida. Nulla placerat, tortor ut finibus congue, lectus leo vulputate risus, facilisis hendrerit dui dui id risus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec tempus mi ut erat tincidunt pretium. Nullam tempor, nunc nec eleifend imperdiet, mi nisi vestibulum dui, quis rhoncus erat elit blandit dui. Donec sed ante nibh. Etiam non dui eleifend, porta lacus vitae, mattis mauris. Nullam commodo lectus eu eleifend feugiat. Vivamus pretium, augue id molestie mollis, diam mi fringilla libero, non posuere nunc quam ac purus. Duis gravida sagittis quam id venenatis. Etiam vel cursus lorem, ac gravida augue. Ut bibendum consectetur fermentum.

Nullam non placerat mi. Praesent faucibus est diam, sit amet tempor nisi faucibus ac. Ut ultricies velit eget diam faucibus, hendrerit maximus nisi suscipit. Nunc convallis, diam vitae dictum ultricies, eros nisi ultrices magna, id feugiat nisl arcu ut elit. Nunc cursus rutrum mollis. Nam non erat vehicula, molestie justo vel, eleifend massa. In ornare dui finibus, dignissim justo eget, ullamcorper enim. Mauris fermentum molestie dolor, sodales scelerisque augue tristique in. Quisque vitae consequat ex. Pellentesque sollicitudin dui eu faucibus tempus. Praesent sed consequat leo. Morbi commodo gravida lorem nec gravida. Nulla luctus enim at condimentum luctus. Vestibulum nec sapien tellus. Donec non sapien eu metus lacinia elementum a eget sapien.',1,'MonkeyTime', 1);

INSERT INTO `Post` (`creationTime`,`title`,`message`,`topicId`,`username`,`userId`) VALUES
('2014-10-27 12:10:43',NULL,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras accumsan lacus augue, eget varius orci aliquam ac. Nunc aliquam pharetra augue eleifend feugiat. In hac habitasse platea dictumst. Mauris erat leo, pulvinar sed sem rhoncus, placerat vehicula elit. Curabitur ac nulla vel felis volutpat pulvinar a ac velit. Aenean sit amet ligula dui. Praesent consectetur massa quis turpis tincidunt, in ornare quam viverra. Proin enim metus, facilisis ut sapien ac, auctor eleifend nibh. Etiam ultrices blandit dolor semper molestie. Sed eget elementum nibh, sit amet facilisis augue. Donec interdum nunc vitae felis accumsan ornare. Donec quis leo posuere, blandit justo non, gravida arcu. Vestibulum at porttitor leo. Aliquam a elementum ligula.

Maecenas aliquet rhoncus quam. Nulla posuere maximus gravida. Nulla placerat, tortor ut finibus congue, lectus leo vulputate risus, facilisis hendrerit dui dui id risus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec tempus mi ut erat tincidunt pretium. Nullam tempor, nunc nec eleifend imperdiet, mi nisi vestibulum dui, quis rhoncus erat elit blandit dui. Donec sed ante nibh. Etiam non dui eleifend, porta lacus vitae, mattis mauris. Nullam commodo lectus eu eleifend feugiat. Vivamus pretium, augue id molestie mollis, diam mi fringilla libero, non posuere nunc quam ac purus. Duis gravida sagittis quam id venenatis. Etiam vel cursus lorem, ac gravida augue. Ut bibendum consectetur fermentum.

Nullam non placerat mi. Praesent faucibus est diam, sit amet tempor nisi faucibus ac. Ut ultricies velit eget diam faucibus, hendrerit maximus nisi suscipit. Nunc convallis, diam vitae dictum ultricies, eros nisi ultrices magna, id feugiat nisl arcu ut elit. Nunc cursus rutrum mollis. Nam non erat vehicula, molestie justo vel, eleifend massa. In ornare dui finibus, dignissim justo eget, ullamcorper enim. Mauris fermentum molestie dolor, sodales scelerisque augue tristique in. Quisque vitae consequat ex. Pellentesque sollicitudin dui eu faucibus tempus. Praesent sed consequat leo. Morbi commodo gravida lorem nec gravida. Nulla luctus enim at condimentum luctus. Vestibulum nec sapien tellus. Donec non sapien eu metus lacinia elementum a eget sapien.',1,'MonkeyTime2', 2);

INSERT INTO `Post` (`creationTime`,`title`,`message`,`topicId`,`username`,`userId`) VALUES
('2014-10-27 12:10:43',NULL,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras accumsan lacus augue, eget varius orci aliquam ac. Nunc aliquam pharetra augue eleifend feugiat. In hac habitasse platea dictumst. Mauris erat leo, pulvinar sed sem rhoncus, placerat vehicula elit. Curabitur ac nulla vel felis volutpat pulvinar a ac velit. Aenean sit amet ligula dui. Praesent consectetur massa quis turpis tincidunt, in ornare quam viverra. Proin enim metus, facilisis ut sapien ac, auctor eleifend nibh. Etiam ultrices blandit dolor semper molestie. Sed eget elementum nibh, sit amet facilisis augue. Donec interdum nunc vitae felis accumsan ornare. Donec quis leo posuere, blandit justo non, gravida arcu. Vestibulum at porttitor leo. Aliquam a elementum ligula.

Maecenas aliquet rhoncus quam. Nulla posuere maximus gravida. Nulla placerat, tortor ut finibus congue, lectus leo vulputate risus, facilisis hendrerit dui dui id risus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec tempus mi ut erat tincidunt pretium. Nullam tempor, nunc nec eleifend imperdiet, mi nisi vestibulum dui, quis rhoncus erat elit blandit dui. Donec sed ante nibh. Etiam non dui eleifend, porta lacus vitae, mattis mauris. Nullam commodo lectus eu eleifend feugiat. Vivamus pretium, augue id molestie mollis, diam mi fringilla libero, non posuere nunc quam ac purus. Duis gravida sagittis quam id venenatis. Etiam vel cursus lorem, ac gravida augue. Ut bibendum consectetur fermentum.

Nullam non placerat mi. Praesent faucibus est diam, sit amet tempor nisi faucibus ac. Ut ultricies velit eget diam faucibus, hendrerit maximus nisi suscipit. Nunc convallis, diam vitae dictum ultricies, eros nisi ultrices magna, id feugiat nisl arcu ut elit. Nunc cursus rutrum mollis. Nam non erat vehicula, molestie justo vel, eleifend massa. In ornare dui finibus, dignissim justo eget, ullamcorper enim. Mauris fermentum molestie dolor, sodales scelerisque augue tristique in. Quisque vitae consequat ex. Pellentesque sollicitudin dui eu faucibus tempus. Praesent sed consequat leo. Morbi commodo gravida lorem nec gravida. Nulla luctus enim at condimentum luctus. Vestibulum nec sapien tellus. Donec non sapien eu metus lacinia elementum a eget sapien.',2,'MonkeyTime2', 2);

INSERT INTO `Post` (`creationTime`,`title`,`message`,`topicId`,`username`,`userId`) VALUES
('2014-10-27 12:10:43',NULL,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras accumsan lacus augue, eget varius orci aliquam ac. Nunc aliquam pharetra augue eleifend feugiat. In hac habitasse platea dictumst. Mauris erat leo, pulvinar sed sem rhoncus, placerat vehicula elit. Curabitur ac nulla vel felis volutpat pulvinar a ac velit. Aenean sit amet ligula dui. Praesent consectetur massa quis turpis tincidunt, in ornare quam viverra. Proin enim metus, facilisis ut sapien ac, auctor eleifend nibh. Etiam ultrices blandit dolor semper molestie. Sed eget elementum nibh, sit amet facilisis augue. Donec interdum nunc vitae felis accumsan ornare. Donec quis leo posuere, blandit justo non, gravida arcu. Vestibulum at porttitor leo. Aliquam a elementum ligula.

Maecenas aliquet rhoncus quam. Nulla posuere maximus gravida. Nulla placerat, tortor ut finibus congue, lectus leo vulputate risus, facilisis hendrerit dui dui id risus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec tempus mi ut erat tincidunt pretium. Nullam tempor, nunc nec eleifend imperdiet, mi nisi vestibulum dui, quis rhoncus erat elit blandit dui. Donec sed ante nibh. Etiam non dui eleifend, porta lacus vitae, mattis mauris. Nullam commodo lectus eu eleifend feugiat. Vivamus pretium, augue id molestie mollis, diam mi fringilla libero, non posuere nunc quam ac purus. Duis gravida sagittis quam id venenatis. Etiam vel cursus lorem, ac gravida augue. Ut bibendum consectetur fermentum.

Nullam non placerat mi. Praesent faucibus est diam, sit amet tempor nisi faucibus ac. Ut ultricies velit eget diam faucibus, hendrerit maximus nisi suscipit. Nunc convallis, diam vitae dictum ultricies, eros nisi ultrices magna, id feugiat nisl arcu ut elit. Nunc cursus rutrum mollis. Nam non erat vehicula, molestie justo vel, eleifend massa. In ornare dui finibus, dignissim justo eget, ullamcorper enim. Mauris fermentum molestie dolor, sodales scelerisque augue tristique in. Quisque vitae consequat ex. Pellentesque sollicitudin dui eu faucibus tempus. Praesent sed consequat leo. Morbi commodo gravida lorem nec gravida. Nulla luctus enim at condimentum luctus. Vestibulum nec sapien tellus. Donec non sapien eu metus lacinia elementum a eget sapien.',3,'MonkeyTime2', 2);