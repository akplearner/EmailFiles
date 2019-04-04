CREATE DATABASE  IF NOT EXISTS `user` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `user`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: user
-- ------------------------------------------------------
-- Server version	8.0.12

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
-- Table structure for table `delete`
--

DROP TABLE IF EXISTS `delete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `delete` (
  `sender` varchar(45) NOT NULL,
  `receiver` varchar(45) NOT NULL,
  `subject` varchar(45) NOT NULL,
  `content` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sender`,`receiver`,`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delete`
--

LOCK TABLES `delete` WRITE;
/*!40000 ALTER TABLE `delete` DISABLE KEYS */;
INSERT INTO `delete` VALUES ('akp@yg.com','aaaa','hi','sdf'),('akp@yg.com','aaaa@yg.com','ha','hi'),('akp@yg.com','aaaa@yg.com','hi','jkhsdaf');
/*!40000 ALTER TABLE `delete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `draft`
--

DROP TABLE IF EXISTS `draft`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `draft` (
  `sender` varchar(45) NOT NULL,
  `receiver` varchar(45) NOT NULL,
  `subject` varchar(45) NOT NULL,
  `content` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sender`,`receiver`,`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `draft`
--

LOCK TABLES `draft` WRITE;
/*!40000 ALTER TABLE `draft` DISABLE KEYS */;
INSERT INTO `draft` VALUES ('akp','aaaa@yg.com','akp>aaaa','draft test'),('akp','aaaa@yg.com','akp>aaaa@','draft test'),('akp','aaaa@yg.com','akp>aaaa@y','draft test'),('akp','aaaa@yg.com','akp>aaaa@yg.com','draft test'),('akp@yg.com','aaaa@yg.com','akp>aaaa','Draft test1'),('akp@yg.com','aaaa@yg.com','akp>aaaa@yg.com','Draft test1');
/*!40000 ALTER TABLE `draft` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emails`
--

DROP TABLE IF EXISTS `emails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `emails` (
  `from` varchar(45) DEFAULT NULL,
  `to` varchar(45) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emails`
--

LOCK TABLES `emails` WRITE;
/*!40000 ALTER TABLE `emails` DISABLE KEYS */;
INSERT INTO `emails` VALUES ('akp@yg.com','akp1@yg.com','testing','Content test');
/*!40000 ALTER TABLE `emails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info`
--

DROP TABLE IF EXISTS `info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `info` (
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `userName` varchar(45) NOT NULL,
  `domain` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`userName`,`domain`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info`
--

LOCK TABLES `info` WRITE;
/*!40000 ALTER TABLE `info` DISABLE KEYS */;
INSERT INTO `info` VALUES ('1aa','1aa','12aa','1aa','1aa'),('1a','1a','1a','1a','1a'),('1aa','1aa','1aa','1aa','1aa'),('a','a','aa','@lnb.gov','12345678'),('a','a','aa','@qc.edu','12345678'),('a','a','aa','@yg.com','12345678'),('aaaa','aaaa','aaaa','@yg.com','aaaa'),('aa','aa','aaaaaa','@yg.com','aaaaaa'),('ant','p','akp','@yg.com','123'),('a','p','akp3','@yg.com','123456789'),('a','p','akpz','@yg.com','123'),('bbbb','bbbb','bbbb','@qc.edu','bbbb'),('b','b','bbbb','@yg.com','bbbb'),('chris','c','chris','@yg.com','123'),('qq','qq','qqqq','@yg.com','qqqq'),('a','p','tato','@yg.com','123');
/*!40000 ALTER TABLE `info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info2`
--

DROP TABLE IF EXISTS `info2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `info2` (
  `sender` varchar(45) NOT NULL,
  `receiver` varchar(45) NOT NULL,
  `subject` varchar(45) NOT NULL,
  `content` varchar(125) DEFAULT NULL,
  PRIMARY KEY (`sender`,`receiver`,`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info2`
--

LOCK TABLES `info2` WRITE;
/*!40000 ALTER TABLE `info2` DISABLE KEYS */;
INSERT INTO `info2` VALUES ('aa','aaaa','aaa','sssss'),('aa','akp','aa>akp','test5'),('aa','sssss','ssss','ssssss'),('aaaa','akp','aaaa>akp','test6'),('aaaa@yg.com','akp@qc.edu','aaaa@yg.com>akp@yg.com','testing name plus domain user name'),('aaaa@yg.com','akp@yg.com','aaaa@yg.com>akp@yg.com','testing name plus domain user name'),('aaaa@yg.com','akp@yg.com','aaaa>akp@','testing name plus domain user name'),('aaaa@yg.com','akp@yg.com','aaaa>akp@yg.com','testing name plus domain user name'),('akp','aa','akp>aa','test2'),('akp','aaaa','akp>aaaa','hihi'),('akp','aaaa@yg.com','akp>aaaa@y','testing'),('akp','chris','akp>chris','testing'),('akp','ssss','akp>ssss','bua'),('akp@yg.com','aaaa@yg.com','akp>>aaaa@yg','test'),('akp@yg.com','aaaa@yg.com','testing ','hiiiii'),('akp@yg.com','aaaa@yg.com','testing subject primary','hiiiii'),('akp@yg.com','aaaa@yg.com','testing subject primary key','hello'),('akp@yg.com','aaaa@yg.com','testing wh','hiiiii'),('akp@yg.com','aaaa@yg.com','testing why','hiiiii'),('akpz','aaaa@yg.com','akpz>>aaaa@','Testing domain primary key'),('chris','aa','chris>aa','test4'),('chris','akp','chris>akp','test3');
/*!40000 ALTER TABLE `info2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-08 18:36:52
