-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: db_phone
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `tb_phone`
--

DROP TABLE IF EXISTS `tb_phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_phone` (
  `ID_Phone` varchar(10) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Price` int DEFAULT NULL,
  `Amount` double DEFAULT NULL,
  `Color` varchar(45) DEFAULT NULL,
  `Company` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_Phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_phone`
--

LOCK TABLES `tb_phone` WRITE;
/*!40000 ALTER TABLE `tb_phone` DISABLE KEYS */;
INSERT INTO `tb_phone` VALUES ('p01','iPhone 8 Plus - Black',6,10,'Black','Apple'),('p02','iPhone 8 Plus - White',7,9,'White','Apple'),('p03','iPhone 11 - Blue',11,12,'Trắng','Apple'),('p04','Samsung s22 Ultra - White',15,8,'Trắng','Samsung'),('p05','Samsung s22 Ultra - White',17,15,'Trắng','Samsung'),('p06','Poco Phone F1',5,10,'Đen','Xiaomi'),('p07','Iphone 12',20,8,'Đen','All');
/*!40000 ALTER TABLE `tb_phone` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-22 14:03:45
