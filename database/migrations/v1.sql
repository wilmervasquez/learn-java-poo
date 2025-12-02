CREATE TABLE categorias (
    id INT AUTO_INCREMENT primary key,
    name VARCHAR(100) NOT NULL
);

DROP TABLE productos;
CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sku VARCHAR(255) UNIQUE,
    nombre VARCHAR(255),
    marca VARCHAR(255),
    precio DOUBLE PRECISION,
    categoria_id INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);

INSERT INTO categorias (name) VALUES ('Laptops')