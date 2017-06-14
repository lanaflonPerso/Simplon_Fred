-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: new_schema
-- ------------------------------------------------------
-- Server version	5.7.17-0ubuntu0.16.04.1

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
-- Table structure for table `CHILDREN`
--

DROP TABLE IF EXISTS `CHILDREN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CHILDREN` (
  `ID` int(11) NOT NULL,
  `CONTACT_ID` int(11) DEFAULT NULL,
  `FNAME` varchar(30) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CHILDREN`
--

LOCK TABLES `CHILDREN` WRITE;
/*!40000 ALTER TABLE `CHILDREN` DISABLE KEYS */;
INSERT INTO `CHILDREN` VALUES (1,5,'Sam',5),(2,1,'Ruby',2),(3,1,'Robert',4),(4,1,'Roman',6);
/*!40000 ALTER TABLE `CHILDREN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CONTACTS`
--

DROP TABLE IF EXISTS `CONTACTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CONTACTS` (
  `ID` int(11) NOT NULL,
  `FNAME` varchar(100) DEFAULT NULL,
  `LNAME` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `CONTACT_TYPE` varchar(30) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CONTACTS`
--

LOCK TABLES `CONTACTS` WRITE;
/*!40000 ALTER TABLE `CONTACTS` DISABLE KEYS */;
INSERT INTO `CONTACTS` VALUES (1,'Dave','Smith','dsmith@icloud.com','friend',46),(2,'Xena','Johnson','xjonson@icloud.com','friend',46),(3,'Fred','Jackon','fjackson@icloud.com','co-worker',18),(4,'Alma','Tyler','atyler@icloud.com','contact',57),(5,'Jane','Edwards','jedwards@icloud.com','contact',40),(6,'Jill','Jackson','jjackson@icloud.com','friend',24);
/*!40000 ALTER TABLE `CONTACTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HOBBIES`
--

DROP TABLE IF EXISTS `HOBBIES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HOBBIES` (
  `ID` int(11) NOT NULL,
  `CONTACT_ID` int(11) DEFAULT NULL,
  `HOBBY` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HOBBIES`
--

LOCK TABLES `HOBBIES` WRITE;
/*!40000 ALTER TABLE `HOBBIES` DISABLE KEYS */;
INSERT INTO `HOBBIES` VALUES (1,1,'Horseback Riding'),(2,2,'Sailing'),(3,1,'Guitar'),(4,3,'Skiing'),(5,3,'Scuba'),(6,4,'Photography'),(7,6,'Travel'),(8,6,'Guitar');
/*!40000 ALTER TABLE `HOBBIES` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-21 16:02:49
