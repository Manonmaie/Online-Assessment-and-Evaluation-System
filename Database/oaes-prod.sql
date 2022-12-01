-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 13, 2014 at 02:07 PM
-- Server version: 5.5.37
-- PHP Version: 5.4.30-2+deb.sury.org~precise+1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `oaes-prod`
--

-- --------------------------------------------------------

--
-- Table structure for table `ai_item`
--

CREATE TABLE IF NOT EXISTS `ai_item` (
  `ai_item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ai_master_id` int(10) unsigned NOT NULL,
  `oaes_item_id` int(10) unsigned NOT NULL,
  `section` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ai_item_id`),
  KEY `ai_item_ai_master_id_foreign` (`ai_master_id`),
  KEY `ai_item_oaes_item_id_foreign` (`oaes_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `ai_master`
--

CREATE TABLE IF NOT EXISTS `ai_master` (
  `ai_master_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ap_master_id` int(10) unsigned NOT NULL,
  `ai_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ai_desc` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `item_order` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ai_master_id`),
  KEY `ai_master_ap_master_id_foreign` (`ap_master_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `ai_question_paper`
--

CREATE TABLE IF NOT EXISTS `ai_question_paper` (
  `ai_question_paper_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ap_view_list_id` int(10) unsigned NOT NULL,
  `item_ids` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  `que_name` varchar(250) NOT NULL,
  `que_subject` varchar(250) NOT NULL,
  `assment_title` varchar(250) NOT NULL,
  PRIMARY KEY (`ai_question_paper_id`),
  KEY `ap_view_list_id` (`ap_view_list_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=205 ;

--
-- Dumping data for table `ai_question_paper`
--

INSERT INTO `ai_question_paper` (`ai_question_paper_id`, `ap_view_list_id`, `item_ids`, `created_at`, `updated_at`, `que_name`, `que_subject`, `assment_title`) VALUES
(181, 44, '["48","83","60","124","47","125","59","178","203","86","61","62","148","127","176","63","102","65","114","68","75","76","105","67","78","118","90","69","70","81","79"]', '2014-10-30 07:16:45', '2014-10-30 07:16:45', 'test aiii', 'IT TOOLS & BUSINESS SYSTEMS', 'testap'),
(182, 44, '["110","94","140","133","182","48","83","85","124","47","125","59","166","177","86","61","62","148","127","176","63","102","65","74","66","75","76","105","67","78","118","69","90","81","70","121","79","45","57","45","57","242","253"]', '2014-11-03 04:29:54', '2014-11-03 04:29:54', 'juhjhjhjh', 'IT TOOLS & BUSINESS SYSTEMS', 'testap'),
(183, 44, '["59","60","63"]', '2014-10-30 06:43:36', '2014-10-30 06:43:36', 'sdtttttttttt', 'IT TOOLS & BUSINESS SYSTEMS', 'testap'),
(184, 44, '["145","133","182","48","83","60","124","47","125","97","98","203","86","61","168","148","127","176","63","102","65","77","66","75","76","105","67","118","78","69","90","81","70","79","121"]', '2014-10-20 11:59:43', '2014-10-20 11:59:43', 'que paper1', 'IT TOOLS & BUSINESS SYSTEMS', 'testap'),
(185, 44, '["180","110","94","140","133","149","48","83","85","144","47","97","169","203","86","61","62","148","127","176","63","102","65","77","68","75","76","105","67","118","78","69","90","81","70","121","79","45","57","236"]', '2014-10-28 08:23:30', '2014-10-28 08:23:30', 'que31', 'IT TOOLS & BUSINESS SYSTEMS', 'testap'),
(186, 44, '["180","82","94","140","133","149","48","83","85","84","47","125","97","179","203","86","61","62","148","127","176","63","102","65","74","66","75","76","105","67","118","78","69","90","70","81","121","79"]', '2014-10-21 04:32:31', '2014-10-21 04:32:31', 'rhhjghghgh', 'IT TOOLS & BUSINESS SYSTEMS', 'testap'),
(187, 44, '["58","48","83","60","124","47","125","59","166","203","86","61","168","148","127","176","63","102","65","74","66","75","76","105","67","78","118","90","69","70","81","79","121"]', '2014-10-21 05:41:58', '2014-10-21 05:41:58', 'ghghfg', 'IT TOOLS & BUSINESS SYSTEMS', 'testap'),
(188, 44, '["171","157","180","57","94","140","133","58","48","83","161","84","47","125","97","167","177","86","61","62","148","127","176","63","102","65","77","66","75","76","105","67","78","118","69","90","70","81","121","79"]', '2014-10-21 06:22:30', '2014-10-21 06:22:30', 'gnhnjhjh', 'IT TOOLS & BUSINESS SYSTEMS', 'testap'),
(189, 45, '["102","68"]', '2014-10-23 04:51:42', '2014-10-23 04:51:42', 'hhgghgh', 'IT TOOLS & BUSINESS SYSTEMS', '40Quepat'),
(190, 44, '["122","158","180","82","94","140","133","149","48","83","60","124","47","125","97","202","203","86","61","168","148","127","176","63","102","65","77","68","75","76","105","67","118","78","69","90","81","70","79","121","45"]', '2014-10-28 09:02:21', '2014-10-28 09:02:21', 'fhhh', 'IT TOOLS & BUSINESS SYSTEMS', 'testap'),
(191, 44, '["160","180","110","94","140","133","182","48","83","85","124","47","125","59","167","203","86","61","62","148","208","127","176","63","102","65","77","66","75","76","105","67","78","118","69","90","81","70","121","79"]', '2014-10-27 04:08:50', '2014-10-27 04:08:50', 'quei', 'IT TOOLS & BUSINESS SYSTEMS', 'testap'),
(192, 44, '["181","160","180","110","94","140","133","182","48","83","85","124","47","125","97","179","203","86","61","62","148","208","127","176","63","102","65","114","68","75","76","105","67","78","118","69","90","81","70","121","79"]', '2014-10-27 05:51:09', '2014-10-27 05:51:09', 'fgtfgfg', 'IT TOOLS & BUSINESS SYSTEMS', 'testap'),
(193, 44, '["122","160","180","82","94","140","133","182","48","83","60","84","47","125","97","166","203","86","61","168","148","208","127","176","63","102","65","114","103","75","76","105","67","78","118","69","90","70","81","121","79"]', '2014-10-27 07:19:16', '2014-10-27 07:19:16', 'khhkk', 'IT TOOLS & BUSINESS SYSTEMS', 'testap'),
(194, 44, '["162","145","180","82","94","140","133","149","48","83","161","84","47","125","97","167","203","86","61","168","148","208","127","176","63","102","209","114","68","75","76","105","67","118","78","90","69","70","81","79","121"]', '2014-10-27 07:33:01', '2014-10-27 07:33:01', 'oooko', 'IT TOOLS & BUSINESS SYSTEMS', 'testap'),
(195, 45, '["162","158","180","110","94","140","133","106","177","86","61","62","102","68","70","79"]', '2014-10-27 07:37:03', '2014-10-27 07:37:03', 'gghhggh', 'IT TOOLS & BUSINESS SYSTEMS', '40Quepat'),
(196, 46, '["181","145","180","179","203","103","81","121"]', '2014-10-27 08:15:16', '2014-10-27 08:15:16', 'tyui', 'IT TOOLS & BUSINESS SYSTEMS', 'new pattern1'),
(197, 44, '["210","160","180","110","94","140","133","149","48","83","60","144","47","125","97","211","177","86","61","233","148","208","127","176","63","102","209","77","103","75","76","105","67","118","78","90","69","70","81","121","79"]', '2014-10-28 04:44:12', '2014-10-28 04:44:12', 'gghghghgh', 'IT TOOLS & BUSINESS SYSTEMS', 'testap'),
(198, 46, '["147","145","180","169","203","68","70","79"]', '2014-10-28 05:10:01', '2014-10-28 05:10:01', 'hjjolhjkjjhj', 'IT TOOLS & BUSINESS SYSTEMS', 'new pattern1'),
(199, 46, '["45","57","45","45","47","48","57","58","59","45","45","47","59","58","60","45"]', '2014-10-28 07:22:54', '2014-10-28 07:22:54', 'hfgfgfgfg', 'IT TOOLS & BUSINESS SYSTEMS', 'new pattern1'),
(200, 45, '["171","145","180","57","94","140","133","166","177","86","61","236","102","68","75","79","238","236","234"]', '2014-10-30 07:07:22', '2014-10-30 07:07:22', 'jkjkjkjk', 'IT TOOLS & BUSINESS SYSTEMS', '40Quepat'),
(201, 45, '["171","145","180","57","94","140","133","166","177","86","61","236","102","68","75","81","79"]', '2014-10-28 08:52:07', '2014-10-28 08:52:07', 'jkjkjkjk', 'IT TOOLS & BUSINESS SYSTEMS', '40Quepat'),
(202, 45, '["171","145","180","57","94","140","133","166","177","86","61","236","102","68","75","81","79","236","240","235","234","61","242"]', '2014-10-30 06:45:40', '2014-10-30 06:45:40', 'jkjkjkjk', 'IT TOOLS & BUSINESS SYSTEMS', '40Quepat'),
(203, 44, '["84","47","125","97","178","203","86","61","168","148","208","127","176","63","102","65","74","66","75","76","105","67","118","78","90","69","81","70","79","121","238","61","237"]', '2014-10-28 09:35:39', '2014-10-28 09:35:39', 'noone', 'IT TOOLS & BUSINESS SYSTEMS', 'testap'),
(204, 47, '["145","180","110","94","140","133","211","203","86","61","168","241","103","75","70","81","79","242"]', '2014-10-30 11:07:43', '2014-10-30 11:07:43', 'Qp Example', 'IT TOOLS & BUSINESS SYSTEMS', 'Ap Example');

-- --------------------------------------------------------

--
-- Table structure for table `ap_item_mark`
--

CREATE TABLE IF NOT EXISTS `ap_item_mark` (
  `ap_item_mark_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mark_desc` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mark` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ap_item_mark_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `ap_master`
--

CREATE TABLE IF NOT EXISTS `ap_master` (
  `ap_master_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ap_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ap_desc` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ap_master_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `ap_master`
--

INSERT INTO `ap_master` (`ap_master_id`, `ap_name`, `ap_desc`, `status`, `created_at`, `updated_at`) VALUES
(1, 'assessment pattern1', 'assessment pattern1', '', '0000-00-00 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `ap_topic`
--

CREATE TABLE IF NOT EXISTS `ap_topic` (
  `ap_topic_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `topic_desc` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `oaes_subject_id` int(10) unsigned NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ap_topic_id`),
  KEY `ap_topic_oaes_subject_id_foreign` (`oaes_subject_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=59 ;

--
-- Dumping data for table `ap_topic`
--

INSERT INTO `ap_topic` (`ap_topic_id`, `topic_desc`, `oaes_subject_id`, `created_at`, `updated_at`) VALUES
(3, '1', 1, '0000-00-00 00:00:00', '2014-09-08 04:47:56'),
(4, '2', 1, '0000-00-00 00:00:00', '2014-09-08 04:47:56'),
(11, '3', 1, '0000-00-00 00:00:00', '2014-09-08 04:47:56'),
(12, '4', 1, '0000-00-00 00:00:00', '2014-09-08 04:47:56'),
(13, '5', 1, '0000-00-00 00:00:00', '2014-09-08 04:47:56'),
(14, '6', 1, '0000-00-00 00:00:00', NULL),
(17, '7', 1, '0000-00-00 00:00:00', NULL),
(18, '8', 1, '0000-00-00 00:00:00', NULL),
(19, '9', 1, '0000-00-00 00:00:00', NULL),
(20, '10', 1, '0000-00-00 00:00:00', NULL),
(21, '11', 1, '0000-00-00 00:00:00', NULL),
(22, '12', 1, '0000-00-00 00:00:00', NULL),
(23, '13', 1, '0000-00-00 00:00:00', NULL),
(24, '14', 1, '0000-00-00 00:00:00', NULL),
(25, '15', 1, '0000-00-00 00:00:00', NULL),
(26, '16', 1, '0000-00-00 00:00:00', NULL),
(27, '1', 2, '0000-00-00 00:00:00', NULL),
(28, '2', 2, '0000-00-00 00:00:00', NULL),
(29, '3', 2, '0000-00-00 00:00:00', NULL),
(30, '4', 2, '0000-00-00 00:00:00', NULL),
(31, '5', 2, '0000-00-00 00:00:00', NULL),
(32, '6', 2, '0000-00-00 00:00:00', NULL),
(33, '7', 2, '0000-00-00 00:00:00', NULL),
(34, '8', 2, '0000-00-00 00:00:00', NULL),
(35, '9', 2, '0000-00-00 00:00:00', NULL),
(36, '10', 2, '0000-00-00 00:00:00', NULL),
(37, '11', 2, '0000-00-00 00:00:00', NULL),
(38, '12', 2, '0000-00-00 00:00:00', NULL),
(39, '13', 2, '0000-00-00 00:00:00', NULL),
(40, '14', 2, '0000-00-00 00:00:00', NULL),
(42, '1', 3, '0000-00-00 00:00:00', NULL),
(43, '2', 3, '0000-00-00 00:00:00', NULL),
(44, '3', 3, '0000-00-00 00:00:00', NULL),
(45, '4', 3, '0000-00-00 00:00:00', NULL),
(46, '5', 3, '0000-00-00 00:00:00', NULL),
(47, '6', 3, '0000-00-00 00:00:00', NULL),
(48, '7', 3, '0000-00-00 00:00:00', NULL),
(49, '8', 3, '0000-00-00 00:00:00', NULL),
(50, '9', 3, '0000-00-00 00:00:00', NULL),
(51, '10', 3, '0000-00-00 00:00:00', NULL),
(52, '11', 3, '0000-00-00 00:00:00', NULL),
(53, '12', 3, '0000-00-00 00:00:00', NULL),
(54, '13', 3, '0000-00-00 00:00:00', NULL),
(55, '14', 3, '0000-00-00 00:00:00', NULL),
(56, '15', 3, '0000-00-00 00:00:00', NULL),
(57, '16', 3, '0000-00-00 00:00:00', NULL),
(58, '17', 3, '0000-00-00 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `ap_topic_detail`
--

CREATE TABLE IF NOT EXISTS `ap_topic_detail` (
  `ap_topic_detail_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mark` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `num_of_item` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `section` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ap_topic_id` int(10) unsigned NOT NULL,
  `ap_item_mark_id` int(10) unsigned NOT NULL,
  `oaes_cognitive_category_id` int(10) unsigned NOT NULL,
  `oaes_item_type_id` int(10) unsigned NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ap_topic_detail_id`),
  KEY `ap_topic_detail_ap_topic_id_foreign` (`ap_topic_id`),
  KEY `ap_topic_detail_ap_item_mark_id_foreign` (`ap_item_mark_id`),
  KEY `ap_topic_detail_oaes_cognitive_category_id_foreign` (`oaes_cognitive_category_id`),
  KEY `ap_topic_detail_oaes_item_type_id_foreign` (`oaes_item_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `ap_topic_weight`
--

CREATE TABLE IF NOT EXISTS `ap_topic_weight` (
  `ap_topic_weight_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ap_topic_id` int(10) unsigned NOT NULL,
  `ap_master_id` int(10) unsigned NOT NULL,
  `mark` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ap_topic_weight_id`),
  KEY `ap_topic_weight_ap_topic_id_foreign` (`ap_topic_id`),
  KEY `ap_topic_weight_ap_master_id_foreign` (`ap_master_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

-- --------------------------------------------------------

--
-- Table structure for table `ap_unitofstudy`
--

CREATE TABLE IF NOT EXISTS `ap_unitofstudy` (
  `ap_unitofstudy_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `unitofstudy_name` varchar(500) NOT NULL,
  `ap_topic_id` int(10) unsigned NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ap_unitofstudy_id`),
  KEY `ap_topic_id` (`ap_topic_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `ap_unitofstudy`
--

INSERT INTO `ap_unitofstudy` (`ap_unitofstudy_id`, `unitofstudy_name`, `ap_topic_id`, `created_at`, `updated_at`) VALUES
(1, 'UnitofStudy1', 4, '2014-11-05 05:41:08', '0000-00-00 00:00:00'),
(2, 'UnitofStudy2', 4, '2014-11-05 05:41:09', '0000-00-00 00:00:00'),
(3, 'UnitofStudy3', 4, '2014-11-05 05:41:09', '0000-00-00 00:00:00'),
(4, 'UnitofStudy4', 4, '2014-11-05 05:41:09', '0000-00-00 00:00:00'),
(5, 'UnitofStudy5', 3, '2014-11-05 05:41:09', '0000-00-00 00:00:00'),
(6, 'UnitofStudy6', 3, '2014-11-05 05:41:09', '0000-00-00 00:00:00'),
(7, 'UnitofStudy7', 3, '2014-11-05 05:41:09', '0000-00-00 00:00:00'),
(8, 'UnitofStudy8', 3, '2014-11-05 05:41:09', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `ap_view_list`
--

CREATE TABLE IF NOT EXISTS `ap_view_list` (
  `ap_view_list_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` longtext COLLATE utf8_unicode_ci NOT NULL,
  `oaes_subject_id` int(10) unsigned NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  `ap_value` longtext COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ap_view_list_id`),
  KEY `ap_view_list_oaes_subject_id_foreign` (`oaes_subject_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=48 ;

--
-- Dumping data for table `ap_view_list`
--

INSERT INTO `ap_view_list` (`ap_view_list_id`, `description`, `oaes_subject_id`, `created_at`, `updated_at`, `ap_value`) VALUES
(44, 'testap', 1, '2014-10-20 09:08:25', '2014-10-20 09:08:25', '[[[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1]],[[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1]],[[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1]],[[3,3,2,2,2],[3,3,2,2,2],[3,3,5,5,5]]]'),
(45, '40Quepat', 1, '2014-10-21 08:58:04', '2014-10-21 08:58:04', '[[[1,1,1,1,1],[1,1,0,0,0],[0,0,0,0,0]],[[1,1,1,1,1],[1,1,0,0,0],[0,0,0,0,0]],[[1,1,0,0,0],[1,1,1,1,1],[0,0,0,0,0]],[[0,0,0,0,0],[2,2,1,1,1],[4,4,0,0,4]]]'),
(46, 'new pattern1', 1, '2014-10-27 07:42:00', '2014-10-27 07:42:00', '[[[1,1,1,0,0],[0,0,0,0,0],[0,0,0,0,0]],[[1,1,1,0,0],[0,0,0,0,0],[0,0,0,0,0]],[[0,0,0,0,0],[1,1,1,0,0],[0,0,0,0,0]],[[0,0,0,0,0],[1,1,1,1,1],[0,0,0,3,3]]]'),
(47, 'Ap Example', 1, '2014-10-30 10:57:32', '2014-10-30 10:57:32', '[[[1,1,1,1,1],[1,1,0,0,0],[0,0,0,0,0]],[[1,1,1,1,1],[1,1,0,0,0],[0,0,0,0,0]],[[1,1,0,0,0],[1,1,1,1,1],[0,0,0,0,0]],[[0,0,0,0,0],[1,1,2,2,1],[1,1,3,3,4]]]');

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `permissions` text COLLATE utf8_unicode_ci,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `groups_name_unique` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`id`, `name`, `permissions`, `created_at`, `updated_at`) VALUES
(1, 'Users', '{"users":1,"item.view":1,"item.edit":1,"item.add":1,"item.delete":1}', '2014-08-20 09:04:42', '2014-08-20 09:04:42'),
(2, 'Admins', '{"admin":1,"item.view":1,"item.edit":1,"item.add":1,"item.delete":1}', '2014-08-20 09:04:42', '2014-08-20 09:04:42'),
(3, 'Reviewer', '{"reviewer":1,"item.view":1,"item.edit":1,"item.add":0,"item.delete":1}', '2014-08-20 09:04:42', '2014-08-20 09:04:42');

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE IF NOT EXISTS `migrations` (
  `migration` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`migration`, `batch`) VALUES
('2012_12_06_225921_migration_cartalyst_sentry_install_users', 1),
('2012_12_06_225929_migration_cartalyst_sentry_install_groups', 1),
('2012_12_06_225945_migration_cartalyst_sentry_install_users_groups_pivot', 1),
('2012_12_06_225988_migration_cartalyst_sentry_install_throttle', 1),
('2014_06_09_065102_create_question_table', 1),
('2014_08_20_100000_create_oaes_item_type', 1),
('2014_08_20_100001_create_oaes_subject', 1),
('2014_08_20_100002_create_oaes_cognitive_category', 1),
('2014_08_20_100003_create_oaes_knowledge_category', 1),
('2014_08_20_100004_create_oaes_difficulty', 1),
('2014_08_20_100010_create_oaes_item', 1),
('2014_08_20_100050_create_oaes_mcq', 1),
('2014_08_20_100051_create_oaes_truefalse', 1),
('2014_08_20_100512_create_oaes_fill_ups', 1),
('2014_08_20_100922_create_oaes_mchq', 1),
('2014_08_20_123748_create_oaes_keywords', 1),
('2014_08_20_140930_add_keyword_to_oaes_item', 1),
('2014_09_16_143308_create_ap_view_list', 2),
('2014_09_16_151022_ap_value_to_ap_view_list', 3);

-- --------------------------------------------------------

--
-- Table structure for table `oaes_cognitive_category`
--

CREATE TABLE IF NOT EXISTS `oaes_cognitive_category` (
  `oaes_cognitive_category_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cognitive_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`oaes_cognitive_category_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Dumping data for table `oaes_cognitive_category`
--

INSERT INTO `oaes_cognitive_category` (`oaes_cognitive_category_id`, `cognitive_name`, `created_at`, `updated_at`) VALUES
(1, 'Remember', '0000-00-00 00:00:00', NULL),
(2, 'Understand', '0000-00-00 00:00:00', NULL),
(3, 'Apply', '0000-00-00 00:00:00', NULL),
(4, 'Analyze', '0000-00-00 00:00:00', NULL),
(5, 'Evaluate', '0000-00-00 00:00:00', NULL),
(6, 'Create', '0000-00-00 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `oaes_difficulty`
--

CREATE TABLE IF NOT EXISTS `oaes_difficulty` (
  `oaes_difficulty_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `level` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`oaes_difficulty_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `oaes_difficulty`
--

INSERT INTO `oaes_difficulty` (`oaes_difficulty_id`, `level`, `created_at`, `updated_at`) VALUES
(1, 'DL1', '0000-00-00 00:00:00', NULL),
(2, 'DL2', '0000-00-00 00:00:00', NULL),
(3, 'DL3', '0000-00-00 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `oaes_fill_ups`
--

CREATE TABLE IF NOT EXISTS `oaes_fill_ups` (
  `oaes_fill_ups_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fill_text` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `fill_mark` int(250) NOT NULL,
  `oaes_item_id` int(10) unsigned NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`oaes_fill_ups_id`),
  KEY `oaes_fill_ups_oaes_item_id_foreign` (`oaes_item_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=53 ;

--
-- Dumping data for table `oaes_fill_ups`
--

INSERT INTO `oaes_fill_ups` (`oaes_fill_ups_id`, `fill_text`, `fill_mark`, `oaes_item_id`, `created_at`, `updated_at`) VALUES
(16, 'Different', 100, 403, '2014-11-10 09:48:18', '2014-11-10 09:48:18'),
(17, 'Equality', 100, 404, '2014-11-10 09:50:07', '2014-11-10 09:50:07'),
(18, 'Single ', 100, 405, '2014-11-10 09:51:07', '2014-11-10 09:51:07'),
(19, 'Variable ', 100, 406, '2014-11-10 09:52:06', '2014-11-10 09:52:06'),
(20, 'fseek(fp, 0L, 0)', 100, 407, '2014-11-10 09:53:09', '2014-11-10 09:53:09'),
(21, '4 bytes', 100, 408, '2014-11-10 09:58:35', '2014-11-10 09:58:35'),
(22, 'prenthesis ', 100, 409, '2014-11-10 10:20:05', '2014-11-10 10:20:05'),
(23, 'do…while', 100, 410, '2014-11-10 10:20:53', '2014-11-10 10:20:53'),
(24, '||', 100, 411, '2014-11-10 10:21:38', '2014-11-10 10:21:38'),
(25, '(*t)', 100, 412, '2014-11-10 10:22:21', '2014-11-10 10:22:21'),
(26, '2', 100, 413, '2014-11-10 10:24:15', '2014-11-10 10:24:15'),
(27, '4', 100, 414, '2014-11-10 10:25:09', '2014-11-10 10:25:09'),
(28, 'semicolon ', 100, 415, '2014-11-10 10:26:00', '2014-11-10 10:26:00'),
(29, 'void ', 100, 416, '2014-11-10 10:26:37', '2014-11-10 10:26:37'),
(30, 'header file ', 100, 417, '2014-11-10 10:27:25', '2014-11-10 10:27:25'),
(31, 'Macro ', 100, 418, '2014-11-10 10:28:03', '2014-11-10 10:28:03'),
(32, 'Union ', 100, 419, '2014-11-10 10:28:53', '2014-11-10 10:28:53'),
(33, 'integers ', 100, 420, '2014-11-10 10:29:33', '2014-11-10 10:29:33'),
(34, 'indirection ', 100, 421, '2014-11-10 10:30:20', '2014-11-10 10:30:20'),
(35, 'Macro ', 100, 422, '2014-11-10 10:30:57', '2014-11-10 10:30:57'),
(36, 'break', 100, 423, '2014-11-10 10:36:58', '2014-11-10 10:36:58'),
(37, 'structure', 100, 424, '2014-11-10 10:37:33', '2014-11-10 10:37:33'),
(38, 'break', 100, 425, '2014-11-10 10:38:11', '2014-11-10 10:38:11'),
(39, 'typecasting', 100, 426, '2014-11-10 10:38:45', '2014-11-10 10:38:45'),
(40, 'one', 100, 427, '2014-11-10 10:39:21', '2014-11-10 10:39:21'),
(41, '&', 100, 428, '2014-11-10 10:40:06', '2014-11-10 10:40:06'),
(42, 'Global', 100, 429, '2014-11-10 10:40:48', '2014-11-10 10:40:48'),
(43, 'array', 100, 430, '2014-11-10 10:41:17', '2014-11-10 10:41:17'),
(44, 'fseek', 100, 431, '2014-11-10 10:41:57', '2014-11-10 10:41:57'),
(45, 'malloc', 100, 432, '2014-11-10 10:42:40', '2014-11-10 10:42:40'),
(46, '2', 100, 473, '2014-11-11 06:25:36', '2014-11-11 06:25:36'),
(47, '4', 100, 474, '2014-11-11 06:59:04', '2014-11-11 06:59:04'),
(48, 'semicolon', 100, 475, '2014-11-11 07:00:00', '2014-11-11 07:00:00'),
(49, 'void', 100, 476, '2014-11-11 07:01:58', '2014-11-11 07:01:58'),
(50, 'header file ', 100, 477, '2014-11-11 07:03:51', '2014-11-11 07:03:51'),
(51, 'Macro', 100, 478, '2014-11-11 07:04:46', '2014-11-11 07:04:46'),
(52, 'Union ', 100, 479, '2014-11-11 07:06:11', '2014-11-11 07:06:11');

-- --------------------------------------------------------

--
-- Table structure for table `oaes_fill_ups_nolist`
--

CREATE TABLE IF NOT EXISTS `oaes_fill_ups_nolist` (
  `oaes_fill_ups_nolist_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fill_text` varchar(400) NOT NULL,
  `oaes_item_id` int(10) unsigned NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`oaes_fill_ups_nolist_id`),
  KEY `oaes_item_id` (`oaes_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `oaes_item`
--

CREATE TABLE IF NOT EXISTS `oaes_item` (
  `oaes_item_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `item_text` varchar(1024) COLLATE utf8_unicode_ci NOT NULL,
  `item_desc` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `item_status` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  `oaes_item_type_id` int(10) unsigned NOT NULL,
  `oaes_subject_id` int(10) unsigned NOT NULL,
  `oaes_cognitive_category_id` int(10) unsigned NOT NULL,
  `oaes_knowledge_category_id` int(10) unsigned NOT NULL,
  `oaes_difficulty_id` int(10) unsigned DEFAULT NULL,
  `ap_topic_id` int(10) unsigned NOT NULL,
  `item_keywords` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ap_unitofstudy_id` int(10) unsigned DEFAULT NULL,
  `author_id` int(11) unsigned NOT NULL,
  `reviewer_id` int(10) unsigned DEFAULT NULL,
  `manager_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`oaes_item_id`),
  KEY `oaes_item_oaes_item_type_id_foreign` (`oaes_item_type_id`),
  KEY `oaes_item_oaes_subject_id_foreign` (`oaes_subject_id`),
  KEY `oaes_item_oaes_cognitive_category_id_foreign` (`oaes_cognitive_category_id`),
  KEY `oaes_item_oaes_knowledge_category_id_foreign` (`oaes_knowledge_category_id`),
  KEY `oaes_item_oaes_difficulty_id_foreign` (`oaes_difficulty_id`),
  KEY `ap_topic_id` (`ap_topic_id`),
  KEY `	ap_unitofstudy_id` (`ap_unitofstudy_id`),
  KEY `	ap_unitofstudy_id_2` (`ap_unitofstudy_id`),
  KEY `ap_unitofstudy_id` (`ap_unitofstudy_id`),
  KEY `author_id` (`author_id`),
  KEY `reviewer_id` (`reviewer_id`,`manager_id`),
  KEY `manager_id` (`manager_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=493 ;

--
-- Dumping data for table `oaes_item`
--

INSERT INTO `oaes_item` (`oaes_item_id`, `item_text`, `item_desc`, `item_status`, `created_at`, `updated_at`, `oaes_item_type_id`, `oaes_subject_id`, `oaes_cognitive_category_id`, `oaes_knowledge_category_id`, `oaes_difficulty_id`, `ap_topic_id`, `item_keywords`, `ap_unitofstudy_id`, `author_id`, `reviewer_id`, `manager_id`) VALUES
(343, '<p>The following is a program<br /><br /><strong>Main()</strong><br /><br /><strong>{</strong><br /><br /><strong>int x = 0;</strong><br /><br /><strong>while(x&lt;=10)</strong><br /><br /><strong>for( ; ; )</strong><br /><br /><strong>if( ++ x%10 = =0)</strong><br /><br /><strong>break;</strong><br /><br /><strong>printf(&ldquo;x = %d&rdquo;, x);</strong><br /><br /><strong>}</strong><br /><br />What will be the output of the above program?</p>', '1m3', 1, '2014-11-10 05:58:14', '2014-11-10 05:58:14', 2, 3, 1, 1, 0, 48, 'If loop, For loop ', NULL, 2, NULL, NULL),
(344, '<p>Consider the following variable declaration<br /><br /><strong>Union x{</strong><br /><br /><strong>int i;</strong><br /><br /><strong>float f;</strong><br /><br /><strong>char c;</strong><br /><br /><strong>M4.1-R3 Page 1 of 6 January, 2006</strong><br /><br /><strong>}y;</strong><br /><br />if the size of i, f and c are 2 bytes, 4 bytes and 1 byte respectively then the size of the <br /><br />variable y is:-</p>', '2m3', 1, '2014-11-10 06:01:12', '2014-11-10 06:01:12', 2, 3, 1, 1, 0, 55, 'Union', NULL, 2, NULL, NULL),
(345, '<p>Pick up the odd one out from the following</p>', '3m3', 1, '2014-11-10 06:03:40', '2014-11-10 06:03:40', 2, 3, 1, 1, 0, 47, 'decreament', NULL, 2, NULL, NULL),
(346, '<p>What is the value of &lsquo;average&rsquo; after the following program is executed?</p>\r\n<p><strong>main()</strong></p>\r\n<p><strong>{</strong></p>\r\n<p><strong>int sum, index=0;</strong></p>\r\n<p><strong>float average;</strong></p>\r\n<p><strong>sum = 0;</strong></p>\r\n<p><strong>for( ; ; ) {</strong></p>\r\n<p><strong>sum = sum + index;</strong></p>\r\n<p><strong>++ index;</strong></p>\r\n<p><strong>if (sum &gt; = 100) break;</strong></p>\r\n<p><strong>}</strong></p>\r\n<p><strong>average = sum / index;</strong></p>\r\n<p><strong>}</strong></p>', '4m3', 1, '2014-11-10 06:11:39', '2014-11-10 06:11:39', 2, 3, 1, 1, 0, 48, 'For loop, If loop', NULL, 2, NULL, NULL),
(347, '<p>If a = -11 and b = -3. What is the value of a % b?</p>', '6m3', 1, '2014-11-10 06:13:42', '2014-11-10 06:13:42', 2, 3, 1, 1, 0, 47, 'Relational', NULL, 2, NULL, NULL),
(348, '<p>Suppose i, j, k are integer variables with values 1, 2, 3 respectively. What is the value of the following expression?</p>\r\n<p><strong>! (( j + k ) &gt; (i + 5 ))</strong></p>', '5m3', 1, '2014-11-10 06:14:56', '2014-11-10 06:14:56', 2, 3, 1, 1, 0, 47, 'Relational', NULL, 2, NULL, NULL),
(349, '<p>If c is a variable initialized to 1, how many times will the following loop be executed?</p>\r\n<p><strong>while(( c &gt; 0 &amp;&amp; (c &lt; 60))</strong></p>\r\n<p><strong>{</strong></p>\r\n<p><strong>c ++;</strong></p>\r\n<p><strong>}</strong></p>', '7m3', 1, '2014-11-10 06:16:17', '2014-11-10 06:16:17', 2, 3, 1, 1, 0, 48, 'While loop', NULL, 2, NULL, NULL),
(350, '<p>Which one of the following describes correctly a static variable?</p>', '8m3', 1, '2014-11-10 06:19:22', '2014-11-10 06:19:22', 2, 3, 1, 1, 0, 45, 'Static variable ', NULL, 2, NULL, NULL),
(351, '<p>What will be the output of the following program?</p>\r\n<p><strong>main()</strong></p>\r\n<p><strong>{</strong></p>\r\n<p><strong>int a, *ptr, b, c;</strong></p>\r\n<p><strong>a = 25;</strong></p>\r\n<p><strong>ptr = &amp;a;</strong></p>\r\n<p><strong>b = a + 30;</strong></p>\r\n<p><strong>c = *ptr;</strong></p>\r\n<p><strong>printf(&ldquo;%d %d %d&rdquo;, a, b, c);</strong></p>\r\n<p><strong>}</strong></p>', '9m3', 1, '2014-11-10 06:24:55', '2014-11-10 06:24:55', 2, 3, 1, 1, 0, 56, 'Pointers', NULL, 2, NULL, NULL),
(352, '<p>If a = 0&acute;aa and b = a &lt;&lt; 1 then which of the following is true</p>', '10m3', 1, '2014-11-10 06:30:52', '2014-11-10 06:30:52', 2, 3, 1, 1, 0, 47, 'Relational', NULL, 2, NULL, NULL),
(353, '<p>It is not possible to print the % character as the function <strong>printf </strong>treats % as the beginning of a conversion specification</p>', '11m3', 1, '2014-11-10 06:32:04', '2014-11-10 06:32:04', 1, 3, 1, 1, 0, 46, 'Printf', NULL, 2, NULL, NULL),
(354, '<p>A structure can include one or more pointers as members</p>', '12m3', 1, '2014-11-10 06:33:15', '2014-11-10 06:33:15', 1, 3, 1, 1, 0, 55, 'structure', NULL, 2, NULL, NULL),
(355, '<p>It is not possible to have formatted input / output in &lsquo;C&rsquo;</p>', '13m3', 1, '2014-11-10 06:34:02', '2014-11-10 06:34:02', 1, 3, 1, 1, 0, 46, 'Input/Output', NULL, 2, NULL, NULL),
(356, '<p>It is not possible to have nested if &ndash; else statements in &lsquo;C&rsquo;</p>', '14m3', 1, '2014-11-10 06:34:59', '2014-11-10 06:34:59', 1, 3, 1, 1, 0, 48, 'Nested if else', NULL, 2, NULL, NULL),
(357, '<p>The increment operator ++ does not work with float variable</p>', '15m3', 1, '2014-11-10 06:36:11', '2014-11-10 06:36:11', 1, 3, 1, 1, 0, 47, 'increment, float', NULL, 2, NULL, NULL),
(358, '<p>*a is the same as a[ ] in a parameter declaration</p>', '16m3', 1, '2014-11-10 07:01:17', '2014-11-10 07:01:17', 1, 3, 1, 1, 0, 56, 'pointer', NULL, 2, NULL, NULL),
(359, '<p>In &lsquo;C&rsquo; programming language, strings are represented using an array</p>', '17m3', 1, '2014-11-10 07:02:18', '2014-11-10 07:02:18', 1, 3, 1, 1, 0, 51, 'Strings', NULL, 2, NULL, NULL),
(360, '<p>Relational operators have higher precedence than arithmetic operators</p>', '18m3', 1, '2014-11-10 07:03:07', '2014-11-10 07:03:07', 1, 3, 1, 1, 0, 47, 'Relational', NULL, 2, NULL, NULL),
(361, '<p>A structure cannot be a member of a union</p>', '19m3', 1, '2014-11-10 07:03:58', '2014-11-10 07:03:58', 1, 3, 1, 1, 0, 55, 'structure', NULL, 2, NULL, NULL),
(362, '<p>*p++ increments the content of the location pointed by p</p>', '20m3', 1, '2014-11-10 07:05:31', '2014-11-10 07:05:31', 1, 3, 1, 1, 0, 56, 'Pointers', NULL, 2, NULL, NULL),
(363, '<p>The &amp;&amp; and || operators</p>', '21m3', 1, '2014-11-10 09:05:28', '2014-11-10 09:05:28', 2, 3, 1, 1, 0, 47, 'Operators', NULL, 2, NULL, NULL),
(364, '<p>The break statement causes an exit</p>', '22m3', 1, '2014-11-10 09:06:34', '2014-11-10 09:06:34', 2, 3, 1, 1, 0, 48, 'Graphics', NULL, 2, NULL, NULL),
(365, '<p>Assuming var1 has value 20. What will following code print?</p>\r\n<p>Printf(&ldquo;%d %d\\n&rdquo;, var1--, ++var1);</p>', '23m3', 1, '2014-11-10 09:07:58', '2014-11-10 09:07:58', 2, 3, 1, 1, 0, 46, 'Operators', NULL, 2, NULL, NULL),
(366, '<p>When accessing a structure member, the identifier to the left of the dot operator is the name of</p>', '24m3', 1, '2014-11-10 09:09:12', '2014-11-10 09:09:12', 2, 3, 1, 1, 0, 45, 'structure', NULL, 2, NULL, NULL),
(367, '<p>A static automatic variable is used to</p>', '25m3', 1, '2014-11-10 09:10:23', '2014-11-10 09:10:23', 2, 3, 1, 1, 0, 45, 'Static variable', NULL, 2, NULL, NULL),
(368, '<p>Which of the following directive creates functions like macros?</p>', '26m3', 1, '2014-11-10 09:11:25', '2014-11-10 09:11:25', 2, 3, 1, 1, 0, 46, 'Macros', NULL, 2, NULL, NULL),
(369, '<p>Which format specification is used in printf statement to print hexadecimal format</p>', '27m3', 1, '2014-11-10 09:12:22', '2014-11-10 09:12:22', 2, 3, 1, 1, 0, 46, 'Printf', NULL, 2, NULL, NULL),
(370, '<p>What will be the output of the following program:</p>\r\n<p><strong>Main()</strong></p>\r\n<p><strong>{</strong></p>\r\n<p><strong>int val = 500;</strong></p>\r\n<p><strong>int *ptr = &amp;val;</strong></p>\r\n<p><strong>int **ptr1 = &amp;ptr;</strong></p>\r\n<p><strong>printf(&ldquo;val = %d&rdquo;, **ptr1);</strong></p>\r\n<p><strong>}</strong></p>', '28m3', 1, '2014-11-10 09:13:37', '2014-11-10 09:13:37', 2, 3, 3, 3, 0, 45, 'Pointers', NULL, 2, NULL, NULL),
(371, '<p>size of operator returns the size in bytes of</p>', '29m3', 1, '2014-11-10 09:14:43', '2014-11-10 09:14:43', 2, 3, 1, 1, 0, 45, 'Size, Data Size', NULL, 2, NULL, NULL),
(372, '<p>The value of variable x after executing the following code will be:</p>\r\n<p><strong>val = -200;</strong></p>\r\n<p><strong>x = (val &gt;= 0 ) ? val : -val</strong></p>', '30m3', 1, '2014-11-10 09:15:35', '2014-11-10 09:15:35', 2, 3, 3, 3, 0, 47, 'If Statement', NULL, 2, NULL, NULL),
(373, '<p>The #undef directive removes a name previously defined with #define directive.</p>', '31m3', 1, '2014-11-10 09:16:25', '2014-11-10 09:16:25', 1, 3, 1, 1, 0, 45, 'Directives', NULL, 2, NULL, NULL),
(374, '<p>The &lsquo;C&rsquo; program can have only one command line argument</p>', '32m3', 1, '2014-11-10 09:17:11', '2014-11-10 09:17:11', 1, 3, 1, 1, 0, 42, 'Command line arguments', NULL, 2, NULL, NULL),
(375, '<p>The goto statement causes control to go to a function</p>', '33m3', 1, '2014-11-10 09:17:48', '2014-11-10 09:17:48', 1, 3, 1, 1, 0, 49, 'Goto', NULL, 2, NULL, NULL),
(376, '<p>If you don&rsquo;t use a return type in the function declaration, the compiler assumes that the function does not return anything.</p>', '34m3', 1, '2014-11-10 09:18:22', '2014-11-10 09:18:22', 1, 3, 1, 1, 0, 53, 'Functions', NULL, 2, NULL, NULL),
(377, '<p>An array element is accessed using the dot operator.</p>', '35m3', 1, '2014-11-10 09:19:01', '2014-11-10 09:19:01', 1, 3, 1, 1, 0, 45, 'Arrays', NULL, 2, NULL, NULL),
(378, '<p>Continue statement skips all subsequent statements in the loop body and triggers the next iteration for the loop.</p>', '36m3', 1, '2014-11-10 09:19:48', '2014-11-10 09:19:48', 1, 3, 1, 1, 0, 48, 'Loops', NULL, 2, NULL, NULL),
(379, '<p>The strcmpi function compares two strings irrespective of case</p>', '37m3', 1, '2014-11-10 09:20:31', '2014-11-10 09:20:31', 1, 3, 1, 1, 0, 51, 'Strings', NULL, 2, NULL, NULL),
(380, '<p>For loop allows a statement or compound statement to be executed at least once.</p>', '38m3', 1, '2014-11-10 09:21:21', '2014-11-10 09:21:21', 1, 3, 1, 1, 0, 48, 'Loops, for', NULL, 2, NULL, NULL),
(381, '<p>The fread function reads formatted data from a stream</p>', '39m3', 1, '2014-11-10 09:22:08', '2014-11-10 09:22:08', 1, 3, 1, 1, 0, 58, 'File Operations', NULL, 2, NULL, NULL),
(382, '<p>In &lsquo;C&rsquo;, unsigned int can have maximum range of values between 0 to 65535.</p>', '40m4', 1, '2014-11-10 09:23:07', '2014-11-10 09:23:07', 1, 3, 1, 1, 0, 45, 'Integer', NULL, 2, NULL, NULL),
(383, '<p>Given the following code fragment:</p>\r\n<p><strong>void main(void)</strong></p>\r\n<p><strong>{</strong></p>\r\n<p><strong>char x = &lsquo;\\0&rsquo;;</strong></p>\r\n<p><strong>char n = &lsquo;N&rsquo;;</strong></p>\r\n<p><strong>printf(&ldquo;%u&rdquo; &rdquo;%s\\n&rdquo;, &amp;n, &amp;n);</strong></p>\r\n<p><strong>}</strong></p>\r\n<p>What will be the result of execution?</p>', '41m3', 1, '2014-11-10 09:24:34', '2014-11-10 09:24:34', 2, 3, 1, 1, 0, 45, 'Output, Void', NULL, 2, NULL, NULL),
(384, '<p>Given the following code fragment:</p>\r\n<p><strong>int main(void)</strong></p>\r\n<p><strong>{</strong></p>\r\n<p><strong>int raw[20], i, sum=0;</strong></p>\r\n<p><strong>int *p = raw;</strong></p>\r\n<p><strong>for (i=0; i &lt; 20; i++)</strong></p>\r\n<p><strong>*(p+i) = i;</strong></p>\r\n<p><strong>for(i=0; i &lt; 20; i += sizeof(int))</strong></p>\r\n<p><strong>sum += *(p+i);</strong></p>\r\n<p><strong>printf("sum = %d\\n", sum);</strong></p>\r\n<p><strong>return();</strong></p>\r\n<p><strong>}</strong></p>\r\n<p>What will be the result of execution?</p>', '42m3', 1, '2014-11-10 09:25:33', '2014-11-10 09:25:33', 2, 3, 1, 1, 0, 48, 'For loop', NULL, 2, NULL, NULL),
(385, '<p>What is the missing statement in the following function which copies string x into string y</p>\r\n<p><strong>void strcpy( char *x, char *y)</strong></p>\r\n<p><strong>{</strong></p>\r\n<p><strong>while (*y != &lsquo;\\0&rsquo;)</strong></p>\r\n<p><strong>&hellip;&hellip;&hellip;&hellip;&hellip;&hellip;&hellip; </strong><strong>/* missing stament */</strong></p>\r\n<p><strong>*x = &lsquo;\\0&rsquo;;</strong></p>\r\n<p><strong>}</strong></p>', '43m3', 1, '2014-11-10 09:26:35', '2014-11-10 09:26:35', 2, 3, 1, 1, 0, 51, 'String Copy', NULL, 2, NULL, NULL),
(386, '<p>Consider the following program,</p>\r\n<p><strong>main( )</strong></p>\r\n<p><strong>{</strong></p>\r\n<p><strong>int x = 49;</strong></p>\r\n<p><strong>for(;x;)</strong></p>\r\n<p><strong>x--;</strong></p>\r\n<p><strong>printf(&ldquo;%d\\n&rdquo;, x);</strong></p>\r\n<p><strong>}</strong></p>\r\n<p>the output of the program will be</p>', '44m3', 1, '2014-11-10 09:27:30', '2014-11-10 09:27:30', 2, 3, 1, 1, 0, 48, 'For loop', NULL, 2, NULL, NULL),
(387, '<p># define dp(e) printf(#e &ldquo; = %d\\n&rdquo;,e)</p>\r\n<p><strong>main( )</strong></p>\r\n<p><strong>{</strong></p>\r\n<p><strong>int x =3, y = 2;</strong></p>\r\n<p><strong>dp(x/y)</strong></p>\r\n<p><strong>}</strong></p>\r\n<p>What will be the output of the program?</p>', '45m3', 1, '2014-11-10 09:28:39', '2014-11-10 09:28:39', 2, 3, 1, 1, 0, 53, 'Functions', NULL, 2, NULL, NULL),
(388, '<p>Assume that <em>i</em>, <em>j </em>and <em>k </em>are integer variables and their values are 8, 5 and 0 respectively. What will be the values of variables <em>i </em>and <em>k </em>after executing the following expressions?</p>\r\n<p><em>k </em>= ( j &gt; 5) ? ( i &lt; 5) ? i-j: j-i: k-j;</p>\r\n<p><em>i </em>-= (k) ? (i) ? (j): (i): (k);</p>', '46m3', 1, '2014-11-10 09:29:45', '2014-11-10 09:29:45', 2, 3, 1, 1, 0, 47, 'Relational Operator', NULL, 2, NULL, NULL),
(389, '<p>The &amp;&amp; and | | operators</p>', '47m3', 1, '2014-11-10 09:30:54', '2014-11-10 09:30:54', 2, 3, 1, 1, 0, 47, 'Relational', NULL, 2, NULL, NULL),
(390, '<p>An external variable is one</p>', '48m3', 1, '2014-11-10 09:35:32', '2014-11-10 09:35:32', 2, 3, 1, 1, 0, 45, 'Extern variable', NULL, 2, NULL, NULL),
(391, '<p>Find the error in the following program:</p>\r\n<p><strong>main( )</strong></p>\r\n<p><strong>{</strong></p>\r\n<p><strong>int m;</strong></p>\r\n<p><strong>char g;</strong></p>\r\n<p><strong>switch(m)</strong></p>\r\n<p><strong>{</strong></p>\r\n<p><strong>case 5 : grade=&rdquo;P&rdquo;;break;</strong></p>\r\n<p><strong>case 2 : grade=&rdquo;Q&rdquo;;break;</strong></p>\r\n<p><strong>case 2 : grade=&rdquo;R&rdquo;;break;</strong></p>\r\n<p><strong>default : grade=&rdquo;S&rdquo;;break;</strong></p>\r\n<p><strong>}</strong></p>\r\n<p><strong>}</strong></p>', '49m3', 1, '2014-11-10 09:36:38', '2014-11-10 09:36:38', 2, 3, 1, 1, 0, 47, 'Switch Statement', NULL, 2, NULL, NULL),
(392, '<p>Consider the following program:</p>\r\n<p><strong>main( )</strong></p>\r\n<p><strong>{</strong></p>\r\n<p><strong>char *k=&rdquo;xyz;</strong></p>\r\n<p><strong>f(k);</strong></p>\r\n<p><strong>printf(&ldquo;%s\\n&rdquo;,k);</strong></p>\r\n<p><strong>}</strong></p>\r\n<p><strong>f(char *k)</strong></p>\r\n<p><strong>{ k = malloc(4); strcpy(k, &ldquo;pq&rdquo;); }</strong></p>\r\n<p>What will be the output?</p>', '50m3', 1, '2014-11-10 09:37:42', '2014-11-10 09:37:42', 2, 3, 1, 1, 0, 58, 'Malloc', NULL, 2, NULL, NULL),
(393, '<p>Arrays in &lsquo;C&rsquo; language are always stored in column-major fashion</p>', '51m3', 1, '2014-11-10 09:38:26', '2014-11-10 09:38:26', 1, 3, 1, 1, 0, 50, 'Arrays', NULL, 2, NULL, NULL),
(394, '<p>for(;;) will give syntax error in &lsquo;C&rsquo; language</p>', '52m3', 1, '2014-11-10 09:39:03', '2014-11-10 09:39:03', 1, 3, 1, 1, 0, 48, 'For loop', NULL, 2, NULL, NULL),
(395, '<p>For command line arguments, argv is a pointer to an array of pointers</p>', '53m3', 1, '2014-11-10 09:39:47', '2014-11-10 09:39:47', 1, 3, 1, 1, 0, 56, 'Array, Pointers', NULL, 2, NULL, NULL),
(396, '<p>A member of any structure is referred to in an expression by a construction of the form structure-name &rarr; member</p>', '54m3', 1, '2014-11-10 09:40:24', '2014-11-10 09:40:24', 1, 3, 1, 1, 0, 55, 'structure', NULL, 2, NULL, NULL),
(397, '<p>Bitwise fields can be of any type</p>', '55m3', 1, '2014-11-10 09:41:07', '2014-11-10 09:41:07', 1, 3, 1, 1, 0, 47, 'Bitwise', NULL, 2, NULL, NULL),
(398, '<p>Goto statement transfer the control from one function to another</p>', '56m3', 1, '2014-11-10 09:42:19', '2014-11-10 09:42:19', 1, 3, 1, 1, 0, 47, 'Goto', NULL, 2, NULL, NULL),
(399, '<p>An array&rsquo;s name is a pointer constant</p>', '57m3', 1, '2014-11-10 09:42:52', '2014-11-10 09:42:52', 1, 3, 1, 1, 0, 50, 'Arrays', NULL, 2, NULL, NULL),
(400, '<p>C allows different variables to have the same name</p>', '58m3', 1, '2014-11-10 09:43:32', '2014-11-10 09:43:32', 1, 3, 1, 1, 0, 45, 'Variables', NULL, 2, NULL, NULL),
(401, '<p>Variables defined in the same function always have the same scope</p>', '59m3', 1, '2014-11-10 09:44:00', '2014-11-10 09:44:00', 1, 3, 1, 1, 0, 45, 'Variables', NULL, 2, NULL, NULL),
(402, '<p>Each symbol constant requires a separate # define directive to create it</p>', '60m3', 1, '2014-11-10 09:44:46', '2014-11-10 09:44:46', 1, 3, 1, 1, 0, 45, 'Define Directive', NULL, 2, NULL, NULL),
(403, '<p>Operators &amp;, ^, = = have ________ precedence</p>', '61m3', 1, '2014-11-10 09:48:18', '2014-11-10 09:48:18', 4, 3, 1, 1, 0, 47, 'Operators', NULL, 2, NULL, NULL),
(404, '<p>The logical operator = = checks for ________ of two values</p>', '62m3', 1, '2014-11-10 09:50:07', '2014-11-10 09:50:07', 4, 3, 1, 1, 0, 47, 'Operators', NULL, 2, NULL, NULL),
(405, '<p>A character constant is a sequence of one or more characters enclosed in ________ quotes.</p>', '63m3', 1, '2014-11-10 09:51:07', '2014-11-10 09:51:07', 4, 3, 1, 1, 0, 45, 'Characters', NULL, 2, NULL, NULL),
(406, '<p>printf( ) function uses ________ number of arguments</p>', '64m3', 1, '2014-11-10 09:52:06', '2014-11-10 09:52:06', 4, 3, 1, 1, 0, 46, 'Printf', NULL, 2, NULL, NULL),
(407, '<p>rewind (fp) and ________ performs the same operation</p>', '65m3', 1, '2014-11-10 09:53:09', '2014-11-10 09:53:09', 4, 3, 1, 1, 0, 58, 'fseek', NULL, 2, NULL, NULL),
(408, '<p>The contents of two pointers that point to adjacent variables of type float differ by ________.</p>', '66m3', 1, '2014-11-10 09:58:35', '2014-11-10 09:58:35', 4, 3, 1, 1, 0, 56, 'Pointers', NULL, 2, NULL, NULL),
(409, '<p>A function name must be followed by ________.</p>', '67m3', 1, '2014-11-10 10:20:05', '2014-11-10 10:20:05', 4, 3, 1, 1, 0, 53, 'Functions', NULL, 2, NULL, NULL),
(410, '<p>________ iterative statement will always be executed atleast once</p>', '68m3', 1, '2014-11-10 10:20:53', '2014-11-10 10:20:53', 4, 3, 1, 1, 0, 58, 'Do While', NULL, 2, NULL, NULL),
(411, '<p>________ is the bitwise inclusive or operator</p>', '69m3', 1, '2014-11-10 10:21:38', '2014-11-10 10:21:38', 4, 3, 1, 1, 0, 47, 'Bitwise operator', NULL, 2, NULL, NULL),
(412, '<p>If &ldquo;t&rdquo; is a pointer to a structure then &ldquo;t&rarr;&rdquo; is the same as ________</p>', '70m3', 1, '2014-11-10 10:22:21', '2014-11-10 10:22:21', 4, 3, 1, 1, 0, 56, 'Pointers', NULL, 2, NULL, NULL),
(413, '<p>The expression 11%3 evaluates to __________.</p>', '71m3', 1, '2014-11-10 10:24:15', '2014-11-10 10:24:15', 4, 3, 1, 1, 0, 42, 'Functions', NULL, 2, NULL, NULL),
(414, '<p>In a 32 bit system float data type will occupy __________ bytes</p>', '72m3', 1, '2014-11-10 10:25:09', '2014-11-10 10:25:09', 4, 3, 1, 1, 0, 45, 'Data, size', NULL, 2, NULL, NULL),
(415, '<p>The closing brace of a structure is followed by __________.</p>', '73m3', 1, '2014-11-10 10:26:00', '2014-11-10 10:26:00', 4, 3, 1, 1, 0, 45, 'Data type, Structure', NULL, 2, NULL, NULL),
(416, '<p>A function that does not return anything has return type __________.</p>', '74m3', 1, '2014-11-10 10:26:37', '2014-11-10 10:26:37', 4, 3, 1, 1, 0, 53, 'Functions', NULL, 2, NULL, NULL),
(417, '<p>A(n) __________ cannot be passed to a function as an argument</p>', '75m3', 1, '2014-11-10 10:27:25', '2014-11-10 10:27:25', 4, 3, 1, 1, 0, 48, 'Functions', NULL, 2, NULL, NULL),
(418, '<p>An instruction to the compiler to perform an action at compile time is called __________.</p>', '76m3', 1, '2014-11-10 10:28:03', '2014-11-10 10:28:03', 4, 3, 1, 1, 0, 42, 'Compiler', NULL, 2, NULL, NULL),
(419, '<p>__________ is an example of derived data type</p>', '77m3', 1, '2014-11-10 10:28:53', '2014-11-10 10:28:53', 4, 3, 1, 1, 0, 45, 'Union, Derived data type', NULL, 2, NULL, NULL),
(420, '<p>Enumerations can be internally treated as __________.</p>', '78m3', 1, '2014-11-10 10:29:33', '2014-11-10 10:29:33', 4, 3, 1, 1, 0, 44, 'Data', NULL, 2, NULL, NULL),
(421, '<p>Accessing a data object through a pointer rather than directly by name is called ______.</p>', '79m3', 1, '2014-11-10 10:30:20', '2014-11-10 10:30:20', 4, 3, 1, 1, 0, 44, 'Pointers', NULL, 2, NULL, NULL),
(422, '<p>An identifier defined in a #define preprocessor directive to represent another series of character is called __________.</p>', '80m3', 1, '2014-11-10 10:30:57', '2014-11-10 10:30:57', 4, 3, 1, 1, 0, 44, 'Macro', NULL, 2, NULL, NULL),
(423, '<p>In switch statement, one of the optional key word is _______.</p>', '81m3', 1, '2014-11-10 10:36:58', '2014-11-10 10:36:58', 4, 3, 1, 1, 0, 48, 'If loop, For loop', NULL, 2, NULL, NULL),
(424, '<p>________ is used to construct user defined data type using the existing ones</p>', '82m3', 1, '2014-11-10 10:37:33', '2014-11-10 10:37:33', 4, 3, 1, 1, 0, 48, 'If loop, For loop', NULL, 2, NULL, NULL),
(425, '<p>________ is used to skip body of the loop once</p>', '83m3', 1, '2014-11-10 10:38:11', '2014-11-10 10:38:11', 4, 3, 1, 1, 0, 48, 'If loop, For loop', NULL, 2, NULL, NULL),
(426, '<p>To convert one data type into another for the evaluation purpose is called ________</p>', '84m3', 1, '2014-11-10 10:38:45', '2014-11-10 10:38:45', 4, 3, 1, 1, 0, 48, 'If loop, For loop', NULL, 2, NULL, NULL),
(427, '<p>In for loop, initialization is done ________ time(s)</p>', '85m3', 1, '2014-11-10 10:39:21', '2014-11-10 10:39:21', 4, 3, 1, 1, 0, 48, 'If loop, For loop', NULL, 2, NULL, NULL),
(428, '<p>________ operator is used to access the value of a variable using pointer.</p>', '86m3', 1, '2014-11-10 10:40:06', '2014-11-10 10:40:06', 4, 3, 1, 1, 0, 48, 'If loop, For loop', NULL, 2, NULL, NULL),
(429, '<p>________ variable can be accessed by all the functions in the program</p>', '87m3', 1, '2014-11-10 10:40:48', '2014-11-10 10:40:48', 4, 3, 1, 1, 0, 48, 'If loop, For loop', NULL, 2, NULL, NULL),
(430, '<p>________ uses a single name to represent a collection of items of same type</p>', '88m3', 1, '2014-11-10 10:41:17', '2014-11-10 10:41:17', 4, 3, 1, 1, 0, 48, 'If loop, For loop', NULL, 2, NULL, NULL),
(431, '<p>Using ________ function, we can write data to file</p>', '89m3', 1, '2014-11-10 10:41:57', '2014-11-10 10:41:57', 4, 3, 1, 1, 0, 48, 'If loop, For loop', NULL, 2, NULL, NULL),
(432, '<p>________ function is used to allocate memory at run time</p>', '90m3', 1, '2014-11-10 10:42:40', '2014-11-10 10:42:40', 4, 3, 1, 1, 0, 48, 'If loop, For loop', NULL, 2, NULL, NULL),
(433, '<p>Physically placing the machine instructions and data into main memory is done by</p>', '91m3', 1, '2014-11-10 10:43:43', '2014-11-10 10:43:43', 2, 3, 1, 1, 0, 42, 'Loader', NULL, 2, NULL, NULL),
(434, '<p>Choose the option that contains only Unary operators of C</p>', '92m3', 1, '2014-11-10 10:44:43', '2014-11-10 10:44:43', 2, 3, 1, 1, 0, 47, 'Unray Operator', NULL, 2, NULL, NULL),
(435, '<p>Which of the following is true for break and continue statements</p>', '93m3', 1, '2014-11-10 10:45:39', '2014-11-10 10:45:39', 2, 3, 1, 1, 0, 47, 'Break, Continue', NULL, 2, NULL, NULL),
(436, '<p>To print whether the number is odd or even, choose the correct option.</p>', '94m3', 1, '2014-11-10 10:46:48', '2014-11-10 10:46:48', 2, 3, 1, 1, 0, 46, 'Mod Operator', NULL, 2, NULL, NULL),
(437, '<p>What is the effect of the following code:</p>\r\n<p><strong>main() { int a[4] = {1,5};</strong></p>\r\n<p><strong>printf(&ldquo;%d&rdquo;, a[3]); }</strong></p>', '95m3', 1, '2014-11-10 10:47:42', '2014-11-10 10:47:42', 2, 3, 1, 1, 0, 46, 'Printf', NULL, 2, NULL, NULL),
(438, '<p>What will be the output of the following code?</p>\r\n<p><strong>main() { int a,b,c;</strong></p>\r\n<p><strong>a=1,b=10,c=2;</strong></p>\r\n<p><strong>for( ;c&lt;3;c++);</strong></p>\r\n<p><strong>for( ;a&lt;9,b&gt;6;a++,b--)</strong></p>\r\n<p><strong>printf(&ldquo;%d&rdquo;,c);</strong></p>\r\n<p><strong>}</strong></p>', '96m3', 1, '2014-11-10 10:48:43', '2014-11-10 10:48:43', 2, 3, 1, 1, 0, 48, 'If loop, For loop', NULL, 2, NULL, NULL),
(439, '<p>Which is the correct option for the following code?</p>\r\n<p><strong>main() { char *str1="hello", *str2="hello";</strong></p>\r\n<p><strong>if(str1==str2)</strong></p>\r\n<p><strong>printf("equal");</strong></p>\r\n<p><strong>else</strong></p>\r\n<p><strong>printf("unequal"); }</strong></p>', '97m3', 1, '2014-11-10 10:49:44', '2014-11-10 10:49:44', 2, 3, 1, 1, 0, 48, 'If loop, For loop', NULL, 2, NULL, NULL),
(440, '<p>Maximum value of an unsigned integer is</p>', '98m3', 1, '2014-11-10 10:50:51', '2014-11-10 10:50:51', 2, 3, 1, 1, 0, 45, 'Unsigned integer', NULL, 2, NULL, NULL),
(441, '<p>The keyword <strong>typedef </strong>is used to</p>', '99m3', 1, '2014-11-10 10:51:58', '2014-11-10 10:51:58', 2, 3, 1, 1, 0, 45, 'Keyword, typedef', NULL, 2, NULL, NULL),
(442, '<p>For the following definition, which of the given option is correct?</p>\r\n<p><strong>int a[10];</strong></p>', '100m3', 1, '2014-11-10 10:53:06', '2014-11-10 10:53:06', 2, 3, 1, 1, 0, 47, 'Operators', NULL, 2, NULL, NULL),
(443, '<p>By default, return type of any user-defined function is void</p>', '101m3', 1, '2014-11-10 10:53:38', '2014-11-10 10:53:38', 1, 3, 1, 1, 0, 52, 'Functions', NULL, 2, NULL, NULL),
(444, '<p>In else&hellip;if ladder, the else statement at last is optional</p>', '102m3', 1, '2014-11-10 10:54:20', '2014-11-10 10:54:20', 1, 3, 1, 1, 0, 48, 'If else loop', NULL, 2, NULL, NULL),
(445, '<p>There must be only one <strong>main( ) </strong>function in a program</p>', '103m3', 1, '2014-11-10 10:54:55', '2014-11-10 10:54:55', 1, 3, 1, 1, 0, 45, 'Main() function', NULL, 2, NULL, NULL),
(446, '<p>There is only one ternary operator in &lsquo;C&rsquo; which is Conditional operator</p>', '104m3', 1, '2014-11-10 10:55:27', '2014-11-10 10:55:27', 1, 3, 1, 1, 0, 47, 'Ternary operator', NULL, 2, NULL, NULL),
(447, '<p><strong>int a[ ]={4}; </strong>this statement allocates 4 bytes of memory</p>', '105m3', 1, '2014-11-10 10:56:01', '2014-11-10 10:56:01', 1, 3, 1, 1, 0, 56, 'Memory allocation', NULL, 2, NULL, NULL),
(448, '<p><strong>Float_int (float, float); </strong>is an invalid function prototype</p>', '106m3', 1, '2014-11-10 10:56:37', '2014-11-10 10:56:37', 1, 3, 1, 1, 0, 52, 'Functions', NULL, 2, NULL, NULL),
(449, '<p><strong>printf( ) </strong>is a user-defined function declared in <strong>stdio.h </strong>file</p>', '107m3', 1, '2014-11-10 10:57:14', '2014-11-10 10:57:14', 1, 3, 1, 1, 0, 45, 'printf	Stdio.h', NULL, 2, NULL, NULL),
(450, '<p>When an array is declared, name of array works as a constant pointer to base address</p>', '108m3', 1, '2014-11-10 10:57:41', '2014-11-10 10:57:41', 1, 3, 1, 1, 0, 50, 'Arrays', NULL, 2, NULL, NULL),
(451, '<p>Every string ends with character &lsquo;\\&amp;&rsquo;</p>', '109m3', 1, '2014-11-10 10:58:19', '2014-11-10 10:58:19', 1, 3, 1, 1, 0, 51, 'Strings', NULL, 2, NULL, NULL),
(452, '<p>If file can not be opened, <strong>fopen( ) </strong>returns Null pointer</p>', '110m3', 1, '2014-11-10 10:58:57', '2014-11-10 10:58:57', 1, 3, 1, 1, 0, 58, 'File`	fopen()', NULL, 2, NULL, NULL),
(453, '<p>The &amp;&amp; and || operators</p>', '111m3', 1, '2014-11-10 11:00:38', '2014-11-10 11:00:38', 2, 3, 1, 1, 0, 46, 'Operators', NULL, 2, NULL, NULL),
(454, '<p>The break statement causes an exit</p>', '112m3', 1, '2014-11-10 11:01:30', '2014-11-10 11:01:30', 2, 3, 1, 1, 0, 45, 'Break', NULL, 2, NULL, NULL),
(455, '<p>Assuming var1 has value 20. What will following code print?</p>\r\n<p>Printf(&ldquo;%d %d\\n&rdquo;, var1--, ++var1);</p>', '113m3', 1, '2014-11-10 11:02:47', '2014-11-10 11:02:47', 2, 3, 3, 3, 0, 46, 'Operators', NULL, 2, NULL, NULL),
(456, '<p>When accessing a structure member, the identifier to the left of the dot operator is the name of</p>', '114m3', 1, '2014-11-10 11:04:02', '2014-11-10 11:04:02', 2, 3, 1, 1, 0, 45, 'Data types	struct', NULL, 2, NULL, NULL),
(457, '<p>A static automatic variable is used to</p>', '115m3', 1, '2014-11-10 11:06:57', '2014-11-10 11:06:57', 2, 3, 1, 1, 0, 45, 'data types', NULL, 2, NULL, NULL),
(458, '<p>Which of the following directive creates functions like macros?</p>', '116m3', 1, '2014-11-10 11:08:05', '2014-11-10 11:08:05', 2, 3, 1, 1, 0, 45, 'data types', NULL, 2, NULL, NULL),
(459, '<p>Which format specification is used in printf statement to print hexadecimal format</p>', '117m3', 1, '2014-11-10 11:08:55', '2014-11-10 11:08:55', 2, 3, 1, 1, 0, 45, 'Printf', NULL, 2, NULL, NULL),
(460, '<p>What will be the output of the following program:</p>\r\n<p><strong>Main()</strong></p>\r\n<p><strong>{</strong></p>\r\n<p><strong>int val = 500;</strong></p>\r\n<p><strong>int *ptr = &amp;val;</strong></p>\r\n<p><strong>int **ptr1 = &amp;ptr;</strong></p>\r\n<p><strong>printf(&ldquo;val = %d&rdquo;, **ptr1);</strong></p>\r\n<p><strong>}</strong></p>', '118m3', 1, '2014-11-10 11:09:59', '2014-11-10 11:09:59', 2, 3, 3, 3, 0, 45, 'Pointers', NULL, 2, NULL, NULL),
(461, '<p>Size of operator returns the size in bytes of</p>', '119m3', 1, '2014-11-10 11:11:28', '2014-11-10 11:11:28', 2, 3, 1, 1, 0, 45, 'Data types, size', NULL, 2, NULL, NULL),
(462, '<p>The value of variable x after executing the following code will be:</p>\r\n<p><strong>val = -200;</strong></p>\r\n<p><strong>x = (val &gt;= 0 ) ? val : -val</strong></p>', '120m3', 1, '2014-11-10 11:12:33', '2014-11-10 11:12:33', 2, 3, 3, 3, 0, 46, 'Operators	expressions', NULL, 2, NULL, NULL),
(463, '<p>The #undef directive removes a name previously defined with #define directive</p>', '121m3', 1, '2014-11-11 05:08:53', '2014-11-11 05:08:53', 1, 3, 1, 1, 0, 45, 'Macros', NULL, 2, NULL, NULL),
(464, '<p>The &lsquo;C&rsquo; program can have only one command line argument</p>', '122m3', 1, '2014-11-11 05:09:40', '2014-11-11 05:09:40', 1, 3, 1, 1, 0, 44, 'Argument', NULL, 2, NULL, NULL),
(465, '<p>The goto statement causes control to go to a function</p>', '123m3', 1, '2014-11-11 05:10:19', '2014-11-11 05:10:19', 1, 3, 1, 1, 0, 48, 'Goto', NULL, 2, NULL, NULL),
(466, '<p>If you don&rsquo;t use a return type in the function declaration, the compiler assumes that the function does not return anything.</p>', '124m3', 1, '2014-11-11 05:10:55', '2014-11-11 05:10:55', 1, 3, 1, 1, 0, 43, 'Functions', NULL, 2, NULL, NULL),
(467, '<p>An array element is accessed using the dot operator</p>', '125m3', 1, '2014-11-11 05:11:59', '2014-11-11 05:11:59', 1, 3, 1, 1, 0, 42, 'Arrays', NULL, 2, NULL, NULL),
(468, '<p>Continue statement skips all subsequent statements in the loop body and triggers the next iteration for the loop.</p>', '126m3', 1, '2014-11-11 05:21:58', '2014-11-11 05:21:58', 1, 3, 2, 3, 0, 48, 'Continue, loop', NULL, 2, NULL, NULL),
(469, '<p>The strcmpi function compares two strings irrespective of case.</p>', '127m3', 1, '2014-11-11 05:24:33', '2014-11-11 05:24:33', 1, 3, 1, 1, 0, 51, 'String, Compare, Case, insensitive', NULL, 2, NULL, NULL),
(470, '<p>For loop allows a statement or compound statement to be executed at least once.</p>', '128m3', 1, '2014-11-11 05:25:21', '2014-11-11 05:25:21', 1, 3, 1, 1, 0, 48, 'For', NULL, 2, NULL, NULL),
(471, '<p>The fread function reads formatted data from a stream.</p>', '129m3', 1, '2014-11-11 05:26:10', '2014-11-11 05:26:10', 1, 3, 1, 1, 0, 58, 'Files, Read, steam', NULL, 2, NULL, NULL),
(472, '<p>In &lsquo;C&rsquo;, unsigned int can have maximum range of values between 0 to 65535.</p>', '130m3', 1, '2014-11-11 05:29:04', '2014-11-11 05:29:04', 1, 3, 1, 1, 0, 45, 'data types', NULL, 2, NULL, NULL),
(473, '<p>The expression 11%3 evaluates to __________.</p>', '131m3', 1, '2014-11-11 06:25:36', '2014-11-11 06:25:36', 4, 3, 1, 1, 0, 45, 'Operators, modulus', NULL, 2, NULL, NULL),
(474, '<p>In a 32 bit system float data type will occupy __________ bytes.</p>', '132m3', 1, '2014-11-11 06:59:04', '2014-11-11 06:59:04', 4, 3, 1, 1, 0, 45, 'data types, float', NULL, 2, NULL, NULL),
(475, '<p>The closing brace of a structure is followed by __________.</p>', '133m3', 1, '2014-11-11 07:00:00', '2014-11-11 07:00:00', 4, 3, 1, 1, 0, 45, 'Data type, Structure', NULL, 2, NULL, NULL),
(476, '<p>A function that does not return anything has return type __________.</p>', '134m3', 1, '2014-11-11 07:01:58', '2014-11-11 07:01:58', 4, 3, 1, 1, 0, 45, 'Data type, Structure', NULL, 2, NULL, NULL),
(477, '<p>A(n) __________ cannot be passed to a function as an argument.</p>', '135m3', 1, '2014-11-11 07:03:51', '2014-11-11 07:03:51', 4, 3, 1, 1, 0, 44, 'header, argument', NULL, 2, NULL, NULL),
(478, '<p>An instruction to the compiler to perform an action at compile time is called __________.</p>', '136m3', 1, '2014-11-11 07:04:46', '2014-11-11 07:04:46', 4, 3, 1, 1, 0, 45, 'Macro', NULL, 2, NULL, NULL),
(479, '<p>__________ is an example of derived data type.</p>', '137m3', 1, '2014-11-11 07:06:11', '2014-11-11 07:06:11', 4, 3, 1, 1, 0, 45, 'data types', NULL, 2, NULL, NULL),
(480, '<p>A binary digit is called a</p>', '1M1', 1, '2014-11-13 07:15:11', '2014-11-13 07:15:11', 2, 1, 1, 1, 0, 3, 'Binary Digit', NULL, 2, NULL, NULL),
(481, '<p>One KB implies</p>', '2M1', 1, '2014-11-13 07:16:17', '2014-11-13 07:16:17', 2, 1, 1, 1, 0, 3, 'KB', NULL, 2, NULL, NULL),
(482, '<p>A parallel port is used to</p>', '3m1', 1, '2014-11-13 07:17:26', '2014-11-13 07:17:26', 2, 1, 1, 1, 0, 4, 'Parallel Port', 1, 2, NULL, NULL),
(483, '<p>Hard copy of a document can be obtained from</p>', '4m1', 1, '2014-11-13 07:18:23', '2014-11-13 07:18:23', 2, 1, 1, 1, 0, 3, 'Hard copy', NULL, 2, NULL, NULL),
(484, '<p>Disadvantage of RAM is</p>', '5m1', 1, '2014-11-13 07:19:26', '2014-11-13 07:19:26', 2, 1, 1, 1, 0, 4, 'RAM', 1, 2, NULL, NULL),
(485, '<p>The MICR is a device used to read characters in the form of</p>', '6m1', 1, '2014-11-13 07:38:58', '2014-11-13 07:38:58', 2, 1, 1, 1, 0, 3, 'MICR', NULL, 2, NULL, NULL),
(486, '<p>Which one of the following is not an impact printer</p>', '7m1', 1, '2014-11-13 07:40:03', '2014-11-13 07:40:03', 2, 1, 1, 1, 0, 4, 'Impact printer', 1, 2, NULL, NULL),
(487, '<p>Find the odd one out:</p>', '8m1', 1, '2014-11-13 07:41:17', '2014-11-13 07:41:17', 2, 1, 1, 1, 0, 11, 'Fortran, Pascal, cobol', NULL, 2, NULL, NULL),
(488, '<p>What is the short cut key for slide show in Power Point</p>', '9m1', 1, '2014-11-13 07:42:30', '2014-11-13 07:42:30', 2, 1, 1, 1, 0, 21, 'Slide Show', NULL, 2, NULL, NULL),
(489, '<p>Find the odd one out</p>', '10m1', 1, '2014-11-13 07:44:23', '2014-11-13 07:44:23', 2, 1, 1, 1, 0, 20, 'Word, Excel, access', NULL, 2, NULL, NULL),
(490, '<p>The contents of hard disk are lost when the PC is switched of</p>', '11m1', 1, '2014-11-13 07:45:04', '2014-11-13 07:45:04', 1, 1, 1, 1, 0, 4, 'Hard disk', 1, 2, NULL, NULL),
(491, '<p>The data or characters are represented in hexadecimal form in a computer</p>', '12m1', 1, '2014-11-13 07:50:48', '2014-11-13 07:50:48', 1, 1, 1, 1, 0, 11, 'hexadecimal', NULL, 2, NULL, NULL),
(492, '<p>Compiler is a software</p>', '13m1', 1, '2014-11-13 07:53:20', '2014-11-13 07:53:20', 1, 1, 1, 1, 0, 11, 'Compiler', NULL, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `oaes_item_type`
--

CREATE TABLE IF NOT EXISTS `oaes_item_type` (
  `oaes_item_type_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type_desc` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`oaes_item_type_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Dumping data for table `oaes_item_type`
--

INSERT INTO `oaes_item_type` (`oaes_item_type_id`, `type_name`, `type_desc`, `created_at`, `updated_at`) VALUES
(1, 'True / False', 'True / False', '0000-00-00 00:00:00', NULL),
(2, 'Multiple Choice Question', 'Multiple Choice Question', '0000-00-00 00:00:00', NULL),
(3, 'Match the Following', 'Match the Following', '0000-00-00 00:00:00', NULL),
(4, 'Fill in the Blanks', 'Fill in the Blanks', '0000-00-00 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `oaes_keywords`
--

CREATE TABLE IF NOT EXISTS `oaes_keywords` (
  `oaes_Keywords_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `keyword` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`oaes_Keywords_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `oaes_keywords`
--

INSERT INTO `oaes_keywords` (`oaes_Keywords_id`, `keyword`, `created_at`, `updated_at`) VALUES
(1, 'Topic 1', '0000-00-00 00:00:00', '2014-09-08 04:25:47'),
(2, 'Topic 2', '0000-00-00 00:00:00', '2014-09-08 04:25:47');

-- --------------------------------------------------------

--
-- Table structure for table `oaes_knowledge_category`
--

CREATE TABLE IF NOT EXISTS `oaes_knowledge_category` (
  `oaes_knowledge_category_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `knowledge_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`oaes_knowledge_category_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Dumping data for table `oaes_knowledge_category`
--

INSERT INTO `oaes_knowledge_category` (`oaes_knowledge_category_id`, `knowledge_name`, `created_at`, `updated_at`) VALUES
(1, 'Factual', '0000-00-00 00:00:00', NULL),
(2, 'Conceptual', '0000-00-00 00:00:00', NULL),
(3, 'Procedural', '0000-00-00 00:00:00', NULL),
(4, 'Meta Cognitive', '0000-00-00 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `oaes_mchq`
--

CREATE TABLE IF NOT EXISTS `oaes_mchq` (
  `oaes_mchq_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mchq_text` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mchq_mark` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  `oaes_item_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`oaes_mchq_id`),
  KEY `oaes_mchq_oaes_item_id_foreign` (`oaes_item_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

-- --------------------------------------------------------

--
-- Table structure for table `oaes_mcq`
--

CREATE TABLE IF NOT EXISTS `oaes_mcq` (
  `oaes_mcq_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mcq_text` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mcq_mark` int(11) NOT NULL,
  `oaes_item_id` int(10) unsigned NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`oaes_mcq_id`),
  KEY `oaes_mcq_oaes_item_id_foreign` (`oaes_item_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=261 ;

--
-- Dumping data for table `oaes_mcq`
--

INSERT INTO `oaes_mcq` (`oaes_mcq_id`, `mcq_text`, `mcq_mark`, `oaes_item_id`, `created_at`, `updated_at`) VALUES
(21, 'Will print x = 10', 0, 343, '2014-11-10 05:58:14', '2014-11-10 05:58:14'),
(22, 'Will give compilation error', 0, 343, '2014-11-10 05:58:14', '2014-11-10 05:58:14'),
(23, 'Will give runtime error', 0, 343, '2014-11-10 05:58:14', '2014-11-10 05:58:14'),
(24, 'Will print x = 20', 100, 343, '2014-11-10 05:58:14', '2014-11-10 05:58:14'),
(25, '1 byte', 0, 344, '2014-11-10 06:01:12', '2014-11-10 06:01:12'),
(26, '2 bytes', 0, 344, '2014-11-10 06:01:12', '2014-11-10 06:01:12'),
(27, '4 bytes', 100, 344, '2014-11-10 06:01:12', '2014-11-10 06:01:12'),
(28, '7 bytes', 0, 344, '2014-11-10 06:01:12', '2014-11-10 06:01:12'),
(29, 'x = x – 1', 0, 345, '2014-11-10 06:03:41', '2014-11-10 06:03:41'),
(30, 'x - = 1', 0, 345, '2014-11-10 06:03:41', '2014-11-10 06:03:41'),
(31, 'x - -', 0, 345, '2014-11-10 06:03:41', '2014-11-10 06:03:41'),
(32, 'x = - 1', 100, 345, '2014-11-10 06:03:41', '2014-11-10 06:03:41'),
(33, '91/13', 0, 346, '2014-11-10 06:11:39', '2014-11-10 06:11:39'),
(34, '91/14', 0, 346, '2014-11-10 06:11:39', '2014-11-10 06:11:39'),
(35, '105/14', 0, 346, '2014-11-10 06:11:39', '2014-11-10 06:11:39'),
(36, '105/15', 100, 346, '2014-11-10 06:11:39', '2014-11-10 06:11:39'),
(37, '– 3	', 0, 347, '2014-11-10 06:13:42', '2014-11-10 06:13:42'),
(38, '– 2	', 0, 347, '2014-11-10 06:13:42', '2014-11-10 06:13:42'),
(39, '2', 100, 347, '2014-11-10 06:13:42', '2014-11-10 06:13:42'),
(40, '3', 0, 347, '2014-11-10 06:13:42', '2014-11-10 06:13:42'),
(41, '6', 0, 348, '2014-11-10 06:14:56', '2014-11-10 06:14:56'),
(42, '5', 0, 348, '2014-11-10 06:14:56', '2014-11-10 06:14:56'),
(43, '1', 100, 348, '2014-11-10 06:14:56', '2014-11-10 06:14:56'),
(44, '0', 0, 348, '2014-11-10 06:14:56', '2014-11-10 06:14:56'),
(45, '61', 0, 349, '2014-11-10 06:16:18', '2014-11-10 06:16:18'),
(46, '60', 0, 349, '2014-11-10 06:16:18', '2014-11-10 06:16:18'),
(47, '59', 100, 349, '2014-11-10 06:16:18', '2014-11-10 06:16:18'),
(48, '1', 0, 349, '2014-11-10 06:16:18', '2014-11-10 06:16:18'),
(49, 'This cannot be initialized.', 0, 350, '2014-11-10 06:19:22', '2014-11-10 06:19:22'),
(50, 'This is initialized once at the commencement of execution and cannot be changed at run time.', 0, 350, '2014-11-10 06:19:22', '2014-11-10 06:19:22'),
(51, 'This retains its value through the life of the program.', 100, 350, '2014-11-10 06:19:22', '2014-11-10 06:19:22'),
(52, 'This is same as an automatic variable but is placed at the head of a program.', 0, 350, '2014-11-10 06:19:22', '2014-11-10 06:19:22'),
(53, '25, 25, 25', 0, 351, '2014-11-10 06:24:56', '2014-11-10 06:24:56'),
(54, '25, 55, 25	', 0, 351, '2014-11-10 06:24:56', '2014-11-10 06:24:56'),
(55, '25, 55, 25', 100, 351, '2014-11-10 06:24:56', '2014-11-10 06:24:56'),
(56, 'None of the above', 0, 351, '2014-11-10 06:24:56', '2014-11-10 06:24:56'),
(57, 'b = a', 100, 352, '2014-11-10 06:30:52', '2014-11-10 06:30:52'),
(58, 'b = 2a', 0, 352, '2014-11-10 06:30:52', '2014-11-10 06:30:52'),
(59, 'a = 2b', 0, 352, '2014-11-10 06:30:52', '2014-11-10 06:30:52'),
(60, 'b = a - 1', 0, 352, '2014-11-10 06:30:52', '2014-11-10 06:30:52'),
(61, 'compare two numeric values', 100, 363, '2014-11-10 09:05:28', '2014-11-10 09:05:28'),
(62, 'combine two numeric values', 0, 363, '2014-11-10 09:05:28', '2014-11-10 09:05:28'),
(63, 'compare two Boolean values', 0, 363, '2014-11-10 09:05:28', '2014-11-10 09:05:28'),
(64, 'combine two Boolean values', 0, 363, '2014-11-10 09:05:29', '2014-11-10 09:05:29'),
(65, 'only from innermost loop', 0, 364, '2014-11-10 09:06:34', '2014-11-10 09:06:34'),
(66, 'only from innermost switch', 0, 364, '2014-11-10 09:06:34', '2014-11-10 09:06:34'),
(67, 'from the innermost loop or switch', 100, 364, '2014-11-10 09:06:34', '2014-11-10 09:06:34'),
(68, 'none of the above', 0, 364, '2014-11-10 09:06:34', '2014-11-10 09:06:34'),
(69, '20 20', 100, 365, '2014-11-10 09:07:58', '2014-11-10 09:07:58'),
(70, '19 20', 0, 365, '2014-11-10 09:07:58', '2014-11-10 09:07:58'),
(71, '20 21', 0, 365, '2014-11-10 09:07:58', '2014-11-10 09:07:58'),
(72, '21 22', 0, 365, '2014-11-10 09:07:58', '2014-11-10 09:07:58'),
(73, 'a structure member', 0, 366, '2014-11-10 09:09:12', '2014-11-10 09:09:12'),
(74, 'a structure tag', 0, 366, '2014-11-10 09:09:12', '2014-11-10 09:09:12'),
(75, 'a structure variable', 100, 366, '2014-11-10 09:09:12', '2014-11-10 09:09:12'),
(76, 'the keyword struct', 0, 366, '2014-11-10 09:09:12', '2014-11-10 09:09:12'),
(77, 'make a variable visible to several functions', 0, 367, '2014-11-10 09:10:23', '2014-11-10 09:10:23'),
(78, 'retain a value when a function is not executing', 100, 367, '2014-11-10 09:10:23', '2014-11-10 09:10:23'),
(79, 'conserve memory when a function is not executing', 0, 367, '2014-11-10 09:10:23', '2014-11-10 09:10:23'),
(80, 'None of the above', 0, 367, '2014-11-10 09:10:23', '2014-11-10 09:10:23'),
(81, '#include', 0, 368, '2014-11-10 09:11:25', '2014-11-10 09:11:25'),
(82, '#define', 100, 368, '2014-11-10 09:11:25', '2014-11-10 09:11:25'),
(83, '#undef', 0, 368, '2014-11-10 09:11:25', '2014-11-10 09:11:25'),
(84, '#ifdef', 0, 368, '2014-11-10 09:11:25', '2014-11-10 09:11:25'),
(85, '%i', 0, 369, '2014-11-10 09:12:22', '2014-11-10 09:12:22'),
(86, '%c', 0, 369, '2014-11-10 09:12:22', '2014-11-10 09:12:22'),
(87, '%x', 100, 369, '2014-11-10 09:12:22', '2014-11-10 09:12:22'),
(88, '%u', 0, 369, '2014-11-10 09:12:22', '2014-11-10 09:12:22'),
(89, '500', 0, 370, '2014-11-10 09:13:37', '2014-11-10 09:13:37'),
(90, 'address of ptr', 100, 370, '2014-11-10 09:13:37', '2014-11-10 09:13:37'),
(91, 'contents of ptr', 0, 370, '2014-11-10 09:13:37', '2014-11-10 09:13:37'),
(92, 'None of the above', 0, 370, '2014-11-10 09:13:37', '2014-11-10 09:13:37'),
(93, 'identifier', 0, 371, '2014-11-10 09:14:43', '2014-11-10 09:14:43'),
(94, 'type', 0, 371, '2014-11-10 09:14:43', '2014-11-10 09:14:43'),
(95, 'identifier or type', 100, 371, '2014-11-10 09:14:43', '2014-11-10 09:14:43'),
(96, 'array', 0, 371, '2014-11-10 09:14:43', '2014-11-10 09:14:43'),
(97, '0', 0, 372, '2014-11-10 09:15:35', '2014-11-10 09:15:35'),
(98, '200', 100, 372, '2014-11-10 09:15:35', '2014-11-10 09:15:35'),
(99, '-200', 0, 372, '2014-11-10 09:15:35', '2014-11-10 09:15:35'),
(100, '1', 0, 372, '2014-11-10 09:15:35', '2014-11-10 09:15:35'),
(101, 'ddddd N ( where d represents any digit)', 0, 383, '2014-11-10 09:24:34', '2014-11-10 09:24:34'),
(102, '78 N', 0, 383, '2014-11-10 09:24:34', '2014-11-10 09:24:34'),
(103, '78 garbage', 0, 383, '2014-11-10 09:24:34', '2014-11-10 09:24:34'),
(104, 'compilation error', 100, 383, '2014-11-10 09:24:34', '2014-11-10 09:24:34'),
(105, 'sum = 10', 0, 384, '2014-11-10 09:25:33', '2014-11-10 09:25:33'),
(106, 'sum = 40', 100, 384, '2014-11-10 09:25:33', '2014-11-10 09:25:33'),
(107, 'sum = 60', 0, 384, '2014-11-10 09:25:33', '2014-11-10 09:25:33'),
(108, 'sum = 190', 0, 384, '2014-11-10 09:25:33', '2014-11-10 09:25:33'),
(109, 'x = y', 0, 385, '2014-11-10 09:26:35', '2014-11-10 09:26:35'),
(110, '*x++ = *y++', 100, 385, '2014-11-10 09:26:35', '2014-11-10 09:26:35'),
(111, '(*x)++ = (*y)++	', 0, 385, '2014-11-10 09:26:35', '2014-11-10 09:26:35'),
(112, 'None of the above', 0, 385, '2014-11-10 09:26:35', '2014-11-10 09:26:35'),
(113, '49', 0, 386, '2014-11-10 09:27:30', '2014-11-10 09:27:30'),
(114, '0', 100, 386, '2014-11-10 09:27:30', '2014-11-10 09:27:30'),
(115, '-49', 0, 386, '2014-11-10 09:27:30', '2014-11-10 09:27:30'),
(116, 'None of the above', 0, 386, '2014-11-10 09:27:30', '2014-11-10 09:27:30'),
(117, 'prints x/y = 1', 0, 387, '2014-11-10 09:28:39', '2014-11-10 09:28:39'),
(118, 'prints #e = 1.5', 0, 387, '2014-11-10 09:28:39', '2014-11-10 09:28:39'),
(119, 'prints #x/y = 1', 0, 387, '2014-11-10 09:28:39', '2014-11-10 09:28:39'),
(120, 'None of the above', 100, 387, '2014-11-10 09:28:39', '2014-11-10 09:28:39'),
(121, '-3 and 3', 0, 388, '2014-11-10 09:29:45', '2014-11-10 09:29:45'),
(122, '3 and -5', 100, 388, '2014-11-10 09:29:45', '2014-11-10 09:29:45'),
(123, '3 and -3', 0, 388, '2014-11-10 09:29:45', '2014-11-10 09:29:45'),
(124, '-5 and 3', 0, 388, '2014-11-10 09:29:45', '2014-11-10 09:29:45'),
(125, 'compare two numeric values', 0, 389, '2014-11-10 09:30:54', '2014-11-10 09:30:54'),
(126, 'combine two numeric values', 0, 389, '2014-11-10 09:30:54', '2014-11-10 09:30:54'),
(127, 'compare two Boolean values', 100, 389, '2014-11-10 09:30:54', '2014-11-10 09:30:54'),
(128, 'None of the above', 0, 389, '2014-11-10 09:30:54', '2014-11-10 09:30:54'),
(129, 'Which resides in the memory till the end of the program', 0, 390, '2014-11-10 09:35:32', '2014-11-10 09:35:32'),
(130, 'Which is globally accessible by all functions', 0, 390, '2014-11-10 09:35:32', '2014-11-10 09:35:32'),
(131, 'Which is declared outside the body of any function', 100, 390, '2014-11-10 09:35:32', '2014-11-10 09:35:32'),
(132, 'All of the above', 0, 390, '2014-11-10 09:35:32', '2014-11-10 09:35:32'),
(133, 'No two labels may be identical', 100, 391, '2014-11-10 09:36:38', '2014-11-10 09:36:38'),
(134, 'switch statement cannot have more than three labels', 0, 391, '2014-11-10 09:36:38', '2014-11-10 09:36:38'),
(135, 'case label cannot be numbers', 0, 391, '2014-11-10 09:36:38', '2014-11-10 09:36:38'),
(136, 'None of the above', 0, 391, '2014-11-10 09:36:38', '2014-11-10 09:36:38'),
(137, 'pq	', 0, 392, '2014-11-10 09:37:42', '2014-11-10 09:37:42'),
(138, 'xyz', 0, 392, '2014-11-10 09:37:42', '2014-11-10 09:37:42'),
(139, 'syntax error', 100, 392, '2014-11-10 09:37:42', '2014-11-10 09:37:42'),
(140, 'None of the above', 0, 392, '2014-11-10 09:37:42', '2014-11-10 09:37:42'),
(141, 'Linker', 100, 433, '2014-11-10 10:43:43', '2014-11-10 10:43:43'),
(142, 'Loader', 0, 433, '2014-11-10 10:43:43', '2014-11-10 10:43:43'),
(143, 'Code Generator', 0, 433, '2014-11-10 10:43:43', '2014-11-10 10:43:43'),
(144, 'Interpreter', 0, 433, '2014-11-10 10:43:43', '2014-11-10 10:43:43'),
(145, 'sizeof, (type conversion)	', 100, 434, '2014-11-10 10:44:43', '2014-11-10 10:44:43'),
(146, 'short hand operator, &', 0, 434, '2014-11-10 10:44:43', '2014-11-10 10:44:43'),
(147, 'increment(++), >=, !', 0, 434, '2014-11-10 10:44:43', '2014-11-10 10:44:43'),
(148, '==, !=', 0, 434, '2014-11-10 10:44:43', '2014-11-10 10:44:43'),
(149, 'break transfers control out of loop, continue bypasses the remaining statements of loop', 100, 435, '2014-11-10 10:45:39', '2014-11-10 10:45:39'),
(150, 'break bypasses the remaining statements of loop, continue transfers control out of loop', 0, 435, '2014-11-10 10:45:39', '2014-11-10 10:45:39'),
(151, 'both have same function', 0, 435, '2014-11-10 10:45:39', '2014-11-10 10:45:39'),
(152, 'None of the above', 0, 435, '2014-11-10 10:45:39', '2014-11-10 10:45:39'),
(153, '(a/2==0)?pr int f ( “Odd” ) ; :pr int f ( “Even” )', 0, 436, '2014-11-10 10:46:48', '2014-11-10 10:46:48'),
(154, '(a%2==0)?pr int f ( “Odd” ) :pr int f ( “Even” ) ', 0, 436, '2014-11-10 10:46:48', '2014-11-10 10:46:48'),
(155, '(a%2==1)?pr int f ( “Odd” ) :pr int f ( “Even” ) ', 100, 436, '2014-11-10 10:46:49', '2014-11-10 10:46:49'),
(156, '(a/2==1)?pr int f ( “Even” ) :pr int f ( “Odd” ) ', 0, 436, '2014-11-10 10:46:49', '2014-11-10 10:46:49'),
(157, '0', 100, 437, '2014-11-10 10:47:42', '2014-11-10 10:47:42'),
(158, 'Syntax error because of improper initialization', 0, 437, '2014-11-10 10:47:42', '2014-11-10 10:47:42'),
(159, '5', 0, 437, '2014-11-10 10:47:42', '2014-11-10 10:47:42'),
(160, 'Syntax error because of invalid index', 0, 437, '2014-11-10 10:47:42', '2014-11-10 10:47:42'),
(161, 'Infinite 2 2 2 ……', 0, 438, '2014-11-10 10:48:43', '2014-11-10 10:48:43'),
(162, '3 3 3 3', 100, 438, '2014-11-10 10:48:43', '2014-11-10 10:48:43'),
(163, '2 2 2 2', 0, 438, '2014-11-10 10:48:43', '2014-11-10 10:48:43'),
(164, 'Infinite times 4 4 4 …', 0, 438, '2014-11-10 10:48:43', '2014-11-10 10:48:43'),
(165, 'Output is equal', 100, 439, '2014-11-10 10:49:44', '2014-11-10 10:49:44'),
(166, 'Syntax error', 0, 439, '2014-11-10 10:49:44', '2014-11-10 10:49:44'),
(167, 'Error because two pointers cannot be compared', 0, 439, '2014-11-10 10:49:44', '2014-11-10 10:49:44'),
(168, 'Output is unequal', 0, 439, '2014-11-10 10:49:44', '2014-11-10 10:49:44'),
(169, '65535', 100, 440, '2014-11-10 10:50:51', '2014-11-10 10:50:51'),
(170, '32767', 0, 440, '2014-11-10 10:50:51', '2014-11-10 10:50:51'),
(171, '-32767', 0, 440, '2014-11-10 10:50:51', '2014-11-10 10:50:51'),
(172, '-65535', 0, 440, '2014-11-10 10:50:51', '2014-11-10 10:50:51'),
(173, 'create a type of function', 0, 441, '2014-11-10 10:51:58', '2014-11-10 10:51:58'),
(174, 'define the type of function', 0, 441, '2014-11-10 10:51:58', '2014-11-10 10:51:58'),
(175, 'define the type of a variable', 0, 441, '2014-11-10 10:51:58', '2014-11-10 10:51:58'),
(176, 'create a new data type name', 100, 441, '2014-11-10 10:51:58', '2014-11-10 10:51:58'),
(177, 'a++', 0, 442, '2014-11-10 10:53:06', '2014-11-10 10:53:06'),
(178, 'a=a+1', 0, 442, '2014-11-10 10:53:06', '2014-11-10 10:53:06'),
(179, '*a++', 0, 442, '2014-11-10 10:53:06', '2014-11-10 10:53:06'),
(180, '*a[1]', 100, 442, '2014-11-10 10:53:06', '2014-11-10 10:53:06'),
(181, 'compare two numeric values', 100, 453, '2014-11-10 11:00:38', '2014-11-10 11:00:38'),
(182, 'combine two numeric values', 0, 453, '2014-11-10 11:00:38', '2014-11-10 11:00:38'),
(183, 'compare two Boolean values', 0, 453, '2014-11-10 11:00:38', '2014-11-10 11:00:38'),
(184, 'combine two Boolean values', 0, 453, '2014-11-10 11:00:38', '2014-11-10 11:00:38'),
(185, 'only from innermost loop', 0, 454, '2014-11-10 11:01:30', '2014-11-10 11:01:30'),
(186, 'only from innermost switch', 0, 454, '2014-11-10 11:01:30', '2014-11-10 11:01:30'),
(187, 'from the innermost loop or switch', 100, 454, '2014-11-10 11:01:30', '2014-11-10 11:01:30'),
(188, 'None of the above', 0, 454, '2014-11-10 11:01:30', '2014-11-10 11:01:30'),
(189, '20 20', 100, 455, '2014-11-10 11:02:47', '2014-11-10 11:02:47'),
(190, '19 20', 0, 455, '2014-11-10 11:02:48', '2014-11-10 11:02:48'),
(191, '20 21', 0, 455, '2014-11-10 11:02:48', '2014-11-10 11:02:48'),
(192, '21 22', 0, 455, '2014-11-10 11:02:48', '2014-11-10 11:02:48'),
(193, 'a structure member', 0, 456, '2014-11-10 11:04:02', '2014-11-10 11:04:02'),
(194, 'a structure tag', 0, 456, '2014-11-10 11:04:02', '2014-11-10 11:04:02'),
(195, 'a structure variable', 100, 456, '2014-11-10 11:04:02', '2014-11-10 11:04:02'),
(196, 'the keyword struct', 0, 456, '2014-11-10 11:04:02', '2014-11-10 11:04:02'),
(197, 'make a variable visible to several functions', 0, 457, '2014-11-10 11:06:57', '2014-11-10 11:06:57'),
(198, 'retain a value when a function is not executing', 100, 457, '2014-11-10 11:06:57', '2014-11-10 11:06:57'),
(199, 'conserve memory when a function is not executing', 0, 457, '2014-11-10 11:06:57', '2014-11-10 11:06:57'),
(200, 'None of the above', 0, 457, '2014-11-10 11:06:57', '2014-11-10 11:06:57'),
(201, '#include', 0, 458, '2014-11-10 11:08:05', '2014-11-10 11:08:05'),
(202, '#define', 100, 458, '2014-11-10 11:08:05', '2014-11-10 11:08:05'),
(203, '#undef', 0, 458, '2014-11-10 11:08:05', '2014-11-10 11:08:05'),
(204, '#ifdef', 0, 458, '2014-11-10 11:08:05', '2014-11-10 11:08:05'),
(205, '%i', 0, 459, '2014-11-10 11:08:55', '2014-11-10 11:08:55'),
(206, '%c	', 0, 459, '2014-11-10 11:08:55', '2014-11-10 11:08:55'),
(207, '%x', 100, 459, '2014-11-10 11:08:56', '2014-11-10 11:08:56'),
(208, '%u', 0, 459, '2014-11-10 11:08:56', '2014-11-10 11:08:56'),
(209, '500', 0, 460, '2014-11-10 11:09:59', '2014-11-10 11:09:59'),
(210, 'address of ptr', 100, 460, '2014-11-10 11:09:59', '2014-11-10 11:09:59'),
(211, 'contents of ptr', 0, 460, '2014-11-10 11:09:59', '2014-11-10 11:09:59'),
(212, 'None of the above', 0, 460, '2014-11-10 11:09:59', '2014-11-10 11:09:59'),
(213, 'identifier', 0, 461, '2014-11-10 11:11:28', '2014-11-10 11:11:28'),
(214, 'type', 0, 461, '2014-11-10 11:11:28', '2014-11-10 11:11:28'),
(215, 'identifier or type', 100, 461, '2014-11-10 11:11:28', '2014-11-10 11:11:28'),
(216, 'array', 0, 461, '2014-11-10 11:11:28', '2014-11-10 11:11:28'),
(217, '0', 0, 462, '2014-11-10 11:12:33', '2014-11-10 11:12:33'),
(218, '200', 100, 462, '2014-11-10 11:12:33', '2014-11-10 11:12:33'),
(219, '-200', 0, 462, '2014-11-10 11:12:33', '2014-11-10 11:12:33'),
(220, '1', 0, 462, '2014-11-10 11:12:33', '2014-11-10 11:12:33'),
(221, 'character', 0, 480, '2014-11-13 07:15:11', '2014-11-13 07:15:11'),
(222, 'bit	', 100, 480, '2014-11-13 07:15:11', '2014-11-13 07:15:11'),
(223, 'byte', 0, 480, '2014-11-13 07:15:11', '2014-11-13 07:15:11'),
(224, 'all of the above', 0, 480, '2014-11-13 07:15:11', '2014-11-13 07:15:11'),
(225, '1 thousand bytes', 100, 481, '2014-11-13 07:16:17', '2014-11-13 07:16:17'),
(226, '1024 bytes', 0, 481, '2014-11-13 07:16:17', '2014-11-13 07:16:17'),
(227, '1024 bits', 0, 481, '2014-11-13 07:16:17', '2014-11-13 07:16:17'),
(228, '100 bits', 0, 481, '2014-11-13 07:16:17', '2014-11-13 07:16:17'),
(229, 'control a printer', 100, 482, '2014-11-13 07:17:26', '2014-11-13 07:17:26'),
(230, 'control a keyboard', 0, 482, '2014-11-13 07:17:26', '2014-11-13 07:17:26'),
(231, 'control a mouse', 0, 482, '2014-11-13 07:17:26', '2014-11-13 07:17:26'),
(232, 'variety of purpose', 0, 482, '2014-11-13 07:17:26', '2014-11-13 07:17:26'),
(233, 'Laser Printer', 100, 483, '2014-11-13 07:18:23', '2014-11-13 07:18:23'),
(234, 'Card reader', 0, 483, '2014-11-13 07:18:23', '2014-11-13 07:18:23'),
(235, 'CRT', 0, 483, '2014-11-13 07:18:23', '2014-11-13 07:18:23'),
(236, 'Paper tape', 0, 483, '2014-11-13 07:18:23', '2014-11-13 07:18:23'),
(237, 'Fast speed', 0, 484, '2014-11-13 07:19:26', '2014-11-13 07:19:26'),
(238, 'High cost', 0, 484, '2014-11-13 07:19:26', '2014-11-13 07:19:26'),
(239, 'Inaccuracy', 0, 484, '2014-11-13 07:19:26', '2014-11-13 07:19:26'),
(240, 'None of the above', 100, 484, '2014-11-13 07:19:26', '2014-11-13 07:19:26'),
(241, 'Electrical pulses in wires', 0, 485, '2014-11-13 07:38:58', '2014-11-13 07:38:58'),
(242, 'Punched holes in card', 100, 485, '2014-11-13 07:38:58', '2014-11-13 07:38:58'),
(243, 'Magnetic ink on paper', 0, 485, '2014-11-13 07:38:58', '2014-11-13 07:38:58'),
(244, 'None of the above', 0, 485, '2014-11-13 07:38:58', '2014-11-13 07:38:58'),
(245, 'Daisy Wheel', 100, 486, '2014-11-13 07:40:03', '2014-11-13 07:40:03'),
(246, 'Dot-matrix printer', 0, 486, '2014-11-13 07:40:03', '2014-11-13 07:40:03'),
(247, 'Chain printer', 0, 486, '2014-11-13 07:40:03', '2014-11-13 07:40:03'),
(248, 'Laser printer', 0, 486, '2014-11-13 07:40:04', '2014-11-13 07:40:04'),
(249, 'Fortran', 0, 487, '2014-11-13 07:41:17', '2014-11-13 07:41:17'),
(250, 'Pascal', 0, 487, '2014-11-13 07:41:17', '2014-11-13 07:41:17'),
(251, 'Machine language', 100, 487, '2014-11-13 07:41:17', '2014-11-13 07:41:17'),
(252, 'Cobol', 0, 487, '2014-11-13 07:41:17', '2014-11-13 07:41:17'),
(253, 'F1', 0, 488, '2014-11-13 07:42:30', '2014-11-13 07:42:30'),
(254, 'F3', 0, 488, '2014-11-13 07:42:30', '2014-11-13 07:42:30'),
(255, 'F5', 100, 488, '2014-11-13 07:42:30', '2014-11-13 07:42:30'),
(256, 'F7', 0, 488, '2014-11-13 07:42:30', '2014-11-13 07:42:30'),
(257, 'Norton', 100, 489, '2014-11-13 07:44:23', '2014-11-13 07:44:23'),
(258, 'Word', 0, 489, '2014-11-13 07:44:23', '2014-11-13 07:44:23'),
(259, 'Excel', 0, 489, '2014-11-13 07:44:23', '2014-11-13 07:44:23'),
(260, 'Access', 0, 489, '2014-11-13 07:44:23', '2014-11-13 07:44:23');

-- --------------------------------------------------------

--
-- Table structure for table `oaes_subject`
--

CREATE TABLE IF NOT EXISTS `oaes_subject` (
  `oaes_subject_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `subject_code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `subject_title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`oaes_subject_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Dumping data for table `oaes_subject`
--

INSERT INTO `oaes_subject` (`oaes_subject_id`, `subject_code`, `subject_title`, `created_at`, `updated_at`) VALUES
(1, 'M1-R4', 'IT TOOLS & BUSINESS SYSTEMS', '0000-00-00 00:00:00', NULL),
(2, 'M2-R4', 'INTERNET TECHNOLOGY & WEB DESIGN', '0000-00-00 00:00:00', NULL),
(3, 'M3-R4', 'PROGRAMMING AND PROBLEM SOLVING THROUGH C LANGUAGE', '0000-00-00 00:00:00', NULL),
(4, 'M4.1-R4', 'APPLICATION OF .NET  TECNOLOGY', '0000-00-00 00:00:00', NULL),
(5, 'M4.2-R4', 'INTRODUCTION TO MULTIMEDIA', '0000-00-00 00:00:00', NULL),
(6, 'M4.3-R4', 'INTRODUCTION TO ICT RESOURCES', '0000-00-00 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `oaes_truefalse`
--

CREATE TABLE IF NOT EXISTS `oaes_truefalse` (
  `oaes_mf_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `oaes_item_id` int(10) unsigned NOT NULL,
  `mf_answer` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`oaes_mf_id`),
  KEY `oaes_truefalse_oaes_item_id_foreign` (`oaes_item_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=181 ;

--
-- Dumping data for table `oaes_truefalse`
--

INSERT INTO `oaes_truefalse` (`oaes_mf_id`, `oaes_item_id`, `mf_answer`, `created_at`, `updated_at`) VALUES
(128, 353, 0, '2014-11-10 06:32:04', '2014-11-10 06:32:04'),
(129, 354, 1, '2014-11-10 06:33:15', '2014-11-10 06:33:15'),
(130, 355, 1, '2014-11-10 06:34:02', '2014-11-10 06:34:02'),
(131, 356, 0, '2014-11-10 06:34:59', '2014-11-10 06:34:59'),
(132, 357, 1, '2014-11-10 06:36:11', '2014-11-10 06:36:11'),
(133, 358, 1, '2014-11-10 07:01:17', '2014-11-10 07:01:17'),
(134, 359, 1, '2014-11-10 07:02:18', '2014-11-10 07:02:18'),
(135, 360, 1, '2014-11-10 07:03:07', '2014-11-10 07:03:07'),
(136, 361, 0, '2014-11-10 07:03:58', '2014-11-10 07:03:58'),
(137, 362, 1, '2014-11-10 07:05:31', '2014-11-10 07:05:31'),
(138, 373, 1, '2014-11-10 09:16:25', '2014-11-10 09:16:25'),
(139, 374, 0, '2014-11-10 09:17:11', '2014-11-10 09:17:11'),
(140, 375, 0, '2014-11-10 09:17:48', '2014-11-10 09:17:48'),
(141, 376, 0, '2014-11-10 09:18:22', '2014-11-10 09:18:22'),
(142, 377, 0, '2014-11-10 09:19:01', '2014-11-10 09:19:01'),
(143, 378, 1, '2014-11-10 09:19:48', '2014-11-10 09:19:48'),
(144, 379, 1, '2014-11-10 09:20:31', '2014-11-10 09:20:31'),
(145, 380, 0, '2014-11-10 09:21:21', '2014-11-10 09:21:21'),
(146, 381, 1, '2014-11-10 09:22:08', '2014-11-10 09:22:08'),
(147, 382, 0, '2014-11-10 09:23:07', '2014-11-10 09:23:07'),
(148, 393, 0, '2014-11-10 09:38:26', '2014-11-10 09:38:26'),
(149, 394, 0, '2014-11-10 09:39:03', '2014-11-10 09:39:03'),
(150, 395, 0, '2014-11-10 09:39:47', '2014-11-10 09:39:47'),
(151, 396, 1, '2014-11-10 09:40:24', '2014-11-10 09:40:24'),
(152, 397, 1, '2014-11-10 09:41:08', '2014-11-10 09:41:08'),
(153, 398, 1, '2014-11-10 09:42:19', '2014-11-10 09:42:19'),
(154, 399, 1, '2014-11-10 09:42:52', '2014-11-10 09:42:52'),
(155, 400, 0, '2014-11-10 09:43:32', '2014-11-10 09:43:32'),
(156, 401, 1, '2014-11-10 09:44:00', '2014-11-10 09:44:00'),
(157, 402, 0, '2014-11-10 09:44:46', '2014-11-10 09:44:46'),
(158, 443, 1, '2014-11-10 10:53:38', '2014-11-10 10:53:38'),
(159, 444, 1, '2014-11-10 10:54:20', '2014-11-10 10:54:20'),
(160, 445, 1, '2014-11-10 10:54:55', '2014-11-10 10:54:55'),
(161, 446, 1, '2014-11-10 10:55:27', '2014-11-10 10:55:27'),
(162, 447, 0, '2014-11-10 10:56:01', '2014-11-10 10:56:01'),
(163, 448, 0, '2014-11-10 10:56:37', '2014-11-10 10:56:37'),
(164, 449, 1, '2014-11-10 10:57:14', '2014-11-10 10:57:14'),
(165, 450, 1, '2014-11-10 10:57:41', '2014-11-10 10:57:41'),
(166, 451, 0, '2014-11-10 10:58:19', '2014-11-10 10:58:19'),
(167, 452, 1, '2014-11-10 10:58:57', '2014-11-10 10:58:57'),
(168, 463, 1, '2014-11-11 05:08:53', '2014-11-11 05:08:53'),
(169, 464, 0, '2014-11-11 05:09:41', '2014-11-11 05:09:41'),
(170, 465, 0, '2014-11-11 05:10:19', '2014-11-11 05:10:19'),
(171, 466, 1, '2014-11-11 05:10:55', '2014-11-11 05:10:55'),
(172, 467, 0, '2014-11-11 05:11:59', '2014-11-11 05:11:59'),
(173, 468, 1, '2014-11-11 05:21:58', '2014-11-11 05:21:58'),
(174, 469, 1, '2014-11-11 05:24:33', '2014-11-11 05:24:33'),
(175, 470, 0, '2014-11-11 05:25:21', '2014-11-11 05:25:21'),
(176, 471, 1, '2014-11-11 05:26:10', '2014-11-11 05:26:10'),
(177, 472, 0, '2014-11-11 05:29:04', '2014-11-11 05:29:04'),
(178, 490, 0, '2014-11-13 07:45:04', '2014-11-13 07:45:04'),
(179, 491, 1, '2014-11-13 07:50:48', '2014-11-13 07:50:48'),
(180, 492, 1, '2014-11-13 07:53:20', '2014-11-13 07:53:20');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `text` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `short_question`
--

CREATE TABLE IF NOT EXISTS `short_question` (
  `short_question_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `short_text` varchar(600) NOT NULL,
  `oaes_item_id` int(10) unsigned NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`short_question_id`),
  KEY `oaes_item_id` (`oaes_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `throttle`
--

CREATE TABLE IF NOT EXISTS `throttle` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `ip_address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `attempts` int(11) NOT NULL DEFAULT '0',
  `suspended` tinyint(1) NOT NULL DEFAULT '0',
  `banned` tinyint(1) NOT NULL DEFAULT '0',
  `last_attempt_at` timestamp NULL DEFAULT NULL,
  `suspended_at` timestamp NULL DEFAULT NULL,
  `banned_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `throttle_user_id_index` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- Dumping data for table `throttle`
--

INSERT INTO `throttle` (`id`, `user_id`, `ip_address`, `attempts`, `suspended`, `banned`, `last_attempt_at`, `suspended_at`, `banned_at`) VALUES
(1, 1, NULL, 0, 0, 0, NULL, NULL, NULL),
(2, 2, NULL, 0, 0, 0, NULL, NULL, NULL),
(3, 3, NULL, 0, 0, 0, NULL, NULL, NULL),
(4, 4, NULL, 0, 0, 0, NULL, NULL, NULL),
(5, 5, NULL, 0, 0, 0, NULL, NULL, NULL),
(6, 6, NULL, 0, 0, 0, NULL, NULL, NULL),
(7, 7, NULL, 0, 0, 0, NULL, NULL, NULL),
(8, 8, NULL, 0, 0, 0, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `permissions` text COLLATE utf8_unicode_ci,
  `activated` tinyint(1) NOT NULL DEFAULT '0',
  `activation_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activated_at` timestamp NULL DEFAULT NULL,
  `last_login` timestamp NULL DEFAULT NULL,
  `persist_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reset_password_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_email_unique` (`email`),
  KEY `users_activation_code_index` (`activation_code`),
  KEY `users_reset_password_code_index` (`reset_password_code`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `permissions`, `activated`, `activation_code`, `activated_at`, `last_login`, `persist_code`, `reset_password_code`, `first_name`, `last_name`, `created_at`, `updated_at`) VALUES
(1, 'admin@localhost.com', '$2y$10$VgOVd9xIGANh4rQnlFyScu.vBZwMbwpjI2LgMitiCUEK00cmuDqwq', NULL, 1, NULL, NULL, '2014-11-06 09:13:47', '$2y$10$OI93P4knfpYG/7EuUfSfbO/7E/AdOhDE7SzPzcHuWyHcpnjINbZQe', NULL, NULL, NULL, '2014-08-20 09:04:43', '2014-11-06 09:13:47'),
(2, 'itemauthor@localhost.com', '$2y$10$VgOVd9xIGANh4rQnlFyScu.vBZwMbwpjI2LgMitiCUEK00cmuDqwq', NULL, 1, NULL, '2014-11-07 09:40:06', '2014-11-13 07:05:35', '$2y$10$.6a.tV04ucl54/DEyu40re2nTv9WUwLrtpuhhAALUAFCEavPVpYLe', NULL, NULL, NULL, '2014-08-20 09:04:43', '2014-11-13 07:05:35'),
(3, 'kanikadey9@gmail.com', '$2y$10$0/URwS0f3o7XuSdQ/yoS1e0dTX/3XyyfJThp80cOLLouL3s.NC53u', NULL, 1, 'mem5JgXKr3I9HIUB5JEwNk2M5lDDpHRXbJxjm59A4c', '2014-08-27 06:33:17', NULL, NULL, NULL, 'rinku', 'dey', '2014-08-25 09:06:22', '2014-08-26 05:08:34'),
(4, 'Vidhya.y93@gmail.com', '$2y$10$xnn5J1XI02UvVvOz2fh1PeY8bbtH.3TGdqRDicVwKwyFH6wb.A0XO', NULL, 1, 'sAugp4YV4M6VIZ93N98LUxJnGExlmIGKbVSVRfTvd5', '2014-08-27 06:33:28', NULL, NULL, NULL, NULL, NULL, '2014-08-25 09:13:27', '2014-08-25 09:13:27'),
(5, 'simha@localhost.com', '$2y$10$F6vvgeRpk5XpIzCZyC/5jOpkG1Wwfi4wkV/F7qr2zkXOMvtOGtnQe', NULL, 1, 'FAClk1G0QkwND5mWRs3jQz0Y1atejnYvJAQtZ4p7VR', NULL, '2014-09-22 04:36:52', '$2y$10$lW3563YvpQvtOcD7d1NU4eup5x0en72n1ivWy/1oZ3USAu18IoPNy', NULL, NULL, NULL, '2014-09-22 04:35:08', '2014-09-22 04:36:52'),
(6, 'ass@hh.com', '$2y$10$kAujMbFDtjhpzMSFc472T.3FYTbaN2Fm6gjGKu1bSOMEnoZ.g.cNG', NULL, 0, 'RhezTdZ3PMWsa2CHlRXhKkc1euVinV2Iqy1aq1oGJM', NULL, NULL, NULL, NULL, NULL, NULL, '2014-10-07 10:52:18', '2014-10-07 10:52:18'),
(8, 'reviewer@localhost.com', '$2y$10$mlrM40S1t9.tzsaG/KRU2e0E87VkHHSerXC78xAV7ZmbRhG2IHH9u', NULL, 1, 'GiFsEsw7dusIEilCn9cFmT5GOJfxyRNMKT3C2B9TLT', NULL, '2014-11-04 05:10:00', '$2y$10$kDFq6B16wMADJmkmLXK7B.bFKnHOvNElBeC5x47ER7.HPbPr25yMa', NULL, NULL, NULL, '2014-10-31 11:18:02', '2014-11-04 05:10:00');

-- --------------------------------------------------------

--
-- Table structure for table `users_groups`
--

CREATE TABLE IF NOT EXISTS `users_groups` (
  `user_id` int(10) unsigned NOT NULL,
  `group_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_id`,`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users_groups`
--

INSERT INTO `users_groups` (`user_id`, `group_id`) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 1),
(7, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ai_item`
--
ALTER TABLE `ai_item`
  ADD CONSTRAINT `ai_item_ai_master_id_foreign` FOREIGN KEY (`ai_master_id`) REFERENCES `ai_master` (`ai_master_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ai_item_oaes_item_id_foreign` FOREIGN KEY (`oaes_item_id`) REFERENCES `oaes_item` (`oaes_item_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ai_master`
--
ALTER TABLE `ai_master`
  ADD CONSTRAINT `ai_master_ap_master_id_foreign` FOREIGN KEY (`ap_master_id`) REFERENCES `ap_master` (`ap_master_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ai_question_paper`
--
ALTER TABLE `ai_question_paper`
  ADD CONSTRAINT `ai_question_paper_ibfk_1` FOREIGN KEY (`ap_view_list_id`) REFERENCES `ap_view_list` (`ap_view_list_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ap_topic`
--
ALTER TABLE `ap_topic`
  ADD CONSTRAINT `ap_topic_oaes_subject_id_foreign` FOREIGN KEY (`oaes_subject_id`) REFERENCES `oaes_subject` (`oaes_subject_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ap_topic_detail`
--
ALTER TABLE `ap_topic_detail`
  ADD CONSTRAINT `ap_topic_detail_ap_item_mark_id_foreign` FOREIGN KEY (`ap_item_mark_id`) REFERENCES `ap_item_mark` (`ap_item_mark_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ap_topic_detail_ap_topic_id_foreign` FOREIGN KEY (`ap_topic_id`) REFERENCES `ap_topic` (`ap_topic_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ap_topic_detail_oaes_cognitive_category_id_foreign` FOREIGN KEY (`oaes_cognitive_category_id`) REFERENCES `oaes_cognitive_category` (`oaes_cognitive_category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ap_topic_detail_oaes_item_type_id_foreign` FOREIGN KEY (`oaes_item_type_id`) REFERENCES `oaes_item_type` (`oaes_item_type_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ap_topic_weight`
--
ALTER TABLE `ap_topic_weight`
  ADD CONSTRAINT `ap_topic_weight_ap_master_id_foreign` FOREIGN KEY (`ap_master_id`) REFERENCES `ap_master` (`ap_master_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ap_topic_weight_ap_topic_id_foreign` FOREIGN KEY (`ap_topic_id`) REFERENCES `ap_topic` (`ap_topic_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ap_unitofstudy`
--
ALTER TABLE `ap_unitofstudy`
  ADD CONSTRAINT `ap_unitofstudy_ibfk_1` FOREIGN KEY (`ap_topic_id`) REFERENCES `ap_topic` (`ap_topic_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ap_view_list`
--
ALTER TABLE `ap_view_list`
  ADD CONSTRAINT `ap_view_list_oaes_subject_id_foreign` FOREIGN KEY (`oaes_subject_id`) REFERENCES `oaes_subject` (`oaes_subject_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `oaes_fill_ups`
--
ALTER TABLE `oaes_fill_ups`
  ADD CONSTRAINT `oaes_fill_ups_oaes_item_id_foreign` FOREIGN KEY (`oaes_item_id`) REFERENCES `oaes_item` (`oaes_item_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `oaes_fill_ups_nolist`
--
ALTER TABLE `oaes_fill_ups_nolist`
  ADD CONSTRAINT `oaes_fill_ups_nolist_ibfk_1` FOREIGN KEY (`oaes_item_id`) REFERENCES `oaes_item` (`oaes_item_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `oaes_item`
--
ALTER TABLE `oaes_item`
  ADD CONSTRAINT `oaes_item_ibfk_5` FOREIGN KEY (`manager_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_ibfk_1` FOREIGN KEY (`ap_topic_id`) REFERENCES `ap_topic` (`ap_topic_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_ibfk_2` FOREIGN KEY (`ap_unitofstudy_id`) REFERENCES `ap_unitofstudy` (`ap_unitofstudy_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_ibfk_3` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_ibfk_4` FOREIGN KEY (`reviewer_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_oaes_cognitive_category_id_foreign` FOREIGN KEY (`oaes_cognitive_category_id`) REFERENCES `oaes_cognitive_category` (`oaes_cognitive_category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_oaes_item_type_id_foreign` FOREIGN KEY (`oaes_item_type_id`) REFERENCES `oaes_item_type` (`oaes_item_type_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_oaes_knowledge_category_id_foreign` FOREIGN KEY (`oaes_knowledge_category_id`) REFERENCES `oaes_knowledge_category` (`oaes_knowledge_category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_oaes_subject_id_foreign` FOREIGN KEY (`oaes_subject_id`) REFERENCES `oaes_subject` (`oaes_subject_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `oaes_mchq`
--
ALTER TABLE `oaes_mchq`
  ADD CONSTRAINT `oaes_mchq_oaes_item_id_foreign` FOREIGN KEY (`oaes_item_id`) REFERENCES `oaes_item` (`oaes_item_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `oaes_mcq`
--
ALTER TABLE `oaes_mcq`
  ADD CONSTRAINT `oaes_mcq_oaes_item_id_foreign` FOREIGN KEY (`oaes_item_id`) REFERENCES `oaes_item` (`oaes_item_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `oaes_truefalse`
--
ALTER TABLE `oaes_truefalse`
  ADD CONSTRAINT `oaes_truefalse_oaes_item_id_foreign` FOREIGN KEY (`oaes_item_id`) REFERENCES `oaes_item` (`oaes_item_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `short_question`
--
ALTER TABLE `short_question`
  ADD CONSTRAINT `short_question_ibfk_1` FOREIGN KEY (`oaes_item_id`) REFERENCES `oaes_item` (`oaes_item_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
