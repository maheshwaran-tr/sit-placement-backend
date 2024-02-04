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
-- Table structure for table `staffs`
--

DROP TABLE IF EXISTS `staffs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staffs` (
  `staff_db_id` int NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(10) NOT NULL,
  `staff_name` varchar(100) DEFAULT NULL,
  `department` varchar(10) DEFAULT NULL,
  `date_of_birth` varchar(10) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone_number` varchar(12) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `last_modified_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`staff_db_id`),
  UNIQUE KEY `staff_id` (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staffs`
--

LOCK TABLES `staffs` WRITE;
/*!40000 ALTER TABLE `staffs` DISABLE KEYS */;
INSERT INTO `staffs` VALUES (1,'FD21001','John Doe','CSE','1990-05-15','Male','john.doe@example.com','1234567890',NULL,NULL),(2,'FD21002','Jane Smith','CSD','1985-08-21','Female','jane.smith@example.com','9876543210',NULL,NULL),(3,'FD21003','Bob Johnson','AIDS','1982-12-03','Male','bob.johnson@example.com','5551112222',NULL,NULL),(4,'FD21004','Alice Brown','AGRI','1988-07-10','Female','alice.brown@example.com','1112223333',NULL,NULL),(5,'FD21005','Charlie Wilson','CSE','1995-02-28','Male','charlie.wilson@example.com','7778889999',NULL,NULL),(6,'FD21006','Eva Davis','CSD','1987-09-17','Female','eva.davis@example.com','4443332222',NULL,NULL),(7,'FD21007','David Lee','AIDS','1984-04-11','Male','david.lee@example.com','6665554444',NULL,NULL),(8,'FD21008','Grace Miller','AGRI','1992-11-05','Female','grace.miller@example.com','9990001111',NULL,NULL),(9,'FD21009','Frank White','CSE','1980-06-25','Male','frank.white@example.com','3332221111',NULL,NULL),(10,'FD21010','Helen Taylor','CSD','1998-03-19','Female','helen.taylor@example.com','1239874560',NULL,NULL),(12,'FD24003','ANAND A P','CSD','1990-05-15','Male','anand@gmail.com','9874563210','2024-02-02 09:20:30.300141','2024-02-02 09:20:30.300141'),(14,'FD24004','ARUNINIGO','CSD','1992-11-05','male','arun.inigo@example.com','9990001111','2024-02-04 07:38:14.981989','2024-02-04 07:38:14.981989');
/*!40000 ALTER TABLE `staffs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-04 12:08:09
