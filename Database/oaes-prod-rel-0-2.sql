-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 30, 2014 at 10:13 AM
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
(3, 'C1', 1, '0000-00-00 00:00:00', '2014-09-08 04:47:56'),
(4, 'C2', 1, '0000-00-00 00:00:00', '2014-09-08 04:47:56'),
(11, 'C3', 1, '0000-00-00 00:00:00', '2014-09-08 04:47:56'),
(12, 'C4', 1, '0000-00-00 00:00:00', '2014-09-08 04:47:56'),
(13, 'C5', 1, '0000-00-00 00:00:00', '2014-09-08 04:47:56'),
(14, 'C6', 1, '0000-00-00 00:00:00', NULL),
(17, 'C7', 1, '0000-00-00 00:00:00', NULL),
(18, 'C8', 1, '0000-00-00 00:00:00', NULL),
(19, 'C9', 1, '0000-00-00 00:00:00', NULL),
(20, 'C10', 1, '0000-00-00 00:00:00', NULL),
(21, 'C11', 1, '0000-00-00 00:00:00', NULL),
(22, 'C12', 1, '0000-00-00 00:00:00', NULL),
(23, 'C13', 1, '0000-00-00 00:00:00', NULL),
(24, 'C14', 1, '0000-00-00 00:00:00', NULL),
(25, 'C15', 1, '0000-00-00 00:00:00', NULL),
(26, 'C16', 1, '0000-00-00 00:00:00', NULL),
(27, 'C1', 2, '0000-00-00 00:00:00', NULL),
(28, 'C2', 2, '0000-00-00 00:00:00', NULL),
(29, 'C3', 2, '0000-00-00 00:00:00', NULL),
(30, 'C4', 2, '0000-00-00 00:00:00', NULL),
(31, 'C5', 2, '0000-00-00 00:00:00', NULL),
(32, 'C6', 2, '0000-00-00 00:00:00', NULL),
(33, 'C7', 2, '0000-00-00 00:00:00', NULL),
(34, 'C8', 2, '0000-00-00 00:00:00', NULL),
(35, 'C9', 2, '0000-00-00 00:00:00', NULL),
(36, 'C10', 2, '0000-00-00 00:00:00', NULL),
(37, 'C11', 2, '0000-00-00 00:00:00', NULL),
(38, 'C12', 2, '0000-00-00 00:00:00', NULL),
(39, 'C13', 2, '0000-00-00 00:00:00', NULL),
(40, 'C14', 2, '0000-00-00 00:00:00', NULL),
(42, 'C1', 3, '0000-00-00 00:00:00', NULL),
(43, 'C2', 3, '0000-00-00 00:00:00', NULL),
(44, 'C3', 3, '0000-00-00 00:00:00', NULL),
(45, 'C4', 3, '0000-00-00 00:00:00', NULL),
(46, 'C5', 3, '0000-00-00 00:00:00', NULL),
(47, 'C6', 3, '0000-00-00 00:00:00', NULL),
(48, 'C7', 3, '0000-00-00 00:00:00', NULL),
(49, 'C8', 3, '0000-00-00 00:00:00', NULL),
(50, 'C9', 3, '0000-00-00 00:00:00', NULL),
(51, 'C10', 3, '0000-00-00 00:00:00', NULL),
(52, 'C11', 3, '0000-00-00 00:00:00', NULL),
(53, 'C12', 3, '0000-00-00 00:00:00', NULL),
(54, 'C13', 3, '0000-00-00 00:00:00', NULL),
(55, 'C14', 3, '0000-00-00 00:00:00', NULL),
(56, 'C15', 3, '0000-00-00 00:00:00', NULL),
(57, 'C16', 3, '0000-00-00 00:00:00', NULL),
(58, 'C17', 3, '0000-00-00 00:00:00', NULL);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`id`, `name`, `permissions`, `created_at`, `updated_at`) VALUES
(1, 'Item Author', '{"itemauthor":1,"item.view":1,"item.freeze":0,"item.edit":1,"item.add":1,"item.delete":1,"item.export":0,"item.search":1,"item.techreview":0,"item.pedagogicreview":0,"item.checkequivalence":0,"item.Retire":0,"item.tagitem":0,"item.finalpendingitem":0,"item.finalapprovalitem":0,"item.techreject":0,"item.pedreject":0,"assessmentpattern.view":0,"assessmentpattern.edit":0,"assessmentpattern.add":0,"assessmentpattern.delete":0,"assessmentinstrument.view":0,"assessmentinstrument.edit":0,"assessmentinstrument.add":0,"assessmentinstrument.delete":0,"administration.view":0,"administration.edit":0,"administration.add":0,"administration.delete":0,"administration.subjectallocation":0,"administration.techreviewerallocation":0,"administration.createuser":0,"administration.edituser":0,"administration.viewuser":0,"administration.deleteuser":0,"administration.testconstructorallocation":0,"administration.candidateallocation":0,"administration.instrumentallocation":0}', '2014-08-20 09:04:42', '2014-11-18 05:21:31'),
(2, 'Admins', '{"admin":1,"item.view":1,"item.edit":1,"item.add":1,"item.delete":1}', '2014-08-20 09:04:42', '2014-11-13 06:43:16'),
(3, 'Item Reviewer', '{"reviewer":1,"item.view":1,"item.freeze":1,"item.edit":1,"item.add":0,"item.delete":0,"item.export":1,"item.search":1,"item.techreview":0,"item.pedagogicreview":1,"item.checkequivalence":0,"item.Retire":1,"item.tagitem":1,"item.finalpendingitem":1,"item.finalapprovalitem":0,"item.techreject":0,"item.pedreject":1,"assessmentpattern.view":0,"assessmentpattern.edit":0,"assessmentpattern.add":0,"assessmentpattern.delete":0,"assessmentinstrument.view":0,"assessmentinstrument.edit":0,"assessmentinstrument.add":0,"assessmentinstrument.delete":0,"administration.view":0,"administration.edit":0,"administration.add":0,"administration.delete":0,"administration.subjectallocation":0,"administration.techreviewerallocation":0,"administration.createuser":0,"administration.edituser":0,"administration.viewuser":0,"administration.deleteuser":0,"administration.testconstructorallocation":0,"administration.candidateallocation":0,"administration.instrumentallocation":0}', '2014-08-20 09:04:42', '2014-11-14 05:53:13'),
(5, 'Item Bank Manager', '{"itembankmanager":1,"item.view":1,"item.edit":1,"item.add":0,"item.delete":1,"item.export":1,"item.search":1,"item.techreview":0,"item.pedagogicreview":1,"item.checkequivalence":1,"item.Retire":1,"item.tagitem":1,"item.finalpendingitem":0,"item.finalapprovalitem":1,"item.techreject":0,"item.pedreject":0,"assessmentpattern.view":0,"assessmentpattern.edit":0,"assessmentpattern.add":0,"assessmentpattern.delete":0,"assessmentinstrument.view":0,"assessmentinstrument.edit":0,"assessmentinstrument.add":0,"assessmentinstrument.delete":0,"administration.view":0,"administration.edit":0,"administration.add":0,"administration.delete":0,"administration.subjectallocation":0,"administration.techreviewerallocation":0,"administration.createuser":0,"administration.edituser":0,"administration.viewuser":0,"administration.deleteuser":0,"administration.testconstructorallocation":0,"administration.candidateallocation":0,"administration.instrumentallocation":0}', '2014-08-20 09:04:42', '2014-08-20 09:04:42'),
(6, 'Test Constructor', '{"testconstructor":1,"item.view":1,"item.edit":1,"item.add":1,"item.delete":1,"item.export":1,"item.search":0,"item.techreview":0,"item.pedagogicreview":0,"item.checkequivalence":0,"item.Retire":0,"item.tagitem":0,"item.finalpendingitem":0,"item.finalapprovalitem":0,"item.techreject":0,"item.pedreject":0,"assessmentpattern.view":0,"assessmentpattern.edit":0,"assessmentpattern.add":0,"assessmentpattern.delete":0,"assessmentinstrument.view":0,"assessmentinstrument.edit":0,"assessmentinstrument.add":0,"assessmentinstrument.delete":0,"administration.view":0,"administration.edit":0,"administration.add":0,"administration.delete":0,"administration.subjectallocation":0,"administration.techreviewerallocation":0,"administration.createuser":0,"administration.edituser":0,"administration.viewuser":0,"administration.deleteuser":0,"administration.testconstructorallocation":0,"administration.candidateallocation":0,"administration.instrumentallocation":0}', '2014-08-20 09:04:42', '2014-11-17 12:45:56'),
(7, 'Instrument Manager', '{"instrumentanager":1,"item.view":0,"item.edit":0,"item.add":0,"item.delete":0,"item.export":0,"item.search":0,"item.techreview":0,"item.pedagogicreview":0,"item.checkequivalence":0,"item.Retire":0,"item.tagitem":0,"item.finalpendingitem":0,"item.finalapprovalitem":0,"item.techreject":0,"item.pedreject":0,"assessmentpattern.view":0,"assessmentpattern.edit":0,"assessmentpattern.add":0,"assessmentpattern.delete":0,"assessmentinstrument.view":0,"assessmentinstrument.edit":0,"assessmentinstrument.add":0,"assessmentinstrument.delete":0,"administration.view":0,"administration.edit":0,"administration.add":0,"administration.delete":0,"administration.subjectallocation":0,"administration.techreviewerallocation":0,"administration.createuser":0,"administration.edituser":0,"administration.viewuser":0,"administration.deleteuser":0,"administration.testconstructorallocation":0,"administration.candidateallocation":0,"administration.instrumentallocation":0}', '2014-08-20 09:04:42', '2014-11-12 11:50:47'),
(8, 'Controller of examinations', '{"controllerofexaminations":1,"item.view":0,"item.edit":0,"item.add":0,"item.delete":0,"item.export":0,"item.search":0,"item.techreview":0,"item.pedagogicreview":0,"item.checkequivalence":0,"item.Retire":0,"item.tagitem":0,"item.finalpendingitem":0,"item.finalapprovalitem":0,"item.techreject":0,"item.pedreject":0,"assessmentpattern.view":0,"assessmentpattern.edit":0,"assessmentpattern.add":0,"assessmentpattern.delete":0,"assessmentinstrument.view":0,"assessmentinstrument.edit":0,"assessmentinstrument.add":0,"assessmentinstrument.delete":0,"administration.view":0,"administration.edit":0,"administration.add":0,"administration.delete":0,"administration.subjectallocation":0,"administration.techreviewerallocation":0,"administration.createuser":1,"administration.edituser":1,"administration.viewuser":1,"administration.deleteuser":1,"administration.testconstructorallocation":1,"administration.candidateallocation":1,"administration.instrumentallocation":0}', '2014-08-20 09:04:42', '2014-08-20 09:04:42');

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
-- Table structure for table `oaes_action_master`
--

CREATE TABLE IF NOT EXISTS `oaes_action_master` (
  `oaes_action_master_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `action_group` varchar(200) NOT NULL,
  `action_name` varchar(200) NOT NULL,
  `action_code` varchar(200) NOT NULL,
  PRIMARY KEY (`oaes_action_master_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=68 ;

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
  `item_desc` varchar(1024) COLLATE utf8_unicode_ci NOT NULL,
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
  `oaes_tech_review` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oaes_final_review` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `oaes_marks` int(11) NOT NULL DEFAULT '1',
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=424 ;

-- --------------------------------------------------------

--
-- Table structure for table `oaes_item_audit_trail`
--

CREATE TABLE IF NOT EXISTS `oaes_item_audit_trail` (
  `oaes_item_audit_trail_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `oaes_action_master_id` int(10) unsigned DEFAULT NULL,
  `action_timestamp` datetime NOT NULL,
  `action_user_id` int(10) unsigned NOT NULL,
  `oaes_item_id` int(10) unsigned NOT NULL,
  `Remarks` varchar(200) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`oaes_item_audit_trail_id`),
  KEY `oaes_action_master_id` (`oaes_action_master_id`),
  KEY `action_user_id` (`action_user_id`),
  KEY `oaes_item_id` (`oaes_item_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=67 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=47 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=81 ;

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
-- Table structure for table `oaes_subject_user`
--

CREATE TABLE IF NOT EXISTS `oaes_subject_user` (
  `oaes_subject_user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `role` varchar(100) NOT NULL,
  `oaes_subject_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`oaes_subject_user_id`),
  KEY `user_id` (`user_id`),
  KEY `oaes_subject_id` (`oaes_subject_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `oaes_subject_user`
--

INSERT INTO `oaes_subject_user` (`oaes_subject_user_id`, `user_id`, `created_at`, `updated_at`, `role`, `oaes_subject_id`) VALUES
(1, 8, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'Reviewer', 1),
(2, 8, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'Reviewer', 3),
(3, 9, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'Reviewer', 2),
(4, 9, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'Reviewer', 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=159 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=12 ;

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
(8, 8, NULL, 0, 0, 0, NULL, NULL, NULL),
(9, 10, NULL, 0, 0, 0, NULL, NULL, NULL),
(10, 12, NULL, 0, 0, 0, NULL, NULL, NULL),
(11, 9, NULL, 0, 0, 0, NULL, NULL, NULL);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=13 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `permissions`, `activated`, `activation_code`, `activated_at`, `last_login`, `persist_code`, `reset_password_code`, `first_name`, `last_name`, `created_at`, `updated_at`) VALUES
(1, 'admin@localhost.com', '$2y$10$VgOVd9xIGANh4rQnlFyScu.vBZwMbwpjI2LgMitiCUEK00cmuDqwq', NULL, 1, NULL, NULL, '2014-11-25 09:54:24', '$2y$10$VWpTtA4Jiq2f1HKgSCwKweSF3NtyrpTq1Yfax5Ot5PdI10WdkHeuy', NULL, '', '', '2014-08-20 09:04:43', '2014-11-25 09:54:24'),
(2, 'user@localhost.com', '$2y$10$VgOVd9xIGANh4rQnlFyScu.vBZwMbwpjI2LgMitiCUEK00cmuDqwq', NULL, 1, NULL, NULL, '2014-11-28 12:30:48', '$2y$10$kQMVoz05M.TIAoL33uTSEeh08JSg4Vw8wL2WFAHbsFz6FgBu5lSgW', NULL, NULL, NULL, '2014-08-20 09:04:43', '2014-11-28 12:30:48'),
(7, 'itemauthor@localhost.com', '$2y$10$VgOVd9xIGANh4rQnlFyScu.vBZwMbwpjI2LgMitiCUEK00cmuDqwq', NULL, 1, 'h2K7SwrRF8XiutoUH09DBXjPutb2p0lMzLjAbVFY1E', NULL, '2014-11-28 14:41:46', '$2y$10$MpiQkfhTVWvNEXbZwJMr6OFMTrzE/l//58m7Yh7ugo7EoCxIygDC6', NULL, '', '', '2014-10-30 12:16:20', '2014-11-28 14:41:46'),
(8, 'reviewer@localhost.com', '$2y$10$mlrM40S1t9.tzsaG/KRU2e0E87VkHHSerXC78xAV7ZmbRhG2IHH9u', NULL, 1, 'GiFsEsw7dusIEilCn9cFmT5GOJfxyRNMKT3C2B9TLT', NULL, '2014-11-28 14:44:39', '$2y$10$2NdevC7JZVCELl08oxokq./rLvmT4q2YoDsEVHpURmXwlKY64A8Yu', NULL, '', '', '2014-10-31 11:18:02', '2014-11-28 14:44:39'),
(9, 'reviewer1@localhost.com', '$2y$10$mlrM40S1t9.tzsaG/KRU2e0E87VkHHSerXC78xAV7ZmbRhG2IHH9u', NULL, 1, 'GiFsEsw7dusIEilCn9cFmT5GOJfxyRNMKT3C2B9TLT', NULL, '2014-11-27 05:44:15', '$2y$10$9eBfkJ4RrsPW6VlZdNFONeZCuaPdONivSMf5ycoyxHTjH/Evwmc2u', NULL, '', '', '2014-10-31 11:18:02', '2014-11-27 05:44:15'),
(10, 'admin1@localhost.com', '$2y$10$VgOVd9xIGANh4rQnlFyScu.vBZwMbwpjI2LgMitiCUEK00cmuDqwq', NULL, 1, NULL, '2014-11-28 12:36:27', '2014-11-25 09:52:38', '$2y$10$0W5V9rntWQX0t2ftbCwT6.tPHq1yEKoecMaKEPEn/r8.95GIVA0gW', NULL, NULL, NULL, '2014-08-20 09:04:43', '2014-11-25 09:52:38');

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
(7, 1),
(8, 3),
(9, 3),
(10, 1),
(11, 6);

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
  ADD CONSTRAINT `oaes_item_ibfk_1` FOREIGN KEY (`ap_topic_id`) REFERENCES `ap_topic` (`ap_topic_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_ibfk_2` FOREIGN KEY (`ap_unitofstudy_id`) REFERENCES `ap_unitofstudy` (`ap_unitofstudy_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_ibfk_3` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_ibfk_4` FOREIGN KEY (`reviewer_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_ibfk_5` FOREIGN KEY (`manager_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_oaes_cognitive_category_id_foreign` FOREIGN KEY (`oaes_cognitive_category_id`) REFERENCES `oaes_cognitive_category` (`oaes_cognitive_category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_oaes_item_type_id_foreign` FOREIGN KEY (`oaes_item_type_id`) REFERENCES `oaes_item_type` (`oaes_item_type_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_oaes_knowledge_category_id_foreign` FOREIGN KEY (`oaes_knowledge_category_id`) REFERENCES `oaes_knowledge_category` (`oaes_knowledge_category_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_oaes_subject_id_foreign` FOREIGN KEY (`oaes_subject_id`) REFERENCES `oaes_subject` (`oaes_subject_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `oaes_item_audit_trail`
--
ALTER TABLE `oaes_item_audit_trail`
  ADD CONSTRAINT `oaes_item_audit_trail_ibfk_1` FOREIGN KEY (`action_user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_audit_trail_ibfk_2` FOREIGN KEY (`oaes_item_id`) REFERENCES `oaes_item` (`oaes_item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_item_audit_trail_ibfk_3` FOREIGN KEY (`oaes_action_master_id`) REFERENCES `oaes_action_master` (`oaes_action_master_id`) ON DELETE CASCADE ON UPDATE CASCADE;

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
-- Constraints for table `oaes_subject_user`
--
ALTER TABLE `oaes_subject_user`
  ADD CONSTRAINT `oaes_subject_user_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oaes_subject_user_ibfk_2` FOREIGN KEY (`oaes_subject_id`) REFERENCES `oaes_subject` (`oaes_subject_id`) ON DELETE CASCADE ON UPDATE CASCADE;

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
