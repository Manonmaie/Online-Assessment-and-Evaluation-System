-- MySQL dump 10.13  Distrib 8.0.21, for Linux (x86_64)
--
-- Host: localhost    Database: oaes_authoring_db
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
-- Table structure for table `out_qpack_header`
--

DROP TABLE IF EXISTS `out_qpack_header`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `out_qpack_header` (
  `qpack_header_id` int unsigned NOT NULL AUTO_INCREMENT,
  `qpack_desc` varchar(255) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `qpack_status` enum('CREATED','SENT') DEFAULT 'CREATED',
  `qpack_sent_on` datetime DEFAULT NULL,
  `qpack_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`qpack_header_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `out_qpack_header`
--

LOCK TABLES `out_qpack_header` WRITE;
/*!40000 ALTER TABLE `out_qpack_header` DISABLE KEYS */;
INSERT INTO `out_qpack_header` VALUES (1,'Nothing','2020-11-30 13:46:44','Author','CREATED',NULL,NULL),(2,'Nothing','2020-11-30 13:52:10','Author','CREATED',NULL,NULL),(3,'Nothing','2020-11-30 14:50:13','Author','CREATED',NULL,NULL),(4,'Nothing','2020-11-30 14:56:03','Author','CREATED',NULL,NULL),(5,'Nothing','2020-12-01 00:24:54','Author','CREATED',NULL,NULL),(6,'Nothing','2020-12-01 00:43:47','Author','CREATED',NULL,NULL);
/*!40000 ALTER TABLE `out_qpack_header` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qpack1`
--

DROP TABLE IF EXISTS `qpack1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qpack1` (
  `qpack1_id` int unsigned NOT NULL AUTO_INCREMENT,
  `qpack_header_id` int unsigned NOT NULL,
  `qp_id` int unsigned NOT NULL,
  `maximum_marks` int NOT NULL,
  `instruction_id` int unsigned DEFAULT NULL,
  `instruction_text` varchar(255) DEFAULT NULL,
  `duration` int NOT NULL,
  `course_id` int unsigned NOT NULL,
  `course_code` varchar(255) NOT NULL,
  `course_name` varchar(255) NOT NULL,
  `batch_code` varchar(255) NOT NULL,
  PRIMARY KEY (`qpack1_id`),
  UNIQUE KEY `instruction_id` (`instruction_id`),
  KEY `fk_qpack1_qpack_header_id` (`qpack_header_id`),
  CONSTRAINT `fk_qpack1_qpack_header_id` FOREIGN KEY (`qpack_header_id`) REFERENCES `out_qpack_header` (`qpack_header_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qpack1`
--

LOCK TABLES `qpack1` WRITE;
/*!40000 ALTER TABLE `qpack1` DISABLE KEYS */;
INSERT INTO `qpack1` VALUES (36,6,3,25,6,'Exam duration is 1 hr',60,1,'dbms_101','6','batch3'),(37,6,3,25,7,'It has only one section with no negative marking',60,1,'dbms_101','7','batch3'),(38,6,2,50,4,'Exam duration is 2 hrs',120,1,'dbms_101','4','batch2'),(39,6,2,50,5,'It has only one section',120,1,'dbms_101','5','batch2'),(40,6,1,100,1,'Exam duration is 3 hrs',180,1,'dbms_101','1','batch1'),(41,6,1,100,2,'It has two sections',180,1,'dbms_101','2','batch1'),(42,6,1,100,3,'Each section contributes to 50% of the total marks',180,1,'dbms_101','3','batch1');
/*!40000 ALTER TABLE `qpack1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qpack2`
--

DROP TABLE IF EXISTS `qpack2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qpack2` (
  `qpack2_id` int unsigned NOT NULL AUTO_INCREMENT,
  `qpack1_id` int unsigned NOT NULL,
  `qp_id` int unsigned NOT NULL,
  `item_id` int unsigned NOT NULL,
  `qp_item_id` int unsigned NOT NULL,
  `item_text` blob NOT NULL,
  `item_marks` float unsigned NOT NULL,
  `item_type` varchar(255) NOT NULL,
  `cognitive_level` enum('REMEMBER','UNDERSTAND','APPLY','ANALYZE','EVALUATE','CREATE') NOT NULL,
  PRIMARY KEY (`qpack2_id`),
  KEY `fk_qpack2_qpack1_id` (`qpack1_id`),
  CONSTRAINT `fk_qpack2_qpack1_id` FOREIGN KEY (`qpack1_id`) REFERENCES `qpack1` (`qpack1_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qpack2`
--

LOCK TABLES `qpack2` WRITE;
/*!40000 ALTER TABLE `qpack2` DISABLE KEYS */;
INSERT INTO `qpack2` VALUES (46,36,3,4,6,_binary '[B@6aa092ac',1,'True/False','APPLY'),(47,36,3,6,7,_binary '[B@7fbc32ac',1,'True/False','APPLY'),(48,36,3,9,8,_binary '[B@64c86c19',1,'True/False','EVALUATE'),(49,36,3,2,9,_binary '[B@7614cc8e',1,'McqSingleCorrect','UNDERSTAND'),(50,38,2,8,4,_binary '[B@759f3c26',1,'McqMultiCorrect','ANALYZE'),(51,38,2,6,5,_binary '[B@4ad7d20f',1,'True/False','APPLY'),(52,40,1,1,1,_binary '[B@1ff0166f',1,'McqSingleCorrect','UNDERSTAND'),(53,40,1,3,2,_binary '[B@4418b7a',1,'McqMultiCorrect','APPLY'),(54,40,1,2,3,_binary '[B@47ce3e9a',1,'McqSingleCorrect','UNDERSTAND');
/*!40000 ALTER TABLE `qpack2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qpack3`
--

DROP TABLE IF EXISTS `qpack3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qpack3` (
  `qpack3_id` int unsigned NOT NULL AUTO_INCREMENT,
  `qpack2_id` int unsigned NOT NULL,
  `item_id` int unsigned NOT NULL,
  `qp_item_id` int unsigned NOT NULL,
  `item_option_id` int unsigned NOT NULL,
  `option_text` varchar(255) NOT NULL,
  PRIMARY KEY (`qpack3_id`),
  KEY `fk_qpack3_qpack2_id` (`qpack2_id`),
  CONSTRAINT `fk_qpack3_qpack2_id` FOREIGN KEY (`qpack2_id`) REFERENCES `qpack2` (`qpack2_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qpack3`
--

LOCK TABLES `qpack3` WRITE;
/*!40000 ALTER TABLE `qpack3` DISABLE KEYS */;
INSERT INTO `qpack3` VALUES (101,52,1,1,1,'Collection of related data'),(102,52,1,1,2,'Collection of data'),(103,52,1,1,3,'Collection of words'),(104,52,1,1,4,'Collection of people'),(105,54,2,3,5,'Primary Key'),(106,49,2,9,5,'Primary Key'),(107,54,2,3,6,'Personal Key'),(108,49,2,9,6,'Personal Key'),(109,54,2,3,7,'Person Key'),(110,49,2,9,7,'Person Key'),(111,54,2,3,8,'Primary Keyword'),(112,49,2,9,8,'Primary Keyword'),(113,53,3,2,9,'Foreign Key'),(114,53,3,2,10,'Foreign Keyword'),(115,53,3,2,11,'Fashion Key'),(116,53,3,2,12,'Forward Key'),(117,50,8,4,1,'True'),(118,50,8,4,1,'False'),(119,48,9,8,2,'True'),(120,48,9,8,2,'False');
/*!40000 ALTER TABLE `qpack3` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-01  0:43:58
