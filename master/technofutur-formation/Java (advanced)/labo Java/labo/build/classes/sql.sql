



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
  `title` VARCHAR(55) NOT NULL,
  `creationTime` DATETIME NOT NULL,
  `lastPostTime` DATETIME NOT NULL,
  `totalViews` INT NULL DEFAULT NULL,
  `totalReplies` INT NULL DEFAULT NULL,
  `createdBy` VARCHAR(55) NOT NULL,
  `lastPostBy` VARCHAR(55) NOT NULL,
  `forumId` INT NOT NULL,
  `message` MEDIUMTEXT NOT NULL,
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
  `username` VARCHAR(55) NOT NULL,
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
-- INSERT INTO `Topic` (`id`,`title`,`creationTime`,`lastPostTime`,`totalViews`,`totalReplies`,`createdBy`,`lastPostBy`,`forumId`,`message`) VALUES
-- ('','','','','','','','','','');
-- INSERT INTO `Post` (`id`,`creationTime`,`title`,`message`,`topicId`,`userId`) VALUES
-- ('','','','','','');
-- INSERT INTO `User` (`id`,`username`,`password`,`firstName`,`lastName`,`email`,`totalPosts`,`registrationDate`,`lastVisit`,`roleId`) VALUES
-- ('','','','','','','','','','');
-- INSERT INTO `Role` (`id`,`name`,`description`) VALUES
-- ('','','');