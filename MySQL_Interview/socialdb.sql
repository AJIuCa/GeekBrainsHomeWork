-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: socialdb
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `like_collect`
--

DROP TABLE IF EXISTS `like_collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `like_collect` (
  `user_id` int(11) NOT NULL,
  `like_in_total` int(11) NOT NULL DEFAULT '0',
  `like_in_user` int(11) NOT NULL DEFAULT '0',
  `like_together` int(11) NOT NULL DEFAULT '0',
  `like_in_photo` int(11) NOT NULL DEFAULT '0',
  `like_in_comment` int(11) NOT NULL DEFAULT '0',
  `like_out` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`),
  CONSTRAINT `fk_like_collect_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like_collect`
--

LOCK TABLES `like_collect` WRITE;
/*!40000 ALTER TABLE `like_collect` DISABLE KEYS */;
INSERT INTO `like_collect` VALUES (1,3,2,0,1,0,7),(2,3,3,0,0,0,1),(3,9,3,0,2,3,2),(4,3,3,0,0,0,2),(5,1,1,0,0,0,2),(6,1,1,0,0,0,0);
/*!40000 ALTER TABLE `like_collect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `like_post`
--

DROP TABLE IF EXISTS `like_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `like_post` (
  `user_id` int(11) NOT NULL,
  `user_id_like` int(11) DEFAULT NULL,
  `photo_id_like` int(11) DEFAULT NULL,
  `comment_id_like` int(11) DEFAULT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`user_id`,`date`),
  KEY `fk_like_post_photo_id_idx` (`photo_id_like`),
  KEY `fk_like_post_comment_id_like_idx` (`comment_id_like`),
  CONSTRAINT `fk_like_post_comment_id_like` FOREIGN KEY (`comment_id_like`) REFERENCES `photo` (`comment_id`),
  CONSTRAINT `fk_like_post_photo_id_like` FOREIGN KEY (`photo_id_like`) REFERENCES `photo` (`photo_id`),
  CONSTRAINT `fk_like_post_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like_post`
--

LOCK TABLES `like_post` WRITE;
/*!40000 ALTER TABLE `like_post` DISABLE KEYS */;
INSERT INTO `like_post` VALUES (1,2,NULL,NULL,'2007-10-11 19:05:07'),(1,3,NULL,NULL,'2007-10-11 19:05:15'),(1,4,NULL,NULL,'2007-10-11 19:55:07'),(1,4,NULL,NULL,'2007-11-11 19:26:57'),(1,5,NULL,NULL,'2007-11-11 19:27:00'),(1,6,NULL,NULL,'2007-11-11 19:27:30'),(1,NULL,1,3,'2008-01-01 08:44:31'),(2,NULL,3,3,'2008-01-01 08:46:31'),(3,1,NULL,NULL,'2007-10-11 19:33:15'),(3,4,NULL,NULL,'2007-10-11 19:55:15'),(4,3,NULL,NULL,'2007-10-11 19:25:07'),(4,2,NULL,NULL,'2007-11-11 19:25:07'),(5,2,NULL,NULL,'2007-11-11 08:37:05'),(5,3,NULL,NULL,'2007-11-11 08:44:31');
/*!40000 ALTER TABLE `like_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `photo` (
  `user_id` int(11) NOT NULL,
  `photo_id` int(11) NOT NULL,
  `title_photo` varchar(45) NOT NULL,
  `comment_id` int(11) NOT NULL,
  `comment_photo` text NOT NULL,
  `photo_date` datetime NOT NULL,
  PRIMARY KEY (`user_id`,`photo_date`),
  UNIQUE KEY `photo_id_UNIQUE` (`photo_id`),
  UNIQUE KEY `comment_id_UNIQUE` (`comment_id`),
  CONSTRAINT `fk_photo_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
INSERT INTO `photo` VALUES (1,4,'autumn',4,'so sad','2013-01-01 08:14:03'),(2,1,'spring',1,'wonderfull','2010-01-01 08:54:03'),(6,2,'summer',2,'sunny','2011-01-01 08:14:03'),(6,3,'winter',3,'bzz','2012-01-01 08:44:03');
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_first_name` text NOT NULL,
  `user_last_name` text NOT NULL,
  `reg_day` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Ivan','asd','2009-06-04 22:00:00'),(2,'Alice','noname','2010-10-11 19:05:07'),(3,'Olya','zzz','2011-05-23 09:35:47'),(4,'Sveta','cccc','2012-12-03 11:53:15'),(5,'Typhus','Sss','2013-02-07 01:17:28'),(6,'Mama','Mia','2014-12-03 11:53:15');
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

-- Dump completed on 2020-11-18 21:06:12
