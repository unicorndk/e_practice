-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: polyclinic
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(45) NOT NULL,
  `LAST_NAME` varchar(45) NOT NULL,
  `MIDDLE_NAME` varchar(45) NOT NULL,
  `POSITION` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Артур','Коробов','Эдуардович','Интерн'),(2,'Василий','Петренко','Дмитриевич','Врач-инфекционист'),(4,'Роман','Смирнов','Романович','Врач-терапевт'),(5,'Иван','Иванов','Алексеевич','Врач-эндокринолог'),(6,'Андрей','Соловьев','Дмитриевич','Врач-терапевт'),(7,'Виктор','Соловьев','Дмитриевич','Врач-кардиолог'),(8,'Александр','Александров','Егорович','Врач-инфекционист'),(9,'Александр','Смирнов','Романович','Врач-терапевт'),(10,'Виктория','Бузова','Константиновна','Врач-терапевт'),(11,'Наталья','Иванова','Андреевна','Врач-инфекционист'),(12,'Розалия','Мирная','Дмитриевна','Интерн'),(13,'Андрей','Смирнов','Романович','Врач-инфекционист'),(14,'Дарья','Смирнова','Алексеевна','Интерн'),(15,'Ольга','Воронина','Викторовна','Врач-кардиолог'),(16,'Виктор','Крутой','Артемович','Врач-кардиолог'),(17,'Степан','Мирный','Дмитриевич','Врач-эндокринолог'),(18,'Владимир','Путин','Александрович','Врач-инфекционист'),(19,'Любовь','Коршунова','Степановна','Врач-инфекционист'),(20,'Виктория','Панина','Сергеевна','Врач-инфекционист'),(21,'Людмила','Степаненко','Дмитриевна','Врач-кардиолог'),(22,'Виктор','Усов','Усов','Врач-эндокринолог'),(23,'Виктор','Романенко','Сергеевич','Детский врач');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-08  3:14:11
