-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-05-2016 a las 18:53:11
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `cibercafe`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conexion`
--

CREATE TABLE IF NOT EXISTS `conexion` (
  `Numero_Conexion` int(11) NOT NULL,
  `Codigo_Ordenador` varchar(32) NOT NULL,
  `Hora_Inicio` time NOT NULL,
  `Hora_Final` time NOT NULL,
  `DNI` varchar(9) NOT NULL,
  PRIMARY KEY (`Numero_Conexion`),
  KEY `Codigo_Socio` (`Codigo_Ordenador`),
  KEY `Codigo_Ordenador` (`Codigo_Ordenador`),
  KEY `DNI` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `conexion`
--

INSERT INTO `conexion` (`Numero_Conexion`, `Codigo_Ordenador`, `Hora_Inicio`, `Hora_Final`, `DNI`) VALUES
(1, 'AAA123', '00:00:00', '00:00:00', '99999999J'),
(2, 'BBB123', '00:00:00', '00:00:00', '99999999K');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE IF NOT EXISTS `empleados` (
  `Codigo_Empleado` varchar(32) NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `Nombre` varchar(32) NOT NULL,
  `Apellidos` varchar(32) NOT NULL,
  `Direccion` varchar(32) NOT NULL,
  `Telefono` int(11) NOT NULL,
  `Tipo_de_Contrato` varchar(32) NOT NULL,
  `Antigüedad` int(11) NOT NULL,
  `Sueldo` decimal(10,0) NOT NULL,
  `Cargo` varchar(32) NOT NULL,
  `Numero_SS` varchar(32) NOT NULL,
  PRIMARY KEY (`Codigo_Empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`Codigo_Empleado`, `DNI`, `Nombre`, `Apellidos`, `Direccion`, `Telefono`, `Tipo_de_Contrato`, `Antigüedad`, `Sueldo`, `Cargo`, `Numero_SS`) VALUES
('1ABC', '99999999P', 'PEPE', 'PEREZ', 'CALLE NOSEQUE', 666666666, 'TEMPORAL', 1, '1233', 'ENCARGADO', 'ASDFG1'),
('2ABC', '12345678A', 'PACO', 'LOPEZ', 'CALLE BONIATO', 644338789, 'FIJO', 2, '2345', 'CAFETERIA', 'ASDFG2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE IF NOT EXISTS `factura` (
  `Numero_Factura` int(11) NOT NULL,
  `Codigo_Empleado` varchar(32) NOT NULL,
  `Numero_Conexion` int(11) NOT NULL,
  `Importe` decimal(10,0) NOT NULL,
  `Fecha` date NOT NULL,
  `Descuento` int(11) NOT NULL,
  PRIMARY KEY (`Numero_Factura`),
  KEY `Codigo_Empleado` (`Codigo_Empleado`,`Numero_Conexion`),
  KEY `Numero_Conexion` (`Numero_Conexion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`Numero_Factura`, `Codigo_Empleado`, `Numero_Conexion`, `Importe`, `Fecha`, `Descuento`) VALUES
(1, '1ABC', 1, '15', '2016-05-01', 15),
(2, '2ABC', 2, '12', '2016-05-02', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_productos`
--

CREATE TABLE IF NOT EXISTS `factura_productos` (
  `Numero_Factura` int(11) NOT NULL,
  `Codigo_Producto` varchar(32) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Precio` decimal(10,2) NOT NULL,
  PRIMARY KEY (`Numero_Factura`,`Codigo_Producto`),
  KEY `Numero_Factura` (`Numero_Factura`,`Codigo_Producto`),
  KEY `Codigo_Producto` (`Codigo_Producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `factura_productos`
--

INSERT INTO `factura_productos` (`Numero_Factura`, `Codigo_Producto`, `Cantidad`, `Precio`) VALUES
(1, 'A1', 1, '0.50'),
(1, 'C1', 1, '1.00'),
(2, 'C1', 2, '2.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenadores`
--

CREATE TABLE IF NOT EXISTS `ordenadores` (
  `Codigo_Ordenador` varchar(9) NOT NULL,
  `Contador` int(11) NOT NULL,
  PRIMARY KEY (`Codigo_Ordenador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ordenadores`
--

INSERT INTO `ordenadores` (`Codigo_Ordenador`, `Contador`) VALUES
('AAA123', 10),
('BBB123', 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `Codigo_Producto` varchar(32) NOT NULL,
  `Nombre_Proveedor` varchar(32) NOT NULL,
  `Tipo_de_Productos` varchar(32) NOT NULL,
  `Precio` decimal(11,2) NOT NULL,
  `Nombre` varchar(32) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  PRIMARY KEY (`Codigo_Producto`),
  KEY `Nombre_Proveedor` (`Nombre_Proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`Codigo_Producto`, `Nombre_Proveedor`, `Tipo_de_Productos`, `Precio`, `Nombre`, `Cantidad`) VALUES
('A1', 'FONTBELLA', 'AGUA', '0.50', 'AGUA', 0),
('C1', 'COCACOLA', 'REFRESCO', '1.00', 'COCACOLA', 0),
('C2', 'CRUZCAMPO', 'ALCOHOL', '1.00', 'CERVEZA', 0),
('C3', 'NETSLE', 'CAFETERIA', '1.00', 'CAFE SOLO', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE IF NOT EXISTS `proveedores` (
  `Nombre_Proveedor` varchar(32) NOT NULL,
  `Direccion` varchar(32) NOT NULL,
  `Telefono` int(9) NOT NULL,
  PRIMARY KEY (`Nombre_Proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`Nombre_Proveedor`, `Direccion`, `Telefono`) VALUES
('COCACOLA', 'CALLE TRAMONTA', 914537686),
('CRUZCAMPO', 'CALLE MONTAÑA', 912864906),
('FONTBELLA', 'CALLE GELIDA', 91678935),
('NETSLE', 'CALLE BONIATO', 97234674);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `Nombre` varchar(32) NOT NULL,
  `Contraseña` varchar(32) NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `Codigo_Socio` varchar(32) NOT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Nombre`, `Contraseña`, `DNI`, `Codigo_Socio`) VALUES
('VICTOR', 'ROTCIV', '99999999J', 'AAA1'),
('CESAR', 'RASEC', '99999999K', 'AAA2'),
('MIGUEL', 'LEUGIM', '99999999L', 'AAA3'),
('JAIME', 'EMIAJ', '99999999P', 'AAA4');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `conexion`
--
ALTER TABLE `conexion`
  ADD CONSTRAINT `conexion_ibfk_2` FOREIGN KEY (`DNI`) REFERENCES `usuarios` (`DNI`),
  ADD CONSTRAINT `conexion_ibfk_1` FOREIGN KEY (`Codigo_Ordenador`) REFERENCES `ordenadores` (`Codigo_Ordenador`);

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`Codigo_Empleado`) REFERENCES `empleados` (`Codigo_Empleado`),
  ADD CONSTRAINT `factura_ibfk_2` FOREIGN KEY (`Numero_Conexion`) REFERENCES `conexion` (`Numero_Conexion`);

--
-- Filtros para la tabla `factura_productos`
--
ALTER TABLE `factura_productos`
  ADD CONSTRAINT `factura_productos_ibfk_1` FOREIGN KEY (`Numero_Factura`) REFERENCES `factura` (`Numero_Factura`),
  ADD CONSTRAINT `factura_productos_ibfk_2` FOREIGN KEY (`Codigo_Producto`) REFERENCES `productos` (`Codigo_Producto`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`Nombre_Proveedor`) REFERENCES `proveedores` (`Nombre_Proveedor`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
