CREATE DATABASE controlClientes;
use controlClientes;
CREATE TABLE usuario (
	id int auto_increment,
	primary key(id),
	nombre VARCHAR(255) NOT NULL,
	apellidos VARCHAR(255) NOT NULL,
	direccion VARCHAR(255) NOT NULL
);

INSERT INTO usuario (nombre, apellidos, direccion) VALUES ('Juan', 'Pérez', 'Calle Mayor, 123');