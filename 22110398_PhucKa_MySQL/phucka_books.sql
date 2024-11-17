-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: phucka
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `bookid` int NOT NULL,
  `isbn` int DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `publisher` varchar(100) DEFAULT NULL,
  `price` decimal(6,2) DEFAULT NULL,
  `description` mediumtext,
  `publish_date` date DEFAULT NULL,
  `cover_image` varchar(100) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,123,'Chí Phèo','NXB Văn học',45.00,'Một tác phẩm nổi tiếng của Nam Cao, miêu tả cuộc đời nhân vật Chí Phèo.','1960-01-01','chiphèo.jpg',100),(2,123,'Lão Hạc','NXB Văn học',50.00,'Tác phẩm nổi tiếng của Nam Cao, kể về câu chuyện bi thảm của ông lão Hạc.','1962-01-01','laohac.jpg',80),(3,123,'Vang bóng một thời','NXB Hội Nhà văn',60.00,'Tác phẩm nổi tiếng của Nguyễn Tuân, miêu tả vẻ đẹp của cảnh vật và con người Việt Nam trước cách mạng.','1940-01-01','vangbongmotthoi.jpg',150),(4,123,'Tùy bút sông Đà','NXB Văn học',70.00,'Tác phẩm của Nguyễn Tuân, viết về dòng sông Đà và vẻ đẹp của nó.','1955-01-01','tuybutsongda.jpg',120),(5,123,'Thơ thơ','NXB Văn học',40.00,'Tập thơ đầu tay của Xuân Diệu, mang đậm ảnh hưởng của phong trào Thơ Mới.','1938-01-01','thotho.jpg',200),(6,123,'Gửi hương cho gió','NXB Hội Nhà văn',50.00,'Tập thơ nổi tiếng của Xuân Diệu, với những bài thơ tình yêu và nỗi niềm riêng tư.','1945-01-01','guihuongchogio.jpg',180),(7,123,'Mắt biếc','NXB Trẻ',90.00,'Tiểu thuyết nổi tiếng của Nguyễn Nhật Ánh, kể về câu chuyện tình yêu ngọt ngào và day dứt của nhân vật trong suốt thời gian dài.','1990-01-01','matbiec.jpg',250),(8,123,'Cho tôi xin một vé đi tuổi thơ','NXB Hội Nhà văn',65.00,'Một tác phẩm của Nguyễn Nhật Ánh về những ký ức tuổi thơ đẹp đẽ và lãng mạn.','1995-01-01','chotoisinmotvedituoitho.jpg',300);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-17 22:58:43
