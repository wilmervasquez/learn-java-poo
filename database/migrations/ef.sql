-- Active: 1765562312409@@127.0.0.1@3306@poo
CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    telefono VARCHAR(20) UNIQUE NOT
);

CREATE TABLE peliculas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(50) UNIQUE NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    genero VARCHAR(50),
    duracion INT
);

CREATE TABLE alquileres (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cliente_id INT NOT NULL,
    pelicula_id INT NOT NULL,
    fecha_alquiler DATE NOT NULL,
    fecha_devolucion DATE,
    precio DOUBLE NOT NULL,
    estado VARCHAR(50),

    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    FOREIGN KEY (pelicula_id) REFERENCES peliculas(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
