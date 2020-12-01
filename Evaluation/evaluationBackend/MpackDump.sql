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
-- Table structure for table `out_mpack_header`
--

DROP TABLE IF EXISTS `out_mpack_header`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `out_mpack_header` (
  `mpack_header_id` int unsigned NOT NULL AUTO_INCREMENT,
  `mpack_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `created_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mpack_status` enum('CREATED','SENT') COLLATE utf8_bin DEFAULT NULL,
  `mpack_sent_on` datetime DEFAULT NULL,
  `mpack_path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`mpack_header_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `out_mpack_header`
--

LOCK TABLES `out_mpack_header` WRITE;
/*!40000 ALTER TABLE `out_mpack_header` DISABLE KEYS */;
INSERT INTO `out_mpack_header` VALUES (1,'Nothing','2020-12-01 16:01:42','Author','CREATED',NULL,NULL),(2,'Nothing','2020-12-01 16:02:15','Author','CREATED',NULL,NULL),(3,'Nothing','2020-12-01 16:02:52','Author','CREATED',NULL,NULL);
/*!40000 ALTER TABLE `out_mpack_header` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mpack1`
--

LOCK TABLES `mpack1` WRITE;
/*!40000 ALTER TABLE `mpack1` DISABLE KEYS */;
INSERT INTO `mpack1` VALUES (7,3,1,100,180),(8,3,2,50,120),(9,3,3,25,60);
/*!40000 ALTER TABLE `mpack1` ENABLE KEYS */;
UNLOCK TABLES;

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
  `item_text` varchar(511) COLLATE utf8_bin NOT NULL,
  `item_marks` float unsigned NOT NULL,
  `item_type` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`mpack2_id`),
  KEY `fk_mpack2_mpack1_id` (`mpack1_id`),
  CONSTRAINT `fk_mpack2_mpack1_id` FOREIGN KEY (`mpack1_id`) REFERENCES `mpack1` (`mpack1_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mpack2`
--

LOCK TABLES `mpack2` WRITE;
/*!40000 ALTER TABLE `mpack2` DISABLE KEYS */;
INSERT INTO `mpack2` VALUES (21,7,1,1,'What is a database?',2,'McqSingleCorrect'),(22,7,1,2,'What is a  PK?',1,'McqMultiCorrect'),(23,7,1,3,'What is a FK?',2,'McqMultiCorrect'),(24,7,1,4,'UK and PK are same.',1,'True/False'),(25,7,1,5,'Uk with no null values is Pk.',2,'True/False'),(26,8,2,6,'What is a database?',2,'McqSingleCorrect'),(27,8,2,7,'What is a  PK?',1,'McqSingleCorrect'),(28,8,2,8,'What is a FK?',2,'McqMultiCorrect'),(29,8,2,9,'UK and PK are same.',1,'True/False'),(30,8,2,10,'Uk with no null values is Pk.',2,'True/False');
/*!40000 ALTER TABLE `mpack2` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mpack3`
--

LOCK TABLES `mpack3` WRITE;
/*!40000 ALTER TABLE `mpack3` DISABLE KEYS */;
INSERT INTO `mpack3` VALUES (3,21,1,1,1,10);
/*!40000 ALTER TABLE `mpack3` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-01 16:02:53
