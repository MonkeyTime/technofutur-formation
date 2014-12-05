



-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;

-- ---
-- Table 'forum'
-- 
-- ---

DROP TABLE IF EXISTS `forum`;
		
CREATE TABLE `forum` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'subject'
-- 
-- ---

DROP TABLE IF EXISTS `subject`;
		
CREATE TABLE `subject` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `content` MEDIUMTEXT NOT NULL,
  `forum_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'response'
-- 
-- ---

DROP TABLE IF EXISTS `response`;
		
CREATE TABLE `response` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` MEDIUMTEXT NOT NULL,
  `subject_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'user'
-- 
-- ---

DROP TABLE IF EXISTS `user`;
		
CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(55) NOT NULL UNIQUE,
  `password` VARCHAR(196) NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `subject` ADD FOREIGN KEY (forum_id) REFERENCES `forum` (`id`);
ALTER TABLE `subject` ADD FOREIGN KEY (user_id) REFERENCES `user` (`id`);
ALTER TABLE `response` ADD FOREIGN KEY (subject_id) REFERENCES `subject` (`id`);
ALTER TABLE `response` ADD FOREIGN KEY (user_id) REFERENCES `user` (`id`);

-- ---
-- Test Data
-- ---

INSERT INTO `user` (`nickname`,`password`) VALUES
('user1','user1');
INSERT INTO `user` (`nickname`,`password`) VALUES
('user2','user2');
INSERT INTO `user` (`nickname`,`password`) VALUES
('user3','user3');

INSERT INTO `forum` (`name`,`description`) VALUES
('Java forum','Tout savoir sur Java');
INSERT INTO `forum` (`name`,`description`) VALUES
('UML forum','Tout savoir sur UML');
INSERT INTO `forum` (`name`,`description`) VALUES
('XML forum','Tout savoir sur XML');
INSERT INTO `subject` (`title`,`content`,`forum_id`, `user_id`) VALUES
('Lorem ipsum dolor si amet consequor', 

'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec velit vitae elit tincidunt imperdiet. Integer condimentum nisl id mattis ultrices. Ut lacinia libero lectus, porttitor pretium nulla congue vel. Aliquam erat volutpat. Phasellus in accumsan erat. Ut in tincidunt ex, sed euismod ante. Duis placerat elementum vulputate. Morbi bibendum sollicitudin quam, ac faucibus mauris maximus vitae. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus condimentum ut nulla pulvinar suscipit. Aliquam lacinia ante ut sem commodo congue. Cras faucibus auctor ligula sed congue. Aenean pulvinar metus ex, in porttitor nunc ultricies blandit. Nullam tincidunt eleifend ultrices. Maecenas metus metus, blandit id ornare quis, tempus ut risus. Cras hendrerit ultricies dui in vehicula.

Nulla sapien ligula, malesuada vehicula rhoncus eget, suscipit ac sapien. Pellentesque pulvinar vulputate tortor. Fusce eget magna non nulla lobortis congue. Vivamus mauris odio, maximus in nulla vel, viverra sodales felis. Vestibulum nec volutpat sapien, eu blandit eros. Sed maximus ipsum sem, id laoreet magna pretium mollis. Vestibulum nec consequat enim. Aliquam facilisis tempor elit, mattis semper sem congue sed. Mauris mattis mi nec massa blandit, eget luctus purus lobortis. Mauris convallis porta lorem, quis interdum dui consequat sed. Nunc dignissim rutrum fermentum. Nunc at lectus ultrices, volutpat risus quis, posuere sem. Maecenas vestibulum imperdiet vestibulum. Sed et mollis sem, ullamcorper lacinia lacus. Nullam eget lorem augue.

Cras sed sem id sem suscipit porta. Praesent convallis vehicula aliquam. In id odio felis. Ut ullamcorper porta est sit amet feugiat. Vestibulum eu leo lorem. Quisque rhoncus bibendum dictum. Vivamus sodales dolor ac eros consectetur, vitae bibendum est ultrices. Vestibulum vulputate nulla vitae quam mollis laoreet. Etiam est lorem, mollis ac tortor tempor, ultricies finibus tortor. Integer ultrices dictum lorem. Praesent lacinia nunc nisi, eu faucibus urna pretium in.

Phasellus nec sagittis diam, posuere commodo nulla. Phasellus posuere laoreet lacus. Phasellus tempus tortor eget arcu pellentesque ultrices. Nunc non neque elit. Fusce laoreet elit vitae felis dictum sagittis. Fusce felis mauris, porttitor in mauris et, fermentum hendrerit enim. Integer vestibulum nunc ligula, a consequat quam tristique id. Ut diam nulla, mollis sed molestie nec, lobortis sit amet nunc. In ultrices ac ipsum nec imperdiet. Vestibulum sodales erat ipsum, ut tincidunt arcu euismod ut. Vestibulum auctor at turpis feugiat eleifend. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam dapibus aliquam elit, quis consequat est ornare ac. In sed dui laoreet ipsum venenatis vehicula in eu enim.

Donec vitae sagittis augue, non pharetra ligula. Donec at ullamcorper ipsum. Vivamus vitae laoreet nulla. Donec condimentum dui quis sem elementum, non fermentum tellus sollicitudin. Suspendisse placerat ipsum vitae efficitur mattis. Cras ullamcorper tellus at sagittis lacinia. Vestibulum eget maximus nunc. Donec sed tristique odio. Vestibulum feugiat venenatis ultricies. Vestibulum at libero quis mi dignissim blandit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas aliquam ac neque ac feugiat.', 
1, 1);
INSERT INTO `subject` (`title`,`content`,`forum_id`, `user_id`) VALUES
('Lorem ipsum dolor si amet consequor 2', 

'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec velit vitae elit tincidunt imperdiet. Integer condimentum nisl id mattis ultrices. Ut lacinia libero lectus, porttitor pretium nulla congue vel. Aliquam erat volutpat. Phasellus in accumsan erat. Ut in tincidunt ex, sed euismod ante. Duis placerat elementum vulputate. Morbi bibendum sollicitudin quam, ac faucibus mauris maximus vitae. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus condimentum ut nulla pulvinar suscipit. Aliquam lacinia ante ut sem commodo congue. Cras faucibus auctor ligula sed congue. Aenean pulvinar metus ex, in porttitor nunc ultricies blandit. Nullam tincidunt eleifend ultrices. Maecenas metus metus, blandit id ornare quis, tempus ut risus. Cras hendrerit ultricies dui in vehicula.

Nulla sapien ligula, malesuada vehicula rhoncus eget, suscipit ac sapien. Pellentesque pulvinar vulputate tortor. Fusce eget magna non nulla lobortis congue. Vivamus mauris odio, maximus in nulla vel, viverra sodales felis. Vestibulum nec volutpat sapien, eu blandit eros. Sed maximus ipsum sem, id laoreet magna pretium mollis. Vestibulum nec consequat enim. Aliquam facilisis tempor elit, mattis semper sem congue sed. Mauris mattis mi nec massa blandit, eget luctus purus lobortis. Mauris convallis porta lorem, quis interdum dui consequat sed. Nunc dignissim rutrum fermentum. Nunc at lectus ultrices, volutpat risus quis, posuere sem. Maecenas vestibulum imperdiet vestibulum. Sed et mollis sem, ullamcorper lacinia lacus. Nullam eget lorem augue.

Cras sed sem id sem suscipit porta. Praesent convallis vehicula aliquam. In id odio felis. Ut ullamcorper porta est sit amet feugiat. Vestibulum eu leo lorem. Quisque rhoncus bibendum dictum. Vivamus sodales dolor ac eros consectetur, vitae bibendum est ultrices. Vestibulum vulputate nulla vitae quam mollis laoreet. Etiam est lorem, mollis ac tortor tempor, ultricies finibus tortor. Integer ultrices dictum lorem. Praesent lacinia nunc nisi, eu faucibus urna pretium in.

Phasellus nec sagittis diam, posuere commodo nulla. Phasellus posuere laoreet lacus. Phasellus tempus tortor eget arcu pellentesque ultrices. Nunc non neque elit. Fusce laoreet elit vitae felis dictum sagittis. Fusce felis mauris, porttitor in mauris et, fermentum hendrerit enim. Integer vestibulum nunc ligula, a consequat quam tristique id. Ut diam nulla, mollis sed molestie nec, lobortis sit amet nunc. In ultrices ac ipsum nec imperdiet. Vestibulum sodales erat ipsum, ut tincidunt arcu euismod ut. Vestibulum auctor at turpis feugiat eleifend. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam dapibus aliquam elit, quis consequat est ornare ac. In sed dui laoreet ipsum venenatis vehicula in eu enim.

Donec vitae sagittis augue, non pharetra ligula. Donec at ullamcorper ipsum. Vivamus vitae laoreet nulla. Donec condimentum dui quis sem elementum, non fermentum tellus sollicitudin. Suspendisse placerat ipsum vitae efficitur mattis. Cras ullamcorper tellus at sagittis lacinia. Vestibulum eget maximus nunc. Donec sed tristique odio. Vestibulum feugiat venenatis ultricies. Vestibulum at libero quis mi dignissim blandit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas aliquam ac neque ac feugiat.', 
1, 1);
INSERT INTO `subject` (`title`,`content`,`forum_id`, `user_id`) VALUES
('Lorem ipsum dolor si amet consequor', 

'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec velit vitae elit tincidunt imperdiet. Integer condimentum nisl id mattis ultrices. Ut lacinia libero lectus, porttitor pretium nulla congue vel. Aliquam erat volutpat. Phasellus in accumsan erat. Ut in tincidunt ex, sed euismod ante. Duis placerat elementum vulputate. Morbi bibendum sollicitudin quam, ac faucibus mauris maximus vitae. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus condimentum ut nulla pulvinar suscipit. Aliquam lacinia ante ut sem commodo congue. Cras faucibus auctor ligula sed congue. Aenean pulvinar metus ex, in porttitor nunc ultricies blandit. Nullam tincidunt eleifend ultrices. Maecenas metus metus, blandit id ornare quis, tempus ut risus. Cras hendrerit ultricies dui in vehicula.

Nulla sapien ligula, malesuada vehicula rhoncus eget, suscipit ac sapien. Pellentesque pulvinar vulputate tortor. Fusce eget magna non nulla lobortis congue. Vivamus mauris odio, maximus in nulla vel, viverra sodales felis. Vestibulum nec volutpat sapien, eu blandit eros. Sed maximus ipsum sem, id laoreet magna pretium mollis. Vestibulum nec consequat enim. Aliquam facilisis tempor elit, mattis semper sem congue sed. Mauris mattis mi nec massa blandit, eget luctus purus lobortis. Mauris convallis porta lorem, quis interdum dui consequat sed. Nunc dignissim rutrum fermentum. Nunc at lectus ultrices, volutpat risus quis, posuere sem. Maecenas vestibulum imperdiet vestibulum. Sed et mollis sem, ullamcorper lacinia lacus. Nullam eget lorem augue.

Cras sed sem id sem suscipit porta. Praesent convallis vehicula aliquam. In id odio felis. Ut ullamcorper porta est sit amet feugiat. Vestibulum eu leo lorem. Quisque rhoncus bibendum dictum. Vivamus sodales dolor ac eros consectetur, vitae bibendum est ultrices. Vestibulum vulputate nulla vitae quam mollis laoreet. Etiam est lorem, mollis ac tortor tempor, ultricies finibus tortor. Integer ultrices dictum lorem. Praesent lacinia nunc nisi, eu faucibus urna pretium in.

Phasellus nec sagittis diam, posuere commodo nulla. Phasellus posuere laoreet lacus. Phasellus tempus tortor eget arcu pellentesque ultrices. Nunc non neque elit. Fusce laoreet elit vitae felis dictum sagittis. Fusce felis mauris, porttitor in mauris et, fermentum hendrerit enim. Integer vestibulum nunc ligula, a consequat quam tristique id. Ut diam nulla, mollis sed molestie nec, lobortis sit amet nunc. In ultrices ac ipsum nec imperdiet. Vestibulum sodales erat ipsum, ut tincidunt arcu euismod ut. Vestibulum auctor at turpis feugiat eleifend. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam dapibus aliquam elit, quis consequat est ornare ac. In sed dui laoreet ipsum venenatis vehicula in eu enim.

Donec vitae sagittis augue, non pharetra ligula. Donec at ullamcorper ipsum. Vivamus vitae laoreet nulla. Donec condimentum dui quis sem elementum, non fermentum tellus sollicitudin. Suspendisse placerat ipsum vitae efficitur mattis. Cras ullamcorper tellus at sagittis lacinia. Vestibulum eget maximus nunc. Donec sed tristique odio. Vestibulum feugiat venenatis ultricies. Vestibulum at libero quis mi dignissim blandit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas aliquam ac neque ac feugiat.', 
2, 2);
INSERT INTO `subject` (`title`,`content`,`forum_id`, `user_id`) VALUES
('Lorem ipsum dolor si amet consequor 2', 

'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec velit vitae elit tincidunt imperdiet. Integer condimentum nisl id mattis ultrices. Ut lacinia libero lectus, porttitor pretium nulla congue vel. Aliquam erat volutpat. Phasellus in accumsan erat. Ut in tincidunt ex, sed euismod ante. Duis placerat elementum vulputate. Morbi bibendum sollicitudin quam, ac faucibus mauris maximus vitae. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus condimentum ut nulla pulvinar suscipit. Aliquam lacinia ante ut sem commodo congue. Cras faucibus auctor ligula sed congue. Aenean pulvinar metus ex, in porttitor nunc ultricies blandit. Nullam tincidunt eleifend ultrices. Maecenas metus metus, blandit id ornare quis, tempus ut risus. Cras hendrerit ultricies dui in vehicula.

Nulla sapien ligula, malesuada vehicula rhoncus eget, suscipit ac sapien. Pellentesque pulvinar vulputate tortor. Fusce eget magna non nulla lobortis congue. Vivamus mauris odio, maximus in nulla vel, viverra sodales felis. Vestibulum nec volutpat sapien, eu blandit eros. Sed maximus ipsum sem, id laoreet magna pretium mollis. Vestibulum nec consequat enim. Aliquam facilisis tempor elit, mattis semper sem congue sed. Mauris mattis mi nec massa blandit, eget luctus purus lobortis. Mauris convallis porta lorem, quis interdum dui consequat sed. Nunc dignissim rutrum fermentum. Nunc at lectus ultrices, volutpat risus quis, posuere sem. Maecenas vestibulum imperdiet vestibulum. Sed et mollis sem, ullamcorper lacinia lacus. Nullam eget lorem augue.

Cras sed sem id sem suscipit porta. Praesent convallis vehicula aliquam. In id odio felis. Ut ullamcorper porta est sit amet feugiat. Vestibulum eu leo lorem. Quisque rhoncus bibendum dictum. Vivamus sodales dolor ac eros consectetur, vitae bibendum est ultrices. Vestibulum vulputate nulla vitae quam mollis laoreet. Etiam est lorem, mollis ac tortor tempor, ultricies finibus tortor. Integer ultrices dictum lorem. Praesent lacinia nunc nisi, eu faucibus urna pretium in.

Phasellus nec sagittis diam, posuere commodo nulla. Phasellus posuere laoreet lacus. Phasellus tempus tortor eget arcu pellentesque ultrices. Nunc non neque elit. Fusce laoreet elit vitae felis dictum sagittis. Fusce felis mauris, porttitor in mauris et, fermentum hendrerit enim. Integer vestibulum nunc ligula, a consequat quam tristique id. Ut diam nulla, mollis sed molestie nec, lobortis sit amet nunc. In ultrices ac ipsum nec imperdiet. Vestibulum sodales erat ipsum, ut tincidunt arcu euismod ut. Vestibulum auctor at turpis feugiat eleifend. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam dapibus aliquam elit, quis consequat est ornare ac. In sed dui laoreet ipsum venenatis vehicula in eu enim.

Donec vitae sagittis augue, non pharetra ligula. Donec at ullamcorper ipsum. Vivamus vitae laoreet nulla. Donec condimentum dui quis sem elementum, non fermentum tellus sollicitudin. Suspendisse placerat ipsum vitae efficitur mattis. Cras ullamcorper tellus at sagittis lacinia. Vestibulum eget maximus nunc. Donec sed tristique odio. Vestibulum feugiat venenatis ultricies. Vestibulum at libero quis mi dignissim blandit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas aliquam ac neque ac feugiat.', 
2, 2);
INSERT INTO `subject` (`title`,`content`,`forum_id`, `user_id`) VALUES
('Lorem ipsum dolor si amet consequor', 

'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec velit vitae elit tincidunt imperdiet. Integer condimentum nisl id mattis ultrices. Ut lacinia libero lectus, porttitor pretium nulla congue vel. Aliquam erat volutpat. Phasellus in accumsan erat. Ut in tincidunt ex, sed euismod ante. Duis placerat elementum vulputate. Morbi bibendum sollicitudin quam, ac faucibus mauris maximus vitae. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus condimentum ut nulla pulvinar suscipit. Aliquam lacinia ante ut sem commodo congue. Cras faucibus auctor ligula sed congue. Aenean pulvinar metus ex, in porttitor nunc ultricies blandit. Nullam tincidunt eleifend ultrices. Maecenas metus metus, blandit id ornare quis, tempus ut risus. Cras hendrerit ultricies dui in vehicula.

Nulla sapien ligula, malesuada vehicula rhoncus eget, suscipit ac sapien. Pellentesque pulvinar vulputate tortor. Fusce eget magna non nulla lobortis congue. Vivamus mauris odio, maximus in nulla vel, viverra sodales felis. Vestibulum nec volutpat sapien, eu blandit eros. Sed maximus ipsum sem, id laoreet magna pretium mollis. Vestibulum nec consequat enim. Aliquam facilisis tempor elit, mattis semper sem congue sed. Mauris mattis mi nec massa blandit, eget luctus purus lobortis. Mauris convallis porta lorem, quis interdum dui consequat sed. Nunc dignissim rutrum fermentum. Nunc at lectus ultrices, volutpat risus quis, posuere sem. Maecenas vestibulum imperdiet vestibulum. Sed et mollis sem, ullamcorper lacinia lacus. Nullam eget lorem augue.

Cras sed sem id sem suscipit porta. Praesent convallis vehicula aliquam. In id odio felis. Ut ullamcorper porta est sit amet feugiat. Vestibulum eu leo lorem. Quisque rhoncus bibendum dictum. Vivamus sodales dolor ac eros consectetur, vitae bibendum est ultrices. Vestibulum vulputate nulla vitae quam mollis laoreet. Etiam est lorem, mollis ac tortor tempor, ultricies finibus tortor. Integer ultrices dictum lorem. Praesent lacinia nunc nisi, eu faucibus urna pretium in.

Phasellus nec sagittis diam, posuere commodo nulla. Phasellus posuere laoreet lacus. Phasellus tempus tortor eget arcu pellentesque ultrices. Nunc non neque elit. Fusce laoreet elit vitae felis dictum sagittis. Fusce felis mauris, porttitor in mauris et, fermentum hendrerit enim. Integer vestibulum nunc ligula, a consequat quam tristique id. Ut diam nulla, mollis sed molestie nec, lobortis sit amet nunc. In ultrices ac ipsum nec imperdiet. Vestibulum sodales erat ipsum, ut tincidunt arcu euismod ut. Vestibulum auctor at turpis feugiat eleifend. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam dapibus aliquam elit, quis consequat est ornare ac. In sed dui laoreet ipsum venenatis vehicula in eu enim.

Donec vitae sagittis augue, non pharetra ligula. Donec at ullamcorper ipsum. Vivamus vitae laoreet nulla. Donec condimentum dui quis sem elementum, non fermentum tellus sollicitudin. Suspendisse placerat ipsum vitae efficitur mattis. Cras ullamcorper tellus at sagittis lacinia. Vestibulum eget maximus nunc. Donec sed tristique odio. Vestibulum feugiat venenatis ultricies. Vestibulum at libero quis mi dignissim blandit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas aliquam ac neque ac feugiat.', 
3, 3);
INSERT INTO `subject` (`title`,`content`,`forum_id`, `user_id`) VALUES
('Lorem ipsum dolor si amet consequor 2', 

'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec velit vitae elit tincidunt imperdiet. Integer condimentum nisl id mattis ultrices. Ut lacinia libero lectus, porttitor pretium nulla congue vel. Aliquam erat volutpat. Phasellus in accumsan erat. Ut in tincidunt ex, sed euismod ante. Duis placerat elementum vulputate. Morbi bibendum sollicitudin quam, ac faucibus mauris maximus vitae. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus condimentum ut nulla pulvinar suscipit. Aliquam lacinia ante ut sem commodo congue. Cras faucibus auctor ligula sed congue. Aenean pulvinar metus ex, in porttitor nunc ultricies blandit. Nullam tincidunt eleifend ultrices. Maecenas metus metus, blandit id ornare quis, tempus ut risus. Cras hendrerit ultricies dui in vehicula.

Nulla sapien ligula, malesuada vehicula rhoncus eget, suscipit ac sapien. Pellentesque pulvinar vulputate tortor. Fusce eget magna non nulla lobortis congue. Vivamus mauris odio, maximus in nulla vel, viverra sodales felis. Vestibulum nec volutpat sapien, eu blandit eros. Sed maximus ipsum sem, id laoreet magna pretium mollis. Vestibulum nec consequat enim. Aliquam facilisis tempor elit, mattis semper sem congue sed. Mauris mattis mi nec massa blandit, eget luctus purus lobortis. Mauris convallis porta lorem, quis interdum dui consequat sed. Nunc dignissim rutrum fermentum. Nunc at lectus ultrices, volutpat risus quis, posuere sem. Maecenas vestibulum imperdiet vestibulum. Sed et mollis sem, ullamcorper lacinia lacus. Nullam eget lorem augue.

Cras sed sem id sem suscipit porta. Praesent convallis vehicula aliquam. In id odio felis. Ut ullamcorper porta est sit amet feugiat. Vestibulum eu leo lorem. Quisque rhoncus bibendum dictum. Vivamus sodales dolor ac eros consectetur, vitae bibendum est ultrices. Vestibulum vulputate nulla vitae quam mollis laoreet. Etiam est lorem, mollis ac tortor tempor, ultricies finibus tortor. Integer ultrices dictum lorem. Praesent lacinia nunc nisi, eu faucibus urna pretium in.

Phasellus nec sagittis diam, posuere commodo nulla. Phasellus posuere laoreet lacus. Phasellus tempus tortor eget arcu pellentesque ultrices. Nunc non neque elit. Fusce laoreet elit vitae felis dictum sagittis. Fusce felis mauris, porttitor in mauris et, fermentum hendrerit enim. Integer vestibulum nunc ligula, a consequat quam tristique id. Ut diam nulla, mollis sed molestie nec, lobortis sit amet nunc. In ultrices ac ipsum nec imperdiet. Vestibulum sodales erat ipsum, ut tincidunt arcu euismod ut. Vestibulum auctor at turpis feugiat eleifend. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam dapibus aliquam elit, quis consequat est ornare ac. In sed dui laoreet ipsum venenatis vehicula in eu enim.

Donec vitae sagittis augue, non pharetra ligula. Donec at ullamcorper ipsum. Vivamus vitae laoreet nulla. Donec condimentum dui quis sem elementum, non fermentum tellus sollicitudin. Suspendisse placerat ipsum vitae efficitur mattis. Cras ullamcorper tellus at sagittis lacinia. Vestibulum eget maximus nunc. Donec sed tristique odio. Vestibulum feugiat venenatis ultricies. Vestibulum at libero quis mi dignissim blandit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas aliquam ac neque ac feugiat.', 
3, 3);
INSERT INTO `response` (`content`,`subject_id`, `user_id`) VALUES
('1 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec velit vitae elit tincidunt imperdiet. Integer condimentum nisl id mattis ultrices. Ut lacinia libero lectus, porttitor pretium nulla congue vel. Aliquam erat volutpat. Phasellus in accumsan erat. Ut in tincidunt ex, sed euismod ante. Duis placerat elementum vulputate. Morbi bibendum sollicitudin quam, ac faucibus mauris maximus vitae. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus condimentum ut nulla pulvinar suscipit. Aliquam lacinia ante ut sem commodo congue. Cras faucibus auctor ligula sed congue. Aenean pulvinar metus ex, in porttitor nunc ultricies blandit. Nullam tincidunt eleifend ultrices. Maecenas metus metus, blandit id ornare quis, tempus ut risus. Cras hendrerit ultricies dui in vehicula.

Nulla sapien ligula, malesuada vehicula rhoncus eget, suscipit ac sapien. Pellentesque pulvinar vulputate tortor. Fusce eget magna non nulla lobortis congue. Vivamus mauris odio, maximus in nulla vel, viverra sodales felis. Vestibulum nec volutpat sapien, eu blandit eros. Sed maximus ipsum sem, id laoreet magna pretium mollis. Vestibulum nec consequat enim. Aliquam facilisis tempor elit, mattis semper sem congue sed. Mauris mattis mi nec massa blandit, eget luctus purus lobortis. Mauris convallis porta lorem, quis interdum dui consequat sed. Nunc dignissim rutrum fermentum. Nunc at lectus ultrices, volutpat risus quis, posuere sem. Maecenas vestibulum imperdiet vestibulum. Sed et mollis sem, ullamcorper lacinia lacus. Nullam eget lorem augue.',
1, 2);
INSERT INTO `response` (`content`,`subject_id`, `user_id`) VALUES
('2 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec velit vitae elit tincidunt imperdiet. Integer condimentum nisl id mattis ultrices. Ut lacinia libero lectus, porttitor pretium nulla congue vel. Aliquam erat volutpat. Phasellus in accumsan erat. Ut in tincidunt ex, sed euismod ante. Duis placerat elementum vulputate. Morbi bibendum sollicitudin quam, ac faucibus mauris maximus vitae. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus condimentum ut nulla pulvinar suscipit. Aliquam lacinia ante ut sem commodo congue. Cras faucibus auctor ligula sed congue. Aenean pulvinar metus ex, in porttitor nunc ultricies blandit. Nullam tincidunt eleifend ultrices. Maecenas metus metus, blandit id ornare quis, tempus ut risus. Cras hendrerit ultricies dui in vehicula.

Nulla sapien ligula, malesuada vehicula rhoncus eget, suscipit ac sapien. Pellentesque pulvinar vulputate tortor. Fusce eget magna non nulla lobortis congue. Vivamus mauris odio, maximus in nulla vel, viverra sodales felis. Vestibulum nec volutpat sapien, eu blandit eros. Sed maximus ipsum sem, id laoreet magna pretium mollis. Vestibulum nec consequat enim. Aliquam facilisis tempor elit, mattis semper sem congue sed. Mauris mattis mi nec massa blandit, eget luctus purus lobortis. Mauris convallis porta lorem, quis interdum dui consequat sed. Nunc dignissim rutrum fermentum. Nunc at lectus ultrices, volutpat risus quis, posuere sem. Maecenas vestibulum imperdiet vestibulum. Sed et mollis sem, ullamcorper lacinia lacus. Nullam eget lorem augue.',
1, 2);
INSERT INTO `response` (`content`,`subject_id`, `user_id`) VALUES
('1 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec velit vitae elit tincidunt imperdiet. Integer condimentum nisl id mattis ultrices. Ut lacinia libero lectus, porttitor pretium nulla congue vel. Aliquam erat volutpat. Phasellus in accumsan erat. Ut in tincidunt ex, sed euismod ante. Duis placerat elementum vulputate. Morbi bibendum sollicitudin quam, ac faucibus mauris maximus vitae. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus condimentum ut nulla pulvinar suscipit. Aliquam lacinia ante ut sem commodo congue. Cras faucibus auctor ligula sed congue. Aenean pulvinar metus ex, in porttitor nunc ultricies blandit. Nullam tincidunt eleifend ultrices. Maecenas metus metus, blandit id ornare quis, tempus ut risus. Cras hendrerit ultricies dui in vehicula.

Nulla sapien ligula, malesuada vehicula rhoncus eget, suscipit ac sapien. Pellentesque pulvinar vulputate tortor. Fusce eget magna non nulla lobortis congue. Vivamus mauris odio, maximus in nulla vel, viverra sodales felis. Vestibulum nec volutpat sapien, eu blandit eros. Sed maximus ipsum sem, id laoreet magna pretium mollis. Vestibulum nec consequat enim. Aliquam facilisis tempor elit, mattis semper sem congue sed. Mauris mattis mi nec massa blandit, eget luctus purus lobortis. Mauris convallis porta lorem, quis interdum dui consequat sed. Nunc dignissim rutrum fermentum. Nunc at lectus ultrices, volutpat risus quis, posuere sem. Maecenas vestibulum imperdiet vestibulum. Sed et mollis sem, ullamcorper lacinia lacus. Nullam eget lorem augue.',
2, 3);
INSERT INTO `response` (`content`,`subject_id`, `user_id`) VALUES
('2 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec velit vitae elit tincidunt imperdiet. Integer condimentum nisl id mattis ultrices. Ut lacinia libero lectus, porttitor pretium nulla congue vel. Aliquam erat volutpat. Phasellus in accumsan erat. Ut in tincidunt ex, sed euismod ante. Duis placerat elementum vulputate. Morbi bibendum sollicitudin quam, ac faucibus mauris maximus vitae. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus condimentum ut nulla pulvinar suscipit. Aliquam lacinia ante ut sem commodo congue. Cras faucibus auctor ligula sed congue. Aenean pulvinar metus ex, in porttitor nunc ultricies blandit. Nullam tincidunt eleifend ultrices. Maecenas metus metus, blandit id ornare quis, tempus ut risus. Cras hendrerit ultricies dui in vehicula.

Nulla sapien ligula, malesuada vehicula rhoncus eget, suscipit ac sapien. Pellentesque pulvinar vulputate tortor. Fusce eget magna non nulla lobortis congue. Vivamus mauris odio, maximus in nulla vel, viverra sodales felis. Vestibulum nec volutpat sapien, eu blandit eros. Sed maximus ipsum sem, id laoreet magna pretium mollis. Vestibulum nec consequat enim. Aliquam facilisis tempor elit, mattis semper sem congue sed. Mauris mattis mi nec massa blandit, eget luctus purus lobortis. Mauris convallis porta lorem, quis interdum dui consequat sed. Nunc dignissim rutrum fermentum. Nunc at lectus ultrices, volutpat risus quis, posuere sem. Maecenas vestibulum imperdiet vestibulum. Sed et mollis sem, ullamcorper lacinia lacus. Nullam eget lorem augue.',
2, 3);
INSERT INTO `response` (`content`,`subject_id`, `user_id`) VALUES
('1 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec velit vitae elit tincidunt imperdiet. Integer condimentum nisl id mattis ultrices. Ut lacinia libero lectus, porttitor pretium nulla congue vel. Aliquam erat volutpat. Phasellus in accumsan erat. Ut in tincidunt ex, sed euismod ante. Duis placerat elementum vulputate. Morbi bibendum sollicitudin quam, ac faucibus mauris maximus vitae. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus condimentum ut nulla pulvinar suscipit. Aliquam lacinia ante ut sem commodo congue. Cras faucibus auctor ligula sed congue. Aenean pulvinar metus ex, in porttitor nunc ultricies blandit. Nullam tincidunt eleifend ultrices. Maecenas metus metus, blandit id ornare quis, tempus ut risus. Cras hendrerit ultricies dui in vehicula.

Nulla sapien ligula, malesuada vehicula rhoncus eget, suscipit ac sapien. Pellentesque pulvinar vulputate tortor. Fusce eget magna non nulla lobortis congue. Vivamus mauris odio, maximus in nulla vel, viverra sodales felis. Vestibulum nec volutpat sapien, eu blandit eros. Sed maximus ipsum sem, id laoreet magna pretium mollis. Vestibulum nec consequat enim. Aliquam facilisis tempor elit, mattis semper sem congue sed. Mauris mattis mi nec massa blandit, eget luctus purus lobortis. Mauris convallis porta lorem, quis interdum dui consequat sed. Nunc dignissim rutrum fermentum. Nunc at lectus ultrices, volutpat risus quis, posuere sem. Maecenas vestibulum imperdiet vestibulum. Sed et mollis sem, ullamcorper lacinia lacus. Nullam eget lorem augue.',
3, 1);
INSERT INTO `response` (`content`,`subject_id`, `user_id`) VALUES
('2 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec velit vitae elit tincidunt imperdiet. Integer condimentum nisl id mattis ultrices. Ut lacinia libero lectus, porttitor pretium nulla congue vel. Aliquam erat volutpat. Phasellus in accumsan erat. Ut in tincidunt ex, sed euismod ante. Duis placerat elementum vulputate. Morbi bibendum sollicitudin quam, ac faucibus mauris maximus vitae. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus condimentum ut nulla pulvinar suscipit. Aliquam lacinia ante ut sem commodo congue. Cras faucibus auctor ligula sed congue. Aenean pulvinar metus ex, in porttitor nunc ultricies blandit. Nullam tincidunt eleifend ultrices. Maecenas metus metus, blandit id ornare quis, tempus ut risus. Cras hendrerit ultricies dui in vehicula.

Nulla sapien ligula, malesuada vehicula rhoncus eget, suscipit ac sapien. Pellentesque pulvinar vulputate tortor. Fusce eget magna non nulla lobortis congue. Vivamus mauris odio, maximus in nulla vel, viverra sodales felis. Vestibulum nec volutpat sapien, eu blandit eros. Sed maximus ipsum sem, id laoreet magna pretium mollis. Vestibulum nec consequat enim. Aliquam facilisis tempor elit, mattis semper sem congue sed. Mauris mattis mi nec massa blandit, eget luctus purus lobortis. Mauris convallis porta lorem, quis interdum dui consequat sed. Nunc dignissim rutrum fermentum. Nunc at lectus ultrices, volutpat risus quis, posuere sem. Maecenas vestibulum imperdiet vestibulum. Sed et mollis sem, ullamcorper lacinia lacus. Nullam eget lorem augue.',
3, 1);
