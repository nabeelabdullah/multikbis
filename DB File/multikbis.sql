CREATE DATABASE  IF NOT EXISTS `temp_multikbis` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `temp_multikbis`;
-- MySQL dump 10.13  Distrib 5.6.19, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: temp_multikbis
-- ------------------------------------------------------
-- Server version	5.6.19-1~exp1ubuntu2

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
-- Table structure for table `answer_id_holder`
--

DROP TABLE IF EXISTS `answer_id_holder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer_id_holder` (
  `id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer_id_holder`
--

LOCK TABLES `answer_id_holder` WRITE;
/*!40000 ALTER TABLE `answer_id_holder` DISABLE KEYS */;
INSERT INTO `answer_id_holder` VALUES ('AN0000000003');
/*!40000 ALTER TABLE `answer_id_holder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attachment`
--

DROP TABLE IF EXISTS `attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attachment` (
  `user_id` varchar(20) DEFAULT NULL,
  `post_id` varchar(20) DEFAULT NULL,
  `attach` varchar(20) DEFAULT NULL,
  `ext1` varchar(10) DEFAULT NULL,
  `ext2` varchar(10) DEFAULT NULL,
  `random` varchar(10) DEFAULT NULL,
  `no_of_attach` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attachment`
--

LOCK TABLES `attachment` WRITE;
/*!40000 ALTER TABLE `attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_detail`
--

DROP TABLE IF EXISTS `book_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_detail` (
  `book_id` varchar(20) DEFAULT NULL,
  `user_name` varchar(150) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  KEY `book_id` (`book_id`),
  KEY `bd_idx` (`book_id`),
  CONSTRAINT `book_detail_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book_info` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_detail`
--

LOCK TABLES `book_detail` WRITE;
/*!40000 ALTER TABLE `book_detail` DISABLE KEYS */;
INSERT INTO `book_detail` VALUES ('BI150326aaaaaaaaaa','nabeel abdullah','nabeelabdullah.11@gmail.com','1245858785','asxd',NULL),('BI150417aaaaaaaaab','nabeel abdullah','akhtar@gmail.com','7860921092','no any defect,',NULL),('BI150429aaaaaaaaac','nabeel abdullah','noman.akhtar@mkbis.com','7860921092','no any defect',NULL),('BI150429aaaaaaaaad','nabeel abdullah','akhtar2011@mkbis.com','7860921092','no defacts',NULL),('BI150429aaaaaaaaae','nabeel abdullah','iu@mkbis.com','7860921092','no defect',NULL),('BI150429aaaaaaaaaf','nabeel abdullah','noman.iu@gmail.com','7860921092','no defect',NULL),('BI150429aaaaaaaaag','nabeel abdullah','noman.iu@gmail.com','7860921092','no defect',NULL),('BI150429aaaaaaaaah','nabeel abdullah','noman.akhtar.iu@gmail.com','7860921092','no defect',NULL),('BI150429aaaaaaaaai','nabeel abdullah','noman.akhtar.iu@gmail.com','7860921092','no defect',NULL),('BI150429aaaaaaaaaj','nabeel abdullah','noman.akhtar2011@gmail.com','7860123654','no defect',NULL),('BI150429aaaaaaaaak','nabeel abdullah','noman.akhtar2011@gmail.com','7860123654','no defect',NULL),('BI150707aaaaaaaaal','nabeel abdullah','noman.akhtar2011@gmail.com','7860921092','cover page is defected',NULL),('BI150716aaaaaaaaam','nabeel abdullah','noman@gnail.com','78609271025','bjbb b bjbjb hjbhjb','integral university'),('BI150716aaaaaaaaan','nabeel abdullah','n@hmail.com','786464','bbjkrk rfbbf b','bjkbj bb bj'),('BI150716aaaaaaaaao','nabeel abdullah','noman@gmail.com','7860666555','no','smms'),('BI150717aaaaaaaaap','noman akhtar','n@hmail.xocm','786254','mo','sipah ibrahimabad madhuban mau uttar pradesh maunath bhanjan gorakgpure india'),('BI150717aaaaaaaaaq','noman akhtar','akhtar2011@gmail.com','7860921092','noman','integral boys hostel lucknow'),('BI150717aaaaaaaaar','noman akhtar','akhtar2011@gmail.com','7860921092','noman','integral boys hostel lucknow'),('BI150717aaaaaaaaas','noman akhtar','akhtar2011@gmail.com','7860921092','noman','integral boys hostel lucknow'),('BI150717aaaaaaaaat','noman akhtar','akhtar2011@gmail.com','7860921092','noman','integral boys hostel lucknow'),('BI150717aaaaaaaaau','noman akhtar','nommnq@jmail.com','64489489','jknjkn','kbjbjb ,n  kjiu  dbyubw jd jhebcdw  fchjhefds sj jfd fdc jdbufaieni fvubv j hjv hvdf');
/*!40000 ALTER TABLE `book_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_info`
--

DROP TABLE IF EXISTS `book_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_info` (
  `book_id` varchar(20) NOT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `catagory` varchar(100) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `college` varchar(100) DEFAULT NULL,
  `date` varchar(15) DEFAULT NULL,
  `time` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `bi_idx` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_info`
--

LOCK TABLES `book_info` WRITE;
/*!40000 ALTER TABLE `book_info` DISABLE KEYS */;
INSERT INTO `book_info` VALUES ('BI150326aaaaaaaaaa','UI0000000017','nabeel','Medical','123','as','integral university','26/MAR/2015','23:26:09'),('BI150417aaaaaaaaab','UI0000000017','Compiler','Engineering','200','Korth','integral university','17/APR/2015','23:25:54'),('BI150429aaaaaaaaac','UI0000000017','Java','Engineering','300','Black Book','integral university','29/APR/2015','22:20:08'),('BI150429aaaaaaaaad','UI0000000017','C','Engineering','500','Ritchi','integral university','29/APR/2015','22:22:28'),('BI150429aaaaaaaaae','UI0000000017','C','Engineering','700','Ritchi','integral university','29/APR/2015','22:37:59'),('BI150429aaaaaaaaaf','UI0000000017','OOps','Magazines','360','myself','integral university','29/APR/2015','22:43:07'),('BI150429aaaaaaaaag','UI0000000017','DatawareHouse','Engineering','505','akhtar','integral university','29/APR/2015','22:43:59'),('BI150429aaaaaaaaah','UI0000000017','Nural Network','Engineering','505','myself','integral university','29/APR/2015','22:44:39'),('BI150429aaaaaaaaai','UI0000000017','Real Time','Engineering','505','myself','integral university','29/APR/2015','22:45:17'),('BI150429aaaaaaaaaj','UI0000000017','WebTech','Engineering','450','SHIN','integral university','29/APR/2015','22:47:46'),('BI150429aaaaaaaaak','UI0000000017','Core Java','Engineering','450','mac david','integral university','29/APR/2015','22:49:04'),('BI150707aaaaaaaaal','UI0000000017','admin','Educationals &gt;Engineering','205','akhtar','integral university','07/JUL/2015','17:47:19'),('BI150716aaaaaaaaam','UI0000000017','mhjvjhvj','Educationals &gt;Management','64656','vhjvhvhjv','integral university','16/JUL/2015','00:41:37'),('BI150716aaaaaaaaan','UI0000000017','kjbb','Others','16','bbjbjb','integral university','16/JUL/2015','00:46:01'),('BI150716aaaaaaaaao','UI0000000017','daa','Educationals &gt;Engineering','250','noman','integral university','16/JUL/2015','23:43:45'),('BI150717aaaaaaaaap','UI0000000018','noman','Magazines','200','tom','integral university','17/JUL/2015','00:14:04'),('BI150717aaaaaaaaaq','UI0000000018','goo','Novels','320','noman','integral university','17/JUL/2015','00:30:00'),('BI150717aaaaaaaaar','UI0000000018','integral','Novels','320','noman','integral university','17/JUL/2015','00:32:22'),('BI150717aaaaaaaaas','UI0000000018','integral','Others','320','noman','integral university','17/JUL/2015','00:32:35'),('BI150717aaaaaaaaat','UI0000000018','integral','Novels','320','noman','integral university','17/JUL/2015','00:37:36'),('BI150717aaaaaaaaau','UI0000000018','noman','Magazines','2320','nnn','integral university','17/JUL/2015','00:39:31');
/*!40000 ALTER TABLE `book_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat` (
  `s_id` varchar(20) DEFAULT NULL,
  `msg` varchar(1000) DEFAULT NULL,
  `r_id` varchar(20) DEFAULT NULL,
  `id` varchar(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `chat_index` (`id`),
  KEY `chat_idx` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (NULL,NULL,NULL,'000000000000',NULL),('UI0000000018','hiiiiiiiiiiiiii','UI0000000017','CI0000000001','NOMAN AKHTAR '),('UI0000000017','ddddddddddd','UI0000000018','CI0000000002','NABEEL ABDULLAH '),('UI0000000017','hiiiiii','UI0000000018','CI0000000003','NABEEL ABDULLAH '),('UI0000000018','kkkkk','UI0000000017','CI0000000004','NOMAN AKHTAR '),('UI0000000018','jbj','UI0000000017','CI0000000005','NOMAN AKHTAR '),('UI0000000018','gooooooo','UI0000000017','CI0000000006','NOMAN AKHTAR '),('UI0000000017','gggggggggg','UI0000000018','CI0000000007','NABEEL ABDULLAH '),('UI0000000017','hiiiii','UI0000000018','CI0000000008','NABEEL ABDULLAH '),('UI0000000018','noman','UI0000000017','CI0000000009','NOMAN AKHTAR '),('UI0000000017','kjbbj','UI0000000018','CI000000000a','NABEEL ABDULLAH '),('UI0000000017','hooo','UI0000000018','CI000000000b','NABEEL ABDULLAH '),('UI0000000017','goopppppppppppp','UI0000000018','CI000000000c','NABEEL ABDULLAH '),('UI0000000017','hhhhhhhhhhhhhhhhhhhh','UI0000000018','CI000000000d','NABEEL ABDULLAH '),('UI0000000017','ggggggggg','UI0000000018','CI000000000e','NABEEL ABDULLAH '),('UI0000000017','hhhvvvvhvhvhv','UI0000000018','CI000000000f','NABEEL ABDULLAH '),('UI0000000017','ddddddddddddddddddddddddd','UI0000000018','CI000000000g','NABEEL ABDULLAH '),('UI0000000017','bdbd','UI0000000018','CI000000000h','NABEEL ABDULLAH '),('UI0000000017','eeeeeeeeeeeeeeeeeeeeeeeee','UI0000000018','CI000000000i','NABEEL ABDULLAH '),('UI0000000017','ttttttttttt','UI0000000018','CI000000000j','NABEEL ABDULLAH '),('UI0000000017','ddddddddddddddddddddddddddd','UI0000000018','CI000000000k','NABEEL ABDULLAH '),('UI0000000017','fffffffffffffffff','UI0000000018','CI000000000l','NABEEL ABDULLAH '),('UI0000000017','rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr','UI0000000018','CI000000000m','NABEEL ABDULLAH '),('UI0000000017','jhvvhvvv hv','UI0000000018','CI000000000n','NABEEL ABDULLAH '),('UI0000000017','guguyuygyu','UI0000000018','CI000000000o','NABEEL ABDULLAH '),('UI0000000017','ffffffffffffff','UI0000000018','CI000000000p','NABEEL ABDULLAH '),('UI0000000018','rrrrrrrrrrrrr','UI0000000017','CI000000000q','NOMAN AKHTAR '),('UI0000000017','hello','UI0000000018','CI000000000r','NABEEL ABDULLAH '),('UI0000000018','dddddddd','UI0000000017','CI000000000s','NOMAN AKHTAR '),('UI0000000017','gooooooooooo','UI0000000018','CI000000000t','NABEEL ABDULLAH '),('UI0000000017','hiiiiiiii','UI0000000018','CI000000000u','NABEEL ABDULLAH '),('UI0000000017','aaaaaaaaa','UI0000000018','CI000000000v','NABEEL ABDULLAH '),('UI0000000017','hiii','UI0000000018','CI000000000w','NABEEL ABDULLAH '),('UI0000000017','hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh','UI0000000018','CI000000000x','NABEEL ABDULLAH '),('UI0000000017','hello','UI0000000018','CI000000000y','NABEEL ABDULLAH '),('UI0000000017','iiiii','UI0000000018','CI000000000z','NABEEL ABDULLAH ');
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_record`
--

DROP TABLE IF EXISTS `comment_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment_record` (
  `comment_id` varchar(20) DEFAULT NULL,
  `c_user_id` varchar(20) DEFAULT NULL,
  `c_date` varchar(12) DEFAULT NULL,
  `c_time` varchar(12) DEFAULT NULL,
  `c_likes` int(12) DEFAULT NULL,
  KEY `comment_id` (`comment_id`),
  KEY `cr_idx` (`comment_id`),
  CONSTRAINT `comment_record_ibfk_1` FOREIGN KEY (`comment_id`) REFERENCES `user_comment` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_record`
--

LOCK TABLES `comment_record` WRITE;
/*!40000 ALTER TABLE `comment_record` DISABLE KEYS */;
INSERT INTO `comment_record` VALUES ('CI151115aaaaaaaaaa','UI0000000017','15/NOV/2015','17:36:18',1),('CI151116aaaaaaaaab','UI0000000017','16/NOV/2015','17:59:52',1);
/*!40000 ALTER TABLE `comment_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forget_pass`
--

DROP TABLE IF EXISTS `forget_pass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forget_pass` (
  `user_id` varchar(20) DEFAULT NULL,
  `nonce` varchar(20) DEFAULT NULL,
  KEY `fp_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forget_pass`
--

LOCK TABLES `forget_pass` WRITE;
/*!40000 ALTER TABLE `forget_pass` DISABLE KEYS */;
INSERT INTO `forget_pass` VALUES ('UI0000000017','4911736'),('UI0000000018','4911736');
/*!40000 ALTER TABLE `forget_pass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friends` (
  `table_id` varchar(20) NOT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `friend_id` varchar(20) DEFAULT NULL,
  `status` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`table_id`),
  KEY `f_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends`
--

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;
INSERT INTO `friends` VALUES ('FR000000000u','UI000000000b','UI000000000d','1'),('FR000000001s','UI000000000d','UI000000000b','1'),('FR000000001u','UI000000000n','UI000000000o','1'),('FR000000001v','UI000000000o','UI000000000p','1'),('FR000000001w','UI000000000p','UI000000000o','1'),('FR000000001x','UI000000000o','UI000000000n','1'),('FR0000000020','UI0000000012','UI0000000017','0'),('FR0000000023','UI0000000019','UI0000000017','0'),('FR000000002c','UI0000000017','UI0000000018','1'),('FR000000002d','UI0000000018','UI0000000017','1');
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends_table_id_holder`
--

DROP TABLE IF EXISTS `friends_table_id_holder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friends_table_id_holder` (
  `id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends_table_id_holder`
--

LOCK TABLES `friends_table_id_holder` WRITE;
/*!40000 ALTER TABLE `friends_table_id_holder` DISABLE KEYS */;
INSERT INTO `friends_table_id_holder` VALUES ('FR000000002d');
/*!40000 ALTER TABLE `friends_table_id_holder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_answer`
--

DROP TABLE IF EXISTS `group_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_answer` (
  `answer_id` varchar(20) NOT NULL,
  `question_id` varchar(20) DEFAULT NULL,
  `answer_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`answer_id`),
  KEY `ga_idx` (`answer_id`,`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_answer`
--

LOCK TABLES `group_answer` WRITE;
/*!40000 ALTER TABLE `group_answer` DISABLE KEYS */;
INSERT INTO `group_answer` VALUES ('AN0000000001','QS0000000001','UI0000000017'),('AN0000000002','QS0000000004','UI0000000017'),('AN0000000003','QS0000000006','UI0000000017');
/*!40000 ALTER TABLE `group_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_member`
--

DROP TABLE IF EXISTS `group_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_member` (
  `group_id` varchar(20) DEFAULT NULL,
  `member_id` varchar(20) DEFAULT NULL,
  KEY `gm_idx` (`group_id`,`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_member`
--

LOCK TABLES `group_member` WRITE;
/*!40000 ALTER TABLE `group_member` DISABLE KEYS */;
INSERT INTO `group_member` VALUES ('GI0000000000','UI0000000017'),('GI0000000001','UI0000000017'),('GI0000000008','UI0000000017');
/*!40000 ALTER TABLE `group_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_name`
--

DROP TABLE IF EXISTS `group_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_name` (
  `group_id` varchar(20) NOT NULL,
  `group_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`group_id`),
  KEY `gn_idx` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_name`
--

LOCK TABLES `group_name` WRITE;
/*!40000 ALTER TABLE `group_name` DISABLE KEYS */;
INSERT INTO `group_name` VALUES ('GI0000000000','CSE 1 4th YEAR'),('GI0000000001','CSE 2 4th YEAR'),('GI0000000002','CSE 3 4th YEAR'),('GI0000000003','CSE 4 4th YEAR'),('GI0000000004','CSE 1 3rd YEAR'),('GI0000000005','CSE 2 3rd YEAR'),('GI0000000006','CSE 3 3rd YEAR'),('GI0000000007','CSE 4 3rd YEAR'),('GI0000000008','CSE 1 2nd YEAR'),('GI0000000009','CSE 2 2nd YEAR'),('GI0000000010','CSE 3 2nd YEAR'),('GI0000000011','CSE 4 2nd YEAR'),('GI0000000012','CSE 1 1st YEAR'),('GI0000000013','CSE 2 1st YEAR');
/*!40000 ALTER TABLE `group_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_question`
--

DROP TABLE IF EXISTS `group_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_question` (
  `user_id` varchar(20) DEFAULT NULL,
  `group_id` varchar(20) DEFAULT NULL,
  `question_id` varchar(20) DEFAULT NULL,
  `answer_no` int(10) DEFAULT NULL,
  KEY `gq_idx` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_question`
--

LOCK TABLES `group_question` WRITE;
/*!40000 ALTER TABLE `group_question` DISABLE KEYS */;
INSERT INTO `group_question` VALUES ('UI0000000017','GI0000000000','QS0000000001',1),('UI0000000017','GI0000000001','QS0000000002',0),('UI0000000017','GI0000000000','QS0000000003',0),('UI0000000017','GI0000000000','QS0000000004',1),('UI0000000017','GI0000000002','QS0000000005',0),('UI0000000017','GI0000000001','QS0000000006',1);
/*!40000 ALTER TABLE `group_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_request`
--

DROP TABLE IF EXISTS `group_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_request` (
  `sender_id` varchar(20) NOT NULL DEFAULT '',
  `group_id` varchar(20) NOT NULL DEFAULT '',
  `accept` int(10) DEFAULT NULL,
  `reject` int(10) DEFAULT NULL,
  PRIMARY KEY (`sender_id`,`group_id`),
  KEY `gr_idx` (`sender_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_request`
--

LOCK TABLES `group_request` WRITE;
/*!40000 ALTER TABLE `group_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `id_holder`
--

DROP TABLE IF EXISTS `id_holder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `id_holder` (
  `chat_id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `id_holder`
--

LOCK TABLES `id_holder` WRITE;
/*!40000 ALTER TABLE `id_holder` DISABLE KEYS */;
INSERT INTO `id_holder` VALUES ('CI000000000z');
/*!40000 ALTER TABLE `id_holder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `on_off`
--

DROP TABLE IF EXISTS `on_off`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `on_off` (
  `user_id` varchar(20) NOT NULL,
  `status` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `on_off_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `on_off`
--

LOCK TABLES `on_off` WRITE;
/*!40000 ALTER TABLE `on_off` DISABLE KEYS */;
INSERT INTO `on_off` VALUES ('UI000000000a','0'),('UI000000000b','0'),('UI000000000c','0'),('UI000000000d','0'),('UI000000000i','0'),('UI000000000k','0'),('UI000000000m','0'),('UI000000000n','0'),('UI000000000o','0'),('UI000000000p','0'),('UI000000000r','0'),('UI000000000s','0'),('UI0000000012','0'),('UI0000000017','0'),('UI0000000018','1'),('UI0000000019','0');
/*!40000 ALTER TABLE `on_off` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_id_holder`
--

DROP TABLE IF EXISTS `question_id_holder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_id_holder` (
  `id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_id_holder`
--

LOCK TABLES `question_id_holder` WRITE;
/*!40000 ALTER TABLE `question_id_holder` DISABLE KEYS */;
INSERT INTO `question_id_holder` VALUES ('QS0000000006');
/*!40000 ALTER TABLE `question_id_holder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `user_id` varchar(20) NOT NULL,
  `first` varchar(100) DEFAULT NULL,
  `last` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `institute` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `day` varchar(2) DEFAULT NULL,
  `month` varchar(15) DEFAULT NULL,
  `year` varchar(4) DEFAULT NULL,
  `gender` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `r_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES ('UI0000000001','nabeel','abdullah','nabeelabdullah.11@gmail.com','7800179393','INTEGRALUNIVERSITY','LUCKNOW','2f6cf10b749c39ec05cf05421afe37ab87f4ad08076b9bb731b2f4b3e0dbf680065f2ae6aab851431305f51cfbaec96fdf0ed3d5e86a3edbd6c18265f58c680f','11','January','1993','male'),('UI0000000002','noman','akhtar','noman.akhtar2011@gmail.com','7800179393','INTEGRALUNIVERSITY','LUCKNOW','e12742064caaf960be48f63933c1b3f782eb2b61f90e54e04fe7df5271a571898d041ca6a0e18fe76a923c81dd9c0d68bcae615f35049f5aeea89412f7276c66','14','January','1993','male'),('UI0000000003','salahuddin','ahmad','salahuddiniu7@gmail.com','1236547895','INTEGRALUNIVERSITY','LUCKNOW','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2','17','January','1976','male'),('UI0000000004','salahuddin','ahmad','salahuddiniu@gmail.com','1234567895','INTEGRALUNIVERSITY','LUCKNOW','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2','29','January','1976','male'),('UI0000000005','nafees','ahmad','nafeesahmad1681@gmail.com','9506790877','INTEGRALUNIVERSITY','LUCKNOW','ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413','1','January','1991','male'),('UI0000000006','Nafees','Ahmad','78600000a@gmail.com','9506790877','INTEGRALUNIVERSITY','LUCKNOW','ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413','1','January','2000','male'),('UI0000000007','noman','akhtar','noman.2011@gmail.com','7860921092','INTEGRALUNIVERSITY','LUCKNOW','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2','15','March','1994','male'),('UI0000000008','salman','ahmad','salman@gmail.com','9621809380','INTEGRALUNIVERSITY','LUCKNOW','d5d623c49777ed10fa993773df849c1bad9174f08734d1f54141d8572d67cda9a21486acc4b2dba57f7786ec37f2fd97a0dadaa6001be1eabafdba9451520c13','11','December','1994','male'),('UI0000000009','imran','ahmad','imahmad48@gmail.com','8574121636','INTEGRALUNIVERSITY','LUCKNOW','4b21b7432e829bc1779e5f5dea8940e5fdda67f850e66999ce4d7eb1c4256da874adb90cf92d845a8716e74e3847c71da685a2502e40513373857dd86ab0aaa7','2','June','1994','male'),('UI000000000a','Sufiyan','Akhtar','sufiyan@gsc.net','9876543210','INTEGRALUNIVERSITY','LUCKNOW','690437692d902cfd23005bda16631d83644899e78dc0a489da6dca3cb9f9c0cdcd9dd533bc59102dc90155223df777672328c9149354de239f48c58f0a1d44a6','15','June','2000','male'),('UI000000000b','Basheer','Ahmad','jeetrainer@gmail.com','9792909239','INTEGRALUNIVERSITY','LUCKNOW','0a48bfd2eee85c342716493d25576202ae2256426dcb0d4a64ad41e35b9c53461d54658755dbe96b25ee9585e72c6f0ee183711fb984b667e478f5752e1cd741','13','July','1982','male'),('UI000000000c','Raghav','Mathur','raghavmathur77@gmail.com','9532037938','INTEGRALUNIVERSITY','LUCKNOW','c77e19dfa84dc1989c8db958df7e50791fce8fdebfdcc8fa9bb305ae1c57f66256be2bda170a39cae4a466ec3db1d48dbda51460a1051b1584706b5ab3ae691a','7','April','1993','male'),('UI000000000d','adeeb','khan','adeebkhan.it@gmail.com','7309191792','INTEGRALUNIVERSITY','LUCKNOW','eedb470e9c17b028bc438a7365283fd938e2c1ab7efc9ae62ad903cf58afc55c24774557019027b26f8e59aa3aa91968d60e90c3eb2e1a5634e07a45ad153155','28','Auguest','1992','male'),('UI000000000e','shahnoor','khan','shanoorkhan1200@gmail.com','9889715688','INTEGRALUNIVERSITY','LUCKNOW','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2','7','February','1993','male'),('UI000000000f','radhe','shyam','radhe@gmail.com','0000000000','INTEGRALUNIVERSITY','nill','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2','17','January','1977','male'),('UI000000000g','ankita','srivastav','ankita@gmail.com','0000000000','INTEGRALUNIVERSITY','nill','c9f725a4b3faeb3661a09683d27fd7dd707a4379d36ee11ca8123e5e1ee8b2633d2e992dace0c91302a536302f939f6a6668831df192f12bb3d8ac99d20649f4','17','March','1976','female'),('UI000000000h','akhtar','noman','akhtar@gmail.com','0000000000','INTEGRALUNIVERSITY','nill','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2','14','March','1999','male'),('UI000000000i','Mohsin','Khan','mohsinkhan00700@gmail.com','0000000000','INTEGRALUNIVERSITY','nill','5a04c2d325cbe96a42899d7062c04469d130346ef0c2e93f4f861d761c0b926c761fc9f66f9fed5a48072540ce96c7cd2ba73448c834e95d7380eb5981e86608','18','May','1993','male'),('UI000000000k','faiz','mateen','faiz007.mateen@gmail.com','0000000000','INTEGRALUNIVERSITY','nill','e49fea36c129ce9583404ad4c45abced932ce510dd74d7b9926fdec682d2d845d3aa4178b80afd3dedeaa3f1be4dd5b5ce85d0868de24aa05a8288a10bebe677','7','Auguest','1992','male'),('UI000000000m','umar','ata','umarata.cse4@gmail.com','0000000000','INTEGRALUNIVERSITY','nill','ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413','1','January','2000','male'),('UI000000000n','Anoop','Maurya','akmaurya@iul.ac.in','0000000000','INTEGRALUNIVERSITY','nill','d9e6762dd1c8eaf6d61b3c6192fc408d4d6d5f1176d0c29169bc24e71c3f274ad27fcd5811b313d681f7e55ec02d73d499c95455b6b5bb503acf574fba8ffe85','15','July','1990','male'),('UI000000000o','ankur','singh','ankur.tendlya@gmail.com','0000000000','INTEGRALUNIVERSITY','nill','d9e6762dd1c8eaf6d61b3c6192fc408d4d6d5f1176d0c29169bc24e71c3f274ad27fcd5811b313d681f7e55ec02d73d499c95455b6b5bb503acf574fba8ffe85','10','November','1990','male'),('UI000000000p','hemant','shukla','chauhan@iul.ac.in','0000000000','INTEGRALUNIVERSITY','nill','3627909a29c31381a071ec27f7c9ca97726182aed29a7ddd2e54353322cfb30abb9e3a6df2ac2c20fe23436311d678564d0c8d305930575f60e2d3d048184d79','2','April','1992','male'),('UI000000000r','zainab','afreen','zainabafreen25@gmail.com','0000000000','INTEGRALUNIVERSITY','nill','5e27561545fcf251d33f44729cd40151bc94d57e0194a9340b725bbe9ef315be4c677e019a4a40ee371d546090cb120a0264ef55882bc6972d16fc4ad00c550d','25','May','2000','female'),('UI000000000u','Mukesh','Rai','mukeshrai90@gmail.com','0000000000','INTEGRALUNIVERSITY','nill','ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413','6','September','1991','male'),('UI000000000v','Ali','Niazi','mca.aliniazi@gmail.com','0000000000','INTEGRALUNIVERSITY','nill','2c410144c210d8ea4d3bdea7a1412228f03a50e9275fbc959589dc4b31be800d351af26516e31458f3bbe6db5369569e14b93cd99db3a4379bce7bf34ea3e88c','25','February','1990','male'),('UI000000000w','Zishan','Mohsin','zishan2050@gmail.com','0000000000','INTEGRALUNIVERSITY','nill','f1ecb37cc45de7b5e816917b042f258e37bd81e95a4352723c172d20095418d82e3c05838912b8801f4f0d215969c0188509868f26735eddc5293880ef0a4c06','6','October','1992','male'),('UI000000000x','irfan','alam','irfanalam.iu@gmail.com','0000000000','INTEGRALUNIVERSITY','nill','2b8ae51192fc02b8067a593bfcf6beba4d9012a8747011a3472a6718e6503d443e4538f271d3f0b4d4eb13d69d88076ac13b99fcc4186ac71c2d9ae84a87fdf3','5','November','1990','male'),('UI000000000y','masroor','anwar','masrooranwar1990@gmail.com','0000000000','INTEGRALUNIVERSITY','nill','93e73174b9909e0b439c111b3bcd0993cdd47cda90e3f7bbfd765e3476d3bc8d48f478b4253f7e0610cf54ff13adc1d2d2d723626eb489f8efd67237ea7702a0','5','November','1992','male'),('UI000000000z','yusuf','khan','yusufkhan1200@gmail.com','0000000000','INTEGRALUNIVERSITY','nill','5e0d1fb6f4626a3a6a30f83d7d167dcac93a94f5f22af86d4ed88670f3010cbed30c255e80d528c7c215adb77e897b3b3a99000767e43fc162a01455e2b7f3b6','17','May','1972','male'),('UI0000000012','rukhsar','fatima','rukhsarfatima59@gmail.com','0000000000','INTEGRALUNIVERSITY','nill','12b798133143ad0052ab63db248e944175e9032124cae88ce54baae2834870df071fe361f0d36680c81a84c4538ee07d0ccb6607f413e5cb62528b4a9f2deb27','2','February','1994','female'),('UI0000000017','nabeel','abdullah','nabeelabdullah.11@gmail.com','0000000000','INTEGRAL UNIVERSITY','nill','2f6cf10b749c39ec05cf05421afe37ab87f4ad08076b9bb731b2f4b3e0dbf680065f2ae6aab851431305f51cfbaec96fdf0ed3d5e86a3edbd6c18265f58c680f','5','April','1993','male'),('UI0000000018','noman','akhtar','noman.akhtar2011@gmail.com','0000000000','INTEGRAL UNIVERSITY','nill','6991a060304fffea817dc36c7d385e9dbcd42f9d49d2b1b5211bf872913ffc3249d2a712645b6e80e2c2eaf998dc5589db366c63492f487f761104a3e1ce7472','15','March','1994','male'),('UI0000000019','noman','abdullah','noman1236@gmail.com','0000000000','INTEGRAL UNIVERSITY','nill','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2','17','March','1975','male');
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_id_holder`
--

DROP TABLE IF EXISTS `request_id_holder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request_id_holder` (
  `old_id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_id_holder`
--

LOCK TABLES `request_id_holder` WRITE;
/*!40000 ALTER TABLE `request_id_holder` DISABLE KEYS */;
INSERT INTO `request_id_holder` VALUES ('RI0000000000');
/*!40000 ALTER TABLE `request_id_holder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `search_record`
--

DROP TABLE IF EXISTS `search_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `search_record` (
  `post_id` varchar(20) NOT NULL,
  `topic` varchar(100) DEFAULT NULL,
  `likes` int(15) DEFAULT NULL,
  `no_of_attach` varchar(5) DEFAULT NULL,
  `total_comment` varchar(10) DEFAULT '0',
  `p_date` varchar(12) DEFAULT NULL,
  `p_time` varchar(12) DEFAULT NULL,
  `ext1` varchar(10) DEFAULT NULL,
  `ext2` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `sr_idx` (`post_id`),
  CONSTRAINT `search_record_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `user_post` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `search_record`
--

LOCK TABLES `search_record` WRITE;
/*!40000 ALTER TABLE `search_record` DISABLE KEYS */;
INSERT INTO `search_record` VALUES ('PI151115aaaaaaaaaa','ddd',0,'0','1','15/NOV/2015','17:19:46',NULL,NULL),('PI151115aaaaaaaaab','hello',0,'0','0','15/NOV/2015','18:11:53',NULL,NULL),('PI151115aaaaaaaaac','sss',0,'0','1','15/NOV/2015','18:31:05',NULL,NULL);
/*!40000 ALTER TABLE `search_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temp_tamil`
--

DROP TABLE IF EXISTS `temp_tamil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temp_tamil` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Symbols_Value` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=366 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temp_tamil`
--

LOCK TABLES `temp_tamil` WRITE;
/*!40000 ALTER TABLE `temp_tamil` DISABLE KEYS */;
INSERT INTO `temp_tamil` VALUES (1,3),(2,4),(3,0),(4,0),(5,8),(6,0),(7,0),(8,16),(9,0),(10,0),(11,0),(12,0),(13,0),(14,0),(15,0),(16,1),(17,0),(18,4),(19,0),(20,32),(21,0),(22,0),(23,0),(24,0),(25,0),(26,0),(27,0),(28,0),(29,0),(30,1),(31,0),(32,4),(33,0),(34,8),(35,0),(36,0),(37,0),(38,16),(39,0),(40,0),(41,0),(42,0),(43,0),(44,0),(45,0),(46,1),(47,4),(48,0),(49,32),(50,0),(51,0),(52,0),(53,0),(54,0),(55,0),(56,2),(57,0),(58,0),(59,0),(60,1),(61,4),(62,0),(63,0),(64,8),(65,0),(66,0),(67,0),(68,16),(69,0),(70,0),(71,0),(72,0),(73,0),(74,0),(75,0),(76,1),(77,4),(78,0),(79,32),(80,0),(81,0),(82,0),(83,0),(84,2),(85,0),(86,0),(87,0),(88,0),(89,0),(90,1),(91,4),(92,0),(93,0),(94,8),(95,0),(96,0),(97,0),(98,16),(99,0),(100,0),(101,0),(102,0),(103,0),(104,0),(105,1),(106,4),(107,0),(108,32),(109,0),(110,2),(111,0),(112,0),(113,0),(114,0),(115,0),(116,0),(117,0),(118,0),(119,1),(120,0),(121,4),(122,0),(123,0),(124,8),(125,0),(126,0),(127,16),(128,0),(129,0),(130,0),(131,0),(132,0),(133,0),(134,1),(135,4),(136,0),(137,0),(138,34),(139,0),(140,0),(141,0),(142,0),(143,0),(144,0),(145,0),(146,0),(147,0),(148,0),(149,1),(150,0),(151,4),(152,0),(153,8),(154,0),(155,0),(156,16),(157,0),(158,0),(159,0),(160,0),(161,0),(162,0),(163,1),(164,0),(165,6),(166,0),(167,32),(168,0),(169,0),(170,0),(171,0),(172,0),(173,0),(174,0),(175,0),(176,0),(177,0),(178,0),(179,1),(180,4),(181,0),(182,0),(183,8),(184,0),(185,0),(186,16),(187,0),(188,0),(189,0),(190,0),(191,0),(192,2),(193,1),(194,4),(195,0),(196,0),(197,32),(198,0),(199,0),(200,0),(201,0),(202,0),(203,0),(204,0),(205,0),(206,0),(207,0),(208,1),(209,0),(210,4),(211,0),(212,8),(213,0),(214,0),(215,16),(216,0),(217,0),(218,0),(219,0),(220,2),(221,0),(222,1),(223,4),(224,0),(225,0),(226,32),(227,0),(228,0),(229,0),(230,0),(231,0),(232,0),(233,0),(234,0),(235,0),(236,0),(237,0),(238,1),(239,4),(240,0),(241,8),(242,0),(243,0),(244,16),(245,0),(246,0),(247,0),(248,0),(249,0),(250,0),(251,1),(252,0),(253,4),(254,0),(255,0),(256,32),(257,0),(258,0),(259,0),(260,0),(261,0),(262,0),(263,0),(264,0),(265,0),(266,0),(267,1),(268,4),(269,0),(270,0),(271,8),(272,0),(273,0),(274,18),(275,0),(276,0),(277,0),(278,0),(279,0),(280,0),(281,1),(282,0),(283,4),(284,0),(285,32),(286,0),(287,0),(288,0),(289,0),(290,0),(291,0),(292,0),(293,0),(294,0),(295,0),(296,0),(297,1),(298,4),(299,0),(300,8),(301,0),(302,2),(303,16),(304,0),(305,0),(306,0),(307,0),(308,0),(309,0),(310,0),(311,1),(312,0),(313,4),(314,0),(315,32),(316,0),(317,0),(318,0),(319,0),(320,0),(321,0),(322,0),(323,0),(324,0),(325,0),(326,1),(327,4),(328,0),(329,10),(330,0),(331,0),(332,0),(333,16),(334,0),(335,0),(336,0),(337,0),(338,0),(339,0),(340,0),(341,1),(342,4),(343,0),(344,0),(345,32),(346,0),(347,0),(348,0),(349,0),(350,0),(351,0),(352,0),(353,0),(354,0),(355,1),(356,0),(357,4),(358,0),(359,8),(360,0),(361,0),(362,16),(363,0),(364,0),(365,0);
/*!40000 ALTER TABLE `temp_tamil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testing`
--

DROP TABLE IF EXISTS `testing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `testing` (
  `val` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testing`
--

LOCK TABLES `testing` WRITE;
/*!40000 ALTER TABLE `testing` DISABLE KEYS */;
INSERT INTO `testing` VALUES (12),(13),(NULL);
/*!40000 ALTER TABLE `testing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_comment`
--

DROP TABLE IF EXISTS `user_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_comment` (
  `post_id` varchar(20) DEFAULT NULL,
  `comment_id` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`comment_id`),
  UNIQUE KEY `uc_idx` (`comment_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `user_comment_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `user_post` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_comment`
--

LOCK TABLES `user_comment` WRITE;
/*!40000 ALTER TABLE `user_comment` DISABLE KEYS */;
INSERT INTO `user_comment` VALUES ('PI151115aaaaaaaaaa','CI151115aaaaaaaaaa'),('PI151115aaaaaaaaac','CI151116aaaaaaaaab');
/*!40000 ALTER TABLE `user_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_id`
--

DROP TABLE IF EXISTS `user_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_id` (
  `user_id` varchar(20) NOT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `ui_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_id`
--

LOCK TABLES `user_id` WRITE;
/*!40000 ALTER TABLE `user_id` DISABLE KEYS */;
INSERT INTO `user_id` VALUES ('UI000000000a','Sufiyan Akhtar'),('UI000000000b','Basheer Ahmad'),('UI000000000c','Raghav Mathur'),('UI000000000d','adeeb khan'),('UI000000000i','Mohsin Khan'),('UI000000000k','faiz mateen'),('UI000000000m','umar ata'),('UI000000000n','Anoop Maurya'),('UI000000000o','ankur singh'),('UI000000000p','hemant shukla'),('UI000000000r','zainab afreen'),('UI000000000s','Mohd Salman'),('UI0000000012','rukhsar fatima'),('UI0000000017','nabeel abdullah'),('UI0000000018','noman akhtar'),('UI0000000019','noman abdullah');
/*!40000 ALTER TABLE `user_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_id_holder`
--

DROP TABLE IF EXISTS `user_id_holder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_id_holder` (
  `max_id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_id_holder`
--

LOCK TABLES `user_id_holder` WRITE;
/*!40000 ALTER TABLE `user_id_holder` DISABLE KEYS */;
INSERT INTO `user_id_holder` VALUES ('UI0000000019');
/*!40000 ALTER TABLE `user_id_holder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_login`
--

DROP TABLE IF EXISTS `user_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_login` (
  `user_id` varchar(20) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `user_pass` varchar(128) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `ul_idx` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_login`
--

LOCK TABLES `user_login` WRITE;
/*!40000 ALTER TABLE `user_login` DISABLE KEYS */;
INSERT INTO `user_login` VALUES ('UI000000000a','sufiyan@gsc.net','690437692d902cfd23005bda16631d83644899e78dc0a489da6dca3cb9f9c0cdcd9dd533bc59102dc90155223df777672328c9149354de239f48c58f0a1d44a6',1),('UI000000000b','jeetrainer@gmail.com','0a48bfd2eee85c342716493d25576202ae2256426dcb0d4a64ad41e35b9c53461d54658755dbe96b25ee9585e72c6f0ee183711fb984b667e478f5752e1cd741',1),('UI000000000c','raghavmathur77@gmail.com','c77e19dfa84dc1989c8db958df7e50791fce8fdebfdcc8fa9bb305ae1c57f66256be2bda170a39cae4a466ec3db1d48dbda51460a1051b1584706b5ab3ae691a',1),('UI000000000d','adeebkhan.it@gmail.com','eedb470e9c17b028bc438a7365283fd938e2c1ab7efc9ae62ad903cf58afc55c24774557019027b26f8e59aa3aa91968d60e90c3eb2e1a5634e07a45ad153155',1),('UI000000000i','mohsinkhan00700@gmail.com','5a04c2d325cbe96a42899d7062c04469d130346ef0c2e93f4f861d761c0b926c761fc9f66f9fed5a48072540ce96c7cd2ba73448c834e95d7380eb5981e86608',1),('UI000000000k','faiz007.mateen@gmail.com','e49fea36c129ce9583404ad4c45abced932ce510dd74d7b9926fdec682d2d845d3aa4178b80afd3dedeaa3f1be4dd5b5ce85d0868de24aa05a8288a10bebe677',1),('UI000000000m','umarata.cse4@gmail.com','ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413',1),('UI000000000n','akmaurya@iul.ac.in','d9e6762dd1c8eaf6d61b3c6192fc408d4d6d5f1176d0c29169bc24e71c3f274ad27fcd5811b313d681f7e55ec02d73d499c95455b6b5bb503acf574fba8ffe85',1),('UI000000000o','ankur.tendlya@gmail.com','d9e6762dd1c8eaf6d61b3c6192fc408d4d6d5f1176d0c29169bc24e71c3f274ad27fcd5811b313d681f7e55ec02d73d499c95455b6b5bb503acf574fba8ffe85',1),('UI000000000p','chauhan@iul.ac.in','3627909a29c31381a071ec27f7c9ca97726182aed29a7ddd2e54353322cfb30abb9e3a6df2ac2c20fe23436311d678564d0c8d305930575f60e2d3d048184d79',1),('UI000000000r','zainabafreen25@gmail.com','5e27561545fcf251d33f44729cd40151bc94d57e0194a9340b725bbe9ef315be4c677e019a4a40ee371d546090cb120a0264ef55882bc6972d16fc4ad00c550d',1),('UI000000000s','salmann511@gmail.com','f5b6f3f3f7239eadb6a7386c781196c7e4b4048ccdd827ff2904dcee7bcb9d149eeb2dbf03a78133f6aa7fde6a2fcadb9dacacf9e212ac7ab32dbb12ca4bf5b5',1),('UI0000000012','rukhsarfatima59@gmail.com','12b798133143ad0052ab63db248e944175e9032124cae88ce54baae2834870df071fe361f0d36680c81a84c4538ee07d0ccb6607f413e5cb62528b4a9f2deb27',1),('UI0000000017','nabeelabdullah.11@gmail.com','2f6cf10b749c39ec05cf05421afe37ab87f4ad08076b9bb731b2f4b3e0dbf680065f2ae6aab851431305f51cfbaec96fdf0ed3d5e86a3edbd6c18265f58c680f',1),('UI0000000018','noman.akhtar2011@gmail.com','6991a060304fffea817dc36c7d385e9dbcd42f9d49d2b1b5211bf872913ffc3249d2a712645b6e80e2c2eaf998dc5589db366c63492f487f761104a3e1ce7472',1),('UI0000000019','noman1236@gmail.com','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',1);
/*!40000 ALTER TABLE `user_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_post`
--

DROP TABLE IF EXISTS `user_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_post` (
  `user_id` varchar(20) DEFAULT NULL,
  `post_id` varchar(20) NOT NULL,
  PRIMARY KEY (`post_id`),
  UNIQUE KEY `up_idx` (`post_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_post_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_post`
--

LOCK TABLES `user_post` WRITE;
/*!40000 ALTER TABLE `user_post` DISABLE KEYS */;
INSERT INTO `user_post` VALUES ('UI0000000017','PI151115aaaaaaaaaa'),('UI0000000017','PI151115aaaaaaaaab'),('UI0000000017','PI151115aaaaaaaaac');
/*!40000 ALTER TABLE `user_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_profile` (
  `user_id` varchar(20) NOT NULL,
  `sch_from` varchar(200) DEFAULT NULL,
  `sec_from` varchar(200) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `a_o_e` varchar(100) DEFAULT NULL,
  `collage` varchar(100) DEFAULT NULL,
  `live_in` varchar(200) DEFAULT NULL,
  `found_off` varchar(100) DEFAULT NULL,
  `course` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `upr_idx` (`user_id`),
  CONSTRAINT `user_profile_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profile`
--

LOCK TABLES `user_profile` WRITE;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` VALUES ('UI000000000a','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','Sufiyan Akhtar'),('UI000000000b','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','Basheer Ahmad'),('UI000000000c','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','Raghav Mathur'),('UI000000000d','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','adeeb khan'),('UI000000000i','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','Mohsin Khan'),('UI000000000k','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','faiz mateen'),('UI000000000m','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','umar ata'),('UI000000000n','NIL','NIL','akmaurya@iul.ac.in','NIL','NIL','Integral','NIL','NIL','NIL','NIL','Anoop Maurya'),('UI000000000o','null','null','null','null','null','null','null','null','null','null','ankur singh'),('UI000000000p','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','hemant shukla'),('UI0000000012',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'rukhsar fatima'),('UI0000000017','integral university','NIL','NIL','NIL','NIL','NIL','Lucknow','NIL','NIL','cse','nabeel abdullah'),('UI0000000018','Integral university','NIL','noman.akhtar2011@gmail.com','NIL','NIL','NIL','NIL','NIL','NIL','NIL','noman akhtar'),('UI0000000019','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','NIL','noman abdullah');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-09 17:32:07
