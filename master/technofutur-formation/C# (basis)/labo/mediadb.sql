-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Sam 26 Juillet 2014 à 17:09
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `mediadb`
--
CREATE DATABASE IF NOT EXISTS `mediadb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `mediadb`;

-- --------------------------------------------------------

--
-- Structure de la table `albums`
--

CREATE TABLE IF NOT EXISTS `albums` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` mediumtext,
  `released` date NOT NULL,
  `artiste_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `artiste_id` (`artiste_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `albums`
--

INSERT INTO `albums` (`id`, `name`, `description`, `released`, `artiste_id`) VALUES
(4, 'Lorem Ipsum et lesJacksums 1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.', '1999-01-01', 2),
(5, 'Lorem Ipsum et lesJacksums 2', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.', '1999-01-01', 2),
(6, 'Lorem Ipsum et lesJacksums 3', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.', '1999-01-01', 2),
(7, 'Lorem Ipsum et les Ipsums 1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ac elementum lorem. Interdum et malesuada fames ac ante ipsum primis in faucibus. Fusce nec dui id nunc mollis pharetra. Proin id rutrum lorem, ut vulputate erat. Quisque condimentum id lorem a fermentum. Pellentesque sit amet velit eget leo dapibus euismod. Sed leo elit, dictum vitae faucibus sit amet, euismod eget mauris.', '0089-01-01', 3),
(8, 'Lorem Ipsum et les Ipsums 2', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ac elementum lorem. Interdum et malesuada fames ac ante ipsum primis in faucibus. Fusce nec dui id nunc mollis pharetra. Proin id rutrum lorem, ut vulputate erat. Quisque condimentum id lorem a fermentum. Pellentesque sit amet velit eget leo dapibus euismod. Sed leo elit, dictum vitae faucibus sit amet, euismod eget mauris.', '0089-01-01', 3),
(9, 'Lorem Ipsum et les Ipsums 3', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ac elementum lorem. Interdum et malesuada fames ac ante ipsum primis in faucibus. Fusce nec dui id nunc mollis pharetra. Proin id rutrum lorem, ut vulputate erat. Quisque condimentum id lorem a fermentum. Pellentesque sit amet velit eget leo dapibus euismod. Sed leo elit, dictum vitae faucibus sit amet, euismod eget mauris.', '0089-01-01', 3),
(10, 'Lorem Ipsum et les Ipsums 4', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ac elementum lorem. Interdum et malesuada fames ac ante ipsum primis in faucibus. Fusce nec dui id nunc mollis pharetra. Proin id rutrum lorem, ut vulputate erat. Quisque condimentum id lorem a fermentum. Pellentesque sit amet velit eget leo dapibus euismod. Sed leo elit, dictum vitae faucibus sit amet, euismod eget mauris.', '0089-01-01', 3),
(11, 'Lorem Ipsum et les Lorems 1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ac elementum lorem. Interdum et malesuada fames ac ante ipsum primis in faucibus. Fusce nec dui id nunc mollis pharetra. Proin id rutrum lorem, ut vulputate erat. Quisque condimentum id lorem a fermentum. Pellentesque sit amet velit eget leo dapibus euismod. Sed leo elit, dictum vitae faucibus sit amet, euismod eget mauris.', '0099-01-01', 4),
(12, 'Lorem Ipsum et les Lorems 2', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ac elementum lorem. Interdum et malesuada fames ac ante ipsum primis in faucibus. Fusce nec dui id nunc mollis pharetra. Proin id rutrum lorem, ut vulputate erat. Quisque condimentum id lorem a fermentum. Pellentesque sit amet velit eget leo dapibus euismod. Sed leo elit, dictum vitae faucibus sit amet, euismod eget mauris.', '0099-01-01', 4),
(13, 'Lorem Ipsum et les Lorems 3', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ac elementum lorem. Interdum et malesuada fames ac ante ipsum primis in faucibus. Fusce nec dui id nunc mollis pharetra. Proin id rutrum lorem, ut vulputate erat. Quisque condimentum id lorem a fermentum. Pellentesque sit amet velit eget leo dapibus euismod. Sed leo elit, dictum vitae faucibus sit amet, euismod eget mauris.', '1999-01-01', 4);

-- --------------------------------------------------------

--
-- Structure de la table `albums_categories`
--

CREATE TABLE IF NOT EXISTS `albums_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `albums_categories`
--

INSERT INTO `albums_categories` (`id`, `name`, `description`) VALUES
(1, 'Jazz', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.'),
(2, 'Hip hop', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.'),
(3, 'Rap', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.'),
(4, 'Heavy metal', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.'),
(5, 'Pop', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.');

-- --------------------------------------------------------

--
-- Structure de la table `album_cats`
--

CREATE TABLE IF NOT EXISTS `album_cats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `album_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `album_id` (`album_id`),
  KEY `category_id` (`category_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `album_cats`
--

INSERT INTO `album_cats` (`id`, `album_id`, `category_id`) VALUES
(4, 4, 5),
(5, 5, 5),
(6, 6, 2),
(7, 7, 5),
(8, 8, 5),
(9, 9, 5),
(10, 10, 5),
(11, 11, 1),
(12, 12, 1),
(13, 13, 1);

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

CREATE TABLE IF NOT EXISTS `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `resume` mediumtext,
  `url` mediumtext NOT NULL,
  `artiste_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `artiste_id` (`artiste_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `artistes`
--

CREATE TABLE IF NOT EXISTS `artistes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `birthdate` date NOT NULL,
  `birthplace` varchar(255) NOT NULL,
  `biography` mediumtext,
  `website` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Contenu de la table `artistes`
--

INSERT INTO `artistes` (`id`, `firstname`, `lastname`, `nickname`, `birthdate`, `birthplace`, `biography`, `website`, `image`, `nationality`) VALUES
(2, 'Lorem', 'Ipsum', 'Lorem Ipsum 2', '1977-01-01', 'Brussels', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.<br />\r\n<br />\r\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.', 'http://loremipsum.tld', NULL, 'Belgian'),
(3, 'Lorem', 'Ipsum', 'Lorem Ipsum 3', '1977-01-01', 'Brussels', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.<br />\r\n<br />\r\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.', 'http://loremipsum.tld', NULL, 'Belgian'),
(4, 'Lorem', 'Ipsum', 'Lorem Ipsum 4', '1977-01-01', 'Brussels', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.<br />\r\n<br />\r\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.', 'http://loremipsum.tld', NULL, 'Belgian'),
(5, 'Lorem', 'Ipsum', 'Lorem Ipsum 5', '1977-01-01', 'Brussels', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.<br />\r\n<br />\r\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.', 'http://loremipsum.tld', NULL, 'Belgian'),
(6, 'Lorem', 'Ipsum', 'Lorem Ipsum 6', '1977-01-01', 'Brussels', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.<br />\r\n<br />\r\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.', 'http://loremipsum.tld', NULL, 'Belgian'),
(7, 'Lorem', 'Ipsum', 'Lorem Ipsum 7', '1977-01-01', 'Brussels', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.<br />\r\n<br />\r\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.', 'http://loremipsum.tld', NULL, 'Belgian'),
(8, 'Lorem', 'Ipsum', 'Lorem Ipsum 8', '1977-01-01', 'Brussels', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.<br />\r\n<br />\r\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.', 'http://loremipsum.tld', NULL, 'Belgian'),
(9, 'Lorem', 'Ipsum', 'Lorem Ipsum 9', '1977-01-01', 'Brussels', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.<br />\r\n<br />\r\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.', 'http://loremipsum.tld', NULL, 'Belgian'),
(10, 'Lorem', 'Ipsum', 'Lorem Ipsum 10', '1977-01-01', 'Brussels', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.<br />\r\n<br />\r\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.', 'http://loremipsum.tld', NULL, 'Belgian');

-- --------------------------------------------------------

--
-- Structure de la table `artiste_cats`
--

CREATE TABLE IF NOT EXISTS `artiste_cats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `artiste_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `artiste_id` (`artiste_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Contenu de la table `artiste_cats`
--

INSERT INTO `artiste_cats` (`id`, `category_id`, `artiste_id`) VALUES
(2, 1, 2),
(3, 2, 3),
(4, 2, 4),
(5, 2, 5),
(6, 1, 6),
(7, 1, 7),
(8, 3, 8),
(9, 4, 9),
(10, 5, 10);

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `categories`
--

INSERT INTO `categories` (`id`, `name`, `description`) VALUES
(1, 'Hip hop', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.'),
(2, 'Jazz', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.'),
(3, 'Rap', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.'),
(4, 'Pop', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.'),
(5, 'Heavy metal', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tristique libero quis justo pulvinar, ut tempus justo iaculis. Quisque et dolor a tellus tempor bibendum. Sed egestas lectus et ligula mattis commodo. Pellentesque vitae turpis vel quam elementum sodales eget eu sapien. Cras non pharetra justo. Duis lectus lectus, euismod ac gravida sed, sagittis et libero. Nunc vel lacinia risus, vitae fringilla odio. Mauris interdum metus eu lectus volutpat porttitor. Aliquam tempus tincidunt aliquam. Nulla dignissim libero ac est laoreet, et euismod erat rhoncus. Nam non fringilla felis. Proin iaculis lectus at viverra lobortis. Phasellus laoreet nunc sed quam egestas vulputate. Integer faucibus a tellus in molestie. Integer feugiat erat neque, luctus fermentum velit interdum et. Nullam quis tortor quis diam consectetur aliquam.');

-- --------------------------------------------------------

--
-- Structure de la table `rewards`
--

CREATE TABLE IF NOT EXISTS `rewards` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` mediumtext,
  `obtained` date NOT NULL,
  `artiste_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `artiste_id` (`artiste_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `albums`
--
ALTER TABLE `albums`
  ADD CONSTRAINT `albums_ibfk_1` FOREIGN KEY (`artiste_id`) REFERENCES `artistes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `album_cats`
--
ALTER TABLE `album_cats`
  ADD CONSTRAINT `album_cats_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `albums_categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `album_cats_ibfk_1` FOREIGN KEY (`album_id`) REFERENCES `albums` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `articles`
--
ALTER TABLE `articles`
  ADD CONSTRAINT `articles_ibfk_1` FOREIGN KEY (`artiste_id`) REFERENCES `artistes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `artiste_cats`
--
ALTER TABLE `artiste_cats`
  ADD CONSTRAINT `artiste_cats_ibfk_2` FOREIGN KEY (`artiste_id`) REFERENCES `artistes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `artiste_cats_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `rewards`
--
ALTER TABLE `rewards`
  ADD CONSTRAINT `rewards_ibfk_1` FOREIGN KEY (`artiste_id`) REFERENCES `artistes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
