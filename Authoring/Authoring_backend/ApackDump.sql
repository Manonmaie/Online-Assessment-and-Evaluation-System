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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `out_apack_header`
--

LOCK TABLES `out_apack_header` WRITE;
/*!40000 ALTER TABLE `out_apack_header` DISABLE KEYS */;
INSERT INTO `out_apack_header` VALUES (1,'Nothing','2020-12-01 00:26:30','Author','CREATED',NULL,NULL),(2,'Nothing','2020-12-01 00:39:44','Author','CREATED',NULL,NULL),(3,'Nothing','2020-12-01 00:41:28','Author','CREATED',NULL,NULL);
/*!40000 ALTER TABLE `out_apack_header` ENABLE KEYS */;
UNLOCK TABLES;

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
  `item_text` blob NOT NULL,
  `item_marks` float unsigned NOT NULL,
  `item_type` varchar(255) NOT NULL,
  PRIMARY KEY (`apack1_id`),
  KEY `fk_apack1_apack_header_id` (`apack_header_id`),
  CONSTRAINT `fk_apack1_apack_header_id` FOREIGN KEY (`apack_header_id`) REFERENCES `out_apack_header` (`apack_header_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apack1`
--

LOCK TABLES `apack1` WRITE;
/*!40000 ALTER TABLE `apack1` DISABLE KEYS */;
INSERT INTO `apack1` VALUES (19,3,1,1,1,_binary '[B@3a64a18',1,'McqSingleCorrect'),(20,3,1,3,2,_binary '[B@3046ebd7',1,'McqMultiCorrect'),(21,3,1,2,3,_binary '[B@578e548f',1,'McqSingleCorrect'),(22,3,2,8,4,_binary '[B@7afdc8d3',1,'McqMultiCorrect'),(23,3,2,6,5,_binary '[B@9f893e',1,'True/False'),(24,3,3,4,6,_binary '[B@265f4689',1,'True/False'),(25,3,3,6,7,_binary '[B@31bfa2c4',1,'True/False'),(26,3,3,9,8,_binary '[B@7a5c182a',1,'True/False'),(27,3,3,2,9,_binary '[B@697cb20',1,'McqSingleCorrect');
/*!40000 ALTER TABLE `apack1` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apack2`
--

LOCK TABLES `apack2` WRITE;
/*!40000 ALTER TABLE `apack2` DISABLE KEYS */;
INSERT INTO `apack2` VALUES (41,19,1,1,1,'Collection of related data',1),(42,19,1,1,2,'Collection of data',0),(43,19,1,1,3,'Collection of words',0),(44,19,1,1,4,'Collection of people',0),(45,21,2,3,5,'Primary Key',1),(46,27,2,9,5,'Primary Key',1),(47,21,2,3,6,'Personal Key',0),(48,27,2,9,6,'Personal Key',0),(49,21,2,3,7,'Person Key',0),(50,27,2,9,7,'Person Key',0),(51,21,2,3,8,'Primary Keyword',0),(52,27,2,9,8,'Primary Keyword',0),(53,20,3,2,9,'Foreign Key',0),(54,20,3,2,10,'Foreign Keyword',1),(55,20,3,2,11,'Fashion Key',0),(56,20,3,2,12,'Forward Key',0),(57,26,9,8,1,'True',100),(58,26,9,8,1,'False',0),(59,22,8,4,2,'True',0),(60,22,8,4,2,'False',100);
/*!40000 ALTER TABLE `apack2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-01  0:41:36
