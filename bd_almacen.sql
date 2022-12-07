-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-11-2022 a las 21:53:12
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_almacen`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caracteristicas`
--

CREATE TABLE `caracteristicas` (
  `id_caracteristica` int(11) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `caracteristicas`
--

INSERT INTO `caracteristicas` (`id_caracteristica`, `tipo`) VALUES
(1, 'Botella de gaseosa '),
(2, 'Bolsa 12 unidades'),
(3, 'Sachet '),
(4, 'solido de goma '),
(5, 'Barra'),
(7, 'botella de gaseosa '),
(8, 'bolsa 12 unidades'),
(9, 'sachet '),
(10, 'solido de goma '),
(11, 'barra '),
(12, 'lata en polvo'),
(13, 'bolsa en polvo'),
(14, 'frasco '),
(15, 'caja '),
(16, 'solido '),
(17, 'grema');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `id_compras` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `fecha` varchar(12) DEFAULT NULL,
  `cantidad` double DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `compras`
--

INSERT INTO `compras` (`id_compras`, `descripcion`, `fecha`, `cantidad`, `precio`, `total`, `id_usuario`) VALUES
(1, 'En perfecto estado', '2022-01-31', 25, 245, 21454, 1),
(2, 'Estan en un Buen estado', '2022-02-01', 24, 12, 484, 2),
(3, 'Son buena Calidad', '2022-02-22', 12, 5, 60, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id_empleados` int(11) NOT NULL,
  `ci` varchar(9) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `direccion` varchar(80) DEFAULT NULL,
  `numero` varchar(8) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id_empleados`, `ci`, `nombre`, `apellidos`, `direccion`, `numero`, `telefono`, `id_usuario`) VALUES
(1, '5987964', 'Marco Antonio', 'Gomez Gutierrez', 'Av. Illimani', '137', 76537648, 1),
(2, '123456789', 'Juan David', 'Ramos Cadena', 'Av. Barrientos', '45', 75315945, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE `marcas` (
  `id_marcas` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `marcas`
--

INSERT INTO `marcas` (`id_marcas`, `nombre`) VALUES
(1, 'Coca Cola'),
(2, 'Pan Casero'),
(3, 'Fridocita'),
(4, 'Pepsi');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `id_tipo` int(11) NOT NULL,
  `id_marcas` int(11) NOT NULL,
  `id_caracteristica` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `nombre`, `stock`, `id_tipo`, `id_marcas`, `id_caracteristica`) VALUES
(1, 'Manzana', 12, 1, 3, 5),
(2, 'Fanta', 15, 2, 1, 1),
(33, 'fanta', 100, 2, 1, 1),
(34, 'Coca-Cola', 15, 2, 1, 2),
(35, 'sprite', 15, 2, 4, 15),
(36, 'Pan dulce', 18, 5, 2, 8),
(37, 'cereal', 15, 5, 3, 2),
(38, 'Cafe', 25, 6, 1, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_tallas`
--

CREATE TABLE `producto_tallas` (
  `id_producto_talla` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `id_talla` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto_tallas`
--

INSERT INTO `producto_tallas` (`id_producto_talla`, `id_producto`, `id_talla`) VALUES
(1, 1, 3),
(2, 1, 2),
(4, 1, 1),
(5, 2, 1),
(6, 2, 1),
(7, 1, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id_proveedores` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `direccion` varchar(80) DEFAULT NULL,
  `ciudad` varchar(30) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `observaciones` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`id_proveedores`, `nombre`, `direccion`, `ciudad`, `telefono`, `correo`, `observaciones`) VALUES
(1, 'Impro VIP', 'Av. La Paz', 'La Paz', '75315465', 'impro@gmail.com', 'Las entregas son a tiempo'),
(2, 'Coca Cola', 'Av. Illimani', 'Oruro', '75147852', 'cocacola@gmail.com', 'Las bebidas son muy dulces'),
(3, 'Comercial Gomez Mayor', 'Av. Achacachi ', 'La Paz', '78954476', 'comercialmayorgomez@gamil.com', 'Distribución solo de productos gaseoso de la marca Coca Cola '),
(4, 'Panificadora San Gabriel', 'Z Charapaqui Av. Jaime Mendoza No. 1574', 'La paz', '78965425', 'panificadorasangabriel@gmail.com ', 'distribuidora de pan dulce etc.'),
(5, 'Tarifer', 'Av. Madrid No. 7548', 'Santa Cruz', '78954896', 'tarifermadrid@gmail.com', 'distribuye productos como ser cafe,   pastillas dulces y bebida azucarada'),
(6, 'colgate palmolive', 'Z. Obrajes C. anillos cero No.9885', 'Cochabamba', '78954685', 'palmilivecolgate@gmail.com', 'distribuidora de productos de cuidado oral '),
(7, 'Balquis France', 'Z. Franco Valle C. Cora Cora No. 5565', 'Santa Cruz', '78945632', 'balquis@gmail.com', 'distribuidora de productos de belleza'),
(8, 'Merkandi', 'Z. Bueno Aires C. Franco Balle', 'Potosi', '78955466', 'Mercandioreo@gmail.com', 'distribuidora de productos dulces '),
(9, 'Glassto', 'Z. Graft C. Cocas per No. 8854', 'Oruro', '78845569', 'pumaglassto@gmail.com', 'distribuidora de productos de prenda de muchos tipos'),
(10, 'KDbiznes', 'Av. franco santalleta No. 145', 'Potosi', '7845562', 'kdbizneskike@gmail.com', 'distribuidora de zapatos nike'),
(11, 'Aliexpres', 'Av. franx Goerge No. 254', 'Tarija', '78451291', 'aliexpresadid@gmail.com', 'proveedor de productos Adidas ropa deportiva, zapatillas de deporte, chándales, joggers, joyas, etc.'),
(12, 'paisanas', 'Z. Sandy Yack C. 2 de febrero No. 888', 'Cochabamba', '78466255', 'paismaccolumbia@gmail.com', 'proveedor de productos de prendas chamaras, yogers,etc.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tallas`
--

CREATE TABLE `tallas` (
  `id_talla` int(11) NOT NULL,
  `medida` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tallas`
--

INSERT INTO `tallas` (`id_talla`, `medida`) VALUES
(1, 'Grande'),
(2, 'Mediano'),
(3, 'Pequeño'),
(4, 'Inter-medio'),
(5, 'Yumbo '),
(6, '2L'),
(7, '200 gm'),
(8, '200 ml'),
(9, '4 gm'),
(10, '800 grm'),
(11, 'grande'),
(12, 'pequeño'),
(13, ' p(30)'),
(14, 'p(40)'),
(15, 'L'),
(16, 'XL'),
(17, 'S'),
(18, 'M');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos`
--

CREATE TABLE `tipos` (
  `id_tipo` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL COMMENT 'tipo de alimentos como frutas, viveres, etc',
  `detalle` varchar(100) DEFAULT NULL,
  `id_proveedores` int(11) NOT NULL,
  `id_compras` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipos`
--

INSERT INTO `tipos` (`id_tipo`, `nombre`, `detalle`, `id_proveedores`, `id_compras`) VALUES
(1, 'Frutas', 'Manter un lugar Fresco', 1, 1),
(2, 'Refresco', '3 litros', 2, 2),
(5, 'Bienes de Consumo', 'usabilidad limitada, se consumen de manera rapida y tienen vida corta como alimentos ', 1, 1),
(6, 'Bienes de Uso Comun ', 'productos que forman parte de una canasta habitual y se consumen rapido, para el higiene y textiles', 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `usuario`, `password`) VALUES
(1, 'Mario', '8cb2237d0679ca88db6464eac60da96345513964'),
(2, 'Pablo', '8cb2237d0679ca88db6464eac60da96345513964'),
(3, 'Esther', '8cb2237d0679ca88db6464eac60da96345513964'),
(5, 'Carmelo', '8cb2237d0679ca88db6464eac60da96345513964'),
(6, 'Paty', '8cb2237d0679ca88db6464eac60da96345513964'),
(7, 'Anthony', '8cb2237d0679ca88db6464eac60da96345513964');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_ventas` int(11) NOT NULL,
  `cliente` varchar(100) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  `fecha` varchar(12) DEFAULT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_ventas`, `cliente`, `descripcion`, `fecha`, `id_usuario`) VALUES
(1, 'Fernando', 'Compra de muchos articulos', '2022-02-15', 1),
(2, 'Camila', 'Tiene un defecto de fabrica', '2022-02-20', 6),
(5, 'perez', 'bebidas azucaradas para tienda coca cola ', '2022-11-10', 2),
(6, 'gonzales', 'venta para tienda  de 5 bolsas de pan dulce ', '2022-11-11', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta_productos`
--

CREATE TABLE `venta_productos` (
  `id_venta_producto` int(11) NOT NULL,
  `id_ventas` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `descuento` double DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `venta_productos`
--

INSERT INTO `venta_productos` (`id_venta_producto`, `id_ventas`, `id_producto`, `cantidad`, `descuento`, `precio`, `total`) VALUES
(1, 1, 1, 12, 0.3, 26.3, 201.6),
(2, 1, 2, 2, 0.1, 24.6, 125.3),
(5, 1, 1, 20, 0, 10, 200),
(6, 2, 2, 5, 0, 19.5, 97.5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `caracteristicas`
--
ALTER TABLE `caracteristicas`
  ADD PRIMARY KEY (`id_caracteristica`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`id_compras`,`id_usuario`),
  ADD KEY `fk_compras_Usuario1_idx` (`id_usuario`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id_empleados`,`id_usuario`),
  ADD KEY `fk_Empleados_usuario1_idx` (`id_usuario`);

--
-- Indices de la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`id_marcas`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`,`id_tipo`,`id_marcas`,`id_caracteristica`),
  ADD KEY `fk_productos_tipo1_idx` (`id_tipo`),
  ADD KEY `fk_productos_marcas1_idx` (`id_marcas`),
  ADD KEY `fk_productos_caracteristica1_idx` (`id_caracteristica`);

--
-- Indices de la tabla `producto_tallas`
--
ALTER TABLE `producto_tallas`
  ADD PRIMARY KEY (`id_producto_talla`,`id_producto`,`id_talla`),
  ADD KEY `fk_producto_talla_productos1_idx` (`id_producto`),
  ADD KEY `fk_producto_talla_talla1_idx` (`id_talla`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id_proveedores`);

--
-- Indices de la tabla `tallas`
--
ALTER TABLE `tallas`
  ADD PRIMARY KEY (`id_talla`);

--
-- Indices de la tabla `tipos`
--
ALTER TABLE `tipos`
  ADD PRIMARY KEY (`id_tipo`,`id_proveedores`,`id_compras`),
  ADD KEY `fk_tipo_proveedores1_idx` (`id_proveedores`),
  ADD KEY `fk_tipo_compras1_idx` (`id_compras`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_ventas`,`id_usuario`),
  ADD KEY `fk_ventas_Usuario1_idx` (`id_usuario`);

--
-- Indices de la tabla `venta_productos`
--
ALTER TABLE `venta_productos`
  ADD PRIMARY KEY (`id_venta_producto`,`id_ventas`,`id_producto`),
  ADD KEY `fk_venta_producto_ventas1_idx` (`id_ventas`),
  ADD KEY `fk_venta_producto_productos1_idx` (`id_producto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `caracteristicas`
--
ALTER TABLE `caracteristicas`
  MODIFY `id_caracteristica` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `id_compras` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id_empleados` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `marcas`
--
ALTER TABLE `marcas`
  MODIFY `id_marcas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de la tabla `producto_tallas`
--
ALTER TABLE `producto_tallas`
  MODIFY `id_producto_talla` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id_proveedores` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `tallas`
--
ALTER TABLE `tallas`
  MODIFY `id_talla` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `tipos`
--
ALTER TABLE `tipos`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_ventas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `venta_productos`
--
ALTER TABLE `venta_productos`
  MODIFY `id_venta_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `fk_compras_Usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `fk_Empleados_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `FK_producto_tipo` FOREIGN KEY (`id_tipo`) REFERENCES `tipos` (`id_tipo`),
  ADD CONSTRAINT `fk_productos_caracteristica1` FOREIGN KEY (`id_caracteristica`) REFERENCES `caracteristicas` (`id_caracteristica`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_productos_marcas1` FOREIGN KEY (`id_marcas`) REFERENCES `marcas` (`id_marcas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_productos_tipo1` FOREIGN KEY (`id_tipo`) REFERENCES `tipos` (`id_tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto_tallas`
--
ALTER TABLE `producto_tallas`
  ADD CONSTRAINT `fk_producto_talla_productos1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_producto_talla_talla1` FOREIGN KEY (`id_talla`) REFERENCES `tallas` (`id_talla`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tipos`
--
ALTER TABLE `tipos`
  ADD CONSTRAINT `fk_tipo_compras1` FOREIGN KEY (`id_compras`) REFERENCES `compras` (`id_compras`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tipo_proveedores1` FOREIGN KEY (`id_proveedores`) REFERENCES `proveedores` (`id_proveedores`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `fk_ventas_Usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `venta_productos`
--
ALTER TABLE `venta_productos`
  ADD CONSTRAINT `fk_venta_producto_productos1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_venta_producto_ventas1` FOREIGN KEY (`id_ventas`) REFERENCES `ventas` (`id_ventas`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
