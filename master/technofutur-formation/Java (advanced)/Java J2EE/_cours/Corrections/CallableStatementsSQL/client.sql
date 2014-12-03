use test;

drop table if exists client;
DROP procedure IF EXISTS `search_client_by_name`;
DROP procedure IF EXISTS `delete_client_by_name`;
DROP procedure IF EXISTS `search_client_by_id`;
DROP procedure IF EXISTS `insert_client`;
DROP procedure IF EXISTS `update_client_by_id`;

CREATE TABLE `client` (
	`client_id` int NOT NULL AUTO_INCREMENT,
	`first_name` varchar(255) NOT NULL DEFAULT 'Unknow',
	`last_name` varchar(255) NOT NULL DEFAULT 'Unknow',
	PRIMARY KEY (`client_id`),
	UNIQUE KEY `unique_constraint` (`first_name`,`last_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_client_by_name`(in sfirst_name varchar(255), in slast_name varchar(255))
BEGIN
	set SQL_SAFE_UPDATES = 0;
	delete from client where `first_name`=sfirst_name and `last_name`=slast_name;
	set SQL_SAFE_UPDATES = 1;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_client`(in sfirst_name varchar(255), in slast_name varchar(255))
BEGIN
	insert into client(`first_name`, `last_name`) values(sfirst_name, slast_name);
	select * from client where client_id=LAST_INSERT_ID();
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `search_client_by_id`(in search_key int)
BEGIN
	select `client_id`, `first_name`, `last_name` from client where `client_id`=search_key;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `search_client_by_name`(in sfirst_name varchar(255), in slast_name varchar(255))
BEGIN
	select `client_id`, `first_name`, `last_name` from client where `first_name`=sfirst_name and `last_name`=slast_name;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_client_by_id`(in search_id int, in sfirst_name varchar(255), in slast_name varchar(255))
BEGIN
	set SQL_SAFE_UPDATES = 0;
	update client set `first_name`=sfirst_name, `last_name`=slast_name where `client_id`=search_id;
	set SQL_SAFE_UPDATES = 1;
END$$
DELIMITER ;


call insert_client('Arya','Stark');
call insert_client('John','Snow');
call insert_client('Ned','Stark');
call insert_client('Robb','Stark');
call insert_client('Tyrion','Lannister');
select * from client;

call search_client_by_id(2);
call update_client_by_id(2, 'toto', 'tata');
select * from client;

call delete_client_by_name('toto', 'tata');
select * from client;
