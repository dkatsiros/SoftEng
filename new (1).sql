-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: cafes
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admin` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'giannis','mpampallou','pipis@hotmail.com');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application_user`
--

DROP TABLE IF EXISTS `application_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `application_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `points` int(11) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application_user`
--

LOCK TABLES `application_user` WRITE;
/*!40000 ALTER TABLE `application_user` DISABLE KEYS */;
INSERT INTO `application_user` VALUES (1,'admin','$2a$10$w7A5wWV1QJHUSc3x4zSYpe0mV0RKBc.fAQ9sf.PkW1HindEMNYCdy','adas','xasxc','dwdqwd',0,''),(2,'admin4','$2a$10$BwbjN/IvD.PeOfkEL1NYu.ndFO1Nx5NP87FwKxnXwDOZPkKvFuwZ2','sda','da','asx',0,'USER'),(3,'veremisgay','$2a$10$eMun7358CcXSIFsa1c8mVObBu9j/V0DyCBlvNaZOOh4o/frRD23VG','veremistonpino@gmail.com','veremis','gay',0,'USER'),(4,'veremisgay','$2a$10$0ZN8J4yjhLwdvyJL9WM8MeqYHVBMpvC9jlxFA5Y8IOKSoeVvblWYa','veremistonpino@gmail.com','veremis','gay',0,'USER');
/*!40000 ALTER TABLE `application_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auth_token`
--

DROP TABLE IF EXISTS `auth_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `auth_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(500) NOT NULL,
  `withdrawn` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auth_token`
--

LOCK TABLES `auth_token` WRITE;
/*!40000 ALTER TABLE `auth_token` DISABLE KEYS */;
INSERT INTO `auth_token` VALUES (1,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjQiLCJleHAiOjE1NTI0ODI3NTV9.0GL9CuPypv7pKmJlpHxUR3X-DjONv_UrfBqhaZXmbZZo9fdrrSu-Sv2lM6YFBvlUjrhzprVutFvIvfBJMQSUqQ',0),(2,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjQiLCJleHAiOjE1NTI0ODI4OTB9.qh_1CM_oi7oMcenilVgf4i5lH7N3WcFO_G7JzVAYN2Bs0f2-Vu3GRL1T61l6szLJEJVXXwmJWEv3Be23SPNMMQ',1),(3,'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjQiLCJleHAiOjE1NTI0ODM3OTB9.GgL7sVBxcbooyJNCmplksixmqHDeZu_NCT-tfXZFXP2OpaZRw26y-OpGt-ZVkssjYpO9QiHyMciyfGwEC6KyBA',0);
/*!40000 ALTER TABLE `auth_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `price` (
  `priceid` int(11) NOT NULL AUTO_INCREMENT,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `price` double DEFAULT NULL,
  `thumbsdown` int(11) DEFAULT NULL,
  `thumbsup` int(11) DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  `shopid` int(11) DEFAULT NULL,
  PRIMARY KEY (`priceid`),
  KEY `productid` (`productid`),
  KEY `shopid` (`shopid`),
  CONSTRAINT `productid` FOREIGN KEY (`productid`) REFERENCES `product` (`id`),
  CONSTRAINT `shopid` FOREIGN KEY (`shopid`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES (1,'2017-03-21','2020-12-12',1.4,0,0,1,1),(2,'2018-04-12','2020-01-19',1.5,0,0,1,2),(3,'1977-12-03','1987-03-12',1.7,0,0,1,3),(4,'1977-12-03','1987-03-12',2,0,0,4,3),(5,'1977-12-03','1987-03-12',1.98,0,0,3,3),(6,'1977-12-03','1987-03-12',1.42,0,0,3,2),(7,'1950-02-02','2070-03-05',2.2,0,0,8,1),(8,'1950-02-02','2070-03-05',2.2,0,0,8,1),(9,'1950-02-02','2070-03-05',2.2,0,0,8,1),(10,'1950-02-02','2070-03-05',2.2,0,0,8,1),(11,'1950-02-02','2070-03-05',2.5,0,0,8,1);
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `withdrawn` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'κρυος καφες','κακο καφε','φραπουτσινο','καλο, κακο',0),(2,'cafes','o pio omorfos cafes','freddo espresso2','freddo, pagwmeno, espresso',0),(3,'cafes','o pio omorfos cafes','freddo espresso2','freddo, pagwmeno, espresso',0),(4,'cold coffee','kako kafe ','frape','good, bad',0),(5,'cold coffee','kako kafe ','frape','good, bad',0),(6,'cold coffee','kako kafe ','frape','good, bad',0),(7,'cold coffee','kako kafe ','frapedara','good, bad',0),(8,'παγωμενος','νοστιμο καφεδακι ','φρεντο','νοστιμο, δροσερο, φτηνο',0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `withdrawn` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES (1,'Μεσολλογγίου 13, Καστοριά',35.5137,24.0173,'Mc','cafes, magazi, apo kastoria paok',0),(2,'Μεσολλογγίου 13, Καστοριά',35.5127,24.018,'Mc','cafes, magazi, apo kastoria paok, velanidia',0),(3,'Μεσολλογγίου 13, Καστοριά',35.5137,24.0173,'Mc','cafes, magazi, apo kastoria paok',0),(4,'Μεσολλογγίου 13, Καστοριά',13.7,12.3,'Mc','cafes, magazi, apo kastoria paok',0);
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `points` int(11) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('nikalhths','12345','nikf31@hotmail.com','Nitsiforos','Katakis',0),('veremakos','axaxax','veremisgay@hotmail.com','Alexios','Vergay',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-03 18:34:58
