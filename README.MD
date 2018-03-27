#Phonebook#
---
Tech stack: Java 8, Spring Boot, Spring MVC, Spring Data, Hibernate, MySQL, JSP
---
Program functions:
* Login in
* Site registration
* User Info
* Information about phonebook contacts
* Search by name, surname and phone number. You can search for part of the surname, name and phone number
* Add, update, or delete contacts
* Log out
---
DB:
> MySQL. To create all necessary tables and make test contacts in them - run the sql query (path - /home/andrey/IdeaProjects/phonebook/src/main/resources/sql/dump.sql)
> Or run this code 
<-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
 --
 -- Host: 127.0.0.1    Database: phonebook
 -- ------------------------------------------------------
 -- Server version	5.7.21-0ubuntu0.16.04.1
 
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
 -- Table structure for table `phone_number`
 --
 
 DROP TABLE IF EXISTS `phone_number`;
 /*!40101 SET @saved_cs_client     = @@character_set_client */;
 /*!40101 SET character_set_client = utf8 */;
 CREATE TABLE `phone_number` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `email` varchar(255) DEFAULT NULL,
   `name` varchar(255) DEFAULT NULL,
   `patronymic` varchar(255) DEFAULT NULL,
   `phone_number` varchar(255) DEFAULT NULL,
   `surname` varchar(255) DEFAULT NULL,
   `user_id` bigint(20) DEFAULT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `phone_number_id_uindex` (`id`),
   KEY `FKa2rs298303a3x456x2mpqje9s` (`user_id`),
   CONSTRAINT `FKa2rs298303a3x456x2mpqje9s` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
 /*!40101 SET character_set_client = @saved_cs_client */;
 
 --
 -- Dumping data for table `phone_number`
 --
 
 LOCK TABLES `phone_number` WRITE;
 /*!40000 ALTER TABLE `phone_number` DISABLE KEYS */;
 INSERT INTO `phone_number` VALUES (17,'gmail@gmail.com','Alex','Vladimirovich','+380501111111','Abbott',1),(18,'yandex@yandex.com','Bob','Vladimirovich','+380632222222','Abbott',6),(22,'ukrnet@ukr.net','Alex','Vladimirovich','+380961112222','Ady',1),(24,'bigmir@bigmir.net','bob','Vladimirovich','+380932221111','Ady',1);
 /*!40000 ALTER TABLE `phone_number` ENABLE KEYS */;
 UNLOCK TABLES;
 
 --
 -- Table structure for table `users`
 --
 
 DROP TABLE IF EXISTS `users`;
 /*!40101 SET @saved_cs_client     = @@character_set_client */;
 /*!40101 SET character_set_client = utf8 */;
 CREATE TABLE `users` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `email` varchar(255) DEFAULT NULL,
   `password` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `users_id_uindex` (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
 /*!40101 SET character_set_client = @saved_cs_client */;
 
 --
 -- Dumping data for table `users`
 --
 
 LOCK TABLES `users` WRITE;
 /*!40000 ALTER TABLE `users` DISABLE KEYS */;
 INSERT INTO `users` VALUES (1,'a.potiha@gmail.com','111'),(6,'p.andrey@gmail.com','111');
 /*!40000 ALTER TABLE `users` ENABLE KEYS */;
 UNLOCK TABLES;
 
 --
 -- Table structure for table `users_phone_numbers`
 --
 
 DROP TABLE IF EXISTS `users_phone_numbers`;
 /*!40101 SET @saved_cs_client     = @@character_set_client */;
 /*!40101 SET character_set_client = utf8 */;
 CREATE TABLE `users_phone_numbers` (
   `user_id` bigint(20) NOT NULL,
   `phone_numbers_id` bigint(20) NOT NULL,
   UNIQUE KEY `UK_s1ijol8m1vedytx1v64u95jxp` (`phone_numbers_id`),
   KEY `FKlhdsfbuq6dw3qlwohua41lwb6` (`user_id`),
   CONSTRAINT `FK3w8swqw0wjsgmidcy7ruyd7g2` FOREIGN KEY (`phone_numbers_id`) REFERENCES `phone_number` (`id`),
   CONSTRAINT `FKlhdsfbuq6dw3qlwohua41lwb6` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 /*!40101 SET character_set_client = @saved_cs_client */;
 
 --
 -- Dumping data for table `users_phone_numbers`
 --
 
 LOCK TABLES `users_phone_numbers` WRITE;
 /*!40000 ALTER TABLE `users_phone_numbers` DISABLE KEYS */;
 /*!40000 ALTER TABLE `users_phone_numbers` ENABLE KEYS */;
 UNLOCK TABLES;
 /*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
 
 /*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
 /*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
 /*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
 /*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
 /*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
 /*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
 /*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
 
 -- Dump completed on 2018-03-26 12:05:52
>

---
> After running dump.sql, you will see - 2 users and contacts:
 >> 1. Login a.potiha@gmail.com, password — 111
 >> 2. Login p.andrey@gmail.com, password — 111
 ---
>The interface is very simple, it has only 2 tabs: Info  - information about logged in and All contacts - with the output of all contacts and the filter option.