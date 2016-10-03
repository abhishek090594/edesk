-- MySQL dump 10.13  Distrib 5.6.21, for Win32 (x86)
--
-- Host: localhost    Database: erd
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Current Database: `erd`
--

/*!40000 DROP DATABASE IF EXISTS `erd`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `erd` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `erd`;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `ad_id` int(4) NOT NULL AUTO_INCREMENT,
  `ad_username` varchar(25) NOT NULL,
  `ad_password` varchar(32) NOT NULL,
  PRIMARY KEY (`ad_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','admin123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coursename`
--

DROP TABLE IF EXISTS `coursename`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coursename` (
  `con_id` int(3) NOT NULL AUTO_INCREMENT,
  `con_name` varchar(36) NOT NULL,
  PRIMARY KEY (`con_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursename`
--

LOCK TABLES `coursename` WRITE;
/*!40000 ALTER TABLE `coursename` DISABLE KEYS */;
INSERT INTO `coursename` VALUES (1,'Bachelor of Computer Application'),(2,'Bachelor of Business Administrator'),(3,'Master Of Computer Apllication'),(4,'Master Of Business Administrator'),(5,'MSC-CA'),(6,'MSC-ICT');
/*!40000 ALTER TABLE `coursename` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institutename`
--

DROP TABLE IF EXISTS `institutename`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `institutename` (
  `inn_id` int(3) NOT NULL AUTO_INCREMENT,
  `inn_name` varchar(85) NOT NULL,
  PRIMARY KEY (`inn_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institutename`
--

LOCK TABLES `institutename` WRITE;
/*!40000 ALTER TABLE `institutename` DISABLE KEYS */;
INSERT INTO `institutename` VALUES (1,'Shree Madhav Institute Of Computer Application and Information Technology'),(2,'Udhna Citizen College Of Computer Application and Information Technology'),(3,'S.D.J Inernational College'),(4,'Bhagwan Mahavir of Computer Application and Information Technology');
/*!40000 ALTER TABLE `institutename` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `panelhead`
--

DROP TABLE IF EXISTS `panelhead`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `panelhead` (
  `ph_id` int(4) NOT NULL AUTO_INCREMENT,
  `ph_name` varchar(35) NOT NULL,
  `stf_id` int(4) NOT NULL,
  PRIMARY KEY (`ph_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `panelhead`
--

LOCK TABLES `panelhead` WRITE;
/*!40000 ALTER TABLE `panelhead` DISABLE KEYS */;
INSERT INTO `panelhead` VALUES (15,'Amish Patel',4),(16,'Pinkesh Patel',7);
/*!40000 ALTER TABLE `panelhead` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `panelmembers`
--

DROP TABLE IF EXISTS `panelmembers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `panelmembers` (
  `pnm_id` int(4) NOT NULL AUTO_INCREMENT,
  `ph_id` int(4) NOT NULL,
  `stf_id` int(4) NOT NULL,
  PRIMARY KEY (`pnm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `panelmembers`
--

LOCK TABLES `panelmembers` WRITE;
/*!40000 ALTER TABLE `panelmembers` DISABLE KEYS */;
INSERT INTO `panelmembers` VALUES (4,16,1);
/*!40000 ALTER TABLE `panelmembers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `stf_id` int(4) NOT NULL AUTO_INCREMENT,
  `stf_name` varchar(35) NOT NULL,
  `stf_address` varchar(80) NOT NULL,
  `stf_contact` bigint(20) DEFAULT NULL,
  `stf_emailid` varchar(70) NOT NULL,
  `stf_image` varchar(100) DEFAULT NULL,
  `stf_password` varchar(32) NOT NULL,
  `stf_status` tinyint(1) NOT NULL,
  `stf_dateofjoin` datetime NOT NULL,
  PRIMARY KEY (`stf_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'Pratik nayak','address',999999999,'pratik@gmail.com','IMG_20150916_213557.jpg','12',0,'2016-00-23 02:00:33'),(4,'Amish Patel','2dfkmdkfdk',98765768,'pratik@gmail.com','IMG_20150916_213557.jpg','2323',1,'2016-10-23 02:10:17'),(7,'Pinkesh Patel','Ghod-Dod Road',9876098765,'pinkeshp@gmail.com','IMG_20150819_174624.jpg','1234',1,'2016-04-06 05:00:49'),(10,'Ronak Gandhi','Athwagate',8879291923,'ronak123@gmail.com','IMG_20150819_132856.jpg','ronak123',0,'2016-04-06 06:27:54'),(11,'Rutu Patel','Udhna Darwaja',9087651213,'rutupatel123@gmail.com','','1',0,'2016-04-08 04:35:17');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentinquiry`
--

DROP TABLE IF EXISTS `studentinquiry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentinquiry` (
  `stud_id` int(4) NOT NULL AUTO_INCREMENT,
  `stf_id` int(4) NOT NULL,
  `inn_id` int(3) NOT NULL,
  `con_id` int(3) NOT NULL,
  `stud_name` varchar(35) NOT NULL,
  `stud_address` varchar(150) NOT NULL,
  `stud_contact` bigint(20) NOT NULL,
  `stud_emailid` varchar(70) NOT NULL,
  `stud_percentage` float NOT NULL,
  `stud_status` tinyint(1) NOT NULL,
  `stud_inquirydate` datetime NOT NULL,
  PRIMARY KEY (`stud_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentinquiry`
--

LOCK TABLES `studentinquiry` WRITE;
/*!40000 ALTER TABLE `studentinquiry` DISABLE KEYS */;
INSERT INTO `studentinquiry` VALUES (3,1,3,6,'Sohil B. Chamadia','Unn Patia,surat',9913485514,'sohilchamadia128@gmail.com',83.54,1,'2016-04-11 11:53:11'),(4,1,4,6,'Sonwane Darshan','Bhestan Jiav-road,surat',8809765432,'darshan@ymail.com',55.89,0,'2016-04-11 11:15:52'),(5,1,4,5,'Divyata Chauuhan','Rander,surat',9876987686,'div@gmail.com',53.98,0,'2016-04-11 10:56:16'),(7,10,2,1,'Sunil Dora','Sachin,Surat',9087654354,'sunildora@gmail.com',59.01,0,'2016-04-11 06:46:47'),(8,10,4,5,'Jayshree Lad','Udhna',8907654343,'jayshree@ymail.com',71,1,'2016-04-11 06:47:37'),(9,1,4,4,'Rathod Roshan','Ring-Road,surat',7812343456,'roshan123@gmail.com',69.01,0,'2016-04-12 12:33:42');
/*!40000 ALTER TABLE `studentinquiry` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-13 17:36:11
