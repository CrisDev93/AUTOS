CREATE DATABASE  IF NOT EXISTS `bdscec2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bdscec`;
-- MySQL dump 10.13  Distrib 5.6.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bdscec
-- ------------------------------------------------------
-- Server version	5.6.21-enterprise-commercial-advanced-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ciudades`
--

DROP TABLE IF EXISTS `ciudades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudades` (
  `idCiudad` bigint(11) NOT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  `idEstado` bigint(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idCiudad`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudades`
--

LOCK TABLES `ciudades` WRITE;
/*!40000 ALTER TABLE `ciudades` DISABLE KEYS */;
INSERT INTO `ciudades` VALUES (2,'',1,'Guadalajara'),(3,'',2,'Tuxtla'),(5,'',2,'Chiapa de Corzo'),(6,'',8,'Chilpancingo'),(7,'',8,'Iguala'),(8,'',8,'Ayotzinapa'),(9,'',9,'Mordor');
/*!40000 ALTER TABLE `ciudades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estados` (
  `idEstado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idEstado`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'Jalisco',''),(2,'Chiapas',''),(3,'Tabasco',''),(4,'Quintana Roo',''),(5,'Yucatan',''),(6,'Campeche',''),(7,'Oaxaca',''),(8,'Guerrero',''),(9,'Tierra Media','');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historialrespuestas`
--

DROP TABLE IF EXISTS `historialrespuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historialrespuestas` (
  `idHistorial` int(11) NOT NULL AUTO_INCREMENT,
  `idTest` int(11) NOT NULL,
  `idPregunta` int(11) NOT NULL,
  `idRespuesta` int(11) NOT NULL,
  `Resultado` int(11) NOT NULL COMMENT 'Use 0 para indicar respuesta incorrecta y 1 para indicar respuesta correcta',
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idHistorial`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialrespuestas`
--

LOCK TABLES `historialrespuestas` WRITE;
/*!40000 ALTER TABLE `historialrespuestas` DISABLE KEYS */;
INSERT INTO `historialrespuestas` VALUES (1,1,1,1,0,'Emanuel'),(2,1,5,13,0,'Emanuel'),(3,1,3,7,0,'Emanuel'),(4,1,7,19,0,'Emanuel'),(5,1,1,2,0,'Adriana'),(6,1,5,14,0,'Adriana'),(7,1,3,8,0,'Adriana'),(8,1,7,20,0,'Adriana'),(9,1,1,3,0,'Rafael'),(10,1,5,15,0,'Rafael'),(11,1,3,9,0,'Rafael'),(12,1,7,21,0,'Rafael'),(13,2,2,4,0,'Adriana'),(14,2,6,16,0,'Adriana'),(15,2,4,10,0,'Adriana'),(16,2,8,22,0,'Adriana'),(17,2,2,5,0,'Rafael'),(18,2,6,17,0,'Rafael'),(19,2,4,11,0,'Rafael'),(20,2,8,23,0,'Rafael'),(21,2,2,6,0,'Emanuel'),(22,2,6,18,0,'Emanuel'),(23,2,4,12,0,'Emanuel'),(24,2,8,24,0,'Emanuel');
/*!40000 ALTER TABLE `historialrespuestas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `historiatest`
--

DROP TABLE IF EXISTS `historiatest`;
/*!50001 DROP VIEW IF EXISTS `historiatest`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `historiatest` AS SELECT 
 1 AS `idt`,
 1 AS `idh`,
 1 AS `nombre`,
 1 AS `idp`,
 1 AS `idr`,
 1 AS `idrc`,
 1 AS `pregunta`,
 1 AS `respuesta`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personas` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `idCiudad` int(11) NOT NULL,
  `Nombres` varchar(75) NOT NULL,
  `Apellidos` varchar(75) NOT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `Telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,1,'Emanuel','Roque Pimentel','Enrique Segoviano','5555925'),(2,1,'Adriana','Roque Pimentel','Las Lomas','5555825'),(3,1,'Rafael','Roque Medina','Vista Hermosa Popular','6636020'),(4,7,'Yarib Octavio','Lopez Hernandez','Colonia centro','2367893367'),(5,0,'2345678','123456789','23456789','qwertyuio'),(6,9,'Orco','Orco','Orco','0987654321');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pregunta` (
  `idPregunta` int(11) NOT NULL AUTO_INCREMENT,
  `idSeccion` int(11) NOT NULL,
  `posicion` int(11) DEFAULT NULL,
  `idRespuestaCorrecta` int(11) DEFAULT NULL,
  `pregunta` varchar(145) NOT NULL,
  PRIMARY KEY (`idPregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta`
--

LOCK TABLES `pregunta` WRITE;
/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
INSERT INTO `pregunta` VALUES (1,1,1,1,'Pregunta1'),(2,2,2,5,'Pregunta2'),(3,3,3,9,'Pregunta3'),(4,4,4,10,'Pregunta4'),(5,1,5,14,'Pregunta5'),(6,2,6,18,'Pregunta6'),(7,3,7,19,'Pregunta7'),(8,4,8,23,'Pregunta8');
/*!40000 ALTER TABLE `pregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuesta` (
  `idRespuesta` int(11) NOT NULL AUTO_INCREMENT,
  `idPregunta` int(11) NOT NULL,
  `respuesta` varchar(200) NOT NULL,
  PRIMARY KEY (`idRespuesta`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta`
--

LOCK TABLES `respuesta` WRITE;
/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
INSERT INTO `respuesta` VALUES (1,1,'Respuesta1'),(2,1,'Respuesta2'),(3,1,'Respuesta3'),(4,2,'Respuesta4'),(5,2,'Respuesta5'),(6,2,'Respuesta6'),(7,3,'Respuesta7'),(8,3,'Respuesta8'),(9,3,'Respuesta9'),(10,4,'Respuesta10'),(11,4,'Respuesta11'),(12,4,'Respuesta12'),(13,5,'Respuesta13'),(14,5,'Respuesta14'),(15,5,'Respuesta15'),(16,6,'Respuesta16'),(17,6,'Respuesta17'),(18,6,'Respuesta18'),(19,7,'Respuesta19'),(20,7,'Respuesta20'),(21,7,'Respuesta21'),(22,8,'Respuesta22'),(23,8,'Respuesta23'),(24,8,'Respuesta24');
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `idRol` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idRol`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seccion`
--

DROP TABLE IF EXISTS `seccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seccion` (
  `idSeccion` int(11) NOT NULL AUTO_INCREMENT,
  `idTest` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idSeccion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seccion`
--

LOCK TABLES `seccion` WRITE;
/*!40000 ALTER TABLE `seccion` DISABLE KEYS */;
INSERT INTO `seccion` VALUES (1,1,'Español'),(2,2,'Matematicas'),(3,1,'Ciencias Naturales'),(4,2,'Fisica');
/*!40000 ALTER TABLE `seccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `idTest` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idTest`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,'Prueba1'),(2,'Prueba2');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `testgenerado`
--

DROP TABLE IF EXISTS `testgenerado`;
/*!50001 DROP VIEW IF EXISTS `testgenerado`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `testgenerado` AS SELECT 
 1 AS `idt`,
 1 AS `idp`,
 1 AS `idr`,
 1 AS `respuesta`,
 1 AS `pregunta`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `usuariorol`
--

DROP TABLE IF EXISTS `usuariorol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuariorol` (
  `idUsuario` bigint(20) NOT NULL,
  `idRol` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariorol`
--

LOCK TABLES `usuariorol` WRITE;
/*!40000 ALTER TABLE `usuariorol` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuariorol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idUsuario` bigint(20) NOT NULL,
  `nombrePrefijo` varchar(255) DEFAULT NULL,
  `nombreNombre` varchar(255) DEFAULT NULL,
  `nombreApellidoPaterno` varchar(255) DEFAULT NULL,
  `nombreApellidoMaterno` varchar(255) DEFAULT NULL,
  `nombrePosfijo` varchar(255) DEFAULT NULL,
  `nombreIniciales` varchar(255) DEFAULT NULL,
  `nombreUsuario` varchar(255) NOT NULL,
  `claveAcceso` varchar(255) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `nombreUsuario` (`nombreUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `historiatest`
--

/*!50001 DROP VIEW IF EXISTS `historiatest`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `historiatest` AS select `historialrespuestas`.`idTest` AS `idt`,`historialrespuestas`.`idHistorial` AS `idh`,`historialrespuestas`.`nombre` AS `nombre`,`historialrespuestas`.`idPregunta` AS `idp`,`historialrespuestas`.`idRespuesta` AS `idr`,`pregunta`.`idRespuestaCorrecta` AS `idrc`,`pregunta`.`pregunta` AS `pregunta`,`respuesta`.`respuesta` AS `respuesta` from ((`historialrespuestas` join `pregunta` on((`pregunta`.`idPregunta` = `historialrespuestas`.`idPregunta`))) join `respuesta` on((`respuesta`.`idRespuesta` = `historialrespuestas`.`idRespuesta`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `testgenerado`
--

/*!50001 DROP VIEW IF EXISTS `testgenerado`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `testgenerado` AS select `seccion`.`idTest` AS `idt`,`pregunta`.`idPregunta` AS `idp`,`respuesta`.`idRespuesta` AS `idr`,`respuesta`.`respuesta` AS `respuesta`,`pregunta`.`pregunta` AS `pregunta` from ((`pregunta` left join `respuesta` on((`respuesta`.`idPregunta` = `pregunta`.`idPregunta`))) left join `seccion` on((`seccion`.`idSeccion` = `pregunta`.`idSeccion`))) order by `pregunta`.`idSeccion`,`pregunta`.`idPregunta` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-30 13:46:53
