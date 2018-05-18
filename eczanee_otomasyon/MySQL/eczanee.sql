-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: eczanee
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `ilac_bilgisi`
--

DROP TABLE IF EXISTS `ilac_bilgisi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ilac_bilgisi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ilac_adi` varchar(45) NOT NULL,
  `uretici_firma` varchar(45) NOT NULL,
  `ilac_fiyati` double NOT NULL,
  `adet` varchar(20) NOT NULL,
  `kullanim_amaci` varchar(70) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ilac_bilgisi`
--

LOCK TABLES `ilac_bilgisi` WRITE;
/*!40000 ALTER TABLE `ilac_bilgisi` DISABLE KEYS */;
INSERT INTO `ilac_bilgisi` VALUES (1,'Aqua fresh','ELEGANCE',25,'1','Lens Solüsyonu'),(2,'Magnesie Calcine  TOZ','Saba',30,'2','Antiasid, Adsorban, Laksatif Rahatsızlıklarda'),(3,'Naprosyn','ABDIİBRAHİM',5.5,'3','Eklem Kıkırdağı İtihabı ve Eklemde Oluşan Komplike Ağrılarda'),(4,'Allerset 10 Mg','Santa Farma',12,'1','Antialerjik, Reaksiyonlara Bağlı oluşan alerjik sorunlarda'),(5,'SULFARHİN','Santa Farma',7.5,'4','Burunda oluşan iltihaba bağlı dekonjestan özellikli burun pomadı'),(6,'NİMES','Sanovel',10,'2','Eklem Kıkırdağı hassasiyeti ile oluşan,ağrı,iltihap giderilmesinde'),(7,'Apikobal','Santa Farma ',15,'3','B12,B6,B9 vitamin eksikliğinde'),(8,'StrepSpray + Plus','Drogsan İlac San.',8,'1','Gribe bağlı  boğaz enfeksiyonunda'),(9,'CİPRO 750 Mg','Biofarma',6.5,'2','Enfesiyona bağlı antibiyotik'),(10,'Ferrum Fort ','Lab. Hausmann',35,'2','Demir eksikliğine bağlı '),(11,'SivEx LOSYON','ORVA',20,'3','Akne ve iltihaplı sivilce tedavisinde'),(12,'METPAMİD ','SİFAR',3.5,'1','Mide bulantısı tedavisinde'),(13,'Lorders 5 mg','NOBEL',12.4,'2','Mevsimsel alerjik rinit ve tedavisinde'),(14,'Famoser 40 mg','Biofarma',6,'1','Midede oluşan fazla asitin dengelenmesinde'),(15,'Talcid Tablet','BAYER',8.5,'2','Midede oluşan gazın önlenmesinde'),(16,'NewCal D3 Efervasan Tablet','Neutec ',45,'3','Kalsiyum ve Magnezyum Eksikliğinde'),(17,'Beneday Tablet','Takeda',20,'1','B1-B6-12 ve ALA Eksikliğinde'),(18,'Teokap SR','NOBEL',6,'1','Grip enfeksiyonuna bağlı tedavide kullanılan antibiyotik'),(19,'Aksef 500mg','NOBEL',10,'2','Gribe bağlı gelişen geniş spektrumlu antibiyotik'),(20,'Aferin Kapsül','Bilim İlac San.',15,'3','Girip Enfeksiyonlarında'),(21,'SİLVERDİN KREM %1','DEVA',14,'1','Yara ve Yanık Tedavisinde'),(22,'Advantan  M Losyon','BAYER',18,'2','Topikal Alerjik Tedavide'),(23,'Kenacort-A Orabase Pomad','DEVA',25,'5','Ağızda oluşan Aft tedavisinde'),(24,'Panalgine','ATABAY',7.5,'1','Ağrı Kesici ve Ateş Düşürücü'),(25,'Minoset','BAYER',5,'1','Ağrı Kesici ve Ateş Düşürücü'),(26,'KATARİN','Biofarma',6.7,'2','Gribamal Enfeksyonlarda'),(27,'Sinecod Depo','NOVART',4,'1','Öksürüğe bağlı tedavide'),(28,'Famodin 40 mg','SANDOZ',16,'2','Midede bulunan fazla asitin giderilmesinde'),(29,'ALEVE 220mg','BAYER',13,'4','Soğuk Algınlığı ve tedavisinde'),(30,'ColdaWAY','ABDIİBRAHİM',3.5,'1','Grip enfeksiyonlarında');
/*!40000 ALTER TABLE `ilac_bilgisi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musteri_bilgisi`
--

DROP TABLE IF EXISTS `musteri_bilgisi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `musteri_bilgisi` (
  `id_musteri` int(11) NOT NULL AUTO_INCREMENT,
  `tc_kimlik_no` varchar(45) NOT NULL,
  `adi_soyadi` varchar(45) NOT NULL,
  `guvence` varchar(20) NOT NULL,
  `telefon` varchar(50) NOT NULL,
  `adres` varchar(250) NOT NULL,
  PRIMARY KEY (`id_musteri`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musteri_bilgisi`
--

LOCK TABLES `musteri_bilgisi` WRITE;
/*!40000 ALTER TABLE `musteri_bilgisi` DISABLE KEYS */;
INSERT INTO `musteri_bilgisi` VALUES (1,'11696214055','Elvan Bayar','SSK','0532 620 1742','İ Caddesi. N Sokak. No/1 Kartal'),(2,'21474836471','Erhan Çıray','Bağkur','0534 450 1467','C Caddesi. O Sokak. No/20 Levent'),(3,'13111703271','Öznur Çulhaoğlu','Emekli','0535 750 2034','H Caddesi. Ş Sokak. No/10 Üsküdar'),(4,'12375630032','Zeynep Derdemez','Bağkur','0531 862 6032','S Caddesi. P Sokak. No/5 Sarıyer'),(5,'20672719611','Mehmet Çelikkol','Bağkur','0534 852 3120','Z Caddesi. A Sokak. No/7 Bayrampaşa'),(6,'31676517632','Mert Kırgız','SSK','0531 165 5552','K Caddesi. F Sokak. No/8 Beşiktaş'),(7,'36520012302','Mert Altın','Yok','0531 252 6032','SS Caddesi. P Sokak. No/11 Eminönü'),(8,'12032065232','Sanem Kılıç','SSK','0536 785 1980','KL Caddesi. D Sokak. No/21  Taksim'),(9,'32035400320','Adem Savunur','Bağkur','0520 450 3210','Ö Caddesi. H Sokak. No/6 Ümraniye'),(10,'43021368500','Yaren Çiçek','Yok','0510 700 6520','X Caddesi.  J Sokak. No/2 Beykoz'),(11,'12032056423','Ömer Çetin','SSK','0520 650 8542','AS Caddesi. Ş Sokak. No/4 İstinye'),(12,'52037895420','Aysun Öz','Emekli','0560 452 2011','İL Caddesi. F Sokak. No/63 Bağcılar'),(13,'00012035510','Dursun Özbek','Bağkur','0580 654 0011','PJ Caddesi. V Sokak. No/12 Avcılar'),(14,'20036875465','Sinan Diren','Yok','0521 320 4851','N Caddesi.  T Sokak. No/18 Yenibosna'),(15,'17452165212','Ezgi Şilek','Yok','0580 145 7559','I Caddesi.  MN Sokak. No/17 Beylikdüzü'),(16,'52165487650','Aynur Nerin','SSK','0540 965 4111','ZC Caddesi. OP Sokak. No/65 Bayrampaşa'),(17,'32069875424','İlhan Barsun','SSK','0511 723 1452','ÇÖ Caddesi. CX Sokak. No/2 Gaziosmanpaşa'),(18,'63201452575','Onur Ören','Yok','0573 965 2045','FG Caddesi. İÜ Sokak. No/32 Fatih'),(19,'20574125415','Gül Laleli','Emekli','0595 152 3020','BV Caddesi. Ç Sokak. No/60 Eyüp'),(20,'02541125844','İlke Ekşi','Bağkur','0573 852 4692','LY Caddesi. Y Sokak. No/3 Ataşehir'),(21,'14585742541','İlker Saman','Yok','0534 025 7600','OX Caddesi. HG Sokak. No/19 Şişli');
/*!40000 ALTER TABLE `musteri_bilgisi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uyelikler`
--

DROP TABLE IF EXISTS `uyelikler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uyelikler` (
  `uye_id` int(11) NOT NULL AUTO_INCREMENT,
  `kullanici_adi` varchar(45) NOT NULL,
  `password` varchar(50) NOT NULL,
  `uyelik_turu` varchar(15) NOT NULL,
  `Email` varchar(50) NOT NULL,
  PRIMARY KEY (`uye_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uyelikler`
--

LOCK TABLES `uyelikler` WRITE;
/*!40000 ALTER TABLE `uyelikler` DISABLE KEYS */;
INSERT INTO `uyelikler` VALUES (1,'aykut','123456','Yönetici','sahinaykut88@gmail.com'),(5,'ahmet','1234','Personel','ahmet@gmail.com'),(6,'ilknur','12345','Personel','ilknursahin449@gmail.com'),(7,'ayşe','ayşe123','Personel','ayse@gmail.com'),(8,'ayla','ayla33','Personel','ayla@mail.com');
/*!40000 ALTER TABLE `uyelikler` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-08 21:12:40
