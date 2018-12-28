-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: schoolmate
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adminstaff`
--

DROP TABLE IF EXISTS `adminstaff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adminstaff` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL DEFAULT '0',
  `fname` varchar(20) NOT NULL DEFAULT '',
  `lname` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`adminid`),
  UNIQUE KEY `UserID` (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminstaff`
--

LOCK TABLES `adminstaff` WRITE;
/*!40000 ALTER TABLE `adminstaff` DISABLE KEYS */;
/*!40000 ALTER TABLE `adminstaff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignments`
--

DROP TABLE IF EXISTS `assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assignments` (
  `assignmentid` int(11) NOT NULL AUTO_INCREMENT,
  `courseid` int(11) NOT NULL DEFAULT '0',
  `semesterid` int(11) NOT NULL DEFAULT '0',
  `termid` int(11) NOT NULL DEFAULT '0',
  `title` varchar(15) NOT NULL DEFAULT '',
  `totalpoints` double(6,2) NOT NULL DEFAULT '0.00',
  `assigneddate` date NOT NULL DEFAULT '0000-00-00',
  `duedate` date NOT NULL DEFAULT '0000-00-00',
  `assignmentinformation` text,
  PRIMARY KEY (`assignmentid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignments`
--

LOCK TABLES `assignments` WRITE;
/*!40000 ALTER TABLE `assignments` DISABLE KEYS */;
INSERT INTO `assignments` VALUES (2,8,2,3,'assignment 1',1.00,'2018-12-01','2018-12-13','TODO');
/*!40000 ALTER TABLE `assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `courseid` int(11) NOT NULL AUTO_INCREMENT,
  `semesterid` int(11) NOT NULL DEFAULT '0',
  `termid` int(11) NOT NULL DEFAULT '0',
  `coursename` varchar(20) NOT NULL DEFAULT '',
  `teacherid` int(11) NOT NULL DEFAULT '0',
  `sectionnum` varchar(15) NOT NULL DEFAULT '0',
  `roomnum` varchar(5) NOT NULL DEFAULT '',
  `periodnum` char(3) NOT NULL DEFAULT '',
  `q1points` double(6,2) NOT NULL DEFAULT '0.00',
  `q2points` double(6,2) NOT NULL DEFAULT '0.00',
  `totalpoints` double(6,2) NOT NULL DEFAULT '0.00',
  `aperc` double(6,3) NOT NULL DEFAULT '0.000',
  `bperc` double(6,3) NOT NULL DEFAULT '0.000',
  `cperc` double(6,3) NOT NULL DEFAULT '0.000',
  `dperc` double(6,3) NOT NULL DEFAULT '0.000',
  `fperc` double(6,3) NOT NULL DEFAULT '0.000',
  `dotw` varchar(5) DEFAULT NULL,
  `substituteid` int(11) DEFAULT NULL,
  `secondcourseid` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseid`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (8,2,3,'class2',3,'1','2','1',0.00,1.00,1.00,0.000,0.000,0.000,0.000,0.000,'TW',0,0),(7,2,3,'class1',2,'1','1','1',0.00,0.00,0.00,0.000,0.000,0.000,0.000,0.000,'MWH',0,0);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grades` (
  `gradeid` int(11) NOT NULL AUTO_INCREMENT,
  `assignmentid` int(11) NOT NULL DEFAULT '0',
  `courseid` int(11) NOT NULL DEFAULT '0',
  `semesterid` int(11) NOT NULL DEFAULT '0',
  `termid` int(11) NOT NULL DEFAULT '0',
  `studentid` int(11) NOT NULL DEFAULT '0',
  `points` double(6,2) DEFAULT '0.00',
  `comment` text,
  `submitdate` date DEFAULT '0000-00-00',
  `islate` int(1) DEFAULT '0',
  PRIMARY KEY (`gradeid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grades`
--

LOCK TABLES `grades` WRITE;
/*!40000 ALTER TABLE `grades` DISABLE KEYS */;
/*!40000 ALTER TABLE `grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent_student_match`
--

DROP TABLE IF EXISTS `parent_student_match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parent_student_match` (
  `matchid` int(11) NOT NULL AUTO_INCREMENT,
  `parentid` int(11) NOT NULL DEFAULT '0',
  `studentid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`matchid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent_student_match`
--

LOCK TABLES `parent_student_match` WRITE;
/*!40000 ALTER TABLE `parent_student_match` DISABLE KEYS */;
INSERT INTO `parent_student_match` VALUES (2,2,3),(3,2,2);
/*!40000 ALTER TABLE `parent_student_match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parents`
--

DROP TABLE IF EXISTS `parents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parents` (
  `parentid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL DEFAULT '0',
  `fname` varchar(15) DEFAULT NULL,
  `lname` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`parentid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parents`
--

LOCK TABLES `parents` WRITE;
/*!40000 ALTER TABLE `parents` DISABLE KEYS */;
INSERT INTO `parents` VALUES (2,6,'parent','parent'),(3,6,'parent2','parent2');
/*!40000 ALTER TABLE `parents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrations`
--

DROP TABLE IF EXISTS `registrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registrations` (
  `regid` int(11) NOT NULL AUTO_INCREMENT,
  `courseid` int(11) NOT NULL DEFAULT '0',
  `studentid` int(11) NOT NULL DEFAULT '0',
  `semesterid` int(11) NOT NULL DEFAULT '0',
  `termid` int(11) NOT NULL DEFAULT '0',
  `q1currpoints` double(6,2) NOT NULL DEFAULT '0.00',
  `q2currpoints` double(6,2) NOT NULL DEFAULT '0.00',
  `currentpoints` double(6,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`regid`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrations`
--

LOCK TABLES `registrations` WRITE;
/*!40000 ALTER TABLE `registrations` DISABLE KEYS */;
INSERT INTO `registrations` VALUES (8,7,2,2,3,0.00,0.00,0.00),(7,1,1,1,0,0.00,0.00,0.00),(6,1,1,1,0,0.00,0.00,0.00),(10,7,3,2,3,0.00,0.00,0.00),(11,8,4,2,3,0.00,0.00,0.00);
/*!40000 ALTER TABLE `registrations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolattendance`
--

DROP TABLE IF EXISTS `schoolattendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolattendance` (
  `sattendid` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` int(11) NOT NULL DEFAULT '0',
  `sattenddate` date NOT NULL DEFAULT '0000-00-00',
  `semesterid` int(11) NOT NULL DEFAULT '0',
  `termid` int(11) NOT NULL DEFAULT '0',
  `type` enum('tardy','absent') DEFAULT NULL,
  PRIMARY KEY (`sattendid`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolattendance`
--

LOCK TABLES `schoolattendance` WRITE;
/*!40000 ALTER TABLE `schoolattendance` DISABLE KEYS */;
INSERT INTO `schoolattendance` VALUES (5,3,'0000-00-00',2,3,'tardy'),(4,3,'0000-00-00',2,3,'tardy');
/*!40000 ALTER TABLE `schoolattendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolbulletins`
--

DROP TABLE IF EXISTS `schoolbulletins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolbulletins` (
  `sbulletinid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(15) NOT NULL DEFAULT '',
  `message` text NOT NULL,
  `bulletindate` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`sbulletinid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolbulletins`
--

LOCK TABLES `schoolbulletins` WRITE;
/*!40000 ALTER TABLE `schoolbulletins` DISABLE KEYS */;
INSERT INTO `schoolbulletins` VALUES (2,'vacanze','yuppyyyyy\r\n','2018-12-27');
/*!40000 ALTER TABLE `schoolbulletins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schoolinfo`
--

DROP TABLE IF EXISTS `schoolinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schoolinfo` (
  `schoolname` varchar(50) NOT NULL DEFAULT '',
  `address` varchar(50) DEFAULT NULL,
  `phonenumber` varchar(14) DEFAULT NULL,
  `sitetext` text,
  `sitemessage` text,
  `currenttermid` int(11) DEFAULT NULL,
  `numsemesters` int(3) NOT NULL DEFAULT '0',
  `numperiods` int(3) NOT NULL DEFAULT '0',
  `apoint` double(6,3) NOT NULL DEFAULT '0.000',
  `bpoint` double(6,3) NOT NULL DEFAULT '0.000',
  `cpoint` double(6,3) NOT NULL DEFAULT '0.000',
  `dpoint` double(6,3) NOT NULL DEFAULT '0.000',
  `fpoint` double(6,3) NOT NULL DEFAULT '0.000',
  PRIMARY KEY (`schoolname`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schoolinfo`
--

LOCK TABLES `schoolinfo` WRITE;
/*!40000 ALTER TABLE `schoolinfo` DISABLE KEYS */;
INSERT INTO `schoolinfo` VALUES ('School Name','1,Street','52365895','','This is the Message of the day:-\r\n\r\n\r\nWe think our fathers fools, so wise do we grow,\r\nno doubt our wisest sons would think us\r\nso.',NULL,0,0,0.000,0.000,0.000,0.000,0.000);
/*!40000 ALTER TABLE `schoolinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semesters`
--

DROP TABLE IF EXISTS `semesters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `semesters` (
  `semesterid` int(11) NOT NULL AUTO_INCREMENT,
  `termid` varchar(15) NOT NULL DEFAULT '',
  `title` varchar(15) NOT NULL DEFAULT '',
  `startdate` date NOT NULL DEFAULT '0000-00-00',
  `midtermdate` date NOT NULL DEFAULT '0000-00-00',
  `enddate` date NOT NULL DEFAULT '0000-00-00',
  `type` enum('1','2') DEFAULT NULL,
  PRIMARY KEY (`semesterid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semesters`
--

LOCK TABLES `semesters` WRITE;
/*!40000 ALTER TABLE `semesters` DISABLE KEYS */;
INSERT INTO `semesters` VALUES (2,'3','first semester','2018-09-01','2018-10-01','2018-12-22','1');
/*!40000 ALTER TABLE `semesters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `studentid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL DEFAULT '0',
  `fname` varchar(15) NOT NULL DEFAULT '',
  `mi` char(1) NOT NULL DEFAULT '',
  `lname` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`studentid`),
  UNIQUE KEY `UserID` (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (3,4,'studente 1','S','uno'),(2,8,'studente2','S','due'),(4,9,'studente3','3','tre');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers` (
  `teacherid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL DEFAULT '0',
  `fname` varchar(15) NOT NULL DEFAULT '',
  `lname` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`teacherid`),
  UNIQUE KEY `UserID` (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (3,3,'teacher1','teacher1'),(2,5,'alessio','trivisonno');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terms`
--

DROP TABLE IF EXISTS `terms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terms` (
  `termid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(15) NOT NULL DEFAULT '',
  `startdate` date NOT NULL DEFAULT '0000-00-00',
  `enddate` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`termid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terms`
--

LOCK TABLES `terms` WRITE;
/*!40000 ALTER TABLE `terms` DISABLE KEYS */;
INSERT INTO `terms` VALUES (2,'Second Term','2019-02-03','2019-01-06'),(3,'First Term','2018-09-01','2018-12-22');
/*!40000 ALTER TABLE `terms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) NOT NULL DEFAULT '',
  `password` varchar(32) NOT NULL DEFAULT '',
  `type` enum('Admin','Teacher','Substitute','Student','Parent') NOT NULL DEFAULT 'Admin',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (9,'studente3','bb73f216216d3764b78b3faea0ea86eb','Student'),(2,'schoolmate','e92490babb18f75d40a3f35b75d52b87','Admin'),(3,'teacher','8d788385431273d11e8b43bb78f3aa41','Teacher'),(4,'student','cd73502828457d15655bbd7a63fb0bc8','Student'),(5,'alessio','d2462e55381a20059ed811cefd42493e','Teacher'),(6,'parent','d0e45878043844ffc41aac437e86b602','Parent'),(7,'substitute','30baf0837b1972f86bc7492024cef370','Substitute'),(8,'studente2','521fc79b21b2b4dfe62528b22213777f','Student');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-28 14:13:44
