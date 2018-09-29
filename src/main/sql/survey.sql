-- MySQL dump 10.13  Distrib 5.6.26, for Linux (x86_64)
--
-- Host: localhost    Database: survey
-- ------------------------------------------------------
-- Server version	5.6.26

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
-- Table structure for table `charge`
--

DROP TABLE IF EXISTS `charge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `charge` (
  `charge_account` varchar(10) NOT NULL,
  `charge_password` varchar(20) NOT NULL,
  `charge_name` varchar(8) NOT NULL,
  `email` varchar(20) DEFAULT '',
  PRIMARY KEY (`charge_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `class_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `class_name` char(30) NOT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `leader`
--

DROP TABLE IF EXISTS `leader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leader` (
  `leader_account` varchar(10) NOT NULL,
  `leader_password` varchar(20) NOT NULL,
  `leader_name` varchar(8) NOT NULL,
  `email` varchar(20) DEFAULT '',
  PRIMARY KEY (`leader_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `messenger`
--

DROP TABLE IF EXISTS `messenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messenger` (
  `messenger_account` varchar(10) NOT NULL,
  `messenger_password` varchar(20) NOT NULL,
  `class_id` tinyint(3) unsigned NOT NULL,
  `email` varchar(20) DEFAULT '',
  PRIMARY KEY (`messenger_account`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `messenger_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `problem`
--

DROP TABLE IF EXISTS `problem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `problem` (
  `problem_id` smallint(6) NOT NULL AUTO_INCREMENT,
  `messenger_account` varchar(10) NOT NULL,
  `problem_type` varchar(20) NOT NULL,
  `problem_describe` varchar(200) NOT NULL,
  `process_time` timestamp NULL DEFAULT NULL,
  `process_teacher_account` varchar(10) DEFAULT NULL,
  `process_course` varchar(200) DEFAULT NULL,
  `is_confirm` tinyint(1) unsigned DEFAULT '0',
  `is_process` tinyint(1) unsigned DEFAULT '0',
  `submit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `is_assignment_teacher` tinyint(1) unsigned DEFAULT '0',
  `is_reject` tinyint(1) unsigned DEFAULT '0',
  `assignment_time` timestamp NULL DEFAULT NULL,
  `reject_time` timestamp NULL DEFAULT NULL,
  `is_agree` tinyint(1) unsigned DEFAULT '0',
  `agree_time` timestamp NULL DEFAULT NULL,
  `is_to_teacher` tinyint(1) unsigned DEFAULT '0',
  `to_teacher_time` timestamp NULL DEFAULT NULL,
  `reject_reason` varchar(90) DEFAULT NULL,
  `confirm_time` timestamp NULL DEFAULT NULL,
  `to_teacher_reason` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`problem_id`),
  KEY `messenger_account` (`messenger_account`),
  KEY `process_teacher_account` (`process_teacher_account`),
  CONSTRAINT `problem_ibfk_1` FOREIGN KEY (`messenger_account`) REFERENCES `messenger` (`messenger_account`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `problem_ibfk_2` FOREIGN KEY (`process_teacher_account`) REFERENCES `process_teacher` (`process_teacher_account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `process_teacher`
--

DROP TABLE IF EXISTS `process_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `process_teacher` (
  `process_teacher_account` varchar(10) NOT NULL,
  `process_teacher_password` varchar(20) NOT NULL,
  `process_teacher_type` varchar(20) NOT NULL,
  `process_teacher_name` varchar(8) NOT NULL,
  `email` varchar(20) DEFAULT '',
  PRIMARY KEY (`process_teacher_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-28 19:24:13
