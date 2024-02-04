-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sit_database
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `job_post`
--

DROP TABLE IF EXISTS `job_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_post` (
  `job_id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(200) NOT NULL,
  `company_details` text,
  `required_skills` text,
  `history_of_arrears` varchar(255) DEFAULT NULL,
  `job_name` varchar(100) DEFAULT NULL,
  `job_description` text,
  `campus_mode` varchar(10) DEFAULT NULL,
  `eligible_10th_mark` double DEFAULT NULL,
  `eligible_12th_mark` double DEFAULT NULL,
  `eligible_cgpa_mark` double DEFAULT NULL,
  `venue` text,
  `interview_date` varchar(20) DEFAULT NULL,
  `interview_time` varchar(10) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `last_modified_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_post`
--

LOCK TABLES `job_post` WRITE;
/*!40000 ALTER TABLE `job_post` DISABLE KEYS */;
INSERT INTO `job_post` VALUES (1,'ZOHO','ZOHO PVT LTD','Problem Solving , Java','0','Software Developer','Software Developer with Problem Solving skills and tech skills','on-campus',40,40,4,'SIT','24-01-2024','12.00 PM',NULL,NULL),(2,'TCS','TCS PVT LTD','Problem Solving, Python, Django','0','Website Developer','Website Developer with Problem Solving skills and tech skills','off-campus',80,80,7,'SIT','24-01-2024','12.00 PM',NULL,NULL),(3,'Test','hshsh','hss','0','hwhah','hwhah','bshs',50,50,5,'chhhb','2024-01-26','4:04 PM',NULL,NULL),(4,'nextwealth','sd','sdf','0','sdff','sdff','off-campus',60,60,6,'sd','2024-02-04','9:54 AM','2024-02-04 09:58:26.190748','2024-02-04 09:58:26.190748');
/*!40000 ALTER TABLE `job_post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-04 12:08:08
