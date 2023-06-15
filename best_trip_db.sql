-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Lun 12 Juin 2023 à 15:53
-- Version du serveur :  5.6.16
-- Version de PHP :  5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `best_trip_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `accounts`
--

CREATE TABLE IF NOT EXISTS `accounts` (
  `id_account` bigint(20) NOT NULL AUTO_INCREMENT,
  `e_mail` varchar(255) DEFAULT NULL,
  `image_account` tinyblob,
  `number_of_exepriences_shared` int(11) NOT NULL,
  `number_of_guide_contributions` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `profile_name` varchar(255) DEFAULT NULL,
  `sub` bit(1) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_account`),
  UNIQUE KEY `UK_k8h1bgqoplx0rkngj01pm1rgp` (`username`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `accounts`
--

INSERT INTO `accounts` (`id_account`, `e_mail`, `image_account`, `number_of_exepriences_shared`, `number_of_guide_contributions`, `password`, `profile_name`, `sub`, `username`) VALUES
(1, 'cedric.rahbari@gmail.com', NULL, 0, 0, '$2y$10$aHR7iKvU3lwYDOZ2mWdJNuEUuqfzBIt59JmfJvItJL0gpJgxxbete', 'malorf', b'1', 'admin'),
(2, 'juliette.delrieu30@gmail.com', NULL, 0, 0, '$2y$10$lpBFKGEWk9F0BaKhStozf.m5TQCl6wIC6Spd7LRU02/Ma6G.1gOB.', 'juliette', b'1', 'juliette'),
(3, 'juliette.user@gmail.com', NULL, 0, 0, '$2y$10$JLehpCGWuQVGlFCITfGLYunLKcENIgSPqT0k9Zn8Rl6SKndOrIwwK', 'user1', b'1', 'user1'),
(4, 'victoriamilie@outlook.fr', NULL, 0, 0, '$2y$10$1zC4am70mFxwMowDSd5E8.6/S2WfsHhergG1.xvHAgdyKplAR4WGO', 'vivihrk', b'1', 'vivihrk'),
(5, 'wendy.bignon@loutlook.fr', NULL, 0, 0, '$2y$10$eKCC5eOfRJ78Gc9yaVSy2.UfIXbakvAiK2AwQRGgeO1YUZbTKpvx6', 'wendy', b'0', 'wendy'),
(6, 'dydy291@live.fr', NULL, 0, 0, '$2y$10$pTQ9fsZ4ybT2VSsgVYo1c.X0XNl0XD1ZKopNCryaPVHmHmePixVGm', 'dydy', b'0', 'dydy');

-- --------------------------------------------------------

--
-- Structure de la table `experiences`
--

CREATE TABLE IF NOT EXISTS `experiences` (
  `id_experience` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `image_exp` tinyblob,
  `status_exp` int(11) DEFAULT NULL,
  `update_exp` date DEFAULT NULL,
  `url_travel_guide` varchar(255) DEFAULT NULL,
  `video_exp` varchar(255) DEFAULT NULL,
  `id_account` bigint(20) DEFAULT NULL,
  `url_video_exp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_experience`),
  KEY `FKb3f01ujjx41k68v6eaieirorv` (`id_account`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `experiences`
--

INSERT INTO `experiences` (`id_experience`, `description`, `image_exp`, `status_exp`, `update_exp`, `url_travel_guide`, `video_exp`, `id_account`, `url_video_exp`) VALUES
(1, 'Japon en famille', NULL, 0, '2023-06-11', NULL, NULL, 2, NULL),
(2, 'Malte entre amis', NULL, 1, '2023-06-05', NULL, NULL, 3, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `newsletters`
--

CREATE TABLE IF NOT EXISTS `newsletters` (
  `id_newsletter` bigint(20) NOT NULL AUTO_INCREMENT,
  `favorite_trip_of_the_month` varchar(255) DEFAULT NULL,
  `image_newsletter` tinyblob,
  `publication_date` date DEFAULT NULL,
  `id_account` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_newsletter`),
  KEY `FKgndquseebfqwfn52hpmacbuqp` (`id_account`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `newsletters`
--

INSERT INTO `newsletters` (`id_newsletter`, `favorite_trip_of_the_month`, `image_newsletter`, `publication_date`, `id_account`) VALUES
(1, NULL, NULL, '2023-06-01', 4),
(2, NULL, NULL, '2023-05-01', 5);

-- --------------------------------------------------------

--
-- Structure de la table `places`
--

CREATE TABLE IF NOT EXISTS `places` (
  `dtype` varchar(31) NOT NULL,
  `id_place` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `postal_code` bigint(20) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `place_cost` float DEFAULT NULL,
  `place_name` varchar(255) DEFAULT NULL,
  `place_rating` float DEFAULT NULL,
  `free` bit(1) DEFAULT NULL,
  `stars` int(11) DEFAULT NULL,
  `take_away` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_place`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `places`
--

INSERT INTO `places` (`dtype`, `id_place`, `city`, `postal_code`, `street`, `place_cost`, `place_name`, `place_rating`, `free`, `stars`, `take_away`) VALUES
('Restaurant', 1, 'Paris', 75000, 'rue rivoli', 32, 'Pizza Paille', 4.6, NULL, NULL, b'0'),
('Restaurant', 2, 'Rome', 85669, 'Trevi Street', 50, 'Popolinni', 4.6, NULL, NULL, b'0'),
('Hotel', 3, 'Phuket', 44447, 'Sea Street', 5215, 'Paradise Island', 4.7, NULL, 4, NULL),
('Activity', 4, 'Roma', 45333, 'Vatican Street', 17, 'Vatican', 3.3, b'0', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `profils`
--

CREATE TABLE IF NOT EXISTS `profils` (
  `id_user` bigint(20) NOT NULL,
  `id_role` bigint(20) NOT NULL,
  PRIMARY KEY (`id_user`,`id_role`),
  KEY `FKo4k9qlonb0dlx6hrc0mjna7kg` (`id_role`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `profils`
--

INSERT INTO `profils` (`id_user`, `id_role`) VALUES
(1, 2),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1);

-- --------------------------------------------------------

--
-- Structure de la table `reviews`
--

CREATE TABLE IF NOT EXISTS `reviews` (
  `id_review` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `review_object_id` bigint(20) DEFAULT NULL,
  `review_object_type` int(11) DEFAULT NULL,
  `user_rating` float NOT NULL,
  `id_account` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_review`),
  KEY `FKfgwo8nfc53i9vf7ffh53s21ue` (`id_account`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `reviews`
--

INSERT INTO `reviews` (`id_review`, `comment`, `review_object_id`, `review_object_type`, `user_rating`, `id_account`) VALUES
(1, 'C''était top', 1, 1, 3.6, 1),
(2, 'Beaucoup trop de monde', 4, 1, 3.4, 2);

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `id_role` bigint(20) NOT NULL AUTO_INCREMENT,
  `name_role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `roles`
--

INSERT INTO `roles` (`id_role`, `name_role`) VALUES
(1, 'user'),
(2, 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `transports`
--

CREATE TABLE IF NOT EXISTS `transports` (
  `type` varchar(31) NOT NULL,
  `id_transport` bigint(20) NOT NULL AUTO_INCREMENT,
  `name_company` varchar(255) DEFAULT NULL,
  `time_travel` float DEFAULT NULL,
  `transport_cost` float DEFAULT NULL,
  `transport_rating` float DEFAULT NULL,
  `airplane_class` varchar(255) DEFAULT NULL,
  `boat_class` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_transport`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `transports`
--

INSERT INTO `transports` (`type`, `id_transport`, `name_company`, `time_travel`, `transport_cost`, `transport_rating`, `airplane_class`, `boat_class`) VALUES
('AirTransport', 1, 'Air France', 10, 450, 3, 'business', NULL),
('MaritimeTransport', 2, 'Corsika', 12, 120, 5, NULL, 2),
('AirTransport', 3, 'KLM', 11, 300, 3, 'Eco', NULL),
('MaritimeTransport', 4, 'Betico', 13, 50.5, 4, NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `travelguides`
--

CREATE TABLE IF NOT EXISTS `travelguides` (
  `id_travel_guide` bigint(20) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(255) DEFAULT NULL,
  `global_rating` float NOT NULL,
  `guide_name` varchar(255) DEFAULT NULL,
  `status_travel_guide` int(11) DEFAULT NULL,
  `total_cost` float NOT NULL,
  `update_travel_guide` date DEFAULT NULL,
  `id_account` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_travel_guide`),
  KEY `FKbt61avt9dt723j78xag0c6slq` (`id_account`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `travelguides`
--

INSERT INTO `travelguides` (`id_travel_guide`, `country_name`, `global_rating`, `guide_name`, `status_travel_guide`, `total_cost`, `update_travel_guide`, `id_account`) VALUES
(1, 'Thaïlande', 4.5, 'Go to Thaïlande', 1, 2600, '2023-06-23', 2),
(2, 'Italie', 4.1, 'Welcome to Roma', 0, 1300, '2023-06-30', 3),
(3, 'France', 5, 'Tour de France', 0, 500.6, '2023-06-28', 1),
(4, 'Nouvelle Calédonie', 4.6, 'Bienvenue en Nouvelle Calédonie', 1, 1230, '2023-06-07', 2),
(5, 'Hawaï', 4.8, 'Aloha', 0, 2854, '2023-05-10', 5),
(6, 'Tahiti', 4.8, 'Iaorana', 2, 3345, '2023-06-06', 6);

-- --------------------------------------------------------

--
-- Structure de la table `travel_guides_places`
--

CREATE TABLE IF NOT EXISTS `travel_guides_places` (
  `travel_guide_id` bigint(20) NOT NULL,
  `place_id` bigint(20) NOT NULL,
  KEY `FKc07sgfx4v4j92qqd9v03rflk3` (`place_id`),
  KEY `FKdx5st0dxq6238gmk5mbh1255r` (`travel_guide_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `travel_guides_places`
--

INSERT INTO `travel_guides_places` (`travel_guide_id`, `place_id`) VALUES
(1, 3),
(2, 4),
(2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `travel_guides_transports`
--

CREATE TABLE IF NOT EXISTS `travel_guides_transports` (
  `travel_guide_id` bigint(20) NOT NULL,
  `transport_id` bigint(20) NOT NULL,
  KEY `FKi2iphruw8eovv9s9ecc34tnyo` (`transport_id`),
  KEY `FKnjetgrl7e2ghscx0xsqarihqk` (`travel_guide_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `travel_guides_transports`
--

INSERT INTO `travel_guides_transports` (`travel_guide_id`, `transport_id`) VALUES
(1, 1),
(2, 1),
(4, 3),
(2, 2),
(4, 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
