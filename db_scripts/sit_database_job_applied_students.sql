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
-- Table structure for table `job_applied_students`
--

DROP TABLE IF EXISTS `job_applied_students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_applied_students` (
  `application_id` int NOT NULL AUTO_INCREMENT,
  `job_id` int DEFAULT NULL,
  `student_id` int DEFAULT NULL,
  `status_id` int DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `last_modified_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`application_id`),
  KEY `job_id` (`job_id`),
  KEY `student_id` (`student_id`),
  KEY `FK9xe7rsddm0ku4du1uhktwpn0g` (`status_id`),
  CONSTRAINT `FK9xe7rsddm0ku4du1uhktwpn0g` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`),
  CONSTRAINT `job_applied_students_ibfk_1` FOREIGN KEY (`job_id`) REFERENCES `job_post` (`job_id`),
  CONSTRAINT `job_applied_students_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_applied_students`
--

LOCK TABLES `job_applied_students` WRITE;
/*!40000 ALTER TABLE `job_applied_students` DISABLE KEYS */;
INSERT INTO `job_applied_students` VALUES (1,1,2,1,NULL,NULL),(2,1,189,1,'2024-02-02 08:39:38.438018','2024-02-02 08:39:38.438018'),(15,2,2,1,NULL,NULL),(16,3,189,1,'2024-02-04 08:33:50.214157','2024-02-04 08:33:50.214157');
/*!40000 ALTER TABLE `job_applied_students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-04 12:08:10
