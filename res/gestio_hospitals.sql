# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.25)
# Database: gestio_hospitals
# Generation Time: 2013-06-09 18:13:01 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table especialitat
# ------------------------------------------------------------

DROP TABLE IF EXISTS `especialitat`;

CREATE TABLE `especialitat` (
  `nom_especialitat` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`nom_especialitat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table habitacio
# ------------------------------------------------------------

DROP TABLE IF EXISTS `habitacio`;

CREATE TABLE `habitacio` (
  `numero` int(11) unsigned NOT NULL,
  `nom_hospital` varchar(255) NOT NULL DEFAULT '',
  `nom_especialitat` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`nom_hospital`,`numero`),
  KEY `habitacio_especialitat_nom_fk` (`nom_especialitat`),
  CONSTRAINT `habitacio_especialitat_nom_fk` FOREIGN KEY (`nom_especialitat`) REFERENCES `especialitat` (`nom_especialitat`),
  CONSTRAINT `habitacio_hospital_nom_fk` FOREIGN KEY (`nom_hospital`) REFERENCES `hospital` (`nom_hospital`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table hospital
# ------------------------------------------------------------

DROP TABLE IF EXISTS `hospital`;

CREATE TABLE `hospital` (
  `nom_hospital` varchar(255) NOT NULL DEFAULT '',
  `adreca` varchar(255) DEFAULT NULL,
  `descripcio` varchar(255) DEFAULT '',
  PRIMARY KEY (`nom_hospital`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table hospital_especialitat
# ------------------------------------------------------------

DROP TABLE IF EXISTS `hospital_especialitat`;

CREATE TABLE `hospital_especialitat` (
  `nom_hospital` varchar(255) NOT NULL DEFAULT '',
  `nom_especialitat` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`nom_hospital`,`nom_especialitat`),
  KEY `hospital_especialitat_especialitat_nom` (`nom_especialitat`),
  CONSTRAINT `hospital_especialitat_especialitat_nom` FOREIGN KEY (`nom_especialitat`) REFERENCES `especialitat` (`nom_especialitat`),
  CONSTRAINT `hospital_especialitat_hospital_nom` FOREIGN KEY (`nom_hospital`) REFERENCES `hospital` (`nom_hospital`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table infermera
# ------------------------------------------------------------

DROP TABLE IF EXISTS `infermera`;

CREATE TABLE `infermera` (
  `codi_empleat` char(9) NOT NULL,
  `torn` varchar(50) NOT NULL,
  PRIMARY KEY (`codi_empleat`),
  CONSTRAINT `infermera_sanitari_codi_empleat_fk` FOREIGN KEY (`codi_empleat`) REFERENCES `sanitari` (`codi_empleat`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table ingres
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ingres`;

CREATE TABLE `ingres` (
  `n_ts_pacient` varchar(14) NOT NULL DEFAULT '',
  `nom_hospital` varchar(255) NOT NULL,
  `numero_habitacio` int(11) unsigned NOT NULL,
  `codi_empleat_metge` char(9) DEFAULT NULL,
  `data_inici` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_alta` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`n_ts_pacient`,`data_inici`),
  KEY `ingres_pacient_n_ts_fk` (`n_ts_pacient`),
  KEY `ingres_habitacio_nom_numero_fk` (`nom_hospital`,`numero_habitacio`),
  KEY `ingres_metge_codi_empleat_fk` (`codi_empleat_metge`),
  CONSTRAINT `ingres_habitacio_nom_numero_fk` FOREIGN KEY (`nom_hospital`, `numero_habitacio`) REFERENCES `habitacio` (`nom_hospital`, `numero`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ingres_metge_codi_empleat_fk` FOREIGN KEY (`codi_empleat_metge`) REFERENCES `metge` (`codi_empleat`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ingres_paciend_n_ts_fk` FOREIGN KEY (`n_ts_pacient`) REFERENCES `pacient` (`n_ts`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table metge
# ------------------------------------------------------------

DROP TABLE IF EXISTS `metge`;

CREATE TABLE `metge` (
  `codi_empleat` char(9) NOT NULL,
  `categoria` varchar(255) NOT NULL,
  `nom_especialitat` varchar(255) NOT NULL,
  PRIMARY KEY (`codi_empleat`),
  KEY `metge_especialitat_nom_fk` (`nom_especialitat`),
  CONSTRAINT `metge_especialitat_nom_fk` FOREIGN KEY (`nom_especialitat`) REFERENCES `especialitat` (`nom_especialitat`),
  CONSTRAINT `metge_sanitari_codi_empleat_fk` FOREIGN KEY (`codi_empleat`) REFERENCES `sanitari` (`codi_empleat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table pacient
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pacient`;

CREATE TABLE `pacient` (
  `dni` char(9) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `n_ts` varchar(14) NOT NULL DEFAULT '',
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`n_ts`),
  UNIQUE KEY `pacient_dni_u` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table sanitari
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sanitari`;

CREATE TABLE `sanitari` (
  `dni` char(9) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `codi_empleat` char(9) NOT NULL,
  `nom_hospital` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`codi_empleat`),
  UNIQUE KEY `sanitari_dni_u` (`dni`),
  KEY `sanitari_hospital_nom_fk` (`nom_hospital`),
  CONSTRAINT `sanitari_hospital_nom_fk` FOREIGN KEY (`nom_hospital`) REFERENCES `hospital` (`nom_hospital`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
