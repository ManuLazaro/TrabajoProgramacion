-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: nbamanager
-- ------------------------------------------------------
-- Server version	8.0.30

DROP DATABASE IF EXISTS nbamanager;
CREATE DATABASE nbamanager;
USE nbamanager;
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
-- Table structure for table `estadisticas`
--

DROP TABLE IF EXISTS `estadisticas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadisticas` (
  `Resultado` int DEFAULT NULL,
  `Dificultad` varchar(45) DEFAULT NULL,
  `nombreUsuarios` varchar(45) NOT NULL,
  KEY `fk_Estadisticas_Usuarios1_idx` (`nombreUsuarios`),
  CONSTRAINT `fk_Estadisticas_Usuarios1` FOREIGN KEY (`nombreUsuarios`) REFERENCES `usuarios` (`Nombre`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadisticas`
--

LOCK TABLES `estadisticas` WRITE;
/*!40000 ALTER TABLE `estadisticas` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadisticas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugadores` (
  `idJugadores` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(25) DEFAULT NULL,
  `Posicion` varchar(20) DEFAULT NULL,
  `Tiro` int DEFAULT NULL,
  `Defensa` int DEFAULT NULL,
  `Destreza` varchar(10) DEFAULT NULL,
  `Coste` int DEFAULT NULL,
  PRIMARY KEY (`idJugadores`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (1,'Lebron James','Alero',87,13,'Tirar',35),(2,'Stephen Curry','Base',68,33,'Driblar',34),(3,'Giannis Antetokounmpo','Ala-Pivot',70,30,'Driblar',38),(4,'Nikola Jokić','Pivot',84,16,'Tirar',22),(5,'Anthony Davis','Ala-Pivot',64,36,'Tirar',34),(6,'Luka Dončić','Alero',68,32,'Driblar',36),(7,'Devin Booker','Escolta',20,80,'Defender',40),(8,'Damian Lillard','Base',24,76,'Defender',47),(9,'Jimmy Butler','Escolta',34,66,'Defender',29),(10,'Joel Embiid','Pivot',78,22,'Driblar',32);
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `Nombre` varchar(45) NOT NULL,
  `Clave` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Pepe','Pepito'),(2,'Carlos','1234');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-22 12:28:25
