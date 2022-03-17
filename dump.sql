-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl70asp4l4w0jmbm1tqyofho4o` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (74,2),(85,NULL),(89,NULL),(93,NULL),(97,NULL),(98,NULL),(99,NULL),(100,NULL),(101,NULL),(111,NULL),(104,NULL),(105,NULL),(106,NULL),(107,NULL),(108,NULL),(109,NULL),(110,NULL),(114,NULL),(117,NULL),(122,NULL),(130,NULL),(133,NULL),(138,NULL),(144,NULL),(148,NULL),(158,1),(154,NULL),(157,NULL);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (160);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `discount` int DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` varchar(4096) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Giocattolo',10,'https://images-na.ssl-images-amazon.com/images/I/61nAYaBibvL._AC_SY355_.jpg','Pistola ad Acqua',25,'1. Set di Pistole ad Acqua: il set di pistole ad acqua contiene 2 pistole a spruzzo (viola + blu). Ciascuno misura 18 (cm) x 13 (cm) x 4 (cm). Divertimento senza fine per i bambini a una festa in piscina per bambini o una festa estiva all\'aperto.<br>2. Materiale Durevole Sicuro: Privo di BPA e realizzato in plastica ABS resistente di alta qualità, semplice impugnatura liscia e senza bordi taglienti. È sicuro per adulti e bambini.<br>3. Adatto a Bambini e Adulti: Adatto a bambini e adulti. Goditi la tua pistola ad acqua a lungo raggio nel tuo giardino di azione a casa, in piscina, nella lotta spiaggia-sabbia-acqua o nella festa in acqua. Perfetto giocattolo da piscina per le calde giornate estive che mantengono i bambini freschi e intrattenuti per ore. Portalo in spiaggia, in piscina, all\'ora del bagno, nelle in giardino e altro ancora.<br>4. Funzionamento Semplice: Aprire il coperchio e riempire il serbatoio, spingere in avanti e indietro la maniglia della pompa inferiore e premere il grilletto. Maggiore è la pressione della pompa, puoi avere più colpi.<br>5. Cool Regali Estivi: Come regalo estivo, ideale per bambini e adulti che amano giocare a giochi d\'acqua in estate. Anche sotto il sole cocente, tu, i tuoi amici e la famiglia non solo potete provare l\'eccitazione dei giochi con le pistole ad acqua, ma anche godervi la gioia dell\'acqua ghiacciata, rendere questa calda estate fresca e creare ricordi preziosi.'),(8,'Cibo',0,'https://media.istockphoto.com/photos/jar-of-italian-nutella-hazelnuts-cream-picture-id537609774?k=6&m=537609774&s=612x612&w=0&h=96jZNdX8znqolQZyoMT1QWFe-wh99JbqR5ESVmCK2-I=','Nutella 500g',21,'Faremo il possibile per consegnarti questo prodotto ad almeno 60 giorni dalla scadenza<br>Crema da spalmare alle nocciole e al cacao<br>Nutella ha un gusto unico, dato da una combinazione straordinaria di ingredienti di alta qualità, come le nocciole e il cacao<br>Nutella è perfetta spalmata sul pane a colazione, per cominciare bene la giornata<br>Kosher, idoneo per ovo-latto-vegetariani, senza glutine'),(79,'Elettronica',0,'https://m.media-amazon.com/images/I/81KoSSAwH2L._AC_SY450_.jpg','Laptop',1200,'Sottile e leggero, Surface Laptop 3 è facile da trasportare<br>Livelli superiori di velocità e prestazioni, per fare tutto quello che vuoi tu, con i processori di ultima generazione<br>Porte USB-C(tm) e USB-A per connettersi a schermi, Docking Station e molto altro ancora, e persino per ricaricare gli accessori<br>Gli altoparlanti Omnisonic ancora più avanzati, nascosti sotto la tastiera, offrono un incredibile suono omnidirezionale<br>Tastiera layout QWERTY Italiano'),(2,'Salute',15,'https://images-na.ssl-images-amazon.com/images/I/71NIdcW1dZL._AC_SL1500_.jpg','Integratori',25,'Sustenium plus è un integratore energizzante, con vero succo di arancia, che fornisce una carica di energia quando stanchezza e affaticamento si fanno sentire.<br>Sustenium plus è perfetto durante i cambi di stagione, in periodi stressanti o giornate intense; ma anche per gli sportivi durante la preparazione atletica o dopo l\'allenamento.<br>Sustenium plus contiene una formulazione esclusiva con 5g di aminoacidi, vitamine e minerali per assicurarti un plus quando serve.<br>Non contiene sostanze dopanti ed è senza coloranti artificiali; confezione da 12 bustine da 8gr.<br>Conservare il prodotto in luogo fresco, asciutto e al riparo dalla luce; la data di scadenza si riferisce al prodotto correttamente conservato, in confezione integra.');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_quantity`
--

DROP TABLE IF EXISTS `product_quantity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_quantity` (
  `id` bigint NOT NULL,
  `quantity` int NOT NULL,
  `cart_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8x1b1xg21d6sd2m8mh00asxsd` (`cart_id`),
  KEY `FKi5bxaxet5yf16aj98dt7s064p` (`product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_quantity`
--

LOCK TABLES `product_quantity` WRITE;
/*!40000 ALTER TABLE `product_quantity` DISABLE KEYS */;
INSERT INTO `product_quantity` VALUES (76,10,74,8),(77,5,58,1),(83,15,80,79),(87,9,86,1),(88,2,86,79),(91,4,90,8),(92,12,90,79),(95,1,94,79),(96,5,94,8),(103,1,102,79),(113,1,112,79),(116,1,115,1),(119,4,118,1),(120,7,118,8),(121,1,118,79),(124,1,123,79),(127,1,123,8),(128,8,123,1),(129,4,123,2),(132,1,131,79),(135,1,134,79),(136,1,134,8),(137,1,134,2),(140,1,139,79),(141,1,139,1),(142,1,139,2),(143,1,139,8),(146,1,145,2),(147,4,145,79),(150,2,149,8),(151,48,149,1),(152,1,149,79),(153,1,149,2),(156,1,155,8),(159,1,158,8);
/*!40000 ALTER TABLE `product_quantity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` tinyblob,
  `surname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Davide',_binary 'adminadmin','ciao','admin2','admin@admin.com'),(2,'Antonio',_binary 'antonio','Pizzi','antonio','antonio.pizzi@gmail.com');
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

-- Dump completed on 2022-03-17 12:47:54
