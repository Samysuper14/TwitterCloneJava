-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: users
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `userlog`
--

DROP TABLE IF EXISTS `userlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userlog` (
  `LogNo` int NOT NULL AUTO_INCREMENT,
  `UID` int DEFAULT NULL,
  `Username` varchar(45) DEFAULT NULL,
  `Connection` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`LogNo`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlog`
--

LOCK TABLES `userlog` WRITE;
/*!40000 ALTER TABLE `userlog` DISABLE KEYS */;
INSERT INTO `userlog` VALUES (105,1,'Admin',1),(106,1,'Admin',0),(107,1,'Admin',1),(108,1,'Admin',0),(109,64,'X',1),(110,64,'X',0),(111,64,'X',1),(112,64,'X',0),(113,64,'X',1),(114,64,'X',0),(115,64,'X',1),(116,64,'X',0),(117,65,'conchadelalora',1),(118,65,'conchadelalora',0),(119,65,'conchadelalora',1),(120,64,'X',0),(121,64,'X',0),(122,1,'Admin',1),(123,64,'X',0),(124,64,'X',0),(125,64,'X',1),(126,64,'X',0),(127,64,'X',0),(128,1,'Admin',0),(129,1,'Admin',1),(130,64,'X',0),(131,1,'Admin',0),(132,1,'Admin',1),(133,64,'X',0),(134,1,'Admin',0),(135,1,'Admin',1),(136,64,'X',0),(137,1,'Admin',0),(138,1,'Admin',1),(139,0,'',0),(140,1,'Admin',0),(141,64,'X',1),(142,64,'X',0),(143,64,'X',1),(144,64,'X',0),(145,64,'X',1),(146,64,'X',0),(147,64,'X',1),(148,64,'X',0);
/*!40000 ALTER TABLE `userlog` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-30  5:32:33
