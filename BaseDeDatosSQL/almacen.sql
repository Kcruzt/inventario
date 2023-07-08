/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `mariadb`;
USE `mariadb`;

CREATE TABLE IF NOT EXISTS `administrador` (
  `id_administrador` int NOT NULL AUTO_INCREMENT,
  `id_user` int DEFAULT NULL,
  `nombres` varchar(250) DEFAULT NULL,
  `apellidos` varchar(250) DEFAULT NULL,
  `dni` varchar(250) DEFAULT NULL,
  `telefono` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_administrador`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `usuario_ad` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=5;

/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` (`id_administrador`, `id_user`, `nombres`, `apellidos`, `dni`, `telefono`) VALUES
	(1, 1, 'Jenzy', 'Merino Borja', '74125896', '98743216'),
	(3, 3, 'Juan miguel', 'Prada cobos', '4564565', '949684554'),
	(4, 4, 'Maria Rosa', 'rios vega', '324234', '234234');;
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;

DELIMITER //
CREATE PROCEDURE `Buscar`(
in texto varchar(45)
)
BEGIN
SELECT recepcion.id_recepcion ,
     
	   CONCAT(cliente.nombres,"",cliente.apellidos) as datosC,
         CONCAT(administrador.nombres,"",administrador.apellidos) as datosA,
          carga.id_carga,
          detalle_recepcion.id_detalle_re,
          detalle_recepcion.id_servicio,
          recepcion.total as total
       FROM cliente inner join recepcion ON cliente.id_cliente =recepcion.id_cliente
       INNER JOIN detalle_recepcion ON recepcion.id_recepcion=detalle_recepcion.id_recepcion	
       INNER JOIN servicio ON detalle_recepcion.id_servicio=servicio.id_servicio
       INNER JOIN carga ON detalle_recepcion.id_carga=carga.id_carga
       inner JOIN administrador ON recepcion.id_administrador=administrador.id_administrador
       INNER JOIN categoria ON carga.id_categoria=categoria.id_categoria
where recepcion.id_recepcion like CONCAT('%',texto,'%') or CONCAT(cliente.nombres,"",cliente.apellidos) like CONCAT('%',texto,'%')
 or CONCAT(administrador.nombres,"",administrador.apellidos)  like CONCAT('%',texto,'%')or  recepcion.tipo_comprobante like CONCAT('%',texto,'%')
 or  recepcion.fecha like CONCAT('%',texto,'%')or recepcion.estado like CONCAT('%',texto,'%')or servicio.descripcion like CONCAT('%',texto,'%')
 or  categoria.descripcion like CONCAT('%',texto,'%')or  carga.estado like CONCAT('%',texto,'%')or recepcion.total like CONCAT('%',texto,'%')
 or carga.descripcion like CONCAT('%',texto,'%') order by id_detalle_re desc;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE `BuscarCaja`(
in texto Varchar(250))
BEGIN
SELECT 
carga.id_carga,
categoria.descripcion,
carga.descripcion,
carga.estado
FROM carga INNER JOIN categoria ON carga.id_categoria=categoria.id_categoria
WHERE carga.id_carga like CONCAT('%',texto,'%') or categoria.descripcion like CONCAT('%',texto,'%')or 
carga.descripcion like CONCAT('%',texto,'%')or carga.estado like CONCAT('%',texto,'%');
END//
DELIMITER ;usuario_ad

CREATE TABLE IF NOT EXISTS `carga` (
  `id_carga` int NOT NULL AUTO_INCREMENT,
  `id_categoria` int DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `estado` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_carga`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `carga_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=28;

/*!40000 ALTER TABLE `carga` DISABLE KEYS */;
INSERT INTO `carga` (`id_carga`, `id_categoria`, `descripcion`, `estado`) VALUES
	(1, 1, 'CONTIENE PRODUCTOS INFLAMABLES', 'BUENO'),
	(2, 1, 'DELICADOS', 'CONTIENE-RANURAS'),
	(3, 4, 'CONTIENE FRUTAS', 'CONTIENE RAJADURAS'),
	(4, 4, 'DELICADOS', 'BUENO'),
	(5, 4, 'CONTIENE PRODUCTOS INFLAMABLES', 'BUENO'),
	(6, 3, 'CONTIENE PRODUCTOS INFLAMABLES', 'BUENO'),
	(7, 1, 'INFLAMABLE', 'BUENO'),
	(8, 3, 'INFLAMABLE', 'BUENO'),
	(9, 3, '234234234', '324'),
	(10, 4, 'bla-blabla', '324'),
	(11, 1, '23324', '23423432'),
	(27, 3, 'test', 'bueno');;
/*!40000 ALTER TABLE `carga` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `categoria` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=9;

/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`id_categoria`, `descripcion`) VALUES
	(1, 'fragil'),
	(2, 'Semi fragil'),
	(3, 'Pequeño'),
	(4, 'mediano'),
	(5, 'container'),
	(6, 'pesado'),
	(7, 'pesado plus');;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(250) DEFAULT NULL,
  `apellidos` varchar(250) DEFAULT NULL,
  `dni` varchar(250) DEFAULT NULL,
  `telefono` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=37;

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`id_cliente`, `nombres`, `apellidos`, `dni`, `telefono`) VALUES
	(1, 'Maria antonieta', 'galvez cruz', '3654848', '997465613'),
	(3, 'Victor Maria', 'porras cruz', '345345', '3454354'),
	(4, 'luis martin', 'villanueva hook', '24324', '3423432423'),
	(5, 'victor gabrielEd', 'santos huerta', '23432', '23423443'),
	(7, 'Julio andres', 'merino cardenaz', '234234', '2423423'),
	(17, 'Kiara maria', 'suarez burgas', '7536545', '968574123'),
	(19, 'paula maria', 'ramoz guevaras', '7896541', '963852741'),
	(21, 'FULANO', 'DE TALES', '9757451', '69481888'),
	(26, 'CLIENTE NUEVO', 'APELLIDOS NEUVOS', '23432777', '32432432'),
	(28, 'CLIENTE 1', 'APELILIDOSD', '324324adsd', '234234'),
	(29, 'dsd', 'asdas', 'asda', 'asdas'),
	(30, 'julio', 'lopez', '975454', '9845454454'),
	(31, 'julio', 'lopez puma', '975454', '9845454454'),
	(32, 'juan', 'damian gomez', '75241', '9875453'),
	(33, 'julio', 'damian gomez 2', '975454', '9845454454'),
	(34, 'usuario prueba', 'ramos', '785412', '965531'),
	(35, 'usuario prueba', 'ramos', 'asda', '965531'),
	(36, 'usuario prueba', 'ramos', '785412', '965531');;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `detalle_recepcion` (
  `id_detalle_re` int NOT NULL AUTO_INCREMENT,
  `id_recepcion` int DEFAULT NULL,
  `id_servicio` int DEFAULT NULL,
  `id_carga` int DEFAULT NULL,
  PRIMARY KEY (`id_detalle_re`),
  KEY `id_recepcion` (`id_recepcion`),
  KEY `id_servicio` (`id_servicio`),
  KEY `id_carga` (`id_carga`),
  CONSTRAINT `detalle_recepcion_ibfk_1` FOREIGN KEY (`id_recepcion`) REFERENCES `recepcion` (`id_recepcion`),
  CONSTRAINT `detalle_recepcion_ibfk_2` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id_servicio`),
  CONSTRAINT `detalle_recepcion_ibfk_3` FOREIGN KEY (`id_carga`) REFERENCES `carga` (`id_carga`)
) ENGINE=InnoDB AUTO_INCREMENT=28;

/*!40000 ALTER TABLE `detalle_recepcion` DISABLE KEYS */;
INSERT INTO `detalle_recepcion` (`id_detalle_re`, `id_recepcion`, `id_servicio`, `id_carga`) VALUES
	(1, 1, 1, 1),
	(2, 2, 1, 2),
	(3, 3, 4, 3),
	(4, 4, 5, 4),
	(5, 5, 9, 5),
	(6, 6, 4, 6),
	(7, 7, 1, 7),
	(8, 8, 3, 8),
	(9, 9, 3, 9),
	(10, 10, 4, 10),
	(11, 11, 1, 11),
	(27, 27, 7, 27);;
/*!40000 ALTER TABLE `detalle_recepcion` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `expenses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_gasto` varchar(255) NOT NULL,
  `cantidad` int DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40000 ALTER TABLE `expenses` DISABLE KEYS */;
/*!40000 ALTER TABLE `expenses` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `recepcion` (
  `id_recepcion` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int DEFAULT NULL,
  `id_administrador` int DEFAULT NULL,
  `tipo_comprobante` varchar(250) DEFAULT NULL,
  `fecha` varchar(250) DEFAULT NULL,
  `estado` varchar(250) DEFAULT NULL,
  `total` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_recepcion`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_administrador` (`id_administrador`),
  CONSTRAINT `recepcion_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `recepcion_ibfk_2` FOREIGN KEY (`id_administrador`) REFERENCES `administrador` (`id_administrador`)
) ENGINE=InnoDB AUTO_INCREMENT=28;

/*!40000 ALTER TABLE `recepcion` DISABLE KEYS */;
INSERT INTO `recepcion` (`id_recepcion`, `id_cliente`, `id_administrador`, `tipo_comprobante`, `fecha`, `estado`, `total`) VALUES
	(1, 5, 1, 'GUIA', '2020-12-15 16:41:53', 'ATENTIDO', '225'),
	(2, 21, 1, 'GUIA', '2020-12-15 16:42:25', 'ATENTIDO', '225'),
	(3, 1, 1, 'GUIA', '2020-12-15 16:43:36', 'ATENTIDO', '2025'),
	(4, 21, 1, 'GUIA', '2020-12-15 20:13:26', 'ATENTIDO', '2475'),
	(5, 21, 1, 'GUIA', '2020-12-15 23:37:25', 'RECIBIDO', '4275'),
	(6, 26, 1, 'GUIA', '2020-12-16 00:01:11', 'RECIBIDO', '1575'),
	(7, 26, 1, 'GUIA', '2020-12-17 08:49:59', 'ATENTIDO', '225'),
	(8, 28, 1, 'GUIA', '2020-12-17 09:19:44', 'ATENTIDO', '1225'),
	(9, 26, 1, 'GUIA', '2021-10-14 20:52:00', 'ATENTIDO', '1225'),
	(10, 17, 4, 'GUIA', '2021-10-20 22:42:05', 'ATENTIDO', '2025'),
	(11, 29, 4, 'GUIA', '2021-10-21 11:32:11', 'ATENTIDO', '225'),
	(27, 28, 4, '2022-09-06', '2022-09-25 21:55:36', 'ATENTIDO', '34');;
/*!40000 ALTER TABLE `recepcion` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `servicio` (
  `id_servicio` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_servicio`)
) ENGINE=InnoDB AUTO_INCREMENT=12;

/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` (`id_servicio`, `descripcion`) VALUES
	(1, 'pequeño'),
	(2, 'minimo'),
	(3, 'basico minimo'),
	(4, 'basico medio'),
	(5, 'basico completo'),
	(6, 'intermedio-minimo'),
	(7, 'intermedio mediano'),
	(8, 'completo'),
	(9, 'temporal'),
	(10, 'plus');;

CREATE TABLE IF NOT EXISTS `usuario_ad` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(250) DEFAULT NULL,
  `contrasenia` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=5;

/*!40000 ALTER TABLE `usuario_ad` DISABLE KEYS */;
INSERT INTO `usuario_ad` (`id_user`, `user_name`, `contrasenia`) VALUES
	(1, 'luis123', '827ccb0eea8a706c4c34a16891f84e7b'),
	(3, 'juan123', 'f5737d25829e95b9c234b7fa06af8736'),
	(4, 'maria123', 'f8461b554d59b3014e8ff5165dc62fac');
;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
usuario_ad