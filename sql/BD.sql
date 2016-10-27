CREATE TABLErestaurantes `restaurantes` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `direccion` text,
  `descripcion` text,
  `imagen` varchar(255) DEFAULT NULL,
  `precio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO `restaurantes` (`id`, `nombre`, `direccion`, `descripcion`, `imagen`, `precio`) VALUES
	(1, 'Macdonals', 'Calle de la piruleta nº 2', 'Este es un restaurante que hacen hamburguesas', 'macdonals.jpg', '20000'),
	(3, 'Bar manolo', 'Avenida de los naranjos', 'Bar familiar donde cenar con los niños', 'barmanolo.jpg', '50.000');


