/*
SQLyog Community Edition- MySQL GUI v6.05
Host - 5.6.17 : Database - passagens_aereas
*********************************************************************
Server version : 5.6.17
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `passagens_aereas`;

USE `passagens_aereas`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `aeronave` */

DROP TABLE IF EXISTS `aeronave`;

CREATE TABLE `aeronave` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(50) CHARACTER SET utf8 NOT NULL,
  `nome` varchar(100) CHARACTER SET utf8 NOT NULL,
  `qtdAssentosA` int(11) NOT NULL,
  `qtdAssentosB` int(11) NOT NULL,
  `qtdAssentosC` int(11) NOT NULL,
  `qtdAssentosHorizontais` int(11) NOT NULL,
  `qtdAssentosVerticais` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;

/*Data for the table `aeronave` */

insert  into `aeronave`(`id`,`codigo`,`nome`,`qtdAssentosA`,`qtdAssentosB`,`qtdAssentosC`,`qtdAssentosHorizontais`,`qtdAssentosVerticais`) values (53,'012RE','Ainplane F18e',15,30,80,0,15),(54,'013RE','Ainplane F18a',30,46,87,0,0),(55,'014RE','Ainplane F19b',30,75,98,0,0),(56,'015RA','Airplane 457',60,70,80,15,15),(57,'027','Frankin 157',80,120,121,0,0),(58,'057','Usjt 1000',40,40,65,43,20);

/*Table structure for table `aeroporto` */

DROP TABLE IF EXISTS `aeroporto`;

CREATE TABLE `aeroporto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) CHARACTER SET utf8 NOT NULL,
  `estado` varchar(100) CHARACTER SET utf8 NOT NULL,
  `pais` varchar(100) CHARACTER SET utf8 NOT NULL,
  `codigo` varchar(100) CHARACTER SET utf8 NOT NULL,
  `nomeCompleto` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `aeroporto` */

insert  into `aeroporto`(`id`,`nome`,`estado`,`pais`,`codigo`,`nomeCompleto`) values (3,'Guarulhos','SP','Brasil','GRU/SBGR','Aeroporto Internacional de São Paulo-Guarulhos'),(4,'Congonhas','SP','Brasil','CGH/SBSP','Aeroporto de Congonhas'),(5,'Campinas','SP','Brasil','CPQ/SDAM','Aeroporto Campo dos Amarais'),(6,'Porto Alegre','RS','Brasil','POA/SBPA','Aeroporto Internacional Salgado Filho');

/*Table structure for table `assento` */

DROP TABLE IF EXISTS `assento`;

CREATE TABLE `assento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classe` char(1) NOT NULL,
  `aeronaveId` int(11) NOT NULL,
  `localizacao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_assento` (`aeronaveId`),
  CONSTRAINT `FK_assento` FOREIGN KEY (`aeronaveId`) REFERENCES `aeronave` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `assento` */

/*Table structure for table `bilhete` */

DROP TABLE IF EXISTS `bilhete`;

CREATE TABLE `bilhete` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(100) NOT NULL,
  `passageiroId` int(11) NOT NULL,
  `pagamentoId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bilhete` */

/*Table structure for table `cartao` */

DROP TABLE IF EXISTS `cartao`;

CREATE TABLE `cartao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `codigoSeguranca` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cartao` */

/*Table structure for table `pagamento` */

DROP TABLE IF EXISTS `pagamento`;

CREATE TABLE `pagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(100) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `cartaoId` int(11) NOT NULL,
  `codigoTransacao` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pagamento` */

/*Table structure for table `passageiro` */

DROP TABLE IF EXISTS `passageiro`;

CREATE TABLE `passageiro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(21) NOT NULL,
  `bilheteId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `passageiro` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID do Usuario',
  `usuario` varchar(45) CHARACTER SET utf8 NOT NULL,
  `senha` varchar(100) CHARACTER SET utf8 NOT NULL,
  `perfil` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`id`,`usuario`,`senha`,`perfil`) values (1,'atendente','123',1),(2,'administrador','123',2);

/*Table structure for table `voo` */

DROP TABLE IF EXISTS `voo`;

CREATE TABLE `voo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) CHARACTER SET utf8 NOT NULL,
  `codigo` varchar(50) CHARACTER SET utf8 NOT NULL,
  `aeroportoOrigemId` int(11) NOT NULL,
  `aeroportoDestinoId` int(11) NOT NULL,
  `aeronaveId` int(11) NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_voo_aeroporto_origem` (`codigo`),
  KEY `FK_voo_aeroporto_destino` (`aeroportoOrigemId`),
  KEY `FK_voo_aeronave` (`aeronaveId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `voo` */

insert  into `voo`(`id`,`nome`,`codigo`,`aeroportoOrigemId`,`aeroportoDestinoId`,`aeronaveId`,`preco`,`data`) values (1,'Voo para Guarulhos','012RE',4,3,58,'1003.67','2015-10-13 00:00:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
