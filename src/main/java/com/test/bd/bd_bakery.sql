-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: bakery_spring
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `bread_type`
--

DROP TABLE IF EXISTS `bread_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bread_type` (
  `bread_id` bigint NOT NULL AUTO_INCREMENT,
  `bread_name` varchar(100) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `weight` decimal(10,2) NOT NULL,
  `production_time` int NOT NULL,
  `flour_id` bigint DEFAULT NULL,
  PRIMARY KEY (`bread_id`),
  KEY `flour_id` (`flour_id`),
  CONSTRAINT `bread_type_ibfk_1` FOREIGN KEY (`flour_id`) REFERENCES `flour` (`flour_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bread_type`
--

LOCK TABLES `bread_type` WRITE;
/*!40000 ALTER TABLE `bread_type` DISABLE KEYS */;
INSERT INTO `bread_type` VALUES (1,'Baguette',2.50,0.50,120,1),(2,'Ciabatta',3.00,0.70,150,2),(3,'Whole Wheat Bread',3.50,0.60,140,2);
/*!40000 ALTER TABLE `bread_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flour`
--

DROP TABLE IF EXISTS `flour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flour` (
  `flour_id` bigint NOT NULL AUTO_INCREMENT,
  `flour_name` varchar(100) NOT NULL,
  `quantity` decimal(10,2) NOT NULL,
  `unit` varchar(50) NOT NULL,
  `last_restocked` date NOT NULL,
  PRIMARY KEY (`flour_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flour`
--

LOCK TABLES `flour` WRITE;
/*!40000 ALTER TABLE `flour` DISABLE KEYS */;
INSERT INTO `flour` VALUES (1,'All-Purpose Flour',200.00,'kg','2024-10-01'),(2,'Whole Wheat Flour',150.00,'kg','2024-09-25'),(3,'Bread Flour',100.00,'kg','2024-10-05');
/*!40000 ALTER TABLE `flour` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-16 18:31:42
