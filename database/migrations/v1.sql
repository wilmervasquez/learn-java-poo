DROP TABLE categorias;

CREATE TABLE categorias (
    id INT AUTO_INCREMENT primary key,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sku VARCHAR(255) UNIQUE,
    nombre VARCHAR(255),
    marca VARCHAR(255),
    precio DOUBLE PRECISION,
    cantidad INT NOT NULL,
    categoria_id INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);

CREATE TABLE empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255),
    dni VARCHAR(50) UNIQUE,
    telefono VARCHAR(50),
    cargo VARCHAR(100),
    fecha_contratacion DATE
);

CREATE TABLE ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    producto_id INT NOT NULL,
    empleado_id INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DOUBLE PRECISION NOT NULL,
    fecha_venta DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (producto_id) REFERENCES productos(id),
    FOREIGN KEY (empleado_id) REFERENCES empleados(id)
);

INSERT INTO categorias (nombre) VALUES
('Electrónica'),
('Ropa'),
('Alimentos'),
('Hogar'),
('Libros');

INSERT INTO empleados (nombre, apellido, dni, telefono, cargo, fecha_contratacion) VALUES
('Ana', 'García', '12345678A', '987654321', 'Gerente', '2020-01-15'),
('Juan', 'Martínez', '87654321B', '912345678', 'Vendedor', '2021-05-20'),
('Luisa', 'Pérez', '11223344C', '955112233', 'Cajero', '2022-11-01'),
('Carlos', 'Sánchez', '44332211D', '977889900', 'Almacenista', '2023-03-10');

INSERT INTO productos (sku, nombre, marca, precio, cantidad, categoria_id) VALUES
('ELC-TV4K-001', 'Smart TV 55 Pulgadas', 'TechMax', 599.99, 15, 1), -- Electrónica
('ROP-CAM-012', 'Camiseta Algodón M', 'FashionNow', 25.50, 150, 2), -- Ropa
('ALI-CAFE-KG', 'Café Tostado Grano 1kg', 'AromaFino', 12.90, 80, 3), -- Alimentos
('HOG-LAM-LED', 'Lámpara Escritorio LED', 'HomeStyle', 35.00, 45, 4), -- Hogar
('LIB-FIC-005', 'Novela de Ciencia Ficción', 'EditorialDelta', 18.75, 60, 5), -- Libros
('ELC-AUR-020', 'Auriculares Inalámbricos', 'SoundWave', 79.99, 120, 1),
('ROP-PAN-003', 'Pantalón Vaquero L', 'DenimPro', 49.95, 75, 2);

INSERT INTO ventas (producto_id, empleado_id, cantidad, precio_unitario, fecha_venta) VALUES
(1, 2, 1, 599.99, '2025-10-25 10:30:00'), -- Venta de Smart TV por Juan
(2, 3, 3, 25.50, '2025-10-25 11:15:00'), -- Venta de 3 Camisetas por Luisa
(3, 2, 5, 12.90, '2025-10-26 14:45:00'), -- Venta de Café por Juan
(6, 3, 2, 79.99, '2025-10-27 16:00:00'), -- Venta de 2 Auriculares por Luisa
(4, 3, 1, 35.00, DEFAULT); -- Venta de Lámpara por Luisa (fecha actual)

ALTER TABLE productos ADD COLUMN activo TINYINT(1) DEFAULT 1;
