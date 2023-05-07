-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: hanu_hospital
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `bill_line`
--

DROP TABLE IF EXISTS `bill_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_line` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL,
  `bill` bigint DEFAULT NULL,
  `prescription` int unsigned DEFAULT NULL,
  `medical_procedure` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5b9pnyfvfnu2uu4295jfqr010` (`bill`),
  KEY `FKe4sjq8mvbknwj1r3li7ix231e` (`prescription`),
  KEY `FKtqpv982mfeuemd145xcatyitw` (`medical_procedure`),
  CONSTRAINT `FK5b9pnyfvfnu2uu4295jfqr010` FOREIGN KEY (`bill`) REFERENCES `bill` (`id`),
  CONSTRAINT `FKe4sjq8mvbknwj1r3li7ix231e` FOREIGN KEY (`prescription`) REFERENCES `prescription` (`id`),
  CONSTRAINT `FKtqpv982mfeuemd145xcatyitw` FOREIGN KEY (`medical_procedure`) REFERENCES `medical_procedure` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_line`
--

LOCK TABLES `bill_line` WRITE;
/*!40000 ALTER TABLE `bill_line` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_line` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-06 22:46:25
