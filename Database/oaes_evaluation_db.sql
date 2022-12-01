-- MySQL dump 10.13  Distrib 8.0.21, for Linux (x86_64)
--
-- Host: localhost    Database: oaes_evaluation_db
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `apack1`
--

DROP TABLE IF EXISTS `apack1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apack1` (
  `apack1_id` int unsigned NOT NULL AUTO_INCREMENT,
  `apack_header_id` int unsigned NOT NULL,
  `qp_id` int unsigned NOT NULL,
  `item_id` int unsigned NOT NULL,
  `qp_item_id` int unsigned NOT NULL,
  `item_text` varchar(255) NOT NULL,
  `item_marks` float unsigned NOT NULL,
  `item_type` varchar(255) NOT NULL,
  PRIMARY KEY (`apack1_id`),
  KEY `fk_apack1_apack_header_id` (`apack_header_id`),
  CONSTRAINT `fk_apack1_apack_header_id` FOREIGN KEY (`apack_header_id`) REFERENCES `out_apack_header` (`apack_header_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `apack2`
--

DROP TABLE IF EXISTS `apack2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apack2` (
  `apack2_id` int unsigned NOT NULL AUTO_INCREMENT,
  `apack1_id` int unsigned NOT NULL,
  `item_id` int unsigned NOT NULL,
  `qp_item_id` int unsigned NOT NULL,
  `item_option_id` int unsigned NOT NULL,
  `option_text` varchar(255) NOT NULL,
  `option_percentage` int NOT NULL,
  PRIMARY KEY (`apack2_id`),
  KEY `fk_apack2_apack1_id` (`apack1_id`),
  CONSTRAINT `fk_apack2_apack1_id` FOREIGN KEY (`apack1_id`) REFERENCES `apack1` (`apack1_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_action_master`
--

DROP TABLE IF EXISTS `ev_action_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_action_master` (
  `action_id` int unsigned NOT NULL AUTO_INCREMENT,
  `action_name` varchar(255) NOT NULL,
  `module_name` enum('AU','AS','EVAL','EA') DEFAULT NULL,
  PRIMARY KEY (`action_id`),
  UNIQUE KEY `action_name` (`action_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_evaluator`
--

DROP TABLE IF EXISTS `ev_evaluator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_evaluator` (
  `evaluator_id` int unsigned NOT NULL AUTO_INCREMENT,
  `evaluator_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `evaluator_name` varchar(255) NOT NULL,
  `evaluator_password` varchar(255) NOT NULL,
  PRIMARY KEY (`evaluator_id`),
  UNIQUE KEY `evaluator_code` (`evaluator_code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_examinee_batch`
--

DROP TABLE IF EXISTS `ev_examinee_batch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_examinee_batch` (
  `examinee_batch_id` int unsigned NOT NULL AUTO_INCREMENT,
  `status` enum('PENDING','COMPLETED','ABANDONED') DEFAULT 'PENDING',
  PRIMARY KEY (`examinee_batch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_examinee_item_marks`
--

DROP TABLE IF EXISTS `ev_examinee_item_marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_examinee_item_marks` (
  `examinee_item_marks_id` int unsigned NOT NULL AUTO_INCREMENT,
  `examinee_item_marks` float NOT NULL,
  `examinee_batch_id` int unsigned DEFAULT NULL,
  `qp_item_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`examinee_item_marks_id`),
  KEY `fk_ev_examinee_item_marks_examinee_batch_id` (`examinee_batch_id`),
  KEY `fk_ev_examinee_item_marks_qp_item_id` (`qp_item_id`),
  CONSTRAINT `fk_ev_examinee_item_marks_examinee_batch_id` FOREIGN KEY (`examinee_batch_id`) REFERENCES `ev_examinee_batch` (`examinee_batch_id`) ON DELETE SET NULL,
  CONSTRAINT `fk_ev_examinee_item_marks_qp_item_id` FOREIGN KEY (`qp_item_id`) REFERENCES `ev_qp_item` (`qp_item_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_item_mcq_options`
--

DROP TABLE IF EXISTS `ev_item_mcq_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_item_mcq_options` (
  `item_mcq_id` int unsigned NOT NULL AUTO_INCREMENT,
  `item_mcq_options_code` varchar(255) DEFAULT NULL,
  `qp_item_id` int unsigned DEFAULT NULL,
  `mcq_option_text` varchar(255) NOT NULL,
  `mcq_option_percentage` float DEFAULT '0',
  PRIMARY KEY (`item_mcq_id`),
  UNIQUE KEY `item_mcq_options_code` (`item_mcq_options_code`),
  KEY `fk_ev_item_mcq_options_qp_item_id` (`qp_item_id`),
  CONSTRAINT `fk_ev_item_mcq_options_qp_item_id` FOREIGN KEY (`qp_item_id`) REFERENCES `ev_qp_item` (`qp_item_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_item_true_false`
--

DROP TABLE IF EXISTS `ev_item_true_false`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_item_true_false` (
  `item_true_false_id` int unsigned NOT NULL AUTO_INCREMENT,
  `item_true_false_code` varchar(255) DEFAULT NULL,
  `qp_item_id` int unsigned DEFAULT NULL,
  `true_percentage` float DEFAULT '0',
  `false_percentage` float DEFAULT '0',
  PRIMARY KEY (`item_true_false_id`),
  UNIQUE KEY `item_true_false_code` (`item_true_false_code`),
  KEY `fk_ev_item_true_false_qp_item_id` (`qp_item_id`),
  CONSTRAINT `fk_ev_item_true_false_qp_item_id` FOREIGN KEY (`qp_item_id`) REFERENCES `ev_qp_item` (`qp_item_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_itemtype_master`
--

DROP TABLE IF EXISTS `ev_itemtype_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_itemtype_master` (
  `itemtype_id` int unsigned NOT NULL AUTO_INCREMENT,
  `itemtype_code` varchar(255) DEFAULT NULL,
  `itemtype_name` varchar(255) NOT NULL,
  `itemtype_category` enum('AUTO','MANUAL') DEFAULT 'MANUAL',
  PRIMARY KEY (`itemtype_id`),
  UNIQUE KEY `itemtype_code` (`itemtype_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_qp_item`
--

DROP TABLE IF EXISTS `ev_qp_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_qp_item` (
  `qp_item_id` int unsigned NOT NULL AUTO_INCREMENT,
  `item_code` varchar(255) DEFAULT NULL,
  `item_text` text NOT NULL,
  `item_marks` float unsigned NOT NULL,
  `item_type` varchar(255) NOT NULL,
  `qp_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`qp_item_id`),
  UNIQUE KEY `item_code` (`item_code`),
  KEY `fk_ev_qp_item_qp_id` (`qp_id`),
  CONSTRAINT `fk_ev_qp_item_qp_id` FOREIGN KEY (`qp_id`) REFERENCES `ev_question_paper` (`qp_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_question_paper`
--

DROP TABLE IF EXISTS `ev_question_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_question_paper` (
  `qp_id` int unsigned NOT NULL AUTO_INCREMENT,
  `qp_code` varchar(255) DEFAULT NULL,
  `maximum_marks` float NOT NULL DEFAULT '100',
  `duration` int NOT NULL DEFAULT '180',
  PRIMARY KEY (`qp_id`),
  UNIQUE KEY `qp_code` (`qp_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_response`
--

DROP TABLE IF EXISTS `ev_response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_response` (
  `response_id` int unsigned NOT NULL AUTO_INCREMENT,
  `response_code` varchar(255) DEFAULT NULL,
  `response_text` varchar(511) NOT NULL,
  `examinee_batch_id` int unsigned DEFAULT NULL,
  `qp_item_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`response_id`),
  UNIQUE KEY `response_code` (`response_code`),
  KEY `fk_ev_response_examinee_batch_id` (`examinee_batch_id`),
  KEY `fk_ev_response_qp_item_id` (`qp_item_id`),
  CONSTRAINT `fk_ev_response_examinee_batch_id` FOREIGN KEY (`examinee_batch_id`) REFERENCES `ev_examinee_batch` (`examinee_batch_id`) ON DELETE SET NULL,
  CONSTRAINT `fk_ev_response_qp_item_id` FOREIGN KEY (`qp_item_id`) REFERENCES `ev_qp_item` (`qp_item_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_response_mcq`
--

DROP TABLE IF EXISTS `ev_response_mcq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_response_mcq` (
  `response_mcq_id` int unsigned NOT NULL AUTO_INCREMENT,
  `response_mcq_code` varchar(255) DEFAULT NULL,
  `response_text` varchar(511) NOT NULL,
  `response_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`response_mcq_id`),
  UNIQUE KEY `response_mcq_code` (`response_mcq_code`),
  KEY `fk_ev_response_mcq_response_id` (`response_id`),
  CONSTRAINT `fk_ev_response_mcq_response_id` FOREIGN KEY (`response_id`) REFERENCES `ev_response` (`response_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_response_true_false`
--

DROP TABLE IF EXISTS `ev_response_true_false`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_response_true_false` (
  `response_true_false_id` int unsigned NOT NULL AUTO_INCREMENT,
  `response_true_false_code` varchar(255) DEFAULT NULL,
  `response_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`response_true_false_id`),
  UNIQUE KEY `response_true_false_code` (`response_true_false_code`),
  KEY `fk_ev_response_true_false_response_id` (`response_id`),
  CONSTRAINT `fk_ev_response_true_false_response_id` FOREIGN KEY (`response_id`) REFERENCES `ev_response` (`response_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_role_action`
--

DROP TABLE IF EXISTS `ev_role_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_role_action` (
  `role_action_id` int unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int unsigned DEFAULT NULL,
  `action_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`role_action_id`),
  KEY `fk_ev_role_action_role_id` (`role_id`),
  KEY `fk_ev_role_action_action_id` (`action_id`),
  CONSTRAINT `fk_ev_role_action_action_id` FOREIGN KEY (`action_id`) REFERENCES `ev_action_master` (`action_id`) ON DELETE SET NULL,
  CONSTRAINT `fk_ev_role_action_role_id` FOREIGN KEY (`role_id`) REFERENCES `ev_role_master` (`role_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_role_master`
--

DROP TABLE IF EXISTS `ev_role_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_role_master` (
  `role_id` int unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  `module_name` enum('AU','AS','EVAL','EA') DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_user`
--

DROP TABLE IF EXISTS `ev_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_user` (
  `user_id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` enum('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ev_user_role`
--

DROP TABLE IF EXISTS `ev_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ev_user_role` (
  `user_role_id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned DEFAULT NULL,
  `role_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `fk_ev_user_role_user_id` (`user_id`),
  KEY `fk_ev_user_role_role_id` (`role_id`),
  CONSTRAINT `fk_ev_user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `ev_role_master` (`role_id`) ON DELETE SET NULL,
  CONSTRAINT `fk_ev_user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `ev_user` (`user_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mpack1`
--

DROP TABLE IF EXISTS `mpack1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mpack1` (
  `mpack1_id` int unsigned NOT NULL AUTO_INCREMENT,
  `mpack_header_id` int unsigned NOT NULL,
  `qp_id` int unsigned NOT NULL,
  `maximum_marks` float NOT NULL,
  `duration` int NOT NULL,
  PRIMARY KEY (`mpack1_id`),
  KEY `fk_mpack1_mpack_header_id` (`mpack_header_id`),
  CONSTRAINT `fk_mpack1_mpack_header_id` FOREIGN KEY (`mpack_header_id`) REFERENCES `out_mpack_header` (`mpack_header_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mpack2`
--

DROP TABLE IF EXISTS `mpack2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mpack2` (
  `mpack2_id` int unsigned NOT NULL AUTO_INCREMENT,
  `mpack1_id` int unsigned NOT NULL,
  `qp_id` int unsigned NOT NULL,
  `qp_item_id` int unsigned NOT NULL,
  `item_text` varchar(511) NOT NULL,
  `item_marks` float unsigned NOT NULL,
  `item_type` varchar(255) NOT NULL,
  PRIMARY KEY (`mpack2_id`),
  KEY `fk_mpack2_mpack1_id` (`mpack1_id`),
  CONSTRAINT `fk_mpack2_mpack1_id` FOREIGN KEY (`mpack1_id`) REFERENCES `mpack1` (`mpack1_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mpack3`
--

DROP TABLE IF EXISTS `mpack3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mpack3` (
  `mpack3_id` int unsigned NOT NULL AUTO_INCREMENT,
  `mpack2_id` int unsigned NOT NULL,
  `qp_id` int unsigned NOT NULL,
  `examinee_batch_id` int unsigned NOT NULL,
  `qp_item_id` int unsigned NOT NULL,
  `examinee_item_marks` float unsigned NOT NULL,
  PRIMARY KEY (`mpack3_id`),
  UNIQUE KEY `qp_item_id` (`qp_item_id`),
  KEY `fk_mpack3_mpack2_id` (`mpack2_id`),
  CONSTRAINT `fk_mpack3_mpack2_id` FOREIGN KEY (`mpack2_id`) REFERENCES `mpack2` (`mpack2_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `out_apack_header`
--

DROP TABLE IF EXISTS `out_apack_header`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `out_apack_header` (
  `apack_header_id` int unsigned NOT NULL AUTO_INCREMENT,
  `apack_desc` varchar(255) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `apack_status` enum('CREATED','SENT') DEFAULT 'CREATED',
  `apack_sent_on` datetime DEFAULT NULL,
  `apack_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`apack_header_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `out_mpack_header`
--

DROP TABLE IF EXISTS `out_mpack_header`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `out_mpack_header` (
  `mpack_header_id` int unsigned NOT NULL AUTO_INCREMENT,
  `mpack_desc` varchar(255) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `mpack_status` enum('CREATED','SENT') DEFAULT NULL,
  `mpack_sent_on` datetime DEFAULT NULL,
  `mpack_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mpack_header_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `out_rpack_header`
--

DROP TABLE IF EXISTS `out_rpack_header`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `out_rpack_header` (
  `rpack_header_id` int unsigned NOT NULL AUTO_INCREMENT,
  `rpack_desc` varchar(255) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `rpack_status` enum('CREATED','SENT') DEFAULT NULL,
  `rpack_sent_on` datetime DEFAULT NULL,
  `rpack_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rpack_header_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rpack1`
--

DROP TABLE IF EXISTS `rpack1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rpack1` (
  `rpack1_id` int unsigned NOT NULL AUTO_INCREMENT,
  `rpack_header_id` int unsigned NOT NULL,
  `qp_id` int unsigned NOT NULL,
  `maximum_marks` float NOT NULL,
  `duration` int NOT NULL,
  `batch_id` int unsigned NOT NULL,
  PRIMARY KEY (`rpack1_id`),
  KEY `fk_rpack1_rpack_header_id` (`rpack_header_id`),
  CONSTRAINT `fk_rpack1_rpack_header_id` FOREIGN KEY (`rpack_header_id`) REFERENCES `out_rpack_header` (`rpack_header_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rpack2`
--

DROP TABLE IF EXISTS `rpack2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rpack2` (
  `rpack2_id` int unsigned NOT NULL AUTO_INCREMENT,
  `rpack1_id` int unsigned NOT NULL,
  `qp_id` int unsigned NOT NULL,
  `qp_item_id` int unsigned NOT NULL,
  `item_text` text NOT NULL,
  `item_marks` float unsigned NOT NULL,
  `item_type` varchar(255) NOT NULL,
  `cognitive_level` enum('REMEMBER','UNDERSTAND','APPLY','ANALYZE','EVALUATE','CREATE') DEFAULT NULL,
  PRIMARY KEY (`rpack2_id`),
  KEY `fk_rpack2_rpack1_id` (`rpack1_id`),
  CONSTRAINT `fk_rpack2_rpack1_id` FOREIGN KEY (`rpack1_id`) REFERENCES `rpack1` (`rpack1_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rpack3`
--

DROP TABLE IF EXISTS `rpack3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rpack3` (
  `rpack3_id` int unsigned NOT NULL AUTO_INCREMENT,
  `rpack2_id` int unsigned NOT NULL,
  `qp_item_id` int unsigned NOT NULL,
  `item_option_id` int unsigned NOT NULL,
  `option_text` varchar(255) NOT NULL,
  PRIMARY KEY (`rpack3_id`),
  KEY `fk_rpack3_rpack2_id` (`rpack2_id`),
  CONSTRAINT `fk_rpack3_rpack2_id` FOREIGN KEY (`rpack2_id`) REFERENCES `rpack2` (`rpack2_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rpack4`
--

DROP TABLE IF EXISTS `rpack4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rpack4` (
  `rpack4_id` int unsigned NOT NULL AUTO_INCREMENT,
  `rpack2_id` int unsigned NOT NULL,
  `qp_id` int unsigned NOT NULL,
  `batch_id` int unsigned NOT NULL,
  `examinee_batch_id` int unsigned NOT NULL,
  `examinee_id` int unsigned NOT NULL,
  `qp_item_id` int unsigned NOT NULL,
  `response_id` int unsigned NOT NULL,
  `response_text` varchar(511) NOT NULL,
  PRIMARY KEY (`rpack4_id`),
  KEY `fk_rpack4_rpack2_id` (`rpack2_id`),
  CONSTRAINT `fk_rpack4_rpack2_id` FOREIGN KEY (`rpack2_id`) REFERENCES `rpack2` (`rpack2_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-30 22:51:10
