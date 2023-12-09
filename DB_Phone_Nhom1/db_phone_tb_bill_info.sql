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
-- Table structure for table `tb_bill_info`
--

DROP TABLE IF EXISTS `tb_bill_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_bill_info` (
  `MaHD` varchar(10) DEFAULT NULL,
  `TenSP` varchar(45) DEFAULT NULL,
  `Soluong` int DEFAULT NULL,
  `Giaban` double DEFAULT NULL,
  `Thanhtien` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_bill_info`
--

LOCK TABLES `tb_bill_info` WRITE;
/*!40000 ALTER TABLE `tb_bill_info` DISABLE KEYS */;
INSERT INTO `tb_bill_info` VALUES ('hd01','iPhone 11 - Blue',1,1300000,1300000),('hd01','Samsung s22 Ultra - White',2,1900000,3800000),('hd01','iPhone 8 Plus - White',3,650000,1950000),('hd01','iPhone 8 Plus - Black',4,650000,2600000),('hd02','iPhone 8 Plus - Black',2,6500,13000),('hd02','iPhone 11 - Blue',1,13000,13000),('hd03','Samsung s22 Ultra - White',1,19000,19000),('hd03','Poco Phone F1',1,7000,7000),('hd03','iPhone 8 Plus - White',2,7500,15000),('hd03','iPhone 8 Plus - Black',2,6700,13400),('hd04','iPhone 8 Plus - Black',2,6700,13400),('hd04','Samsung s22 Ultra - White',2,19000,38000);
/*!40000 ALTER TABLE `tb_bill_info` ENABLE KEYS */;
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
